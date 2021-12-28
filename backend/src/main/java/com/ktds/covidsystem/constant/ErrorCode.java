package com.ktds.covidsystem.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

// Author : JHW
@Getter
@AllArgsConstructor
public enum ErrorCode {
    OK(200,"OK","Ok"),
    NOT_FOUND_ERROR(404, "COMMON_ERROR_404", "PAGE NOT FOUND"),
    INTERNAL_SERVER_ERROR(500,"COMMON_ERROR_500","INTERNAL_SERVER_ERROR"),
    EMAIL_DUPLICATED_ERROR(501,"COMMON_ERROR_501", "EMAIL_DUPLICATED_ERROR");

    private int status;
    private String errorCode;
    private String message;
}
