package com.example.asus.guanzw.presenter;

import com.example.asus.guanzw.bean.ZhuCeBean;
import com.example.asus.guanzw.model.ZhuCeModel;
import com.example.asus.guanzw.myinterface.ZhuCeModelCallBack;
import com.example.asus.guanzw.myinterface.ZhuCeViewCallBack;
import com.example.asus.guanzw.view.ZhuCeActivity;

/**
 * Created by ASUS on 2017/12/16.
 */

public class ZhuCePresenter {
    private ZhuCeViewCallBack zhuCeViewCallBack;
    private ZhuCeModel zhuCeModel;
    public ZhuCePresenter(ZhuCeViewCallBack zhuCeViewCallBack) {
        this.zhuCeViewCallBack=zhuCeViewCallBack;
        this.zhuCeModel=new ZhuCeModel();
    }

    public void getData(String yhm, String mm) {
        zhuCeModel.getData(new ZhuCeModelCallBack() {
            @Override
            public void onSuccess(ZhuCeBean zhuCeBean) {
                zhuCeViewCallBack.onSuccess(zhuCeBean);
            }
        },yhm,mm);
    }
}
