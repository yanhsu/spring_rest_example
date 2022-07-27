package com.example.demo.model;

public class ResponseErrorModel {
    private   int status;

    private   String errorMessage;

    public ResponseErrorModel(int status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public int getStatus() {
        return status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
