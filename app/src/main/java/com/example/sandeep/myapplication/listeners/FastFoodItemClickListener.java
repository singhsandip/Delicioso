package com.example.sandeep.myapplication.listeners;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.sandeep.myapplication.R;

/**
 * Created by sandeep on 06-06-2017.
 */

public class FastFoodItemClickListener implements View.OnClickListener {
// private Context context;
private static LayoutInflater inflater;
private Context context;
private int position;
private String price;
    private String name;

public FastFoodItemClickListener(Context context, int position,String price,String name){
        this.context = context;
        this.position = position;
        this.price = price;
    this.name = name;
        }


@Override
public void onClick(View view) {
        inflater = LayoutInflater.from(context);
        View splashScreen = inflater.inflate(R.layout.showprice,null);
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(context);
        alertdialog.setView(splashScreen);
        TextView itenmane = (TextView) splashScreen.findViewById(R.id.itemname);
        itenmane.setText(price+"/"+name);
        alertdialog.setCancelable(true);
        alertdialog.show();
        }
        }
