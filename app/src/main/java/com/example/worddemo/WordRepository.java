package com.example.worddemo;

import android.content.Context;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import java.util.List;

public class WordRepository {

    private LiveData<List<Word>> allWordsLive;
    private WordDao wordDao;

    public WordRepository(Context context) {
        WordDataBase wordDataBase = WordDataBase.getDataBase(context);
        wordDao = wordDataBase.getWordDao();
        allWordsLive = wordDao.getAllWordsLive();
    }

    public LiveData<List<Word>> getAllWordsLive() {
        return allWordsLive;
    }

    void InsertWords(Word... words) {
        new InsertAsyncTask(wordDao).execute(words);
    }

    void UpdateWords(Word... words) {
        new UpdateAsyncTask(wordDao).execute(words);
    }

    void DeleteWords(Word... words) {
        new DeleteAsyncTask(wordDao).execute(words);
    }

    void DeleteAllWords(Word... words) {
        new DeleteAllAsyncTask(wordDao).execute();
    }

    static class InsertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao wordDao;

        public InsertAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.InsertWords(words);
            return null;
        }
    }


    static class UpdateAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao wordDao;

        public UpdateAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.UpdateWords(words);
            return null;
        }

    }

    static class DeleteAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao wordDao;

        public DeleteAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.DeleteWords(words);
            return null;
        }

    }

    static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {

        private WordDao wordDao;

        public DeleteAllAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            wordDao.DeleteAllWords();
            return null;
        }

    }


}
