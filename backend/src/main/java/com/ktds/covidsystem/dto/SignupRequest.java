package com.ktds.covidsystem.dto;

public record SignupRequest(
        String email,
        String nickname,
        String password,
        String phoneNumber
) {
    public static SignupRequest of(String email, String nickname, String password, String phoneNumber) {
        return new SignupRequest(email, nickname, password, phoneNumber);
    }

}
