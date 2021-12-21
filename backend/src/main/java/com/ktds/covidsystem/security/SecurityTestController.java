package com.ktds.covidsystem.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class SecurityTestController {

    @GetMapping("/permit-all")
    public String permitAll() {
        return "permit-all";
    }

    @GetMapping("/auth")
    public String auth() {
        return "auth";
    }
}
