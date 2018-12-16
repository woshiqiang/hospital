package com.hbck.hospital.bean;

import java.io.Serializable;

public class Department implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated Wed Dec 12 12:20:38 CST 2018
     */
    private Long id;

    /**
     * 科室名称
     *
     * @mbggenerated Wed Dec 12 12:20:38 CST 2018
     */
    private String name;

    /**
     * 图片
     *
     * @mbggenerated Wed Dec 12 12:20:38 CST 2018
     */
    private String icon;

    /**
     * 简介
     *
     * @mbggenerated Wed Dec 12 12:20:38 CST 2018
     */
    private String brief;

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }
}