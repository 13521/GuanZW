package com.example.asus.guanzw.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.guanzw.R;
import com.example.asus.guanzw.adatpter.IAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2017/12/15.
 */

public class Fragment_WanCheng extends Fragment {
    private RecyclerView recycle_view;
    private List<Integer> listimage= new ArrayList<>();
    private List<String> listtext= new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.frag_wancheng,null);
        recycle_view = view.findViewById(R.id.recycle_view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listimage .add(R.drawable.d);
        listimage .add(R.drawable.g);
        listimage .add(R.drawable.a);
        listimage .add(R.drawable.b);
        listimage .add(R.drawable.e);
        listimage .add(R.drawable.f);
        listimage .add(R.drawable.c);
        listimage .add(R.drawable.h);
        listimage .add(R.drawable.i);
        listimage .add(R.drawable.j);
        listimage .add(R.drawable.k);

        listtext.add("晋太元中，武陵人捕鱼为业。");
        listtext.add("缘溪行，忘路之远近。忽逢桃花林，夹岸数百步，中无杂树.");
        listtext.add("山不在高，有仙则名。水不在深，有龙则灵。");
        listtext.add("水陆草木之花，可爱者甚蕃。晋陶渊明独爱菊。");
        listtext.add("环滁皆山也。");
        listtext.add("其西南诸峰，林壑尤美。");
        listtext.add("望之蔚然而深秀者，琅琊也");
        listtext.add("环滁皆山也。其西南诸峰，林壑尤美，望之蔚然而深秀者，琅琊也。");
        listtext.add("望之蔚然而深秀者，琅琊也。");
        listtext.add("环滁皆山也。其西南诸峰，林壑尤美.");
        listtext.add("环滁皆山也。其西南诸峰，林壑尤美，望之蔚然而深.");



        IAdapter iAdapter = new IAdapter(getActivity());
        iAdapter.addData(listimage,listtext);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recycle_view.setLayoutManager(linearLayoutManager);
        recycle_view.setAdapter(iAdapter);

    }
}
