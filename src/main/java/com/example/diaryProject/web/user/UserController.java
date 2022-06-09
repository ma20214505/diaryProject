package com.example.diaryProject.web.user;


import com.example.diaryProject.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.userdetails.User;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //ユーザー管理画面遷移
    @GetMapping("/control")
    public String showUserControl(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        return "/user/userControl";
    }

    //ユーザー一覧遷移
    @GetMapping("/showUserList")
    public String showUserList(){
        return "/user/userList";
    }

    //ユーザー削除フォーム遷移
   @GetMapping("/userDelete")
    public String showUserDeleteForm(@ModelAttribute UserForm form){
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       String name = auth.getName();
       return "/user/userDeleteForm";
   }

   @PostMapping("/userDelete")
    public String userDelete(@Validated UserForm form,BindingResult bindingResult){
        userService.delete(form.getName(),form.getPw());
        return "redirect:/login";
   }

   //ユーザー変更
}
