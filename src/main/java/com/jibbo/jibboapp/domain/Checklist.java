package com.jibbo.jibboapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Checklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content; // 체크리스트 항목 내용 (예: 햇빛 잘 듦)
    private boolean checked; // 체크 여부

    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;

    protected Checklist() {}

    public Checklist(String content, boolean checked, House house) {
        this.content = content;
        this.checked = checked;
        this.house = house;
    }
}
