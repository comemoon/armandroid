package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener{
    private EditText zhanghaoff;
    private EditText mimaff;
    private  EditText telephone;
    private Button queding;
    information pp=new information();//java中每个变量相当于指针，所以要既定义指针 还要给他传递空间，一条龙
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        zhanghaoff=findViewById(R.id.zhanghaoff);
        mimaff=findViewById(R.id.mimaff);
        telephone=findViewById(R.id.dianhuaff);
        queding=findViewById(R.id.queding);

        zhanghaoff.setOnClickListener(this);
        mimaff.setOnClickListener(this);//监听器这三个
        telephone.setOnClickListener(this);
        /* 匿名类 */
        queding.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String  str1=zhanghaoff.getText().toString();//活动中的组件可以直接存信息，直接提取就可以
                pp.setName(str1);
                String str2=mimaff.getText().toString();
                pp.setCode(str2);
                String str3=telephone.getText().toString();
                pp.setTelephone(str3);
               //把账号、密码和电话传给pp这个类中

                Intent intent =new Intent();//建立了个回去的路（来的时候已经标明，不用再标一遍）
                Bundle bundle=new Bundle();//建立个包
                bundle.putSerializable("kq",pp);//把pp放进包中，并起名kq
                intent.putExtras(bundle);//把包放路上运回去
                setResult(RESULT_OK,intent);//ok就走了
                Toast.makeText(Main3Activity.this,"注册成功",Toast.LENGTH_LONG).show();
                finish();//运完包就销毁路
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
