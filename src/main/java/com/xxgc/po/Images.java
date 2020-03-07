package com.xxgc.po;

public class Images {
    private Integer imid;

    private String imtitle;

    private String imname;

    private String imdate;

    private String imstate;

    public Integer getImid() {
        return imid;
    }

    public void setImid(Integer imid) {
        this.imid = imid;
    }

    public String getImtitle() {
        return imtitle;
    }

    public void setImtitle(String imtitle) {
        this.imtitle = imtitle == null ? null : imtitle.trim();
    }

    public String getImname() {
        return imname;
    }

    public void setImname(String imname) {
        this.imname = imname == null ? null : imname.trim();
    }

    public String getImdate() {
        return imdate;
    }

    public void setImdate(String imdate) {
        this.imdate = imdate == null ? null : imdate.trim();
    }

    public String getImstate() {
        return imstate;
    }

    public void setImstate(String imstate) {
        this.imstate = imstate == null ? null : imstate.trim();
    }
}