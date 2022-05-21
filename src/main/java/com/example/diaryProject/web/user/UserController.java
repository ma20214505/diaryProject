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

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //ユーザー一覧
    @GetMapping("/showUserList")
    public String showUserList(){
        return "/user/userList";
    }

    //ユーザー作成
    @GetMapping("/createUser")
    public String createUser(@ModelAttribute UserForm form){
        return "/user/createUser";
    }

    @PostMapping
    public String create(@Validated UserForm form, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return createUser(form);
        }
        userService.create(form.getName(), form.getPw(), "USER");
        return "/top";
    }

}
