package com.example.jetpackroom;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    private WordDao wordDao;

    public WordRepository(Context context) {
        WordDatabase wordDatabase = WordDatabase.getworddatabase(context.getApplicationContext());
        wordDao = wordDatabase.getWordDao();
    }

    public LiveData<List<Word>> getAllwordsLive() {
        return wordDao.getAllWords();
    }

    void insertWord(Word... words){
        new InsertAsyncTask(wordDao).execute(words);
    }

    void updateWord(Word... words){
        new UpdateAsynTask(wordDao).execute(words);
    }

    void deleteWord(Word... words){
        new DeleteAsynTask(wordDao).execute(words);
    }

    void clearWords(){
        new ClearAsynTask(wordDao).execute();
    }

    static class InsertAsyncTask extends AsyncTask<Word, Void, Void>{
        private WordDao wordDao;

        public InsertAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.insertWord(words);
            return null;
        }
    }

    static class UpdateAsynTask extends AsyncTask<Word, Void, Void>{
        private WordDao wordDao;

        public UpdateAsynTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.updateWord(words);
            return null;
        }
    }

    static class DeleteAsynTask extends AsyncTask<Word, Void, Void>{
        private WordDao wordDao;

        public DeleteAsynTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.deleteWord(words);
            return null;
        }
    }

    static class ClearAsynTask extends AsyncTask<Void, Void, Void>{
        private WordDao wordDao;

        public ClearAsynTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            wordDao.deleteAllWords();
            return null;
        }
    }

}

