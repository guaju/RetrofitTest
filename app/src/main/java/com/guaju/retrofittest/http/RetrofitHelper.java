package com.guaju.retrofittest.http;

import com.guaju.retrofittest.model.bean.LoginBean;
import com.guaju.retrofittest.model.bean.UploadAvatarBean;

import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import util.SPUtil;

/**
 * Created by guaju on 2018/4/13.
 */

public class RetrofitHelper {
    String BASEURL="http://192.168.190.188/Goods/app/";
    Retrofit retrofit=null;
    private final GoodsServices goodsServices;
    public static RetrofitHelper retrofitHelper=new RetrofitHelper();


    private RetrofitHelper(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        //通过retrofit类去把我们的网络请求service实例化出来
        goodsServices = retrofit.create(GoodsServices.class);
    }


    public  static RetrofitHelper getInstance(){
        return  retrofitHelper;
    }



    //提供一些方法去调用service实体类的方法
    public void login(String username, String password, final OnSuccessListener listener){
        final Observable<LoginBean> login = goodsServices.login(username, password);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<LoginBean>() {
                    @Override
                    public void call(LoginBean loginBean) {
                        listener.onSuccess(loginBean);
                    }
                });

    }
    //提供上传头像的方法
    public void uploadAvatar(RequestBody rb,final OnSuccessListener listener){
        //先拿到token值
        String token="";
        token= SPUtil.getString("token");
        Observable<UploadAvatarBean> uploadAvatarBeanObservable = goodsServices.upLoadAvatar(token, rb);
        uploadAvatarBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<UploadAvatarBean>() {
                    @Override
                    public void call(UploadAvatarBean uploadAvatarBean) {
                        listener.onSuccess(uploadAvatarBean);
                    }
                });

    }



    //当我获取数据成功后要做什么处理
    public interface OnSuccessListener{
        void onSuccess(Object o);
    }

}
