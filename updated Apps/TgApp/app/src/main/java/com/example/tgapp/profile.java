package com.example.tgapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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


public class profile extends Fragment {
    UserSes userSes;
    TextView tid,fullname,email,mob,salutation;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile,container, false);
        userSes = new UserSes(getContext());
//        Toast.makeText(getContext(),userSes.getTid(), Toast.LENGTH_SHORT).show();

        ParseData();

        tid = view.findViewById(R.id.tid);
        email = view.findViewById(R.id.email);
        fullname = view.findViewById(R.id.fullname);
        salutation = view.findViewById(R.id.salu);
        mob = view.findViewById(R.id.mob);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Profile");
    }

    public void ParseData(){
        String URL = "http://192.168.42.207/Reaper/getTeacher.php";
        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    JSONArray jsonArray = jsonObject.getJSONArray("teacherObj");
                    JSONObject data = jsonArray.getJSONObject(0);

                    tid.setText(String.valueOf(data.getInt("TID")));
                    salutation.setText(data.getString("salutation"));
                    fullname.setText(data.getString("fullname"));
                    email.setText(data.getString("email"));
                    mob.setText(data.getString("mobile"));



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
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String,String>();
                params.put("TID",userSes.getTid());

                return params;
            }
        };
        Volley.newRequestQueue(getActivity()).add(request);

    }
}
