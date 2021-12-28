package com.ktds.covidsystem.dto;

// author: KJH
public record FavoriteResponseDto(
        FavoriteDto favoriteDto,
        Long place_id,
        String userName,
        String placeName,
        String address,
        String phoneNumber,
        Integer currentNumberOfPeople,
        Integer capacity
) {
    public FavoriteResponseDto(FavoriteDto favoriteDto, Long place_id, String userName, String placeName, String address, String phoneNumber, Integer currentNumberOfPeople, Integer capacity) {
        this.favoriteDto = favoriteDto;
        this.place_id = place_id;
        this.userName = userName;
        this.placeName = placeName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.currentNumberOfPeople = currentNumberOfPeople;
        this.capacity = capacity;
    }

    public FavoriteResponseDto(String userName, String placeName, String address, String phoneNumber, Integer currentNumberOfPeople, Integer capacity) {
        this(null, null, userName, placeName, address, phoneNumber, currentNumberOfPeople, capacity);
    }
}
