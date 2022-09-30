package doanoracle_qlthuvienAdmin;

import doanoracle_qlthuvienAdmin_sys.Admin_RightsGroup;
import doanoracle_qlthuvienAdmin_sys.Admin_ObjPermission;
import doanoracle_qlthuvienAdmin_sys.Admin_SysPermission;
import DAO_Admin.BienCucBo;
import DAO_Admin.DynamicTime;
import doanoracle_qlthuvien.Home;
import doanoracle_qlthuvienAdmin_sys.Admin_Audit;
import doanoracle_qlthuvienAdmin_sys.Admin_Database;
import doanoracle_qlthuvienAdmin_sys.Admin_Datafile;
import doanoracle_qlthuvienAdmin_sys.Admin_Instance;
import doanoracle_qlthuvienAdmin_sys.Admin_Parameter;
import doanoracle_qlthuvienAdmin_sys.Admin_Process;
import doanoracle_qlthuvienAdmin_sys.Admin_Profile;
import doanoracle_qlthuvienAdmin_sys.Admin_Session;
import doanoracle_qlthuvienAdmin_sys.Admin_CreateUser;
import doanoracle_qlthuvienAdmin_sys.Admin_Tablespace;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Admin_Home extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public Admin_Home() {
        initComponents();
        
        this.setLocationRelativeTo(null); // Chỉnh form nằm giữa màn hình
        
        lblDangNhap.setText(" " +BienCucBo.tenDN);
        
        String[] s = {"DBA","Process","Instance","Database","Datafile","Session",
            "Parameter File","Profile","Tablespace","Audit"};
        
        String[] s2 = {"Phân quyền", "Quyền Hệ thống", "Quyền Đối tượng", 
            "Nhóm quyền","User"};
        
        cbbxemtt.removeAllItems();
        for (String item : s) {
            cbbxemtt.addItem(item);
        }
        
        cbbRightsGroup.removeAllItems();
        for (String item : s2) {
            cbbRightsGroup.addItem(item);
        }
        
        // Khởi tạo thời gian hiện tại của hệ thống ----------------------------
        DynamicTime t = new DynamicTime(lblTime);
        t.start();
        
        // Đăng nhập lần cuối --------------------------------------------------
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(BienCucBo.ketnoi, 
                    BienCucBo.userN, BienCucBo.passW);
            String sql = "select last_login as lastLogin from dba_users where "
                    + "username = '"+BienCucBo.userN.toUpperCase()+"'";
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
        jLabel3 = new javax.swing.JLabel();
        btnNhanVien = new javax.swing.JButton();
        btnSach = new javax.swing.JButton();
        btnHoaDon = new javax.swing.JButton();
        btnKhachHang = new javax.swing.JButton();
        btnTaiKhoan = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        cbbxemtt = new javax.swing.JComboBox<>();
        lblDangNhap = new javax.swing.JLabel();
        cbbRightsGroup = new javax.swing.JComboBox<>();
        lblLock = new javax.swing.JLabel();
        lblLastLogin = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        btnPhieuMuon = new javax.swing.JButton();
        btnThe1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMINISTRATOR - Home");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Admin_Home.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 51));
        jLabel3.setText("ADMINISTRATOR");

        btnNhanVien.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/staff.png"))); // NOI18N
        btnNhanVien.setText(" Nhân viên");
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });

        btnSach.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/book.png"))); // NOI18N
        btnSach.setText(" Sách");
        btnSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSachActionPerformed(evt);
            }
        });

        btnHoaDon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/bill.png"))); // NOI18N
        btnHoaDon.setText(" Hóa đơn");
        btnHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonActionPerformed(evt);
            }
        });

        btnKhachHang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/customer.png"))); // NOI18N
        btnKhachHang.setText(" Khách hàng");
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });

        btnTaiKhoan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/user.png"))); // NOI18N
        btnTaiKhoan.setText(" Tài khoản");
        btnTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiKhoanActionPerformed(evt);
            }
        });

        btnThongKe.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/data.png"))); // NOI18N
        btnThongKe.setText(" Thống Kê");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        btnThoat.setBackground(new java.awt.Color(255, 0, 51));
        btnThoat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(255, 255, 255));
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/exit.png"))); // NOI18N
        btnThoat.setText(" Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        cbbxemtt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cbbxemtt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbxemtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbxemttActionPerformed(evt);
            }
        });

        lblDangNhap.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblDangNhap.setForeground(new java.awt.Color(0, 153, 204));
        lblDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/admin.png"))); // NOI18N
        lblDangNhap.setText("Đăng nhập");

        cbbRightsGroup.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cbbRightsGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbRightsGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbRightsGroupActionPerformed(evt);
            }
        });

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

        btnPhieuMuon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPhieuMuon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/document.png"))); // NOI18N
        btnPhieuMuon.setText(" Phiếu mượn");
        btnPhieuMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhieuMuonActionPerformed(evt);
            }
        });

        btnThe1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThe1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/card.png"))); // NOI18N
        btnThe1.setText(" Thẻ");
        btnThe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThe1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnNhanVien)
                                                .addComponent(btnSach)
                                                .addComponent(btnHoaDon))
                                            .addGap(34, 34, 34))
                                        .addComponent(cbbRightsGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnPhieuMuon))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(155, 155, 155)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbbxemtt, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnTaiKhoan, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnThongKe, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnKhachHang, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(btnThe1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLastLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThoat)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnKhachHang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTaiKhoan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThongKe)
                        .addGap(8, 8, 8)
                        .addComponent(btnThe1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbxemtt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnPhieuMuon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNhanVien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHoaDon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSach)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbRightsGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(lblDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLock, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThoat)
                    .addComponent(lblLastLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleParent(jLabel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Exit button -------------------------------------------------------------
    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát không?")
                                                    == JOptionPane.OK_OPTION){
            BienCucBo.tenDN = "";
            BienCucBo.userN ="";
            BienCucBo.passW = "";
            Home h = new Home();
            h.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    // Staff button ------------------------------------------------------------
    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        Admin_Staff as = new Admin_Staff();
        as.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNhanVienActionPerformed

    // Bill button -------------------------------------------------------------
    private void btnHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonActionPerformed
        
    }//GEN-LAST:event_btnHoaDonActionPerformed

    // Book button -------------------------------------------------------------
    private void btnSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSachActionPerformed
        Admin_Book ab = new Admin_Book();
        ab.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSachActionPerformed

    // Customer button ---------------------------------------------------------
    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        Admin_Customer ac = new Admin_Customer();
        ac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKhachHangActionPerformed

    // Account button ----------------------------------------------------------
    private void btnTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiKhoanActionPerformed
        Admin_Account ac = new Admin_Account();
        ac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTaiKhoanActionPerformed

    // Statistical button ------------------------------------------------------
    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        Admin_Statistical as = new Admin_Statistical();
        as.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void cbbxemttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbxemttActionPerformed
        if(cbbxemtt.getSelectedItem()=="Process")
        {
            Admin_Process apro = new Admin_Process();
            apro.setVisible(true);
            this.dispose();
        }
        if(cbbxemtt.getSelectedItem()=="Instance")
        {
            Admin_Instance ains = new Admin_Instance();
            ains.setVisible(true);
            this.dispose();
        }
        if(cbbxemtt.getSelectedItem()=="Database")
        {
            Admin_Database adatabs = new Admin_Database();
            adatabs.setVisible(true);
            this.dispose();
        }
        if(cbbxemtt.getSelectedItem()=="Datafile")
        {
            Admin_Datafile adtfl = new Admin_Datafile();
            adtfl.setVisible(true);
            this.dispose();
        }
        if(cbbxemtt.getSelectedItem()=="Session")
        {
            Admin_Session ases = new Admin_Session();
            ases.setVisible(true);
            this.dispose();
        }
        if(cbbxemtt.getSelectedItem()=="Parameter File"){
            Admin_Parameter ap = new Admin_Parameter();
            ap.setVisible(true);
            this.dispose();
        }
        if(cbbxemtt.getSelectedItem()=="Profile"){
            Admin_Profile ap = new Admin_Profile();
            ap.setVisible(true);
            this.dispose();
        }
        if(cbbxemtt.getSelectedItem()=="Tablespace"){
            Admin_Tablespace at = new Admin_Tablespace();
            at.setVisible(true);
            this.dispose();
        }
        if(cbbxemtt.getSelectedItem()=="Audit"){
            Admin_Audit ad = new Admin_Audit();
            ad.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_cbbxemttActionPerformed

    private void cbbRightsGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbRightsGroupActionPerformed
        if(cbbRightsGroup.getSelectedItem()=="Quyền Hệ thống"){
            Admin_SysPermission ad = new Admin_SysPermission();
            ad.setVisible(true);
            this.dispose();
        }
        if(cbbRightsGroup.getSelectedItem()=="Quyền Đối tượng"){
            Admin_ObjPermission ao = new Admin_ObjPermission();
            ao.setVisible(true);
            this.dispose();
        }
        if(cbbRightsGroup.getSelectedItem()=="Nhóm quyền"){
            Admin_RightsGroup ar = new Admin_RightsGroup();
            ar.setVisible(true);
            this.dispose();
        }
        if(cbbRightsGroup.getSelectedItem()=="User"){
            Admin_CreateUser uar = new Admin_CreateUser();
            uar.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_cbbRightsGroupActionPerformed

    
    private void btnPhieuMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhieuMuonActionPerformed
        Admin_PhieuMuon ap = new Admin_PhieuMuon();
        ap.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPhieuMuonActionPerformed

    
    private void btnThe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThe1ActionPerformed
        Admin_Card ap = new Admin_Card();
        ap.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnThe1ActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHoaDon;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnPhieuMuon;
    private javax.swing.JButton btnSach;
    private javax.swing.JButton btnTaiKhoan;
    private javax.swing.JButton btnThe1;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JComboBox<String> cbbRightsGroup;
    private javax.swing.JComboBox<String> cbbxemtt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblDangNhap;
    private javax.swing.JLabel lblLastLogin;
    private javax.swing.JLabel lblLock;
    private javax.swing.JLabel lblTime;
    // End of variables declaration//GEN-END:variables
}
