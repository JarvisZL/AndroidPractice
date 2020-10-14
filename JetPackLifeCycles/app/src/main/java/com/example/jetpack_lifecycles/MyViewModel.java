package com.example.jetpack_lifecycles;

import android.os.SystemClock;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Long> elapsedTimeOne;

    public MutableLiveData<Long> getElapsedTimeOne() {
        if(elapsedTimeOne == null){
            elapsedTimeOne = new MutableLiveData<>();
            elapsedTimeOne.setValue((long) 0);
        }
        return elapsedTimeOne;
    }

    public void setElapsedTimeOne(long elapsedTimeOne) {
        this.elapsedTimeOne.setValue(elapsedTimeOne);
    }
}
