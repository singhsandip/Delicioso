package com.example.sandeep.myapplication.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sandeep.myapplication.Adapter.DataAdapter;
import com.example.sandeep.myapplication.BackgroundWork.BackgroundWorker;
import com.example.sandeep.myapplication.Helper.Retrofit_Instance;
import com.example.sandeep.myapplication.Interface.ApiClass;
import com.example.sandeep.myapplication.Interface.Get_Jason_Data;
import com.example.sandeep.myapplication.Models.Get_Products;
import com.example.sandeep.myapplication.Models.MyModel;
import com.example.sandeep.myapplication.Models.Product_Result;
import com.example.sandeep.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by sandeep on 18-01-2017.
 */

public class Products extends Fragment// implements Get_Jason_Data
{

    ProgressDialog progressDialog;
    List<Product_Result> list;
    Activity activity;
    Get_Jason_Data obj;
    /*FragmentManager fragmentManager;*/
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        activity = getActivity();
        progressDialog = new ProgressDialog(activity);
       // obj = this;
        View v = inflater.inflate(R.layout.products,container,false);
        recyclerView = (RecyclerView)v.findViewById(R.id.recyle);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(activity,2);
        recyclerView.setLayoutManager(layoutManager);
        list = new ArrayList<>();
       /* RecyclerView.LayoutManager layoutManager = new GridLayoutManager(activity,2);
        recyclerView.setLayoutManager(layoutManager);*/
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        progressDialog.setMessage("getting products");
        progressDialog.show();

        ApiClass apiClass = Retrofit_Instance.getRetrofit().create(ApiClass.class);
        apiClass.getList(new Callback<Get_Products>() {
            @Override
            public void success(Get_Products get_products, Response response)
            {
                    if (response != null)
                    {
                       list =  get_products.getResult();
                        String omage = list.get(list.size() - 1).getImage();
                        DataAdapter dataAdapter = new DataAdapter(activity,list);
                        recyclerView.setAdapter(dataAdapter);
                        progressDialog.dismiss();
                        Log.e("imegee",omage);
                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(activity, "Unable to get productsssssssssss", Toast.LENGTH_SHORT).show();
                    }
            }

            @Override
            public void failure(RetrofitError error)
            {
                progressDialog.dismiss();
                Toast.makeText(activity, "Unable to get products", Toast.LENGTH_SHORT).show();
                Log.e("errrorrrr", String.valueOf(error));

            }
        });

        /*String type = "getdata";
        BackgroundWorker backgroundWorker = new BackgroundWorker(activity,obj);
        backgroundWorker.execute(type);
    */}

/*    @Override
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
                   DataAdapter dataAdapter = new DataAdapter(this,myModel);
                }
                DataAdapter dataAdapter = new DataAdapter(activity,list);
                recyclerView.setAdapter(dataAdapter);
                progressDialog.dismiss();
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
      return null;
    }*/

}
