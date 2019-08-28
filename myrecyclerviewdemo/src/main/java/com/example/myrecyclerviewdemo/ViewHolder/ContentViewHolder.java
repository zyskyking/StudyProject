package com.example.myrecyclerviewdemo.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myrecyclerviewdemo.Bean.ContentBean;
import com.example.myrecyclerviewdemo.R;
import com.example.myrecyclerviewdemo.ViewHolder.BaseViewHolder;

public class ContentViewHolder extends BaseViewHolder {

    private TextView tv;

    public ContentViewHolder(@NonNull View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.item_main_title2);
    }

    @Override
    public void bindViewData(Object data) {
        tv.setText(((ContentBean)data).name);
    }
}
