package com.example.myrecyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myrecyclerviewdemo.View.IndexView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        IndexView iv = findViewById(R.id.myview);
        String[] strings = new String[28];
        strings[0] = "选择";
        strings[1] = "推荐";
        for (int i = 2; i < 28; i++) {
            strings[i] = String.valueOf((char)(65+i-2));
        }

        iv.setmLetters(strings);
    }
}
