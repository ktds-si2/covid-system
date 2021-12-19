package com.ktds.covidsystem.service;

import com.ktds.covidsystem.constant.PlaceType;
import com.ktds.covidsystem.domain.Place;
import com.ktds.covidsystem.dto.PlaceDto;
import com.ktds.covidsystem.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// Author : KJH
@RequiredArgsConstructor
@Transactional
@Service
public class AdminService {
    private final AdminRepository adminRepository;

    // 전체 장소 조회
    public List<PlaceDto> findAllPlace() {
        return adminRepository.findAll().stream().map(PlaceDto::from).toList();
    }

    // PlaceType으로 전체 장소 조회
    public Page<PlaceDto> findPlaceByPlaceType(PlaceType placeType, Pageable pageable) {
        return adminRepository.findPlaceByPlaceType(placeType, pageable);
    }
    
    // 장소등록
    public void registerNewPlace(PlaceDto placeDto) {
        adminRepository.save(placeDto.toEntity());
    }

    public Optional<PlaceDto> findDetailPlacePage(Long id) {
        return adminRepository.findById(id).map(PlaceDto::from);
    }
}
