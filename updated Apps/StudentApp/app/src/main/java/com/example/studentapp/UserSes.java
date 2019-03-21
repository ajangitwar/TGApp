package com.example.studentapp;

import android.content.Context;
import android.content.SharedPreferences;

public class UserSes {
    private String name,email,salutation,mobile;
    private String sid;
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
        name = sharedPreferences.getString("name","");
        return name;
    }

    public void setName(String name) {
        this.name = name;
       sharedPreferences.edit().putString("name",name).apply();

    }

    public String getSid() {
        sid = sharedPreferences.getString("id","");
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
        sharedPreferences.edit().putString("SID",sid).apply();
    }
}
