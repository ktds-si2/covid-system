package com.ktds.covidsystem.controller;

import com.ktds.covidsystem.domain.Member;
import com.ktds.covidsystem.dto.MemberResponseDto;
import com.ktds.covidsystem.dto.SignupRequest;
import com.ktds.covidsystem.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

// Author : JHW
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<Member> signup(@RequestBody SignupRequest signupRequest) {
        return ResponseEntity.ok(memberService.singUp(signupRequest));
    }

    @GetMapping("/member")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<MemberResponseDto> getMyUserInfo() {
        return ResponseEntity.ok(memberService.getMemberInfo());
    }

    @GetMapping("/member/{email}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<MemberResponseDto> getUserInfo(@PathVariable String email) {
        return ResponseEntity.ok(memberService.getMemberInfo(email));
    }

}
