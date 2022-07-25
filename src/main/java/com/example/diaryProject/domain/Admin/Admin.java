package com.example.diaryProject.domain.Admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;

@Data
@AllArgsConstructor
public class Admin {
    private String id;
    private String name;
}
