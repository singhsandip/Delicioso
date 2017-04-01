package com.example.sandeep.myapplication.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sandeep.myapplication.Adapter.Special_Adapter;
import com.example.sandeep.myapplication.Interface.Get_Jason_Data;
import com.example.sandeep.myapplication.BackgroundWork.JSONResponce;
import com.example.sandeep.myapplication.Models.MyModel;
import com.example.sandeep.myapplication.R;
import com.example.sandeep.myapplication.Interface.RequestInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sandeep on 07-02-2017.
 */

public class Specilites extends Fragment implements Get_Jason_Data
{
   // List<MyModel> list;
    RecyclerView recyclerView;
    Activity activity;
    ArrayList<MyModel> list;
    Special_Adapter specialAdapter;
    /*RecyclerView recyclerView;
    Activity activity;
    */Get_Jason_Data get_jason_data;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        activity = getActivity();
        specialAdapter = new Special_Adapter(activity,new ArrayList<MyModel>());
        //get_jason_data = this;
        View view = inflater.inflate(R.layout.specilities,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.special_recyle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);
        //return inflater.inflate(R.layout.specilities,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        getJSON();
        //String type = "special";
        //super.onViewCreated(view, savedInstanceState);
        //BackgroundWorker backgroundWorker = new BackgroundWorker(activity,get_jason_data);
       // backgroundWorker.execute(type);
    }

    private void getJSON()
    {
        //Retrofit retrofit = new Retrofit.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://singh0396.esy.es/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface requestInterface = retrofit.create(RequestInterface.class);
        Call<JSONResponce> call = requestInterface.getJSON();
        call.enqueue(new Callback<JSONResponce>() {
            @Override
            public void onResponse(Call<JSONResponce> call, Response<JSONResponce> response)
            {
                if (response.body()!=null) {
                    JSONResponce responce = response.body();
                    list = (ArrayList<MyModel>) responce.getList();
                    //specialAdapter = new Special_Adapter(activity,list);
                    specialAdapter.addList(list);
                    recyclerView.setAdapter(specialAdapter);
                }
            }

            @Override
            public void onFailure(Call<JSONResponce> call, Throwable t)
            {
                Toast.makeText(activity, "Failed to parse with retrifit", Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public String sendJasonData(String result)  {
        String s = result;
        /*list = new ArrayList<>();
        if (s != null)
        {
            try {
                JSONObject object = new JSONObject(s);
                JSONArray array = object.getJSONArray("result");
                for (int i=0; i<array.length(); i++)
                {
                    JSONObject obj = array.getJSONObject(i);
                    String name = obj.optString("name");
                    String image = obj.optString("image");
                    MyModel myModel = new MyModel(name,image);
                    list.add(myModel);
                }
                Special_Adapter special_adapter =new Special_Adapter(activity,list);
                recyclerView.setAdapter(special_adapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }*/
        return  null;
    }
}
