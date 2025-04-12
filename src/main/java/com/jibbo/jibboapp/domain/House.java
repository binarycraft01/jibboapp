package com.jibbo.jibboapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;          // 집 제목
    private String realtorName;   // 부동산 이름
    private String dealType;      // "전세", "월세", "매매"
    private Long deposit;         // 보증금
    private Long monthlyRent;     // 월세
    private Long salePrice;       // 매매가
    private String address;       // 주소
    private String memo;          // 메모

    private String imagePath;    //집 사진(이미지) 저장 경로

    @ManyToOne
    @JoinColumn(name = "user_id")  // 외래키
    private User user;

    protected House() {}

    public House(String title, String realtorName, String dealType, Long deposit, Long monthlyRent, Long salePrice, String address, String memo, User user) {
        this.title = title;
        this.realtorName = realtorName;
        this.dealType = dealType;
        this.deposit = deposit;
        this.monthlyRent = monthlyRent;
        this.salePrice = salePrice;
        this.address = address;
        this.memo = memo;
        this.user = user;
    }

    // Getter, Setter 생략 or Lombok 사용 가능
}
