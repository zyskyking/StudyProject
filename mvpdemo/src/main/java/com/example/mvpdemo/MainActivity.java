package com.example.mvpdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mvpdemo.entity.UrlString;
import com.example.mvpdemo.presenter.weatherDataPersenter;
import com.example.mvpdemo.view.IShowDatasView;

public class MainActivity extends AppCompatActivity implements IShowDatasView {

    private static final String TAG = MainActivity.class.getSimpleName();
    weatherDataPersenter weatherDataPersenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weatherDataPersenter = new weatherDataPersenter(this);
    }

    @Override
    public void showData(String data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void showFail() {
        Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
    }

    public void doget(View view) {
        Log.i(TAG, "doget: click");
        weatherDataPersenter.doGetData(UrlString.weatherUrl);
    }
}
