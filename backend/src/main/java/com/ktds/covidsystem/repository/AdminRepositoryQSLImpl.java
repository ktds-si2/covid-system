package com.ktds.covidsystem.repository;

import com.ktds.covidsystem.domain.Place;
import com.ktds.covidsystem.domain.QPlace;
import com.ktds.covidsystem.dto.PlaceDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.time.LocalDateTime;

// Author : KJH
public class AdminRepositoryQSLImpl extends QuerydslRepositorySupport implements AdminRepositoryQSL {

    public AdminRepositoryQSLImpl() {
        super(Place.class);
    }

    @Override
    public Page<PlaceDto> findPlace(Long id, String placeName, LocalDateTime createdAt, LocalDateTime modifiedAt, Pageable pageable) {
        QPlace place = QPlace.place;
        JPQLQuery<PlaceDto> query = from(place)
                .select(Projections.constructor(PlaceDto.class, place.id, place.placeType,)

        return null;
    }
}
