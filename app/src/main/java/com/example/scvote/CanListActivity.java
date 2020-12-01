package com.example.scvote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.scvote.MyAdapter.candidateAdapter;
import com.example.scvote.model.Candidate;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class CanListActivity extends AppCompatActivity {


    FirebaseFirestore mydb;
    RecyclerView cycle1;
    ArrayList<Candidate> candiarray;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_can_list);

        mydb=FirebaseFirestore.getInstance();
        cycle1=findViewById(R.id.cycle1);
        candiarray=new ArrayList<>();


        //fetch //fetch complete collection
        mydb.collection("candidates").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                candiarray.clear();
                    for(QueryDocumentSnapshot Doc:value){
                        Candidate data=new Candidate(); //creating candidate object
                        data.setName(Doc.getData().get("Name").toString());
                        data.setPos(Doc.getData().get("Pos").toString());
                        candiarray.add(data); //adding objects to array candidate



                    }

                    cycle1.setHasFixedSize(true);
                    layoutManager=new LinearLayoutManager(CanListActivity.this);
                    cycle1.setLayoutManager(layoutManager);
                    candidateAdapter MyAdapter=new candidateAdapter(CanListActivity.this,candiarray); //passing candiarray

                    cycle1.setAdapter(MyAdapter);




            }


        }) ;







    }
}