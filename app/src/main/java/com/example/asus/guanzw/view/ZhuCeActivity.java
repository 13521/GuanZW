package com.example.asus.guanzw.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.asus.guanzw.R;
import com.example.asus.guanzw.bean.ZhuCeBean;
import com.example.asus.guanzw.myinterface.ZhuCeViewCallBack;
import com.example.asus.guanzw.presenter.ZhuCePresenter;

public class ZhuCeActivity extends AppCompatActivity implements ZhuCeViewCallBack{

    private ImageView imaeback;
    private EditText edit_yhm;
    private EditText edit_mm;
    private Button e_zhuce;
    private ZhuCePresenter zhuCePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
        imaeback = findViewById(R.id.imaeback);
        edit_yhm = findViewById(R.id.edit_yhm);
        edit_mm = findViewById(R.id.edit_mm);
        e_zhuce = findViewById(R.id.e_zhuce);

        //初始化Presenter
        initpresenter();

        //设置返回
        setBack();

        e_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String yhm = edit_yhm.getText().toString();
                String mm = edit_mm.getText().toString();

                if(edit_yhm==null||yhm.equals("")||yhm==null||edit_mm==null||mm.equals("")||mm==null){
                    Toast.makeText(ZhuCeActivity.this,"用户名或密码为空",Toast.LENGTH_SHORT).show();
                }else {
                    zhuCePresenter.getData(yhm,mm);
                }
            }
        });


    }
    @Override
    public void onSuccess(ZhuCeBean zhuCeBean) {
        Toast.makeText(this,zhuCeBean.getMsg(),Toast.LENGTH_SHORT).show();
        finish();
    }

    private void initpresenter() {
        zhuCePresenter = new ZhuCePresenter(this);
    }

    //设置返回
    private void setBack() {
        imaeback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
