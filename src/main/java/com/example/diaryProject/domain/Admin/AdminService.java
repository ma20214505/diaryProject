package com.example.diaryProject.domain.Admin;

import com.example.diaryProject.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class AdminService {
    private final AdminRepository repository;
    private final PasswordEncoder encoder;

    //ユーザー一覧取得
    public Collection<User> showUsers(){
        return repository.showUsers();
    }

    //ユーザー削除
    public void deleteUser(String[] id){
        for(String deleteId : id){
            repository.delete(id);
        }
    }

    //管理者一覧取得
    public Collection<Admin> showAdmin(){
        return repository.showAdmin();
    }

    //管理者追加
    public void create(String name,String pw){
        String encodPassword =  encoder.encode(pw);
        repository.userCreate(name,encodPassword,"ADMIN");
        repository.adminCreate(name);
    }

    //管理者削除
    public void deleteAdmin(String name,String pw){
        repository.deleteAdmin(name,pw);
    }

}
