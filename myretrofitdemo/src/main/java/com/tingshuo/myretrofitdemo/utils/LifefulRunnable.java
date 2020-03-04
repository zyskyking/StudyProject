package com.tingshuo.myretrofitdemo.utils;

import com.tingshuo.myretrofitdemo.Interface.Lifeful;
import com.tingshuo.myretrofitdemo.Interface.LifefulGenerator;
import com.tingshuo.myretrofitdemo.enter.DefaultLifefulGenerator;

public class LifefulRunnable implements Runnable {

    private LifefulGenerator<Runnable> mLifefulGenerator;

    public LifefulRunnable(Runnable runnable, Lifeful lifeful){
       mLifefulGenerator =  new DefaultLifefulGenerator<>(runnable,lifeful);
    }

    @Override
    public void run() {
        if (LifefulUtils.shouldGoHome(mLifefulGenerator)){
            return;
        }
        mLifefulGenerator.getCallback().run();
    }
}
