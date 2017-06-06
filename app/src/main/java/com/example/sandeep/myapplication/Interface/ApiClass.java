package com.example.sandeep.myapplication.Interface;

import com.example.sandeep.myapplication.Models.Get_Products;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by sandeep on 28-05-2017.
 */

public interface ApiClass
{
    @GET("/get_products.php")
    void getList(Callback<Get_Products> get_productsCallback);

    @GET("/get_sweets.php")
    void getSweets(Callback<Get_Products> get_productsCallback);

    @GET("/get_fastfood.php")
    void getFastFoods(Callback<Get_Products> get_productsCallback);

    @GET("/get_shakes.php")
    void getShakes(Callback<Get_Products> get_productsCallback);

    @GET("/get_icecreams.php")
    void getIcecreamas(Callback<Get_Products> get_productsCallback);

    @GET("/get_juices.php")
    void getJuices(Callback<Get_Products> get_productsCallback);

    @GET("/get_eggdishes.php")
    void getEggdishes(Callback<Get_Products> get_productsCallback);
}
