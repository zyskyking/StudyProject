package com.example.myrecyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.myrecyclerviewdemo.Bean.BannerBean;
import com.example.myrecyclerviewdemo.Bean.ContentBean;
import com.example.myrecyclerviewdemo.InterFace.IItemBeanVisiable;
import com.example.myrecyclerviewdemo.adapter.MulitAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initEvent();
    }

    private void initEvent() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (mShouldScroll) {
                    mShouldScroll = false;
                    smoothMoveToPosition(recyclerView, mToPosition);
                }
            }
        });
    }

    private void initData() {
        List<Data> datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Data data = new Data();
            data.name = "第"+i+"个数据";
            data.id = i;
            datas.add(data);
        }

        List<IItemBeanVisiable> beans = new ArrayList<>();
        beans.add(new BannerBean("www.baidu.com0000",1));
        beans.add(new BannerBean("www.jd.com111111",1));
        beans.add(new ContentBean("www.baidu.com22222222",1));
        beans.add(new BannerBean("www.qq.com333333",1));
        beans.add(new BannerBean("www.sina.co4444444444",1));
        beans.add(new ContentBean("www.taobao.com555555555",1));
        beans.add(new BannerBean("www.google.com666666666",1));
        beans.add(new ContentBean("www.facebook.com77777777777",1));
        beans.add(new BannerBean("www.youtube.com8888888888",1));
        beans.add(new BannerBean("www.apple.com999999999",1));
        beans.add(new BannerBean("www.yahoo.comAAAAAAAAA",1));
        beans.add(new ContentBean("www.azmasinc.comBBBBBBBBBBB",1));
        beans.add(new BannerBean("www.weibo.comCCCCCCCCCCCCC",1));
        beans.add(new BannerBean("www.weibo.comDDDDDDDDDDDDD",1));
        beans.add(new BannerBean("www.weibo.comEEEEEEEEEEE",1));
        beans.add(new BannerBean("www.weibo.comFFFFFFFFFFFFFF",1));
        beans.add(new BannerBean("www.weibo.comGGGGGGGGGGGGG",1));
        beans.add(new BannerBean("www.weibo.comHHHHHHHHHHHH",1));
        beans.add(new BannerBean("www.weibo.comiIIIIIIIIIIIII",1));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MulitAdapter mulitAdapter = new MulitAdapter(beans,this);
        recyclerView.setAdapter(mulitAdapter);
//        recyclerView.setAdapter(new MyAdapter(this,datas));
    }

    private void initView() {
        recyclerView = findViewById(R.id.main_recycler);
    }


    /**
     * 目标项是否在最后一个可见项之后
     */
    private boolean mShouldScroll;
    /**
     * 记录目标项位置
     */
    private int mToPosition;


    private void smoothMoveToPosition(RecyclerView recyclerView,int position){
        int firstNum = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(0));
        int lastNum = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(recyclerView.getChildCount() - 1));

        if (position < firstNum) {
            // 如果跳转位置在第一个可见位置之前，就smoothScrollToPosition可以直接跳转
            recyclerView.smoothScrollToPosition(position);
        } else if (position <= lastNum) {
            // 跳转位置在第一个可见项之后，最后一个可见项之前
            // smoothScrollToPosition根本不会动，此时调用smoothScrollBy来滑动到指定位置
            int movePosition = position - firstNum;
            if (movePosition >= 0 && movePosition < recyclerView.getChildCount()) {
                int top = recyclerView.getChildAt(movePosition).getTop();
                recyclerView.smoothScrollBy(0, top);
            }
        } else {
            // 如果要跳转的位置在最后可见项之后，则先调用smoothScrollToPosition将要跳转的位置滚动到可见位置
            // 再通过onScrollStateChanged控制再次调用smoothMoveToPosition，执行上一个判断中的方法
            recyclerView.smoothScrollToPosition(position);
            mToPosition = position;
            mShouldScroll = true;
        }
    }


    public void moveRe(View view) {
        smoothMoveToPosition(recyclerView,7);
    }
}
