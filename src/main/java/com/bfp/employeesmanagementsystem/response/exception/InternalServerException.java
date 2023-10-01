package com.bfp.employeesmanagementsystem.response.exception;

public class InternalServerException extends RuntimeException{
    public InternalServerException(String message){
        super(message);
    }
}
