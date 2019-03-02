package com.example.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StudentLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        final Button button = findViewById(R.id.logbtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Toast.makeText(StudentLogin.this,"Successfully Login",Toast.LENGTH_SHORT).show();
                Intent activityChangeIntent = new Intent(StudentLogin.this, StudentHome.class);

                // currentContext.startActivity(activityChangeIntent);


                StudentLogin.this.startActivity(activityChangeIntent);
                finish();
            }
        });
    }
}
