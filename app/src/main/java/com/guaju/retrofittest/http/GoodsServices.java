package com.guaju.retrofittest.http;

import com.guaju.retrofittest.model.bean.LoginBean;
import com.guaju.retrofittest.model.bean.UploadAvatarBean;
import com.guaju.retrofittest.model.bean.UploadGoodsBean;

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

    //3、发布商品
//    title       必选
//    description    必选
//    price             必选
//    mobile               必选
//    qq
//    wechat
//    email
//    photo[]  必选
//    token    必选
//    @Multipart
//    @POST("app/item/issue.json")
//    Observable<UploadGoodsBean> uploadGoods(@Query("title") String title,
//                                            @Query("description") String description,
//                                            @Query("price") String price,
//                                            @Query("mobile") String mobile,
//                                            @Query("token") String token,
//                                            @PartMap() HashMap<String, RequestBody> map);

    @Multipart
    @POST("app/item/issue.json")
    Observable<UploadGoodsBean> uploadGoods2(@Part("title") String title,
                                             @Part("description") String description,
                                             @Part("price") String price,
                                             @Part("mobile") String mobile,
                                             @Part("token") String token,
                                             @Part("photo\"; filename=\"test.jpg\"") RequestBody[] requestBodies);
}
