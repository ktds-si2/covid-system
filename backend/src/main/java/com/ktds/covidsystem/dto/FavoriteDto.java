package com.ktds.covidsystem.dto;

import com.ktds.covidsystem.domain.Favorite;
import com.ktds.covidsystem.domain.Place;

// author: KJH
public record FavoriteDto (
    Long id,
    PlaceDto placeDto,
    String userName
) {

    public FavoriteDto(Long id, PlaceDto placeDto, String userName) {
        this.id = id;
        this.placeDto = placeDto;
        this.userName = userName;
    }

    public static FavoriteDto of(Long id, PlaceDto placeDto, String placeName) {
        return new FavoriteDto(id, placeDto, placeName);
    }
    public static FavoriteDto from(Favorite favorite) {
        return new FavoriteDto(favorite.getId(), PlaceDto.from(favorite.getPlace()), favorite.getUserName());
    }

    public Favorite toEntity(Place place) {
        return Favorite.of(place, userName);
    }
}


