package com.sparta.week06.domain;

import com.sparta.week06.controller.request.CommentRequestDto;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Entity // 테이블임을 나타냅니다.
public class Comment extends Timestamped {

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String author;

    @Column(nullable = false)
    private String comment;


    public Long getId() {
        return this.id;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getComment() {
        return this.comment;
    }



    public Comment(String author, String comment) {
        this.author = author;
        this.comment = comment;
    }

    public Comment(CommentRequestDto requestDto) {
        this.author = requestDto.getAuthor();
        this.comment = requestDto.getComment();
    }

    public void update(Comment comment) {
        this.author = comment.author;
        this.comment = comment.comment;
    }

}

