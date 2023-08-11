package com.example.SummerProject.repository;

import com.example.SummerProject.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,String> {
}

