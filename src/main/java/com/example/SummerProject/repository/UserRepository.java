package com.example.SummerProject.repository;

import com.example.SummerProject.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,String> {

    Optional<User> findById(String id);
}

