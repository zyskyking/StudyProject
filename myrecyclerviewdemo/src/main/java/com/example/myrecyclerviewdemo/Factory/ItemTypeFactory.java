package com.example.myrecyclerviewdemo.Factory;

import android.content.Context;
import android.view.View;

import com.example.myrecyclerviewdemo.Bean.BannerBean;
import com.example.myrecyclerviewdemo.Bean.ContentBean;
import com.example.myrecyclerviewdemo.IndexActivity.OptionBean;
import com.example.myrecyclerviewdemo.IndexActivity.RecommendBean;
import com.example.myrecyclerviewdemo.IndexActivity.RecommendGridClickListener;
import com.example.myrecyclerviewdemo.IndexActivity.TitleBean;
import com.example.myrecyclerviewdemo.R;
import com.example.myrecyclerviewdemo.InterFace.TypeFactory;
import com.example.myrecyclerviewdemo.ViewHolder.BannerViewHolder;
import com.example.myrecyclerviewdemo.ViewHolder.BaseViewHolder;
import com.example.myrecyclerviewdemo.ViewHolder.ContentViewHolder;
import com.example.myrecyclerviewdemo.ViewHolder.IndexOptionViewHolder;
import com.example.myrecyclerviewdemo.ViewHolder.IndexRecommendViewHolder;
import com.example.myrecyclerviewdemo.ViewHolder.IndexTitleViewHolder;

public class ItemTypeFactory implements TypeFactory, RecommendGridClickListener {

    //  将id作为type传入adapter
    public static final int main_rv1 = R.layout.item_main_rv;
    public static final int main_rv2 = R.layout.item_main_rv2;
    public static final int third_index_title = R.layout.item_index_title_layout;
    public static final int third_recommend_layout = R.layout.item_index_recommend_layout;
    public static final int third_option_layout = R.layout.item_option_layout;

    private Context context;

    public ItemTypeFactory(Context context) {
        this.context = context;
    }

    @Override
    public int type(BannerBean bannerBean) {
        return main_rv1;
    }

    @Override
    public int type(ContentBean contentBean) {
        return main_rv2;
    }

    @Override
    public int type(TitleBean TitleBean) {
        return third_index_title;
    }

    @Override
    public int type(RecommendBean recommendBean) {
        return third_recommend_layout;
    }

    @Override
    public int type(OptionBean optionBean) {
        return third_option_layout;
    }

    @Override
    public BaseViewHolder createViewHolder(int type, View itemView) {
        switch (type){
            case main_rv1:{
                return new BannerViewHolder(itemView);
            }
            case main_rv2:{
                return new ContentViewHolder(itemView);
            }
            case third_index_title:{
                return new IndexTitleViewHolder(itemView);
            }
            case third_recommend_layout:{
                IndexRecommendViewHolder indexRecommendViewHolder = new IndexRecommendViewHolder(itemView, context);
                indexRecommendViewHolder.setRecommendGridClickListener(this);
                return indexRecommendViewHolder;
            }
            case third_option_layout:{
                return new IndexOptionViewHolder(itemView);
            }
            default:{
                return null;
            }
        }
    }

    @Override
    public void onSelectedClock(int id, String name) {

    }
}
