package com.example.mvpdemo.model;

import com.example.mvpdemo.entity.UrlString;
import com.example.mvpdemo.presenter.IGetDataPersenter;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class weatherDataModel implements IGetDataModel {

    private IGetDataPersenter persenter;
    OkHttpClient okHttpClient;
    public weatherDataModel(IGetDataPersenter persenter){
        this.persenter = persenter;
        okHttpClient = new OkHttpClient();
    }

    @Override
    public void getData(String url) {

        Request build = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(build);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                persenter.doFail();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                persenter.doSuccess(response.body().string());
            }
        });
    }
}
