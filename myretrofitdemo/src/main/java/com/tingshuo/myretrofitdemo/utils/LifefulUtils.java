package com.tingshuo.myretrofitdemo.utils;

import android.util.Log;

import com.tingshuo.myretrofitdemo.Interface.Lifeful;
import com.tingshuo.myretrofitdemo.Interface.LifefulGenerator;

import java.lang.ref.WeakReference;

public class LifefulUtils {

    private static final String TAG = LifefulUtils.class.getSimpleName();

    public static boolean shouldGoHome(WeakReference<Lifeful> lifefulWeakReference,boolean objectIsNull){
        if (lifefulWeakReference ==null){
            Log.e(TAG, "shouldGoHome:lifefulWeakReference= null");
            return true;
        }

        Lifeful lifeful = lifefulWeakReference.get();

        if (lifeful==null&&!objectIsNull){
            Log.e(TAG, "shouldGoHome: lifeful==null&&!objectIsNull");
            return true;
        }

        if (null!=lifeful&& !lifeful.isAlive()){
            Log.e(TAG, "shouldGoHome: null!=lifeful&& !lifeful.isAlive()");
            return true;
        }

        return false;
    }

    public static <T> boolean shouldGoHome(LifefulGenerator<T> lifefulGenerator){
        if (lifefulGenerator==null) {
            Log.e(TAG, "shouldGoHome: lifefulGenerator==null");
            return true;
        }

        if (lifefulGenerator.getCallback()==null){
            Log.e(TAG, "shouldGoHome: lifefulGenerator.getCallback()==null");
            return true;
        }
        return shouldGoHome(lifefulGenerator.getLifefulWeakReference(),lifefulGenerator.isLifefulNull());
    }
}
