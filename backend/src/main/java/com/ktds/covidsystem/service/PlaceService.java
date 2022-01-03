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
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public boolean deletePlace(Long id) {
        log.info("deletePlace() start");
        placeRepository.deleteById(id);

        return true;
    }

    // 즐겨찾기 조회
    public List<FavoriteResponseDto> findFavorite(String userName) {
        log.info("findFavorite() start");
//        return favoriteRepository.findFavorite(PageRequest.of(0, 5), userName).getContent();
        return favoriteRepository.findByUserName(userName)
                .stream().map(FavoriteResponseDto::from)
                .toList();
    }

    // 즐겨찾기 등록
    public void createFavorite(String userName, Long placeId) {
        log.info("createFavorite() start");
        favoriteRepository.save(Favorite.of(placeRepository.findById(placeId).get(), userName));

        // 즐겨찾기 중복을 막는 로직

        // place id를 담는 list
        ArrayList<Long> id_List = new ArrayList<>();
        // favorite table의 id를 담는 list, 해당 table에 있는 id 값은 favorite table delete에 사용됨
        ArrayList<Long> id_dup_List = new ArrayList<>();

        // favorite table을 userName 으로 조회
        List<FavoriteResponseDto> placeList = this.findFavorite(userName);
        // placeList을 loop 돌며 id_List에 place_id를 담음
        // id_List에 place_id가 이미 있으면, id_dup_List에 해당 데이터의 favoirte의 id를 담음
        for(FavoriteResponseDto favoriteResponseDto: placeList) {
            Long tempPlaceId = favoriteResponseDto.place_id();
            if (!id_List.contains(tempPlaceId)) {
                id_List.add(tempPlaceId);
            }
            else {
                id_dup_List.add(favoriteResponseDto.id());
            }
        }

        for (Long id : id_dup_List) {
            this.deleteFavorite(id);
        }

    }

    // 즐겨찾기 삭제
    public void deleteFavorite(Long id) {
        log.info("deleteFavorite() start");
        favoriteRepository.deleteById(id);
    }

    // 즐겨찾기 수정
    public void modifyFavorite() {
        log.info("modifyFavorite() start");
    }
}
