package com.ktds.covidsystem.exception;

import com.ktds.covidsystem.constant.ErrorCode;

// Custom Error     Author : JHW
public class EmailDuplicateException extends RuntimeException {

    private ErrorCode errorCode;

    public EmailDuplicateException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

}
