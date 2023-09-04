package com.example.SummerProject.api;

import com.example.SummerProject.dto.KakaoDto;
import com.example.SummerProject.service.KakaoService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SocialLoginApiController {
    private KakaoService kaKaoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("kakaoURl", kaKaoService.getKakaoLogin());
        return "index";
    }

    @GetMapping("/callback")
    public ResponseEntity<Kakao> callback(HttpServletRequest request) throws Exception{
        KakaoDto kakaoInfo=kaKaoService.getKakaoInfo(request.getParameter("code"));
        return ResponseEntity.ok().body(new MsgEntity("Success",kakaoInfo));
    }
}
