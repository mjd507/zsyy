package com.rainwii.zsyy.activity.subscribe;

import android.view.View;
import android.webkit.WebView;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.base.BaseActivity;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/10/31 17:06
 */
public class SubscribeContentActivity extends BaseActivity {
    private WebView wb;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_subscribe_content);
        setTitleBack(getIntent().getExtras().getString("tab"));
        wb = (WebView) findViewById(R.id.wb);
        wb.loadUrl("");
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
}
