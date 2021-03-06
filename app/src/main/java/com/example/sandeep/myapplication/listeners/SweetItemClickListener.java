package com.example.sandeep.myapplication.listeners;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.sandeep.myapplication.R;

/**
 * Created by sandeep on 03-06-2017.
 */


public class SweetItemClickListener implements View.OnClickListener {
   // private Context context;
    private static LayoutInflater inflater;
    private Context context;
    private int position;
    private String price;

    public SweetItemClickListener(Context context, int position,String price){
        this.context = context;
        this.position = position;
        this.price = price;
    }


    @Override
    public void onClick(View view) {
        inflater = LayoutInflater.from(context);
        View splashScreen = inflater.inflate(R.layout.showprice,null);
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(context);
        alertdialog.setView(splashScreen);
        TextView itenmane = (TextView) splashScreen.findViewById(R.id.itemname);
        itenmane.setText(price+"/KG");
        alertdialog.setCancelable(true);
        alertdialog.show();
    }
}
