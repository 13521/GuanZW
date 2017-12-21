package com.example.asus.guanzw.model;

import com.example.asus.guanzw.application.IApplication;
import com.example.asus.guanzw.bean.LoginBean;
import com.example.asus.guanzw.myinterface.LoginModelCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ASUS on 2017/12/16.
 */

public class LoginModel {
    public void getData(final LoginModelCallBack loginModelCallBack, String yhm, String mm) {
        IApplication.Interface.getLogin(yhm,mm)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        loginModelCallBack.onSuccess(loginBean);
                    }
                });
    }
}
