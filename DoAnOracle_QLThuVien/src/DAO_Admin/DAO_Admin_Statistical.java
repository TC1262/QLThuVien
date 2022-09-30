package DAO_Admin;

import doanoracle_qlthuvien.connectionOracle;
import doanoracle_qlthuvienAdmin.Admin_Statistical;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_Admin_Statistical {
    Admin_Statistical em;
    connectionOracle c;
    
    public DAO_Admin_Statistical()
    {
        c=new connectionOracle();
    }
    
    // Lấy danh sách nhân viên -------------------------------------------------
    public  void load(Vector vdata)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from sys.view_inThongKe";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String mnv=rs.getString("session_id");
                String tennv=rs.getString("db_user");
                String mcv=rs.getString("object_schema");
                String gioit=rs.getString("object_name");
                String nams=rs.getString("policy_name");
                String tendc=rs.getString("sql_text");
                String sdt=rs.getString("statement_type");
                Vector<String> v=new Vector<String>();
                v.add(mnv);
                v.add(tennv);
                v.add(mcv);
                v.add(gioit);
                v.add(nams);
                v.add(tendc);
                v.add(sdt);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Admin_Staff.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}