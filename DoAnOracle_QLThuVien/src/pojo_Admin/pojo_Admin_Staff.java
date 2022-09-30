package pojo_Admin;

public class pojo_Admin_Staff {
    private String mNV,tenNV,mCV,gioiT,namS,tenDC,dienT,luong,avt;

    public String getmNV() {
        return mNV;
    }

    public void setmNV(String mNV) {
        this.mNV = mNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getmCV() {
        return mCV;
    }

    public void setmCV(String mCV) {
        this.mCV = mCV;
    }

    public String getGioiT() {
        return gioiT;
    }

    public void setGioiT(String gioiT) {
        this.gioiT = gioiT;
    }

    public String getNamS() {
        return namS;
    }

    public void setNamS(String namS) {
        this.namS = namS;
    }

    public String getTenDC() {
        return tenDC;
    }

    public void setTenDC(String tenDC) {
        this.tenDC = tenDC;
    }

    public String getDienT() {
        return dienT;
    }

    public void setDienT(String dienT) {
        this.dienT = dienT;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }
    
    public String getAvt() {
        return avt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }

    public pojo_Admin_Staff(String mNV, String tenNV, String mCV, String gioiT, String namS, String tenDC, String dienT, String luong) {
        this.mNV = mNV;
        this.tenNV = tenNV;
        this.mCV = mCV;
        this.gioiT = gioiT;
        this.namS = namS;
        this.tenDC = tenDC;
        this.dienT = dienT;
        this.luong = luong;
    }

    public pojo_Admin_Staff() {
    
        mNV=tenNV=mCV=gioiT=namS=tenDC=dienT=luong="";
    }

    
    @Override
    public String toString() {
        return "pojio_Admin_Staff{" + "mNV=" + mNV + ", tenNV=" + tenNV + ", mCV=" + mCV + ", gioiT=" + gioiT + ", namS=" + namS + ", tenDC=" + tenDC + ", dienT=" + dienT + ", luong=" + luong + '}';
    }
    
}