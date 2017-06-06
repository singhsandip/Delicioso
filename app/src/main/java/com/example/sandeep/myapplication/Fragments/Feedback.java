package com.example.sandeep.myapplication.Fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.sandeep.myapplication.Activities.MainActivity;
import com.example.sandeep.myapplication.BackgroundWork.BackgroundWorker;
import com.example.sandeep.myapplication.Helper.CustomFilterAdapter;
import com.example.sandeep.myapplication.Helper.ProgressDialogHelper;
import com.example.sandeep.myapplication.Interface.Add_Feedback;
import com.example.sandeep.myapplication.Interface.Get_Jason_Data;
import com.example.sandeep.myapplication.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by sandeep on 06-02-2017.
 */

public class Feedback extends Fragment implements View.OnClickListener//,Get_Jason_Data
{
    AlertDialog alertDialog;
    ProgressDialog progressDialog;
    Button submit;
    AutoCompleteTextView email;
    EditText e1,e3;
    Activity mActivity;
    //Get_Jason_Data get_jason_data;
    private AwesomeValidation awesomeValidation;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mActivity = getActivity();
      //  get_jason_data  =  this;
        return inflater.inflate(R.layout.feedback, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        e1 = (EditText)view.findViewById(R.id.f_name);
        email = (AutoCompleteTextView) view.findViewById(R.id.f_email);
        e3 = (EditText)view.findViewById(R.id.f_details);
        progressDialog = ProgressDialogHelper.getProgressDialog(mActivity);
        submit = (Button)view.findViewById(R.id.button3);

        List<String> arraymails = new ArrayList<>();
        arraymails = new ArrayList();
        arraymails.add("@gmail.com");
        arraymails.add("@hotmail.com");
        arraymails.add("@yahoo.com");
        arraymails.add("@outlook.com");

        //  autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autocmptext);

        CustomFilterAdapter adapter = new CustomFilterAdapter(mActivity,android.R.layout.simple_list_item_1, (ArrayList<String>) arraymails);

        email.setAdapter(adapter);
        submit.setOnClickListener(this);

      // awesomeValidation.addValidation(mActivity,R.id.c_name,"^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$",R.string.name_error);
        awesomeValidation.addValidation(mActivity,R.id.f_name,"^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$",R.string.name_error);
        awesomeValidation.addValidation(mActivity,R.id.f_email, Patterns.EMAIL_ADDRESS,R.string.emai_error);
        awesomeValidation.addValidation(mActivity,R.id.f_details,"^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$",R.string.detail_error);
        //String name = e1.getText().toString();

    }


    @Override
    public void onClick(View v)
    {

        if (awesomeValidation.validate())
        {
            String n,e,add;
            n = e1.getText().toString();
            e = email.getText().toString();
            add = e3.getText().toString();
            sendpost(n,e,add);
            progressDialog.setMessage("Adding Feedback");
            progressDialog.setCancelable(false);
            progressDialog.show();

        }

    }

    private void sendpost(String n, String e, String add)
    {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://singh0396.esy.es")
                .build();

        Add_Feedback retrofit_insert = restAdapter.create(Add_Feedback.class);
        retrofit_insert.insertdata(n, e, add, new Callback<Response>() {
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
                alertDialog = new AlertDialog.Builder(mActivity).create();
                alertDialog.setTitle("Add Feedback Status");
                alertDialog.setMessage("Feedback "+output);
                alertDialog.show();
                e1.setText(null);
                email.setText(null);
                e3.setText(null);

               // Toast.makeText(mActivity, ""+output, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError error)
            {
                Toast.makeText(mActivity, "error while inserting", Toast.LENGTH_SHORT).show();


            }
        });



    }

   /* @Override
    public String sendJasonData(String result) {
        *//*alertDialog = new AlertDialog.Builder(mActivity).create();
        alertDialog.setTitle("Add Complaits Status");
        alertDialog.setMessage(result);
        alertDialog.show();*//*
        return null;
    }*/
}
