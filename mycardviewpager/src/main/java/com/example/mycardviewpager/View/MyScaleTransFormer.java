package com.example.mycardviewpager.View;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class MyScaleTransFormer implements ViewPager.PageTransformer{


    private static final String TAG = MyScaleTransFormer.class.getSimpleName();

    @Override
    public void transformPage(@NonNull View page, float position) {
        Log.d(TAG, "transformPage() called with: page = [" + page + "], position = [" + position + "]");
        if (Math.abs(position)>1){
            page.setScaleX(0.7F);
            page.setScaleY(0.7F);
        }else{
            if (position<0){
                //右滑
                float scaleX = 1 + 0.3f * position;
                page.setScaleX(scaleX);
                page.setScaleY(scaleX);
            }else{
                //左滑
                float scaleX = 1 - 0.3f * position;
                page.setScaleX(scaleX);
                page.setScaleY(scaleX);

            }
        }
    }
}
