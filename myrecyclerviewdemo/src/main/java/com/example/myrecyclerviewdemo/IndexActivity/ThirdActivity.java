package com.example.myrecyclerviewdemo.IndexActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.myrecyclerviewdemo.Bean.BannerBean;
import com.example.myrecyclerviewdemo.Bean.ContentBean;
import com.example.myrecyclerviewdemo.InterFace.IItemBeanVisiable;
import com.example.myrecyclerviewdemo.InterFace.IndexViewTouchCallBack;
import com.example.myrecyclerviewdemo.R;
import com.example.myrecyclerviewdemo.View.IndexView;
import com.example.myrecyclerviewdemo.adapter.MulitAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    private static final String TAG = ThirdActivity.class.getSimpleName();

    private RecyclerView recyclerView;
    private IndexView indexView;
    MulitAdapter mulitAdapter;

    /**
     * 目标项是否在最后一个可见项之后
     */
    private boolean mShouldScroll;
    /**
     * 记录目标项位置
     */
    private int mToPosition;
    List<IItemBeanVisiable> beans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
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

        indexView.setTouchCallBack(new IndexViewTouchCallBack() {
            @Override
            public void onTouchChanged(int position, String content) {
                int moveToPositon = 0;

                if (beans!=null){
                    for (int i = 0; i < beans.size(); i++) {
                        IItemBeanVisiable iItemBeanVisiable = beans.get(i);
                        int tag = iItemBeanVisiable.getTag();

                        //如果相同 则直接专挑
                        if (position==tag){
                            moveToPositon = i;
                            Log.i(TAG, "onTouchChanged: 转跳到："+i);
                            break;
                        }else if (position<tag){
                            break;
                        }else{
                            moveToPositon = i;
                        }
                    }
                }
                smoothMoveToPosition(recyclerView,moveToPositon);

            }
        });
    }

    private void initData() {

        String[] strings = new String[28];
        strings[0] = "选择";
        strings[1] = "推荐";
        for (int i = 2; i < 28; i++) {
            strings[i] = String.valueOf((char)(65+i-2));
        }
        indexView.setmLetters(strings);


        List<SelectedBean> RecommendBeanDatas = new ArrayList<>();
        RecommendBeanDatas.add(new SelectedBean(1,"AAA",true));


        List<SelectedBean> RecommendBean2Datas = new ArrayList<>();
        RecommendBean2Datas.add(new SelectedBean(2,"BBBB",false));
        RecommendBean2Datas.add(new SelectedBean(3,"CCCC",false));
        RecommendBean2Datas.add(new SelectedBean(4,"DDDD",false));
        RecommendBean2Datas.add(new SelectedBean(5,"EEEE",false));


        beans = new ArrayList<>();
        beans.add(new TitleBean("当前选择",0));
        beans.add(new RecommendBean(RecommendBeanDatas));
        beans.add(new TitleBean("推荐版本",1));
        beans.add(new RecommendBean(RecommendBean2Datas));
        beans.add(new TitleBean("选择适用地区",0));
        beans.add(new OptionBean("安徽版",2));
        beans.add(new OptionBean("澳门特别行政区",2));
        beans.add(new OptionBean("北京市",3));
        beans.add(new OptionBean("重庆市",4));
        beans.add(new OptionBean("福建省",7));
        beans.add(new OptionBean("甘肃省",8));
        beans.add(new OptionBean("广东省",8));
        beans.add(new OptionBean("广西壮族自治区",8));
        beans.add(new OptionBean("贵州省",8));
        beans.add(new OptionBean("海南省",9));
        beans.add(new OptionBean("河北省",9));
        beans.add(new OptionBean("黑龙江省",9));
        beans.add(new OptionBean("河南省",9));
        beans.add(new OptionBean("湖北省",9));
        beans.add(new OptionBean("湖南省",9));
        beans.add(new OptionBean("江苏省",11));
        beans.add(new OptionBean("江西省",11));
        beans.add(new OptionBean("辽宁省",13));
        beans.add(new OptionBean("内蒙古",13));
        beans.add(new OptionBean("宁夏回族",13));
        beans.add(new OptionBean("青海省",18));
        beans.add(new OptionBean("山东省",20));
        beans.add(new OptionBean("山西省",20));
        beans.add(new OptionBean("陕西省",20));
        beans.add(new OptionBean("上海市",20));
        beans.add(new OptionBean("四川省",20));
        beans.add(new OptionBean("天津市",21));
        beans.add(new OptionBean("西藏",25));
        beans.add(new OptionBean("新疆维吾尔",25));
        beans.add(new OptionBean("云南省",26));
        beans.add(new OptionBean("浙江省",26));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mulitAdapter  = new MulitAdapter(beans,this);
        recyclerView.setAdapter(mulitAdapter);
        EventBus.getDefault().register(this);//订阅
    }

    private void initView() {
        recyclerView = findViewById(R.id.third_rv);
        indexView = findViewById(R.id.third_indexv);
    }


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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onItemSelectedEvent(ItemSelectedMessageEvent event){
        RecommendBean iItemBeanVisiable = (RecommendBean) (beans.get(1));
        List<SelectedBean> datas = iItemBeanVisiable.getDatas();
        SelectedBean selectedBean = datas.get(0);
        selectedBean.name = event.name;
        selectedBean.id = event.id;
        mulitAdapter.notifyItemChanged(1,event.name);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
