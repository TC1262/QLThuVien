package DAO_Admin_sys;

import doanoracle_qlthuvien.connectionOracle;
import doanoracle_qlthuvienAdmin_sys.Admin_Parameter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo_Admin_sys.pojo_Admin_Parameter;

public class DAO_Admin_Parameter {
    Admin_Parameter ap;
    connectionOracle c;
    public DAO_Admin_Parameter()
    {
        c = new connectionOracle();
    }
    
    // Lấy thông tin parameter -------------------------------------------------
    public  void LayDSAdmin_Parameter_vecter(Vector vdata)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from sys.view_inparameter";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String ad=rs.getString("num");
                String pn=rs.getString("name");
                String un=rs.getString("type");
                String vl = rs.getString("value");
                String tn=rs.getString("display_value");
                String pg=rs.getString("default_value");
                Vector<String> v=new Vector<String>();
                v.add(ad);
                v.add(pn);
                v.add(un);
                v.add(vl);
                v.add(tn);
                v.add(pg);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    // Tìm kiếm ----------------------------------------------------------------
    public void timKiem(Vector vdata,pojo_Admin_Parameter x)
    {     
        Statement state;
        vdata.removeAllElements();
        try
        {
           c.OpenConnection();
           state=c.con.createStatement();
           String sqltimkiem="select num,name,type,value,display_value,default_value "
                   + "from sys.v$parameter " +
                   "where (num like '%"+x.getNum()+"%') or "
                   + "(name like '%"+x.getNum()+"%') or " +
                   "(type like '%"+x.getNum()+"%') or "
                   + "(value like '%"+x.getNum()+"%') or " +
                   "(display_value like '%"+x.getNum()+"%') or "
                   + "(default_value like '%"+x.getNum()+"%')";
           ResultSet rs=state.executeQuery(sqltimkiem);
           while(rs.next())
           {
                String ad=rs.getString("num");
                String pn=rs.getString("name");
                String un=rs.getString("type");
                String vl = rs.getString("value");
                String tn=rs.getString("display_value");
                String pg=rs.getString("default_value");
                Vector<String> v=new Vector<String>();
                v.add(ad);
                v.add(pn);
                v.add(un);
                v.add(vl);
                v.add(tn);
                v.add(pg);
                vdata.add(v);
           }
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Parameter.class.getName()).log(Level.SEVERE,null, ex);
        }
    } 
}