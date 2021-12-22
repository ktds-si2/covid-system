package com.ktds.covidsystem.controller;

import com.ktds.covidsystem.dto.SignupRequest;
import com.ktds.covidsystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

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

        if(userService.signUp(signupRequest))
            return ResponseEntity.status(HttpStatus.OK).body("회원가입 완료");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("유저 이미 존재");
    }

    @GetMapping("/user")
    public ResponseEntity user() {
        return ResponseEntity.status(HttpStatus.OK).body("유저");
    }

}
