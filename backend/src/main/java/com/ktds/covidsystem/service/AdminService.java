package com.ktds.covidsystem.service;

import com.ktds.covidsystem.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// Author : KJH
@RequiredArgsConstructor
@Service
public class AdminService {
    private final AdminRepository adminRepository;
}
