package com.jibbo.jibboapp.controller;

import com.jibbo.jibboapp.domain.Checklist;
import com.jibbo.jibboapp.domain.House;
import com.jibbo.jibboapp.repository.ChecklistRepository;
import com.jibbo.jibboapp.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checklists")
public class ChecklistController {

    private final ChecklistRepository checklistRepository;
    private final HouseRepository houseRepository;

    @Autowired
    public ChecklistController(ChecklistRepository checklistRepository, HouseRepository houseRepository) {
        this.checklistRepository = checklistRepository;
        this.houseRepository = houseRepository;
    }

    // ✅ 1. 체크리스트 등록
    @PostMapping
    public Checklist createChecklist(@RequestParam Long houseId, @RequestBody Checklist checklist) {
        House house = houseRepository.findById(houseId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 집입니다."));
        checklist.setHouse(house);
        return checklistRepository.save(checklist);
    }

    // ✅ 2. 특정 집의 체크리스트 전체 조회
    @GetMapping
    public List<Checklist> getChecklistsByHouse(@RequestParam Long houseId) {
        return checklistRepository.findByHouseId(houseId);
    }
}
