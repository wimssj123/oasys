package com.cc.vo;

import com.cc.entity.Authority;

import java.util.List;

public class VRole {

    private Integer id;

    private String info;

    private String name;

    private Integer parentid;

    private List<Authority> alist;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public List<Authority> getAlist() {
        return alist;
    }

    public void setAlist(List<Authority> alist) {
        this.alist = alist;
    }
}
