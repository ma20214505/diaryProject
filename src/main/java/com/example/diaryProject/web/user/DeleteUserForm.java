package com.example.diaryProject.web.user;

import com.example.diaryProject.web.validation.Verification;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@Verification(fields = {"name", "password"})
public class DeleteUserForm {

    @NotBlank
    String name;

    @NotBlank
    String password;
}
