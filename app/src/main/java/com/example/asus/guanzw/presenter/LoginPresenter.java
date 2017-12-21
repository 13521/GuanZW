package com.example.asus.guanzw.presenter;

import com.example.asus.guanzw.bean.LoginBean;
import com.example.asus.guanzw.model.LoginModel;
import com.example.asus.guanzw.myinterface.LoginModelCallBack;
import com.example.asus.guanzw.myinterface.LoginViewCallBack;
import com.example.asus.guanzw.view.LoginActivity;

/**
 * Created by ASUS on 2017/12/16.
 */

public class LoginPresenter {


    private LoginViewCallBack loginViewCallBack;
    private LoginModel loginModel;
    public LoginPresenter(LoginViewCallBack loginViewCallBack) {
        this.loginViewCallBack=loginViewCallBack;
        this.loginModel=new LoginModel();
    }

    public void getData(String yhm,String mm) {
        loginModel.getData(new LoginModelCallBack() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                loginViewCallBack.onSuccess(loginBean);
            }
        },yhm,mm);
    }
}
