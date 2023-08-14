package com.example.SummerProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    /*
    회원가입 페이지
     */
    @GetMapping("/signup")
    public String showSignUp(){
        return "signup/SignUpPage";
    }

    /*
    회원 정보 저장
     */
    @GetMapping("/signup")
    public String saveUserInfo(){

        return null;
    }
}
