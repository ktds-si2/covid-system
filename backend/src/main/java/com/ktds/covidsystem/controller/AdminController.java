package com.ktds.covidsystem.controller;

import com.ktds.covidsystem.dto.PlaceDto;
import com.ktds.covidsystem.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Author : KJH
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final PlaceService placeService;


    /**
     * 모든 장소 조회
     *
     * @return Select * from Place
     */
    @GetMapping("/place")
    public List<PlaceDto> adminPlaceList() {
//        Page<PlaceDto> places = adminService.findPlaceByPlaceType(PlaceType.SPORTS, PageRequest.of(0, 5));
//        adminService.findPlaceByPlaceType(PlaceType.SPORTS, PageRequest.of(0, 5)).getContent();
        return placeService.findAllPlace();
    }

    /**
     * 새로운 장소 조회 페이지 조회
     *
     * @return HttpStatus.OK
     */
    @GetMapping("/place/new")
    public ResponseEntity adminNewPlaceRegisterPage() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 새로운 장소 등록
     *
     * @param placeDto
     * @return Insert into place values (placeDto) , return true
     */
    @PostMapping("/place/new")
    public boolean adminNewPlaceRegister(@RequestBody PlaceDto placeDto) {
        return placeService.createNewPlace(placeDto);
    }

    /**
     * 특정 장소 조회
     *
     * @param placeId
     * @return Select * from Place where placeId
     * @throws Exception
     */
    @GetMapping("/place/{placeId}")
    public PlaceDto adminPlacePageDetail(@PathVariable String placeId) throws Exception {
        return placeService.findDetailPlacePage(Long.valueOf(placeId));

    }

    /**
     * 특정 장소 수정
     *
     * @param placeId
     * @param placeDto
     * @return Update Place set placeDto where placeId
     * @throws Exception
     */
    @PutMapping("/place/{placeId}")
    public boolean adminPlacePageDetailModify(@PathVariable String placeId, @RequestBody PlaceDto placeDto) throws Exception {
        return placeService.modifyDetailPlacePage(Long.valueOf(placeId), placeDto);
    }

    /**
     * 특정 장소 삭제
     *
     * @param placeId
     * @return Delete from Place where placeId
     * @throws Exception
     */
    @DeleteMapping("/place/{placeId}")
    public boolean adminPlacePageDetailDelete(@PathVariable String placeId) throws Exception {
        return placeService.deleteDetailPlacePage(Long.valueOf(placeId));
    }
}
