package DAO_Admin_sys;

import doanoracle_qlthuvien.connectionOracle;
import doanoracle_qlthuvienAdmin_sys.Admin_Datafile;
import doanoracle_qlthuvienAdmin_sys.Admin_Process;
import doanoracle_qlthuvienAdmin.Admin_Staff;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo_Admin_sys.pojo_Admin_Datafile;
import pojo_Admin_sys.pojo_Admin_Process;

public class DAO_Admin_Datafile {
    Admin_Datafile em;
    connectionOracle c;
    public DAO_Admin_Datafile()
    {
        c=new connectionOracle();
    }
    
    // Lấy thông tin datafile --------------------------------------------------
    public  void LayDSAdmin_Datafile_vecter(Vector vdata)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from sys.view_indatafile";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String cc=rs.getString("file_name");
                String ct=rs.getString("file_id");
                String rf=rs.getString("tablespace_name");
                String st=rs.getString("status");
                String enb=rs.getString("bytes");
                String n=rs.getString("maxbytes");
                Vector<String> v=new Vector<String>();
                v.add(cc);
                v.add(ct);
                v.add(rf);
                v.add(st);
                v.add(enb);
                v.add(n);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Admin_Datafile.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Tìm kiếm ----------------------------------------------------------------
    public void timKiem(Vector vdata,pojo_Admin_Datafile x)
    {     
        Statement state;
        vdata.removeAllElements();
        try
        {
           c.OpenConnection();
           state=c.con.createStatement();
           String sqltimkiem="select file_name, file_id, tablespace_name, status, "
                   + "bytes, maxbytes " +
                   "from sys.dba_data_files where (file_name like '%"+x.getFileName()+"%') "
                   + "or (file_id like '%"+x.getFileName()+"%') or " +
                   "(tablespace_name like '%"+x.getFileName()+"%') or "
                   + "(status like '%"+x.getFileName()+"%')  or "
                   + "(bytes like '%SYSTEM%') or (maxbytes like '%SYSTEM%')";
            ResultSet rs=state.executeQuery(sqltimkiem);
            while(rs.next())
            {
                String cc=rs.getString("file_name");
                String ct=rs.getString("file_id");
                String rf=rs.getString("tablespace_name");
                String st=rs.getString("status");
                String enb=rs.getString("bytes");
                String n=rs.getString("maxbytes");
                Vector<String> v=new Vector<String>();
                v.add(cc);
                v.add(ct);
                v.add(rf);
                v.add(st);
                v.add(enb);
                v.add(n);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Datafile.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}