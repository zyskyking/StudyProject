package com.zyskyking.mydialogdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDiaog();
        initRefuseDialog();
        speakWaitDialog = new SpeakWaitDialog(new SpeakWaitDialog.WaitDialogCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                Toast.makeText(MainActivity.this, "2222", Toast.LENGTH_SHORT).show();
            }
        });
        speakWaitDialog.setStyle(1,R.style.NobackDialog);

      handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message message) {
                switch (message.what){
                    case 1:{
                        Log.i(TAG, "handleMessage: 111111");
                        speakWaitDialog.showTick();
                        break;
                    }
                    case 2:{
                        speakWaitDialog.dismiss();
                        break;
                    }
                }
                return false;
            }
        });
    }

    public void toDialog(View view) {

//        waitDialog.show();
        initFragment();
//        refuseJoinClassReasonDialog.show(getSupportFragmentManager(),"1");
    }

    private Dialog waitDialog;
    private String  TAG = "aaaa";
    SpeakWaitDialog speakWaitDialog;

    private void initDiaog(){
        View view = LayoutInflater.from(this).inflate(
                R.layout.activity_mark, null);
        waitDialog = new Dialog(this, R.style.loading_dialog);
        waitDialog.setCancelable(true);
        waitDialog.setCanceledOnTouchOutside(false);
        waitDialog.setContentView(view, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        waitDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

            @Override
            public void onCancel(DialogInterface dialog) {
                Log.i(TAG, "onCancel: ");
            }
        });
    }

    private void initFragment(){

        speakWaitDialog.show(getSupportFragmentManager(),"tag");
        handler.sendEmptyMessageDelayed(1,3*1000);
        handler.sendEmptyMessageDelayed(2,5*1000);
    }

    RefuseJoinClassReasonDialog refuseJoinClassReasonDialog;
    private void initRefuseDialog(){
        refuseJoinClassReasonDialog = new RefuseJoinClassReasonDialog();
        refuseJoinClassReasonDialog.setStyle(1,R.style.NobackDialog);
    }
}
