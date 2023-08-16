package com.example.SummerProject.controller;

import com.example.SummerProject.repository.UserRepository;
import com.example.SummerProject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*
    회원가입 페이지
    */
    @GetMapping("/signup")
    public String showSignUp() {
        return "signup/SignUpPage";
    }


}
