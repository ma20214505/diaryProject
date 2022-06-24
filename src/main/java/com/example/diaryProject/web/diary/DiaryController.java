package com.example.diaryProject.web.diary;

import com.example.diaryProject.domain.diary.Diary;
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

    //投稿フォームの表示
    @GetMapping("/createDiary")
    public String showCreateDiary(@ModelAttribute DiaryForm form){
        return "/diary/diaryForm";
    }

    //日記を投稿　失敗時：作成フォームに遷移　成功時：ユーザーごとの日記一覧に遷移
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

    //日記詳細表示
    @GetMapping("/showDiary/{id}")
    public String showDiaryDetail(@PathVariable("id") int id,Model model,@ModelAttribute DiaryForm form){
        model.addAttribute("diary",diaryService.showDetail(id));
        return "/diary/showDetail";
    }

    //日記の更新
    @PostMapping("/updateDiary")
    public String updateDiary(@Validated Diary diary, BindingResult bindingResult, Model model){
        name = diary.getUserName();
        if(bindingResult.hasErrors()){
            model.addAttribute("diaryList",diaryService.showDiary(name));
            return "/diary/showDiary";
        }
        diaryService.update(diary.getId(),diary.getTitle(),diary.getDetail());
        model.addAttribute("diaryList",diaryService.showDiary(name));
        return "redirect:/diary/showDiary";
    }
}
