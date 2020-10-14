package com.example.jetpackroom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Word {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "English_word")
    private String Name;
    @ColumnInfo(name = "Chinese_meaning")
    private String Cmean;


    public Word(String Name, String Cmean) {
        this.Name = Name;
        this.Cmean = Cmean;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getCmean() {
        return Cmean;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCmean(String cmean) {
        Cmean = cmean;
    }
}
