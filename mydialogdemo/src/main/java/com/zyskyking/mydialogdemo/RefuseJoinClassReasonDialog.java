package com.zyskyking.mydialogdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

/**
 * 拒绝加入班级理由弹窗
 */
public class RefuseJoinClassReasonDialog extends DialogFragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.layout_refuse_join_class_reason_dialog, container);
        //关闭弹窗
        inflate.findViewById(R.id.refulse_join_class_dialog_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        return inflate;
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setBackgroundDrawableResource(R.drawable.shape_refuse_join_class_layout);
        //点击外部不可取消
        getDialog().setCanceledOnTouchOutside(false);

    }


}
