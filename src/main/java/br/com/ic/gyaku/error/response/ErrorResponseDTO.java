package br.com.ic.gyaku.error.response;

import java.time.LocalDateTime;

public record ErrorResponseDTO(int status, LocalDateTime timestamp, String message, String field) {
}
