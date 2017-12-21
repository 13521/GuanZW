package com.example.asus.guanzw.application;

import android.app.Application;

import com.example.asus.guanzw.myinterface.IInterface;
import com.facebook.drawee.backends.pipeline.Fresco;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ASUS on 2017/12/16.
 */

public class IApplication extends Application{

    public static IInterface Interface;

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Interface = retrofit.create(IInterface.class);



    }
}
