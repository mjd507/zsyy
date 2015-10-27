package com.rainwii.zsyy.activity.hospital;

import android.view.View;
import android.widget.RadioButton;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;
import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.BaseActivity;

/**
 * 描述：周边商户
 * 作者 mjd
 * 日期：2015/10/27 19:19
 */
public class HospitalPeripheryNavigationActivity extends BaseActivity {
    private MapView mMapView;
    private RadioButton rbDrug;
    private RadioButton rbHotel;
    private RadioButton rbBank;
    private RadioButton rbIce;

    private BaiduMap mBaiduMap;

    @Override
    protected void initViews() {
        SDKInitializer.initialize(getApplicationContext());

        setContentView(R.layout.activity_hospital_periphery_navigation);
        setTitleBack("周边商户");
        rbDrug = (RadioButton) findViewById(R.id.rb_drug);
        rbHotel = (RadioButton) findViewById(R.id.rb_hotel);
        rbBank = (RadioButton) findViewById(R.id.rb_bank);
        rbIce = (RadioButton) findViewById(R.id.rb_ice);
        mMapView = (MapView) findViewById(R.id.mv);
        mBaiduMap = mMapView.getMap();
        //普通地图
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        //设定中心点坐标
        LatLng centerPoint = new LatLng(31.3023280000, 120.5906890000);
        //定义地图状态
        MapStatus mMapStatus = new MapStatus.Builder()
                .target(centerPoint)
                .zoom(18)
                .build();
        //定义MapStatusUpdate对象，以便描述地图状态将要发生的变化
        MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
        //改变地图状态
        mBaiduMap.setMapStatus(mMapStatusUpdate);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListeners() {
        rbDrug.setOnClickListener(this);
        rbBank.setOnClickListener(this);
        rbHotel.setOnClickListener(this);
        rbIce.setOnClickListener(this);
    }

    @Override
    protected void handleClick(View view) {
        switch (view.getId()) {
            case R.id.rb_drug:
                break;
            case R.id.rb_hotel:
                break;
            case R.id.rb_bank:
                break;
            case R.id.rb_ice:
                break;
        }
    }
}
