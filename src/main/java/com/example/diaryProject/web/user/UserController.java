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
import org.springframework.security.core.Authentication;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //ユーザー管理画面遷移
    @GetMapping("/control")
    public String showUserControl() {
        return "/user/Control";
    }

    //ユーザー一覧遷移
    @GetMapping("/showUserList")
    public String showUserList() {
        return "/user/List";
    }

    //ユーザー削除フォーム遷移
    @GetMapping("/userDelete")
    public String showUserDeleteForm(@ModelAttribute DeleteUserForm form) {
        return "/user/DeleteForm";
    }

    //ユーザー削除処理
    @PostMapping("/userDelete")
    public String userDelete(@Validated DeleteUserForm form,BindingResult bindingResult ,Authentication authentication) {
        if (bindingResult.hasErrors() || !authentication.getName().equals(form.getName())) {
            return showUserDeleteForm(form);
        }
        userService.delete(form.getName());
        return "redirect:/login";
    }
}