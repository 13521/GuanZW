package com.example.asus.guanzw.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.guanzw.R;
import com.example.asus.guanzw.view.LoginActivity;
import com.example.asus.guanzw.view.MainActivity;


/**
 * Created by ASUS on 2017/12/15.
 */

public class Fragment_Mine extends Fragment {

    private LinearLayout buju;
    private TextView login_tv;
    private TextView backtv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.frag_mine,null);
        backtv = view.findViewById(R.id.backtv);
        buju = view.findViewById(R.id.buju);
        login_tv = view.findViewById(R.id.login_tv);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final SharedPreferences sharedPreferences=getActivity().getSharedPreferences("config", Context.MODE_PRIVATE);
        boolean islogin = sharedPreferences.getBoolean("islogin", false);
        String yhm = sharedPreferences.getString("yhm", null);
        if(islogin&&yhm!=null){
            login_tv.setText("欢迎您,"+yhm);
            backtv.setVisibility(View.VISIBLE);
            buju.setClickable(false);
            backtv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sharedPreferences.edit().clear().commit();
                    Toast.makeText(getActivity(),"退出登录",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getActivity(),MainActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            });
        }else {
            backtv.setVisibility(View.GONE);
            buju.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            });
        }
        }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("config", Context.MODE_PRIVATE);
        boolean islogin = sharedPreferences.getBoolean("islogin", false);
        String yhm = sharedPreferences.getString("yhm", null);
        if(islogin&&yhm!=null){
            login_tv.setText("欢迎您,"+yhm);
            buju.setClickable(false);
        }else {
            buju.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            });
        }
    }
}
