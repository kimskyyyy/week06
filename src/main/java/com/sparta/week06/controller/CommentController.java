package com.sparta.week06.controller;


import javax.servlet.http.HttpServletRequest;
import com.sparta.week06.controller.request.CommentRequestDto;
import com.sparta.week06.controller.request.CommentUpdateRequestDto;
import com.sparta.week06.controller.response.ResponseDto;
import com.sparta.week06.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

//    POST 방식 comment API commentRequestDto에 포함된 정보와 권한 인증을 받아 댓글을 생성하고 CommentService에서 정의한 createComment메소드를 반환.
    @RequestMapping(value = "/api/comment", method = RequestMethod.POST)
    public ResponseDto<?> createComment(@RequestBody CommentRequestDto requestDto,
                                        HttpServletRequest request) {
        return commentService.createComment(requestDto, request);
    }
// GET방식 comment API id를 조회하여 commentService에서 정의한 getAllCommentByPost 메소드에 따라 Post의 반복문을 돌려 해당 Post에 속해있는 댓글id들을 반환
//    @RequestMapping(value = "/api/comment/{id}", method = RequestMethod.GET)
//    public ResponseDto<?> getAllComments(@PathVariable Long id) {
//
//        return commentService.getAllCommentsByPost(id);
//    }
    @RequestMapping(value = "/api/comment", method = RequestMethod.GET)
    public ResponseDto<?> getAllComments() {
        return commentService.getAllComment();
    }

//    PUT방식 comment API id와 commentRequestDto에 포함된 정보, 권한 인증을 받아 작성된 댓글을 수정하고 CommentService에서 정의한 updateComment메소드에 따라 수정값을 반환
    @RequestMapping(value = "/api/comment/{id}", method = RequestMethod.PUT)
    public ResponseDto<?> updateComment(@PathVariable Long id, @RequestBody CommentUpdateRequestDto requestDto,
                                        HttpServletRequest request) {
        return commentService.updateComment(id, requestDto, request);
    }

//    DELETE방식 comment API id와 권한을 받아 댓글을 삭제하고 CommentService에서 정의한 deleteComment 메소드에 따라 id와 권한을 삭제.
    @RequestMapping(value = "/api/comment/{id}", method = RequestMethod.DELETE)
    public ResponseDto<?> deleteComment(@PathVariable Long id,
                                        HttpServletRequest request) {
        return commentService.deleteComment(id, request);
    }
}

