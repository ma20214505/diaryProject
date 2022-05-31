package com.example.diaryProject.web.diary;

import com.example.diaryProject.domain.diary.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@Controller
@RequestMapping("/diary")
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;
    private String name;

    //日記作成フォームの表示
    @GetMapping("/createDiary")
    public String showCreateDiary(@ModelAttribute DiaryForm form){
        return "/diary/diaryForm";
    }

    //日記を作成　失敗時：作成フォームに遷移　成功時：ユーザーごとの日記一覧に遷移
    @PostMapping
    public String createDiary(@Validated DiaryForm form, BindingResult bindingResult,Authentication authentication){
        if(bindingResult.hasErrors()){
            return showCreateDiary(form);
        }
        name = authentication.getName();
        diaryService.createDiary(name,form.getTitle(),form.getDetail());
        return "redirect:/diary/showDiary";
    }

    //ユーザーごとに日記を表示する
    @GetMapping("/showDiary")
    public String showDiaryList(Model model,Authentication authentication){
        name = authentication.getName();
        model.addAttribute("diaryList",diaryService.showDiary(name));
        return "/diary/showDiary";
    }

    //タイトルに基づいて内容を表示
    @GetMapping("/showDiary/{id}")
    public String showDiaryDetail(@PathVariable("id") int id,Model model){
        model.addAttribute("diary",diaryService.showDetail(id));
        return "/diary/showDetail";
    }
}
