package com.example.myrecyclerviewdemo.InterFace;

import android.view.View;

import com.example.myrecyclerviewdemo.Bean.BannerBean;
import com.example.myrecyclerviewdemo.Bean.ContentBean;
import com.example.myrecyclerviewdemo.IndexActivity.OptionBean;
import com.example.myrecyclerviewdemo.IndexActivity.RecommendBean;
import com.example.myrecyclerviewdemo.IndexActivity.TitleBean;
import com.example.myrecyclerviewdemo.ViewHolder.BaseViewHolder;

public interface TypeFactory {

    int type(BannerBean bannerBean);

    int type(ContentBean contentBean);

    int type(TitleBean TitleBean);

    int type(RecommendBean recommendBean);

    int type(OptionBean optionBean);

    BaseViewHolder createViewHolder(int type, View itemView);


}
