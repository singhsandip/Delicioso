package com.example.sandeep.myapplication.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.sandeep.myapplication.Adapter.Adapter_Eggs;
import com.example.sandeep.myapplication.Adapter.Adapter_Fastfood;
import com.example.sandeep.myapplication.Adapter.Adapter_Icecreams;
import com.example.sandeep.myapplication.Adapter.Adapter_Juice;
import com.example.sandeep.myapplication.Adapter.Adapter_Shakes;
import com.example.sandeep.myapplication.Adapter.Adapter_Sweets;
import com.example.sandeep.myapplication.Adapter.DataAdapter;
import com.example.sandeep.myapplication.Helper.Constants;
import com.example.sandeep.myapplication.Helper.Retrofit_Instance;
import com.example.sandeep.myapplication.Interface.ApiClass;
import com.example.sandeep.myapplication.Interface.Get_Fastfood;
import com.example.sandeep.myapplication.Interface.Get_Jason_Data;
import com.example.sandeep.myapplication.Models.Get_Products;
import com.example.sandeep.myapplication.Models.Product_Result;
import com.example.sandeep.myapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by sandeep on 09-02-2017.
 */

public class Image_Fragment extends Fragment {
    ProgressDialog progressDialog;
    List<Product_Result> list;
    Activity activity;
    //Get_Jason_Data obj;
    /*FragmentManager fragmentManager;*/
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        activity = getActivity();
        progressDialog = new ProgressDialog(activity);
        // obj = this;
        View v = inflater.inflate(R.layout.products, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyle);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(activity, 2);
        recyclerView.setLayoutManager(layoutManager);
        list = new ArrayList<>();
       /* RecyclerView.LayoutManager layoutManager = new GridLayoutManager(activity,2);
        recyclerView.setLayoutManager(layoutManager);*/
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressDialog.setMessage("getting products");
        progressDialog.show();

