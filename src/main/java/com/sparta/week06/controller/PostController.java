package com.sparta.week06.controller;

import com.sparta.week06.controller.request.PostRequestDto;
import com.sparta.week06.controller.response.ResponseDto;
import com.sparta.week06.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성(생성자 자동 생성)
@RestController // JSON으로 데이터 주고 받는 Controller임을 선언
public class PostController {
    private final PostService postService;

    // 게시글 작성
    @RequestMapping(value = "/api/write", method = RequestMethod.POST)
    public ResponseDto<?> createPost(@RequestBody PostRequestDto requestDto,
                                     HttpServletRequest request) {
        return postService.createPost(requestDto, request);
    }
    // 단일 게시글 조회
    @RequestMapping(value = "/api/post/{id}", method = RequestMethod.GET)
    public ResponseDto<?> getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    // 전체 게시글 조회(메인)
    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public ResponseDto<?> getAllPosts() {
        return postService.getAllPost();
    }

    // 게시글 수정
    @RequestMapping(value = "/api/post/{id}", method = RequestMethod.PUT)
    public ResponseDto<?> updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto,
                                     HttpServletRequest request) {
        return postService.updatePost(id, postRequestDto, request);
    }

    // 게시글 삭제
    @RequestMapping(value = "/api/post/{id}", method = RequestMethod.DELETE)
    public ResponseDto<?> deletePost(@PathVariable Long id,
                                     HttpServletRequest request) {
        return postService.deletePost(id, request);
    }

    // 좋아요
//    @RequestMapping(value = "/api/post/like/{id}", method = RequestMethod.POST)
//    public ResponseDto<?> createpostlikes(@PathVariable Long id,
//                                          HttpServletRequest request){
//        return postService.createpostlikes(id,request);
//    }
}
