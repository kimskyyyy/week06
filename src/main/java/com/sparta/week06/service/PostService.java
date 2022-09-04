package com.sparta.week06.service;

import com.sparta.week06.controller.request.PostRequestDto;
import com.sparta.week06.controller.response.PostResponseDto;
import com.sparta.week06.controller.response.ResponseDto;
import com.sparta.week06.domain.Post;
import com.sparta.week06.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service // PostService 클래스가 서비스임을 스프링에게 알림
@RequiredArgsConstructor // 초기화 되지 않은 final 필드, @NOTNull 필드에 생성자 만듦
public class PostService {
    private final PostRepository postRepository; // 서비스에게 꼭 필요한 것을 final로 명시
//    private CommentRepository commentRepository;
//    private final TokenProvider tokenProvider;
//    private final LikeRepository likeRepository;

    // 게시글 작성
    @Transactional // 메소드가 호출 될 경우 트랜잭션을 시작하고 정상여부에 따라 Commit 또는 Rollback
    public ResponseDto<?> createPost(PostRequestDto requestDto, HttpServletRequest request) {
//        if (null == request.getHeader("Refresh-Token")) {
//            return ResponseDto.fail("USER_NOT_FOUND",
//                    "로그인이 필요합니다.");
//        }
//
//        if (null == request.getHeader("Authorization")) {
//            return ResponseDto.fail("USER_NOT_FOUND",
//                    "로그인이 필요합니다.");
//        }
//
//        User user = validateUser(request);
//        if (null == user) {
//            return ResponseDto.fail("INVALID_TOKEN", "Token이 유효하지 않습니다.");
//        }
//
        Post post = Post.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .imageUrl(requestDto.getImageUrl())
//                .user(user)
                .build();
        postRepository.save(post);
        return ResponseDto.ok(
                PostResponseDto.builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .content(post.getContent())
                        .imageUrl(post.getImageUrl())
//                        .like(post.getLike())
//                        .author(post.getUser())
                        .modifiedAt(post.getModifiedAt())
                        .build()
        );
    }
    // 단일 게시글 조회
    @Transactional(readOnly = true)
    public ResponseDto<?> getPost(Long id) {
        Post post = isPresentPost(id);
        if (null == post) {
            return ResponseDto.fail("NOT_FOUND", "존재하지 않는 게시글 id 입니다.");
        }

//        List<Comment> commentList = commentRepository.findAllByPost(post);
//        List<CommentResponseDto> commentResponseDtoList = new ArrayList<>();
//
//        for (Comment comment : commentList) {
//            commentResponseDtoList.add(
//                    CommentResponseDto.builder()
//                            .id(comment.getId())
//                            .author(comment.getMember().getNickname())
//                            .content(comment.getContent())
////                            .like(comment.getLike())
//                            .modifiedAt(comment.getModifiedAt())
//                            .build()
//            );
//        }

        return ResponseDto.ok(
                PostResponseDto.builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .content(post.getContent())
                        .imageUrl(post.getImageUrl())
//                        .commentcount(commentResponseDtoList.size())
//                        .like(post.getLike())
//                        .commentResponseDtoList(commentResponseDtoList)
//                        .author(post.getUser())
                        .modifiedAt(post.getModifiedAt())
                        .build()
        );
    }

    // 전체 게시글 조회(메인)
    @Transactional(readOnly = true)
    public ResponseDto<?> getAllPost() {
        List<Post> posts = postRepository.findAllByOrderByModifiedAtDesc();
        List<PostResponseDto> postResponseDtos = new ArrayList<>();
        for (Post post:posts){
////            List<Comment> commentList = commentRepository.findAllByPost(post);
//
            postResponseDtos.add(
                    PostResponseDto.builder()
                            .id(post.getId())
                            .title(post.getTitle())
                            .content(post.getContent())
                            .imageUrl(post.getImageUrl())
//                            .like(post.getLike())
//                            .commentcount(commentList.size())
//                            .author(post.getUser())
                            .modifiedAt(post.getModifiedAt())
                            .build()
            );

        }

        return ResponseDto.ok(postResponseDtos);
    }

