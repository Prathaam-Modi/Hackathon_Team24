package com.example.scvote;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class LiveCounting extends AppCompatActivity {

    FirebaseFirestore mydb;

    RelativeLayout relativeLayout[]=new RelativeLayout[5];
    RelativeLayout relativeLayout_[]=new RelativeLayout[5];
    RelativeLayout relativeLayout__[]=new RelativeLayout[5];


    TextView vp_name[]=new TextView[5];
    TextView vp_count[]=new TextView[5];

    TextView ls_name[]=new TextView[5];
    TextView ls_count[]=new TextView[5];

    TextView gs_name[]=new TextView[5];
    TextView gs_count[]=new TextView[5];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.live_counting);
        mydb=FirebaseFirestore.getInstance();

        relativeLayout[0]=findViewById(R.id.live_counting_layout1);
        relativeLayout[1]=findViewById(R.id.live_counting_layout2);
        relativeLayout[2]=findViewById(R.id.live_counting_layout3);
        relativeLayout[3]=findViewById(R.id.live_counting_layout4);
        relativeLayout[4]=findViewById(R.id.live_counting_layout5);


        relativeLayout_[0]=findViewById(R.id.live_counting_layout6);
        relativeLayout_[1]=findViewById(R.id.live_counting_layout7);
        relativeLayout_[2]=findViewById(R.id.live_counting_layout8);
        relativeLayout_[3]=findViewById(R.id.live_counting_layout9);
        relativeLayout_[4]=findViewById(R.id.live_counting_layout10);


        relativeLayout__[0]=findViewById(R.id.live_counting_layout11);
        relativeLayout__[1]=findViewById(R.id.live_counting_layout12);
        relativeLayout__[2]=findViewById(R.id.live_counting_layout13);
        relativeLayout__[3]=findViewById(R.id.live_counting_layout14);
        relativeLayout__[4]=findViewById(R.id.live_counting_layout15);




        vp_name[0]=findViewById(R.id.live_counting_textview_name1);
        vp_name[1]=findViewById(R.id.live_counting_textview_name2);
        vp_name[2]=findViewById(R.id.live_counting_textview_name3);
        vp_name[3]=findViewById(R.id.live_counting_textview_name4);
        vp_name[4]=findViewById(R.id.live_counting_textview_name5);


        vp_count[0]=findViewById(R.id.live_counting_textview_count1);
        vp_count[1]=findViewById(R.id.live_counting_textview_count2);
        vp_count[2]=findViewById(R.id.live_counting_textview_count3);
        vp_count[3]=findViewById(R.id.live_counting_textview_count4);
        vp_count[4]=findViewById(R.id.live_counting_textview_count5);

        ls_name[0]=findViewById(R.id.live_counting_textview_name6);
        ls_name[1]=findViewById(R.id.live_counting_textview_name7);
        ls_name[2]=findViewById(R.id.live_counting_textview_name8);
        ls_name[3]=findViewById(R.id.live_counting_textview_name9);
        ls_name[4]=findViewById(R.id.live_counting_textview_name10);


        ls_count[0]=findViewById(R.id.live_counting_textview_count6);
        ls_count[1]=findViewById(R.id.live_counting_textview_count7);
        ls_count[2]=findViewById(R.id.live_counting_textview_count8);
        ls_count[3]=findViewById(R.id.live_counting_textview_count9);
        ls_count[4]=findViewById(R.id.live_counting_textview_count10);

        gs_name[0]=findViewById(R.id.live_counting_textview_name11);
        gs_name[1]=findViewById(R.id.live_counting_textview_name12);
        gs_name[2]=findViewById(R.id.live_counting_textview_name13);
        gs_name[3]=findViewById(R.id.live_counting_textview_name14);
        gs_name[4]=findViewById(R.id.live_counting_textview_name15);


        gs_count[0]=findViewById(R.id.live_counting_textview_count11);
        gs_count[1]=findViewById(R.id.live_counting_textview_count12);
        gs_count[2]=findViewById(R.id.live_counting_textview_count13);
        gs_count[3]=findViewById(R.id.live_counting_textview_count14);
        gs_count[4]=findViewById(R.id.live_counting_textview_count15);




        mydb.collection("candidates").whereEqualTo("Pos", "Vice President").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                int i=0;
                for(QueryDocumentSnapshot doc:value)
                {
                    relativeLayout[i].setVisibility(View.VISIBLE);
                    vp_name[i].setText(doc.getData().get("Name").toString());
                    vp_count[i].setText(doc.getData().get("votes").toString());
                    i++;
                }
            }
        });

        mydb.collection("candidates").whereEqualTo("Pos", "Literary Sec").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                int i=0;
                for(QueryDocumentSnapshot doc:value)
                {
                    relativeLayout_[i].setVisibility(View.VISIBLE);
                    ls_name[i].setText(doc.getData().get("Name").toString());
                    ls_count[i].setText(doc.getData().get("votes").toString());
                    i++;
                }
            }
        });

        mydb.collection("candidates").whereEqualTo("Pos", "General Sec").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                int i=0;
                for(QueryDocumentSnapshot doc:value)
                {
                    relativeLayout__[i].setVisibility(View.VISIBLE);
                    gs_name[i].setText(doc.getData().get("Name").toString());
                    gs_count[i].setText(doc.getData().get("votes").toString());
                    i++;
                }
            }
        });










    }
}