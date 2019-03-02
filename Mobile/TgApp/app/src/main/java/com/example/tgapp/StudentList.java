package com.example.tgapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

//class ListContent extends AppCompatActivity{
//    ListView listView;
//    List list = new ArrayList();
//    ArrayAdapter<> adapter;
//
//    public ListContent() {
//        setContentView(R.layout.fragment_studentlist);
//
//        listView = findViewById(R.id.list_view);
//
//        for (int i = 0; i < 15 ; i++ ){
//            list.add("Orange");
//        }
//
//        adapter = new ArrayAdapter(ListContent.this ,android.R.layout.simple_list_item_1,list);
//        listView.setAdapter(adapter);
//    }
//}

public class StudentList extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_studentlist,container, false);

        ArrayList<String> list_item = new ArrayList<String>();

        for (int i = 0; i < 20 ; i++ ) list_item.add("Abhishek Jangitwar"+(i+1));

        ListView listView = (ListView) view.findViewById(R.id.list_view);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                list_item
        );

        listView.setAdapter(listViewAdapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Student List");
    }

}