package com.example.tgapp;

import android.content.Context;
import android.content.SharedPreferences;

public class UserSes {
    private String name,email,salutation,mobile;
    private String tid;

    private SharedPreferences sharedPreferences;
    private Context context;
    public UserSes(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences("userinfo",Context.MODE_PRIVATE);
    }
    public void removeUser(){
        sharedPreferences.edit().clear().apply();
    }

    public String getName() {
        name = sharedPreferences.getString("username","");
        return name;
    }

    public void setName(String name) {
        this.name = name;
       sharedPreferences.edit().putString("username",name).apply();

    }
    public String getTid() {
        tid = sharedPreferences.getString("id","");
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
        sharedPreferences.edit().putString("id",tid).apply();

    }
    public String getEmail() {
        email = sharedPreferences.getString("useremail","");
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        sharedPreferences.edit().putString("useremail",email).apply();

    }
}
