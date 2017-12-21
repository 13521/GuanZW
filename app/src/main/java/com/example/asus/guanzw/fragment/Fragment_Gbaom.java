package com.example.asus.guanzw.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.asus.guanzw.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2017/12/15.
 */

public class Fragment_Gbaom extends Fragment {
    private TabLayout gtab_layout;
    private ViewPager baom_viewpager;
    private ViewPager wei_viewpager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.frag_gbaom,null);
        gtab_layout = view.findViewById(R.id.gtab_layout);
        wei_viewpager = view.findViewById(R.id.wei_viewpager);
        baom_viewpager = view.findViewById(R.id.baom_viewpager);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final List<String> list=new ArrayList<>();
        list.add("待审核");
        list.add("待支付");
        list.add("待参加");
        list.add("已完成");

        baom_viewpager.setOffscreenPageLimit(list.size());


        final SharedPreferences sharedPreferences=getActivity().getSharedPreferences("config", Context.MODE_PRIVATE);
        boolean islogin = sharedPreferences.getBoolean("islogin", false);
        if(islogin){

            baom_viewpager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
                @Override
                public CharSequence getPageTitle(int position) {
                    return list.get(position);
                }


                @Override
                public Fragment getItem(int position) {

                    if(list.get(position).equals("待审核")){
                        Fragment_Shenhe fragment_shenhe = new Fragment_Shenhe();
                        return fragment_shenhe;
                    }else if(list.get(position).equals("待支付")){
                        Fragment_ZhiFu fragment_zhiFu = new Fragment_ZhiFu();
                        return fragment_zhiFu;
                    }else if(list.get(position).equals("待参加")){
                        Fragment_Canjia fragment_canjia = new Fragment_Canjia();
                        return fragment_canjia;
                    }else if(list.get(position).equals("已完成")){
                        Fragment_WanCheng fragment_wanCheng = new Fragment_WanCheng();
                        return fragment_wanCheng;
                    }
                    return null;
                }

                @Override
                public int getCount() {
                    return list.size();
                }
            });
            gtab_layout.setupWithViewPager(baom_viewpager);



        }else {

            Toast.makeText(getActivity(),"请先登录",Toast.LENGTH_SHORT).show();

            wei_viewpager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
                @Override
                public CharSequence getPageTitle(int position) {
                    return list.get(position);
                }


                @Override
                public Fragment getItem(int position) {

                    if(list.get(position).equals("待审核")){
                        Fragmentwei fragmentwei = new Fragmentwei();
                        return fragmentwei;
                    }else if(list.get(position).equals("待支付")){
                        Fragmentwei fragmentwei = new Fragmentwei();
                        return fragmentwei;
                    }else if(list.get(position).equals("待参加")){
                        Fragmentwei fragmentwei = new Fragmentwei();
                        return fragmentwei;
                    }else if(list.get(position).equals("已完成")){
                        Fragmentwei fragmentwei = new Fragmentwei();
                        return fragmentwei;
                    }
                    return null;
                }

                @Override
                public int getCount() {
                    return list.size();
                }
            });
            gtab_layout.setupWithViewPager(wei_viewpager);

    }

    }
}
