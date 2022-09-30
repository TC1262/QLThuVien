package doanoracle_qlthuvienUser;

import DAO_Admin.BienCucBo;
import DAO_Admin.DynamicTime;
import doanoracle_qlthuvien.Home;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class User_Home extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public User_Home() {
        initComponents();
        
        lblDangNhap.setText(" " +BienCucBo.tenDN);
        
        this.setLocationRelativeTo(null); // Chỉnh form nằm giữa màn hình
        
        // Khởi tạo thời gian hiện tại của hệ thống
        DynamicTime t = new DynamicTime(lblTime);
        t.start();
        
        // Đăng nhập lần cuối --------------------------------------------------
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(BienCucBo.ketnoi, 
                    BienCucBo.userN, BienCucBo.passW);
            String sql = "select last_login as lastLogin from sys.dba_users where "
                    + "username = '"+BienCucBo.userN+"'";
            pst = con.prepareStatement(sql);

            rs = pst.executeQuery();

            if(rs.next())
                this.lblLastLogin.setText(" Last login: " +rs.getString("lastLogin"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnInfo = new javax.swing.JButton();
        btnChangePass = new javax.swing.JButton();
        btnBook = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnGioHang = new javax.swing.JButton();
        lblDangNhap = new javax.swing.JLabel();
        lblLock = new javax.swing.JLabel();
        lblLastLogin = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("USER - Home");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/User_Home.jpg"))); // NOI18N

        btnInfo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/customer.png"))); // NOI18N
        btnInfo.setText(" Thông tin cá nhân");
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });

        btnChangePass.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnChangePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/edit.png"))); // NOI18N
        btnChangePass.setText(" Đổi mật khẩu");
        btnChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePassActionPerformed(evt);
            }
        });

        btnBook.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/book.png"))); // NOI18N
        btnBook.setText(" Xem sách");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(255, 51, 51));
        btnExit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/exit.png"))); // NOI18N
        btnExit.setText(" Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnGioHang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnGioHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/cart.png"))); // NOI18N
        btnGioHang.setText(" Giỏ hàng");
        btnGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGioHangActionPerformed(evt);
            }
        });

        lblDangNhap.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblDangNhap.setForeground(new java.awt.Color(0, 153, 204));
        lblDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/user.png"))); // NOI18N
        lblDangNhap.setText("Đăng nhập");

        lblLock.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblLock.setForeground(new java.awt.Color(0, 0, 153));
        lblLock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/clock.png"))); // NOI18N
        lblLock.setText(" Time:");

        lblLastLogin.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblLastLogin.setForeground(new java.awt.Color(204, 0, 204));
        lblLastLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/last-login.png"))); // NOI18N

        lblTime.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTime.setForeground(new java.awt.Color(0, 0, 153));
        lblTime.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChangePass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBook)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGioHang))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLastLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInfo)
                    .addComponent(btnChangePass)
                    .addComponent(btnBook)
                    .addComponent(btnGioHang)
                    .addComponent(lblDangNhap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblLock, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(lblTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLastLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Exit button -------------------------------------------------------------
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát không?")
                                                    == JOptionPane.OK_OPTION){
            BienCucBo.userN="";
            BienCucBo.passW="";
            BienCucBo.tenDN="";
            Home h = new Home();
            h.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnExitActionPerformed

    // Information button ------------------------------------------------------
    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        User_Info ui = new User_Info();
        ui.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnInfoActionPerformed

    // Change password button --------------------------------------------------
    private void btnChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePassActionPerformed
        User_ChangePass uc = new User_ChangePass();
        uc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnChangePassActionPerformed

    // View book button --------------------------------------------------------
    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        User_Book ub = new User_Book();
        ub.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBookActionPerformed

    // Cart button -------------------------------------------------------------
    private void btnGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGioHangActionPerformed
        User_Cart uc = new User_Cart();
        uc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGioHangActionPerformed

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
            java.util.logging.Logger.getLogger(User_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnChangePass;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGioHang;
    private javax.swing.JButton btnInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblDangNhap;
    private javax.swing.JLabel lblLastLogin;
    private javax.swing.JLabel lblLock;
    private javax.swing.JLabel lblTime;
    // End of variables declaration//GEN-END:variables
}