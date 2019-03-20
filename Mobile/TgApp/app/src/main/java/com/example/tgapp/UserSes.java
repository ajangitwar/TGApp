package com.example.tgapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class UserSes {
    private String name;
    private SharedPreferences sharedPreferences;
    private Context context;
    public UserSes(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences("userinfo",Context.MODE_PRIVATE);
    }
    public void removeUser(){
        sharedPreferences.edit().clear().commit();
    }

    public String getName() {
        name = sharedPreferences.getString("userdata","");
        return name;
    }

    public void setName(String name) {
        this.name = name;
       sharedPreferences.edit().putString("userdata",name).commit();

    }
}
