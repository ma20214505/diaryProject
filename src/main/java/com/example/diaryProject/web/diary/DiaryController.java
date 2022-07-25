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

@Controller
@RequestMapping("/diary")
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;
    private String name;

    //投稿フォームの表示
    @GetMapping("/create_diary")
    public String showCreateDiary(@ModelAttribute DiaryForm form){
        return "/diary/diaryform";
    }

    //日記を投稿　失敗時：作成フォームに遷移　成功時：ユーザーごとの日記一覧に遷移
    @PostMapping
    public String createDiary(@Validated DiaryForm form, BindingResult bindingResult,Authentication authentication){
        if(bindingResult.hasErrors()){
            return showCreateDiary(form);
        }
        name = authentication.getName();
        diaryService.createDiary(name,form.getTitle(),form.getDetail());
        return "redirect:/diary/show_mydiary";
    }

    //自分の日記を表示する
    @GetMapping("/show_mydiary")
    public String showDiaryList(Model model,Authentication authentication){
        name = authentication.getName();
        model.addAttribute("diaryList",diaryService.showMyDiary(name));
        return "/diary/show_mydiary";
    }

    //自分の日記詳細表示
    @GetMapping("/show_mydiary/{id}")
    public String showDiaryDetail(@PathVariable("id") int id,Model model,@ModelAttribute DiaryForm form){
        model.addAttribute("diary",diaryService.showDetail(id));
        return "/diary/show_mydetail";
    }

    //日記の更新
    @PostMapping("/update_diary")
    public String updateDiary(@Validated Diary diary, BindingResult bindingResult, Model model){
        name = diary.getUserName();
        if(bindingResult.hasErrors()){
            model.addAttribute("diaryList",diaryService.showMyDiary(name));
            return "/diary/show_mydiary";
        }
        diaryService.update(diary.getId(),diary.getTitle(),diary.getDetail());
        model.addAttribute("diaryList",diaryService.showMyDiary(name));
        return "redirect:/diary/show_mydiary";
    }

    //日記一覧
    @GetMapping("/show_diary")
    public String showDiaryList(Model model){
        model.addAttribute("diaryList",diaryService.showDiary());
        return "/diary/show_diary";
    }

    //日記詳細表示
    @GetMapping("/show_diary/{id}")
    public String showDetail(@PathVariable("id") int id,Model model){
        model.addAttribute("diary",diaryService.showDetail(id));
        return "/diary/show_detail";
    }

    //日記の非表示
//    @PostMapping
//    public String hide(Authentication authentication){
//        name = authentication.getName();
//        return "redirect:/diary/showDiary";
//    }
}
