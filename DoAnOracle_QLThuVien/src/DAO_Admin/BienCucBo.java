package DAO_Admin;

import javax.swing.JOptionPane;

public class BienCucBo {
    public  static  String  userN; // user name
    public  static  String  passW; // password
    public  static  String  tenDN; // tên đăng nhập
    public  static  String  ketnoi;
    
    // Thông báo khi ấn button thêm --------------------------------------------
    public  static boolean ktthem()
    {
        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm không?")
                == JOptionPane.OK_OPTION)
            return true;
        return false;
    }
    
    // Thông báo khi ấn button xóa ---------------------------------------------
    public  static boolean ktxoa()
    {
        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?")
                == JOptionPane.OK_OPTION)
            return true;
        return false;
    }
    
    // Thông báo khi ấn button sửa ---------------------------------------------
    public  static boolean ktsua()
    {
        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa không?")
                == JOptionPane.OK_OPTION)
            return true;
        return false;
    }
}