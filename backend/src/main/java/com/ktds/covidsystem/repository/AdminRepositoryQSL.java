package com.ktds.covidsystem.repository;

import com.ktds.covidsystem.constant.PlaceType;
import com.ktds.covidsystem.domain.Place;
import com.ktds.covidsystem.dto.PlaceDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

// Author : KJH
public interface AdminRepositoryQSL {
    Page<PlaceDto> findPlaceByPlaceType(
            PlaceType placeType,
            Pageable pageable
    );
}
