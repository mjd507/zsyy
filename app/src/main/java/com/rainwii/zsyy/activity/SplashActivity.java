package com.rainwii.zsyy.activity;

import android.os.Handler;
import android.view.View;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.base.BaseActivity;

 /**
 * 描述：
 * 作者 mjd
 * 日期：2016/5/28 10:20
 */
public class SplashActivity extends BaseActivity {

    private Handler mHandler = new Handler();

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_splash);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
               enterActivity(MainActivity.class);
                finish();
            }
        }, 2000);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void handleClick(View view) {

    }

     @Override
     public void onBackPressed() {

     }
 }
