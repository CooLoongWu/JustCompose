package com.example.justcompose.utils;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * 顶部栏工具类
 *
 * @author Created by gold on 2018/7/17 15:27
 */
public class BarUtil {

    /**
     * 设置顶部状态栏透明
     *
     * @param activity activity
     */
    public static void execStatusBarTranslucent(Activity activity) {

        Window window = activity.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }

        //解决 状态栏变色的bug
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            window.setStatusBarColor(Color.TRANSPARENT);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                try {
//                    Class decorViewClazz = Class.forName("com.android.internal.policy.DecorView");
//                    Field field = decorViewClazz.getDeclaredField("mSemiTransparentStatusBarColor");
//                    field.setAccessible(true);
//                    field.setInt(activity.getWindow().getDecorView(), Color.TRANSPARENT);  //去掉高版本蒙层改为透明
//                } catch (Exception e) {
//                }
//            }
//        }
    }
}
