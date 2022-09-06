//package com.sparta.week06.controller;
//
//import com.sparta.week06.controller.response.ResponseDto;
//import org.apache.tomcat.util.http.fileupload.impl.SizeException;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.io.IOException;
//
//@RestControllerAdvice // @Controller 전역 핸들링
//public class CustomExceptionHandler {
//
//    // 데이터 검증 예외 처리
//    // Validator를 상속받는 클래스에서 객체값을 검증하는 BindingResult 사용하여 에러 메시지 처리
//    @ExceptionHandler(MethodArgumentNotValidException.class) // 예외 처리 핸들러
//    public ResponseDto<?> handleValidationExceptions(MethodArgumentNotValidException exception) {
//        String errorMessage = exception.getBindingResult()
//                .getAllErrors()
//                .get(0)
//                .getDefaultMessage();
//
//        return ResponseDto.fail("BAD_REQUEST", errorMessage);
//    }
//
//    // 이미지 업로드 파일 제한 용량(10MB)초과 예외
//    @ExceptionHandler(SizeException.class)
//    public ResponseDto<?> SizeLimitExceededException() {
//        return ResponseDto.fail("Size_FAIL", "파일 크기 최대 10MB");
//    }
//    // 이미지 파일 업로드 null일 때 예외 처리
//    @ExceptionHandler(IOException.class)
//    public ResponseDto<?> IOException() {
//        return ResponseDto.fail("EMPTY", "multipart file is empty");
//    }
//
//}
//
