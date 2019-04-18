package com.cc.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class VCourse {
    private Integer id;

    private String name;

    private Integer week;
    @JsonFormat(pattern="yyyy-MM-dd ",timezone="GMT+8")
    private Date createdate;
    private Integer tid;
    private String typeName;

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
        this.name = name;
    }



    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }
}
