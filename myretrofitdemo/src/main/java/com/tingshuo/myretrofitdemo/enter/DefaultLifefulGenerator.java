package com.tingshuo.myretrofitdemo.enter;

import com.tingshuo.myretrofitdemo.Interface.Lifeful;
import com.tingshuo.myretrofitdemo.Interface.LifefulGenerator;

import java.lang.ref.WeakReference;

public class DefaultLifefulGenerator<Callback> implements LifefulGenerator<Callback> {

    private WeakReference<Lifeful> mLifefulWeakReference;
    private boolean mLifefulIsNull;
    private Callback mCallback;

    private DefaultLifefulGenerator(Callback callback,Lifeful lifeful){
        this.mCallback = callback;
        this.mLifefulWeakReference = new WeakReference<>(lifeful);
        this.mLifefulIsNull = lifeful==null;
    }

    @Override
    public Callback getCallback() {
        return mCallback;
    }

    @Override
    public WeakReference<Lifeful> getLifefulWeakReference() {
        return mLifefulWeakReference;
    }

    @Override
    public boolean isLifefulNull() {
        return mLifefulIsNull;
    }
}
