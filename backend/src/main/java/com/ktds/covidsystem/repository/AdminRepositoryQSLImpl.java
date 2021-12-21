package com.ktds.covidsystem.repository;

import com.ktds.covidsystem.constant.PlaceType;
import com.ktds.covidsystem.domain.Place;
import com.ktds.covidsystem.domain.QPlace;
import com.ktds.covidsystem.dto.PlaceDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import java.util.List;

// Author : KJH
public class AdminRepositoryQSLImpl extends QuerydslRepositorySupport implements AdminRepositoryQSL {

    public AdminRepositoryQSLImpl() {
        super(Place.class);
    }

    @Override
    public Page<PlaceDto> findPlaceByPlaceType(PlaceType placetype, Pageable pageable) {
        QPlace place = QPlace.place;
        JPQLQuery<PlaceDto> query = from(place)
                .select(Projections.constructor(PlaceDto.class,
                        place.id,
                        place.placeType,
                        place.placeName,
                        place.address,
                        place.phoneNumber,
                        place.currentNumberOfPeople,
                        place.capacity,
                        place.memo));

        // 검색 조건 추가
        // placetype으로 검색
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
}
