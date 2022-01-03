package com.ktds.covidsystem.dto;

import com.ktds.covidsystem.domain.Favorite;

// author: KJH
public record FavoriteResponseDto(
        Long id,
        Long place_id,
        String userName,
        String placeName,
        String address,
        String phoneNumber,
        Integer currentNumberOfPeople,
        Integer capacity
) {
    public FavoriteResponseDto(Long place_id, String userName, String placeName, String address, String phoneNumber, Integer currentNumberOfPeople, Integer capacity) {
        this(null, place_id, userName, placeName, address, phoneNumber, currentNumberOfPeople, capacity);
    }

    public FavoriteResponseDto(Long place_id) {
        this(null, place_id, null, null, null, null, null, null);
    }

    public static FavoriteResponseDto from(Favorite favorite) {
        return new FavoriteResponseDto(
                favorite.getId(),
                favorite.getPlace().getId(),
                favorite.getUserName(),
                favorite.getPlace().getPlaceName(),
                favorite.getPlace().getAddress(),
                favorite.getPlace().getPhoneNumber(),
                favorite.getPlace().getCurrentNumberOfPeople(),
                favorite.getPlace().getCapacity()
        );
    }
}
