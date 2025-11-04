package br.com.fiap.memorizasaude.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<RestError> handleRuntimeException(RuntimeException ex) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        if (ex.getMessage().contains("já cadastrado")) {
            status = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(status).body(new RestError(ex.getMessage()));
    }
}