package br.com.ic.gyaku.error.response;

import java.time.LocalDateTime;

public record SimpleErrorDTO (int status, String message, LocalDateTime timeStamp){
}
