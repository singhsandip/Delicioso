package com.example.sandeep.myapplication.Adapter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.sandeep.myapplication.Models.Product_Result;
import com.example.sandeep.myapplication.R;
import com.example.sandeep.myapplication.holder.AdapterViewHolder;
import com.example.sandeep.myapplication.listeners.ShakeClickListener;
import com.example.sandeep.myapplication.listeners.SweetItemClickListener;

import java.util.List;

/**
 * Created by sandeep on 06-06-2017.
 */

public class Adapter_Shakes extends RecyclerView.Adapter<AdapterViewHolder> {
    Activity activity;
    android.app.FragmentManager fragmentManager;//= getFragmentManager();
    android.app.FragmentTransaction ft;

    List<Product_Result> list;
    ProgressDialog progressDialog;
    LayoutInflater inflater;
    String description;
    String price;
    String name;
    String image_url;

    public Adapter_Shakes(Activity activity, List<Product_Result> list) {
        this.activity = activity;
        this.fragmentManager = activity.getFragmentManager();
        this.list = list;
        inflater = LayoutInflater.from(activity);

    }


    @Override
    public AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = inflater.inflate(R.layout.product_layout, parent, false);
        //progressDialog = new ProgressDialog(activity);
        //String type = "type";
        //int a = (int)view;
        // String type = String.valueOf(view);

        AdapterViewHolder adapterViewHolder = new AdapterViewHolder(view);

        return adapterViewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterViewHolder holder, int position) {


        holder.textView.setText(list.get(position).getName());
        // progressDialog.show();
        Glide.with(activity)
                .load(list.get(position)
                        .getImage())
                .into(holder.imageView);
        String price = list.get(position).getPrice();
        holder.llitemview.setOnClickListener(new ShakeClickListener(activity,position,price));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

}
