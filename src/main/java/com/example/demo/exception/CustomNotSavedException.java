package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by İbrahim Başar Yargıcı and Emirhan Doğandemir at 2.10.2021
 */
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class CustomNotSavedException extends GenericException {
    public CustomNotSavedException(String message) {
        super(message);
    }

    public CustomNotSavedException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.UNPROCESSABLE_ENTITY;
    }
}
