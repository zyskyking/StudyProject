package com.tingshuo.myretrofitdemo.Interface;

import java.lang.ref.WeakReference;

public interface LifefulGenerator<Callback> {
    /**
     * 返回回调接口
     * @return
     */
    Callback getCallback();

    /**
     * 获取与生命周期绑定的弱引用，一般为Context
     * @return
     */
    WeakReference<Lifeful> getLifefulWeakReference();

    /**
     * 传入的引用是否为null
     * @return true if {@link Lifeful} is null;
     */
    boolean isLifefulNull();

}
