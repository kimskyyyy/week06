package com.sparta.week06.controller.response;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDto {
    private Long parentId;
    private Long id;
    private String author;
    private String comment;
    private LocalDateTime modifiedAt;
}
