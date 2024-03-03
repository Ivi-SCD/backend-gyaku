package br.com.ic.gyaku.error;

import br.com.ic.gyaku.error.exceptions.NullObjectException;
import br.com.ic.gyaku.error.response.ErrorResponseDTO;
import br.com.ic.gyaku.error.response.SimpleErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ExHandler {

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

    @ExceptionHandler(NullObjectException.class)
    public ResponseEntity<Object> handleNullObjectException() {
        return buildSimpleError(HttpStatus.BAD_REQUEST, "Campo não pode ser nulo.");
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
