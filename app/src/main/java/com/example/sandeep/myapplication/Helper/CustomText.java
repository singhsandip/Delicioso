package com.example.sandeep.myapplication.Helper;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by sandeep on 31-05-2017.
 */

public class CustomText extends TextView
{
    public CustomText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/myfont.ttf"));
    }

}
