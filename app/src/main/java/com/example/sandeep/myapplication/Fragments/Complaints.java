package com.example.sandeep.myapplication.Fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.sandeep.myapplication.Interface.Add_Complaints;
import com.example.sandeep.myapplication.Interface.Add_Feedback;
import com.example.sandeep.myapplication.Interface.Get_Jason_Data;
import com.example.sandeep.myapplication.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by sandeep on 24-02-2017.
 */

public class Complaints extends Fragment implements View.OnClickListener
{


    AlertDialog alertDialog;

    Button submit;
    EditText e1,e2,e3;
    Activity mActivity;
    Get_Jason_Data get_jason_data;
    private AwesomeValidation awesomeValidation;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mActivity = getActivity();
        return inflater.inflate(R.layout.complaints,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        e1 = (EditText)view.findViewById(R.id.c_name);
        e2 = (EditText)view.findViewById(R.id.c_email);
        e3 = (EditText)view.findViewById(R.id.c_details);
        submit = (Button)view.findViewById(R.id.button3);
        submit.setOnClickListener(this);

        // awesomeValidation.addValidation(mActivity,R.id.c_name,"^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$",R.string.name_error);
        awesomeValidation.addValidation(mActivity,R.id.c_name,"^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$",R.string.name_error);
        awesomeValidation.addValidation(mActivity,R.id.c_email, Patterns.EMAIL_ADDRESS,R.string.emai_error);
        awesomeValidation.addValidation(mActivity,R.id.c_details,"^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$",R.string.detail_error);

    }

    @Override
    public void onClick(View v) {
        if (awesomeValidation.validate()) {
            String n, e, add;
            n = e1.getText().toString();
            e = e2.getText().toString();
            add = e3.getText().toString();
            sendpost(n, e, add);
        }
    }
    private void sendpost(String n, String e, String add)
    {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://singh0396.esy.es")
                .build();

        Add_Complaints add_complaints = restAdapter.create(Add_Complaints.class);
        add_complaints.insertdata(n, e, add, new Callback<Response>() {
            @Override
            public void success(Response response, Response response2)
            {
                BufferedReader reader = null;

                String output = "";

                try {
                    reader = new BufferedReader(new InputStreamReader(response.getBody().in()));

                    output = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(mActivity, ""+output, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError error)
            {
                Toast.makeText(mActivity, "error while inserting", Toast.LENGTH_SHORT).show();

            }
        });



    }


}



