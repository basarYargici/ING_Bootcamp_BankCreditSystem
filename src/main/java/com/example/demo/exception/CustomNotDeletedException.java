package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by İbrahim Başar Yargıcı and Emirhan Doğandemir at 2.10.2021
 */
@ResponseStatus(HttpStatus.NO_CONTENT)
public class CustomNotDeletedException extends GenericException {
    public CustomNotDeletedException(String message) {
        super(message);
    }

    public CustomNotDeletedException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NO_CONTENT;
    }
}
