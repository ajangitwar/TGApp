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
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.basgeekball.awesomevalidation.utility.custom.SimpleCustomValidation;
import com.example.studentapp.R;
import com.google.common.collect.Range;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static com.example.studentapp.R.id.subbtn;

public class PersonalFormFragment extends Fragment {
    Button button;
    EditText Fullname1,Padrs1,Tadrs1,Mob1,Email1,Gender1,Blood1,Dob1,Height1,Weight1,Uid1,Pan1;
    public static final String url = "http://192.168.42.221/android/Student/InsertPersonal.php";
    AlertDialog.Builder builder;
    AwesomeValidation awesomeValidation;


    public PersonalFormFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal_form, container, false);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        button = view.findViewById(R.id.subbtn);
        builder = new AlertDialog.Builder(getContext());
        Fullname1 = view.findViewById(R.id.fullname);
        Padrs1 = view.findViewById(R.id.Paddress);
        Tadrs1 = view.findViewById(R.id.Taddress);
        Mob1 = view.findViewById(R.id.mob);
        Email1 = view.findViewById(R.id.email);
        Gender1 = view.findViewById(R.id.geer);
        Blood1 = view.findViewById(R.id.bgroup);
        Dob1 = view.findViewById(R.id.dob);
        Height1 = view.findViewById(R.id.height);
        Weight1 = view.findViewById(R.id.weight);
        Uid1 = view.findViewById(R.id.uid);
        Pan1 = view.findViewById(R.id.pan);

        return view;
    }
    private void SendData(){
        final String Fullname,Paddress,Taddress,MobNo,Email,gender,Blood,DOB,Height,weight,UID,PAN;
        Fullname = Fullname1.getText().toString().trim();
        Paddress = Padrs1.getText().toString().trim();
        Taddress = Tadrs1.getText().toString().trim();
        MobNo = Mob1.getText().toString().trim();
        Email =Email1.getText().toString().trim();
        gender =Gender1.getText().toString().trim();
        Blood =Blood1.getText().toString().trim();
        DOB =Dob1.getText().toString().trim();
        Height =Height1.getText().toString().trim();
        weight =Weight1.getText().toString().trim();
        UID =Uid1.getText().toString().trim();
        PAN =Pan1.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        builder.setTitle("Server Response");
                        builder.setMessage("Response :"+response);
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Fullname1.setText("");
                                Padrs1.setText("");
                                Tadrs1.setText("");
                                Mob1.setText("");
                                Email1.setText("");
                                Gender1.setText("");
                                Blood1.setText("");
                                Dob1.setText("");
                                Height1.setText("");
                                Weight1.setText("");
                                Uid1.setText("");
                                Pan1.setText("");
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
                params.put("Fullname",Fullname);
                params.put("Paddress",Paddress);
                params.put("Taddress",Taddress);
                params.put("MobNo",MobNo);
                params.put("Email",Email);
                params.put("gender",gender);
                params.put("Blood",Blood);
                params.put("DOB",DOB);
                params.put("Height",Height);
                params.put("weight",weight);
                params.put("UID",UID);
                params.put("PAN",PAN);

                return params;
            }
        };
        MySingleton.getInstance(getContext()).addToRequestQue(stringRequest);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                awesomeValidation.addValidation((Activity) getContext(),R.id.fullname,"[a-zA-Z\\s]+",R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.paddress,"[a-zA-Z\\s]+",R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.taddress,"[a-zA-Z\\s]+",R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.mob, RegexTemplate.TELEPHONE,R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.email,android.util.Patterns.EMAIL_ADDRESS,R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.geer,"[a-zA-Z\\s]+",R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.bgroup,"[a-zA-Z\\s]+",R.string.txterr);
//                awesomeValidation.addValidation((Activity) getContext(),R.id.dob, Range.closed(1900, Calendar.getInstance().get(Calendar.YEAR)),R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.height,Range.closed(0.0f, 7.0f),R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.weight,Range.closed(30, 200),R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.uid,"[0-9\\s]+",R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(),R.id.pan,"[a-zA-Z0-9\\s]+",R.string.txterr);
                awesomeValidation.addValidation((Activity) getContext(), R.id.dob, new SimpleCustomValidation() {
                    @Override
                    public boolean compare(String input) {
                        // check if the age is >= 18
                        try {
                            Calendar calendarBirthday = Calendar.getInstance();
                            Calendar calendarToday = Calendar.getInstance();
                            calendarBirthday.setTime(new SimpleDateFormat("dd/MM/yyyy", Locale.US).parse(input));
                            int yearOfToday = calendarToday.get(Calendar.YEAR);
                            int yearOfBirthday = calendarBirthday.get(Calendar.YEAR);
                            if (yearOfToday - yearOfBirthday > 18) {
                                return true;
                            } else if (yearOfToday - yearOfBirthday == 18) {
                                int monthOfToday = calendarToday.get(Calendar.MONTH);
                                int monthOfBirthday = calendarBirthday.get(Calendar.MONTH);
                                if (monthOfToday > monthOfBirthday) {
                                    return true;
                                } else if (monthOfToday == monthOfBirthday) {
                                    if (calendarToday.get(Calendar.DAY_OF_MONTH) >= calendarBirthday.get(Calendar.DAY_OF_MONTH)) {
                                        return true;
                                    }
                                }
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        return false;
                    }
                }, R.string.doberr);
                if(awesomeValidation.validate()){
                    SendData();
                }
            }
        });
        super.onActivityCreated(savedInstanceState);
    }
}
