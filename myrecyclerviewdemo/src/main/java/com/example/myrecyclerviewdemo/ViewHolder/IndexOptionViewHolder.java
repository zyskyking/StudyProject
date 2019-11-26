package com.example.myrecyclerviewdemo.ViewHolder;

import android.content.Context;
import android.view.View;
import android.widget.GridView;
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
    private GridView item_option_gv;
    private LinearLayout item_option_lLayout;

    private Context context;

    public IndexOptionViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        this.context = context;
        titleTv = itemView.findViewById(R.id.item_option_title);
        contentTv = itemView.findViewById(R.id.item_option_content);
        item_option_gv = itemView.findViewById(R.id.item_option_gv);
        item_option_lLayout = itemView.findViewById(R.id.item_option_lLayout);
    }

    @Override
    public void bindViewData(Object data) {
        if (data!=null){
            final OptionBean bean = (OptionBean) data;
            titleTv.setText(bean.getTag()+"");
            contentTv.setText(bean.getName());
            itemAdapter itemAdapter = new itemAdapter(context, null);
            item_option_gv.setAdapter(itemAdapter);
            item_option_lLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //展开 或隐藏

                    if (item_option_gv.getVisibility()==View.GONE){
                        item_option_gv.setVisibility(View.VISIBLE);
                    }else{
                        item_option_gv.setVisibility(View.GONE);
                    }
//                    ItemSelectedMessageEvent itemSelectedMessageEvent = new ItemSelectedMessageEvent();
//                    itemSelectedMessageEvent.id = bean.getTag();
//                    itemSelectedMessageEvent.name = bean.getName();
//                    EventBus.getDefault().post(itemSelectedMessageEvent);
                }
            });
        }
    }

    @Override
    public void bindViewData(Object data, Object type) {
        OptionBean bean = (OptionBean) data;
        titleTv.setText(bean.getTag()+"");
        contentTv.setText(bean.getName());
    }
}
