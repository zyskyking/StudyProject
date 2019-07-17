package com.example.studyproject.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.studyproject.Adapter.CardViewPagerAdapter;
import com.example.studyproject.Adapter.MyFragmentPagerAdapter;
import com.example.studyproject.Adapter.MyPagerAdapter;
import com.example.studyproject.Fragment.FragmentFour;
import com.example.studyproject.Fragment.FragmentOne;
import com.example.studyproject.Fragment.FragmentThree;
import com.example.studyproject.Fragment.FragmentTwo;
import com.example.studyproject.Fragment.LogFragment;
import com.example.studyproject.R;
import com.example.studyproject.View.CareViewPagerTransformer;
import com.example.studyproject.View.MyScaleTransFormer;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.main_message_tv)
    TextView mainMessageTv;
    @Bind(R.id.main_message_btn)
    Button mainMessageBtn;
    @Bind(R.id.main_viewpager)
    ViewPager mainViewpager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);




    }



    @OnClick({R.id.main_message_tv, R.id.main_message_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_message_tv:
                break;
            case R.id.main_message_btn: {
                Snackbar.make(view, "主界面", Snackbar.LENGTH_SHORT).show();
                break;
            }
        }
    }

}
