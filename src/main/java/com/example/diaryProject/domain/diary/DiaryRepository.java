package com.example.diaryProject.domain.diary;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Mapper
public interface DiaryRepository {

    //日記の追加
    @Insert("insert into diary (user_name,title,detail) values (#{name},#{title},#{detail})")
    void create(String name, String title, String detail);

    //日記の取得(ユーザーごと)
    @Select("select * from diary where user_name = #{name} order by day desc")
    List<Diary> showDiary(String name);

    //日記の取得(idに基づいて)
    @Select("select * from diary where id = #{id} order by day desc")
    Diary showDetail(int id);
}
