package pojo_User;

public class pojo_User_Cart {
    private String maHD, maSach, CMND, giaSach, soLuong;

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getGiaSach() {
        return giaSach;
    }

    public void setGiaSach(String giaSach) {
        this.giaSach = giaSach;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public pojo_User_Cart() {
        maHD = maSach = CMND = giaSach = soLuong = "";
    }

    public pojo_User_Cart(String maSach, String CMND, String giaSach, String soLuong) {
        this.maSach = maSach;
        this.CMND = CMND;
        this.giaSach = giaSach;
        this.soLuong = soLuong;
    }
}