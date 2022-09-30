package DAO_User;

import doanoracle_qlthuvien.connectionOracle;
import doanoracle_qlthuvienUser.User_Info;
import doanoracle_qlthuvienUser.User_Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static doanoracle_qlthuvienUser.User_Login.UN;
import pojo_User.pojo_User_Info;

public class DAO_User_Info {
    User_Info em;
    connectionOracle c;
    
    public DAO_User_Info()
    {
        c=new connectionOracle();
    }
    
    // Lấy danh sách khách hàng ------------------------------------------------
    public void LayDSKH_vecter(Vector vdata)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from sys.KHACH where CMND = '"+UN+"' ";
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
            Logger.getLogger(DAO_User_Info.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Sửa khách hàng ----------------------------------------------------------
    public  void  SuaKhach(pojo_User_Info x)
    {
        try {
            c.OpenConnection();
            
            String cm=x.getcM();
            String ten=x.getTen();
            String tuoi=x.getngaySinh();
            String gioit=x.getGioiT();  
            String diac=x.getTenDC(); 
            String dt=x.getDienT(); 
            Statement st = c.con.createStatement();
            String sqlInsert="update sys.KHACH set Ten=N'"+ten+"',ngaySinh='"+tuoi+"',"
                    + "gioiTinh=N'"+gioit+"',tenDC=N'"+diac+"',dienThoai='"+dt+"' "
                    + "where CMND='"+cm+"'";
            int numberRowsAffected = st.executeUpdate(sqlInsert);
            c.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_User_Info.class.getName()).log(Level.SEVERE,null, ex);
        }
    }  
}