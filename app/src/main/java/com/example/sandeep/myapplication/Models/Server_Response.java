package com.example.sandeep.myapplication.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sandeep on 10-02-2017.
 */

public class Server_Response
{
    class ServerResponse {

        // variable name should be same as in the json response from php    @SerializedName("success")
        boolean success;
        @SerializedName("message")
        String message;

        String getMessage() {
            return message;
        }

        boolean getSuccess() {
            return success;
        }

    }
}
