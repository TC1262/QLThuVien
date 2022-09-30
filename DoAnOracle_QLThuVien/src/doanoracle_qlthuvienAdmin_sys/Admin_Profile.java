package doanoracle_qlthuvienAdmin_sys;

import DAO_Admin.BienCucBo;
import DAO_Admin_sys.DAO_Admin_Profile;
import doanoracle_qlthuvienAdmin.Admin_Home;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pojo_Admin_sys.pojo_Admin_Process;
import pojo_Admin_sys.pojo_Admin_Profile;

public class Admin_Profile extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    Vector vheader=new Vector();
    Vector vdata=new Vector();
    
    DAO_Admin_Profile dao;
    
    public Admin_Profile() {
        initComponents();
        
        this.setLocationRelativeTo(null); // Chỉnh form nằm giữa màn hình
        
        dao = new DAO_Admin_Profile();
        vheader.add("Role");
        vheader.add("Password Required");
        vheader.add("Loại xác thực");
        vheader.add("Common");
        vheader.add("Oracle Maintained");
        dao.LayDSAdmin_Profile_vecter(vdata);
        jTable1.setModel(new DefaultTableModel(vdata,vheader));
    }

    // kiem tra rỗng -----------------------------------------------------------
    public boolean ktrong()
    {
        if(txtProfileName.getText().length()==0)//rong
        {
            JOptionPane.showMessageDialog(null, "Profile Name không được để trống");
            return  false;
        }
        return  true;
    }
    
    //kiem tra trung khoa chinh ------------------------------------------------
    public  boolean kttrung()
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(BienCucBo.ketnoi, 
                    BienCucBo.userN, BienCucBo.passW);
            String sql = "select sys.ktpkprofile('"+txtProfileName.getText().toUpperCase()+"') "
                    + "as soluong from dual";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                if(Integer.parseInt(rs.getString("soluong"))>0)
                {
                    return true;//tồn tại khóa chính
                }
                else
                { return false;}//không tồn tại khóa chính
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return  false;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtPASSWORD_REUSE_MAX_Day = new javax.swing.JTextField();
        txtFailed_login_attempts_Lan = new javax.swing.JTextField();
        txtFind = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        txtPASSWORD_LOCK_TIME_Day = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPassword_life_time_Day = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtProfileName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMINISTRATOR - Profile");

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/back.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("THÔNG TIN PROFILE");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        txtPASSWORD_REUSE_MAX_Day.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtFailed_login_attempts_Lan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtFind.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFindKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/find.png"))); // NOI18N
        jLabel9.setText("Nhập thông tin profile cần tìm:");

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/delete.png"))); // NOI18N
        btnXoa.setText(" Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/edit.png"))); // NOI18N
        btnSua.setText(" Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnCreate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/add.png"))); // NOI18N
        btnCreate.setText(" Thêm");
        btnCreate.setActionCommand(" Tạo");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        txtPASSWORD_LOCK_TIME_Day.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Thời gian sử dụng");

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 17)); // NOI18N
        jLabel8.setText("Tạo profile mới");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Số lần đổi password");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Sai password tối đa");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Thời gian khóa tài khoản");

        txtPassword_life_time_Day.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Tên profile");

        txtProfileName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtProfileName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProfileNameActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Ngày");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Lần");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Lần");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Ngày");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFind)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtPassword_life_time_Day, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtPASSWORD_REUSE_MAX_Day, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(txtFailed_login_attempts_Lan, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(txtPASSWORD_LOCK_TIME_Day, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel10)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jLabel12))
                                                .addGap(5, 5, 5))
                                            .addComponent(txtProfileName)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCreate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSua)
                                .addGap(55, 55, 55))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(435, 435, 435)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(7, 7, 7)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel8)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProfileName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPassword_life_time_Day, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPASSWORD_REUSE_MAX_Day, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFailed_login_attempts_Lan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPASSWORD_LOCK_TIME_Day, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreate)
                            .addComponent(btnXoa)
                            .addComponent(btnSua))
                        .addGap(42, 42, 42))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Admin_Home ah = new Admin_Home();
        ah.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    // Xóa profile -------------------------------------------------------------
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        Connection con = null;
        CallableStatement callableStmt = null;
        
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?") 
                == JOptionPane.OK_OPTION){
            try {
                con = DriverManager.getConnection(BienCucBo.ketnoi, 
                        BienCucBo.userN ,BienCucBo.passW);
                String command = "{call sys.xoa_profile(?)}";

                callableStmt =  con.prepareCall(command);

                callableStmt.setString(1, txtProfileName.getText());

                // execute database Stored procedure
                callableStmt.executeUpdate();

                if(callableStmt == null){
                    JOptionPane.showMessageDialog(null, "Không thể xóa Profile!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Bạn đã xóa Profile thành công!");
                    dao.LayDSAdmin_Profile_vecter(vdata);
                    jTable1.updateUI();
                }

            }catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    // Sửa profile -------------------------------------------------------------
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
         Connection con = null;
        CallableStatement callableStmt = null;
        
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không?") 
                == JOptionPane.OK_OPTION){
            try {
                con = DriverManager.getConnection(BienCucBo.ketnoi, 
                        BienCucBo.userN ,BienCucBo.passW);
                String command = "{call sys.sua_profile(?,?,?,?,?)}";

                callableStmt =  con.prepareCall(command);

                callableStmt.setString(1, txtProfileName.getText());
                callableStmt.setString(2, txtPassword_life_time_Day.getText());
                callableStmt.setString(3, txtFailed_login_attempts_Lan.getText());
                callableStmt.setString(4, txtPASSWORD_LOCK_TIME_Day.getText());
                callableStmt.setString(5, txtPASSWORD_REUSE_MAX_Day.getText());

                // execute database Stored procedure
                callableStmt.executeUpdate();

                if(callableStmt == null){
                    JOptionPane.showMessageDialog(null, "Không thể sửa Profile!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Bạn đã sửa Profile thành công!");
                    dao.LayDSAdmin_Profile_vecter(vdata);
                    jTable1.updateUI();
                }

            }catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    // Thêm mới profile --------------------------------------------------------
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        Connection con = null;
        CallableStatement callableStmt = null;
        
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không?") 
                == JOptionPane.OK_OPTION){
            try {
                con = DriverManager.getConnection(BienCucBo.ketnoi, 
                        BienCucBo.userN ,BienCucBo.passW);
                String command = "{call sys.tao_profile(?,?,?,?,?)}";

                callableStmt =  con.prepareCall(command);

                callableStmt.setString(1, txtProfileName.getText());
                callableStmt.setString(2, txtPassword_life_time_Day.getText());
                callableStmt.setString(3, txtFailed_login_attempts_Lan.getText());
                callableStmt.setString(4, txtPASSWORD_LOCK_TIME_Day.getText());
                callableStmt.setString(5, txtPASSWORD_REUSE_MAX_Day.getText());

                // execute database Stored procedure
                callableStmt.executeUpdate();

                if(callableStmt == null){
                    JOptionPane.showMessageDialog(null, "Không thể thêm Profile!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Bạn đã tạo Profile thành công!");
                    dao.LayDSAdmin_Profile_vecter(vdata);
                    jTable1.updateUI();
                }

            }catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void txtFindKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            pojo_Admin_Profile x=new pojo_Admin_Profile(txtFind.getText().toUpperCase(),
                    txtPASSWORD_REUSE_MAX_Day.getText(),txtFailed_login_attempts_Lan.getText(),"");
            dao.timKiem(vdata, x);
            jTable1.updateUI();
        }
    }//GEN-LAST:event_txtFindKeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        Vector v = (Vector)vdata.get(index);
        txtProfileName.setText(((String)v.get(0)));
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtProfileNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProfileNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProfileNameActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtFailed_login_attempts_Lan;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtPASSWORD_LOCK_TIME_Day;
    private javax.swing.JTextField txtPASSWORD_REUSE_MAX_Day;
    private javax.swing.JTextField txtPassword_life_time_Day;
    private javax.swing.JTextField txtProfileName;
    // End of variables declaration//GEN-END:variables
}