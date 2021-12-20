package com.ktds.covidsystem.controller;

import com.ktds.covidsystem.dto.SignupRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// 유저 컨트롤러  Author : JHW
@RestController
@Slf4j
public class UserController {

    @PostMapping("/login")
    public ResponseEntity login() {
        log.info("POST /login");

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/logout")
    public ResponseEntity logout() {
        log.info("GET /logout");

        return ResponseEntity.status(HttpStatus.OK).body("로그아웃");
    }

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody SignupRequest signupRequest) {
        log.info("POST /signup : {}", signupRequest);

        return ResponseEntity.status(HttpStatus.OK).body("회원가입");
    }
}
