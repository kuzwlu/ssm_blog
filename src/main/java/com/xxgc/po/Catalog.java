package com.xxgc.po;

public class Catalog {
    private Integer caid;

    private String caname;

    private String canumber;

    private String castate;

    public Integer getCaid() {
        return caid;
    }

    public void setCaid(Integer caid) {
        this.caid = caid;
    }

    public String getCaname() {
        return caname;
    }

    public void setCaname(String caname) {
        this.caname = caname == null ? null : caname.trim();
    }

    public String getCanumber() {
        return canumber;
    }

    public void setCanumber(String canumber) {
        this.canumber = canumber == null ? null : canumber.trim();
    }

    public String getCastate() {
        return castate;
    }

    public void setCastate(String castate) {
        this.castate = castate == null ? null : castate.trim();
    }
}