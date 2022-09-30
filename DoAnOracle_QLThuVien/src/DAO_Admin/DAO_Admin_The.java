package DAO_Admin;

import doanoracle_qlthuvien.connectionOracle;
import doanoracle_qlthuvienAdmin.Admin_Card;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_Admin_The {
    connectionOracle c;
    Admin_Card ac;
    
    public DAO_Admin_The()
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
            String sql ="select * from sys.view_inTHE";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String mnv=rs.getString("maThe");
                String tennv=rs.getString("ngayCap");
                String mcv=rs.getString("loaiThe");
                String gioit=rs.getString("CMND");
                Vector<String> v=new Vector<String>();
                v.add(mnv);
                v.add(tennv);
                v.add(mcv);
                v.add(gioit);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Admin_The.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}