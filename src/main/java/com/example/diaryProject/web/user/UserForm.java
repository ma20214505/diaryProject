package com.example.diaryProject.web.user;

import com.example.diaryProject.web.validation.UniqueUsername;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.context.annotation.Primary;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//フォームから送られたデータを基にユーザー作成
@Data
@AllArgsConstructor
public class UserForm {

    @NotBlank
    @UniqueUsername
    private String name;

    @NotBlank
    @Size(min = 10,max = 128)
    private String pw;

//    @NotBlank
//    @Email
//    private String mail;

//    @NotBlank
//    private String authority;
}
