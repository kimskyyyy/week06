package com.sparta.week06.controller.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CommentRequestDto {
    public Long postId;
    public String comment;
}
