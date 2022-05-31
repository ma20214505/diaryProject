package com.example.diaryProject.domain.diary;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class Diary {
    private int id;
    private String userName;
    private String title;
    private String detail;
    private Timestamp day;
}
