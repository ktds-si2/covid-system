package com.ktds.covidsystem.dto;

public record SignupRequest(
        String email,
        String password
) {
    public static SignupRequest of(String email, String password) {
        return new SignupRequest(email, password);
    }

}
