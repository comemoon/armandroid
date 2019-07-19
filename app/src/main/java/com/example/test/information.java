package com.example.test;

import java.io.Serializable;

public class information implements Serializable {//建立的类 要加  implements Serializable  才会被使用
    private String name;
    private String account;
    private String code;
    private String telephone;
    private int weight;
    private String sexxx;
    private String vipxxx;

    information(){}//要写默认构造！
    public information(String cname,String caccount, String ccode, String ctelephone,int cweight,String csexxx,String cvipxxx)
    {
        name=cname;
        account=caccount;
        code=ccode;
        telephone=ctelephone;
        weight=cweight;
        sexxx=csexxx;
        vipxxx=cvipxxx;
    }
    public String getName() {
        return name;
    }
    public String getAccount(){return account;}
    public String getCode() {
        return code;
    }
    public String getTelephone() {
        return telephone;
    }
    public int getWeight(){return weight;}
    public String getSexxx(){return  sexxx;}
    public  String getVipxxx(){return  vipxxx;}

    public void setName(String name) {
        this.name = name;
    }
    public  void  setAccount(String account) {this.account=account;}
    public  void setWeight(int weight){this.weight=weight;}
    public  void setSexxx(String sexxx){this.sexxx=sexxx;}
    public  void setVipxxx(String vipxxx){this.vipxxx=vipxxx;};
    public void setCode(String code) {
        this.code = code;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
