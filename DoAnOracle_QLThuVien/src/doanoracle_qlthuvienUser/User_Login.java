package doanoracle_qlthuvienUser;

import DAO_Admin.BienCucBo;
import doanoracle_qlthuvien.Home;
import doanoracle_qlthuvien.connectionOracle;
import doanoracle_qlthuvienAdmin.Admin_Home;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import DAO_Admin.DAO_Admin_Account;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import pojo_Admin.pojo_Admin_Account;

public class User_Login extends javax.swing.JFrame {
    public static String UN = new String(); // Khai báo userName tĩnh
    
    // Lấy userName là CMND
    public String getUN (){
        return txtCMND.getText().toString();
    }

    connectionOracle c;
    
    public User_Login() {
        initComponents();
        
        this.jLabel8.setVisible(false); // Ẩn label Hide
        
        txtCMND.requestFocus();
        
        c = new connectionOracle();
        this.setLocationRelativeTo(null); // Chỉnh form nằm giữa màn hình
        
        String[] s = {"Lựa chọn kết nối", "Localhost", "Online"};
        
        cbbKetNoi.removeAllItems();
        for (String item : s) {
            cbbKetNoi.addItem(item);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        txtCMND = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbbKetNoi = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("USER - Login");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("ĐĂNG NHẬP");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/User_Login.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("CMND");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setText("Bạn không có tài khoản?");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/reset.png"))); // NOI18N
        btnReset.setText(" Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/login.png"))); // NOI18N
        btnLogin.setText(" Đăng nhập");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/back.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtCMND.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/view.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/hide.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
        });

        cbbKetNoi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbbKetNoi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbKetNoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKetNoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1001, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCMND)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbbKetNoi, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(jLabel2)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(124, 124, 124))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnReset)
                                .addGap(18, 18, 18)
                                .addComponent(btnLogin)
                                .addGap(64, 64, 64))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(cbbKetNoi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addComponent(jLabel2)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(btnLogin))
                .addGap(60, 60, 60)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Redirect to Registration form -------------------------------------------
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        User_Registration ur = new User_Registration();
        ur.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        jLabel8.setVisible(true);
        jLabel7.setVisible(false);
        txtPassword.setEchoChar((char)0);
    }//GEN-LAST:event_jLabel7MousePressed

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        jLabel7.setVisible(true);
        jLabel8.setVisible(false);
        txtPassword.setEchoChar('*');
    }//GEN-LAST:event_jLabel8MousePressed

    // Back button -------------------------------------------------------------
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Home h = new Home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    // Reset button ------------------------------------------------------------
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtCMND.setText("");
        txtPassword.setText("");
        txtCMND.requestFocus();
    }//GEN-LAST:event_btnResetActionPerformed

    // Login button ------------------------------------------------------------
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        BienCucBo.tenDN = "";
        BienCucBo.userN ="";
        BienCucBo.passW = "";
        
        UN = txtCMND.getText(); // Gán UN là CMND
        
        String msg = "" + txtCMND.getText();
                msg += " \n";
              
        // Nếu username là 'sys'
        if(txtCMND.getText().equals("sys"))
        {
            BienCucBo.userN =txtCMND.getText() + " as sysdba";
            BienCucBo.passW =txtPassword.getText();
            BienCucBo.tenDN = "Xin chào, "+txtCMND.getText(); 
            try {               
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection(BienCucBo.ketnoi, 
                        BienCucBo.userN, BienCucBo.passW);
                String sql = "select * from sys.ACCOUNT_USER where CMND='"+txtCMND.getText()+"' "
                        + "and pass='"+txtPassword.getText()+"'";
                
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Welcome, " +msg+ 
                            "Bạn đã đăng nhập thành công!");
                    User_Home ah = new User_Home();
                    ah.setVisible(true);
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Sai mật khẩu hoặc CMND!");
                    BienCucBo.tenDN = "";
                    BienCucBo.userN ="";
                    BienCucBo.passW = "";
                    txtCMND.requestFocus();
                }
            } catch (Exception e) {
                BienCucBo.tenDN = "";
                BienCucBo.userN ="";
                BienCucBo.passW = "";
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else // Không là user 'sys'
        {
            BienCucBo.userN =txtCMND.getText();
            BienCucBo.passW =txtPassword.getText();
            BienCucBo.tenDN = "Xin chào, "+txtCMND.getText();
            try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(BienCucBo.ketnoi, 
                    BienCucBo.userN, BienCucBo.passW);
            String sql = "select * from sys.ACCOUNT_USER where "
                    + "CMND='"+txtCMND.getText()+"' and pass='"+txtPassword.getText()+"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
                
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Welcome, " +msg+ 
                        "Bạn đã đăng nhập thành công!");                             
                User_Home ah = new User_Home();
                ah.setVisible(true);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Sai mật khẩu hoặc CMND!");
                BienCucBo.tenDN = "";
                BienCucBo.userN ="";
                BienCucBo.passW = "";
                txtCMND.requestFocus();
            }
            } catch (Exception e) {
                BienCucBo.tenDN = "";
                BienCucBo.userN ="";
                BienCucBo.passW = "";
                JOptionPane.showMessageDialog(null, "Sai CMND hoặc mật khẩu!");
                e.printStackTrace();
            }
        }      
    }//GEN-LAST:event_btnLoginActionPerformed

    private void cbbKetNoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKetNoiActionPerformed
        if(cbbKetNoi.getSelectedItem()=="Localhost")
        {
            BienCucBo.ketnoi = "jdbc:oracle:thin:@localhost:1521:ThuVien";
        }
        if(cbbKetNoi.getSelectedItem()=="Online")
        {
            BienCucBo.ketnoi = "jdbc:oracle:thin:@tonan01.ddns.net:1521:QLThuVien";
        }
    }//GEN-LAST:event_cbbKetNoiActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(User_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox cbbKetNoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
