package com.example.university.exception;

public class ResourceNotFindException extends RuntimeException{
    public ResourceNotFindException(String message){
        super(message);
    }
}
