package com.example.practicefragment.utility;


import android.content.Context;
import android.util.DisplayMetrics;

public class Utility {
    private static Utility utility;
    private Context context;

    public static Utility getUtility()
    {
        if (utility == null) {
            utility = new Utility();
        }
        return utility;
    }

    public void setContext(Context context)
    {
        this.context = context;
    }

    public int pxToDp(int px) {
        final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public int dpToPx(int dp) {
        final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

}
