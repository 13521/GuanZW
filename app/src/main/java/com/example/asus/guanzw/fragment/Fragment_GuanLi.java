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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.asus.guanzw.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ASUS on 2017/12/15.
 */

public class Fragment_GuanLi extends Fragment {

    private RadioGroup radio_group;
    private RadioButton radio_baom;
    private RadioButton radio_fabu;
    private ViewPager gviewpager;
    private List<Fragment> list;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.frag_guanli,null);
        radio_group = view.findViewById(R.id.radio_group);
        radio_baom = view.findViewById(R.id.radio_baom);
        radio_fabu = view.findViewById(R.id.radio_fabu);
        gviewpager = view.findViewById(R.id.gviewpager);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

            list = new ArrayList<>();
            list.add(new Fragment_Gbaom());
            list.add(new Fragment_Gfabu());

            gviewpager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
                @Override
                public Fragment getItem(int position) {
                    return list.get(position);
                }

                @Override
                public int getCount() {
                    return list.size();
                }
            });


            //关联viewpager和radiogroup
            setGuanLianVpRg();


    }


    private void setGuanLianVpRg() {

        gviewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        radio_baom.setChecked(true);
                        break;
                    case 1:
                        radio_fabu.setChecked(true);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radio_baom:
                        gviewpager.setCurrentItem(0,false);
                        break;
                    case R.id.radio_fabu:
                        gviewpager.setCurrentItem(1,false);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
