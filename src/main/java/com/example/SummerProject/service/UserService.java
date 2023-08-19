package com.example.SummerProject.service;

import com.example.SummerProject.dto.UserDto;
import com.example.SummerProject.entity.User;
import com.example.SummerProject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
    회원 계정 생성(중복되는 id 찾기)
    */
    public User create(UserDto userDto) {
        String id = userDto.getId();
        log.info("DTO의 아이디"+ id);

        Optional<User> target = userRepository.findById(id);
        log.info("Target"+ target);

        target.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다!");
        });

        //1. Dto -> Entity
        User user = userDto.toEntity();

        //2. repository에게 entity를 디비에 저장하게 시킴
        User saved = userRepository.save(user);
        log.info("Service 정상"+ saved.toString());

        return saved;

    }
    // 닉네임 중복확인
    public boolean existsByNickname(String nickname){

        boolean result = userRepository.existsByNickname(nickname);

        return result;
    }


}
