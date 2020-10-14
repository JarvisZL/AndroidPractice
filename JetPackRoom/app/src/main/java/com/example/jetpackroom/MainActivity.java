package com.example.jetpackroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private WordViewModel wordViewModel;
    TextView textView;
    Button buttonInsert, buttonUpdate, buttonDelete, buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordViewModel = new ViewModelProvider(this).get(WordViewModel.class);
        textView = findViewById(R.id.textView);

        wordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                final StringBuilder stringBuilder = new StringBuilder();
                words.forEach(item->
                {
                    stringBuilder.append(item.getId() + ": " + item.getName() + " = " + item.getCmean() + "\n");
                });
                textView.setText(stringBuilder.toString());
            }
        });

        buttonInsert = findViewById(R.id.buttonInsert);
        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonClear = findViewById(R.id.buttonClear);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word1 = new Word("Hello","嗨");
                Word word2 = new Word("World","世界");
                wordViewModel.insertWord(word1, word2);
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("Hello","你好");
                word.setId(3);
                wordViewModel.updateWord(word);
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("Hello","你好");
                word.setId(1);
                wordViewModel.deleteWord(word);
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wordViewModel.clearWords();
            }
        });

    }
}