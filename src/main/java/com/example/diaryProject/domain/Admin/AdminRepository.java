package com.example.diaryProject.domain.Admin;

import com.example.diaryProject.domain.user.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;

@Mapper
public interface AdminRepository {

    @Select("select * from users where authority = 'USER'")
    Collection<User> showUsers();

    @Delete("delete from users where id = #{id}")
    void delete(String[] id);

    @Select("select * from admin_user")
    Collection<Admin> showAdmin();

    //insert文を書く　管理者テーブル
    @Insert("insert into admin_user(adminname) values(#{name})")
    void adminCreate(String name);

    //delete文を書く　ユーザーテーブル＆管理者テーブル
    void deleteAdmin(String name, String pw);

    //userテーブルに管理者を追加する
    @Insert("insert into users(name,password,authority) values(#{name},#{pw},'ADMIN')")
    void userCreate(String name, String pw, String admin);
}
