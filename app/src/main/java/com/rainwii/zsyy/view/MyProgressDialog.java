package com.rainwii.zsyy.view;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import com.rainwii.zsyy.R;

/**
 * 描述：自定义样式的ProgressDialog
 * 作者 mjd
 * 日期：2015/10/13 14:09
 */
public class MyProgressDialog extends Dialog {

    public MyProgressDialog(Context context,String msg) {
        this(context, R.style.MyProgressDialogStyle, msg);
    }

    public MyProgressDialog(Context context, int theme,String msg) {
        super(context, theme);
        this.setContentView(R.layout.layout_loading_dialog);
        TextView tvLoading = (TextView) this.findViewById(R.id.tv_loading);
        tvLoading.setText(msg);
        setCancelable(false);
    }

}
