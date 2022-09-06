package com.sparta.week06.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
//import java.util.List;

@Builder // 빌더 패턴을 적용할 클래스(필수 매개 변수만으로 생성자를 호출하여 빌더 객체를 얻음)
@Getter // Get메소드 일괄 생성
@NoArgsConstructor // 파라미터가 없는 기본 생성자 생성
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 만듦
public class PostResponseDto {
    private Long id;
    private String author;
    private String title;
    private String content;
    private String imageUrl;
    private LocalDateTime modifiedAt;
//    private int likeCount;
//    private int commentCount;
//    private List<CommentResponseDto> commentResponseDtoList;


}
