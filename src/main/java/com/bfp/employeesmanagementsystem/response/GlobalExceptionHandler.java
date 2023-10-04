package com.bfp.employeesmanagementsystem.response;

import com.bfp.employeesmanagementsystem.response.exception.EmployeeNotFoundException;
import com.bfp.employeesmanagementsystem.response.exception.InternalServerException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static java.time.LocalTime.now;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HttpResponse employeeNotFound(EmployeeNotFoundException ex) {
        return HttpResponse.builder()
                .timestamp(now().toString())
                .statusCode(404)
                .status(HttpStatus.NOT_FOUND)
                .message(ex.getMessage())
                .build();
    }

    @ExceptionHandler(InternalServerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public HttpResponse internalServerError(InternalServerException ex) {
        return HttpResponse.builder()
                .timestamp(now().toString())
                .statusCode(500)
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(ex.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpResponse invalidEmployeeBody(MethodArgumentNotValidException ex) {
        return HttpResponse.builder()
                .timestamp(now().toString())
                .statusCode(400)
                .status(HttpStatus.BAD_REQUEST)
                .message(ex.getMessage())
                .build();
    }

}
