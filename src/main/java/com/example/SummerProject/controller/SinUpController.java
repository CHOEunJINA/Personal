package com.example.SummerProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SinUpController {
    @GetMapping("/signup")
    public String show(){
        return "signup/SignUp";
    }
}
