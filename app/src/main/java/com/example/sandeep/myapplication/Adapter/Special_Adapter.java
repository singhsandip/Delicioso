package com.example.sandeep.myapplication.Adapter;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sandeep.myapplication.Fragments.Image_Fragment;
import com.example.sandeep.myapplication.Fragments.Specility_image_fragment;
import com.example.sandeep.myapplication.Models.MyModel;
import com.example.sandeep.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandeep on 07-02-2017.
 */

public class Special_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    FragmentManager fragmentManager;
    FragmentTransaction ft;
    List<MyModel> list;
    Activity activity;
    LayoutInflater inflater;
    String description;
    String price;
    String name;
    String image_url;


    public Special_Adapter(Activity activity,List<MyModel> list) {
        this.list = list;
        this.activity = activity;
        fragmentManager = activity.getFragmentManager();
        inflater = LayoutInflater.from(activity);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = inflater.inflate(R.layout.special_layout,parent,false);
        return new FindViewHolderSpecial(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        //FindViewHolder findViewHolder = (FindViewHolder) holder;
        if (holder instanceof FindViewHolderSpecial)
        {
            FindViewHolderSpecial findViewHolderSpecial = (FindViewHolderSpecial) holder;
            findViewHolderSpecial.textView.setText(list.get(position).getName());
            Glide.with(activity).load(list.get(position).getImage()).into(findViewHolderSpecial.imageView);
        }

    }
    public void addList(ArrayList<MyModel> list)
    {
        this.list = list;
        notifyDataSetChanged();
        //it notify adapter  notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public  class FindViewHolderSpecial extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public FindViewHolderSpecial(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    description = list.get(getAdapterPosition()).getDescription();
                    price = list.get(getAdapterPosition()).getPrice();
                    name = list.get(getAdapterPosition()).getName();
                    image_url = list.get(getAdapterPosition()).getImage();
                    ft = fragmentManager.beginTransaction();
                     Specility_image_fragment specility_image_fragment = new Specility_image_fragment();
                    //ft.add(R.id.frame_image,image_fragment);
                    Bundle b = new Bundle();
                    b.putString("name",name);
                    b.putString("description",description);
                    b.putString("price",price);
                    b.putString("image",image_url);
                    specility_image_fragment.setArguments(b);
                    ft.addToBackStack("products");
                    //ft.add(R.id.frame,image_fragment);
                    ft.replace(R.id.frame,specility_image_fragment);
                    ft.commit();


                }
            });
            imageView = (ImageView)itemView.findViewById(R.id.image);
            textView = (TextView)itemView.findViewById(R.id.text);
        }
    }
}
