package com.example.sandeep.myapplication.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sandeep.myapplication.Adapter.DataAdapter;
import com.example.sandeep.myapplication.BackgroundWork.BackgroundWorker;
import com.example.sandeep.myapplication.Interface.Get_Jason_Data;
import com.example.sandeep.myapplication.Models.MyModel;
import com.example.sandeep.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandeep on 18-01-2017.
 */

public class Products extends Fragment implements Get_Jason_Data
{

    List<MyModel> list;
    Activity activity;
    Get_Jason_Data obj;
    /*FragmentManager fragmentManager;*/
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        activity = getActivity();
        obj = this;
        View v = inflater.inflate(R.layout.products,container,false);
        recyclerView = (RecyclerView)v.findViewById(R.id.recyle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);
       /* RecyclerView.LayoutManager layoutManager = new GridLayoutManager(activity,2);
        recyclerView.setLayoutManager(layoutManager);*/
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        String type = "getdata";
        BackgroundWorker backgroundWorker = new BackgroundWorker(activity,obj);
        backgroundWorker.execute(type);
    }

    @Override
    public String sendJasonData(String result)
    {

        list = new ArrayList<>();
        String s = result;
        if (s != null)
        {
            try
            {
                JSONObject obj = new JSONObject(s);
                JSONArray array = obj.getJSONArray("result");
                for (int i = 0; i < array.length(); i++)
                {
                    JSONObject object = array.getJSONObject(i);
                    String id = object.getString("id");
                    String name = object.optString("name");
                    String image = object.optString("image");
                    String description = object.optString("description");
                    String price = object.optString("price");
                    MyModel myModel = new MyModel(id,name,image,description,price);
                    list.add(myModel);
                  //  DataAdapter dataAdapter = new DataAdapter(this,myModel);
                }
                DataAdapter dataAdapter = new DataAdapter(activity,list);
                recyclerView.setAdapter(dataAdapter);
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
      return null;
    }

}
