package com.rainwii.zsyy.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {
    public static void showShort(Context context, String str) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
    }
    public static void showLong(Context context, String str) {
        Toast.makeText(context, str, Toast.LENGTH_LONG).show();
    }
}
