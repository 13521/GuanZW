package com.example.asus.guanzw.model;

import com.example.asus.guanzw.application.IApplication;
import com.example.asus.guanzw.bean.LoginBean;
import com.example.asus.guanzw.bean.ZhuCeBean;
import com.example.asus.guanzw.myinterface.ZhuCeModelCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ASUS on 2017/12/16.
 */

public class ZhuCeModel {
    public void getData(final ZhuCeModelCallBack zhuCeModelCallBack, String yhm, String mm) {
        IApplication.Interface.getZhuCe(yhm,mm)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZhuCeBean>() {
                    @Override
                    public void accept(ZhuCeBean zhuCeBean) throws Exception {
                        zhuCeModelCallBack.onSuccess(zhuCeBean);
                    }
                });
    }
}
