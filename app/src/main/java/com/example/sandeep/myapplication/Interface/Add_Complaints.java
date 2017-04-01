package com.example.sandeep.myapplication.Interface;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by sandeep on 24-02-2017.
 */

public interface Add_Complaints
{
    @FormUrlEncoded
    @POST("/actual_insert.php")
    public void insertdata(@Field("name") String name,
                           @Field("email") String email,
                           @Field("details") String fack,
                           Callback<Response> callback);
}
