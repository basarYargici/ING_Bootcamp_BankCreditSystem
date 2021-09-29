package com.example.demo.exception;

public class UsernameExistException extends IllegalArgumentException{
    public UsernameExistException(){
        super("Username already in use .");
    }
}
