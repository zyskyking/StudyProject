package com.example.myrecyclerviewdemo.ViewHolder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myrecyclerviewdemo.IndexActivity.ItemSelectedMessageEvent;
import com.example.myrecyclerviewdemo.IndexActivity.OptionBean;
import com.example.myrecyclerviewdemo.R;

import org.greenrobot.eventbus.EventBus;
import org.w3c.dom.Text;

public class IndexOptionViewHolder extends BaseViewHolder{

    private TextView titleTv;
    private TextView contentTv;
    private LinearLayout item_option_lLayout;

    public IndexOptionViewHolder(@NonNull View itemView) {
        super(itemView);

        titleTv = itemView.findViewById(R.id.item_option_title);
        contentTv = itemView.findViewById(R.id.item_option_content);
        item_option_lLayout = itemView.findViewById(R.id.item_option_lLayout);
    }

    @Override
    public void bindViewData(Object data) {
        if (data!=null){
            final OptionBean bean = (OptionBean) data;
            titleTv.setText(bean.getTag()+"");
            contentTv.setText(bean.getName());
            item_option_lLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ItemSelectedMessageEvent itemSelectedMessageEvent = new ItemSelectedMessageEvent();
                    itemSelectedMessageEvent.id = bean.getTag();
                    itemSelectedMessageEvent.name = bean.getName();
                    EventBus.getDefault().post(itemSelectedMessageEvent);
                }
            });
        }
    }
}
