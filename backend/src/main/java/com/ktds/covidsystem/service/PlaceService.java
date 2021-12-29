package com.ktds.covidsystem.service;

import com.ktds.covidsystem.constant.PlaceType;
import com.ktds.covidsystem.domain.Favorite;
import com.ktds.covidsystem.domain.Member;
import com.ktds.covidsystem.domain.Place;
import com.ktds.covidsystem.dto.FavoriteDto;
import com.ktds.covidsystem.dto.FavoriteResponseDto;
import com.ktds.covidsystem.dto.PlaceDto;
import com.ktds.covidsystem.dto.PlaceResponseDto;
import com.ktds.covidsystem.repository.FavoriteRepository;
import com.ktds.covidsystem.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Author : KJH
@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final FavoriteRepository favoriteRepository;

    // 모든 장소 검색
    public List<PlaceDto> findAllPlace() {
        log.info("findAllPlace() start");
        return placeRepository.findAll().stream().map(PlaceDto::from).toList();
    }

    // 조건으로 장소 검색
    public Page<PlaceDto> findPlace(PlaceResponseDto placeResponseDto) {
        log.info("findPlace() start");
        PlaceType placeType = null;
        if (placeResponseDto.placeType() != null) {
            placeType = PlaceType.valueOf(placeResponseDto.placeType());
        }

        Integer currentNumberOfPeople = placeResponseDto.currentNumberOfPeople();
        if (currentNumberOfPeople == null)
            currentNumberOfPeople = -1;

        Integer capacity = placeResponseDto.capacity();
        if (capacity == null) {
            capacity = -1;
        }

        return placeRepository.findPlace(
                placeType,
                placeResponseDto.placeName(),
                placeResponseDto.address(),
                placeResponseDto.phoneNumber(),
                currentNumberOfPeople,
                capacity, PageRequest.of(placeResponseDto.pageNum(), placeResponseDto.pageSize()));
    }

    // 새로운 장소 등록
    public boolean createNewPlace(PlaceDto placeDto) {
        log.info("registerNewPlace() start");

        if (placeDto == null)
            return false;

        placeRepository.save(placeDto.toEntity());

        return true;
    }

    // 장소 상세페이지 조회
    public PlaceDto findDetailPlacePage(Long id) throws Exception {
        log.info("findDetailPlacePage() start");

        return placeRepository.findById(id).map(PlaceDto::from).orElseThrow(

                () -> new Exception("exception in findDetailPlacePage()"));
    }

    // 장소 상세페이지 수정
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

    // 장소 상세페이지 삭제
    public boolean deleteDetailPlacePage(Long id) throws Exception {

        log.info("deleteDetailPlacePage() start");
        placeRepository.deleteById(id);
//        placeRepository.find
        return true;
    }

    // 즐겨찾기 조회
    public List<FavoriteResponseDto> findFavorite(String userName) {
        log.info("findFavorite() start");
        return favoriteRepository.findFavorite(PageRequest.of(0, 5), userName).getContent();
    }

    // 즐겨찾기 등록
    public void createFavorite(String userName, Long placeId) {

        log.info("createFavorite() start");
//        favoriteRepository.save(favoriteDto.toEntity(placeRepository.findById(placeId).get()));
        favoriteRepository.save(Favorite.of(placeRepository.findById(placeId).get(), userName));
    }

    // 즐겨찾기 삭제
    public boolean deleteFavorite(Long id) {
        log.info("deleteFavorite() start");
        favoriteRepository.deleteById(id);
        return true;
    }

    // 즐겨찾기 수정
    public boolean modifyFavorite() {
        log.info("modifyFavorite() start");

        return true;
    }
}
