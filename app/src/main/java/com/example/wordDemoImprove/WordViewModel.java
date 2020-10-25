package com.example.wordDemoImprove;

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

    LiveData<List<Word>> getAllWordsLive() {
        return wordRepository.getAllWordsLive();
    }

    LiveData<List<Word>> findWordWithPattern(String pattern) {
        return wordRepository.findWordWithPattern(pattern);
    }

    void InsertWords(Word... words) {
        wordRepository.InsertWords(words);
    }

    void UpdateWords(Word... words) {
        wordRepository.UpdateWords(words);
    }

    void DeleteWords(Word... words) {
        wordRepository.DeleteWords(words);
    }

    void DeleteAllWords() {
        wordRepository.DeleteAllWords();
    }

}
