package com.example.sandeep.myapplication.Interface;

import com.example.sandeep.myapplication.BackgroundWork.JSONResponce;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sandeep on 08-02-2017.
 */

public interface RequestInterface
{
    @GET("specilities.php")
    Call<JSONResponce> getJSON();
}
