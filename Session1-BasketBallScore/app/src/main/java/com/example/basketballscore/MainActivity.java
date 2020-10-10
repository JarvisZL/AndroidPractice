package com.example.basketballscore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.basketballscore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MyViewModel myViewModel;
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        mainBinding.setData(myViewModel);
        mainBinding.setLifecycleOwner(this);

    }
}