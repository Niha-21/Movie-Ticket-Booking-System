package com.movie.service.exception;

public class CustomException extends RuntimeException {

    private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public CustomException(ErrorCode errorCode, String additionalErrorMsg) {
        super(errorCode.getMessage() + " : " + additionalErrorMsg);
        this.errorCode = errorCode;
    }
    
    public String getErrorCode() {
        return this.errorCode.getCode();
    }

    public String getErrorMessage() {
        return this.errorCode.getMessage();
    }
}
