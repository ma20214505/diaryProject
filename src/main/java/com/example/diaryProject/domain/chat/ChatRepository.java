package com.example.diaryProject.domain.chat;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ChatRepository {

    @Select("SELECT * FROM chat  where sender_name = #{userName} or receiver_name = #{userName} order by send_date desc")
    List<Chat> showChat(String userName);

    @Insert("INSERT INTO chat (sender_name,receiver_name,message) VALUES (#{senderName},#{receiverName},#{message})")
    void create(String senderName, String receiverName, String message);

    @Delete("DELETE FROM chat WHERE id = #{id}")
    void delete(String id);
}
