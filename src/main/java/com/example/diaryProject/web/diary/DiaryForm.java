package com.example.diaryProject.web.diary;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class DiaryForm {

    @NotBlank
    private String title;

    @NotBlank
    private String detail;
}
