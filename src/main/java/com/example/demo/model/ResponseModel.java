package com.example.demo.model;

public  class ResponseModel {
    private   int status;
    private   String message;
    private   Object result;
    private   String errorMessage;
    public  ResponseModel(int status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public  ResponseModel(int status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
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


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}