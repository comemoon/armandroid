package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    private EditText a1,a2,a3,a4,a5,a6,a7;
    information mn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();//因为他不是往返的路，所以只能接收
        mn=(information)intent.getSerializableExtra("we");//mn接收了包裹，强制转换

        a1=findViewById(R.id.zhanghao);
        a2=findViewById(R.id.mima);
        a3=findViewById(R.id.dianhua);//建立了联系与组件
        a4=findViewById(R.id.mingzi);
        a5=findViewById(R.id.shenfen);
        a6=findViewById(R.id.xingbie);
        a7=findViewById(R.id.tizhong);

        a1.setText(mn.getAccount());//输出显示

        a2.setText(mn.getCode());

        a3.setText(mn.getTelephone());

        a4.setText(mn.getName());

        a5.setText(mn.getVipxxx());

        a6.setText(mn.getSexxx());

        a7.setText(mn.getWeight()+"");


    }
}
