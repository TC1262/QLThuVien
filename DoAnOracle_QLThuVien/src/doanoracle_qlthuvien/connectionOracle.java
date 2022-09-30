package doanoracle_qlthuvien;

import DAO_Admin.BienCucBo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connectionOracle {
    public Connection con;
    
    public connectionOracle(){  
        try {               
            Class.forName("oracle.jdbc.driver.OracleDriver");            
        }catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        con = null;     
    }
    
    // Mở kết nối --------------------------------------------------------------
    public Connection OpenConnection(){  
        String sqlInstanceName=BienCucBo.ketnoi;
        try {
            if(con!=null && con.isClosed()==false)
                return con;
            con = DriverManager.getConnection(sqlInstanceName, BienCucBo.userN, BienCucBo.passW);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }
    
    // Đóng kết nối ------------------------------------------------------------
    public void CloseConnection(){     
        try {
            if(con!=null)
                con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}