package com.example.gridviewdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


import static com.example.gridviewdemo.R.id.main_gridview;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ListView mainGridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        mainGridview = findViewById(main_gridview);
        final boolean[] booleans = {true, false, false, false,false, false, false, false,false, false, false, false,false, false, false, false,false};
        final Adapter adapter = new Adapter(this, booleans);

        mainGridview.setAdapter(adapter);
        mainGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                for (int j = 0; j < booleans.length; j++) {
                    if (i==j){
                        booleans[j] = true;
                    }else{
                        booleans[j] = false;
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });
    }
}
