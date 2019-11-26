package com.tingshuo.myretrofitdemo.Interface;

/**
 * 判断生命周期是否已经结束的一个接口
 */
public interface Lifeful {
    /**
     * 判断某一个组件生命周期是否已经走到最后
     * @return
     */
    boolean isAlive();
}
