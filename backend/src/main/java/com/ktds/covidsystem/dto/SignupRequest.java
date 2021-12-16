package com.ktds.covidsystem.dto;

public record SignupRequest(
        String email,
        String nickname,
        String password,
        String phoneNumber,
        String memo
) {
    public static SignupRequest of(
            String email,
            String nickname,
            String password,
            String phoneNumber,
            String memo
    ) {
        return new SignupRequest(email, nickname, password, phoneNumber, memo);
    }
}
