package com.ktds.covidsystem.dto;

import com.ktds.covidsystem.domain.Member;

public record MemberResponseDto(String name, String email) {
    public static MemberResponseDto of(Member member) {
        return new MemberResponseDto(member.getName(), member.getEmail());
    }
}
