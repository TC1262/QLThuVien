package doanoracle_qlthuvienAdmin;

import DAO_Admin.BienCucBo;
import DAO_Admin.DAO_Admin_Account;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import pojo_Admin.pojo_Admin_Account;

public class Admin_Account extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    DefaultTableModel model;
    
    Vector vheader = new Vector();
    Vector vdata = new Vector();
    
    DAO_Admin_Account dao;
    
    public Admin_Account() {
        initComponents();
        
        this.setLocationRelativeTo(null); // Chỉnh form nằm giữa màn hình
        
        dao = new DAO_Admin_Account();
        
        // Load dữ liệu lên table ----------------------------------------------
        vheader.add("CMND");
        vheader.add("Pass");
        dao.LayDSAdmin_Account_vecter(vdata);
        jTableAccount.setModel(new DefaultTableModel(vdata,vheader));

    }
    
    // Kiểm tra rỗng -----------------------------------------------------------
    public boolean ktrong()
    {
        if(txtCMND.getText().length() == 0) //rong
        {
            JOptionPane.showMessageDialog(null, "CMND không được để trống");
            return  false;
        }
        if(txtMatKhau.getText().length()==0)//rong
        {
            JOptionPane.showMessageDialog(null, "Pass không được để trống");
            return  false;
        }
        return  true;
    }
    
    // kiem tra trùng khoa chinh -----------------------------------------------
    public  boolean kttrung()
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(BienCucBo.ketnoi, BienCucBo.userN, BienCucBo.passW);
            String sql = "select count(*) as sl from sys.ACCOUNT_USER where CMND='"+txtCMND.getText()+"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next())
            {
                if(Integer.parseInt(rs.getString("sl")) == 1)
                {
                    return true; // Trùng
                }
                else
                { 
                    return false; // Không trùng
                }
            }         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return  false;
    }
    
    // kiem tra trung khoa ngoai -----------------------------------------------
    public  boolean ktkhoaNgoai()
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(BienCucBo.ketnoi, BienCucBo.userN, BienCucBo.passW);
            String sql = "select count(*) as soluong from sys.Khach where CMND='"+txtCMND.getText()+"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next())
            {
                if(Integer.parseInt(rs.getString("soluong")) == 1)
                {
                    return true; //ton tai khoa ngoai
                }
                else
                { 
                    return false; //khong ton tai khoa ngoai
                } 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return  false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAccount = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        txtMatKhau = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMINISTRATOR - Account");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("TÀI KHOẢN KHÁCH HÀNG");

        jTableAccount.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAccountMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAccount);

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setText("Thông tin chi tiết");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("CMND");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Mật khẩu");

        txtCMND.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/add.png"))); // NOI18N
        btnAdd.setText(" Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/delete.png"))); // NOI18N
        btnDelete.setText(" Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/edit.png"))); // NOI18N
        btnEdit.setText(" Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/back.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/find.png"))); // NOI18N
        jLabel11.setText("Nhập thông tin tài khoản khách cần tìm:");

        txtFind.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFindKeyPressed(evt);
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
                        .addComponent(btnBack)
                        .addGap(209, 209, 209)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCMND)
                                    .addComponent(txtMatKhau)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete)
                                .addGap(18, 18, 18)
                                .addComponent(btnEdit))
                            .addComponent(jLabel11)
                            .addComponent(txtFind))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1)
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnDelete)
                            .addComponent(btnEdit)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Back button -------------------------------------------------------------
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Admin_Home ah = new Admin_Home();
        ah.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    // Add button --------------------------------------------------------------
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Nếu đễ rỗng -> không thực thi
        if(ktrong()==false)
        {
            return;
        }
        
        if (BienCucBo.ktthem())
        {
            if(kttrung() == true) // Trùng CMND -> không thêm
            {
                JOptionPane.showMessageDialog(null, "CMND bạn nhập đã tồn tại!");
                return;
            }
            else // khong trung -> Tiến hành thêm mới 1 tài khoản
            {
                pojo_Admin_Account x=new pojo_Admin_Account(txtCMND.getText(), txtMatKhau.getText());
                dao.ThemAdmin_Account(x);
                dao.LayDSAdmin_Account_vecter(vdata);
                jTableAccount.updateUI();
                
                if(kttrung()==true) // Kiểm tra lại nếu CMND đã được thêm
                {
                    JOptionPane.showMessageDialog(null, "Thành công");
                    return;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Thất Bại");
                    return;
                }
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    // Edit button -------------------------------------------------------------
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // Nếu để trống -> không thực thi
        if(ktrong()==false) //rỗng
        {
            return;
        }
        
        if (BienCucBo.ktsua() == true) // đồng ý thực thi câu lệnh
        {
            if(kttrung() == false) // không tồn tại khóa chính (không trùng)
            {
                JOptionPane.showMessageDialog(null, "CMND không tồn tại");
                return;
            }
            else // trung
            {
                pojo_Admin_Account x=new pojo_Admin_Account(txtCMND.getText(), txtMatKhau.getText());
                dao.SuaAdmin_Account(x);
                dao.LayDSAdmin_Account_vecter(vdata);
                jTableAccount.updateUI();
             
                if(kttrung()==true)// KTra lại, nếu trùng
                   {
                       JOptionPane.showMessageDialog(null, "Thành công");
                       return;
                   }
                   else
                   {
                       JOptionPane.showMessageDialog(null, "Thất Bại");
                       return;
                   }
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    // Delete button -----------------------------------------------------------
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // CMND không được để trống
        if(txtCMND.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "CMND không được để trống");
            return;
        }
        
        if (BienCucBo.ktxoa()) // Đồng ý thực thi câu lệnh
        {
            if(ktkhoaNgoai()==true) // co khoa ngoai thì không xóa được
            {
                JOptionPane.showMessageDialog(null, "CMND này đang tồn tại ở Khách Hàng"
                        + "\n Không thể xóa!");
                return;
            }
            if(kttrung()==false) // không tồn tại khóa chính
            {
                JOptionPane.showMessageDialog(null, "CMND không tồn tại");
                return;
            }
            else // có khóa chính
            {
                pojo_Admin_Account x=new pojo_Admin_Account();
                x.setcM(txtCMND.getText());
                dao.XoaKAdmin_Account(x);
                dao.LayDSAdmin_Account_vecter(vdata);
                jTableAccount.updateUI(); // thuc thi update len table
            
                if(kttrung()==false) // Không tồn tại (Đã được xóa)
                    {
                        JOptionPane.showMessageDialog(null, "Thành công");
                        return;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Thất Bại");
                        return;
                    }
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jTableAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAccountMouseClicked
        int index=jTableAccount.getSelectedRow();
        Vector v=(Vector)vdata.get(index);
        txtCMND.setText(((String)v.get(0)).replace(" ", ""));
        txtMatKhau.setText((String)v.get(1));

    }//GEN-LAST:event_jTableAccountMouseClicked

    private void txtFindKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            pojo_Admin_Account x=new pojo_Admin_Account(txtFind.getText(), "");
            dao.timKiemAdmin_Account(vdata, x);
            jTableAccount.updateUI();
        }
    }//GEN-LAST:event_txtFindKeyPressed

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
            java.util.logging.Logger.getLogger(Admin_Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Account().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAccount;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtFind;
    private javax.swing.JPasswordField txtMatKhau;
    // End of variables declaration//GEN-END:variables
}
