package com.hbck.hospital.api;


import com.hbck.hospital.bean.BaseBean;
import com.hbck.lib.ApiFactory;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

    @GET("api/hospital/getHospitals")
    Flowable<BaseBean> getHospitals();

    @GET("api/hospital/getDepartments")
    Flowable<BaseBean> getDepartments(@Query("hosId")Long hosId, @Query("pid")Long pid);

}
