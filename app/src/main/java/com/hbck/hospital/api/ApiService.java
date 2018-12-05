package com.hbck.hospital.api;


import com.hbck.hospital.bean.BaseBean;
import com.hbck.lib.ApiFactory;

import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

@ApiFactory
public interface ApiService {

    /**
     * 注册
     *
     * @param phone    手机号
     * @param password 密码
     * @return
     */
    @POST("api/user/register")
    Flowable<BaseBean> register(@Query("phone") String phone, @Query("password") String password);

    /**
     * 登录
     *
     * @param phone
     * @param password
     * @return
     */
    @POST("api/user/login")
    Flowable<BaseBean> login(@Query("phone") String phone, @Query("password") String password);

    /**
     * 更新用户信息
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})//需要添加头
    @POST("api/user/update")
    Flowable<BaseBean> updateUser(@Body RequestBody info);   // 请求体味RequestBody 类型

    @GET("api/hospital/getHospitals")
    Flowable<BaseBean> getHospitals();

    @GET("api/hospital/getDepartments")
    Flowable<BaseBean> getDepartments(@Query("hosId") Long hosId, @Query("pid") Long pid);


    /**
     * type 1:问题图片 2：头像 3：录音
     */
    @Multipart
    @POST("file/uploadFile")
    Flowable<BaseBean> uploadFile(@PartMap Map<String, RequestBody> map, @Query("type") String type);

}
