package com.guaju.retrofittest;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.guaju.retrofittest.http.RetrofitHelper;
import com.guaju.retrofittest.model.bean.LoginBean;
import com.guaju.retrofittest.model.bean.UploadAvatarBean;
import com.guaju.retrofittest.model.bean.UploadGoodsBean;

import java.io.File;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import util.SPUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login();


    }

    private void login() {
        RetrofitHelper instance = RetrofitHelper.getInstance();
        instance.login("15866666666", "123456", new RetrofitHelper.OnSuccessListener() {
            @Override
            public void onSuccess(Object o) {
                LoginBean loginBean= (LoginBean) o;
                Toast.makeText(MainActivity.this, loginBean.getInfo()+loginBean.getToken(), Toast.LENGTH_SHORT).show();
                //存入到sharedPreference中
                SPUtil.saveString("token",loginBean.getToken());

            }
        });
    }
    //上传头像的方法
    public void uploadAvatar(View view) {
        File file = new File(Environment.getExternalStorageDirectory() + "/" + "retrofit/" + "speed.jpg");
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        RetrofitHelper.getInstance().uploadAvatar(requestBody, new RetrofitHelper.OnSuccessListener() {
            @Override
            public void onSuccess(Object o) {
                UploadAvatarBean uploadAvatarBean=(UploadAvatarBean)o;
                Toast.makeText(MainActivity.this, uploadAvatarBean.toString(), Toast.LENGTH_SHORT).show();
                //当上传成功的时候打印成功
                //失败的时候提示再次上传
            }
        });



    }

    public void uploadGoods(View view) {
        HashMap<String, RequestBody> map = new HashMap<>();
        RequestBody[] bodies=new RequestBody[1];
        String name="photo\"; filename=\"test.jpg\"";

        File file = new File(Environment.getExternalStorageDirectory() + "/" + "retrofit/" + "speed.jpg");
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        File file2 = new File(Environment.getExternalStorageDirectory() + "/" + "retrofit/" + "speed2.jpg");
        RequestBody requestBody2 = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        File file3 = new File(Environment.getExternalStorageDirectory() + "/" + "retrofit/" + "speed3.jpg");
        RequestBody requestBody3 = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        File file4 = new File(Environment.getExternalStorageDirectory() + "/" + "retrofit/" + "speed4.jpg");
        RequestBody requestBody4 = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        map.put(name,requestBody);
        bodies[0]=requestBody;
//        map.put(name,requestBody2);
//        map.put(name,requestBody3);
//        map.put(name,requestBody4);

        RetrofitHelper.getInstance().uploadGoods(bodies, new RetrofitHelper.OnSuccessListener() {
            @Override
            public void onSuccess(Object o) {
                UploadGoodsBean bean = (UploadGoodsBean) o;
                Log.e("GUAJU", bean.toString()  );
                Toast.makeText(MainActivity.this, bean.toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
