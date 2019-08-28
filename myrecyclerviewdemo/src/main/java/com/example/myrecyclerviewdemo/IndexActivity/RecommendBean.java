package com.example.myrecyclerviewdemo.IndexActivity;

import com.example.myrecyclerviewdemo.InterFace.IItemBeanVisiable;
import com.example.myrecyclerviewdemo.InterFace.TypeFactory;

import java.util.List;

public class RecommendBean implements IItemBeanVisiable {

    private List<SelectedBean> datas;

    public RecommendBean(List<SelectedBean> data){
        this.datas = data;
    }

    public List<SelectedBean> getDatas() {
        return datas;
    }

    public void setDatas(List<SelectedBean> datas) {
        this.datas = datas;
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    @Override
    public int getTag() {
        return -1;
    }


}
