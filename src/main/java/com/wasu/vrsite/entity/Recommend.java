package com.wasu.vrsite.entity;

import java.util.Date;

public class Recommend {
    private Integer id;

    private String name;

    private Integer uid;

    private String poster1;

    private String poster2;

    private String poster3;

    private String poster4;

    private String poster5;

    private String poster6;

    private String description;

    private Integer type;

    private Integer status;

    private Date gmtCreate;

    private Date gmtModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPoster1() {
        return poster1;
    }

    public void setPoster1(String poster1) {
        this.poster1 = poster1 == null ? null : poster1.trim();
    }

    public String getPoster2() {
        return poster2;
    }

    public void setPoster2(String poster2) {
        this.poster2 = poster2 == null ? null : poster2.trim();
    }

    public String getPoster3() {
        return poster3;
    }

    public void setPoster3(String poster3) {
        this.poster3 = poster3 == null ? null : poster3.trim();
    }

    public String getPoster4() {
        return poster4;
    }

    public void setPoster4(String poster4) {
        this.poster4 = poster4 == null ? null : poster4.trim();
    }

    public String getPoster5() {
        return poster5;
    }

    public void setPoster5(String poster5) {
        this.poster5 = poster5 == null ? null : poster5.trim();
    }

    public String getPoster6() {
        return poster6;
    }

    public void setPoster6(String poster6) {
        this.poster6 = poster6 == null ? null : poster6.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}