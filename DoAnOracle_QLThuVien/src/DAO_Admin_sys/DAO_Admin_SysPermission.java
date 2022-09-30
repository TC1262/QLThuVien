package DAO_Admin_sys;

import DAO_Admin.DAO_Admin_Book;
import doanoracle_qlthuvien.connectionOracle;
import doanoracle_qlthuvienAdmin_sys.Admin_SysPermission;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo_Admin.pojo_Admin_Book;
import pojo_Admin_sys.pojo_Admin_SysPermission;

public class DAO_Admin_SysPermission {
    Admin_SysPermission as;
    connectionOracle c;
    public DAO_Admin_SysPermission()
    {
        c = new connectionOracle();
    }
    
    // Lấy thông tin về quyền hệ thống -----------------------------------------
    public  void LayDSAdmin_SysPermission_vecter(Vector vdata)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from sys.view_inDBA_SYS_PRIVS";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String sd=rs.getString("grantee");
                String ser=rs.getString("privilege");
                String us=rs.getString("admin_option");
                String pg=rs.getString("common");
                
                Vector<String> v=new Vector<String>();
                v.add(sd);
                v.add(ser);
                v.add(us);
                v.add(pg);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //---------------------------------------------------------
    public void Themquyen(pojo_Admin_SysPermission x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.taoganquyenhethong(?,?,?)}");
            stmts.setString(1, x.getGrantee());
            stmts.setString(2, x.getPrivilege());
            stmts.setString(3, x.getAdOption());
            stmts.execute();

            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_SysPermission.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    public void thuhoiquyen(pojo_Admin_SysPermission x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.thuhoiganquyenhethong(?,?)}");
            stmts.setString(1, x.getGrantee());
            stmts.setString(2, x.getPrivilege());
            stmts.execute();

            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_SysPermission.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Tìm kiếm ----------------------------------------------------------------
    public void timKiem(Vector vdata,pojo_Admin_SysPermission x)
    {     
        Statement state;
        vdata.removeAllElements();
        try
        {
           c.OpenConnection();
           state=c.con.createStatement();
           String sqltimkiem="SELECT * FROM sys.DBA_SYS_PRIVS where grantee like '%"+x.getGrantee().toUpperCase()+"%'";
           ResultSet rs=state.executeQuery(sqltimkiem);
           while(rs.next())
           {
                String sd=rs.getString("grantee");
                String ser=rs.getString("privilege");
                String us=rs.getString("admin_option");
                String pg=rs.getString("common");
                
                Vector<String> v=new Vector<String>();
                v.add(sd);
                v.add(ser);
                v.add(us);
                v.add(pg);
                vdata.add(v);
           }
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_SysPermission.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}