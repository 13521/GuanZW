package com.example.asus.guanzw.adatpter;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2017/12/15.
 */

public class BaseAdapter extends PagerAdapter {
    private Context context;
    private List<Integer> list1;

    public BaseAdapter(Context context){
        this.context=context;
    }

    public void addData(List<Integer> list){
        if(list1==null){
            list1=new ArrayList<>();
        }
        list1.addAll(list);
        notifyDataSetChanged();
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);

        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(list1.get(position%list1.size()));
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
