package com.example.tgapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class profile extends Fragment {

    RelativeLayout relativeLayout;
    TableRow tr;
    TextView sem,year,full,sid;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile,container, false);
    ParseData();
        relativeLayout  = view.findViewById(R.id.relative);
        tr = view.findViewById(R.id.tb1);
        sem = view.findViewById(R.id.semester);
        year = view.findViewById(R.id.year);
        full = view.findViewById(R.id.fullname);
        sid = view.findViewById(R.id.SID);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Profile");
    }

    public void ParseData(){
        String URL = "http://192.168.42.159/Reaper/getStudent.php";
        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    JSONArray jsonArray = jsonObject.getJSONArray("studentObj");
                    JSONObject data = jsonArray.getJSONObject(0);

                    sem.setText(String.valueOf(data.getInt("semester")));
                    full.setText(data.getString("fullname"));
                    //year.setText(data.getInt("year"));
                   // sid.setText(data.getInt("SID"));

                    Toast.makeText(getContext(), String.valueOf(data.getString("year")), Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    Toast.makeText(getContext(), "exception ala", Toast.LENGTH_SHORT).show();

                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Nhi ala", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });
        Volley.newRequestQueue(getContext()).add(request);

    }
}
