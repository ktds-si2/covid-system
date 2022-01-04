package com.ktds.covidsystem.dto;

import com.ktds.covidsystem.constant.PlaceType;
import com.ktds.covidsystem.domain.Member;
import com.ktds.covidsystem.domain.Place;

import java.time.LocalDateTime;

public record PlaceDto(
        Long id,
//        User user,
        PlaceType placeType,
        String placeName,
        String address,
        String phoneNumber,
        Integer currentNumberOfPeople,
        Integer capacity,
        String memo,
        String limitTime,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt
) {

    public PlaceDto(Long id, PlaceType placeType, String placeName, String address, String phoneNumber, Integer currentNumberOfPeople, Integer capacity, String memo, String limitTime) {
        this(id, placeType, placeName, address, phoneNumber, currentNumberOfPeople, capacity, memo, limitTime,null, null);
    }

    public PlaceDto(PlaceType placeType, String placeName, String address, String phoneNumber, Integer currentNumberOfPeople, Integer capacity, String memo, String limitTime) {
        this(null,  placeType, placeName, address, phoneNumber, currentNumberOfPeople, capacity, memo, limitTime, null, null);
    }

    public static PlaceDto idOnly(Long id) {
        return PlaceDto.of(id, null,null,null, null, null, null,null, null, null,null, null);
    }

    public static PlaceDto of(
            Long id,
            Member user,
            PlaceType placeType,
            String placeName,
            String address,
            String phoneNumber,
            Integer currentNumberOfPeople,
            Integer capacity,
            String memo,
            String limitTime,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt
    ) {

        return new PlaceDto(id, placeType, placeName, address, phoneNumber, currentNumberOfPeople, capacity, memo, limitTime,createdAt, modifiedAt);
    }

    public static PlaceDto from(Place place) {
        return new PlaceDto(
                place.getId(),
                place.getPlaceType(),
                place.getPlaceName(),
                place.getAddress(),
                place.getPhoneNumber(),
                place.getCurrentNumberOfPeople(),
                place.getCapacity(),
                place.getMemo(),
                place.getLimitTime(),
                place.getCreatedAt(),
                place.getModifiedAt()
        );
    }

    public Place toEntity() {
        return Place.of(placeType, placeName, address, phoneNumber, currentNumberOfPeople, capacity, memo, limitTime);
    }

    public Place updateEntity(Place place) {
        if (placeType != null) { place.setPlaceType(placeType); }
        if (placeName != null) { place.setPlaceName(placeName); }
        if (address != null) { place.setAddress(address); }
        if (phoneNumber != null) { place.setPhoneNumber(phoneNumber); }
        if (capacity != null) { place.setCapacity(capacity); }
        if (memo != null) { place.setMemo(memo); }

        return place;
    }

}
