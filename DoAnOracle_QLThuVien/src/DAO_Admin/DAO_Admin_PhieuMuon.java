package DAO_Admin;

import doanoracle_qlthuvien.connectionOracle;
import doanoracle_qlthuvienAdmin.Admin_PhieuMuon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_Admin_PhieuMuon {
    connectionOracle c;
    Admin_PhieuMuon ap;
    
    public DAO_Admin_PhieuMuon()
    {
        c = new connectionOracle();
    }
    
    // Lấy danh sách nhân viên -------------------------------------------------
    public  void load(Vector vdata)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from sys.view_inPHIEUMUON";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String mnv=rs.getString("CMND");
                String tennv=rs.getString("maSach");
                String mcv=rs.getString("maNV");
                String gioit=rs.getString("ngayBD");
                String ngayKT=rs.getString("ngayKT");
                String tt=rs.getString("tongTien");
                Vector<String> v=new Vector<String>();
                v.add(mnv);
                v.add(tennv);
                v.add(mcv);
                v.add(gioit);
                v.add(ngayKT);
                v.add(tt);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Admin_PhieuMuon.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}