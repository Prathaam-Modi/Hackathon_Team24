package com.example.scvote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.lang.reflect.Member;
import java.util.HashMap;

public class AddCandidateActivity extends AppCompatActivity {

    private Button addcan;
    Member member;
    private RadioButton aone,atwo,athree;
    FirebaseDatabase rootNode;
    FirebaseFirestore mydb;
    String ch;
    DatabaseReference reference;
    int i = 0;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_candidate);
        mydb=FirebaseFirestore.getInstance();

        addcan=findViewById(R.id.addcandibtn);

        RadioButton aone=findViewById(R.id.radioone);
        RadioButton atwo=findViewById(R.id.radiotwo);
        RadioButton athree=findViewById(R.id.radiothree);

        name=findViewById(R.id.addcannametxt);
        addcan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get all the values
                String cname=name.getText().toString().trim();

                if(aone.isChecked()){
                    ch="General Sec";
                }
                if(atwo.isChecked()){
                    ch="Literary Sec";
                }
                if(athree.isChecked()){
                    ch="Vice President";
                }
                HashMap<String,Object> candidate=new HashMap<>();

                candidate.put("Name",cname);
                candidate.put("Pos",ch);
                candidate.put("votes","0");

                mydb.collection("candidates").document(cname).set(candidate);
                Toast.makeText(AddCandidateActivity.this, "Candidate has been added!", Toast.LENGTH_SHORT).show();
//
            }
        });

    }
}