package com.example.test;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button start;
    private ImageView first;
    private ImageView why;
    private Button  two;
    private EditText edit1;
    private EditText edit2;
    private information q=null;//定义的类 q指针，且目前指针为空,空也是个对象，不是空指针

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start=findViewById(R.id.start);
        first=findViewById(R.id.first);//这俩都跟组件图片取得联系
        why=findViewById(R.id.first);//
        two=findViewById(R.id.two);
        edit1=findViewById(R.id.edit1);
        edit2=findViewById(R.id.edit2);
        start.setOnClickListener(this);//这些this的作用是让他能发挥功能
        two.setOnClickListener(this);
        edit1.setOnClickListener(this);
        edit2.setOnClickListener(this);
        first.setOnClickListener(this);
//把组件实现功能 先三部曲 1.private 定义同类型的变量，2.findViewById 与活动中组件建立联系，3.setOnClickListener 调用自己 或 采用匿名类

    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {//这是接受包的代码
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case 1://通行证是1的话
                if(resultCode== RESULT_OK)//必写 结果码为ok
                    q=(information)data.getSerializableExtra("kq");//q指针有了指向，不再为空指针，q接收了名为kq的包裹，强制转换
                break;
        }
    }
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                Intent intent=new Intent(this,Main4Activity.class);//活动3与本活动建立通道
                startActivityForResult(intent,1);//此通道是往返通道 许可证是1
                break;
            case R.id.two:
                String s1=edit1.getText().toString();
                String s2=edit2.getText().toString();
                if(q==null)
                {
                    Toast.makeText(MainActivity.this,"用户名不存在",Toast.LENGTH_SHORT).show();
                }
               else  if(q.getAccount().equals(s1)&&q.getCode().equals(s2))//java特有的判断是否相等的方法
                {
                    Bundle bundle=new Bundle();//建立了一个新包
                    Intent intent1=new Intent(this,Main2Activity.class);//建立了通往活动2的新道路
                    bundle.putSerializable("we",q);//包取名we
                    intent1.putExtras(bundle);

                    startActivity(intent1);//有去无回
                    Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.first:
                why.setImageResource(R.drawable.dianzan);
                Toast.makeText(MainActivity.this,"更换图片成功",Toast.LENGTH_SHORT).show();
                break;


        }
    }
}
