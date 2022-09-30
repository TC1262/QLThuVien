package DAO_Admin_sys;

import doanoracle_qlthuvien.connectionOracle;
import doanoracle_qlthuvienAdmin_sys.Admin_Process;
import doanoracle_qlthuvienAdmin.Admin_Staff;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo_Admin_sys.pojo_Admin_Process;

public class DAO_Admin_Process {
    Admin_Process em;
    connectionOracle c;
    public DAO_Admin_Process()
    {
        c=new connectionOracle();
    }
    
    // Lấy thông tin process ---------------------------------------------------
    public  void LayDSAdmin_Process_vecter(Vector vdata)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from sys.view_inprocess";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String ad=rs.getString("ADDR");
                String pn=rs.getString("PNAME");
                String un=rs.getString("USERNAME");
                String tn=rs.getString("TERMINAL");
                String pg=rs.getString("PROGRAM");
                String tr=rs.getString("TRACEFILE");
                Vector<String> v=new Vector<String>();
                v.add(ad);
                v.add(pn);
                v.add(un);
                v.add(tn);
                v.add(pg);
                v.add(tr);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    // Tìm kiếm ----------------------------------------------------------------
    public void timKiem(Vector vdata,pojo_Admin_Process x)
    {     
        Statement state;
        vdata.removeAllElements();
        try
        {
           c.OpenConnection();
           state=c.con.createStatement();
           String sqltimkiem="select ADDR,PNAME,USERNAME,TERMINAL,PROGRAM,TRACEFILE "
                   + "from sys.v$process " +
                   "where (ADDR like '%"+x.getAddr()+"%') or "
                   + "(PNAME like '%"+x.getAddr()+"%') or " +
                   "(USERNAME like '%"+x.getAddr()+"%') or "
                   + "(TERMINAL like '%"+x.getAddr()+"%') or " +
                   "(PROGRAM like '%"+x.getAddr()+"%') or "
                   + "(TRACEFILE like '%"+x.getAddr()+"%') ";
           ResultSet rs=state.executeQuery(sqltimkiem);
           while(rs.next())
           {
                String ad=rs.getString("ADDR");
                String pn=rs.getString("PNAME");
                String un=rs.getString("USERNAME");
                String tn=rs.getString("TERMINAL");
                String pg=rs.getString("PROGRAM");
                String tr=rs.getString("TRACEFILE");
                Vector<String> v=new Vector<String>();
                v.add(ad);
                v.add(pn);
                v.add(un);
                v.add(tn);
                v.add(pg);
                v.add(tr);
                vdata.add(v);
           }
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Process.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}