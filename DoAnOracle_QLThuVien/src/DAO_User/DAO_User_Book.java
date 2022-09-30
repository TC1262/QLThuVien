package DAO_User;

import DAO_Admin.DAO_Admin_Book;
import doanoracle_qlthuvien.connectionOracle;
import doanoracle_qlthuvienUser.User_Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo_User.pojo_User_Book;
import pojo_User.pojo_User_Cart;

public class DAO_User_Book {
    User_Book em;
    connectionOracle c;
    
    public DAO_User_Book()
    {
        c=new connectionOracle();
    }
    
    // Lấy danh sách các sách trong thư viện -----------------------------------
    public  void LayDSUser_Book_vecter(Vector vdata)
    {
        Statement stmt;
        vdata.removeAllElements();
        try {
            c.OpenConnection();
            stmt=c.con.createStatement();
            String sql ="select * from sys.SACH";
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
            Logger.getLogger(DAO_User_Book.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    // Tìm kiếm sách -----------------------------------------------------------
    public void timKiemAdmin_Book(Vector vdata,pojo_User_Book x)
    {     
        Statement state;
        vdata.removeAllElements();
        try
        {
           c.OpenConnection();
           state=c.con.createStatement();
           String sqltimkiem="select * from sys.SACH where (Masach like '%"+x.getmS()+"%') or (tensach like '%"+x.getmS()+"%') or (matg like '%"+x.getmS()+"%') " +
            "or (namxb like '%"+x.getmS()+"%') or (giasach like '%"+x.getmS()+"%') or (soluong like '%"+x.getmS()+"%')";
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