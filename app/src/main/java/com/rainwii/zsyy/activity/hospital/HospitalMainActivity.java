package com.rainwii.zsyy.activity.hospital;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.BaseActivity;

/**
 * 描述：Hospital Navigation
 * 作者 mjd
 * 日期：2015/10/13 9:27
 */
public class HospitalMainActivity extends BaseActivity {
    private ImageView ivHospital;
    private ImageButton ibMapNavigation;
    private ImageButton ibFloorNavigation;
    private ImageButton ibPeripheryNavigation;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_hospital_main);
        setTitleBack("医院导航");
        ivHospital = (ImageView) findViewById(R.id.iv_hospital);
        ibMapNavigation = (ImageButton) findViewById(R.id.ib_map_navigation);
        ibFloorNavigation = (ImageButton) findViewById(R.id.ib_floor_navigation);
        ibPeripheryNavigation = (ImageButton) findViewById(R.id.ib_periphery_navigation);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListeners() {
        ibMapNavigation.setOnClickListener(this);
        ibFloorNavigation.setOnClickListener(this);
        ibPeripheryNavigation.setOnClickListener(this);
    }

    @Override
    protected void handleClick(View view) {
        switch (view.getId()) {
            case R.id.ib_map_navigation:
                enterActivity(HospitalMapNavigationActivity.class);
                break;
            case R.id.ib_floor_navigation:
                enterActivity(HospitalFloorNavigationActivity.class);
                break;
            case R.id.ib_periphery_navigation:
                enterActivity(HospitalPeripheryNavigationActivity.class);
                break;
        }
    }
}
