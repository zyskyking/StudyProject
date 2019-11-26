package com.example.gridviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class Adapter extends BaseAdapter {

    private boolean[] datas;
    private Context context;

    public Adapter(Context context, boolean[] datas){
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas==null?0:datas.length;
    }

    @Override
    public Object getItem(int i) {
        return datas==null?null:datas[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_gridview, viewGroup, false);
//            View inflate = View.inflate(context, R.layout.item_gridview, null);
            ViewHolder holder = new ViewHolder(view);
            view.setTag(holder);
        }
        if (view != null && view.getTag() instanceof ViewHolder) {
            ViewHolder holder = (ViewHolder)view.getTag();
            holder.tv.setText(i+"个");
            itemAdapter itemAdapter = new itemAdapter(context,null);
            holder.gv.setAdapter(itemAdapter);


            if (datas[i]){
                holder.gv.setVisibility(View.VISIBLE);
            }else{
                holder.gv.setVisibility(View.GONE);
            }
        }



        return view;
    }

     class ViewHolder {

        TextView tv;
        GridView gv;
            public ViewHolder(View viewRoot) {
                tv = viewRoot.findViewById(R.id.item_title);
                gv = viewRoot.findViewById(R.id.item_gridview);
            }
        }
}
