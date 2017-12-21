package com.example.asus.guanzw.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.asus.guanzw.R;
import com.example.asus.guanzw.view.MainActivity;
import com.zaaach.citypicker.CityPickerActivity;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;


/**
 * Created by ASUS on 2017/12/15.
 */

public class Fragment_Active extends Fragment {


    private ViewPager viewpager;
    private TabLayout tablayout;
    private TextView quanguo;
    private static final int REQUEST_CODE_PICK_CITY = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.frag_active,null);
        tablayout = view.findViewById(R.id.tablayout);
        viewpager = view.findViewById(R.id.viewpager);
        quanguo = view.findViewById(R.id.quanguo);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        quanguo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //启动
                startActivityForResult(new Intent(getActivity(), CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);


            }
        });

        final List<String> list=new ArrayList<>();
        list.add("全部");
        list.add("综艺娱乐");
        list.add("财经访谈");
        list.add("文化旅游");
        list.add("时尚体育");
        viewpager.setOffscreenPageLimit(list.size());

        viewpager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }


            @Override
            public Fragment getItem(int position) {

                if(list.get(position).equals("全部")){
                    Fragment_01 fragment_01 = new Fragment_01();
                    return fragment_01;
                }else if(list.get(position).equals("综艺娱乐")){
                    Fragment_02 fragment_02 = new Fragment_02();
                    return fragment_02;
                }else if(list.get(position).equals("财经访谈")){
                    Fragment_03 fragment_03 = new Fragment_03();
                    return fragment_03;
                }else if(list.get(position).equals("文化旅游")){
                    Fragment_04 fragment_04 = new Fragment_04();
                    return fragment_04;
                }else if(list.get(position).equals("时尚体育")){
                    Fragment_05 fragment_05 = new Fragment_05();
                    return fragment_05;
                }
                return null;
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        tablayout.setupWithViewPager(viewpager);


    }

    //重写onActivityResult方法
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK){
            if (data != null){
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                quanguo.setText("当前选择：" + city);
            }
        }
    }


}
