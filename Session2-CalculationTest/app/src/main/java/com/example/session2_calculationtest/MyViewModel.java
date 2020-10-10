package com.example.session2_calculationtest;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import java.util.Random;

public class MyViewModel extends AndroidViewModel {
    private SavedStateHandle handle;
    public boolean win_flag = false;

    public MyViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        if(!handle.contains(getApplication().getString(R.string.Key_Highest_score))){
            SharedPreferences shp = getApplication().
                    getSharedPreferences(getApplication().getString(R.string.SHP_Name), Context.MODE_PRIVATE);
            handle.set(getApplication().getString(R.string.Key_Highest_score),
                    shp.getInt(getApplication().getString(R.string.Key_Highest_score),0));
            handle.set(getApplication().getString(R.string.Key_Current_score), 0);
            handle.set(getApplication().getString(R.string.Key_Left_Num),0);
            handle.set(getApplication().getString(R.string.Key_Operator),"+");
            handle.set(getApplication().getString(R.string.Key_Right_Num),0);
            handle.set(getApplication().getString(R.string.Key_Answer),0);
        }
        this.handle = handle;
    }

    public MutableLiveData<Integer> getHighestScore(){
        return handle.getLiveData(getApplication().getString(R.string.Key_Highest_score));
    }

    public MutableLiveData<Integer> getCurrentScore(){
        return handle.getLiveData(getApplication().getString(R.string.Key_Current_score));
    }

    public MutableLiveData<Integer> getLeftNum(){
        return handle.getLiveData(getApplication().getString(R.string.Key_Left_Num));
    }

    public MutableLiveData<String> getOperator(){
        return handle.getLiveData(getApplication().getString(R.string.Key_Operator));
    }

    public MutableLiveData<Integer> getRightNum(){
        return handle.getLiveData(getApplication().getString(R.string.Key_Right_Num));
    }

    public MutableLiveData<Integer> getAnswer(){
        return handle.getLiveData(getApplication().getString(R.string.Key_Answer));
    }

    @SuppressWarnings("ConstantConditions")
    public void SaveShp(){
        SharedPreferences shp = getApplication().
                getSharedPreferences(getApplication().getString(R.string.SHP_Name),Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putInt(getApplication().getString(R.string.Key_Highest_score), getHighestScore().getValue());
        editor.apply();
    }

    public void Generate(){
        final int LEVEL = 100;
        Random random = new Random();
        int x,y;
        x = random.nextInt(LEVEL + 1);
        y = random.nextInt(LEVEL + 1);
        if(x % 2 == 0){
            //means +
            if(x > y){
                getLeftNum().setValue(y);
                getRightNum().setValue(x - y);
                getAnswer().setValue(x);
            }
            else{
                getLeftNum().setValue(x);
                getRightNum().setValue(y - x);
                getAnswer().setValue(y);
            }
            getOperator().setValue("+");
        }
        else{
            //means -
            if(x > y){
                getLeftNum().setValue(x);
                getRightNum().setValue(y);
                getAnswer().setValue(x - y);
            }
            else{
                getLeftNum().setValue(y);
                getRightNum().setValue(x);
                getAnswer().setValue(y - x);
            }
            getOperator().setValue("-");
        }
    }

    void AnswerCorrect(){
        getCurrentScore().setValue(getCurrentScore().getValue() + 1);
        if(getCurrentScore().getValue() > getHighestScore().getValue()){
            getHighestScore().setValue(getCurrentScore().getValue());
            win_flag = true;
        }
        Generate();
    }

}
