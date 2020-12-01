package com.example.scvote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class HomeActivity extends AppCompatActivity {

    FirebaseFirestore mydb;
    private RadioButton vp[]=new RadioButton[5];
    private RadioGroup vprg;
    private Button next;
    String selcan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        next=findViewById(R.id.next1btn);
        mydb=FirebaseFirestore.getInstance();
        vp[0]=findViewById(R.id.vp1);
        vp[1]=findViewById(R.id.vp2);
        vp[2]=findViewById(R.id.vp3);
        vp[3]=findViewById(R.id.vp4);
        vp[4]=findViewById(R.id.vp5);
        vprg=findViewById(R.id.radioGroup2);


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
//                        startActivity(new Intent(getApplicationContext(),HomeActivity2.class));
                        
//
//                    }
//                });

               Intent intent=new Intent(HomeActivity.this,HomeActivity2.class);

               intent.putExtra("Vice President",selcan);
               startActivity(intent);



            }
        });


        vprg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){

                    case R.id.vp1:
                            selcan=vp[0].getText().toString();
                            break;

                    case R.id.vp2:
                        selcan=vp[1].getText().toString();
                        break;

                    case R.id.vp3:
                        selcan=vp[2].getText().toString();
                        break;

                    case R.id.vp4:
                        selcan=vp[3].getText().toString();
                        break;

                    case R.id.vp5:
                        selcan=vp[4].getText().toString();
                        break;

                }
            }
        });




        mydb.collection("candidates").whereEqualTo("Pos","Vice President").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                int i=0;
                for(QueryDocumentSnapshot doc:task.getResult()){
                    vp[i].setVisibility(View.VISIBLE);
                    vp[i].setText(doc.getData().get("Name").toString());
                    i++;

                }

            }
        });

    }
}