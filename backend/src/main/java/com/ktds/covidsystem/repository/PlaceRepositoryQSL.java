package com.ktds.covidsystem.repository;

import com.ktds.covidsystem.constant.PlaceType;
import com.ktds.covidsystem.dto.PlaceDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

// Author : KJH
public interface PlaceRepositoryQSL {
    Page<PlaceDto> findPlaceByPlaceType(
            PlaceType placeType,
            Pageable pageable
    );

    Page<PlaceDto> findPlaceByPlaceName(
            String placeName,
            Pageable pageable
    );

    Page<PlaceDto> findPlace(
            PlaceType placeType,
            String placeName,
            String address,
            String phoneNumber,
            Integer currentNumberOfPeople,
            Integer capacity,
            Pageable pageable);

}
