package com.sparta.week06.controller;

import com.sparta.week06.controller.response.ResponseDto;
import com.sparta.week06.service.ImageService;
import com.sparta.week06.service.S3UploaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final S3UploaderService s3UploaderService;
    private final ImageService imageService;

    @RequestMapping(value = "/api/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
    public ResponseDto<?> upload(HttpServletRequest request, @RequestParam(value="image", required = false) MultipartFile multipartFile) throws IOException {
        String imageUrl = s3UploaderService.upload(multipartFile, "static");

        return imageService.upload(request, imageUrl);
    }
}
