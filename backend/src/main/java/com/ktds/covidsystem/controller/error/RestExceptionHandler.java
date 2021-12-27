package com.ktds.covidsystem.controller.error;

import com.ktds.covidsystem.constant.ErrorCode;
import com.ktds.covidsystem.dto.ErrorResponseDto;
import com.ktds.covidsystem.exception.EmailDuplicateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// 예외처리  Author : JHW
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    // Error 처리
    @ExceptionHandler
    public ResponseEntity handleError(Error e) {
        log.error("handleError : {} ", e);
        Map<String, String> map = new HashMap<>();

        map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        map.put("message", e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponseDto> handleEmailDuplicateException(EmailDuplicateException e) {
        log.error("handleEmailDuplicateException : {} ", e);

        ErrorResponseDto errorResponse = ErrorResponseDto.of(ErrorCode.EMAIL_DUPLICATED_ERROR);

        return new ResponseEntity<> (errorResponse, HttpStatus.BAD_REQUEST);
    }


    // Exception 처리
    @ExceptionHandler
    public ResponseEntity<ErrorResponseDto> handleException(Exception e) {
        log.error("handleException : {} ", e);

        ErrorResponseDto errorResponse = ErrorResponseDto.of(ErrorCode.INTERNAL_SERVER_ERROR);

        return new ResponseEntity <>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
