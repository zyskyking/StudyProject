package com.example.myhandlertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String net = "1.0.0.0";
        String local = "1..9";

        boolean b = compareToVersion(net,local);
        Log.i(TAG, "onCreate: "+b);

    }

    public static boolean compareToVersion(String netVersion,String localVersion){
        String[] net_array = netVersion.split("\\.");
        String[] local_array = localVersion.split("\\.");

        //按照长度最小的进行遍历，都相同的话，长度长的版本号高
        for (int i = 0; i < Math.min(net_array.length,local_array.length); i++) {
            String netNum = net_array[i];
            String localNum = local_array[i];
            //非空判断
            if (TextUtils.isEmpty(netNum)){
                netNum = "0";
            }
            if (TextUtils.isEmpty(localNum)){
                localNum = "0";
            }

            if (Integer.parseInt(netNum)>Integer.parseInt(localNum)){
                //服务器端大
                return true;
            }else if (Integer.parseInt(netNum)<Integer.parseInt(localNum)){
                //本地版本号大
                return false;
            }
        }

        //程序并没有return 通过长度判断
        if (local_array.length>=net_array.length){
            //本地的长或者一样，本地都为最新版本
            return false;
        }else{
            return true;
        }

    }
}
