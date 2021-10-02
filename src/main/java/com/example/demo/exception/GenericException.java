package com.example.demo.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by İbrahim Başar YARGICI at 2.10.2021
 */
public abstract class GenericException extends RuntimeException {
    public GenericException(String message) {
        super(message);
    }

    public GenericException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract HttpStatus getHttpStatus();
}