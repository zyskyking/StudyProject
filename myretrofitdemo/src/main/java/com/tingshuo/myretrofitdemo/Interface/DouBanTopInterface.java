package com.tingshuo.myretrofitdemo.Interface;

import com.tingshuo.myretrofitdemo.enter.TopBean;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DouBanTopInterface {
    //https://douban.uieee.com/v2/movie/in_theaters?start=0&count=20

    public static final String BaseUrl = "https://douban.uieee.com/v2/movie/";

    @GET("in_theaters")
    Call<TopBean> getTop(@Query("start") String start, @Query("count") String count);
}
