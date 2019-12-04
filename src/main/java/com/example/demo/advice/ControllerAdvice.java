package com.example.demo.advice;

import com.example.demo.model.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Object handleExceptionResponse() throws Throwable {
        Object result = new ResponseModel(HttpStatus.BAD_REQUEST.value(),"發生錯誤");
        return  result;
    }
}
