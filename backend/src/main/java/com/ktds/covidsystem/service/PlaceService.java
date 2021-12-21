package com.ktds.covidsystem.service;

import com.ktds.covidsystem.constant.PlaceType;
import com.ktds.covidsystem.domain.Place;
import com.ktds.covidsystem.dto.PlaceDto;
import com.ktds.covidsystem.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
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

    // 전체 장소 조회
    public List<PlaceDto> findAllPlace() {
        log.info("findAllPlace() start");
        return placeRepository.findAll().stream().map(PlaceDto::from).toList();
    }

    // PlaceType으로 전체 장소 조회
    public Page<PlaceDto> findPlaceByPlaceType(PlaceType placeType, Pageable pageable) {
        log.info("findPlaceByPlaceType() start");
        return placeRepository.findPlaceByPlaceType(placeType, pageable);
    }
    
    // 장소등록
    public boolean registerNewPlace(PlaceDto placeDto) {
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
        if (id < 0)
            return false;

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
        if (id < 0)
            return false;

        log.info("deleteDetailPlacePage() start");

        placeRepository.deleteById(id);

        return true;
    }


}
