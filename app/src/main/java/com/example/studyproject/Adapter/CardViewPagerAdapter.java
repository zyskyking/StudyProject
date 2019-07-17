package com.example.studyproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.studyproject.R;

public class CardViewPagerAdapter extends PagerAdapter {
    //模拟数据
    private int[] horoscopestrImgs = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    private Context mContext;
    public CardViewPagerAdapter(Context context){
        this.mContext = context;
    }
    
    @Override
    public int getCount() {
        return 12*30;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_viewpager_main, null);

        ImageView viewById = inflate.findViewById(R.id.item_viewpager_main_iv);
        viewById.setImageResource(horoscopestrImgs[position%12]);

        container.addView(inflate);
        return inflate;
    }
}
