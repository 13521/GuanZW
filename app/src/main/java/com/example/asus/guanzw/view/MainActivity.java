package com.example.asus.guanzw.view;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.asus.guanzw.R;
import com.example.asus.guanzw.fragment.Fragment_Active;
import com.example.asus.guanzw.fragment.Fragment_FaBu;
import com.example.asus.guanzw.fragment.Fragment_GuanLi;
import com.example.asus.guanzw.fragment.Fragment_Mine;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomTabBar = findViewById(R.id.bottomtabbar);

        bottomTabBar = (BottomTabBar) findViewById(R.id.bottomtabbar);

        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(30,30)
                .setFontSize(17)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("活动",R.drawable.home_, Fragment_Active.class)
                .addTabItem("发布",R.drawable.fx_n, Fragment_FaBu.class)
                .addTabItem("管理",R.drawable.th_sh, Fragment_GuanLi.class)
                .addTabItem("我的",R.drawable.wd_n, Fragment_Mine.class)
                .isShowDivider(true)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });


    }
}
