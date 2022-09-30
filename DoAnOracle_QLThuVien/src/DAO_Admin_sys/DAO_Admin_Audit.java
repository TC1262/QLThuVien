package DAO_Admin_sys;

import doanoracle_qlthuvien.connectionOracle;
import doanoracle_qlthuvienAdmin_sys.Admin_Audit;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo_Admin_sys.pojo_Admin_Audit;
import pojo_Admin_sys.pojo_Admin_TaoUser;

public class DAO_Admin_Audit {
    Admin_Audit em;
    connectionOracle c;
    
    public DAO_Admin_Audit()
    {
        c=new connectionOracle();
    }
    
    // Lấy thông tin database --------------------------------------------------
    public  void loadData(Vector vdata)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from sys.xempolicy";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String n=rs.getString("object_schema");
                String c=rs.getString("object_name");
                String l=rs.getString("policy_owner");
                String ctr=rs.getString("policy_name");
                String om=rs.getString("enabled");
                String sp=rs.getString("sel");
                String in=rs.getString("ins");
                String up=rs.getString("upd");
                String de=rs.getString("del");
                Vector<String> v=new Vector<String>();
                v.add(n);
                v.add(c);
                v.add(l);
                v.add(ctr);
                v.add(om);
                v.add(sp);
                v.add(in);
                v.add(up);
                v.add(de);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Admin_Audit.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Thêm --------------------------------------------------------------------
    public void Thempolicy(pojo_Admin_Audit x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stm=c.con.prepareCall("{call sys.taopolicy(?,?,?,?)}");
            stm.setString(1,x.getObject_schema());
            stm.setString(2,x.getObject_name());
            stm.setString(3,x.getPolicy_name());
            stm.setString(4,x.getSel());
            stm.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Audit.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Xóa ---------------------------------------------------------------------
    public  void  Xoapolicy(pojo_Admin_Audit x,pojo_Admin_Audit y,pojo_Admin_Audit z)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.xoapolicy(?,?,?)}");
            stmts.setString(1,x.getObject_schema());
            stmts.setString(2,y.getObject_name());
            stmts.setString(3,z.getPolicy_name());
            stmts.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Audit.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // bật --------------------------------------------------------------------
    public  void  Batpolicy(pojo_Admin_Audit x,pojo_Admin_Audit y,pojo_Admin_Audit z)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.batpolicy(?,?,?)}");
            stmts.setString(1,x.getObject_schema());
            stmts.setString(2,y.getObject_name());
            stmts.setString(3,z.getPolicy_name());
            stmts.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Audit.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // tắt --------------------------------------------------------------------
    public  void  Tatpolicy(pojo_Admin_Audit x,pojo_Admin_Audit y,pojo_Admin_Audit z)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.tatpolicy(?,?,?)}");
            stmts.setString(1,x.getObject_schema());
            stmts.setString(2,y.getObject_name());
            stmts.setString(3,z.getPolicy_name());
            stmts.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Audit.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}