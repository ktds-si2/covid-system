package com.ktds.covidsystem.service;

import com.ktds.covidsystem.domain.CustomUserDetails;
import com.ktds.covidsystem.dto.SignupRequest;
import com.ktds.covidsystem.repository.UserRepository;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 유저 서비스  Author : JHW
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /*
     * 회원가입
     */
//    public boolean signUp(SignupRequest signupRequest) {
//        if (customUserDetailsService.loadUserByUsername(signupRequest.email()) != null) {
//            return false;
//        }
//        userRepository.save(new CustomUserDetails(signupRequest.email(), signupRequest.password(), "ROLE_USER"));
//        return true;
//    }


}
