package com.example.diaryProject.domain.diary;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository repository;

    //日記の一覧表示(ユーザーごと)
    public List<Diary> showDiary(String name){
        return repository.showDiary(name);
    }

    //日記の登録
    public void createDiary(String name,String title,String detail){
        repository.create(name,title,detail);
    }

    public Diary showDetail(int id) {
        return repository.showDetail(id);
    }
}