package com.sparta.week06.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Image {
    @Id //ID 값을 PRIMARY KEY로 사용
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성을 DB에 위임(자동 생성)
    private Long id;

    @Column(length = 1000) // 컬럼 길이 1000(cf. 기본 컬림 길이 255)
    private String imageUrl;
}
