package DAO_Admin;

import doanoracle_qlthuvienAdmin.Admin_Account;
import doanoracle_qlthuvien.connectionOracle;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo_Admin.pojo_Admin_Account;

public class DAO_Admin_Account {
    Admin_Account em;
    connectionOracle c;
    
    public DAO_Admin_Account()
    {
        c = new connectionOracle();
    }
    
    // Load danh sách tài khoản khách hàng -------------------------------------
    public  void LayDSAdmin_Account_vecter(Vector vdata)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from sys.view_inACCOUNT_USER";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String cm=rs.getString("CMND");
                String pass=rs.getString("pass");
                Vector<String> v=new Vector<String>();
                v.add(cm);
                v.add(pass);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Admin_Account.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Thêm tài khoản khách hàng -----------------------------------------------
    public void ThemAdmin_Account(pojo_Admin_Account x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts=c.con.prepareCall("{call sys.addACCOUNT_USER(?,?)}");
            stmts.setString(1, x.getcM());
            stmts.setString(2, x.getPass());
            stmts.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Account.class.getName()).log(Level.SEVERE,null, ex);
        }
    }

    // Sửa tài khoản khách hàng ------------------------------------------------
    public  void  SuaAdmin_Account(pojo_Admin_Account x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.suaACCOUNT_USER(?,?)}");
            stmts.setString(1, x.getcM());
            stmts.setString(2, x.getPass());
            stmts.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Account.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Xóa tài khoản khách hàng ------------------------------------------------
    public  void  XoaKAdmin_Account(pojo_Admin_Account x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.xoaACCOUNT_USER(?)}");
            stmts.setString(1, x.getcM());
            stmts.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Account.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Tìm kiếm thông tin tài khoản khách hàng ---------------------------------
    public void timKiemAdmin_Account(Vector vdata,pojo_Admin_Account x)
    {     
        Statement state;
        vdata.removeAllElements();
        try
        {
            c.OpenConnection();
            state=c.con.createStatement();
            String sqltimkiem="select * from ACCOUNT_USER where CMND like '%"+x.getcM()+"%'";
            ResultSet rs=state.executeQuery(sqltimkiem);
            while(rs.next())
            {
                String cm=rs.getString("CMND");
                String pass=rs.getString("pass");
                Vector<String> v=new Vector<String>();
                v.add(cm);
                v.add(pass);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Account.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}