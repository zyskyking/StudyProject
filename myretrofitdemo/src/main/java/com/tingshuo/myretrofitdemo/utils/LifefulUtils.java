package com.tingshuo.myretrofitdemo.utils;

import com.tingshuo.myretrofitdemo.Interface.Lifeful;
import com.tingshuo.myretrofitdemo.Interface.LifefulGenerator;

import java.lang.ref.WeakReference;

public class LifefulUtils {

    public static boolean shouldGoHome(WeakReference<Lifeful> lifefulWeakReference,boolean objectIsNull){
        if (lifefulWeakReference ==null){
            return true;
        }

        Lifeful lifeful = lifefulWeakReference.get();

        if (lifeful==null&&!objectIsNull){
            return true;
        }

        if (null!=lifeful&& !lifeful.isAlive()){
            return true;
        }

        return false;
    }

    public static <T> boolean shouldGoHome(LifefulGenerator<T> lifefulGenerator){
        if (lifefulGenerator==null) {
            return true;
        }

        if (lifefulGenerator.getCallback()==null){
            return true;
        }
        return shouldGoHome(lifefulGenerator.getLifefulWeakReference(),lifefulGenerator.isLifefulNull());
    }
}
