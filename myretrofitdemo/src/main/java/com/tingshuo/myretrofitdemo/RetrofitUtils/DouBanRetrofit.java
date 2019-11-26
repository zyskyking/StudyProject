package com.tingshuo.myretrofitdemo.RetrofitUtils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.tingshuo.myretrofitdemo.Interface.DouBanTopInterface;
import com.tingshuo.myretrofitdemo.enter.TopBean;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DouBanRetrofit {

    private static final String TAG = DouBanRetrofit.class.getSimpleName();

    public void getTopInfo(Context context){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DouBanTopInterface.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build();

        DouBanTopInterface douBanTopInterface = retrofit.create(DouBanTopInterface.class);

        Call<TopBean> top = douBanTopInterface.getTop("0", "10");

        top.enqueue(new Callback<TopBean>() {
            @Override
            public void onResponse(Call<TopBean> call, Response<TopBean> response) {
                List<TopBean.subjectsBean> subjects = response.body().getSubjects();
                String title = subjects.get(0).getTitle();
                Toast.makeText(context, title, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<TopBean> call, Throwable t) {

            }
        });


    }
}
