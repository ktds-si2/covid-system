package com.ktds.covidsystem.repository;

import com.ktds.covidsystem.constant.PlaceType;
import com.ktds.covidsystem.domain.Place;
import com.ktds.covidsystem.domain.QPlace;
import com.ktds.covidsystem.dto.PlaceDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import java.util.List;

// Author : KJH

@Slf4j
public class PlaceRepositoryQSLImpl extends QuerydslRepositorySupport implements PlaceRepositoryQSL {

    public PlaceRepositoryQSLImpl() {
        super(Place.class);
    }

    @Override
    public Page<PlaceDto> findPlaceByPlaceType(PlaceType placetype, Pageable pageable) {
        QPlace place = QPlace.place;
        JPQLQuery<PlaceDto> query = select();


        if (placetype != null) {
            query.where(place.placeType.eq(placetype));
        }

        List<PlaceDto> places = getQuerydsl()
                .applyPagination(pageable, query)
                .fetch();
        // 위와 같은 코드 , null 방어 코드 추가 버전
//        List<PlaceDto> places = Optional.ofNullable(getQuerydsl())
//                .orElseThrow(() -> new RuntimeException(("Spring JPA로 부터 에러발생")))
//                .applyPagination(pageable, query)
//                .fetch();

        return new PageImpl<>(places, pageable, query.fetchCount());
    }

    @Override
    public Page<PlaceDto> findPlaceByPlaceName(String placeName, Pageable pageable) {
        QPlace place = QPlace.place;
        JPQLQuery<PlaceDto> query = select();

        if (!placeName.isBlank()) {
            query.where(place.placeName.contains(placeName));
        }
        else {
            log.info("placeName is can not be empty");
            return null;
        }

        List<PlaceDto> places = getQuerydsl()
                .applyPagination(pageable, query)
                .fetch();

        return new PageImpl<>(places, pageable, query.fetchCount());
    }

    @Override
    public Page<PlaceDto> findPlace(PlaceType placeType, String placeName, String address, String phoneNumber, Integer currentNumberOfPeople, Integer capacity, Pageable pageable) {
        QPlace place = QPlace.place;
        JPQLQuery<PlaceDto> query = select();

        if (placeType != null) {
            query.where(place.placeType.eq(placeType));
        }
        if (placeName != null) {
            query.where(place.placeName.contains(placeName));
        }
        if (address != null) {
            query.where(place.address.contains(address));
        }
        if (phoneNumber != null) {
            query.where(place.phoneNumber.contains(phoneNumber));
        }
        if (currentNumberOfPeople != -1) {
            query.where(place.currentNumberOfPeople.goe(currentNumberOfPeople));
        }
        if (capacity != -1) {
            query.where(place.capacity.goe(capacity));
        }

        List<PlaceDto> places = getQuerydsl()
                .applyPagination(pageable, query)
                .fetch();

        return new PageImpl<>(places, pageable, query.fetchCount());
    }

    public JPQLQuery<PlaceDto> select() {
        QPlace place = QPlace.place;
        return from(place)
                .select(Projections.constructor(PlaceDto.class,
                        place.id,
                        place.placeType,
                        place.placeName,
                        place.address,
                        place.phoneNumber,
                        place.currentNumberOfPeople,
                        place.capacity,
                        place.memo));
    }
}
