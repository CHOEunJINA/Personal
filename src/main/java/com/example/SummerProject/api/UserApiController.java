package com.example.SummerProject.api;

import com.example.SummerProject.dto.UserDto;
import com.example.SummerProject.entity.User;
import com.example.SummerProject.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
public class UserApiController {

    private UserService userService;
    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    /*
      회원 정보 저장
    */
    @PostMapping("/signup/SignUpPage")
    public ResponseEntity<String> saveUserInfo(@RequestBody UserDto userDto) {
        String saved = userService.create(userDto);
        return (saved != null) ?
                ResponseEntity.status(HttpStatus.OK).body("회원가입 성공"):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
