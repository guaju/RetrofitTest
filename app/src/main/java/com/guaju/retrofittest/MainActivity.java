package com.guaju.retrofittest;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.guaju.retrofittest.http.RetrofitHelper;
import com.guaju.retrofittest.model.bean.LoginBean;
import com.guaju.retrofittest.model.bean.UploadAvatarBean;

import java.io.File;

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
}
