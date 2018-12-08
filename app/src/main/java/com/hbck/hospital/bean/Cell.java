package com.hbck.hospital.bean;

import java.io.Serializable;

public class Cell implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated Sat Dec 08 14:05:50 CST 2018
     */
    private Long id;

    /**
     * 科室名称
     *
     * @mbggenerated Sat Dec 08 14:05:50 CST 2018
     */
    private String name;

    /**
     * 科室图标
     *
     * @mbggenerated Sat Dec 08 14:05:50 CST 2018
     */
    private String icon;

    /**
     * 科室简介
     *
     * @mbggenerated Sat Dec 08 14:05:50 CST 2018
     */
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}