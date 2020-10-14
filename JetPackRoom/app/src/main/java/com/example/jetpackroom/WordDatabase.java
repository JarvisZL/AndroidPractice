package com.example.jetpackroom;

import android.content.Context;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {
    private static WordDatabase INSTACE;
    static synchronized WordDatabase getworddatabase(Context context){
        if(INSTACE == null){
            INSTACE = Room.databaseBuilder(context, WordDatabase.class, "Word_Database")
                    .build();
        }
        return INSTACE;
    }

    public abstract WordDao getWordDao();
}
