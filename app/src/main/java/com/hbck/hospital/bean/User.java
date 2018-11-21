package com.hbck.hospital.bean;

import java.io.Serializable;

public class User implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated Tue Oct 30 13:28:11 CST 2018
     */
    private Long id;

    /**
     * 手机号
     *
     * @mbggenerated Tue Oct 30 13:28:11 CST 2018
     */
    private String phone;

    /**
     * 密码
     *
     * @mbggenerated Tue Oct 30 13:28:11 CST 2018
     */
    private String password;

    /**
     * 1:可用 0：禁用
     *
     * @mbggenerated Tue Oct 30 13:28:11 CST 2018
     */
    private Integer state;

    /**
     * 姓名
     *
     * @mbggenerated Tue Oct 30 13:28:11 CST 2018
     */
    private String name;

    /**
     * 昵称
     *
     * @mbggenerated Tue Oct 30 13:28:11 CST 2018
     */
    private String nickname;

    /**
     * 0：未知 1：男 2：女
     *
     * @mbggenerated Tue Oct 30 13:28:11 CST 2018
     */
    private Integer sex;

    /**
     * 头像
     *
     * @mbggenerated Tue Oct 30 13:28:11 CST 2018
     */
    private String image;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
}