package com.example.SummerProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String id;
    private String pw;
    private String gender;
    private String number;
    private String name;

    public UserDto toEntity(String id,String pw,String gender,String number,String name){
        return null;
    }
}
