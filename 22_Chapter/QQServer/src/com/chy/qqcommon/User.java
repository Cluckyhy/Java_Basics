package com.chy.qqcommon;

import java.io.Serializable;

//表示一个用户/客户信息
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userid;  //用户ID/用户名
    private String passwd;  //用户密码

    public User(String userid, String passwd) {
        this.userid = userid;
        this.passwd = passwd;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
