package com.guaju.retrofittest.app;

import android.app.Application;

/**
 * Created by guaju on 2018/4/13.
 */

public class MyApplication extends Application {
  public  static  MyApplication application;
    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
    }
   public static MyApplication getApp(){
        return application;
   }


}
