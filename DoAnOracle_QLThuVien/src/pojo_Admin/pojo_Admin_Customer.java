package pojo_Admin;

public class pojo_Admin_Customer {
    private String cM,ten,ngaySinh,gioiT,tenDC,dienT,avt;

    public String getcM() {
        return cM;
    }

    public void setcM(String cM) {
        this.cM = cM;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getngaySinh() {
        return ngaySinh;
    }

    public void setngaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiT() {
        return gioiT;
    }

    public void setGioiT(String gioiT) {
        this.gioiT = gioiT;
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
    
    public String getAvt() {
        return avt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }

    public pojo_Admin_Customer(String cM, String ten, String ngaySinh, 
            String gioiT, String tenDC, String dienT) {
        this.cM = cM;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiT = gioiT;
        this.tenDC = tenDC;
        this.dienT = dienT;
    }

    public pojo_Admin_Customer() {
    
        cM = ten = ngaySinh = gioiT = tenDC = dienT = "";
    }

    @Override
    public String toString() {
        return "pojo_Admin_Customer{" + "cM=" + cM + ", ten=" + ten + ", ngaySinh=" + ngaySinh + ", gioiT=" + gioiT + ", tenDC=" + tenDC + ", dienT=" + dienT + '}';
    }
}