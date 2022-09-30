package DAO_Admin;

import doanoracle_qlthuvien.connectionOracle;
import doanoracle_qlthuvienAdmin.Admin_Customer;
import doanoracle_qlthuvienAdmin.Admin_Staff;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo_Admin.pojo_Admin_Staff;

public class DAO_Admin_Staff {
    Admin_Staff em;
    connectionOracle c;
    public DAO_Admin_Staff()
    {
        c=new connectionOracle();
    }
    
    // Lấy danh sách nhân viên -------------------------------------------------
    public  void LayDSAdmin_Staff_vecter(Vector vdata)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from sys.view_inNHANVIEN";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String mnv=rs.getString("maNV");
                String tennv=rs.getString("tenNV");
                String mcv=rs.getString("maCV");
                String gioit=rs.getString("gioiTinh");
                String nams=rs.getString("namSinh");
                String tendc=rs.getString("tenDC");
                String sdt=rs.getString("dienThoai");
                String luong=rs.getString("Luong");
                Vector<String> v=new Vector<String>();
                v.add(mnv);
                v.add(tennv);
                v.add(mcv);
                v.add(gioit);
                v.add(nams);
                v.add(tendc);
                v.add(sdt);
                v.add(luong);
                vdata.add(v);

            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Admin_Staff.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Lấy danh sách địa chỉ ---------------------------------------------------
    public  void LayDScomboboxAdmin_Staff_Dia_chi_vecter(Vector cdata)
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
    
    // Thêm nhân viên ----------------------------------------------------------
    public void ThemNhanVien(pojo_Admin_Staff x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts=c.con.prepareCall("{call sys.addNHANVIEN(?,?,?,?,?,?,?,?)}");
            stmts.setString(1, x.getmNV());
            stmts.setString(2, x.getTenNV());
            stmts.setString(3, x.getmCV());
            stmts.setString(4, x.getGioiT());
            stmts.setString(5, x.getNamS());
            stmts.setString(6, x.getTenDC());
            stmts.setString(7, x.getDienT());
            stmts.setString(8, x.getLuong());
            stmts.execute();

            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Staff.class.getName()).log(Level.SEVERE,null, ex);
        }
    }

    // Sửa nhân viên -----------------------------------------------------------
    public  void  SuaNhanVien(pojo_Admin_Staff x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.suaNHANVIEN(?,?,?,?,?,?,?,?)}");
            stmts.setString(1, x.getmNV());
            stmts.setString(2, x.getTenNV());
            stmts.setString(3, x.getmCV());
            stmts.setString(4, x.getGioiT());
            stmts.setString(5, x.getNamS());
            stmts.setString(6, x.getTenDC());
            stmts.setString(7, x.getDienT());
            stmts.setString(8, x.getLuong());
            stmts.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Account.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Xóa nhân viên -----------------------------------------------------------
    public  void  XoaNhanVien(pojo_Admin_Staff x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.xoaNHANVIEN(?)}");
            stmts.setString(1, x.getmNV());
            stmts.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Staff.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Tìm kiếm nhân viên ------------------------------------------------------
    public  void timkemnhanvien(Vector vdata,pojo_Admin_Staff x)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from NHANVIEN where (manv like '%"+x.getmNV()+"%') "
                    + "or (Tennv like '%"+x.getmNV()+"%') or (macv like '%"+x.getmNV()+"%') or " +
                    "(gioitinh like '%"+x.getmNV()+"%') or (namsinh like '%"+x.getmNV()+"%') "
                    + "or (tendc like '%"+x.getmNV()+"%') or (dienthoai like '%"+x.getmNV()+"%') or " +
                    "(luong like '%"+x.getmNV()+"%')";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String cm=rs.getString("maNV");
                String ten=rs.getString("tenNV");
                String ngaySinh=rs.getString("maCV");
                String gioit=rs.getString("gioiTinh");
                String namSinh=rs.getString("namSinh");
                String tendc=rs.getString("tenDC");
                String dient=rs.getString("dienThoai");
                String luong = rs.getString("luong");
                Vector<String> v=new Vector<String>();
                v.add(cm);
                v.add(ten);
                v.add(ngaySinh);
                v.add(gioit);
                v.add(tendc);
                v.add(dient);
                v.add(luong);
                v.add(namSinh);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Admin_Staff.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}