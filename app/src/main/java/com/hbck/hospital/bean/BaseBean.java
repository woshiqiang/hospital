package com.hbck.hospital.bean;

import java.io.Serializable;


public class BaseBean  implements Serializable{
    public int code;
    public String message;
    public Data data;


    @Override
    public String toString() {
        return "BaseBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
