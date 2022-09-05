package com.sparta.week06.controller.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CommentRequestDto {
    public final String Author;
    public final String comment;

}
