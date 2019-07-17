package com.example.mycardviewpager.View;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;


public class CareViewPagerTransformer implements ViewPager.PageTransformer {

    private float MAX_SCALE = 1.0f;
    private float MIN_SCALE = 0.85f;

    @Override
    public void transformPage(@NonNull View page, float position) {
        //设置了内间距  有0.15的偏差
        float pos = position - 0.15F;

        if (pos <= 1) {
            float scaleFactor = MIN_SCALE + (1 - Math.abs(pos)) * (MAX_SCALE - MIN_SCALE);

            page.setScaleX(scaleFactor); //缩放效果
            if (pos > 0) {
                page.setTranslationX(-scaleFactor * 2);
            } else if (pos < 0 && pos > -1) {
                page.setTranslationX(scaleFactor * 2);
            }
            page.setScaleY(scaleFactor);


        } else {
            page.setScaleX(MIN_SCALE);
            page.setScaleY(MIN_SCALE);
        }
    }
}
