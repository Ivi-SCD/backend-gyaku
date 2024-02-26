package br.com.ic.gyaku.error;

import br.com.ic.gyaku.error.response.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(
                status.value(),
                LocalDateTime.now(),
                ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage(),
                ex.getBindingResult().getFieldErrors().get(0).getField()
        );

        return ResponseEntity.status(status).body(errorResponse);
    }
}
