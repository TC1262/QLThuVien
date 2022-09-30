package DAO_Admin_sys;

import doanoracle_qlthuvien.connectionOracle;
import doanoracle_qlthuvienAdmin_sys.Admin_RightsGroup;
import doanoracle_qlthuvienAdmin.Admin_Statistical;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo_Admin_sys.pojo_Admin_RightsGroup;
import pojo_Admin_sys.pojo_Admin_SysPermission;

public class DAO_Admin_RightsGroup {
    Admin_RightsGroup rg;
    connectionOracle c;
    
    public DAO_Admin_RightsGroup()
    {
        c=new connectionOracle();
    }
    
    // Lấy danh sách thông tin nhóm quyền --------------------------------------
    public  void LayDSAdmin_RightsGroup_vecter(Vector vdata)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from sys.view_inroles";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String us=rs.getString("role");
                String id=rs.getString("password_required");
                String acst=rs.getString("authentication_type");
                String ld=rs.getString("common");
                String ed=rs.getString("oracle_maintained");
                Vector<String> v=new Vector<String>();
                v.add(us);
                v.add(id);
                v.add(acst);
                v.add(ld);
                v.add(ed);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void TaoNhomquyen(pojo_Admin_RightsGroup x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.taognhomquyen(?,?,?)}");
            stmts.setString(1, x.getRole());
            stmts.setString(2, x.getPwRequired());
            stmts.setString(3, x.getAuthenType());
            stmts.execute();

            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_RightsGroup.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    public void ThemquyenNhomquyen(pojo_Admin_RightsGroup x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.themquyenvaonhomquyen(?,?,?)}");
            stmts.setString(1, x.getRole());
            stmts.setString(2, x.getPwRequired());
            stmts.setString(3, x.getAuthenType());
            stmts.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_RightsGroup.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    public void XoaNhomquyen(pojo_Admin_RightsGroup x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.xoanhomquyen(?)}");
            stmts.setString(1, x.getRole());
            stmts.execute();

            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_RightsGroup.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    public void ThemNhomquyenchoUser(pojo_Admin_RightsGroup x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.gannhomquyenchouser(?,?)}");
            stmts.setString(1, x.getCommon());
            stmts.setString(2, x.getOMaintained());
            stmts.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_RightsGroup.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    public void ThuhoiNhomquyenchoUser(pojo_Admin_RightsGroup x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.thuhoinhomquyenchouser(?,?)}");
            stmts.setString(1, x.getCommon());
            stmts.setString(2, x.getOMaintained());
            stmts.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_RightsGroup.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Tìm kiếm ----------------------------------------------------------------
    public void timKiem(Vector vdata,pojo_Admin_RightsGroup x)
    {     
        Statement state;
        vdata.removeAllElements();
        try
        {
           c.OpenConnection();
           state=c.con.createStatement();
           String sqltimkiem="select * from sys.dba_sys_privs " +
                    "where grantee in (select role from sys.dba_roles where common='NO') "
                   + "and grantee like '%"+ x.getRole() +"%' " +
                    " order by grantee asc ";
           ResultSet rs=state.executeQuery(sqltimkiem);
           while(rs.next())
           {
                String us=rs.getString("grantee");
                String id=rs.getString("privilege");
                String acst=rs.getString("admin_option");
                String ld=rs.getString("common");
                Vector<String> v=new Vector<String>();
                v.add(us);
                v.add(id);
                v.add(acst);
                v.add(ld);
                vdata.add(v);
           }
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_RightsGroup.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}