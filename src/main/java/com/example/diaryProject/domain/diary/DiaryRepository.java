package com.example.diaryProject.domain.diary;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.List;

@Mapper
public interface DiaryRepository {

    //日記の追加
    @Insert("insert into diary (user_name,title,detail,pub_flag) values (#{name},#{title},#{detail},#{pub_flag})")
    void create(String name, String title, String detail,int pub_flag);

    //日記の取得(ユーザーごと)
    @Select("select * from diary where user_name = #{name} order by posteddate desc")
    List<Diary> showMyDiary(String name);

    //日記の取得(idに基づいて)
    @Select("select * from diary where id = #{id}")
    Diary showDetail(int id);

    //日記の更新
    @Update("update diary set title = #{title} , detail = #{detail} where id = #{id}")
    void updateDiary(int id,String title, String detail);

    //日記の非表示
    @Update("update diary set hide = 1 where id = #{id}")
    void hideDiary(String id);

    //日記一覧表示
    @Select("select * from diary order by posteddate desc , user_name desc")
    List<Diary> showDiary();
}
