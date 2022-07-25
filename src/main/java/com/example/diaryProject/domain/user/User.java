package com.example.diaryProject.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private String pw;
    private Authority authority;
    private  Timestamp registratio_time;

    public enum Authority {
        ADMIN, USER
    }
}
