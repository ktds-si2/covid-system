package com.ktds.covidsystem.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// 예외처리  Author : JHW
@RestControllerAdvice
public class RestExceptionHandler {

    // Error 처리
    @ExceptionHandler
    public ResponseEntity handleError(Error e) {
        Map<String, String> map = new HashMap<>();

        map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        map.put("message",e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }


    // Exception 처리
    @ExceptionHandler
    public ResponseEntity handleException(Exception e) {
        Map<String, String> map = new HashMap<>();

        map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        map.put("message",e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
    }

}
