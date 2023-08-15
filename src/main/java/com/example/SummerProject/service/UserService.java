package com.example.SummerProject.service;

import com.example.SummerProject.dto.UserDto;
import com.example.SummerProject.entity.User;
import com.example.SummerProject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
        회원 계정 생성
         */
    public User create(UserDto userDto){
        log.info(userDto.toString());

        //1. Dto -> Entity
        User user = userDto.toEntity();
        log.info("Service = " + user.toString());


        //2. repository에게 entity를 디비에 저장하게 시킴
        User saved = userRepository.save(user);

        return saved;
    }



}
