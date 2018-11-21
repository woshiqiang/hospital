package com.hbck.hospital.bean;

import java.io.Serializable;
import java.util.List;


public class Data implements Serializable {
    public User user;
    public List<Hospital> hospitals;
    public List<Department> departs;
}
