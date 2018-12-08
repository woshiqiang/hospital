package com.hbck.hospital.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Data implements Serializable {
    public User user;
    public List<Hospital> hospitals;
    public List<Department> departs;

    public ArrayList<String> list;//图片

    public ArrayList<Cell> cells;//科室

    public ArrayList<Doctor> doctors;//医生

}
