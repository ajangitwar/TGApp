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

public class PersonalFragment extends Fragment {
    View view;
    TextView sid,fullname,mobile,email,paddress,taddress,bgroup,dob,gender,height,weight,uid,pan;
    public PersonalFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.personal_fragment,container,false);

        sid = view.findViewById(R.id.sid);
        email = view.findViewById(R.id.email);
        fullname = view.findViewById(R.id.fullname);
        paddress = view.findViewById(R.id.paddress);
        mobile = view.findViewById(R.id.mobile);
        taddress = view.findViewById(R.id.taddress);
        bgroup = view.findViewById(R.id.bgroup);
        dob = view.findViewById(R.id.dob);
        gender = view.findViewById(R.id.gender);
        height = view.findViewById(R.id.height);
        weight = view.findViewById(R.id.weight);
        pan = view.findViewById(R.id.pan);
        uid = view.findViewById(R.id.uid);

        getData();
        return view;
    }
    public void getData(){
        String URL = "http://192.168.42.221/Reaper/getStudent.php";
        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    JSONArray jsonArray = jsonObject.getJSONArray("PersonalObj");
                    JSONObject data = jsonArray.getJSONObject(0);

                    sid.setText(String.valueOf(data.getInt("TID")));
                    fullname.setText(data.getString("fullname"));
                    mobile.setText(data.getString("mobile"));
                    email.setText(data.getString("email"));
                    paddress.setText(data.getString("paddress"));
                    taddress.setText(data.getString("taddress"));
                    bgroup.setText(data.getString("bgroup"));
                    dob.setText(data.getString("dob"));
                    gender.setText(data.getString("gender"));
                    height.setText(data.getString("height"));
                    weight.setText(data.getString("weight"));
                    uid.setText(data.getString("uid"));
                    pan.setText(data.getString("pan"));


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
