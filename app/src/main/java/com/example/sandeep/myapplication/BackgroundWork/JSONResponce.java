package com.example.sandeep.myapplication.BackgroundWork;

import com.example.sandeep.myapplication.Models.MyModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sandeep on 08-02-2017.
 */

public class JSONResponce
{
    @SerializedName("result")
    List<MyModel> list;

    public List<MyModel> getList() {
        return list;
    }

    public void setList(List<MyModel> list) {
        this.list = list;
    }
}
