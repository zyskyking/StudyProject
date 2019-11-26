package com.example.myrecyclerviewdemo.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myrecyclerviewdemo.R;

public class itemAdapter extends BaseAdapter {

    private String[] datas;
    private Context context;

    public itemAdapter(Context context, String[] datas){
        this.datas = new String[]{"aaa","bbb","cccc","ddd","eee","ffff","gggg"};
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas.length;
    }

    @Override
    public Object getItem(int i) {
        return datas[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_gone_layout, viewGroup, false);
            ViewHolder2 holder = new ViewHolder2(view);
            view.setTag(holder);
        }
        if (view != null && view.getTag() instanceof ViewHolder2) {
            ViewHolder2 holder = (ViewHolder2)view.getTag();
            holder.textView.setText(datas[i]);
        }
        return view;
    }


    class ViewHolder2 {

        TextView textView;
        public ViewHolder2(View viewRoot) {
            textView = viewRoot.findViewById(R.id.item_item_tv);
        }
    }
}
