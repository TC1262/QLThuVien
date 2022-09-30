package DAO_Admin;

import doanoracle_qlthuvien.connectionOracle;
import doanoracle_qlthuvienAdmin.Admin_Customer;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo_Admin.pojo_Admin_Customer;
import pojo_Admin.pojo_Admin_Staff;

public class DAO_Admin_Customer {
    Admin_Customer em;
    connectionOracle c;
    
    public DAO_Admin_Customer()
    {
        c=new connectionOracle();
    }
    
    // Lấy danh sách khách hàng ------------------------------------------------
    public  void LayDSAdmin_Customer_vecter(Vector vdata)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from sys.view_inKHACH";
            
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String cm=rs.getString("CMND");
                String ten=rs.getString("Ten");
                String ngaySinh=rs.getString("ngaySinh");
                String gioit=rs.getString("gioiTinh");
                String tendc=rs.getString("tenDC");
                String dient=rs.getString("dienThoai");
                Vector<String> v=new Vector<String>();
                v.add(cm);
                v.add(ten);
                v.add(ngaySinh);
                v.add(gioit);
                v.add(tendc);
                v.add(dient);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Admin_Customer.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Lấy danh sách địa chỉ ---------------------------------------------------
    public void LayDScomboboxAdmin_Customer_vecter(Vector cdata)
    {
        Statement stmt;
        cdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from sys.view_inDiaChi";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {

                String tendc=rs.getString("tenDC");
                Vector<String> v=new Vector<String>();
                v.add(tendc);

                cdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    // Thêm mới 1 khách hàng ---------------------------------------------------
    public void ThemKhach(pojo_Admin_Customer x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts=c.con.prepareCall("{call sys.addKHACH(?,?,?,?,?,?)}");
            stmts.setString(1, x.getcM());
            stmts.setString(2, x.getTen());
            stmts.setString(3, x.getngaySinh());
            stmts.setString(4, x.getGioiT());
            stmts.setString(5, x.getTenDC());
            stmts.setString(6, x.getDienT());
            stmts.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Customer.class.getName()).log(Level.SEVERE,null, ex);
        }
    }

    // Sửa khách hàng ----------------------------------------------------------
    public  void  SuaKhach(pojo_Admin_Customer x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.suaKHACH(?,?,?,?,?,?)}");
            stmts.setString(1, x.getcM());
            stmts.setString(2, x.getTen());
            stmts.setString(3, x.getngaySinh());
            stmts.setString(4, x.getGioiT());
            stmts.setString(5, x.getTenDC());
            stmts.setString(6, x.getDienT());
            stmts.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Customer.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Xóa khách hàng ----------------------------------------------------------
    public  void  XoaKhach(pojo_Admin_Customer x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.xoaKHACH(?)}");
            stmts.setString(1, x.getcM());
            stmts.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Customer.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Tìm kiếm khách hàng -----------------------------------------------------
    public  void timkemnhanvien(Vector vdata,pojo_Admin_Customer x)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from KHACH where (cmnd like '%"+x.getcM()+"%') "
                    + "or (ten like '%"+x.getcM()+"%') or (ngaySinh like '%"+x.getcM()+"%') or " +
                    "(gioitinh like '%"+x.getcM()+"%') or (tenDC like '%"+x.getcM()+"%') "
                    + "or (dienthoai like '%"+x.getcM()+"%')";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String cm=rs.getString("CMND");
                String ten=rs.getString("Ten");
                String ngaySinh=rs.getString("ngaySinh");
                String gioit=rs.getString("gioiTinh");
                String tendc=rs.getString("tenDC");
                String dient=rs.getString("dienThoai");
                Vector<String> v=new Vector<String>();
                v.add(cm);
                v.add(ten);
                v.add(ngaySinh);
                v.add(gioit);
                v.add(tendc);
                v.add(dient);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Admin_Customer.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}