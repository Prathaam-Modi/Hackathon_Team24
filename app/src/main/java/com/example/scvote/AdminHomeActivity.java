package com.example.scvote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminHomeActivity extends AppCompatActivity {

    private Button btnaddcan_;
    private Button btncanlist_;
    private Button btncanpoll_;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        btnaddcan_=findViewById(R.id.btnaddcan);
        btncanlist_=findViewById(R.id.btncanlist);
        btncanpoll_=findViewById(R.id.btncanpoll);

        //btncanadd function
        btnaddcan_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddCandidateActivity.class));
            }
        });
        btncanlist_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),CanListActivity.class));
            }
        });

        btncanpoll_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminHomeActivity.this,LiveCounting.class);
                startActivity(intent);
            }
        });
    }
}