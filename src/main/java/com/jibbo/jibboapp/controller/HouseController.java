package com.jibbo.jibboapp.controller;

import com.jibbo.jibboapp.domain.House;
import com.jibbo.jibboapp.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/houses")
public class HouseController {

    private final HouseRepository houseRepository;

    @Autowired
    public HouseController(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    // 1. 전체 집 목록 조회
    @GetMapping
    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }

    // 2. 집 등록
    @PostMapping
    public House createHouse(@RequestBody House house) {
        return houseRepository.save(house);
    }
}
