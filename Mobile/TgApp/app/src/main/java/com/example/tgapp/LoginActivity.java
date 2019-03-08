package com.example.tgapp;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Window window;
    public static PrefConfig prefConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.navColor));
        }

        prefConfig = new PrefConfig(this);

//        if (findViewById(R.id.drawer_layout) != null){
//            if (savedInstanceState != null){
//                return;
//            }
//            if (prefConfig.readLoginStatus()){
////                getSupportFragmentManager().beginTransaction().add(R.id.drawer_layout,new tg_home()).commit();
//                Intent intent = new Intent(this, tg_home.class);
//                startActivity(intent);
//                finish();
//            }else {
//                getSupportFragmentManager().beginTransaction().add(R.id.drawer_layout,new LoginFragment()).commit();
////                Intent intent = new Intent(this, LoginActivity.class);
////                startActivity(intent);
//
//            }
//        }

        final Button button = findViewById(R.id.logbtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Toast.makeText(LoginActivity.this,"Successfully Login",Toast.LENGTH_SHORT).show();
                Intent activityChangeIntent = new Intent(LoginActivity.this, tg_home.class);
                startActivity(activityChangeIntent);
                finish();
            }
        });

    }
}
