package com.example.scvote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Random;

public class HomeActivity2 extends AppCompatActivity {

    FirebaseFirestore mydb;
    private RadioButton ls[]=new RadioButton[5];
    private RadioGroup vprg;
    private Button next;
    String selcan;
    String vpstr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        next=findViewById(R.id.next2btn);
        mydb=FirebaseFirestore.getInstance();
        ls[0]=findViewById(R.id.ls1);
        ls[1]=findViewById(R.id.ls2);
        ls[2]=findViewById(R.id.ls3);
        ls[3]=findViewById(R.id.ls4);
        ls[4]=findViewById(R.id.ls5);
        vprg=findViewById(R.id.radioGroup3);

        vpstr = getIntent().getStringExtra("Vice President");

        Log.d("#36323236","task1");

        Log.d("#36323236",vpstr);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                HashMap<String,Object> test=new HashMap<>();
//                Random rand=new Random();
//                int n=rand.nextInt(10000);
//
//                mydb.collection("candidates").document(selcan).collection("votes").document(Integer.toString(n)).set(test).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        startActivity(new Intent(getApplicationContext(),HomeActivity3.class));
//
//
//                    }
//                });

                Intent intent=new Intent(HomeActivity2.this,HomeActivity3.class);

                intent.putExtra("Vice President",vpstr);
                intent.putExtra("Literary Sec",selcan);
                startActivity(intent);

            }
        });


        vprg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){

                    case R.id.ls1:
                        selcan=ls[0].getText().toString();
                        break;

                    case R.id.ls2:
                        selcan=ls[1].getText().toString();
                        break;

                    case R.id.ls3:
                        selcan=ls[2].getText().toString();
                        break;

                    case R.id.ls4:
                        selcan=ls[3].getText().toString();
                        break;

                    case R.id.ls5:
                        selcan=ls[4].getText().toString();
                        break;

                }
            }
        });




        mydb.collection("candidates").whereEqualTo("Pos","Literary Sec").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                int i=0;
                for(QueryDocumentSnapshot doc:task.getResult()){
                    ls[i].setVisibility(View.VISIBLE);
                    ls[i].setText(doc.getData().get("Name").toString());
                    i++;

                }

            }
        });
    }
}