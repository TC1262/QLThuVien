package DAO_Admin_sys;

import doanoracle_qlthuvien.connectionOracle;
import doanoracle_qlthuvienAdmin_sys.Admin_Database;
import doanoracle_qlthuvienAdmin_sys.Admin_Process;
import doanoracle_qlthuvienAdmin.Admin_Staff;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo_Admin_sys.pojo_Admin_Database;
import pojo_Admin_sys.pojo_Admin_Process;

public class DAO_Admin_Database {
    Admin_Database em;
    connectionOracle c;
    public DAO_Admin_Database()
    {
        c=new connectionOracle();
    }
    
    // Lấy thông tin database --------------------------------------------------
    public  void LayDSAdmin_Database_vecter(Vector vdata)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from sys.view_indatabase";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String n=rs.getString("name");
                String c=rs.getString("created");
                String l=rs.getString("Log_mode");
                String ctr=rs.getString("controlfile_time");
                String om=rs.getString("open_mode");
                Vector<String> v=new Vector<String>();
                v.add(n);
                v.add(c);
                v.add(l);
                v.add(ctr);
                v.add(om);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Admin_Database.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Tìm kiếm ----------------------------------------------------------------
    public void timKiemAdmin_Database(Vector vdata,pojo_Admin_Database x)
    {     
        Statement state;
        vdata.removeAllElements();
        try
        {
           c.OpenConnection();
           state=c.con.createStatement();
           String sqltimkiem="select name,created,Log_mode,controlfile_time,open_mode " +
                   "from sys.v$database where (name like '%"+x.getName()+"%') "
                   + "or (created like '%"+x.getName()+"%') or " +
                   "(Log_mode like '%"+x.getName()+"%') or "
                   + "(controlfile_time like '%"+x.getName()+"%') "
                   + "or (open_mode like '%"+x.getName()+"%')";
           ResultSet rs=state.executeQuery(sqltimkiem);
           while(rs.next())
           {
                String n=rs.getString("name");
                String c=rs.getString("created");
                String l=rs.getString("Log_mode");
                String ctr=rs.getString("controlfile_time");
                String om=rs.getString("open_mode");
                Vector<String> v=new Vector<String>();
                v.add(n);
                v.add(c);
                v.add(l);
                v.add(ctr);
                v.add(om);
                vdata.add(v);
           }
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Database.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}