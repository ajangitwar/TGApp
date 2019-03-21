package com.example.studentapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.service.autofill.RegexValidator;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static java.security.AccessController.getContext;

public class StudentLogin extends AppCompatActivity {
    EditText username,password;
    Window window;
    Button button;
    AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP) {
            window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.navColor));
        }

        username = findViewById(R.id.uname);
        password = findViewById(R.id.upass);
        button = findViewById(R.id.logbtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                awesomeValidation.addValidation(StudentLogin.this,R.id.uname,"[a-zA-Z\\s]+",R.string.txterr);
                awesomeValidation.addValidation(StudentLogin.this,R.id.upass,"[a-zA-Z\\s]+",R.string.txterr);
                if(awesomeValidation.validate()){
                    Login();
                }
            }
        });
    }
    private void Login() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.42.207/Reaper/StudentLogin.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonObject = new JSONObject(response);

                    JSONArray jsonArray = jsonObject.getJSONArray("studentObj");
                    JSONObject data = jsonArray.getJSONObject(0);
                    String status = data.getString("status");
                    if (status.equals("true")) {
                        UserSes userSes = new UserSes(StudentLogin.this);
//                        Toast.makeText(LoginActivity.this, String.valueOf(data.getInt("TID")), Toast.LENGTH_SHORT).show();
                        userSes.setName(data.getString("fullname"));
                        userSes.setSid(String.valueOf(data.getInt("SID")));


                        Toast.makeText(StudentLogin.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(StudentLogin.this,StudentHome.class);
//                        intent.putExtra("name",userSes.getName());
                        startActivity(intent);finish();

                    }else if (status.equals("false")){
                        Toast.makeText(StudentLogin.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(StudentLogin.this, "Something went wrong" , Toast.LENGTH_SHORT).show();
                    }
                }catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(StudentLogin.this, "Volley error" + error, Toast.LENGTH_SHORT).show();
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

        Volley.newRequestQueue(StudentLogin.this).add(stringRequest);

    }
}
