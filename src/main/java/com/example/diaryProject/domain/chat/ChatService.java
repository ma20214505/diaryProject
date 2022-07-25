package com.example.diaryProject.domain.chat;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ChatService {
    private final ChatRepository repository;

    //チャット一覧取得
    public List<Chat> showChat(String name){
        if(repository.showChat(name).isEmpty()){
            return null;
        }
        return repository.showChat(name);
    }

    //チャット追加
    public void createChat(String senderName,String receiverName,String message){
        repository.create(senderName,receiverName,message);
    }

    //チャット削除
    public void deleteChat(String id){
        repository.delete(id);
    }
}
