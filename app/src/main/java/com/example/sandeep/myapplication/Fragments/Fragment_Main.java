package com.example.sandeep.myapplication.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sandeep.myapplication.R;

/**
 * Created by sandeep on 03-04-2017.
 */

public class Fragment_Main extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_layout,container,false);
    }
}
