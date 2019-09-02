package com.example.myrecyclerviewdemo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrecyclerviewdemo.ViewHolder.BaseViewHolder;
import com.example.myrecyclerviewdemo.InterFace.IItemBeanVisiable;
import com.example.myrecyclerviewdemo.Factory.ItemTypeFactory;

import java.util.List;

public class MulitAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final String TAG =MulitAdapter.class.getSimpleName() ;
    private ItemTypeFactory typeFactory;
    List<IItemBeanVisiable> datas;

    public MulitAdapter(List<IItemBeanVisiable> mData, Context context) {
        //  item工厂类 生产viewholder
        this.typeFactory = new ItemTypeFactory(context);
        datas=mData;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent,false);
        return typeFactory.createViewHolder(viewType,view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bindViewData(datas.get(position));

    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position, @NonNull List<Object> payloads) {
        if (payloads.isEmpty()){
            this.onBindViewHolder(holder,position);
        }else{
            Log.i(TAG, "onBindViewHolder: ");
            holder.bindViewData(datas.get(position),payloads.get(0));
        }
    }

    @Override
    public int getItemViewType(int position) {
        return datas.get(position).type(typeFactory);
    }

    @Override
    public int getItemCount() {
        return datas==null ? 0:datas.size();
    }

}
