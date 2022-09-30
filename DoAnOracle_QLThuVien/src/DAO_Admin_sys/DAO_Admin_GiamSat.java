package DAO_Admin_sys;

import doanoracle_qlthuvien.connectionOracle;
import doanoracle_qlthuvienAdmin_sys.Admin_Database;
import doanoracle_qlthuvienAdmin_sys.Admin_GiamSat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_Admin_GiamSat {
    Admin_GiamSat em;
    connectionOracle c;
    public DAO_Admin_GiamSat()
    {
        c=new connectionOracle();
    }
    
    // Lấy thông tin database --------------------------------------------------
    public  void LayDSAdmin_GiamSat_vecter(Vector vdata)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from sys.xemgiamsat";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String n=rs.getString("timestamp");
                String c=rs.getString("db_user");
                String l=rs.getString("userhost");
                String ctr=rs.getString("object_schema");
                String om=rs.getString("object_name");
                String pm=rs.getString("policy_name");
                String st=rs.getString("sql_text");
                String stp=rs.getString("statement_type");
                Vector<String> v=new Vector<String>();
                v.add(n);
                v.add(c);
                v.add(l);
                v.add(ctr);
                v.add(om);
                v.add(pm);
                v.add(st);
                v.add(stp);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Admin_GiamSat.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}