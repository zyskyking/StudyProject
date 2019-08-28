package com.example.myrecyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private static final String TAG = MyAdapter.class.getSimpleName();

    private List<Data> datas;
    private Context mContext;


    public MyAdapter(Context context,List<Data> datas){
        this.mContext = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_main_rv,parent,false));
        } else {
            return new MyViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.item_main_rv2,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.titleView.setText(datas.get(position).name);
    }

    @Override
    public int getItemCount() {
        return datas==null?0:datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2==0){
            return 0;
        }else{
            return 1;
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titleView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.item_main_title);
        }
    }

    public static class MyViewHolder2 extends MyViewHolder{

        TextView titleView;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.item_main_title2);
        }
    }
}
