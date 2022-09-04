package com.sparta.week06.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
//import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {
    private Long id;
    private String author;
    private String title;
    private String content;
    private String imageUrl;
    private LocalDateTime modifiedAt;
//    private int likeCount;
    private int commentCount;
//    private List<CommentResponseDto> commentResponseDtoList;


}
