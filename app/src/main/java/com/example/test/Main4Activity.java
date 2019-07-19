package com.example.test;

import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.IdentityHashMap;

public class Main4Activity<sex, switch1> extends AppCompatActivity implements View.OnClickListener {
    private EditText namepp;
    private EditText accountpp;
    private EditText passwardpp;
    private EditText telepp;
    private SeekBar sb_normal;
    private TextView txt_cur;
    private Context mcontext;
    private RadioGroup sex;
    private Switch mswitch;
    private  String sexin;
    private  String vipin;
    private  int processx;
    private Button ok;
    information pp=new information();//java中每个变量相当于指针，所以要既定义指针 还要给他传递空间，一条龙
    @Override//代码从oncreate开始走
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        mcontext = Main4Activity.this;
        bindViews();
        namepp=findViewById(R.id.name);
        accountpp=findViewById(R.id.account);
        passwardpp=findViewById(R.id.passward);
        telepp=findViewById(R.id.telephone);
        ok =findViewById(R.id.ok);
        sex=(RadioGroup)findViewById(R.id.sex);
        mswitch=(Switch)findViewById(R.id.switch1);
        namepp.setOnClickListener(this);
        accountpp.setOnClickListener(this);
        passwardpp.setOnClickListener(this);
        telepp.setOnClickListener(this);

        sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id=group.getCheckedRadioButtonId();
                RadioButton choise=(RadioButton)findViewById(id);
                sexin=choise.getText().toString();
                pp.setSexxx(sexin);

            }
        });
        mswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    String a1="会员";
                    pp.setVipxxx(a1);
                }
                else
                {
                    String a2="会员";
                    pp.setVipxxx(a2);
                }
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      String str1 = namepp.getText().toString();//活动中的组件可以直接存信息，直接提取就可以
                                      pp.setName(str1);
                                      String str2 = passwardpp.getText().toString();
                                      pp.setCode(str2);
                                      String str3 = telepp.getText().toString();
                                      pp.setTelephone(str3);
                                      String str4=accountpp.getText().toString();
                                      pp.setAccount(str4);
                                      processx = sb_normal.getProgress();
                                      pp.setWeight(processx);
                                      Intent intent =new Intent();//建立了个回去的路（来的时候已经标明，不用再标一遍）
                                      Bundle bundle=new Bundle();//建立个包
                                      bundle.putSerializable("kq",pp);//把pp放进包中，并起名kq
                                      intent.putExtras(bundle);//把包放路上运回去
                                      setResult(RESULT_OK,intent);//ok就走了
                                      Toast.makeText(Main4Activity.this,"注册成功",Toast.LENGTH_LONG).show();
                                      finish();//运完包就销毁路

                                  }
                              }

                );


    }
    private void bindViews() {
        sb_normal=(SeekBar)findViewById(R.id.seekbar1);
        txt_cur=(TextView)findViewById(R.id.data);
        sb_normal.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txt_cur.setText("当前进度值:" + progress + "  / 100 公斤");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
    @Override
    public void onClick(View v) {

    }
}
