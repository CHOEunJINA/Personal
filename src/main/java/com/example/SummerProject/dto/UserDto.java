package com.example.SummerProject.dto;

import com.example.SummerProject.entity.User;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {

    private String id;
    private String pw;
    private String nickname;

    public User toEntity(String id, String pw, String nickname) {
        return User.builder()
                .id(id)
                .pw(pw)
                .nickname(nickname)
                .build();
    }
}
