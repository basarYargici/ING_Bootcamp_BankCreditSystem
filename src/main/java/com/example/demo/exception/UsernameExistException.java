package com.example.demo.exception;

/**
 * Created by Emirhan Doğandemir at 29.09.2021
 */

public class UsernameExistException extends IllegalArgumentException {
    public UsernameExistException() {
        super("Username already in use .");
    }
}
