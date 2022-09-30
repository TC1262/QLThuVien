package DAO_Admin;

import doanoracle_qlthuvien.connectionOracle;
import doanoracle_qlthuvienAdmin.Admin_Book;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo_Admin.pojo_Admin_Book;

public class DAO_Admin_Book {
    Admin_Book em;
    connectionOracle c;
    
    public DAO_Admin_Book()
    {
        c = new connectionOracle();
    }
    
    // Lấy danh sách các sách trong thư viện -----------------------------------
    public void LayDSAdmin_Book_vecter(Vector vdata)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from sys.view_inSACH";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String ms=rs.getString("maSach");
                String tens=rs.getString("tenSach");
                String mtg=rs.getString("maTG");
                String nxb=rs.getString("namXB");
                String gs=rs.getString("giaSach");
                String sl=rs.getString("soLuong");
                
                Vector<String> v=new Vector<String>();
                v.add(ms);
                v.add(tens);
                v.add(mtg);
                v.add(nxb);
                v.add(gs);
                v.add(sl);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Admin_Book.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Thêm mới 1 sách ---------------------------------------------------------
    public void ThemSach(pojo_Admin_Book x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.addSACH(?,?,?,?,?,?)}");
            stmts.setString(1, x.getmS());
            stmts.setString(2, x.getTenS());
            stmts.setString(3, x.getmTG());
            stmts.setString(4, x.getnXB());
            stmts.setString(5, x.getGiaS());
            stmts.setString(6, x.getSoL());
            stmts.execute();

            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Book.class.getName()).log(Level.SEVERE,null, ex);
        }
    }

    // Sửa sách ----------------------------------------------------------------
    public  void  SuaSach(pojo_Admin_Book x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.suaSACH(?,?,?,?,?,?)}");
            stmts.setString(1, x.getmS());
            stmts.setString(2, x.getTenS());
            stmts.setString(3, x.getmTG());
            stmts.setString(4, x.getnXB());
            stmts.setString(5, x.getGiaS());
            stmts.setString(6, x.getSoL());
            stmts.execute();

            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Book.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Xóa sách ----------------------------------------------------------------
    public  void  XoaSach(pojo_Admin_Book x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.xoaSACH(?)}");
            stmts.setString(1, x.getmS());
            stmts.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Book.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Tìm kiếm sách -----------------------------------------------------------
    public void timKiemAdmin_Book(Vector vdata,pojo_Admin_Book x)
    {     
        Statement state;
        vdata.removeAllElements();
        try
        {
           c.OpenConnection();
           state=c.con.createStatement();
           String sqltimkiem="select * from sys.SACH where (Masach like '%"+x.getmS()+"%') "
                   + "or (tensach like '%"+x.getmS()+"%') or (matg like '%"+x.getmS()+"%') " +
                    "or (namxb like '%"+x.getmS()+"%') or (giasach like '%"+x.getmS()+"%') "
                   + "or (soluong like '%"+x.getmS()+"%')";
           ResultSet rs=state.executeQuery(sqltimkiem);
           while(rs.next())
           {
                String ms=rs.getString("maSach");
                String tens=rs.getString("tenSach");
                String mtg=rs.getString("maTG");
                String nxb=rs.getString("namXB");
                String gs=rs.getString("giaSach");
                String sl=rs.getString("soLuong");
                
                Vector<String> v=new Vector<String>();
                v.add(ms);
                v.add(tens);
                v.add(mtg);
                v.add(nxb);
                v.add(gs);
                v.add(sl);
                vdata.add(v);
           }
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Book.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}