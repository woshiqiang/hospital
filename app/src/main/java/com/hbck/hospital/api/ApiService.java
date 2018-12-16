package com.hbck.hospital.api;


import com.hbck.hospital.bean.BaseBean;
import com.hbck.hospital.bean.Order;
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

    /**
     * 获取科室
     *
     * @param page 默认第一页
     * @param rows 默认 每页30条
     * @return
     */
    @GET("api/hospital/getDepartments")
    Flowable<BaseBean> getDepartments(@Query("page") Integer page, @Query("rows") Integer rows);


    /**
     * 文件上传
     *
     * @param map
     * @return
     */
    @Multipart
    @POST("file/uploadFile")
    Flowable<BaseBean> uploadFile(@PartMap Map<String, RequestBody> map);

    /**
     * 根据科室id获取医生
     *
     * @param departmentId
     * @return
     */
    @GET("api/hospital/getDoctorsByDepartmentId")
    Flowable<BaseBean> getDoctorsByDepartmentId(@Query("departmentId") Long departmentId);


    /**
     * 保存预约订单
     *
     * @param order
     * @return
     */
    @POST("api/hospital/saveOrder")
    Flowable<BaseBean> saveOrder(@Body Order order);

    /**
     * 查询时间段
     *
     * @param docId
     * @return
     */
    @GET("api/hospital/selectTimeLinesByDocId")
    Flowable<BaseBean> selectTimeLinesByDocId(@Query("docId") Long docId);


    /**
     *
     * @param userId
     * @return
     */
    @GET("api/hospital/selectOrders")
    Flowable<BaseBean> selectOrders(@Query("userId") Long userId);

}
