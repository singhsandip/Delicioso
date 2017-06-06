package com.example.sandeep.myapplication.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sandeep on 28-05-2017.
 */

public class Get_Products
{
    @SerializedName("result")
    @Expose
    private List<Product_Result> result = null;

    public List<Product_Result> getResult() {
        return result;
    }

    public void setResult(List<Product_Result> result) {
        this.result = result;
    }
}
