package com.example.demo.advice;

import com.example.demo.model.ResponseErrorModel;
import com.example.demo.model.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Object handleExceptionResponse(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        Object result = new ResponseErrorModel(HttpStatus.BAD_REQUEST.value(),errors.toString());
        return  result;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Object handleRuntimeExceptionResponse(Exception ex) {
        System.out.println(ex.getMessage());
        Object result = new ResponseErrorModel(HttpStatus.INTERNAL_SERVER_ERROR.value(),"服務發生問題");
        return  result;
    }
}
