package com.example.studyproject.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyPagerAdapter extends PagerAdapter {

    private static final String TAG = MyPagerAdapter.class.getSimpleName();
    private List<Integer> list ;
    private Context context;
    private List<View> views;

    public MyPagerAdapter(Context context,List<View> views) {
        this.views = views;
        this.context = context;
    }

    public MyPagerAdapter(Context context, ArrayList<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView iv = new ImageView(context);
        iv.setImageResource(list.get(position));
        iv.setLayoutParams(new ViewGroup.LayoutParams(200,200));
        container.addView(iv);

        Log.d(TAG, "instantiateItem() called with: container = [" + container + "], position = [" + position + "]");
        return iv;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
