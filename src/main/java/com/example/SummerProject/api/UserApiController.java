package com.example.SummerProject.api;

import com.example.SummerProject.dto.UserDto;
import com.example.SummerProject.entity.User;
import com.example.SummerProject.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<User> saveUserInfo(@RequestBody @Valid UserDto userDto) {
        User saved = userService.create(userDto);
        return (saved != null) ?
                ResponseEntity.status(HttpStatus.OK).body(saved):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    /*
    닉네임 중복확인
     */
    @GetMapping("/signup/SignUpPage/{nickname}")
    public ResponseEntity<Boolean> checkNickName(@PathVariable String nickname){
        boolean result = userService.existsByNickname(nickname);
        return (result!=true) ?
                ResponseEntity.status(HttpStatus.OK).body(true):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
