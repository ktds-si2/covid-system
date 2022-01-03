package com.ktds.covidsystem.service;

import com.ktds.covidsystem.constant.Authority;
import com.ktds.covidsystem.constant.ErrorCode;
import com.ktds.covidsystem.domain.Member;
import com.ktds.covidsystem.dto.MemberResponseDto;
import com.ktds.covidsystem.dto.SignupRequest;
import com.ktds.covidsystem.exception.EmailDuplicateException;
import com.ktds.covidsystem.repository.MemberRepository;
import com.ktds.covidsystem.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Author : JHW
@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원가입(이메일, 비밀번호, 권한, 활성화여부)
     */
    @Transactional
    public Member singUp(SignupRequest signupRequest) {
        if (memberRepository.findByEmail(signupRequest.email()).orElse(null) != null)
            throw new EmailDuplicateException(ErrorCode.EMAIL_DUPLICATED_ERROR);

        Member member = new Member(
                signupRequest.name(),
                signupRequest.email(),
                encodingPassword(signupRequest.password()),
                Authority.ROLE_USER,
                true);

        return memberRepository.save(member);
    }

    /**
     *  특정유저 정보 받아오기(이메일)
     */
    @Transactional(readOnly = true)
    public MemberResponseDto getMemberInfo(String email) {
        return memberRepository.findByEmail(email)
                .map(MemberResponseDto::of)
                .orElseThrow(() -> new RuntimeException("유저 정보가 없습니다."));
    }

    /**
     *  SecurityContext에 저장된 유저정보 받아오기
     */
    @Transactional(readOnly = true)
    public MemberResponseDto getMemberInfo() {
        return SecurityUtil.getCurrentUsername()
                .flatMap(memberRepository::findByEmail)
                .map(MemberResponseDto::of)
                .orElseThrow(() -> new RuntimeException("현재 SecurityContext에 저장된 유저가 없습니다."));
    }

    /**
     *  비밀번호 인코딩
     */
    public String encodingPassword(String password) {
        return passwordEncoder.encode(password);
    }


}
