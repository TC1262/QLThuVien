package DAO_Admin_sys;

import doanoracle_qlthuvien.connectionOracle;
import doanoracle_qlthuvienAdmin_sys.Admin_CreateUser;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo_Admin_sys.pojo_Admin_TaoUser;

public class DAO_Admin_TaoUser {
    Admin_CreateUser em;
    connectionOracle c;
    public DAO_Admin_TaoUser()
    {
        c=new connectionOracle();
    }
    
    // Lấy thông tin user ------------------------------------------------------
    public  void LayDSAdmin_TaoUser_vecter(Vector vdata)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from sys.view_taouser";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String us=rs.getString("username");
                String p=rs.getString("password");
                String tsp=rs.getString("default_tablespace");
                String pf=rs.getString("profile");
                String act=rs.getString("account_status");
                String cre=rs.getString("created");
                String ll=rs.getString("last_login");
                Vector<String> v=new Vector<String>();
                v.add(us);
                v.add(p);
                v.add(tsp);
                v.add(pf);
                v.add(act);
                v.add(cre);
                v.add(ll);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Admin_TaoUser.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Thêm --------------------------------------------------------------------
    public void Themuser(pojo_Admin_TaoUser x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stm=c.con.prepareCall("{call sys.taouser(?,?,?,?,?,?)}");
            stm.setString(1,x.getUsername());
            stm.setString(2,x.getPassword());
            stm.setString(3,x.getDefault_tablespace());
            stm.setString(4,x.getQuota());
            stm.setString(5,x.getProfile());
            stm.setString(6,x.getRole());
            stm.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_TaoUser.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Sửa ---------------------------------------------------------------------
    public void Suauser(pojo_Admin_TaoUser x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stm=c.con.prepareCall("{call sys.suauser(?,?,?,?,?,?)}");
            stm.setString(1,x.getUsername());
            stm.setString(2,x.getPassword());
            stm.setString(3,x.getDefault_tablespace());
            stm.setString(4,x.getQuota());
            stm.setString(5,x.getProfile());
            stm.setString(6,x.getRole());
            stm.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_TaoUser.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Xóa ---------------------------------------------------------------------
    public  void  Xoauser(pojo_Admin_TaoUser x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.xoauser(?)}");
            stmts.setString(1, x.getUsername());
            stmts.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_TaoUser.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Khóa --------------------------------------------------------------------
    public  void  Khoauser(pojo_Admin_TaoUser x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.khoauser(?)}");
            stmts.setString(1, x.getUsername());
            stmts.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_TaoUser.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Mở khóa -----------------------------------------------------------------
    public  void  MoKhoauser(pojo_Admin_TaoUser x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.mokhoauser(?)}");
            stmts.setString(1, x.getUsername());
            stmts.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_TaoUser.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}