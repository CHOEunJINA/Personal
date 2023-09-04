package com.example.SummerProject.service;

import com.example.SummerProject.dto.KakaoDto;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;

@Service
@Slf4j
public class KakaoService {

    @Value("${kakao.client.id}")
    private String kakao_client_id;

    @Value(staticConstructor = "${kakao.client.secret}")
    private String kakao_client_secret;

    @Value("${kakao.redirect.url}")
    private String kakao_redirect_url;

    private final static String kakao_auth_url = "https://kauth.kakao.com";
    private final static String kakao_api_url = "https://kapi.kakao.com";

    public String getKakaoLogin() {
        return kakao_auth_url + "/oauth/authorize"
                + "?client_id=" + kakao_client_id
                + "&redirect_uri=" + kakao_redirect_url
                + "&response_type=code";
    }

    public KakaoDto getKakaoInfo(String code) throws Exception{
        if(code == null) throw new Exception("Failed get authorization code");

        String accessToken="";
        String refreshToken="";

        try{
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-type", "application/x-www-form-urlencoded");

            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("grant_type", "authorization_code");
            params.add("client_id", kakao_client_id);
            params.add("client_secret", kakao_client_secret);
            params.add("code", code);
            params.add("redirect_uri", kakao_redirect_url);

            RestTemplate restTemplate = new RestTemplate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
