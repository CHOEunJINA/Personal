package com.example.SummerProject.repository;

import com.example.SummerProject.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,String> {
    User save(User user);
    Optional<User> findById(String id);
    List<User> findAll();
    boolean existsByNickname(String nickname);
}

