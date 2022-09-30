package doanoracle_qlthuvienAdmin;

import DAO_Admin.BienCucBo;
import DAO_Admin.DAO_Admin_Statistical;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import doanoracle_qlthuvien.connectionOracle;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Admin_Statistical extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    //connectionOracle c;
    Vector vheader = new Vector();
    Vector vdata = new Vector();
    
    DAO_Admin_Statistical dao;
    
    public Admin_Statistical() {
        initComponents();
        
        this.setLocationRelativeTo(null); // Chỉnh form nằm giữa màn hình
        
        // Load dữ liệu lên table ----------------------------------------------
        dao=new DAO_Admin_Statistical();
        vheader.add("session_id");
        vheader.add("db_user");
        vheader.add("object_schema");
        vheader.add("object_name");
        vheader.add("policy_name");
        vheader.add("sql_text");
        vheader.add("statement_type");
        
        dao.load(vdata);
        jTable1.setModel(new DefaultTableModel(vdata,vheader));
        
        // Hiển thị user bị khóa -----------------------------------------------
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(BienCucBo.ketnoi, 
                    BienCucBo.userN, BienCucBo.passW);
            String sql = "select count(*) as Khoa from sys.dba_users where account_status!='OPEN'";
            pst = con.prepareStatement(sql);

            
            rs = pst.executeQuery();

            if(rs.next()){
                this.lblDangmo.setText("Số lượng các tài khoản đang bị khóa: " +rs.getString("Khoa"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        // Hiển thị user đang mở -----------------------------------------------
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(BienCucBo.ketnoi, 
                    BienCucBo.userN, BienCucBo.passW);
            String sql = "select count(*) as Mo from sys.dba_users where account_status='OPEN'";
            pst = con.prepareStatement(sql);

            
            rs = pst.executeQuery();

            if(rs.next()){
                this.lblDanglock.setText("Số lượng các tài khoản đang mở: " +rs.getString("Mo"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblDangmo = new javax.swing.JLabel();
        lblDanglock = new javax.swing.JLabel();
        btn_Inthongke = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMINISTRATOR - Statistical");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("THỐNG KÊ");

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/back.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblDangmo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDangmo.setText("jLabel1");

        lblDanglock.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDanglock.setText("jLabel1");

        btn_Inthongke.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_Inthongke.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/printer.png"))); // NOI18N
        btn_Inthongke.setText(" In Thống Kê");
        btn_Inthongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InthongkeActionPerformed(evt);
            }
        });

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
        jTable1.setGridColor(new java.awt.Color(255, 0, 51));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDangmo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDanglock, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 361, Short.MAX_VALUE)
                        .addComponent(btn_Inthongke, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(484, 484, 484)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_Inthongke, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDangmo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(lblDanglock, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Admin_Home ah = new Admin_Home();
        ah.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    // Print button ------------------------------------------------------------
    private void btn_InthongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InthongkeActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?")
                == JOptionPane.OK_OPTION)
        {
            try {
                File f = new File("D:\\Project-DuAn\\QLThuVien_HQTCSDL-Oracle\\Print\\Admin_Statistical.txt");
                if(!f.exists()){
                    f.createNewFile();
                }

                FileWriter fw = new FileWriter(f.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write("\t\t\t\tTHÔNG TIN HOẠT ĐỘNG USER\n\n\n");
                bw.write("SESSION_ID  DB_USER  OBJECT_SCHEMA  OBJECT_NAME  POLICY_NAME          SQL_TEXT                                                                STATEMENT_TYPE");
                bw.write("\n___________________________________________________________________________________________________________________________________________________________\n");
                for(int i=0; i<jTable1.getRowCount(); i++){
                    for(int j=0; j<jTable1.getColumnCount(); j++){
                        bw.write((String)jTable1.getModel().getValueAt(i, j)+ "         ");
                    }
                    bw.write("\n___________________________________________________________________________________________________________________________________________________________\n");
                }

                bw.close();
                fw.close();
                JOptionPane.showMessageDialog(this, "In thành công!");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_InthongkeActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_Statistical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Statistical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Statistical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Statistical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Statistical().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btn_Inthongke;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDanglock;
    private javax.swing.JLabel lblDangmo;
    // End of variables declaration//GEN-END:variables
}
