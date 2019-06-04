package com.mt.b.mvp_dagger.mvp.model.network;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Author : ZSK
 * Date : 2019/6/3
 * Description :
 */
public interface RetrofitService {

    String HOST = "https://www.wanandroid.com/";

    /**
     * 登陆
     * @param username user name
     * @param password password
     */
    @POST("user/login")
    @FormUrlEncoded
    Observable<ResponseBody> login(@Field("username") String username, @Field("password") String password);


   /* //上传图片
    @Multipart
    @POST("/Courier/CourierService/uploadCardImg")
    Observable<ResponseBody> uploadPicture(@Part MultipartBody.Part signature, @Part MultipartBody.Part file);*/


}
