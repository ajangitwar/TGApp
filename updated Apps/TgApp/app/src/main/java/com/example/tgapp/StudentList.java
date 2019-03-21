package com.example.tgapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentList extends Fragment{
    RecyclerView myrecyclerview;
    List<StudentModal> lstContact;
    AdapterTest adapterTest;
    UserSes userSes;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_studentlist,container, false);
        adapterTest = new AdapterTest(getContext(),lstContact);
        myrecyclerview = (RecyclerView) view.findViewById(R.id.recyclesStd);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
                  getReports();
         myrecyclerview.setAdapter(adapterTest);
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userSes = new UserSes(getContext());
        lstContact = new ArrayList<>();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Student List");
    }

    void getReports(){

        final StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "http://192.168.42.207/Reaper/getStudentList.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObject = null;
                        Log.d("data",response);
                        try {
                            jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("studentObj");

                            lstContact = new ArrayList<>();
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject obj = jsonArray.getJSONObject(i);
                                String SID = obj.getString("SID");
                                String fullname = obj.getString("fullname");
                                String year = obj.getString("year");
                                String semester = obj.getString("semester");


                                StudentModal c = new StudentModal();
                                c.setSID(obj.getInt("SID"));
                                c.setFullname(obj.getString("fullname"));
                                c.setYear(obj.getString("year"));
                                c.setSemester(obj.getString("semester"));
                                lstContact.add(c);
                            }
                            AdapterTest recyclerViewAdapter = new AdapterTest(getContext(),lstContact);
                            myrecyclerview.setAdapter(recyclerViewAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("TID",userSes.getTid());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }

}