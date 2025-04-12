package com.jibbo.jibboapp.repository;

import com.jibbo.jibboapp.domain.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChecklistRepository extends JpaRepository<Checklist, Long> {
    // 특정 집에 연결된 체크리스트 전체 조회
    List<Checklist> findByHouseId(Long houseId);
}
