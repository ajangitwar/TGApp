package com.example.studentapp.form;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.studentapp.R;
import com.example.studentapp.UserSes;

import java.util.HashMap;
import java.util.Map;

public class EducationFormFragment extends Fragment {
    UserSes userSes;
    Button button,button1,button2;
    EditText Jee,Mhtcet,Xinstname,Xyear,Xper,XIIinstname,XIIyear,XIIper,BEinstname,Branch1,Iperc,IIperc,IIIperc,IVperc,Vperc,VIperc,VIIperc,VIIIperc,Back;
    public static final String url = "http://192.168.43.34/android/Student/InsertEducation.php";
    public static final String url1 = "http://192.168.43.34/android/Student/InsertGen.php";
    public static final String url2 = "http://192.168.43.34/android/Student/InsertBE.php";
    AwesomeValidation awesomeValidation;

    AlertDialog.Builder builder;


    public EducationFormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_education_form, container, false);
        userSes = new UserSes(getContext());
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        button = view.findViewById(R.id.subbtn);
        button1 = view.findViewById(R.id.subbtn1);
        button2 = view.findViewById(R.id.subbtn2);
        builder = new AlertDialog.Builder(getContext());
        Jee = view.findViewById(R.id.jee);
        Mhtcet = view.findViewById(R.id.mhtcet);
        Xinstname = view.findViewById(R.id.X);
        Xyear = view.findViewById(R.id.XYear);
        Xper = view.findViewById(R.id.per);
        XIIinstname = view.findViewById(R.id.XII);
        XIIyear = view.findViewById(R.id.XIIYear);
        XIIper = view.findViewById(R.id.perc);
        BEinstname = view.findViewById(R.id.BE);
        Branch1 = view.findViewById(R.id.Branch);
        Iperc = view.findViewById(R.id.firstper);
        IIperc = view.findViewById(R.id.secondper);
        IIIperc = view.findViewById(R.id.thirdper);
        IVperc = view.findViewById(R.id.fourper);
        Vperc = view.findViewById(R.id.fiveper);
        VIperc = view.findViewById(R.id.sixper);
        VIIperc = view.findViewById(R.id.sevenper);
        VIIIperc = view.findViewById(R.id.eightper);
        Back = view.findViewById(R.id.back);

        return  view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                awesomeValidation.addValidation((Activity) getContext(),R.id.jee,"[0-9\\s]+",R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.mhtcet,"[0-9\\s]+",R.string.txterr);
                if(awesomeValidation.validate()){
                    sendJEE();
                }
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                awesomeValidation.addValidation((Activity) getContext(),R.id.X,"[a-zA-Z\\s]+",R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.XYear,"[0-9\\s]+",R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.per,"[0-9\\s]+",R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.XII,"[a-zA-Z\\s]+",R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.XIIYear,"[0-9\\s]+",R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.perc,"[0-9\\s]+",R.string.txterr);
                if(awesomeValidation.validate()){
                    sendGeneral();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                awesomeValidation.addValidation((Activity) getContext(),R.id.BE,"[a-zA-Z\\s]+",R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.branch,"[a-zA-Z\\s]+",R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.firstper,"[0-9\\s]+",R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.secondper,"[0-9\\s]+",R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.thirdper,"[0-9\\s]+",R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.fourper,"[0-9\\s]+",R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.fiveper,"[0-9\\s]+",R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.sixper,"[0-9\\s]+",R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.sevenper,"[0-9\\s]+",R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.eightper,"[0-9\\s]+",R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.back,"[0-9\\s]+",R.string.txterr);

                if(awesomeValidation.validate()){
                    sendBEInfo();
                }
            }
        });
        super.onActivityCreated(savedInstanceState);
    }

    private void sendJEE(){
        final String JEE,MHTCET;
        JEE = Jee.getText().toString().trim();
        MHTCET = Mhtcet.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        builder.setTitle("Server Response");
                        builder.setMessage("Response :"+response);
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Jee.setText("");
                                Mhtcet.setText("");
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(),"Error...",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String,String>();
                params.put("SID",userSes.getSid());
                params.put("JEE",JEE);
                params.put("MHTCET",MHTCET);

                return params;
            }
        };
        MySingleton.getInstance(getContext()).addToRequestQue(stringRequest);
    }
    private void sendGeneral(){
        final String InstiNameX,YearX,PercentageX,InstiNameXII,YearXII,PerXII;
        InstiNameX = Xinstname.getText().toString().trim();
        YearX = Xyear.getText().toString().trim();
        PercentageX = Xper.getText().toString().trim();
        InstiNameXII = XIIinstname.getText().toString().trim();
        YearXII = XIIyear.getText().toString().trim();
        PerXII = XIIper.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url1,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        builder.setTitle("Server Response");
                        builder.setMessage("Response :"+response);
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Xinstname.setText("");
                                Xyear.setText("");
                                Xper.setText("");
                                XIIinstname.setText("");
                                XIIyear.setText("");
                                XIIper.setText("");

                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(),"Error...",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String,String>();
                params.put("SID",userSes.getSid());
                params.put("InstiNameX",InstiNameX);
                params.put("YearX",YearX);
                params.put("PercentageX",PercentageX);
                params.put("InstiNameXII",InstiNameXII);
                params.put("YearXII",YearXII);
                params.put("PerXII",PerXII);
                return params;
            }
        };
        MySingleton.getInstance(getContext()).addToRequestQue(stringRequest);
    }

    private void sendBEInfo(){
        final String Iper,IIper,IIIper,IVper,Vper,VIper,VIIper,VIIIper,backlogs,InstiName,Branch;
        Iper = Iperc.getText().toString().trim();
        IIper = IIperc.getText().toString().trim();
        IIIper = IIIperc.getText().toString().trim();
        IVper = IVperc.getText().toString().trim();
        Vper = Vperc.getText().toString().trim();
        VIper = VIperc.getText().toString().trim();
        VIIper = VIIperc.getText().toString().trim();
        VIIIper = VIIIperc.getText().toString().trim();
        backlogs = Back.getText().toString().trim();
        InstiName = BEinstname.getText().toString().trim();
        Branch = Branch1.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url2,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        builder.setTitle("Server Response");
                        builder.setMessage("Response :"+response);
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                BEinstname.setText("");
                                Branch1.setText("");
                                Iperc.setText("");
                                IIperc.setText("");
                                IIIperc.setText("");
                                IVperc.setText("");
                                Vperc.setText("");
                                VIperc.setText("");
                                VIIperc.setText("");
                                VIIIperc.setText("");
                                Back.setText("");

                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(),"Error...",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String,String>();
                params.put("SID",userSes.getSid());
                params.put("InstiName",InstiName);
                params.put("Branch",Branch);
                params.put("Iper",Iper);
                params.put("IIper",IIper);
                params.put("IIIper",IIIper);
                params.put("IVper",IVper);
                params.put("Vper",Vper);
                params.put("VIper",VIper);
                params.put("VIIper",VIIper);
                params.put("VIIIper",VIIIper);
                params.put("backlogs",backlogs);

                return params;
            }
        };
        MySingleton.getInstance(getContext()).addToRequestQue(stringRequest);
    }
}
