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

public class PersonalFragment extends Fragment {
    UserSes userSes;
    View view;
    TextView sid,fullname,mobile,email,paddress,taddress,bgroup,dob,gender,height,weight,uid,pan;
    public PersonalFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.personal_fragment,container,false);
        userSes = new UserSes(getContext());
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
        String URL = "http://192.168.43.34/android/Student/FetchPersonal.php";
        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    JSONArray jsonArray = jsonObject.getJSONArray("PersonalObj");
                    JSONObject data = jsonArray.getJSONObject(0);

                    sid.setText(String.valueOf(data.getString("SID")));
                    fullname.setText(data.getString("Fullname"));
                    mobile.setText(data.getString("MobNo"));
                    email.setText(data.getString("Email"));
                    paddress.setText(data.getString("Paddress"));
                    taddress.setText(data.getString("Taddress"));
                    bgroup.setText(data.getString("Blood"));
                    dob.setText(data.getString("DOB"));
                    gender.setText(data.getString("gender"));
                    height.setText(data.getString("Height"));
                    weight.setText(data.getString("weight"));
                    uid.setText(data.getString("UID"));
                    pan.setText(data.getString("PAN"));


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
