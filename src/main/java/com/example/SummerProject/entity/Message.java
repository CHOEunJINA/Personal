package com.example.SummerProject.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

/*
    기능 : 메시지 엔티티
    주요 기능 : 메시지 테이블, 일대다 관계 연결, 외래키 참조
 */
@Entity
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String message;
    @Column
    private String sender;
    @Column
    private String reciver;

    @ManyToOne
    @JoinColumn(name = "roomid")
    private ChatRoom chatRoom;

    public Message(String message, String sender, String reciver) {
        this.message = message;
        this.sender = sender;
        this.reciver = reciver;
    }
}
