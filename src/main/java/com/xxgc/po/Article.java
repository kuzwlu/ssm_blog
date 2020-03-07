package com.xxgc.po;

public class Article {
    private Integer arid;

    private Integer caid;

    private String arnumber;

    private String artitle;

    private String arimage;

    private String aruser;

    private String artime;

    private String arstate;

    private Integer click;

    private String arcontent;

    public Integer getArid() {
        return arid;
    }

    public void setArid(Integer arid) {
        this.arid = arid;
    }

    public Integer getCaid() {
        return caid;
    }

    public void setCaid(Integer caid) {
        this.caid = caid;
    }

    public String getArnumber() {
        return arnumber;
    }

    public void setArnumber(String arnumber) {
        this.arnumber = arnumber == null ? null : arnumber.trim();
    }

    public String getArtitle() {
        return artitle;
    }

    public void setArtitle(String artitle) {
        this.artitle = artitle == null ? null : artitle.trim();
    }

    public String getArimage() {
        return arimage;
    }

    public void setArimage(String arimage) {
        this.arimage = arimage == null ? null : arimage.trim();
    }

    public String getAruser() {
        return aruser;
    }

    public void setAruser(String aruser) {
        this.aruser = aruser == null ? null : aruser.trim();
    }

    public String getArtime() {
        return artime;
    }

    public void setArtime(String artime) {
        this.artime = artime == null ? null : artime.trim();
    }

    public String getArstate() {
        return arstate;
    }

    public void setArstate(String arstate) {
        this.arstate = arstate == null ? null : arstate.trim();
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public String getArcontent() {
        return arcontent;
    }

    public void setArcontent(String arcontent) {
        this.arcontent = arcontent == null ? null : arcontent.trim();
    }
}