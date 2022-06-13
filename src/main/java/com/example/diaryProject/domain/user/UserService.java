package com.example.diaryProject.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    //ユーザー作成
    public void create(String name,String pw,String authority){
       var encodPassword =  passwordEncoder.encode(pw);
        userRepository.create(name,encodPassword,authority);
    }

    //ユーザー削除
    public void delete(String name, String pw) {
        var encodPassword = passwordEncoder.encode(pw);
        userRepository.delete(name,encodPassword);

        //TODO 削除未完成
    }

    public boolean search(String name, String pw) {
        if(userRepository.search(name,passwordEncoder.encode(pw)).isEmpty()){
            return false;
        }else {
            return true;
        }
    }

}
