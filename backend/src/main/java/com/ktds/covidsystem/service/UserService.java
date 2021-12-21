package com.ktds.covidsystem.service;

import com.ktds.covidsystem.domain.CustomUserDetails;
import com.ktds.covidsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 유저 서비스  Author : JHW
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


}
