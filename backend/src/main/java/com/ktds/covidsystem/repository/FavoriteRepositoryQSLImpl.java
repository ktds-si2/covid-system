package com.ktds.covidsystem.repository;

import com.ktds.covidsystem.constant.PlaceType;
import com.ktds.covidsystem.domain.Favorite;
import com.ktds.covidsystem.domain.Place;
import com.ktds.covidsystem.domain.QFavorite;
import com.ktds.covidsystem.domain.QPlace;
import com.ktds.covidsystem.dto.FavoriteDto;
import com.ktds.covidsystem.dto.FavoriteResponseDto;
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
public class FavoriteRepositoryQSLImpl extends QuerydslRepositorySupport implements FavoriteRepositoryQSL {

    public FavoriteRepositoryQSLImpl() {
        super(Place.class);
    }

    @Override
    public Page<FavoriteResponseDto> findFavorite(Pageable pageable) {
        QFavorite favorite = QFavorite.favorite;
        JPQLQuery<FavoriteResponseDto> query = from(favorite)
                .select(Projections.constructor(FavoriteResponseDto.class,
                        favorite.userName,
                        favorite.place.placeName,
                        favorite.place.address,
                        favorite.place.phoneNumber,
                        favorite.place.currentNumberOfPeople,
                        favorite.place.capacity));;

        List<FavoriteResponseDto> favoriteList = getQuerydsl()
                .applyPagination(pageable, query)
                .fetch();

        return new PageImpl<>(favoriteList, pageable, query.fetchCount());
    }
}
