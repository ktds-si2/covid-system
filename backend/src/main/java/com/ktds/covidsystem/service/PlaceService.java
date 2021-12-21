package com.ktds.covidsystem.service;

import com.ktds.covidsystem.constant.PlaceType;
import com.ktds.covidsystem.domain.Place;
import com.ktds.covidsystem.dto.PlaceDto;
import com.ktds.covidsystem.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Author : KJH
@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class PlaceService {
    private final PlaceRepository placeRepository;

    public List<PlaceDto> findAllPlace() {
        log.info("findAllPlace() start");
        return placeRepository.findAll().stream().map(PlaceDto::from).toList();
    }

    public Page<PlaceDto> findPlace(String placeType, String placeName, String address, String phoneNumber,
                                    Integer currentNumberOfPeople, Integer capacity,  int pageNum, int pageSize) {
        log.info("findPlace() start");
        return placeRepository.findPlace(PlaceType.valueOf(placeType), placeName, address, phoneNumber, currentNumberOfPeople, capacity, PageRequest.of(pageNum, pageSize));
    }

    public boolean registerNewPlace(PlaceDto placeDto) {
        log.info("registerNewPlace() start");

        if (placeDto == null)
            return false;

        placeRepository.save(placeDto.toEntity());

        return true;
    }

    public PlaceDto findDetailPlacePage(Long id) throws Exception {
        log.info("findDetailPlacePage() start");
        return placeRepository.findById(id).map(PlaceDto::from).orElseThrow(
                () -> new Exception("exception in findDetailPlacePage()"));
    }

    public boolean modifyDetailPlacePage(Long id, PlaceDto placeDto) throws Exception {
        log.info("modifyDetailPlacePage() start");

        Place place = placeRepository.findById(id).orElseThrow(
                () -> new Exception("exception in modifyDetailPlacePage()"));

        place.setPlaceType(placeDto.placeType());
        place.setPlaceName(placeDto.placeName());
        place.setAddress(placeDto.address());
        place.setPhoneNumber(placeDto.phoneNumber());
        place.setCurrentNumberOfPeople(placeDto.currentNumberOfPeople());
        place.setCapacity(placeDto.capacity());
        place.setMemo(placeDto.memo());

        return true;
    }

    public boolean deleteDetailPlacePage(Long id) throws Exception {
        log.info("deleteDetailPlacePage() start");
        placeRepository.deleteById(id);
        return true;
    }
}
