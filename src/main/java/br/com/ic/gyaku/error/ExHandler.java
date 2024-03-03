package br.com.ic.gyaku.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import Exceptuib

import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage(), ex.getBindingResult().getFieldErrors().get(0).getField());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(EntityNotFoundException ex) {
        return buildSimpleError(HttpStatus.NOT_FOUND, "Entidade não encontrada.");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleMessageNotReadableException() {
        return buildSimpleError(HttpStatus.BAD_REQUEST, "O corpo da requisição não pode ser vazio.");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Object> handleRequestMethodNotSupportedException() {
        return buildSimpleError(HttpStatus.NOT_IMPLEMENTED, "Função não implementada.");
    }

    private ResponseEntity<Object> buildErrorResponse(HttpStatus status, String message, String field) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(status.value(), LocalDateTime.now(), message, field);
        return ResponseEntity.status(status).body(errorResponse);
    }

    private ResponseEntity<Object> buildSimpleError(HttpStatus status, String message) {
        SimpleErrorDTO simpleErrorDTO = new SimpleErrorDTO(status.value(), message, LocalDateTime.now());
        return ResponseEntity.status(status).body(simpleErrorDTO);
    }
}
