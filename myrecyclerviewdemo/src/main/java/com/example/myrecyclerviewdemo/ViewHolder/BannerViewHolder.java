package com.example.myrecyclerviewdemo.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myrecyclerviewdemo.Bean.BannerBean;
import com.example.myrecyclerviewdemo.R;

public class BannerViewHolder extends BaseViewHolder {

    private TextView tv;

    public BannerViewHolder(@NonNull View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.item_main_title);
    }

    @Override
    public void bindViewData(Object data) {
        tv.setText(((BannerBean)data).name);
    }
}
