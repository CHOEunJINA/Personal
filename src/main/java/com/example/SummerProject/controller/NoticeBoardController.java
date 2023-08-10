package com.example.SummerProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticeBoardController {

    @GetMapping("/NoticeBoard")
    public String showNoticeBoard(){
        return "NoticeBoard";
    }
}
