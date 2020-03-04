package com.tingshuo.myretrofitdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tingshuo.myretrofitdemo.Interface.Lifeful;
import com.tingshuo.myretrofitdemo.RetrofitUtils.DouBanRetrofit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements Lifeful {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.main_request_tv)
    TextView mainRequestTv;
    @BindView(R.id.main_request_iv)
    ImageView mainRequestIv;
    @BindView(R.id.main_request_rv)
    RecyclerView mainRequestRv;

    private String baseUrl = "http://api.waiyutong.org/Studenttool/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        mainRequestRv.setLayoutManager(new LinearLayoutManager(this));
    }


    @OnClick({R.id.main_request_tv, R.id.main_request_iv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_request_tv:
                break;
            case R.id.main_request_iv:
                DouBanRetrofit douBanRetrofit = new DouBanRetrofit();
                douBanRetrofit.getTopInfo(this);
                break;
        }
    }

    @Override
    public boolean isAlive() {
        return activityIsAlive();
    }

    private boolean activityIsAlive() {

        return false;
    }
}
