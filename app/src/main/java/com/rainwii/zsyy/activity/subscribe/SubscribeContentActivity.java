package com.rainwii.zsyy.activity.subscribe;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.base.BaseActivity;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/10/31 17:06
 */
public class SubscribeContentActivity extends BaseActivity {
    private WebView mWebView;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_subscribe_content);
        setTitleBack(getIntent().getExtras().getString("tab"));
        mWebView = (WebView) findViewById(R.id.wb);

    }

    @Override
    protected void initData() {
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);// 表示支持js
        settings.setBuiltInZoomControls(true);// 显示放大缩小按钮
        settings.setUseWideViewPort(true);// 支持双击缩放

        mWebView.setWebViewClient(new WebViewClient() {

            /**
             * 网页开始加载
             */
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                showLoading("加载中...");
            }

            /**
             * 网页加载结束
             */
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                closeLoading();
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                closeLoading();
            }

            /**
             * 所有跳转的链接都会在此方法中回调
             */
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // tel:110
                view.loadUrl(url);

                return true;
            }
        });
        mWebView.loadUrl("http://news.163.com/15/1101/08/B7AROQFI00014JB5.html");
    }

    @Override
    protected void initListeners() {
    }

    @Override
    protected void handleClick(View view) {

    }
}
