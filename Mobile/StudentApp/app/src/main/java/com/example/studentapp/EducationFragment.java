package com.example.studentapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EducationFragment extends Fragment {
    View view;
    TextView sscinsti,hscinsti,ssc,hsc,sscyr,hscyr,jee,mhtcet;
    TextView beinsti,branch,sem1,sem2,sem3,sem4,sem5,sem6,sem7,sem8,backlog;

    public EducationFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       view = inflater.inflate(R.layout.education_fragment,container,false);

        sscinsti = view.findViewById(R.id.sscinsti);
        hscinsti = view.findViewById(R.id.hscinsti);
        ssc = view.findViewById(R.id.ssc);
        hsc = view.findViewById(R.id.hsc);
        sscyr = view.findViewById(R.id.sscyr);
        hscyr = view.findViewById(R.id.hscyr);
        jee = view.findViewById(R.id.jee);
        mhtcet = view.findViewById(R.id.mhtcet);

        beinsti = view.findViewById(R.id.beinsti);
        branch = view.findViewById(R.id.branch);
        sem1 = view.findViewById(R.id.sem1);
        sem2 = view.findViewById(R.id.sem2);
        sem3 = view.findViewById(R.id.sem3);
        sem4 = view.findViewById(R.id.sem4);
        sem5 = view.findViewById(R.id.sem5);
        sem6 = view.findViewById(R.id.sem6);
        sem7 = view.findViewById(R.id.sem7);
        sem8 = view.findViewById(R.id.sem8);

        getGeneralEduInfo();
        getBEInfo();

       return view;
    }
    public void getGeneralEduInfo(){
        String URL = "http://192.168.42.221/Reaper/getTeacher.php";
        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    JSONArray jsonArray = jsonObject.getJSONArray("GeneralEduObj");
                    JSONObject data = jsonArray.getJSONObject(0);

                    sscinsti.setText(String.valueOf(data.getInt("sscinsti")));
                    hscinsti.setText(data.getString("hscinsti"));
                    ssc.setText(data.getString("ssc"));
                    hsc.setText(data.getString("hsc"));
                    sscyr.setText(data.getString("sscyr"));
                    hscyr.setText(data.getString("hscyr"));
                    jee.setText(data.getString("jee"));
                    mhtcet.setText(data.getString("mhtcet"));

                } catch (JSONException e) {
//                    Toast.makeText(getContext(), "exception ala", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        Volley.newRequestQueue(getContext()).add(request);
    }
    public void getBEInfo(){
        String URL = "http://192.168.42.228/Reaper/getTeacher.php";
        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    JSONArray jsonArray = jsonObject.getJSONArray("BEEduObj");
                    JSONObject data = jsonArray.getJSONObject(0);

                    beinsti.setText(String.valueOf(data.getInt("beinsti")));
                    branch.setText(data.getString("branch"));
                    sem1.setText(data.getString("sem1"));
                    sem2.setText(data.getString("sem2"));
                    sem3.setText(data.getString("sem3"));
                    sem4.setText(data.getString("sem4"));
                    sem5.setText(data.getString("sem5"));
                    sem6.setText(data.getString("sem6"));
                    sem7.setText(data.getString("sem7"));
                    sem8.setText(data.getString("sem8"));
                    backlog.setText(data.getString("backlog"));

                } catch (JSONException e) {
//                    Toast.makeText(getContext(), "exception ala", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        Volley.newRequestQueue(getContext()).add(request);
    }
}
