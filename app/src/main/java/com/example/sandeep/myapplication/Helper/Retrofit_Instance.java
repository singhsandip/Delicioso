package com.example.sandeep.myapplication.Helper;

import retrofit.RestAdapter;

/**
 * Created by sandeep on 28-05-2017.
 */

public class Retrofit_Instance
{
    public static String BASEURL = "https://loculicidal-gasket.000webhostapp.com";
    public static RestAdapter restAdapter = null;

    public static RestAdapter getRetrofit()

    {
        if (restAdapter == null)
        {
            restAdapter = new RestAdapter.Builder().setEndpoint(BASEURL).build();
        }

        return restAdapter;
    }

}
