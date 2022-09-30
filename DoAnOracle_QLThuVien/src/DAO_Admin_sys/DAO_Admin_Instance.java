package DAO_Admin_sys;

import doanoracle_qlthuvien.connectionOracle;
import doanoracle_qlthuvienAdmin_sys.Admin_Instance;
import doanoracle_qlthuvienAdmin_sys.Admin_Process;
import doanoracle_qlthuvienAdmin.Admin_Staff;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo_Admin_sys.pojo_Admin_Instance;
import pojo_Admin_sys.pojo_Admin_Process;

public class DAO_Admin_Instance {
    Admin_Instance em;
    connectionOracle c;
    public DAO_Admin_Instance()
    {
        c=new connectionOracle();
    }
    
    // Lấy thông tin instance --------------------------------------------------
    public  void LayDSAdmin_Instance_vecter(Vector vdata)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from sys.view_ininstance";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String in=rs.getString("instance_name");
                String hn=rs.getString("host_name");
                String stupt=rs.getString("startup_time");
                String st=rs.getString("status");
                Vector<String> v=new Vector<String>();
                v.add(in);
                v.add(hn);
                v.add(stupt);
                v.add(st);

                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Admin_Instance.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Tìm kiếm ----------------------------------------------------------------
    public void timKiem(Vector vdata,pojo_Admin_Instance x)
    {     
        Statement state;
        vdata.removeAllElements();
        try
        {
           c.OpenConnection();
           state=c.con.createStatement();
           String sqltimkiem="select instance_name,host_name,startup_time,status " +
                "from sys.v$instance where (instance_name like '%"+x.getInstance_name()+"%') "
                + "or  (host_name like '%"+x.getInstance_name()+"%') or " +
                " (startup_time like '%"+x.getInstance_name()+"%') or  "
                + "(status like '%"+x.getInstance_name()+"%')";
           ResultSet rs=state.executeQuery(sqltimkiem);
           while(rs.next())
           {
                String in=rs.getString("instance_name");
                String hn=rs.getString("host_name");
                String stupt=rs.getString("startup_time");
                String st=rs.getString("status");
                Vector<String> v=new Vector<String>();
                v.add(in);
                v.add(hn);
                v.add(stupt);
                v.add(st);

                vdata.add(v);
           }
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Instance.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}