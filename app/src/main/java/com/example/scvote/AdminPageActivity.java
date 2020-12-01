package com.example.scvote;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminPageActivity extends AppCompatActivity {

    private EditText adminemail;
    private EditText adminpassword;
    private Button adminpagelogin;
    private String setadminemail= "admin@gmail.com";
    private String setadminpassword= "123456";

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        adminemail=(EditText)findViewById(R.id.adminemailtxt);
        adminpassword=(EditText)findViewById(R.id.adminpasswordtxt);
        adminpagelogin=findViewById(R.id.adminpageloginbtn);

        adminpagelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aEmail=adminemail.getText().toString().trim();
                String aPass=adminpassword.getText().toString().trim();

                if(TextUtils.isEmpty(aEmail)){
                    adminemail.setError("Required Field..");
                    return;
                }
                if(TextUtils.isEmpty(aPass)){
                    adminpassword.setError("Required Field..");
                    return;
                }
                if(aEmail.equals(setadminemail) && aPass.equals(setadminpassword)){
                    startActivity(new Intent(getApplicationContext(),AdminHomeActivity.class));
                    Toast.makeText(getApplicationContext(),"Login Complete",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });














    }
}