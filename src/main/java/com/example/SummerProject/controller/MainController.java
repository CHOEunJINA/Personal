package com.example.SummerProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String showMain(){
        return "MainPage";
    }
}