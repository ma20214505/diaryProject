package com.example.diaryProject.web.signup;

import com.example.diaryProject.domain.user.UserService;
import com.example.diaryProject.web.user.UserForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignupController {

    private final UserService userService;

    @GetMapping
    public String showSignupForm(@ModelAttribute UserForm form){
        return "/signup/signupForm";
    }

    @PostMapping
    public String signup(@Validated UserForm form, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return showSignupForm(form);
        }
        userService.create(form.getName(),form.getPw(),"USER");
        return "redirect:/login";
    }
}
