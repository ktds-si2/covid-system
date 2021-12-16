package com.ktds.covidsystem.dto;

import com.ktds.covidsystem.constant.PlaceType;

public record PlaceRequest(
        Long id,
        PlaceType placeType,
        String placeName,
        String address,
        String phoneNumber,
        Integer currentNumberOfPeople,
        Integer capacity,
        String memo
) {

    public static PlaceRequest of(
            Long id,
            PlaceType placeType,
            String placeName,
            String address,
            String phoneNumber,
            Integer currentNumberOfPeople,
            Integer capacity,
            String memo
    ) {
        return new PlaceRequest(id, placeType, placeName, address, phoneNumber, currentNumberOfPeople, capacity, memo);
    }

    public PlaceDto toDto() {
        return PlaceDto.of(
                this.id(),
                this.placeType(),
                this.placeName(),
                this.address(),
                this.phoneNumber(),
                this.currentNumberOfPeople(),
                this.capacity(),
                this.memo(),
                null,
                null
        );
    }

}