        Bundle bundle = getArguments();
        int type = bundle.getInt(Constants.TYPE);
        ApiClass api = Retrofit_Instance.getRetrofit().create(ApiClass.class);
        switch (type)
        {
                case 0:
                    api.getSweets(new Callback<Get_Products>() {
                        @Override
                        public void success(Get_Products get_products, Response response) {
                            if (response != null) {
                                list = get_products.getResult();
                                String omage = list.get(list.size() - 1).getImage();
                                Adapter_Sweets dataAdapter = new Adapter_Sweets(activity, list);
                                recyclerView.setAdapter(dataAdapter);
                                progressDialog.dismiss();
                                Log.e("imegee", omage);
                            } else {
                                progressDialog.dismiss();
                                Toast.makeText(activity, "Unable to get products", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void failure(RetrofitError error) {
                            progressDialog.dismiss();
                            Toast.makeText(activity, "Unable to get products", Toast.LENGTH_SHORT).show();
                            Log.e("errrorrrr", String.valueOf(error));

                        }
                    });
                break;

                case 1:
                    api.getFastFoods(new Callback<Get_Products>() {
                        @Override
                        public void success(Get_Products get_products, Response response) {
                            if (response != null) {
                                list = get_products.getResult();
                                String omage = list.get(list.size() - 1).getImage();
                                Adapter_Fastfood dataAdapter = new Adapter_Fastfood(activity, list);
                                recyclerView.setAdapter(dataAdapter);
                                progressDialog.dismiss();
                                Log.e("imegee", omage);
                            } else {
                                progressDialog.dismiss();
                                Toast.makeText(activity, "Unable to get products", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void failure(RetrofitError error) {
                            progressDialog.dismiss();
                            Toast.makeText(activity, "Unable to get products", Toast.LENGTH_SHORT).show();
                            Log.e("errrorrrr", String.valueOf(error));

                        }
                    });
                break;

            case 2:
                api.getShakes(new Callback<Get_Products>() {
                    @Override
                    public void success(Get_Products get_products, Response response) {
                        if (response != null) {
                            list = get_products.getResult();
                            String omage = list.get(list.size() - 1).getImage();
                            Adapter_Shakes dataAdapter = new Adapter_Shakes(activity, list);
                            recyclerView.setAdapter(dataAdapter);
                            progressDialog.dismiss();
                            Log.e("imegee", omage);
                        } else {
                            progressDialog.dismiss();
                            Toast.makeText(activity, "Unable to get products", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void failure(RetrofitError error) {
                        progressDialog.dismiss();
                        Toast.makeText(activity, "Unable to get products", Toast.LENGTH_SHORT).show();
                        Log.e("errrorrrr", String.valueOf(error));

                    }
                });
                break;

            case 3:
                api.getIcecreamas(new Callback<Get_Products>() {
                    @Override
                    public void success(Get_Products get_products, Response response) {
                        if (response != null) {
                            list = get_products.getResult();
                            String omage = list.get(list.size() - 1).getImage();
                            Adapter_Icecreams dataAdapter = new Adapter_Icecreams(activity, list);
                            recyclerView.setAdapter(dataAdapter);
                            progressDialog.dismiss();
                            Log.e("imegee", omage);
                        } else {
                            progressDialog.dismiss();
                            Toast.makeText(activity, "Unable to get products", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void failure(RetrofitError error) {
                        progressDialog.dismiss();
                        Toast.makeText(activity, "Unable to get products", Toast.LENGTH_SHORT).show();
                        Log.e("errrorrrr", String.valueOf(error));

                    }
                });
                break;

            case 4:
                api.getJuices(new Callback<Get_Products>() {
                    @Override
                    public void success(Get_Products get_products, Response response) {
                        if (response != null) {
                            list = get_products.getResult();
                            String omage = list.get(list.size() - 1).getImage();
                            Adapter_Juice dataAdapter = new Adapter_Juice(activity, list);
                            recyclerView.setAdapter(dataAdapter);
                            progressDialog.dismiss();
                            Log.e("imegee", omage);
                        } else {
                            progressDialog.dismiss();
                            Toast.makeText(activity, "Unable to get products", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void failure(RetrofitError error) {
                        progressDialog.dismiss();
                        Toast.makeText(activity, "Unable to get products", Toast.LENGTH_SHORT).show();
                        Log.e("errrorrrr", String.valueOf(error));

                    }
                });
                break;


            case 5:
                api.getEggdishes(new Callback<Get_Products>() {
                    @Override
                    public void success(Get_Products get_products, Response response) {
                        if (response != null) {
                            list = get_products.getResult();
                            String omage = list.get(list.size() - 1).getImage();
                            Adapter_Eggs dataAdapter = new Adapter_Eggs(activity, list);
                            recyclerView.setAdapter(dataAdapter);
                            progressDialog.dismiss();
                            Log.e("imegee", omage);
                        } else {
                            progressDialog.dismiss();
                            Toast.makeText(activity, "Unable to get products", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void failure(RetrofitError error) {
                        progressDialog.dismiss();
                        Toast.makeText(activity, "Unable to get products", Toast.LENGTH_SHORT).show();
                        Log.e("errrorrrr", String.valueOf(error));

                    }
                });
                break;


        }

       /* ApiClass apiClass = Retrofit_Instance.getRetrofit().create(ApiClass.class);
        apiClass.getSweets(new Callback<Get_Products>() {
            @Override
            public void success(Get_Products get_products, Response response) {
                if (response != null) {
                    list = get_products.getResult();
                    String omage = list.get(list.size() - 1).getImage();
                    DataAdapter dataAdapter = new DataAdapter(activity, list);
                    recyclerView.setAdapter(dataAdapter);
                    progressDialog.dismiss();
                    Log.e("imegee", omage);
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(activity, "Unable to get products", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                progressDialog.dismiss();
                Toast.makeText(activity, "Unable to get products", Toast.LENGTH_SHORT).show();
                Log.e("errrorrrr", String.valueOf(error));

            }
        });*/

        /*String type = "getdata";
        BackgroundWorker backgroundWorker = new BackgroundWorker(activity,obj);
        backgroundWorker.execute(type);
    */
    }



}