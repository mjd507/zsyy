package com.rainwii.zsyy.activity;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioGroup;

import com.rainwii.zsyy.R;
import com.rainwii.zsyy.fragment.Main1Fragment;
import com.rainwii.zsyy.fragment.Main2Fragment;
import com.rainwii.zsyy.fragment.Main3Fragment;
import com.rainwii.zsyy.fragment.Main4Fragment;
import com.rainwii.zsyy.utils.ToastUtils;


/**
 * 主页面（包含4个fragment）
 */
public class MainActivity extends BaseActivity {
    private RadioGroup rgMain;

    private Main1Fragment main1Fragment;
    private Main2Fragment main2Fragment;
    private Main3Fragment main3Fragment;
    private Main4Fragment main4Fragment;

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
                if (main1Fragment == null) {
                    main1Fragment = new Main1Fragment();
                    transaction.add(R.id.fl_main, main1Fragment);
                } else {
                    transaction.show(main1Fragment);
                }
                break;
            case 1:
                if (main2Fragment == null) {
                    main2Fragment = new Main2Fragment();
                    transaction.add(R.id.fl_main, main2Fragment);
                } else {
                    transaction.show(main2Fragment);
                }
                break;
            case 2:
                if (main3Fragment == null) {
                    main3Fragment = new Main3Fragment();
                    transaction.add(R.id.fl_main, main3Fragment);
                } else {
                    transaction.show(main3Fragment);
                }
                break;
            case 3:
                if (main4Fragment == null) {
                    main4Fragment = new Main4Fragment();
                    transaction.add(R.id.fl_main, main4Fragment);
                } else {
                    transaction.show(main4Fragment);
                }
                break;
        }
        transaction.commit();
    }

    /**
     * 隐藏所有fragment
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (main1Fragment != null) {
            transaction.hide(main1Fragment);
        }
        if (main2Fragment != null) {
            transaction.hide(main2Fragment);
        }
        if (main3Fragment != null) {
            transaction.hide(main3Fragment);
        }
        if (main4Fragment != null) {
            transaction.hide(main4Fragment);
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
