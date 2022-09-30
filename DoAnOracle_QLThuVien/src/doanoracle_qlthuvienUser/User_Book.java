package doanoracle_qlthuvienUser;

import DAO_Admin.BienCucBo;
import DAO_Admin.DAO_Admin_Book;
import DAO_User.DAO_User_Book;
import doanoracle_qlthuvienAdmin.Admin_Home;
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
import pojo_Admin.pojo_Admin_Book;
import pojo_User.pojo_User_Book;
import pojo_User.pojo_User_Cart;

public class User_Book extends javax.swing.JFrame {
    DefaultTableModel model;
    
    Vector vheader=new Vector();
    Vector vdata=new Vector();
    
    DAO_User_Book dao;
    DAO_Admin_Book daoAd;
    
    public User_Book() {
        initComponents();
        
        this.setLocationRelativeTo(null); // Chỉnh form nằm giữa màn hình
        
        dao=new DAO_User_Book();
        vheader.add("Mã sách");
        vheader.add("Tên sách");
        vheader.add("Mã tác giả");
        vheader.add("Năm xuất bản");
        vheader.add("Giá sách");
        vheader.add("Số lượng");
        dao.LayDSUser_Book_vecter(vdata);
        jTableuserbook.setModel(new DefaultTableModel(vdata,vheader)); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableuserbook = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        txtMaTG = new javax.swing.JTextField();
        txtNXB = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        txtSL = new javax.swing.JTextField();
        btnMuon = new javax.swing.JButton();
        btnMua = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        bthFind1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("USER - Book");

        jTableuserbook.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableuserbook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableuserbookMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableuserbook);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("WELCOME TO OUR LIBRARY");

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setText("Thông tin chi tiết:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Mã sách");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Tên sách");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Mã tác giả");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Năm xuất bản");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Giá");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Số lượng");

        txtMaSach.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtMaSach.setEnabled(false);

        txtTenSach.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTenSach.setEnabled(false);

        txtMaTG.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtMaTG.setEnabled(false);

        txtNXB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNXB.setEnabled(false);

        txtGia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtGia.setEnabled(false);

        txtSL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSL.setEnabled(false);

        btnMuon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMuon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/rent.png"))); // NOI18N
        btnMuon.setText(" Mượn");
        btnMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuonActionPerformed(evt);
            }
        });

        btnMua.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/buy-button.png"))); // NOI18N
        btnMua.setText(" Mua");

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/back.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/find.png"))); // NOI18N
        jLabel11.setText("Nhập thông tin sách cần tìm:");

        txtFind.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFindKeyReleased(evt);
            }
        });

        bthFind1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bthFind1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/find.png"))); // NOI18N
        bthFind1.setText(" Tìm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(1220, Short.MAX_VALUE)
                .addComponent(btnMuon)
                .addGap(18, 18, 18)
                .addComponent(btnMua)
                .addGap(88, 88, 88))
            .addGroup(layout.createSequentialGroup()
                .addGap(1107, 1107, 1107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bthFind1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1078, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5))
                                        .addGap(62, 62, 62))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaTG, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                                    .addComponent(txtTenSach)
                                    .addComponent(txtMaSach)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSL, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                                    .addComponent(txtGia)
                                    .addComponent(txtNXB))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(556, 556, 556))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bthFind1))
                        .addGap(74, 74, 74)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtMaTG, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMuon)
                            .addComponent(btnMua)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Back button -------------------------------------------------------------
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        User_Home uh = new User_Home();
        uh.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void jTableuserbookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableuserbookMouseClicked
        int index = jTableuserbook.getSelectedRow();
        Vector v = (Vector)vdata.get(index);
        txtMaSach.setText(((String)v.get(0)).replace(" ", ""));
        txtTenSach.setText((String)v.get(1));
        txtMaTG.setText((String)v.get(2));
        txtNXB.setText((String)v.get(3));
        txtGia.setText((String)v.get(4));
        txtSL.setText((String)v.get(5));
    }//GEN-LAST:event_jTableuserbookMouseClicked

    private void txtFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyReleased
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            pojo_User_Book x=new pojo_User_Book(txtFind.getText(),txtTenSach.getText(),
                    txtMaTG.getText(),txtNXB.getText(),txtGia.getText(), "");
            dao.timKiemAdmin_Book(vdata, x);
            jTableuserbook.updateUI();
        }
    }//GEN-LAST:event_txtFindKeyReleased

    private void btnMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuonActionPerformed
//        Connection con = null;
//        PreparedStatement pst = null;
//        ResultSet rs = null;
//        
//        try {
//                Class.forName("oracle.jdbc.driver.OracleDriver");
//                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ThuVien", BienCucBo.userN, BienCucBo.passW);
//                String sql = "insert into GIOHANG (maSach, CMND, giaSach, soLuong) "
//                    + "values ('"+txtMaSach.getText()+"', '"+BienCucBo.tenDN+"', "
//                    + "'"+txtGia.getText()+"', '"+txtSL.getText()+"')";
//                pst = con.prepareStatement(sql);
//
//                rs = pst.executeQuery();
//
//                if(rs.next()){
//                    JOptionPane.showMessageDialog(null, "Bạn đã mượn thành công!");
//
//                    User_Cart uh = new User_Cart();
//                    uh.setVisible(true);
//                    this.dispose();
//                }
//                else{
//                    JOptionPane.showMessageDialog(null, "Không thể mượn!");
//                }
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e);
//            }
    }//GEN-LAST:event_btnMuonActionPerformed

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
            java.util.logging.Logger.getLogger(User_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bthFind1;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnMua;
    private javax.swing.JButton btnMuon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableuserbook;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtMaTG;
    private javax.swing.JTextField txtNXB;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtTenSach;
    // End of variables declaration//GEN-END:variables
}