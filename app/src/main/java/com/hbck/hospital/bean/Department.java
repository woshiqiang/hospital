package com.hbck.hospital.bean;

import java.io.Serializable;

public class Department implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated Tue Nov 06 17:24:31 CST 2018
     */
    private Long id;

    /**
     * 所属医院id
     *
     * @mbggenerated Tue Nov 06 17:24:31 CST 2018
     */
    private Long h_id;

    /**
     * 科室名称
     *
     * @mbggenerated Tue Nov 06 17:24:31 CST 2018
     */
    private String name;

    /**
     * 简介
     *
     * @mbggenerated Tue Nov 06 17:24:31 CST 2018
     */
    private String brief;

    /**
     * 父id
     *
     * @mbggenerated Tue Nov 06 17:24:31 CST 2018
     */
    private Long pid;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getH_id() {
        return h_id;
    }

    public void setH_id(Long h_id) {
        this.h_id = h_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}