package com.rainwii.zsyy.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rainwii.zsyy.R;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/10/15 22:16
 */
public class MyRegisterDialog extends Dialog {
    public MyRegisterDialog(Context context, String dialogTitle, String dialogInfo, String dialogOk) {
        this(context, R.style.MyRegisterDialogStyle, dialogTitle, dialogInfo, dialogOk);
    }

    public MyRegisterDialog(Context context, int theme, String dialogTitle, String dialogInfo, String dialogOk) {
        super(context, theme);
        this.setContentView(R.layout.layout_register_dialog);
        TextView tvDialogTitle = (TextView) this.findViewById(R.id.tv_title);
        TextView tvDialogInfo = (TextView) this.findViewById(R.id.tv_info);
        TextView tvDialogOk = (TextView) this.findViewById(R.id.tv_ok);
        tvDialogTitle.setText(dialogTitle);
        tvDialogInfo.setText(dialogInfo);
        tvDialogOk.setText(dialogOk);
        tvDialogOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

}
