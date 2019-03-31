package com.bangnd.util.exception;

public class AppException extends Exception {
    private String message;

    public AppException(String message) {
        this.message = message;
    }
}
