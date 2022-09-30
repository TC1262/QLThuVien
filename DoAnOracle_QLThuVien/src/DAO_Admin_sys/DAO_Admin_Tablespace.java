package DAO_Admin_sys;

import DAO_Admin.DAO_Admin_Book;
import doanoracle_qlthuvien.connectionOracle;
import doanoracle_qlthuvienAdmin_sys.Admin_Tablespace;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo_Admin.pojo_Admin_Book;
import pojo_Admin_sys.pojo_Admin_Tablespace;

public class DAO_Admin_Tablespace {
    Admin_Tablespace em;
    connectionOracle c;
    
    public DAO_Admin_Tablespace()
    {
        c = new connectionOracle();
    }
    
    // Lấy thông tin tablespace ------------------------------------------------
    public  void load(Vector vdata)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select dba_tablespaces.tablespace_name, file_name, "
                    + "logging, online_status "
                    + "from sys.dba_tablespaces, dba_data_files "
                    + "where dba_tablespaces.tablespace_name = dba_data_files.tablespace_name";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String us=rs.getString("tablespace_name");
                String p=rs.getString("file_name");
                String tsp=rs.getString("logging");
                String pf=rs.getString("online_status");
                Vector<String> v=new Vector<String>();
                v.add(us);
                v.add(p);
                v.add(tsp);
                v.add(pf);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Admin_TaoUser.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Thêm --------------------------------------------------------------------
    public void Themtablespace(pojo_Admin_Tablespace x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.tao_tablespace(?,?,?,?,?)}");
            stmts.setString(1, x.getTablespace_name());
            stmts.setString(2, x.getFile_name());
            stmts.setString(3, x.getSize());
            stmts.setString(4, x.getTudongtang());
            stmts.setString(5, x.getMaxsize());
            stmts.execute();

            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Tablespace.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Sửa ---------------------------------------------------------------------
    public void suatablespace(pojo_Admin_Tablespace x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.sua_tablespace(?,?,?,?,?)}");
            stmts.setString(1, x.getTablespace_name());
            stmts.setString(2, x.getFile_name());
            stmts.setString(3, x.getSize());
            stmts.setString(4, x.getTudongtang());
            stmts.setString(5, x.getMaxsize());
            stmts.execute();

            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Tablespace.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Xóa ---------------------------------------------------------------------
    public void xoatablespace(pojo_Admin_Tablespace x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.xoa_tablespace(?)}");
            stmts.setString(1, x.getTablespace_name());
            stmts.execute();

            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Tablespace.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}