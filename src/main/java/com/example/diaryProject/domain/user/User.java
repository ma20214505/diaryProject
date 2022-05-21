package com.example.diaryProject.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private String pw;
    private Authority authority;

    public enum Authority {
        ADMIN, USER
    }
}
