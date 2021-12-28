package com.ktds.covidsystem.controller;

import com.ktds.covidsystem.constant.PlaceType;
import com.ktds.covidsystem.domain.Favorite;
import com.ktds.covidsystem.domain.Place;
import com.ktds.covidsystem.dto.FavoriteDto;
import com.ktds.covidsystem.dto.FavoriteResponseDto;
import com.ktds.covidsystem.dto.PlaceDto;
import com.ktds.covidsystem.repository.PlaceRepository;
import com.ktds.covidsystem.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Author : KJH
@RestController
@RequiredArgsConstructor
@RequestMapping("/place")
public class PlaceController {

    private final PlaceService placeService;

    /**
     * 모든 장소 조회
     * @return Select * from Place
     */
    @GetMapping()
    public List<PlaceDto> placeList() {
        return placeService.findAllPlace();
    }

    /**
     * 각 검색 조건으로 장소 조회
     * @param placeType: equal
     * @param placeName: like
     * @param address: like
     * @param phoneNumber: like
     * @param currentNumberOfPeople: greater than or equal
     * @param capacity: greater than or equal
     * @param pageNum: number of page
     * @param pageSize: paging size
     * @return: Select * from place where ?
     */
    @PostMapping("/find")
    public List<PlaceDto> findPlace(@RequestParam(required = false) String placeType,
                                    @RequestParam(required = false) String placeName,
                                    @RequestParam(required = false) String address,
                                    @RequestParam(required = false) String phoneNumber,
                                    @RequestParam(required = false, defaultValue = "-1") Integer currentNumberOfPeople,
                                    @RequestParam(required = false, defaultValue = "-1") Integer capacity,
                                    int pageNum, int pageSize){
        return placeService.findPlace(placeType, placeName, address, phoneNumber, currentNumberOfPeople, capacity, pageNum, pageSize).getContent();
    }

    /**
     * 모든 즐겨찾기 조회
     * favorite 테이블에는 id, user_name, place_id가 존재
     * place_id를 기준으로 Place 테이블을 조회하여 관련 정보를 함께 select 한다
     * @return userName, placeName, address, phoneNumber, currentNumberOfPeople, capacity
     */
    @GetMapping("/favorite")
    public List<FavoriteResponseDto> findFavorite()
    {
        return placeService.findFavorite();
    }

    /**
     * 즐겨찾기 등록
     * @param favoriteResponseDto: username과 placeid를 가진 객체
     *      아래와 같은 형태로 post 요청
     *     "favoriteDto": {
     *         "userName": "Lavine"
     *     },
     *     "place_id": 3
     *
     * @return Insert into Favorite values(favoriteDto, place_id)
     */
    @PostMapping("/favorite")
    public boolean createFavorite(@RequestBody FavoriteResponseDto favoriteResponseDto) {
        placeService.createFavorite(favoriteResponseDto.favoriteDto(), favoriteResponseDto.place_id());
        return false;
    }

    /**
     * 즐겨 찾기 삭제
     * @param favorite_id
     * @return Delete from Favorite where favorite_id
     */
    @DeleteMapping("/favorite")
    public boolean deleteFavorite(@RequestParam Long favorite_id) {
        placeService.deleteFavorite(favorite_id);
        return true;
    }
}
