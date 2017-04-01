package com.example.sandeep.myapplication.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sandeep.myapplication.R;

/**
 * Created by sandeep on 18-01-2017.
 */

public class About_us extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.about_us,container,false);
        return v;
    }
}
