package com.jibbo.jibboapp.repository;

import com.jibbo.jibboapp.domain.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {
    // 필요한 경우: 특정 유저의 집 목록 조회도 여기서 작성 가능
}
