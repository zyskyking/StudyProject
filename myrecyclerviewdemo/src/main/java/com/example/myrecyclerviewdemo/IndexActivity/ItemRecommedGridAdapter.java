package com.example.myrecyclerviewdemo.IndexActivity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myrecyclerviewdemo.R;

import java.util.List;

public class ItemRecommedGridAdapter extends BaseAdapter {

    private List<SelectedBean> datas;
    private LayoutInflater layoutInflater;


    public ItemRecommedGridAdapter(Context context, List<SelectedBean> datas){
        this.datas = datas;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas==null?0:datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas==null?0:datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        itemViewHolder holder =null;
        if (view==null){
            view  = layoutInflater.inflate(R.layout.item_recommend_grid_item, null);
            holder = new itemViewHolder();
            holder.tv = view.findViewById(R.id.item_recommend_grid_item_title);
            view.setTag(holder);
        }else{
            holder = (itemViewHolder) view.getTag();
        }
        //设置名称
        holder.tv.setText(datas.get(i).name);
        //设置选中状态
        if (datas.get(i).isSelected){
            //如果选中
            holder.tv.setBackgroundResource(R.drawable.shape_item_recommed_grid_btn_bg);
        }else{
            holder.tv.setBackgroundResource(R.drawable.grid_item_shape);
        }

        return view;
    }

    class itemViewHolder{
        TextView tv;
    }
}
