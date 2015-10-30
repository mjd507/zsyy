package com.rainwii.zsyy.activity.hospital;

import android.view.View;
import android.widget.ImageButton;

//import com.baidu.location.BDLocation;
//import com.baidu.location.BDLocationListener;
//import com.baidu.location.LocationClient;
//import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;
import com.rainwii.zsyy.R;
import com.rainwii.zsyy.activity.base.BaseActivity;

/**
 * 描述：地图导航
 * 作者 mjd
 * 日期：2015/10/27 15:15
 */
public class HospitalMapNavigationActivity extends BaseActivity {
    private ImageButton ibBus;
    private ImageButton ibDriver;
    private ImageButton ibWalk;

    // 定位相关
//    LocationClient mLocClient;
//    public MyLocationListener myListener = new MyLocationListener();
//    private LocationMode mCurrentMode;
//    BitmapDescriptor mCurrentMarker;

    private MapView mMapView;
    private BaiduMap mBaiduMap;

    boolean isFirstLoc = true; // 是否首次定位

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

        initMapCenterPoint();

//        initMyLocation();
    }

    /**
     * 初始化我的位置（定位）
     */
    private void initMyLocation() {
//        mCurrentMode = LocationMode.NORMAL;
//        // 开启定位图层
//        mBaiduMap.setMyLocationEnabled(true);
//        // 定位初始化
//        mLocClient = new LocationClient(this);
//        mLocClient.registerLocationListener(myListener);
//        LocationClientOption option = new LocationClientOption();
//        option.setOpenGps(true); // 打开gps
//        option.setCoorType("bd09ll"); // 设置坐标类型
//        option.setScanSpan(1000);
//        mLocClient.setLocOption(option);
//        mLocClient.start();
    }

    /**
     * 初始化地图的中心点
     */
    private void initMapCenterPoint() {
        LatLng centerPoint = new LatLng(31.3023280000, 120.5906890000);//设定中心点坐标
        MapStatus mMapStatus = new MapStatus.Builder()
                .target(centerPoint)
                .zoom(18)
                .build();//定义地图状态
        //定义MapStatusUpdate对象，以便描述地图状态将要发生的变化
        MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
        mBaiduMap.setMapStatus(mMapStatusUpdate);//改变地图状态
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

    /**
     * 定位SDK监听函数
     */
//    public class MyLocationListener implements BDLocationListener {
//
//        @Override
//        public void onReceiveLocation(BDLocation location) {
//            // map view 销毁后不在处理新接收的位置
//            if (location == null || mMapView == null) {
//                return;
//            }
//            MyLocationData locData = new MyLocationData.Builder()
//                    .accuracy(location.getRadius())
//                            // 此处设置开发者获取到的方向信息，顺时针0-360
//                    .direction(100).latitude(location.getLatitude())
//                    .longitude(location.getLongitude()).build();
//            mBaiduMap.setMyLocationData(locData);
//            if (isFirstLoc) {
//                isFirstLoc = false;
//                LatLng ll = new LatLng(location.getLatitude(),
//                        location.getLongitude());
//                MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(ll);
//                mBaiduMap.animateMapStatus(u);
//            }
//        }
//
//        public void onReceivePoi(BDLocation poiLocation) {
//        }
//    }

    @Override
    protected void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        mMapView.onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
//        // 退出时销毁定位
//        mLocClient.stop();
//        // 关闭定位图层
//        mBaiduMap.setMyLocationEnabled(false);
        mMapView.onDestroy();
        mMapView = null;
        super.onDestroy();
    }


}
