package com.hbck.hospital.base;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.hbck.hospital.R;
import com.hbck.hospital.util.GlideImageLoader;
import com.hbck.hospital.util.SpUtil;

import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.PauseOnScrollListener;
import cn.finalteam.galleryfinal.ThemeConfig;

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

        initGalleryFinal();
    }

    private void initGalleryFinal() {
        //设置主题
        ThemeConfig theme = new ThemeConfig.Builder()
                .setTitleBarBgColor(getResources().getColor(R.color.colorPrimary))
                .setTitleBarTextColor(Color.WHITE)
                .setTitleBarIconColor(Color.WHITE)
                .setFabNornalColor(getResources().getColor(R.color.colorPrimary))
                .setFabPressedColor(Color.BLUE)
                .setCheckNornalColor(Color.WHITE)
                .setCheckSelectedColor(getResources().getColor(R.color.colorPrimary))
                .build();
        //配置功能
        FunctionConfig functionConfig = new FunctionConfig.Builder()
                .setEnableCamera(true)
                .setEnableEdit(true)
                .setEnableCrop(true)
                .setEnableRotate(true)
                .setCropSquare(true)
                .setEnablePreview(true)
                .build();
        CoreConfig coreConfig = new CoreConfig.Builder(this, new GlideImageLoader(), theme)
                .setFunctionConfig(functionConfig)
                .setPauseOnScrollListener(new PauseOnScrollListener(false, true) {
                    @Override
                    public void resume() {

                    }

                    @Override
                    public void pause() {

                    }
                })
                .build();
        GalleryFinal.init(coreConfig);
    }


    public static App getAppContext() {
        return mApp;
    }
}
