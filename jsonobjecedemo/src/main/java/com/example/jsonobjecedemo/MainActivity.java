package com.example.jsonobjecedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        String config = "{\"key\":\"value\"}";
//
//        JsonObject jsonObject = new JsonObject();
//        JsonParser jsonParser = new JsonParser();
//        JsonElement parse = jsonParser.parse(config);
//        jsonObject.add("key",parse);
//
//        String s = jsonObject.toString();
//        Log.i(TAG, "onCreate: s:"+s);


//            JSONObject jsonObject1 = new JSONObject(config);
//
//
//            JSONObject bigJson = new JSONObject();
//            bigJson.put("key",jsonObject1);
//            String s1 = bigJson.toString();
//            Log.i(TAG, "onCreate: s1:"+s1);
//
//            JSONObject jsonObject2 = new JSONObject();
//            jsonObject2.putOpt("key",jsonObject1);
//            String s2 = jsonObject2.toString();
//            Log.i(TAG, "onCreate: s2:"+s2);


//            jsonObject.add("aaa",jsonObject1);
//            String s = jsonObject.toString();
//            Log.i(TAG, "onCreate: "+s);

    }

    public void jumpTo(View view) {
        SurfaceView iv = findViewById(R.id.image);

    }
}
