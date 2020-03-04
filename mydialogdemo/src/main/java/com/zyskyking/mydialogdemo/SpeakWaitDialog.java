package com.zyskyking.mydialogdemo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class SpeakWaitDialog extends DialogFragment {

    private View tick;
    private android.widget.ProgressBar progressBar;
    private TextView message;

    public SpeakWaitDialog(WaitDialogCancelListener listener){
        onWaitDialogCancelListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_mark, container);
        tick = view.findViewById(R.id.mark_dialog_tick);
        progressBar = view.findViewById(R.id.mark_dialog_pb);
        message = view.findViewById(R.id.speak_wait_dialog_message_tv);
        return view;
    }

    public void showTick(){
        if (tick!=null&&tick.getVisibility()==View.GONE){
            tick.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
            message.setText("判分完成");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    getDialog().cancel();
                    return true;
                }
                return false;
            }
        });
        getDialog().setCancelable(true);
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                if (onWaitDialogCancelListener!=null){
                    onWaitDialogCancelListener.onCancel(dialogInterface);
                }
            }
        });
    }

    private WaitDialogCancelListener onWaitDialogCancelListener;

    public interface WaitDialogCancelListener{
        void onCancel(DialogInterface dialogInterface);
    }
}
