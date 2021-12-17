package com.ktds.covidsystem.controller;

import com.ktds.covidsystem.domain.Place;
import com.ktds.covidsystem.dto.PlaceDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/place")
    public ResponseEntity adminPlaceList() {
        return new ResponseEntity<>(PlaceDto.idOnly(1L), HttpStatus.OK);
    }

    @GetMapping("/place/new")
    public ResponseEntity adminNewPlaceRegisterPage() {
        return new ResponseEntity<>(PlaceDto.idOnly(1L), HttpStatus.OK);
    }

    @PostMapping("/place/new")
    public ResponseEntity adminNewPlaceRegister() {
        return new ResponseEntity<>(PlaceDto.idOnly(1L), HttpStatus.OK);
    }

    @GetMapping("/place/{placeId}")
    public ResponseEntity adminPlacePageDetail(@PathVariable String placeId) {
        return new ResponseEntity<>(PlaceDto.idOnly(1L), HttpStatus.OK);
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
