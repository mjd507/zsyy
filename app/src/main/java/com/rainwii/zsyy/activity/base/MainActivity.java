package com.rainwii.zsyy.activity.base;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioGroup;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.fragment.HomeFragment;
import com.rainwii.zsyy.fragment.ServiceFragment;
import com.rainwii.zsyy.fragment.SubscribeFragment;
import com.rainwii.zsyy.fragment.RecordFragment;
import com.rainwii.zsyy.utils.ToastUtils;


/**
 * 主页面（包含4个fragment）
 */
public class MainActivity extends BaseActivity {
    private RadioGroup rgMain;

    private HomeFragment homeFragment;
    private ServiceFragment serviceFragment;
    private SubscribeFragment subscribeFragment;
    private RecordFragment recordFragment;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_main);
        rgMain = (RadioGroup) findViewById(R.id.rg_main);
    }

    @Override
    protected void initData() {
        setSelectedTab(0);
    }

    @Override
    protected void initListeners() {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        setSelectedTab(0);
                        break;
                    case R.id.rb_service:
                        setSelectedTab(1);
                        break;
                    case R.id.rb_subscribe:
                        setSelectedTab(2);
                        break;
                    case R.id.rb_health_record:
                        setSelectedTab(3);
                        break;
                }
            }
        });
    }


    /**
     * 设置选中的标签
     */
    private void setSelectedTab(int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragments(transaction);
        switch (index) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.fl_main, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
                break;
            case 1:
                if (serviceFragment == null) {
                    serviceFragment = new ServiceFragment();
                    transaction.add(R.id.fl_main, serviceFragment);
                } else {
                    transaction.show(serviceFragment);
                }
                break;
            case 2:
                if (subscribeFragment == null) {
                    subscribeFragment = new SubscribeFragment();
                    transaction.add(R.id.fl_main, subscribeFragment);
                } else {
                    transaction.show(subscribeFragment);
                }
                break;
            case 3:
                if (recordFragment == null) {
                    recordFragment = new RecordFragment();
                    transaction.add(R.id.fl_main, recordFragment);
                } else {
                    transaction.show(recordFragment);
                }
                break;
        }
        transaction.commit();
    }

    /**
     * 隐藏所有fragment
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (serviceFragment != null) {
            transaction.hide(serviceFragment);
        }
        if (subscribeFragment != null) {
            transaction.hide(subscribeFragment);
        }
        if (recordFragment != null) {
            transaction.hide(recordFragment);
        }
    }

    @Override
    protected void handleClick(View view) {

    }

    private long currentTime = 0;

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - currentTime > 2000) {
            ToastUtils.showShort(this, "再按一次退出应用");
            currentTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }
}
