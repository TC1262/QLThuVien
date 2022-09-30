package DAO_Admin_sys;

import doanoracle_qlthuvien.connectionOracle;
import doanoracle_qlthuvienAdmin_sys.Admin_ObjPermission;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo_Admin_sys.pojo_Admin_ObjPermission;

public class DAO_Admin_ObjPermission {
    Admin_ObjPermission ao;
    connectionOracle c;
    public DAO_Admin_ObjPermission()
    {
        c = new connectionOracle();
    }
    
    // Lấy thông tin về quyền đối tượng ----------------------------------------
    public  void LayDSAdmin_ObjPermission_vecter(Vector vdata)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from sys.view_inprivs";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String sd=rs.getString("grantee");
                String ser=rs.getString("owner");
                String us=rs.getString("table_name");
                String pg=rs.getString("grantor");
                String privi=rs.getString("privilege");
                String prantable=rs.getString("grantable");
                String type=rs.getString("type");
                
                Vector<String> v=new Vector<String>();
                v.add(sd);
                v.add(ser);
                v.add(us);
                v.add(pg);
                v.add(privi);
                v.add(prantable);
                v.add(type);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    // Tìm kiếm ----------------------------------------------------------------
    public void timKiem(Vector vdata,pojo_Admin_ObjPermission x)
    {     
        Statement state;
        vdata.removeAllElements();
        try
        {
           c.OpenConnection();
           state=c.con.createStatement();
           String sqltimkiem="SELECT grantee, owner, table_name, grantor, privilege, "
                   + "grantable, type FROM sys.dba_tab_privs " +
                   "where (grantee like '%"+x.getGrantee()+"%') or "
                   + "(owner like '%"+x.getGrantee()+"%') or " +
                   "(table_name like '%"+x.getGrantee()+"%') or "
                   + "(grantor like '%"+x.getGrantee()+"%') or " +
                   "(privilege like '%"+x.getGrantee()+"%') or "
                   + "(grantable like '%"+x.getGrantee()+"%') or " +
                   "(type like '%"+x.getGrantee()+"%') ";
           ResultSet rs=state.executeQuery(sqltimkiem);
           while(rs.next())
           {
                String sd=rs.getString("grantee");
                String ser=rs.getString("owner");
                String us=rs.getString("table_name");
                String pg=rs.getString("grantor");
                String privi=rs.getString("privilege");
                String prantable=rs.getString("grantable");
                String type=rs.getString("type");
                
                Vector<String> v=new Vector<String>();
                v.add(sd);
                v.add(ser);
                v.add(us);
                v.add(pg);
                v.add(privi);
                v.add(prantable);
                v.add(type);
                vdata.add(v);
           }
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_ObjPermission.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}