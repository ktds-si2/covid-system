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

    @GetMapping("/place")
    public List<PlaceDto> adminPlaceList() {
//        Page<PlaceDto> places = adminService.findPlaceByPlaceType(PlaceType.SPORTS, PageRequest.of(0, 5));
//        adminService.findPlaceByPlaceType(PlaceType.SPORTS, PageRequest.of(0, 5)).getContent();
        return placeService.findAllPlace();
    }

    @GetMapping("/place/new")
    public ResponseEntity adminNewPlaceRegisterPage() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/place/new")
    public void adminNewPlaceRegister(@RequestBody PlaceDto placeDto) {
        placeService.registerNewPlace(placeDto);
    }

    @GetMapping("/place/{placeId}")
    public PlaceDto adminPlacePageDetail(@PathVariable String placeId) throws Exception {
        return placeService.findDetailPlacePage(Long.valueOf(placeId));

    }

    @PutMapping("/place/{placeId}")
    public boolean adminPlacePageDetailModify(@PathVariable String placeId, @RequestBody PlaceDto placeDto) throws Exception {
        return placeService.modifyDetailPlacePage(Long.valueOf(placeId), placeDto);
    }

    @DeleteMapping("/place/{placeId}")
    public boolean adminPlacePageDetailDelete(@PathVariable String placeId) throws Exception {
        return placeService.deleteDetailPlacePage(Long.valueOf(placeId));
    }
}
