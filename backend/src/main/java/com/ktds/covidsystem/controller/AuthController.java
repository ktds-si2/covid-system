package com.ktds.covidsystem.controller;

import com.ktds.covidsystem.constant.Authority;
import com.ktds.covidsystem.domain.Member;
import com.ktds.covidsystem.dto.LoginRequest;
import com.ktds.covidsystem.dto.MemberResponseDto;
import com.ktds.covidsystem.dto.TokenDto;
import com.ktds.covidsystem.repository.MemberRepository;
import com.ktds.covidsystem.security.JwtFilter;
import com.ktds.covidsystem.security.TokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Author : JHW
@CrossOrigin("*")
@RestController
@Slf4j
public class AuthController {
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final MemberRepository memberRepository;

    public AuthController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, MemberRepository memberRepository) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.memberRepository = memberRepository;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<TokenDto> authorize(@RequestBody LoginRequest loginRequest) {
        // 토큰객체 생성
        log.info("authenticate : {}", loginRequest);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        // 접속한 유저
        Member loginMember = memberRepository.findByEmail(loginRequest.email()).get();

        return new ResponseEntity<>(new TokenDto(jwt, loginMember.getAuthority(), loginMember.getName()), httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/users")
    public List<MemberResponseDto> findAllUser() {
        return memberRepository.findAll().stream().map(MemberResponseDto::ofWithAuthority).toList();
    }

    @DeleteMapping("/users")
    public void deleteUser(@RequestBody MemberResponseDto memberResponseDto) {
        memberRepository.deleteById(memberResponseDto.id());
    }
}
