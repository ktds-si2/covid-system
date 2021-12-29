package com.ktds.covidsystem.dto;

import com.ktds.covidsystem.constant.PlaceType;

public record PlaceResponseDto(
        String placeType,
        String placeName,
        String address,
        String phoneNumber,
        Integer currentNumberOfPeople,
        Integer capacity,
        int pageNum,
        int pageSize
) {
    public PlaceResponseDto(String placeType, String placeName, String address, String phoneNumber, Integer currentNumberOfPeople, Integer capacity, int pageNum, int pageSize) {
        this.placeType = placeType;
        this.placeName = placeName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.currentNumberOfPeople = currentNumberOfPeople;
        this.capacity = capacity;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
