package com.hbck.hospital.bean;

import java.io.Serializable;

public class TimeLine implements Serializable {
    private Long id;

    /**
     * 医生id
     *
     * @mbggenerated Wed Dec 26 14:58:16 CST 2018
     */
    private Long doctor_id;

    /**
     * 日期
     *
     * @mbggenerated Wed Dec 26 14:58:16 CST 2018
     */
    private String date;

    /**
     * 允许预约的人数
     *
     * @mbggenerated Wed Dec 26 14:58:16 CST 2018
     */
    private Integer quota;

    /**
     * 时段开始语 例8:00
     *
     * @mbggenerated Wed Dec 26 14:58:16 CST 2018
     */
    private String starttime;

    /**
     *  时段结束 例9:00
     *
     * @mbggenerated Wed Dec 26 14:58:16 CST 2018
     */
    private String endtime;

    /**
     * 该时段是否允许预约 0 否 1允许
     *
     * @mbggenerated Wed Dec 26 14:58:16 CST 2018
     */
    private Integer status;

    /**
     * 已约数量
     *
     * @mbggenerated Wed Dec 26 14:58:16 CST 2018
     */
    private Integer leftnum;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Long doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLeftnum() {
        return leftnum;
    }

    public void setLeftnum(Integer leftnum) {
        this.leftnum = leftnum;
    }
}