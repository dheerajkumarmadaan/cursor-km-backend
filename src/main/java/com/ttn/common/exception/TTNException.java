package com.ttn.common.exception;

import com.ttn.common.enums.ErrorCode;
import org.springframework.http.HttpStatus;

public class TTNException extends RuntimeException {
    
    private final ErrorCode errorCode;
    private final HttpStatus httpStatus;
    private final String details;

    public TTNException(ErrorCode errorCode) {
        this(errorCode, null);
    }

    public TTNException(ErrorCode errorCode, String details) {
        this(errorCode, HttpStatus.INTERNAL_SERVER_ERROR, details);
    }

    public TTNException(ErrorCode errorCode, HttpStatus httpStatus, String details) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.details = details;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getDetails() {
        return details;
    }
} 