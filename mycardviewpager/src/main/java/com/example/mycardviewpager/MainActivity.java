package com.example.mycardviewpager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.mycardviewpager.Adapter.MyPagerAdapter;
import com.example.mycardviewpager.View.MyScaleTransFormer;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

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

        initViewPager();
    }

    private void initViewPager() {
//        ArrayList<Fragment> list = new ArrayList<>();
//        list.add(new FragmentOne());
//        list.add(new FragmentTwo());
//        list.add(new FragmentThree());
//        list.add(new FragmentFour());
//        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), list);
//        mainViewpager.setPageMargin(80);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.mipmap.aaa);
        list.add(R.mipmap.bbb);
        list.add(R.mipmap.ccc);
        list.add(R.mipmap.eee);
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(this, list);
        mainViewpager.setAdapter(myPagerAdapter);
        mainViewpager.setPageTransformer(false, new MyScaleTransFormer());
    }

    @OnClick({R.id.main_message_tv, R.id.main_message_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_message_tv:
                break;
            case R.id.main_message_btn:
                break;
        }
    }
}
