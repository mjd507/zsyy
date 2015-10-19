package com.rainwii.zsyy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rainwii.zsyy.R;

/**
 * 描述：主页面六个功能模块的适配器
 * 作者 mjd
 * 日期：2015/10/12 10:42
 */
public class HomeModulesAdapter extends BaseAdapter {

    private Context context;
    public HomeModulesAdapter(Context context) {
        this.context = context;
    }

    private static int[] moduleIcons ={
            R.drawable.btn_home_moudle_1,R.drawable.btn_home_moudle_2,
            R.drawable.btn_home_moudle_3,R.drawable.btn_home_moudle_4,
            R.drawable.btn_home_moudle_5,R.drawable.btn_home_moudle_6
    };

    private static String[] moduleNames ={
            "手机挂号","排队叫号","报告查询",
            "智能导诊","专家排班","医院导航"
    };

    @Override
    public int getCount() {
        return moduleIcons.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private static ImageView ivItem;
    private static TextView tvItem;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_modules, null);
        ivItem = (ImageView) view.findViewById(R.id.iv_item);
        tvItem = (TextView) view.findViewById(R.id.tv_item);
        ivItem.setImageResource(moduleIcons[position]);
        tvItem.setText(moduleNames[position]);
        return view;
    }
}
