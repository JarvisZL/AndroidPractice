package com.example.jetpack_lifecycles;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Chronometer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class Mychronometer extends Chronometer implements LifecycleObserver {

    public Mychronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void ElapsedTimeSave(){
        MainActivity.myViewModel.
                setElapsedTimeOne(SystemClock.elapsedRealtime() - getBase());
        stop();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void ElapsedTimeload(){
        setBase(SystemClock.elapsedRealtime() - MainActivity.myViewModel.getElapsedTimeOne().getValue());
        start();
    }

}
