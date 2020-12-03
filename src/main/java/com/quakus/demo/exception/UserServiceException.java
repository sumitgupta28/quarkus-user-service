package com.quakus.demo.exception;

public class UserServiceException extends RuntimeException {

    private int httpStatusCode;
    private String errorMessage;

    public UserServiceException(int httpStatusCode,String errorMessage) {
        super(errorMessage);
        this.errorMessage=errorMessage;
        this.httpStatusCode=httpStatusCode;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

