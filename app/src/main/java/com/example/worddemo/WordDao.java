package com.example.worddemo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WordDao {
    @Insert
    void InsertWords(Word... words);

    @Update
    void UpdateWords(Word... words);

    @Delete
    void DeleteWords(Word... words);

    @Query("DELETE FROM WORD")
    void DeleteAllWords();

    @Query("SELECT * FROM WORD ORDER BY ID DESC")
    LiveData<List<Word>> getAllWordsLive();//使用LiveData改写

}
