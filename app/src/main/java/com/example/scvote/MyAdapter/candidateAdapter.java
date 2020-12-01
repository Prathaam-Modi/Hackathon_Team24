package com.example.scvote.MyAdapter;


import android.content.Context;
import android.content.Intent;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.example.scvote.R;
import com.example.scvote.model.Candidate;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.ArrayList;


public class candidateAdapter extends RecyclerView.Adapter<candidateAdapter.candidateHolder> {


    private Context context;
    ArrayList<Candidate> data;

    public candidateAdapter(Context context, ArrayList<Candidate> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public candidateHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.candi,parent,false);
        candidateHolder viewholder= new candidateHolder(view);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull candidateHolder holder, final int position) {

        holder.candiname.setText(data.get(position).getName().toString());
        holder.candipos.setText(data.get(position).getPos().toString());
        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseFirestore mydb=FirebaseFirestore.getInstance();
                mydb.collection("candidates").document(data.get(position).getName()).delete();

            }
        });




    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class candidateHolder extends RecyclerView.ViewHolder{

        TextView candiname,candipos;
        Button del;



        public candidateHolder(@NonNull View itemView) {
            super(itemView);


            candiname=itemView.findViewById(R.id.candi_name);
            candipos=itemView.findViewById(R.id.candi_pos);
            del=itemView.findViewById(R.id.btncandel);



        }
    }


}
