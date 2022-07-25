package com.example.diaryProject.web.admin;

import com.example.diaryProject.domain.Admin.AdminService;
import com.example.diaryProject.web.user.UserForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    //管理者用トップページ
    @GetMapping
    public String showTop(Model model) {
        return "/admin/top";
    }

    //管理者一覧画面
    @GetMapping("/showAdmin")
    public String showAdminList(Model model){
        model.addAttribute("adminList",adminService.showAdmin());
        return "/admin/show_admin";
    }

    //管理登録画面遷移
    @GetMapping("/control")
    public String adminControl(@ModelAttribute UserForm form){
        return "/admin/control";
    }

    //管理者登録処理
    @PostMapping("/register")
    public String registerAdmin(@Validated UserForm form, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return adminControl(form);
        }
        adminService.create(form.getName(),form.getPw());
        return "redirect:/admin/show_admin";
    }

    //ユーザー一覧画面
    @GetMapping("/showUser")
    public String showUserList(Model model){
        model.addAttribute("userList",adminService.showUsers());
        return "/admin/show_user";
    }
}
