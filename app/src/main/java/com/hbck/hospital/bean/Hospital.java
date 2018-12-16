package com.hbck.hospital.bean;

import java.io.Serializable;

public class Hospital implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated Wed Nov 07 14:50:21 CST 2018
     */
    private Long id;

    /**
     * 医院名称
     *
     * @mbggenerated Wed Nov 07 14:50:21 CST 2018
     */
    private String name;

    /**
     * 重点科室
     *
     * @mbggenerated Wed Nov 07 14:50:21 CST 2018
     */
    private String cell;

    /**
     * 级别
     *
     * @mbggenerated Wed Nov 07 14:50:21 CST 2018
     */
    private String level;

    /**
     * 电话
     *
     * @mbggenerated Wed Nov 07 14:50:21 CST 2018
     */
    private String tel;

    /**
     * 地址
     *
     * @mbggenerated Wed Nov 07 14:50:21 CST 2018
     */
    private String address;

    /**
     * 公交线路
     *
     * @mbggenerated Wed Nov 07 14:50:21 CST 2018
     */
    private String rout;

    /**
     * 经度
     *
     * @mbggenerated Wed Nov 07 14:50:21 CST 2018
     */
    private Double longitude;

    /**
     * 纬度
     *
     * @mbggenerated Wed Nov 07 14:50:21 CST 2018
     */
    private Double latitude;

    /**
     * 简介
     *
     * @mbggenerated Wed Nov 07 14:50:21 CST 2018
     */
    private String description;

    private String image;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell == null ? null : cell.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getRout() {
        return rout;
    }

    public void setRout(String rout) {
        this.rout = rout == null ? null : rout.trim();
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}