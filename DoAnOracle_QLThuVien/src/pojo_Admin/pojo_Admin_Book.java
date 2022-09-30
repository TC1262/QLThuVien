package pojo_Admin;

public class pojo_Admin_Book {
    private  String mS,tenS,mTG,nXB,giaS,soL;

    public String getmS() {
        return mS;
    }

    public void setmS(String mS) {
        this.mS = mS;
    }

    public String getTenS() {
        return tenS;
    }

    public void setTenS(String tenS) {
        this.tenS = tenS;
    }

    public String getmTG() {
        return mTG;
    }

    public void setmTG(String mTG) {
        this.mTG = mTG;
    }

    public String getnXB() {
        return nXB;
    }

    public void setnXB(String mXB) {
        this.nXB = mXB;
    }

    public String getGiaS() {
        return giaS;
    }

    public void setGiaS(String giaS) {
        this.giaS = giaS;
    }

    public String getSoL() {
        return soL;
    }

    public void setSoL(String soL) {
        this.soL = soL;
    }

    public pojo_Admin_Book(String mS, String tenS, String mTG, String nXB, String giaS, String soL) {
        this.mS = mS;
        this.tenS = tenS;
        this.mTG = mTG;
        this.nXB = nXB;
        this.giaS = giaS;
        this.soL = soL;
    }

    public pojo_Admin_Book() {
    
        mS=tenS=mTG=nXB=giaS=soL="";
    }

    
    @Override
    public String toString() {
        return "pojo_Admin_Book{" + "mS=" + mS + ", tenS=" + tenS + ", mTG=" + mTG + ", nXB=" + nXB + ", giaS=" + giaS + ", soL=" + soL + "}";
    }
}
