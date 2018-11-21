package com.hbck.hospital.base;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.hbck.hospital.util.SpUtil;

/**
 * @Date 2018-10-31.
 */
public class App extends Application{
    private static App mApp;
    public static int width;
    public static int height;

    @Override
    public void onCreate() {
        super.onCreate();
        SpUtil.init(this);
        mApp = this;

        WindowManager manager = (WindowManager) getBaseContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        width = outMetrics.widthPixels;
        height = outMetrics.heightPixels;
    }


    public static App getAppContext() {
        return mApp;
    }
}
