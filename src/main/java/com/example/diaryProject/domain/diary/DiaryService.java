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

    //日記IDに基づいて取得
    public Diary showDetail(int id) {
        return repository.showDetail(id);
    }

    //日記の更新
    public void update(int id,String title, String detail) {
        repository.updateDiary(id,title,detail);
    }
}
