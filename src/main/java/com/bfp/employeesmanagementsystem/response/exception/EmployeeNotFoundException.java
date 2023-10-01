package com.bfp.employeesmanagementsystem.response.exception;

public class EmployeeNotFoundException  extends RuntimeException{

    public EmployeeNotFoundException(String message){
        super(message);
    }

}
