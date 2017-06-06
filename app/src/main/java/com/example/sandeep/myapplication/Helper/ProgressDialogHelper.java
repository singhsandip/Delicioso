package com.example.sandeep.myapplication.Helper;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by sandeep on 03-04-2017.
 */

public class ProgressDialogHelper {

        private static ProgressDialog progressDialog;

        public static ProgressDialog getProgressDialog(Context context)
        {
            if (progressDialog == null)
            {
                progressDialog = new ProgressDialog(context);
            }
            return  progressDialog;
        }

}
