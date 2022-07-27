package com.example.demo.model;

public  class ResponseModel {
    private   int status;
    private   String message;
    private   Object result;
    public  ResponseModel(int status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }


    public int getStatus() {
        return status;
    }


    public String getMessage() {
        return message;
    }


    public Object getResult() {
        return result;
    }

}