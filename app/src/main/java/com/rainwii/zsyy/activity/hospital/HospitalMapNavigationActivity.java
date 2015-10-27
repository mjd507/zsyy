package com.rainwii.zsyy.activity.hospital;

import android.view.View;
import android.widget.ImageButton;

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
 * 描述：地图导航
 * 作者 mjd
 * 日期：2015/10/27 15:15
 */
public class HospitalMapNavigationActivity extends BaseActivity {
    private ImageButton ibBus;
    private ImageButton ibDriver;
    private ImageButton ibWalk;
    private MapView mMapView;
    private BaiduMap mBaiduMap;

    @Override
    protected void initViews() {
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());

        setContentView(R.layout.activity_hospital_map_navigation);
        setTitleBack("地图导航");
        ibBus = (ImageButton) findViewById(R.id.ib_bus);
        ibDriver = (ImageButton) findViewById(R.id.ib_driver);
        ibWalk = (ImageButton) findViewById(R.id.ib_walk);
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
        ibBus.setOnClickListener(this);
        ibDriver.setOnClickListener(this);
        ibWalk.setOnClickListener(this);
    }

    @Override
    protected void handleClick(View view) {
        switch (view.getId()) {
            case R.id.ib_bus:
                //开启交通图
                mBaiduMap.setTrafficEnabled(true);
                break;
            case R.id.ib_driver:

                break;
            case R.id.ib_walk:

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }

}
