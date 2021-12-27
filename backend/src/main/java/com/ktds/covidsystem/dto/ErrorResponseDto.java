package com.ktds.covidsystem.dto;

import com.ktds.covidsystem.constant.ErrorCode;

// 에러 정보 클래스 Author : JHW
public record ErrorResponseDto(
        int status,
        String errorCode,
        String message
) {
    public static ErrorResponseDto of(ErrorCode errorCode) {
        return new ErrorResponseDto(errorCode.getStatus(), errorCode.getErrorCode(), errorCode.getMessage());
    }

}
