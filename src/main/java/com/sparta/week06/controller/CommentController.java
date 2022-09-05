package com.sparta.week06.controller;

import com.sparta.week06.domain.Comment;
import com.sparta.week06.controller.request.CommentRequestDto;
import com.sparta.week06.repository.CommentRepository;
import com.sparta.week06.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;
    private final CommentRepository commentRepository;

    @GetMapping("/api/comment")
    public List<Comment> getComment() {
        return commentRepository.findAll();
    }


    // PostMapping을 통해서, 같은 주소라도 방식이 다름을 구분합니다.
    @PostMapping("/api/comment")
    public Comment createComment(@RequestBody CommentRequestDto requestDto) {
        // requestDto 는, 생성 요청을 의미합니다.
        // 강의 정보를 만들기 위해서는 강의 제목과 튜터 이름이 필요하잖아요?
        // 그 정보를 가져오는 녀석입니다.

        // 저장하는 것은 Dto가 아니라 Course이니, Dto의 정보를 course에 담아야 합니다.
        // 잠시 뒤 새로운 생성자를 만듭니다.
        Comment comment = new Comment(requestDto);

        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
        return commentRepository.save(comment);
    }

    @PutMapping("/api/comment/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody Comment requestDto) {
        return commentService.update(id, requestDto);
    }

    @DeleteMapping("/api/comment/{id}")
    public Long deleteComment(@PathVariable Long id){
        commentRepository.deleteById(id);
        return id;
    }
}

