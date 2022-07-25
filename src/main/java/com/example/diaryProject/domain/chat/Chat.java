package com.example.diaryProject.domain.chat;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class Chat {
    private String id;
    private String senderName;   //送信者
    private String receiverName; //受信者
    private String message;      //メッセージ
    private Timestamp sendDate;  //送信日時
}