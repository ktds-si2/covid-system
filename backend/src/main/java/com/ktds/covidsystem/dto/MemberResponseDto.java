package com.ktds.covidsystem.dto;

import com.ktds.covidsystem.constant.Authority;
import com.ktds.covidsystem.domain.Member;

public record MemberResponseDto(Long id, String name, String email, Authority authority) {

    public MemberResponseDto(String name, String email) {
        this(null, name, email, null);
    }

    public MemberResponseDto(Long id) {
        this(id, null, null, null);
    }

    public static MemberResponseDto of(Member member) {
        return new MemberResponseDto(member.getName(), member.getEmail());
    }

    public static MemberResponseDto ofWithAuthority(Member member) {
        return new MemberResponseDto(member.getId(), member.getName(), member.getEmail(), member.getAuthority());
    }

}
