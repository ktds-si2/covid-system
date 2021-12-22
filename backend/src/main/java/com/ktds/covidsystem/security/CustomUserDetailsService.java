package com.ktds.covidsystem.security;

import com.ktds.covidsystem.domain.CustomUserDetails;
import com.ktds.covidsystem.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Author : JHW
@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // DB에서 param으로 받는 username에 해당하는 유저가 있는지 확인 후 Security 객체에 담아주어야함
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("유저 서비스 진입");
        CustomUserDetails user = userRepository.findByUsername(username);
        log.info("유저 : {}", user);
        return user;
    }
}
