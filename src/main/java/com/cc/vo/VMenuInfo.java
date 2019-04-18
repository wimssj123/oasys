package com.cc.vo;

import java.util.List;

public class VMenuInfo {
    private Integer id;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;
    private String title;
    private String icon;
    private List<VMenuInfo> cMenu;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<VMenuInfo> getcMenu() {
        return cMenu;
    }

    public void setcMenu(List<VMenuInfo> cMenu) {
        this.cMenu = cMenu;
    }
}
