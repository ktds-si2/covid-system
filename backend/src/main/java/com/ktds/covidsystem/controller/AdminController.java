package com.ktds.covidsystem.controller;

import com.ktds.covidsystem.dto.PlaceDto;
import com.ktds.covidsystem.service.AdminService;
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

    private final AdminService adminService;

    @GetMapping("/place")
    public List<PlaceDto> adminPlaceList() {
//        Page<PlaceDto> places = adminService.findPlaceByPlaceType(PlaceType.SPORTS, PageRequest.of(0, 5));
//        adminService.findPlaceByPlaceType(PlaceType.SPORTS, PageRequest.of(0, 5)).getContent();
        return adminService.findAllPlace();
    }

    @GetMapping("/place/new")
    public ResponseEntity adminNewPlaceRegisterPage() {
        return new ResponseEntity<>(PlaceDto.idOnly(1L), HttpStatus.OK);
    }

    @PostMapping("/place/new")
    public void adminNewPlaceRegister(@RequestBody PlaceDto placeDto) {
        adminService.registerNewPlace(placeDto);
    }

    @GetMapping("/place/{placeId}")
    public PlaceDto adminPlacePageDetail(@PathVariable String placeId) {
//        return adminService.findDetailPlacePage(Long.valueOf(placeId))
//                .map(PlaceDto::of)
//                .orElse()
        return null;
    }

    @PutMapping("/place/{placeId}")
    public ResponseEntity adminPlacePageDetailModify(@PathVariable String placeId) {
        return new ResponseEntity<>(PlaceDto.idOnly(1L), HttpStatus.OK);
    }

    @DeleteMapping("/place/{placeId}")
    public ResponseEntity adminPlacePageDetailDelete(@PathVariable String placeId) {
        return new ResponseEntity<>(PlaceDto.idOnly(1L), HttpStatus.OK);
    }
}
