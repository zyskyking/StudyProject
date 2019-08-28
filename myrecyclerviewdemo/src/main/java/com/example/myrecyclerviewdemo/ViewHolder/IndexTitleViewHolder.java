package com.example.myrecyclerviewdemo.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myrecyclerviewdemo.IndexActivity.TitleBean;
import com.example.myrecyclerviewdemo.R;

public class IndexTitleViewHolder extends BaseViewHolder {

    private TextView tv;

    public IndexTitleViewHolder(@NonNull View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.item_index_title_layout_tv);
    }

    @Override
    public void bindViewData(Object data) {
        TitleBean titleBean = (TitleBean) data;
        if (titleBean!=null){
            tv.setText(titleBean.title);
        }

    }
}
