package com.example.tgapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {
    private Context cnt;
    private ArrayList<StudentModal> mArrayList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void OnItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public Adapter(Context cnt, ArrayList<StudentModal> mArrayList) {
        this.cnt = cnt;
        this.mArrayList = mArrayList;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(cnt).inflate(R.layout.studentcell,parent,false);

        return  new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder Holder, int i) {
        StudentModal studentModal = mArrayList.get(i);

        int SID  = studentModal.getSID();
        String fullname = studentModal.getFullname();
        String year = studentModal.getYear();
        String semester  = studentModal.getSemester();

        Holder.SID.setText(SID);
        Holder.fullname.setText(fullname);
        Holder.year.setText(year);
        Holder.semester.setText(semester);

    }


    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        TextView SID,fullname,year,semester;


        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            SID = itemView.findViewById(R.id.SID);
            fullname = itemView.findViewById(R.id.fullname);
            year = itemView.findViewById(R.id.year);
            semester = itemView.findViewById(R.id.semester);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mListener.OnItemClick(position);
                        }
                    }
                }
            });
        }
    }

}
