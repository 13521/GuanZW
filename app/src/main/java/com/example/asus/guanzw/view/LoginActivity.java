package com.example.asus.guanzw.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.guanzw.R;
import com.example.asus.guanzw.bean.LoginBean;
import com.example.asus.guanzw.myinterface.LoginViewCallBack;
import com.example.asus.guanzw.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginViewCallBack{

    private Button e_login;
    private EditText edit_yhm;
    private EditText edit_mm;
    private ImageView imaeback;
    private TextView to_zhuce;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        to_zhuce = findViewById(R.id.to_zhuce);
        e_login = findViewById(R.id.e_login);
        edit_yhm = findViewById(R.id.edit_yhm);
        edit_mm = findViewById(R.id.edit_mm);
        imaeback = findViewById(R.id.imaeback);

        //初始化presenter
        initPresenter();
        //跳转注册
        setToZhuCe();
        //设置返回
        setBack();

        e_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String yhm = edit_yhm.getText().toString();
                String mm = edit_mm.getText().toString();

                if(edit_yhm==null||yhm.equals("")||yhm==null||edit_mm==null||mm.equals("")||mm==null){
                    Toast.makeText(LoginActivity.this,"用户名或密码为空",Toast.LENGTH_SHORT).show();
                }else {

                    loginPresenter.getData(yhm,mm);
                }

            }
        });


    }

    private void setBack() {
        imaeback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initPresenter() {

        loginPresenter = new LoginPresenter(this);

    }
    @Override
    public void onSuccess(LoginBean loginBean) {


        if(loginBean.getMsg().equals("天呢！用户不存在")){

            Toast.makeText(this,loginBean.getMsg(),Toast.LENGTH_SHORT).show();

        }else {

            Toast.makeText(this,loginBean.getMsg(),Toast.LENGTH_SHORT).show();
            SharedPreferences sharedPreferences=getSharedPreferences("config",MODE_PRIVATE);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("islogin",true).commit();
            edit.putString("yhm",loginBean.getData().getMobile()).commit();

            finish();

            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }




    }

    private void setToZhuCe() {
        to_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,ZhuCeActivity.class));
            }
        });
    }
}
