package com.xxgc.po;

public class Message {
    private Integer meid;

    private Integer arid;

    private String metitle;

    private Integer userid;

    private Integer managerid;

    private String metime;

    private String mestate;

    private String mecontent;

    public Integer getMeid() {
        return meid;
    }

    public void setMeid(Integer meid) {
        this.meid = meid;
    }

    public Integer getArid() {
        return arid;
    }

    public void setArid(Integer arid) {
        this.arid = arid;
    }

    public String getMetitle() {
        return metitle;
    }

    public void setMetitle(String metitle) {
        this.metitle = metitle == null ? null : metitle.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getManagerid() {
        return managerid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    public String getMetime() {
        return metime;
    }

    public void setMetime(String metime) {
        this.metime = metime == null ? null : metime.trim();
    }

    public String getMestate() {
        return mestate;
    }

    public void setMestate(String mestate) {
        this.mestate = mestate == null ? null : mestate.trim();
    }

    public String getMecontent() {
        return mecontent;
    }

    public void setMecontent(String mecontent) {
        this.mecontent = mecontent == null ? null : mecontent.trim();
    }
}