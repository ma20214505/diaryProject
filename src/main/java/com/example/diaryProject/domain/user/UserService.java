package com.example.diaryProject.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public void create(String name,String pw,String authority){
       var encodPassword =  passwordEncoder.encode(pw);
        userRepository.create(name,encodPassword,authority);
    }
}