    // 게시글 수정
    @Transactional
    public ResponseDto<Post> updatePost(Long id, PostRequestDto requestDto, HttpServletRequest request) {
//        if (null == request.getHeader("Refresh-Token")) {
//            return ResponseDto.fail("USER_NOT_FOUND",
//                    "로그인이 필요합니다.");
//        }
//
//        if (null == request.getHeader("Authorization")) {
//            return ResponseDto.fail("USER_NOT_FOUND",
//                    "로그인이 필요합니다.");
//        }
//
//        User user = validateUser(request);
//        if (null == user) {
//            return ResponseDto.fail("INVALID_TOKEN", "Token이 유효하지 않습니다.");
//        }
//
        Post post = isPresentPost(id);
        if (null == post) {
            return ResponseDto.fail("NOT_FOUND", "존재하지 않는 게시글 id 입니다.");
        }

//        if (post.validateUser(user)) {
//            return ResponseDto.fail("BAD_REQUEST", "작성자만 수정할 수 있습니다.");
//        }

        post.update(requestDto);
        return ResponseDto.ok(post);
    }

    // 게시글 삭제
    @Transactional
    public ResponseDto<?> deletePost(Long id, HttpServletRequest request) {
//        if (null == request.getHeader("Refresh-Token")) {
//            return ResponseDto.fail("USER_NOT_FOUND",
//                    "로그인이 필요합니다.");
//        }
//
//        if (null == request.getHeader("Authorization")) {
//            return ResponseDto.fail("USER_NOT_FOUND",
//                    "로그인이 필요합니다.");
//        }
//
//        User user = validateUser(request);
//        if (null == user) {
//            return ResponseDto.fail("INVALID_TOKEN", "Token이 유효하지 않습니다.");
//        }
//
        Post post = isPresentPost(id);
        if (null == post) {
            return ResponseDto.fail("NOT_FOUND", "존재하지 않는 게시글 id 입니다.");
        }
//
//        if (post.validateUser(user)) {
//            return ResponseDto.fail("BAD_REQUEST", "작성자만 삭제할 수 있습니다.");
//        }
//
        postRepository.delete(post);
        return ResponseDto.ok("delete success");
    }

    @Transactional(readOnly = true)
    public Post isPresentPost(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        return optionalPost.orElse(null);
    }

    // 게시글 좋아요
//    @Transactional
//    public User validateUser(HttpServletRequest request) {
//        if (!tokenProvider.validateToken(request.getHeader("Refresh-Token"))) {
//            return null;
//        }
//        return tokenProvider.getUserFromAuthentication();
//    }
//
//
//    public PostLike isPresentLike(Long Id, String nickname) {
//        Optional<PostLike> optionalPostLike = likeRepository.findByRequestIdAndUser(Id,User);
//        return optionalPostLike.orElse(null);
//    }

    // 게시글 좋아요
//    @Transactional
//    public ResponseDto<?> createpostlike(Long id, HttpServletRequest request) {
//        if (null == request.getHeader("Refresh-Token")) {
//            return ResponseDto.fail("USER_NOT_FOUND",
//                    "로그인이 필요합니다.");
//        }
//
//        if (null == request.getHeader("Authorization")) {
//            return ResponseDto.fail("USER_NOT_FOUND",
//                    "로그인이 필요합니다.");
//        }
//
//        User user = validateUser(request);
//        if (null == user) {
//            return ResponseDto.fail("INVALID_TOKEN", "Token이 유효하지 않습니다.");
        }

//        Post post = isPresentPost(id);
//        if (null == post) {
//            return ResponseDto.fail("NOT_FOUND", "존재하지 않는 게시글 id 입니다.");
//        }
//        PostLike like = isPresentLike(post.getId(), user.getNickname());
//
//        if (null == like)
//            likeRepository.save(PostLike.builder()
//                    .requestId(post.getId())
//                    .nickname(user.getNickname()).build());
//        else
//            likeRepository.delete(like);
//
//        post.updatelike(likeRepository
//                .findAllByRequestId(post.getId()).size());
//
//        return ResponseDto.ok("like success");

//    }




