package com.example.tgapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

public class Welcome extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3500;
    Window window;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final UserSes userSes = new UserSes(Welcome.this);

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP) {
            window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.navColor));
        }

        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){
                if (userSes.getName() != "") {
                    Intent homeIntent = new Intent(Welcome.this, tg_home.class);
                    startActivity(homeIntent);
                    finish();
                }else {
                    Intent homeIntent = new Intent(Welcome.this, LoginActivity.class);
                    startActivity(homeIntent);
                    finish();
                }
            }
        },SPLASH_TIME_OUT);
    }
}
