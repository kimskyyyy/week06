package com.sparta.week06.service;

//import com.sparta.week06.controller.response.ImageResponseDto;
import com.sparta.week06.controller.response.ImageResponseDto;
import com.sparta.week06.controller.response.ResponseDto;
//import com.sparta.week06.domain.Image;
import com.sparta.week06.domain.Image;
import com.sparta.week06.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service // PostService 클래스가 서비스임을 스프링에게 알림
@RequiredArgsConstructor // 초기화 되지 않은 final 필드, @NOTNull 필드에 생성자 만듦
public class ImageService {
    private final ImageRepository imageRepository;
//    private final TokenProvider tokenProvider;


    @Transactional
    public ResponseDto<?> upload(HttpServletRequest request, String imageUrl) {
//        if (null == request.getHeader("Refresh-Token")) {
//            return ResponseDto.fail("USER_NOT_FOUND",
//                    "로그인이 필요합니다.");
//        }
//
//        if (null == request.getHeader("Authorization")) {
//            return ResponseDto.fail("USER_NOT_FOUND",
//                    "로그인이 필요합니다.");
//        }

//        User user = validateUser(request);
//        if (null == user) {
//            return ResponseDto.fail("INVALID_TOKEN", "Token이 유효하지 않습니다.");
//        }
//
        if (null == imageUrl) {
            return ResponseDto.fail("EMPTY", "multipart file is empty");
        }

        Image image = Image.builder()
                .imageUrl(imageUrl)
                .build();
        imageRepository.save(image);
        return ResponseDto.success(
                ImageResponseDto.builder()
                        .imageUrl(image.getImageUrl())
                        .build()
        );
    }

//    @Transactional
//    public User validateUser(HttpServletRequest request) {
//        if (!tokenProvider.validateToken(request.getHeader("Refresh-Token"))) {
//            return null;
//        }
//        return tokenProvider.getUserFromAuthentication();
//    }
}


