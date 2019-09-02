package com.example.myrecyclerviewdemo.ViewHolder;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;

import com.example.myrecyclerviewdemo.IndexActivity.ItemRecommedGridAdapter;
import com.example.myrecyclerviewdemo.IndexActivity.ItemSelectedMessageEvent;
import com.example.myrecyclerviewdemo.IndexActivity.RecommendBean;
import com.example.myrecyclerviewdemo.IndexActivity.RecommendGridClickListener;
import com.example.myrecyclerviewdemo.R;

import org.greenrobot.eventbus.EventBus;

public class IndexRecommendViewHolder extends BaseViewHolder {

    private GridView gridView;
    private Context context;
    private RecommendGridClickListener listener;
    ItemRecommedGridAdapter itemRecommedGridAdapter;

    public void setRecommendGridClickListener(RecommendGridClickListener listener) {
        this.listener = listener;
    }

    public IndexRecommendViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        gridView = itemView.findViewById(R.id.item_index_recommend_gv);
        this.context = context;
    }

    @Override
    public void bindViewData(Object data) {
        final RecommendBean bean = (RecommendBean) data;
        if (bean!=null){
            //创建适配器
            itemRecommedGridAdapter = new ItemRecommedGridAdapter(context,bean.getDatas());
            gridView.setAdapter(itemRecommedGridAdapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                    if (listener!=null){
//                        listener.onSelectedClock(bean.getDatas().get(i).id,bean.getDatas().get(i).name);
//                    }

                    ItemSelectedMessageEvent itemSelectedMessageEvent = new ItemSelectedMessageEvent();
                    itemSelectedMessageEvent.id = bean.getDatas().get(i).id;
                    itemSelectedMessageEvent.name = bean.getDatas().get(i).name;
                    //发布事件
                    EventBus.getDefault().post(itemSelectedMessageEvent);
                }
            });
        }
    }

    @Override
    public void bindViewData(Object data, Object type) {
        itemRecommedGridAdapter.notifyDataSetChanged();
    }
}
