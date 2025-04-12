package com.jibbo.jibboapp.controller;

import com.jibbo.jibboapp.domain.House;
import com.jibbo.jibboapp.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/houses")
public class HouseController {

    private final HouseRepository houseRepository;

    @Autowired
    public HouseController(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    // ✅ 1. 집 전체 조회
    @GetMapping
    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }

    // ✅ 2. 집 등록
    @PostMapping
    public House createHouse(@RequestBody House house) {
        return houseRepository.save(house);
    }

    // ✅ 3. 사진 업로드
    @PostMapping("/{houseId}/upload-image")
    public String uploadImage(@PathVariable Long houseId, @RequestParam("file") MultipartFile file) throws IOException {
        House house = houseRepository.findById(houseId)
                .orElseThrow(() -> new IllegalArgumentException("해당 집이 존재하지 않습니다."));

        // 저장 디렉토리
        String uploadDir = "uploads/";
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir + fileName);

        // 디렉토리 없으면 생성
        Files.createDirectories(filePath.getParent());

        // 파일 저장
        Files.write(filePath, file.getBytes());

        // House에 이미지 경로 저장
        house.setImagePath(filePath.toString());
        houseRepository.save(house);

        return "사진 업로드 성공: " + fileName;
    }
}
