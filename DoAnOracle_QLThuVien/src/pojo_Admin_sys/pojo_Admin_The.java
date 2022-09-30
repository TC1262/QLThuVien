package pojo_Admin_sys;

public class pojo_Admin_The {
    private String maThe, ngayCap, loaiThe, CMND;

    public String getMaThe() {
        return maThe;
    }

    public void setMaThe(String maThe) {
        this.maThe = maThe;
    }

    public String getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(String ngayCap) {
        this.ngayCap = ngayCap;
    }

    public String getLoaiThe() {
        return loaiThe;
    }

    public void setLoaiThe(String loaiThe) {
        this.loaiThe = loaiThe;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public pojo_Admin_The() {
        maThe = ngayCap = loaiThe = CMND = "";
    }

    public pojo_Admin_The(String maThe, String ngayCap, String loaiThe, String CMND) {
        this.maThe = maThe;
        this.ngayCap = ngayCap;
        this.loaiThe = loaiThe;
        this.CMND = CMND;
    }
}