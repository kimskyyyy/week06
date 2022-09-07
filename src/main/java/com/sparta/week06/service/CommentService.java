package com.sparta.week06.service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

import com.sparta.week06.controller.request.CommentRequestDto;
import com.sparta.week06.controller.request.CommentUpdateRequestDto;
import com.sparta.week06.controller.response.CommentResponseDto;
import com.sparta.week06.controller.response.PostResponseDto;
import com.sparta.week06.controller.response.ResponseDto;
import com.sparta.week06.domain.Comment;
import com.sparta.week06.domain.Post;
import com.sparta.week06.domain.User;
import com.sparta.week06.jwt.TokenProvider;
import com.sparta.week06.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    private final TokenProvider tokenProvider;
    private final PostService postService;

    @Transactional
//    댓글 생성. CommentRequestDto와 HttpServletRequest를 받은 후,
//    if문을 통해 refresh-token확인, 권한 확인, 유저확인, post확인을 진행 한 후
//    코멘트 build를 통해 해당 내용을 저장.
    public ResponseDto<?> createComment(CommentRequestDto requestDto, HttpServletRequest request) {
        if (null == request.getHeader("refreshtoken")) {
            return ResponseDto.fail("MEMBER_NOT_FOUND",
                    "로그인이 필요합니다.");
        }

        if (null == request.getHeader("Authorization")) {
            return ResponseDto.fail("MEMBER_NOT_FOUND",
                    "로그인이 필요합니다.");
        }

        User user = validateUser(request);
        if (null == user) {
            return ResponseDto.fail("INVALID_TOKEN", "Token이 유효하지 않습니다.");
        }

        Post post = postService.isPresentPost(requestDto.getParentId());
        if (null == post) {
            return ResponseDto.fail("NOT_FOUND", "존재하지 않는 게시글 id 입니다.");
        }

        Comment comment = Comment.builder()
                .user(user)
                .post(post)
                .comment(requestDto.getComment())
                .build();
        commentRepository.save(comment);
        return ResponseDto.success(
                CommentResponseDto.builder()
                        .id(comment.getId())
                        .parentId(comment.getPost().getId())
                        .author(comment.getUser().getUsername())
                        .comment(comment.getComment())
                        .modifiedAt(comment.getModifiedAt())
                        .build()
        );
    }

//    @Transactional(readOnly = true)
////    댓글 조회. Post에 있는 parentId를 받아서 post가 존재하는지 확인.
////    이후 존재한다면 반복분을 통하여 commentResponseDtoList에 추가.
////    이후 성공한다면 ResponseDto.success(commentResponseDtoList)로 반환.
//    public ResponseDto<?> getAllCommentsByPost(Long parentId) {
//        Post post = postService.isPresentPost(parentId);
//        if (null == post) {
//            return ResponseDto.fail("NOT_FOUND", "존재하지 않는 게시글 id 입니다.");
//        }
//
//        List<Comment> commentList = commentRepository.findAllByPost(post);
//        List<CommentResponseDto> commentResponseDtoList = new ArrayList<>();
//
//        for (Comment comment : commentList) {
//            commentResponseDtoList.add(
//                    CommentResponseDto.builder()
//                            .id(comment.getId())
//                            .author(comment.getUser().getUsername())
//                            .comment(comment.getComment())
//                            .modifiedAt(comment.getModifiedAt())
//                            .build()
//            );
//        }
//        return ResponseDto.success(commentResponseDtoList);
//    }

    @Transactional(readOnly = true)
    public ResponseDto<?> getAllComment() {
        List<Comment> comments = commentRepository.findAllByOrderByModifiedAtDesc();
        List<CommentResponseDto> commentResponseDtos = new ArrayList<>();
        for (Comment comment : comments) {
//            List<Comment> commentList = commentRepository.findAllByPost(post);

            commentResponseDtos.add(
                    CommentResponseDto.builder()
                            .id(comment.getId())
                            .parentId(comment.getPost().getId())
                            .author(comment.getUser().getUsername())
                            .comment(comment.getComment())
                            .modifiedAt(comment.getModifiedAt())
                            .build()
            );

        }
        return ResponseDto.success(commentResponseDtos);
    }
    @Transactional
