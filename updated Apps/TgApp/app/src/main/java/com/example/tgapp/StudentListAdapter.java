package com.example.tgapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.MyViewHolder> {


    Context mContext;
    List<StudentModal> mdata;

    public StudentListAdapter(Context mContext, List<StudentModal> mdata) {
        this.mContext = mContext;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.studentcell,null);
        MyViewHolder vHolder = new MyViewHolder(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        final String name = mdata.get(i).getFullname();
        holder.sid.setText(String.valueOf(mdata.get(i).getSID()));
        holder.name.setText(mdata.get(i).getFullname());
        holder.year.setText(mdata.get(i).getYear());
        holder.semester.setText(mdata.get(i).getSemester());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(mContext, StudentDetails.class);
                homeIntent.putExtra("name",name);
                mContext.startActivity(homeIntent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView sid,name,year,semester;
        public LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name =  itemView.findViewById(R.id.get);
            sid =  itemView.findViewById(R.id.SID);
            year =  itemView.findViewById(R.id.year);
            semester =  itemView.findViewById(R.id.l);
            linearLayout = itemView.findViewById(R.id.linear);


        }
    }
}