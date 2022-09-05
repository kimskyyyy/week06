package com.sparta.week06.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.sparta.week06.controller.request.SignupRequestDto;
import com.sparta.week06.controller.request.UserRequestDto;
import com.sparta.week06.controller.response.ResponseDto;
import com.sparta.week06.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @RequestMapping(value = "/api/user/signup", method = RequestMethod.POST)
    public ResponseDto<?> signup(@RequestBody @Valid UserRequestDto requestDto) {
        return userService.createUser(requestDto);
    }

    @RequestMapping(value = "/api/user/login", method = RequestMethod.POST)
    public ResponseDto<?> login(@RequestBody @Valid SignupRequestDto requestDto,
                                HttpServletResponse response
    ) {
        return userService.login(requestDto, response);
    }

//  @RequestMapping(value = "/api/auth/member/reissue", method = RequestMethod.POST)
//  public ResponseDto<?> reissue(HttpServletRequest request, HttpServletResponse response) {
//    return memberService.reissue(request, response);
//  }

    @RequestMapping(value = "/api/logout", method = RequestMethod.POST)
    public ResponseDto<?> logout(HttpServletRequest request) {
        return userService.logout(request);
    }
}