package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by Emirhan Doğandemir at 29.09.2021
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleValidationExample(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<>();
        exceptions.getBindingResult()
                .getFieldErrors()
                .forEach(fieldError -> validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage()));
        return ResponseEntity.badRequest().body(validationErrors);
    }

    @ExceptionHandler(UsernameExistException.class)
    public ResponseEntity<Map<String, String>> handleUsernameException(UsernameExistException exception) {
        return ResponseEntity.badRequest().body(Collections.singletonMap("username", exception.getMessage()));
    }
}
