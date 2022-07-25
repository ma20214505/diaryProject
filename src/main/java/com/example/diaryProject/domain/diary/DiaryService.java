package com.example.diaryProject.domain.diary;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository repository;

    //日記の一覧表示(ユーザーごと)
    public List<Diary> showMyDiary(String name){
        return repository.showMyDiary(name);
    }

    //日記の登録
    public void createDiary(String name,String title,String detail){
        repository.create(name,title,detail,0);
    }

    //日記IDに基づいて取得
    public Diary showDetail(int id) {
        return repository.showDetail(id);
    }

    //日記の更新
    public void update(int id,String title, String detail) {
        repository.updateDiary(id,title,detail);
    }

    //日記の非表示
    public void hideDiary(String id) {
        repository.hideDiary(id);
    }

    //日記一覧表示
    public List<Diary> showDiary() {
        return repository.showDiary();
    }


}
