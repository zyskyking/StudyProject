package com.example.mvpdemo.presenter;

import com.example.mvpdemo.entity.UrlString;
import com.example.mvpdemo.model.weatherDataModel;
import com.example.mvpdemo.view.IShowDatasView;

public class weatherDataPersenter implements IGetDataPersenter{

    weatherDataModel weatherDataModel;
    IShowDatasView interfceView;

    public weatherDataPersenter(IShowDatasView interfceView){
        this.interfceView = interfceView;
        weatherDataModel  = new weatherDataModel(this);
    }

    @Override
    public void doGetData(String url) {
        weatherDataModel.getData(url);
    }

    @Override
    public void doSuccess(String relult) {
        interfceView.showData(relult);
    }

    @Override
    public void doFail() {
        interfceView.showFail();
    }
}
