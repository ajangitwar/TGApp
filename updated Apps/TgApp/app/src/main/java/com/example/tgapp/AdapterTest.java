package com.example.tgapp;

import android.content.Context;
        import android.support.annotation.NonNull;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextClock;
        import android.widget.TextView;

        import java.util.List;

public class AdapterTest extends RecyclerView.Adapter<AdapterTest.MyViewHolder> {


    Context mContext;
    List<StudentModal> mdata;

    public AdapterTest(Context mContext, List<StudentModal> mdata) {
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

        holder.sid.setText(String.valueOf(mdata.get(i).getSID()));
        holder.name.setText(mdata.get(i).getFullname());
        holder.year.setText(mdata.get(i).getYear());
        holder.semester.setText(mdata.get(i).getSemester());

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView sid,name,year,semester;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.fullname);
            sid = (TextView) itemView.findViewById(R.id.SID);
            year = (TextView) itemView.findViewById(R.id.year);
            semester = (TextView) itemView.findViewById(R.id.semester);


        }
    }
}