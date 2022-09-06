package com.sparta.week06.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder // 빌더 패턴을 적용할 클래스(필수 매개 변수만으로 생성자를 호출하여 빌더 객체를 얻음)
@Getter // Get메소드 일괄 생성
@NoArgsConstructor // 파라미터가 없는 기본 생성자 생성
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 만듦
@Entity // DB 테이블과 1:1 매칭
public class Image {
    @Id //ID 값을 PRIMARY KEY로 사용
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성을 DB에 위임(자동 생성)
    private Long id;

    @Column(length = 1000) // 컬럼 길이 1000(cf. 기본 컬림 길이 255)
    private String imageUrl;
}