//    댓글 수정(댓글 업데이트). 댓글 id와 CommentRequestDto, HttpServletRequest를 통해
//    refresh-token 확인, 권한 확인, User와  Post, Comment를 확인하여 일치하지 않을 경우 해당 메시지 출력. 성공시 comment.update(requestDto)를 통해 댓글 사항 수정.
    public ResponseDto<?> updateComment(Long id, CommentUpdateRequestDto requestDto, HttpServletRequest request) {
        if (null == request.getHeader("refreshtoken")) {
            return ResponseDto.fail("MEMBER_NOT_FOUND",
                    "로그인이 필요합니다.");
        }

        if (null == request.getHeader("Authorization")) {
            return ResponseDto.fail("MEMBER_NOT_FOUND",
                    "로그인이 필요합니다.");
        }

        User user = validateUser(request);
        if (null == user) {
            return ResponseDto.fail("INVALID_TOKEN", "Token이 유효하지 않습니다.");
        }

//       현재 따로 사용하지 않아서 제거.
//        Post post = postService.isPresentPost(requestDto.getId());
//        if (null == post) {
//            return ResponseDto.fail("NOT_FOUND", "존재하지 않는 게시글 id 입니다.");
//        }

        Comment comment = isPresentComment(id);
        if (null == comment) {
            return ResponseDto.fail("NOT_FOUND", "존재하지 않는 댓글 id 입니다.");
        }

        if (comment.validateUser(user)) {
            return ResponseDto.fail("BAD_REQUEST", "작성자만 수정할 수 있습니다.");
        }

        comment.update(requestDto);
        return ResponseDto.success(
                CommentResponseDto.builder()
                        .id(comment.getId())
                        .parentId(comment.getPost().getId())
                        .author(comment.getUser().getUsername())
                        .comment(comment.getComment())
                        .modifiedAt(comment.getModifiedAt())
                        .build()
        );
    }

    @Transactional
//    댓글 삭제. id와 HttpServletRequest를 통해
//    refresh-token 확인, 권한 확인, User와 Comment 확인을 진행. 오류시 해당 메시지 출력.
//    이후 cpmmentRepository.delete(comment)를 통해 댓글 삭제.
    public ResponseDto<?> deleteComment(Long id, HttpServletRequest request) {
        if (null == request.getHeader("refreshtoken")) {
            return ResponseDto.fail("MEMBER_NOT_FOUND",
                    "로그인이 필요합니다.");
        }

        if (null == request.getHeader("Authorization")) {
            return ResponseDto.fail("MEMBER_NOT_FOUND",
                    "로그인이 필요합니다.");
        }

        User user = validateUser(request);
        if (null == user) {
            return ResponseDto.fail("INVALID_TOKEN", "Token이 유효하지 않습니다.");
        }

        Comment comment = isPresentComment(id);
        if (null == comment) {
            return ResponseDto.fail("NOT_FOUND", "존재하지 않는 댓글 id 입니다.");
        }

        if (comment.validateUser(user)) {
            return ResponseDto.fail("BAD_REQUEST", "작성자만 수정할 수 있습니다.");
        }

        commentRepository.delete(comment);
        return ResponseDto.success("success");
    }

    @Transactional(readOnly = true)
//    댓글 존재 여부 확인 코드. comment가 commentRepository에 정의되어있는 findById를 통해 id를 확인. 없을경우 null.
    public Comment isPresentComment(Long id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        return optionalComment.orElse(null);
    }

    @Transactional
//    User확인 코드. HttpServletRequest를 받아 tokenProvider에서 token을 확인하였을 때
//    헤더에서 받은 토큰이 refresh-token이 아닐 경우 null을 반환. 일치할 경우 tokenProvider의 getUserFromAuthentication 메소드를 통해 권한부여
    public User validateUser(HttpServletRequest request) {
        if (!tokenProvider.validateToken(request.getHeader("refreshtoken"))) {
            return null;
        }
        return tokenProvider.getUserFromAuthentication();
    }
}
