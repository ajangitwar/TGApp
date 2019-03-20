package com.example.tgapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    Window window;
    EditText username,password;
//    public static PrefConfig prefConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.navColor));
        }

        username = findViewById(R.id.uname);
        password = findViewById(R.id.upass);
        final Button button = findViewById(R.id.logbtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Login();
            }
        });

    }
    private void Login() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.42.209/Reaper/Teacherlogin.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("True")) {
                    UserSes userSes = new UserSes(LoginActivity.this);
                    userSes.setName(username.getText().toString());
                    Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,tg_home.class);
                    intent.putExtra("name",userSes.getName());
                    startActivity(intent);finish();
                }else if (response.equals("False")){
                    Toast.makeText(LoginActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this, "Something went wrong" , Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, "Volley error" + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("username", username.getText().toString());
                params.put("password", password.getText().toString());
                return params;
            }
        };

        Volley.newRequestQueue(LoginActivity.this).add(stringRequest);

    }
}
