package com.ktds.covidsystem.repository;

import com.ktds.covidsystem.constant.PlaceType;
import com.ktds.covidsystem.dto.PlaceDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

// Author : KJH
public interface PlaceRepositoryQSL {
    Page<PlaceDto> findPlaceByPlaceType(
            PlaceType placeType,
            Pageable pageable
    );
}
