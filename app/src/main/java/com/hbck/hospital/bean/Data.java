package com.hbck.hospital.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Data implements Serializable {
    public User user;
    public List<Hospital> hospitals;
    public List<Department> departs;

    public String url;//图片url

    public ArrayList<Department> cells;//科室

    public ArrayList<Doctor> doctors;//医生

    public List<TimeLine> timeLines;//排班时间段

    public List<OrderDetail> orders;//我的预约记录

    public OrderDetail orderDetail;//订单

}
