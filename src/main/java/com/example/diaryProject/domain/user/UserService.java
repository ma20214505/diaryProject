package com.example.diaryProject.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void create(String name,String pw,String authority){
        userRepository.create(name,pw,authority);
    }
}
