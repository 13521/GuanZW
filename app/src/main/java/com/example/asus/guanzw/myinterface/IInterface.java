package com.example.asus.guanzw.myinterface;

import com.example.asus.guanzw.bean.LoginBean;
import com.example.asus.guanzw.bean.ZhuCeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ASUS on 2017/12/16.
 */

public interface IInterface  {

    @GET("/user/login")
    Observable<LoginBean> getLogin(@Query("mobile") String mobile,@Query("password") String password);

    @GET("/user/reg")
    Observable<ZhuCeBean> getZhuCe(@Query("mobile") String mobile, @Query("password") String password);
}
