package util;

import android.content.Context;
import android.content.SharedPreferences;

import com.guaju.retrofittest.app.MyApplication;

/**
 * Created by guaju on 2018/4/13.
 */

public class SPUtil {
    //把String存储到sharedpreference
    public static void saveString(String name,String value){
        SharedPreferences user = MyApplication.getApp().getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = user.edit();
        edit.putString(name,value);
        edit.commit();

    }
    public  static  String getString(String name){
        SharedPreferences user = MyApplication.getApp().getSharedPreferences("user", Context.MODE_PRIVATE);
        String string = user.getString(name, "");
        return string;
    }

}
