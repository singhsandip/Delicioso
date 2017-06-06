package com.example.sandeep.myapplication.Interface;

import com.example.sandeep.myapplication.Models.Get_Products;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by sandeep on 28-05-2017.
 */

public interface Get_Fastfood
{
        @GET("/get_fastfood.php")
        void getFastFoods(Callback<Get_Products> get_productsCallback);
}
