package com.cc.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class VDepart {
    private Integer id;

    private String name;
    //部门人数
    private Integer num;
    @JsonFormat(pattern="yyyy-MM-dd ",timezone="GMT+8")
    private Date createtime;

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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
