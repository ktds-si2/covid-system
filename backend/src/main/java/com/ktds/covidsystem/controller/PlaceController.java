package com.ktds.covidsystem.controller;

import com.ktds.covidsystem.constant.PlaceType;
import com.ktds.covidsystem.domain.Favorite;
import com.ktds.covidsystem.domain.Member;
import com.ktds.covidsystem.domain.Place;
import com.ktds.covidsystem.dto.FavoriteDto;
import com.ktds.covidsystem.dto.FavoriteResponseDto;
import com.ktds.covidsystem.dto.PlaceDto;
import com.ktds.covidsystem.dto.PlaceResponseDto;
import com.ktds.covidsystem.repository.PlaceRepository;
import com.ktds.covidsystem.service.PlaceService;
import com.ktds.covidsystem.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

// Author : KJH
@CrossOrigin("*")
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
     * 각 검색 조건으로 장소 조회 (pageNum, pageSize 필수)
     * placeType: equal
     * placeName: like
     * address: like
     * phoneNumber: like
     * currentNumberOfPeople: greater than or equal
     * capacity: greater than or equal
     * pageNum: number of page
     * pageSize: paging size
     * @return: Select * from place where ?
     */
    @PostMapping("/find")
    public List<PlaceDto> findPlace(@RequestBody PlaceResponseDto placeResponseDto){
        return placeService.findPlace(placeResponseDto).getContent();
    }

    /**
     * 모든 즐겨찾기 조회
     * favorite 테이블에는 id, user_name, place_id가 존재
     * place_id를 기준으로 Place 테이블을 조회하여 관련 정보를 함께 select 한다
     * where 조건으로 현재 로그인한 유저 이름을 넣는다
     * @return Select from Favorite where username = 현재유저 and Place.id = place_id
     */
    @GetMapping("/favorite")
    public List<FavoriteResponseDto> findFavorite()
    {
        return placeService.findFavorite(SecurityUtil.getCurrentUsername().get());
    }

    /**
     * 즐겨찾기 등록
     * 현재 로그인한 유저의 이름과 장소에 대한 정보를 table에 저장한다
     * @param favoriteResponseDto: placeid를 가진 객체
     *   아래와 같이 요청
     *      {
     *       "place_id": 3
     *      }
     * @return Insert into Favorite values(Place(findById), userName)
     */
    @PostMapping("/favorite")
    @ResponseBody
    public void createFavorite(@RequestBody FavoriteResponseDto favoriteResponseDto) {
        placeService.createFavorite(SecurityUtil.getCurrentUsername().get(), favoriteResponseDto.place_id());
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
