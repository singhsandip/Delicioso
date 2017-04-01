package com.example.sandeep.myapplication.Fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sandeep.myapplication.R;

/**
 * Created by sandeep on 09-02-2017.
 */

public class Image_Fragment extends Fragment
{
    ImageView dish_image;
    TextView nametv,pricetv,descriptiontv;
    //FragmentManager fragmentManager = getFragmentManager();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.image_fragment,container,false);
    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       Bundle bundle =  getArguments();
        String name = bundle.getString("name");
        String image = bundle.getString("image");
        String description = bundle.getString("description");
        String price = bundle.getString("price");

        dish_image = (ImageView)view.findViewById(R.id.dish_image);
        nametv = (TextView)view.findViewById(R.id.dish_name);
        descriptiontv = (TextView)view.findViewById(R.id.dish_discription);
        pricetv = (TextView)view.findViewById(R.id.dish_price);

        nametv.setText(name);
        descriptiontv.setText(description);
        pricetv.setText(price);
        Glide.with(getActivity()).load(image).into(dish_image);
    }
}
