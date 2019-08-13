package com.example.mvpdemo.presenter;

public interface IGetDataPersenter {
    //获取数据
    void doGetData(String url);
    //获取成功
    void doSuccess(String relult);
    //获取失败
    void doFail();
}
