package com.hbck.hospital.bean;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    /**
     * 预约表主键
     *
     * @mbggenerated Sat Dec 15 17:03:22 CST 2018
     */
    private Long id;

    /**
     * 病人id
     *
     * @mbggenerated Sat Dec 15 17:03:22 CST 2018
     */
    private Long userId;

    /**
     * 医生id
     *
     * @mbggenerated Sat Dec 15 17:03:22 CST 2018
     */
    private Long docId;

    /**
     * 科室id
     *
     * @mbggenerated Sat Dec 15 17:03:22 CST 2018
     */
    private Long depId;

    /**
     * 预约码
     *
     * @mbggenerated Sat Dec 15 17:03:22 CST 2018
     */
    private String orderCode;

    /**
     * 支付状态
     *
     * @mbggenerated Sat Dec 15 17:03:22 CST 2018
     */
    private Integer payState;

    /**
     * 挂号费
     *
     * @mbggenerated Sat Dec 15 17:03:22 CST 2018
     */
    private Integer money;

    /**
     * 就诊日期
     *
     * @mbggenerated Sat Dec 15 17:03:22 CST 2018
     */
    private String yydate;

    /**
     * 开始时间点
     *
     * @mbggenerated Sat Dec 15 17:03:22 CST 2018
     */
    private String starttime;

    /**
     * 结束时间点
     *
     * @mbggenerated Sat Dec 15 17:03:22 CST 2018
     */
    private String endtime;

    /**
     * 添加时间
     *
     * @mbggenerated Sat Dec 15 17:03:22 CST 2018
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getYydate() {
        return yydate;
    }

    public void setYydate(String yydate) {
        this.yydate = yydate == null ? null : yydate.trim();
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}