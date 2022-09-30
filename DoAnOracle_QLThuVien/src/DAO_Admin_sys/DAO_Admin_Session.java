package DAO_Admin_sys;

import doanoracle_qlthuvien.connectionOracle;
import doanoracle_qlthuvienAdmin_sys.Admin_Process;
import doanoracle_qlthuvienAdmin.Admin_Staff;
import doanoracle_qlthuvienAdmin_sys.Admin_Session;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo_Admin_sys.pojo_Admin_Process;
import pojo_Admin_sys.pojo_Admin_Session;

public class DAO_Admin_Session {
    Admin_Session em;
    connectionOracle c;
    public DAO_Admin_Session()
    {
        c=new connectionOracle();
    }
    
    // Lấy thông tin session ---------------------------------------------------
    public  void LayDSAdmin_Session_vecter(Vector vdata)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from sys.view_insession";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String sd=rs.getString("sid");
                String ser=rs.getString("serial#");
                String us=rs.getString("username");
                String pg=rs.getString("program");
                String tr=rs.getString("terminal");
                String trfile=rs.getString("tracefile");
                
                Vector<String> v=new Vector<String>();
                v.add(sd);
                v.add(ser);
                v.add(us);
                v.add(pg);
                v.add(tr);
                v.add(trfile);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Admin_Session.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Kill session ------------------------------------------------------------
    public  void  KillSession(pojo_Admin_Session x,pojo_Admin_Session y)
    {
        try {
            c.OpenConnection();
            Statement st = c.con.createStatement();
            CallableStatement stmts=c.con.prepareCall("{call sys.cnkillsession(?,?)}");
            stmts.setString(1,x.getSid());
            stmts.setString(2,y.getSerial());
            stmts.execute();
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Session.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Tìm kiếm ----------------------------------------------------------------
    public void timKiem(Vector vdata,pojo_Admin_Session x)
    {     
        Statement state;
        vdata.removeAllElements();
        try
        {
           c.OpenConnection();
           state=c.con.createStatement();
           String sqltimkiem="select s.sid,s.serial#,s.username,s.program,p.terminal,p.tracefile " +
                   "from sys.v$session s,v$process p where "
                   + "(s.paddr=p.addr and s.type !='BACKGROUND') and "
                   + "((s.sid like '%"+x.getSid()+"%') or " +
                   "(s.serial# like '%"+x.getSid()+"%') or "
                   + "(s.username like '%"+x.getSid()+"%') or " +
                   "(s.program like '%"+x.getSid()+"%') or "
                   + "(p.terminal like '%"+x.getSid()+"%') or " +
                   "(p.tracefile  like '%"+x.getSid()+"%'))";
            ResultSet rs=state.executeQuery(sqltimkiem);
            while(rs.next())
            {
                String sd=rs.getString("sid");
                String ser=rs.getString("serial#");
                String us=rs.getString("username");
                String pg=rs.getString("program");
                String tr=rs.getString("terminal");
                String trfile=rs.getString("tracefile");
                Vector<String> v=new Vector<String>();
                v.add(sd);
                v.add(ser);
                v.add(us);
                v.add(pg);
                v.add(tr);
                v.add(trfile);
                vdata.add(v);
           }
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_Admin_Session.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}