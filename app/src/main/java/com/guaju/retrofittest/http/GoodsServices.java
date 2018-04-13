package com.guaju.retrofittest.http;

import com.guaju.retrofittest.model.bean.LoginBean;
import com.guaju.retrofittest.model.bean.UploadAvatarBean;

import okhttp3.RequestBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by guaju on 2018/4/13.
 */

public interface GoodsServices {
    //BASE URL=http://192.168.190.188/Goods/app/
    //1、登录(获取token值，及个人信息)
    @POST("common/login.json")
    Observable<LoginBean> login(@Query("username") String username,@Query("password") String password);
    //2、上传头像
    @Multipart
    @POST("user/upload.json")
    Observable<UploadAvatarBean> upLoadAvatar(@Query("token") String token, @Part("photo\"; filename=\"test.jpg\"")RequestBody request);

//    {status:1,info:"成功"}
     //3、获取个人信息
//    @POST("app/user/info.json")
    

    //4、发布商品


}
