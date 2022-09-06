package com.sparta.week06.controller;

import com.sparta.week06.controller.response.ResponseDto;
import com.sparta.week06.service.ImageService;
import com.sparta.week06.service.S3UploaderService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.impl.SizeException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final S3UploaderService s3UploaderService;
    private final ImageService imageService;

    // MULTIPART/FORM으로 받은 이미지를 S3업로드 서비스로 넘겨주고, 리턴 값을 imageUrl로 받아 이미지 업로드 서비스로 넘김
    @RequestMapping(value = "/api/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
    public ResponseDto<?> upload(HttpServletRequest request, @RequestParam(value="image", required = false) MultipartFile multipartFile) throws IOException {
        String imageUrl = s3UploaderService.upload(multipartFile, "static");

        return imageService.upload(request, imageUrl);
    }

}
