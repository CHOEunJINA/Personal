package com.example.SummerProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class UserEntity {
    @Id
    private String id;

    @Column
    private String pw;

    @Column
    private String name;

    @Column
    private String gender;

    @Column
    private String number;

    public UserEntity(String id, String pw, String name, String number, String gender) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.number = number;
        this.gender = gender;
    }
}