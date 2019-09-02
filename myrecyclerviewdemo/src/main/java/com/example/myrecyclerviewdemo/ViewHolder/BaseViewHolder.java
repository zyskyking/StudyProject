package com.example.myrecyclerviewdemo.ViewHolder;

import android.util.SparseArray;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    private View mItemView;
    SparseArray<View> views;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        mItemView = itemView;
        views = new SparseArray<>();
    }

    public View getViews(int resId){
        View view = views.get(resId);
        if (view!=null){
            view = mItemView;
            views.put(resId,mItemView);
        }
        return view;
    }

    public abstract void bindViewData(T data);

    public abstract void bindViewData(T data,Object type);
}
