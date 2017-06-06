package com.example.sandeep.myapplication.holder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sandeep.myapplication.R;

/**
 * Created by sandeep on 03-06-2017.
 */

public class AdapterViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView textView;
    public LinearLayout llitemview;


    public AdapterViewHolder(View view) {
        super(view);

        imageView = (ImageView) view.findViewById(R.id.image);
        textView = (TextView) view.findViewById(R.id.text);
        llitemview = (LinearLayout) view.findViewById(R.id.llItemView);

    }
}
