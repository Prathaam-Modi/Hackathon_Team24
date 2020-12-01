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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Transaction;

import java.util.HashMap;
import java.util.Random;

public class HomeActivity3 extends AppCompatActivity {

    private Button finish;
    FirebaseFirestore mydb;
    private RadioButton cs[]=new RadioButton[5];
    private RadioGroup vprg;
    private Button next;
    String selcan;
    String vpstr,lsstr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home3);
        next=findViewById(R.id.finbtn);
        mydb=FirebaseFirestore.getInstance();
        cs[0]=findViewById(R.id.cs1);
        cs[1]=findViewById(R.id.cs2);
        cs[2]=findViewById(R.id.cs3);
        cs[3]=findViewById(R.id.cs4);
        cs[4]=findViewById(R.id.cs5);
        vprg=findViewById(R.id.radioGroup4);

        vpstr = getIntent().getStringExtra("Vice President");
        lsstr = getIntent().getStringExtra("Literary Sec");
        Log.d("#36323236","activity 3");
        Log.d("#36323236",vpstr);
        Log.d("#36323236",lsstr);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final DocumentReference sfDocRef = mydb.collection("candidates").document(vpstr);

                mydb.runTransaction(new Transaction.Function<Void>() {
                    @Override
                    public Void apply(Transaction transaction) throws FirebaseFirestoreException {
                        DocumentSnapshot snapshot = transaction.get(sfDocRef);

                        String newVotes=Integer.toString(Integer.parseInt(snapshot.getData().get("votes").toString())+1);

                        transaction.update(sfDocRef, "votes", newVotes);

                        // Success
                        return null;
                    }
                });


                final DocumentReference sfDocRef2 = mydb.collection("candidates").document(lsstr);

                mydb.runTransaction(new Transaction.Function<Void>() {
                    @Override
                    public Void apply(Transaction transaction) throws FirebaseFirestoreException {
                        DocumentSnapshot snapshot = transaction.get(sfDocRef2);

                        String newVotes=Integer.toString(Integer.parseInt(snapshot.getData().get("votes").toString())+1);

                        transaction.update(sfDocRef2, "votes", newVotes);

                        // Success
                        return null;
                    }
                });


                final DocumentReference sfDocRef3 = mydb.collection("candidates").document(selcan);

                mydb.runTransaction(new Transaction.Function<Void>() {
                    @Override
                    public Void apply(Transaction transaction) throws FirebaseFirestoreException {
                        DocumentSnapshot snapshot = transaction.get(sfDocRef3);

                        String newVotes=Integer.toString(Integer.parseInt(snapshot.getData().get("votes").toString())+1);

                        transaction.update(sfDocRef3, "votes", newVotes);

                        // Success
                        return null;
                    }
                });








            }
        });


        vprg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){

                    case R.id.cs1:
                        selcan=cs[0].getText().toString();
                        break;

                    case R.id.cs2:
                        selcan=cs[1].getText().toString();
                        break;

                    case R.id.cs3:
                        selcan=cs[2].getText().toString();
                        break;

                    case R.id.cs4:
                        selcan=cs[3].getText().toString();
                        break;

                    case R.id.cs5:
                        selcan=cs[4].getText().toString();
                        break;

                }
            }
        });




        mydb.collection("candidates").whereEqualTo("Pos","General Sec").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                int i=0;
                for(QueryDocumentSnapshot doc:task.getResult()){
                    cs[i].setVisibility(View.VISIBLE);
                    cs[i].setText(doc.getData().get("Name").toString());
                    i++;

                }

            }
        });

    }
}