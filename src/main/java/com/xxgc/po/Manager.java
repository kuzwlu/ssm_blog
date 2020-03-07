package com.xxgc.po;

public class Manager {
    private Integer managerid;

    private String managername;

    private String passwd;

    private String matate;

    private String maimage;

    public Integer getManagerid() {
        return managerid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername == null ? null : managername.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public String getMatate() {
        return matate;
    }

    public void setMatate(String matate) {
        this.matate = matate == null ? null : matate.trim();
    }

    public String getMaimage() {
        return maimage;
    }

    public void setMaimage(String maimage) {
        this.maimage = maimage == null ? null : maimage.trim();
    }
}