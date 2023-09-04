package com.example.SummerProject.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KakaoDto {

    private String id;
    private String email;
    private String nickname;
}
