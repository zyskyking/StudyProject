package com.example.myrecyclerviewdemo.Bean;

import com.example.myrecyclerviewdemo.InterFace.IItemBeanVisiable;
import com.example.myrecyclerviewdemo.InterFace.TypeFactory;

public class BannerBean implements IItemBeanVisiable {

    public String name;
    public int id;

    public BannerBean(String name,int id){
        this.id = id;
        this.name = name;
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
