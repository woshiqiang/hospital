package com.hbck.hospital.bean;

import java.io.Serializable;

public class Doctor implements Serializable {
    private Long id;

    /**
     * 姓名
     *
     * @mbggenerated Thu Dec 13 16:48:04 CST 2018
     */
    private String name;

    /**
     * 性别
     *
     * @mbggenerated Thu Dec 13 16:48:04 CST 2018
     */
    private String sex;

    /**
     * 职称
     *
     * @mbggenerated Thu Dec 13 16:48:04 CST 2018
     */
    private String title;

    /**
     * 主诊
     *
     * @mbggenerated Thu Dec 13 16:48:04 CST 2018
     */
    private String major;

    /**
     * 出生日期,计算年龄用
     *
     * @mbggenerated Thu Dec 13 16:48:04 CST 2018
     */
    private String birthday;

    /**
     * 参加工作的时间，计算从业年限
     *
     * @mbggenerated Thu Dec 13 16:48:04 CST 2018
     */
    private String job_time;

    /**
     * 毕业院校
     *
     * @mbggenerated Thu Dec 13 16:48:04 CST 2018
     */
    private String college;

    /**
     * 简介
     *
     * @mbggenerated Thu Dec 13 16:48:04 CST 2018
     */
    private String description;

    /**
     * 挂号费
     *
     * @mbggenerated Thu Dec 13 16:48:04 CST 2018
     */
    private Integer money;

    /**
     * 电话
     *
     * @mbggenerated Thu Dec 13 16:48:04 CST 2018
     */
    private String phone;

    /**
     * 所属科室id
     *
     * @mbggenerated Thu Dec 13 16:48:04 CST 2018
     */
    private Long dep_id;

    /**
     * 头像
     *
     * @mbggenerated Thu Dec 13 16:48:04 CST 2018
     */
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getJob_time() {
        return job_time;
    }

    public void setJob_time(String job_time) {
        this.job_time = job_time == null ? null : job_time.trim();
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Long getDep_id() {
        return dep_id;
    }

    public void setDep_id(Long dep_id) {
        this.dep_id = dep_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
}