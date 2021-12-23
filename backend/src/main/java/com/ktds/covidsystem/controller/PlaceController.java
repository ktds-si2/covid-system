package com.ktds.covidsystem.controller;

import com.ktds.covidsystem.constant.PlaceType;
import com.ktds.covidsystem.domain.Place;
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
     *
     * @return Select * from Place
     */
    @GetMapping("/")
    public List<PlaceDto> placeList() {
        return placeService.findAllPlace();
    }

    /**
     * 각 검색 조건으로 장소 조회
     *
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
    @PostMapping("/find/byPlace")
    public List<PlaceDto> findPlace(@RequestParam(required = false) String placeType,
                                    @RequestParam(required = false) String placeName,
                                    @RequestParam(required = false) String address,
                                    @RequestParam(required = false) String phoneNumber,
                                    @RequestParam(required = false, defaultValue = "-1") Integer currentNumberOfPeople,
                                    @RequestParam(required = false, defaultValue = "-1") Integer capacity,
                                    int pageNum, int pageSize){
        return placeService.findPlace(placeType, placeName, address, phoneNumber, currentNumberOfPeople, capacity, pageNum, pageSize).getContent();
    }



}
