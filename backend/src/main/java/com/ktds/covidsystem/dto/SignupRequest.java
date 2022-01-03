package com.ktds.covidsystem.dto;

public record SignupRequest(
        String name,
        String email,
        String password
) {
    public static SignupRequest of(String name, String email, String password) {
        return new SignupRequest(name, email, password);
    }

}
