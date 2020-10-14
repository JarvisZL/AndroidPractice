package com.example.jetpackroom;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


public class WordViewModel extends AndroidViewModel {
    private WordRepository wordRepository;


    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository = new WordRepository(application);
    }

    LiveData<List<Word>> getAllWords(){
        return wordRepository.getAllwordsLive();
    }

    void insertWord(Word... words){
        wordRepository.insertWord(words);
    }

    void updateWord(Word... words){
        wordRepository.updateWord(words);
    }

    void deleteWord(Word... words){
        wordRepository.deleteWord(words);
    }

    void clearWords(){
        wordRepository.clearWords();
    }
}
