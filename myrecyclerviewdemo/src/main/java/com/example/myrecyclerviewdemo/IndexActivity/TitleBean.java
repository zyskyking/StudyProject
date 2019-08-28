package com.example.myrecyclerviewdemo.IndexActivity;

import com.example.myrecyclerviewdemo.InterFace.IItemBeanVisiable;
import com.example.myrecyclerviewdemo.InterFace.TypeFactory;

public class TitleBean implements IItemBeanVisiable {

    public String title;
    public int id;

    public TitleBean(String title,int id){
        this.id = id;
        this.title = title;
    }


    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    @Override
    public int getTag() {
        return id;
    }

}
