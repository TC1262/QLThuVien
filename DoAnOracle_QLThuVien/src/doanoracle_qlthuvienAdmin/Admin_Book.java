package doanoracle_qlthuvienAdmin;


import DAO_Admin.BienCucBo;
import DAO_Admin.DAO_Admin_Book;
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
import pojo_Admin.pojo_Admin_Book;

public class Admin_Book extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    DefaultTableModel model;
    
    Vector vheader=new Vector();
    Vector vdata=new Vector();
    
    Vector cdata=new Vector();
    Vector ndata=new Vector();
    
    DAO_Admin_Book dao;
    
    public Admin_Book() {
        initComponents();
        
        this.setLocationRelativeTo(null); // Chỉnh form nằm giữa màn hình
        
        initComboBoxMaTG();
        
        // Load dữ liệu lên table ----------------------------------------------
        dao=new DAO_Admin_Book();
        vheader.add("Mã sách");
        vheader.add("Tên sách");
        vheader.add("Mã tác giả");
        vheader.add("Năm xuất bản");
        vheader.add("Giá sách");
        vheader.add("Số lượng");
        
        dao.LayDSAdmin_Book_vecter(vdata);
        jTablesach.setModel(new DefaultTableModel(vdata,vheader));   
    }
    
    // kiem tra rỗng -----------------------------------------------------------
    public boolean ktrong()
    {
        if(txtMaSach.getText().length()==0)//rong
        {
            JOptionPane.showMessageDialog(null, "Mã sách không được để trống");
            return  false;
        }
        if(txtTenSach.getText().length()==0)//rong
        {
            JOptionPane.showMessageDialog(null, "Tên không được để trống");
            return  false;
        }
        if(txtNXB.getText().length()==0)//rong
        {
            JOptionPane.showMessageDialog(null, "Năm nhà xuất bản không được để trống");
            return  false;
        }
        if(txtGia.getText().length()==0)//rong
        {
            JOptionPane.showMessageDialog(null, "Giá không được để trống");
            return  false;
        }
        if(txtSL.getText().length()==0)//rong
        {
            JOptionPane.showMessageDialog(null, "Só lượng không được để trống");
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
            String sql = "select sys.fct_kt_trungmasach('"+txtMaSach.getText()+"') as soluong from dual";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                if(Integer.parseInt(rs.getString("soluong"))==1)
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
    
    // Khởi tạo phần combobox mã tác giả ---------------------------------------
    private void initComboBoxMaTG(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(BienCucBo.ketnoi, 
                    BienCucBo.userN, BienCucBo.passW);
            String sql = "select * from sys.view_inmaTACGIA";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            cbbmatagia.removeAllItems();
            while(rs.next()){
                cbbmatagia.addItem(rs.getString("maTG"));
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablesach = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        txtMaSach = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenSach = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNXB = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        txtSL = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        cbbmatagia = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMINISTRATOR - Book");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Số lượng");

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/delete.png"))); // NOI18N
        btnXoa.setText(" Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jTablesach.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablesach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablesachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablesach);

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/back.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtMaSach.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("THÔNG TIN CÁC SÁCH CỦA THƯ VIỆN");

        txtTenSach.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setText("Thông tin chi tiết:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Mã sách");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Tên sách");

        txtNXB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Mã tác giả");

        txtGia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtSL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Năm xuất bản");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Giá");

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/add.png"))); // NOI18N
        btnThem.setText(" Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
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

        cbbmatagia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbbmatagia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/find.png"))); // NOI18N
        jLabel11.setText("Nhập thông tin sách cần tìm:");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 533, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(508, 508, 508))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1065, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addComponent(btnThem)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnXoa)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSua))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel11)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel4)
                                                            .addComponent(jLabel3)
                                                            .addComponent(jLabel5)
                                                            .addComponent(jLabel7)
                                                            .addComponent(jLabel8)
                                                            .addComponent(jLabel9))
                                                        .addGap(32, 32, 32)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(txtTenSach)
                                                            .addComponent(txtMaSach)
                                                            .addComponent(cbbmatagia, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(txtNXB, javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(txtGia, javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(txtSL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                            .addComponent(jLabel1)))
                                    .addComponent(txtFind, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1)
                        .addGap(40, 40, 40)
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
                            .addComponent(cbbmatagia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnXoa)
                            .addComponent(btnSua)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Admin_Home ah = new Admin_Home();
        ah.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // Nếu để rỗng -> không thực thi
        if(ktrong()==false)
        {
            return;
        }
        
        if(BienCucBo.ktthem()) // Đồng ý thực hiện thao tác
        {
            if(kttrung()==true) //trùng mã sách
            {
                JOptionPane.showMessageDialog(null, "Trùng Mã sách!");
                return;
            }
            else //mã sách không trùng
            {
               pojo_Admin_Book x = new pojo_Admin_Book(txtMaSach.getText(), 
               txtTenSach.getText(),cbbmatagia.getSelectedItem().toString(),
               txtNXB.getText(),txtGia.getText(),txtSL.getText());
               dao.ThemSach(x);
               dao.LayDSAdmin_Book_vecter(vdata);
               jTablesach.updateUI();
               
               if(kttrung()==true) // trung là đã thêm vào thành công
                {
                    JOptionPane.showMessageDialog(null, "Thành công");
                    return;
                }
               else // không trùng không có trông table
                {
                    JOptionPane.showMessageDialog(null, "Thất Bại");
                    return;
                }
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // Nếu để rỗng -> không thực thi
        if(ktrong()==false)//rỗng
        {
            return;
        }
        
        if (BienCucBo.ktsua()) // đồng ý thực thi thao tác
        {
            if(kttrung()==false) // không tồn tại khóa chính
            {
                JOptionPane.showMessageDialog(null, "Mã Sách Không tồn tại ");
                return;
            }
            else//khong trung
            {                                   
             pojo_Admin_Book x=new pojo_Admin_Book(txtMaSach.getText(), 
                    txtTenSach.getText(),cbbmatagia.getSelectedItem().toString(),
                    txtNXB.getText(),txtGia.getText(),txtSL.getText());
             dao.SuaSach(x);
             dao.LayDSAdmin_Book_vecter(vdata);
             jTablesach.updateUI();
             if(kttrung()==true) // trung là đã thêm vào thành công
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
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // Nếu để rỗng -> không thực thi
        if(txtMaSach.getText().length()==0)//rỗng
        {
            JOptionPane.showMessageDialog(null, "CMND không được để trống");
            return;
        }
        
        if (BienCucBo.ktxoa()) // đồng ý thực hiện thao tác
        {
            if(kttrung()==false) // không tồn tại khóa chính
            {
                JOptionPane.showMessageDialog(null, "Mã Sách Không tồn tại");
                return;
            }
            else // khong trung
            {
            pojo_Admin_Book x = new pojo_Admin_Book();
            x.setmS(txtMaSach.getText());
            dao.XoaSach(x);
            dao.LayDSAdmin_Book_vecter(vdata);
            jTablesach.updateUI();
            
            if(kttrung()==false)// Không tồn tại tức là đã xóa thành công
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
        
    }//GEN-LAST:event_btnXoaActionPerformed

    private void jTablesachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablesachMouseClicked
        int index = jTablesach.getSelectedRow();
        Vector v = (Vector)vdata.get(index);
        txtMaSach.setText(((String)v.get(0)));
        txtTenSach.setText((String)v.get(1));
        cbbmatagia.setSelectedItem((String)v.get(2));
        txtNXB.setText((String)v.get(3));
        txtGia.setText((String)v.get(4));
        txtSL.setText((String)v.get(5));       
    }//GEN-LAST:event_jTablesachMouseClicked

    private void txtFindKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyPressed
        // TODO add your handling code here
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            pojo_Admin_Book x=new pojo_Admin_Book(txtFind.getText(),txtTenSach.getText(),
                    cbbmatagia.getSelectedItem().toString(),txtNXB.getText(),txtGia.getText(), "");
            dao.timKiemAdmin_Book(vdata, x);
            jTablesach.updateUI();
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
            java.util.logging.Logger.getLogger(Admin_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbmatagia;
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
    private javax.swing.JTable jTablesach;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtNXB;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtTenSach;
    // End of variables declaration//GEN-END:variables
}