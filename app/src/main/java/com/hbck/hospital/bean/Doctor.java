package com.hbck.hospital.bean;

import java.io.Serializable;
import java.util.Date;

public class Doctor implements Serializable {
    private Long id;

    /**
     * 姓名
     *
     * @mbggenerated Sat Dec 08 14:35:31 CST 2018
     */
    private String name;

    /**
     * 性别
     *
     * @mbggenerated Sat Dec 08 14:35:31 CST 2018
     */
    private String sex;

    /**
     * 职称
     *
     * @mbggenerated Sat Dec 08 14:35:31 CST 2018
     */
    private String title;

    /**
     * 主诊
     *
     * @mbggenerated Sat Dec 08 14:35:31 CST 2018
     */
    private String major;

    /**
     * 医生编号
     *
     * @mbggenerated Sat Dec 08 14:35:31 CST 2018
     */
    private String doc_num;

    /**
     * 年龄
     *
     * @mbggenerated Sat Dec 08 14:35:31 CST 2018
     */
    private Integer age;

    /**
     * 从业年限
     *
     * @mbggenerated Sat Dec 08 14:35:31 CST 2018
     */
    private Integer job_time;

    /**
     * 毕业院校
     *
     * @mbggenerated Sat Dec 08 14:35:31 CST 2018
     */
    private String college;

    /**
     * 就诊时间
     *
     * @mbggenerated Sat Dec 08 14:35:31 CST 2018
     */
    private String do_time;

    /**
     * 简介
     *
     * @mbggenerated Sat Dec 08 14:35:31 CST 2018
     */
    private String description;

    /**
     * 头像
     *
     * @mbggenerated Sat Dec 08 14:35:31 CST 2018
     */
    private String image;

    /**
     * 挂号费
     *
     * @mbggenerated Sat Dec 08 14:35:31 CST 2018
     */
    private Integer money;

    /**
     * 电话
     *
     * @mbggenerated Sat Dec 08 14:35:31 CST 2018
     */
    private String phone;

    /**
     * 出生日期
     *
     * @mbggenerated Sat Dec 08 14:35:31 CST 2018
     */
    private Date birthday;

    /**
     * 所属科室id
     *
     * @mbggenerated Sat Dec 08 14:35:31 CST 2018
     */
    private Long cell_id;

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

    public String getDoc_num() {
        return doc_num;
    }

    public void setDoc_num(String doc_num) {
        this.doc_num = doc_num == null ? null : doc_num.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getJob_time() {
        return job_time;
    }

    public void setJob_time(Integer job_time) {
        this.job_time = job_time;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public String getDo_time() {
        return do_time;
    }

    public void setDo_time(String do_time) {
        this.do_time = do_time == null ? null : do_time.trim();
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
        this.image = image == null ? null : image.trim();
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getCell_id() {
        return cell_id;
    }

    public void setCell_id(Long cell_id) {
        this.cell_id = cell_id;
    }
}