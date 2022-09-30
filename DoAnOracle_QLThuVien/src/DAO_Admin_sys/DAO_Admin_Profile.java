package DAO_Admin_sys;

import doanoracle_qlthuvien.connectionOracle;
import doanoracle_qlthuvienAdmin_sys.Admin_Profile;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo_Admin_sys.pojo_Admin_Profile;
import pojo_Admin_sys.pojo_Admin_TaoUser;

public class DAO_Admin_Profile {
    Admin_Profile ap;
    connectionOracle c;
    
    public DAO_Admin_Profile()
    {
        c = new connectionOracle();
    }
    
    // Lấy danh sách thông tin profile -----------------------------------------
    public  void LayDSAdmin_Profile_vecter(Vector vdata)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from sys.view_inprofiles";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String us=rs.getString("profile");
                String id=rs.getString("resource_name");
                String acst=rs.getString("resource_type");
                String ld=rs.getString("limit");
                String ed=rs.getString("common");
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
            Logger.getLogger(DAO_Admin_Profile.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Tìm kiếm ----------------------------------------------------------------
    public void timKiem(Vector vdata,pojo_Admin_Profile x)
    {     
        Statement state;
        vdata.removeAllElements();
        try
        {
           c.OpenConnection();
           state=c.con.createStatement();
           String sqltimkiem="select * from sys.dba_profiles where "
                   + "(profile like '%"+x.getProfile()+"%') or " +
                   "(resource_name like '%"+x.getProfile()+"%') or "
                   + "(resource_type like '%"+x.getProfile()+"%') or " +
                   "(limit like '%"+x.getProfile()+"%') or "
                   + "(common like '%"+x.getProfile()+"%')  ";
           ResultSet rs=state.executeQuery(sqltimkiem);
           while(rs.next())
           {
                String us=rs.getString("profile");
                String id=rs.getString("resource_name");
                String acst=rs.getString("resource_type");
                String ld=rs.getString("limit");
                String ed=rs.getString("common");
                Vector<String> v=new Vector<String>();
                v.add(us);
                v.add(id);
                v.add(acst);
                v.add(ld);
                v.add(ed);
                vdata.add(v);
           }
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Profile.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Thêm --------------------------------------------------------------------
    public void ThemProfile(pojo_Admin_Profile x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stm=c.con.prepareCall("{call sys.tao_profile(?,?,?,?,?)}");
            stm.setString(1,x.getProfile());
            stm.setString(2,x.getResource_name());
            stm.setString(3,x.getResource_type());
            stm.setString(4,x.getLimit());
            stm.setString(5,x.getCommon());
            stm.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Profile.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Sửa ---------------------------------------------------------------------
    public void SuaProfile(pojo_Admin_Profile x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stm=c.con.prepareCall("{call sys.sua_profile(?,?,?,?,?)}");
            stm.setString(1,x.getProfile().toUpperCase());
            stm.setString(2,x.getResource_name());
            stm.setString(3,x.getResource_type());
            stm.setString(4,x.getLimit());
            stm.setString(5,x.getCommon());
            stm.execute();
            stm.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Profile.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Xóa ---------------------------------------------------------------------
    public  void  XoaProfile(pojo_Admin_Profile x)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts = c.con.prepareCall("{call sys.xoa_profile(?)}");
            stmts.setString(1, x.getProfile().toUpperCase());
            stmts.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Profile.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}