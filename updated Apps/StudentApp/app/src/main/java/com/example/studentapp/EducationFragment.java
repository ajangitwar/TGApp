package com.example.studentapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class EducationFragment extends Fragment {
    UserSes userSes;
    View view;
    TextView sscinsti,hscinsti,ssc,hsc,sscyr,hscyr,jee,mhtcet;
    TextView beinsti,branch,sem1,sem2,sem3,sem4,sem5,sem6,sem7,sem8,backlog;

    public EducationFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       view = inflater.inflate(R.layout.education_fragment,container,false);
        userSes = new UserSes(getContext());
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
        eduInfo();

       return view;
    }
    public void eduInfo(){
        String URL = "http://192.168.43.34/android/Student/FetchEducation.php";
        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    JSONArray jsonArray = jsonObject.getJSONArray("EduObj");
                    JSONObject data = jsonArray.getJSONObject(0);
//                    sid.setText(String.valueOf(data.getString("SID")));
                    jee.setText(data.getString("JEE"));
                    mhtcet.setText(data.getString("MHTCET"));

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
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String,String>();
                params.put("SID",userSes.getSid());

                return params;
            }
        };
        Volley.newRequestQueue(getContext()).add(request);
    }

    public void getGeneralEduInfo(){
        String URL = "http://192.168.43.34/android/Student/FetchGen.php";
        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    JSONArray jsonArray = jsonObject.getJSONArray("GenObj");
                    JSONObject data = jsonArray.getJSONObject(0);

//                    sid.setText(String.valueOf(data.getString("SID")));
                    sscinsti.setText(String.valueOf(data.getInt("InstiNameX")));
                    hscinsti.setText(data.getString("InstiNameXII"));
                    ssc.setText(data.getString("PercentageX"));
                    hsc.setText(data.getString("PerXII"));
                    sscyr.setText(data.getString("YearX"));
                    hscyr.setText(data.getString("YearXII"));
//                    jee.setText(data.getString("jee"));
//                    mhtcet.setText(data.getString("mhtcet"));

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
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String,String>();
                params.put("SID",userSes.getSid());

                return params;
            }
        };
        Volley.newRequestQueue(getContext()).add(request);
    }
    public void getBEInfo(){
        String URL = "http://192.168.43.34/android/Student/FetchBe.php";
        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    JSONArray jsonArray = jsonObject.getJSONArray("BeObj");
                    JSONObject data = jsonArray.getJSONObject(0);
//                    sid.setText(String.valueOf(data.getString("SID")));
                    beinsti.setText(String.valueOf(data.getInt("InstiName")));
                    branch.setText(data.getString("Branch"));
                    sem1.setText(data.getString("Iper"));
                    sem2.setText(data.getString("IIper"));
                    sem3.setText(data.getString("IIIper"));
                    sem4.setText(data.getString("IVper"));
                    sem5.setText(data.getString("Vper"));
                    sem6.setText(data.getString("VIper"));
                    sem7.setText(data.getString("VIIper"));
                    sem8.setText(data.getString("VIIIper"));
                    backlog.setText(data.getString("backlogs"));

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
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String,String>();
                params.put("SID",userSes.getSid());

                return params;
            }
        };
        Volley.newRequestQueue(getContext()).add(request);
    }
}
