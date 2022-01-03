package com.ktds.covidsystem.dto;

import com.ktds.covidsystem.constant.Authority;

public record TokenDto(String token, Authority authority, String memberName) {
}
