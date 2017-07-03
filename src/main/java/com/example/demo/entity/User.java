package com.example.demo.entity;

import java.io.Serializable;

/**
 * Created by zeng on 2017/6/22.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 2120869894112984147L;

    private String id;
    private String userName;
    private String password;
    private String realName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
