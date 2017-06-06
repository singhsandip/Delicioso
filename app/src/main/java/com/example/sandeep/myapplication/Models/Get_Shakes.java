package com.example.sandeep.myapplication.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sandeep on 28-05-2017.
 */

public class Get_Shakes
{
    @SerializedName("result")
    @Expose
    private List<Shakes_Result> result = null;

    public List<Shakes_Result> getResult() {
        return result;
    }

    public void setResult(List<Shakes_Result> result) {
        this.result = result;
    }
}
