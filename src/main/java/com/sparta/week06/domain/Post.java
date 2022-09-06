package com.sparta.week06.domain;

import com.sparta.week06.controller.request.PostRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // get 함수 일괄 생성
@Builder
@NoArgsConstructor // 파라미터가 없는 기본 생성자 생성
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 만듦
@Entity // DB 테이블과 1:1 매칭
public class Post extends Timestamped {

    @Id //ID 값을 PRIMARY KEY로 사용
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성을 DB에 위임(자동 생성)
    private Long id;

    @Column(nullable = false) // 컬럼 값, null 허용 안함
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(length = 1000) // 컬럼 길이 1000(cf. 기본 컬림 길이 255)
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY) // 여러개의 post를 1명의 User가 작성, 지연 로딩 사용
    @JoinColumn(name = "author", nullable = false) // post테이블을 user테이블의 username을 이용하여 조인
    private User username;

//    @Column
//    private int like;

    public void update(PostRequestDto postRequestDto) { // updqte 일반 생성자
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.imageUrl =  postRequestDto.getImageUrl();
    }

//    public boolean validateUser(User user) {
//        return !this.user.equals(user);
//    }


//    public void updatelike(int num) {
//        this.like = (num);
//    }



}
