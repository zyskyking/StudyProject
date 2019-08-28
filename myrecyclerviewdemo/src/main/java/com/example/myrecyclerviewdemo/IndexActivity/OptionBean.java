package com.example.myrecyclerviewdemo.IndexActivity;

import com.example.myrecyclerviewdemo.InterFace.IItemBeanVisiable;
import com.example.myrecyclerviewdemo.InterFace.TypeFactory;

public class OptionBean implements IItemBeanVisiable {

    private String name;
    private int id;

    public OptionBean(String name,int id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
