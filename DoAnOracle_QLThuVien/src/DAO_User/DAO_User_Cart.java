package DAO_User;

import doanoracle_qlthuvien.connectionOracle;
import doanoracle_qlthuvienUser.User_Cart;
import static doanoracle_qlthuvienUser.User_Login.UN;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_User_Cart {
    User_Cart uc;
    connectionOracle c;
    
    public DAO_User_Cart()
    {
        c=new connectionOracle();
    }
    
    // Lấy danh sách khách hàng ------------------------------------------------
    public void loadData(Vector vdata)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from sys.GIOHANG where CMND = '"+UN+"' ";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String cm=rs.getString("maHD");
                String ten=rs.getString("maSach");
                String ngaySinh=rs.getString("CMND");
                String gioit=rs.getString("giaSach");
                String tendc=rs.getString("soLuong");
                Vector<String> v=new Vector<String>();
                v.add(cm);
                v.add(ten);
                v.add(ngaySinh);
                v.add(gioit);
                v.add(tendc);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_User_Info.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}