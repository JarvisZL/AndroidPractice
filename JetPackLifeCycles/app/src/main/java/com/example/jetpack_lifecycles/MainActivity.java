package com.example.jetpack_lifecycles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static MyViewModel myViewModel;
    Mychronometer mychronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        mychronometer = findViewById(R.id.meter);
        getLifecycle().addObserver(mychronometer);
    }
}