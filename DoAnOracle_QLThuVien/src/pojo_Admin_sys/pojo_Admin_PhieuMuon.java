package pojo_Admin_sys;

public class pojo_Admin_PhieuMuon {
    private String CMND, maSach, maNV, ngayBD, ngayKT, tongTien;

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }

    public String getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(String ngayKT) {
        this.ngayKT = ngayKT;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public pojo_Admin_PhieuMuon() {
        CMND = maNV = maSach = ngayBD = ngayKT = tongTien = "";
    }

    public pojo_Admin_PhieuMuon(String CMND, String maSach, String maNV, String ngayBD, String ngayKT, String tongTien) {
        this.CMND = CMND;
        this.maSach = maSach;
        this.maNV = maNV;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.tongTien = tongTien;
    }
}