package com.example.diaryProject.web.admin;

import com.example.diaryProject.web.user.UserForm;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AdminForm extends UserForm {
    public AdminForm(@NotBlank String name, @NotBlank @Size(min = 10, max = 128) String pw) {
        super(name, pw);
    }
}
