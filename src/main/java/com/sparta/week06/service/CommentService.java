package com.sparta.week06.service;

import com.sparta.week06.domain.Comment;
import com.sparta.week06.repository.CommentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service // 스프링에게 이 클래스는 서비스임을 명시
public class CommentService {

    // final: 서비스에게 꼭 필요한 녀석임을 명시
    private final CommentRepository commentRepository;

    // 생성자를 통해, Service 클래스를 만들 때 꼭 Repository를 넣어주도록
    // 스프링에게 알려줌
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, Comment comment) {
        Comment comment1 = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        comment1.update(comment);
        return comment1.getId();
    }
}
