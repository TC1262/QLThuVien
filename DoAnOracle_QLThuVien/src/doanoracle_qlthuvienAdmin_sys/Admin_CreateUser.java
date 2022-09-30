package doanoracle_qlthuvienAdmin_sys;

import DAO_Admin.BienCucBo;
import DAO_Admin_sys.DAO_Admin_Database;
import DAO_Admin_sys.DAO_Admin_Datafile;
import DAO_Admin_sys.DAO_Admin_TaoUser;
import doanoracle_qlthuvienAdmin.Admin_Home;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pojo_Admin_sys.pojo_Admin_Database;
import pojo_Admin_sys.pojo_Admin_TaoUser;

public class Admin_CreateUser extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    Vector vheader=new Vector();
    Vector vdata=new Vector();
    
    DAO_Admin_TaoUser dao;
    
    public Admin_CreateUser() {
        initComponents();
        this.setLocationRelativeTo(null); // Chỉnh form nằm giữa màn hình
        
        initComboBoxtablespace();
        initComboBoxtenrole();
        initComboBoxprofile();
        
        dao=new DAO_Admin_TaoUser();
        vheader.add("Username");
        vheader.add("Password");
        vheader.add("Default_tablespace");
        vheader.add("Profile");
        vheader.add("Account_status");
        vheader.add("Created");
        vheader.add("Last_login");
        dao.LayDSAdmin_TaoUser_vecter(vdata);
        jTable1.setModel(new DefaultTableModel(vdata,vheader));
    }

    //kiem tra chua nhap du lieu
    public boolean ktrong()
    {
        if(txtusername.getText().length()==0)//rong
        {
            JOptionPane.showMessageDialog(null, "Username không được để trống");
            return  false;
        }
        if(txtpassword.getText().length()==0)//rong
        {
            JOptionPane.showMessageDialog(null, "Password không được để trống");
            return  false;
        }
        if(txtquota.getText().length()==0)//rong
        {
            JOptionPane.showMessageDialog(null, "Quota không được để trống");
            return  false;
        }
        return  true;
    }
    //kiem tra khoa chinh
    public  boolean kttrung()
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(BienCucBo.ketnoi, 
                    BienCucBo.userN, BienCucBo.passW);
            String sql = "select sys.kt_taouser('"+txtusername.getText().toUpperCase()+"') "
                    + "as soluong from dual";
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
    //kiem tra khoa chinh
    public  boolean ktlockuser()
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(BienCucBo.ketnoi, 
                    BienCucBo.userN, BienCucBo.passW);
            String sql = "select sys.kt_lockuser('"+txtusername.getText().toUpperCase()+"') "
                    + "as soluong from dual";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                if(Integer.parseInt(rs.getString("soluong"))==0)
                {
                    return true;//user dang doc mo
                }
                else
                { return false;}//user dang bi khoa
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return  false;
    }
    
    private void initComboBoxtablespace(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(BienCucBo.ketnoi, 
                    BienCucBo.userN, BienCucBo.passW);
            String sql = "select * from sys.view_tentablespace";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            cbbdefault_tablespace.removeAllItems();
            cbbdefault_tablespace.addItem("DEFAULT");
            while(rs.next()){
                cbbdefault_tablespace.addItem(rs.getString("NAME"));
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void initComboBoxprofile(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(BienCucBo.ketnoi, 
                    BienCucBo.userN, BienCucBo.passW);
            String sql = "select * from sys.view_tenprofile";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            cbbprofile.removeAllItems();
            cbbprofile.addItem("DEFAULT");
            while(rs.next()){
                cbbprofile.addItem(rs.getString("profile"));
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void initComboBoxtenrole(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(BienCucBo.ketnoi, 
                    BienCucBo.userN, BienCucBo.passW);
            String sql = "select * from sys.tennhom";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            cbbrole.removeAllItems();
            cbbrole.addItem("DEFAULT");
            while(rs.next()){
                cbbrole.addItem(rs.getString("role"));
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

        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtusername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbbdefault_tablespace = new javax.swing.JComboBox<String>();
        txtquota = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbbprofile = new javax.swing.JComboBox<String>();
        jLabel8 = new javax.swing.JLabel();
        cbbrole = new javax.swing.JComboBox<String>();
        jLabel9 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        txtpassword = new javax.swing.JPasswordField();
        btnMokhoa = new javax.swing.JButton();
        btnkhoa = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMINISTRATOR - User");

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/back.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("THÔNG TIN USER");

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

        txtusername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Tên user");

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel4.setText("Thông tin chi tiết:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Password");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Tablespace");

        cbbdefault_tablespace.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbbdefault_tablespace.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtquota.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Quota");

        cbbprofile.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbbprofile.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Profile");

        cbbrole.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbbrole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Role");

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/add.png"))); // NOI18N
        btnAdd.setText(" Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

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

        txtpassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnMokhoa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMokhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/open-padlock.png"))); // NOI18N
        btnMokhoa.setText(" Mở Khóa");
        btnMokhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMokhoaActionPerformed(evt);
            }
        });

        btnkhoa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnkhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/lock.png"))); // NOI18N
        btnkhoa.setText(" Khóa");
        btnkhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkhoaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/find.png"))); // NOI18N
        jLabel11.setText("Nhập thông tin user cần tìm:");

        txtFind.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFindKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFindKeyReleased(evt);
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
                        .addGap(467, 467, 467)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel11)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnAdd)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnXoa)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSua)
                                        .addGap(55, 55, 55))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnkhoa)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnMokhoa)
                                        .addGap(100, 100, 100))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(txtFind))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel8)
                                                    .addComponent(jLabel9))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(cbbrole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cbbprofile, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtquota)
                                                    .addComponent(cbbdefault_tablespace, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtusername)
                                                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbdefault_tablespace, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtquota, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbprofile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbrole, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoa)
                            .addComponent(btnSua)
                            .addComponent(btnAdd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMokhoa)
                            .addComponent(btnkhoa))
                        .addGap(28, 28, 28))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Admin_Home ah = new Admin_Home();
        ah.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(ktrong()==false)
        {
            return;
        }
        if(BienCucBo.ktthem())
        {
            if(kttrung()==true)//trùng mã sách
            {
                JOptionPane.showMessageDialog(null, "User đã tồn tại!");
                return;
            }
            else//mã sách không trùng
            {
               pojo_Admin_TaoUser x = new pojo_Admin_TaoUser(txtusername.getText(), 
                        txtpassword.getText(),cbbdefault_tablespace.getSelectedItem().toString(),
                        txtquota.getText(),cbbprofile.getSelectedItem().toString(),
                        cbbrole.getSelectedItem().toString(),cbbrole.getSelectedItem().toString(),"","");
               dao.Themuser(x);
               dao.LayDSAdmin_TaoUser_vecter(vdata);
               jTable1.updateUI();
               if(kttrung()==true)//trung là đã thêm vào thành công
                {
                    JOptionPane.showMessageDialog(null, "Thành công");
                    return;
                }
                else//không trùng không có trông table
                {
                    JOptionPane.showMessageDialog(null, "Thất Bại");
                    return;
                }
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

        if(txtusername.getText().length()==0)//rỗng
        {
            JOptionPane.showMessageDialog(null, "Username không được để trống");
            return;
        }
        if (BienCucBo.ktxoa())//
        {
            if(kttrung()==false)//không tồn tại khóa chính
            {
                JOptionPane.showMessageDialog(null, "Username Không tồn tại");
                return;
            }
            else//khong trung
            {
            pojo_Admin_TaoUser x = new pojo_Admin_TaoUser();
            x.setUsername(txtusername.getText().toUpperCase());
            dao.Xoauser(x);
            dao.LayDSAdmin_TaoUser_vecter(vdata);
            jTable1.updateUI();
            if(kttrung()==false)//Không tồn tại
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

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

        if(ktrong()==false)//rỗng
        {
            return;
        }
        if (BienCucBo.ktsua())//tồn tại
        {
            if(kttrung()==false)//không tồn tại khóa chính
            {
                JOptionPane.showMessageDialog(null, "Username Không tồn tại ");
                return;
            }
            else//khong trung
            {                                   
               pojo_Admin_TaoUser x = new pojo_Admin_TaoUser(txtusername.getText(), 
                        txtpassword.getText(),cbbdefault_tablespace.getSelectedItem().toString(),
                        txtquota.getText(),cbbprofile.getSelectedItem().toString(),
                       cbbrole.getSelectedItem().toString(),cbbrole.getSelectedItem().toString(),"","");
               dao.Suauser(x);
               dao.LayDSAdmin_TaoUser_vecter(vdata);
               jTable1.updateUI();
             if(kttrung()==true)//trung
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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        Vector v = (Vector)vdata.get(index);
        txtusername.setText(((String)v.get(0)));
        txtpassword.setText((String)v.get(1));
        cbbdefault_tablespace.setSelectedItem((String)v.get(2));
        cbbprofile.setSelectedItem((String)v.get(3));
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnMokhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMokhoaActionPerformed
        // TODO add your handling code here:
        if(txtusername.getText().length()==0)//rỗng
        {
            JOptionPane.showMessageDialog(null, "Username không được để trống");
            return;
        }
        if(JOptionPane.showConfirmDialog(null, "Bạn có muốn Khóa user không?")== JOptionPane.OK_OPTION)
        {
            if(kttrung()==false)//không tồn tại khóa chính
            {
                JOptionPane.showMessageDialog(null, "Username Không tồn tại");
                return;
            }
            else
            {
                if(ktlockuser()==true)
                {
                    JOptionPane.showMessageDialog(null, "User Đang ở trạng thái mở");
                    return;
                }
                else
                {
                    pojo_Admin_TaoUser x = new pojo_Admin_TaoUser();
                    x.setUsername(txtusername.getText().toUpperCase());
                    dao.MoKhoauser(x);
                    dao.LayDSAdmin_TaoUser_vecter(vdata);
                    jTable1.updateUI();
                    if(ktlockuser()==true)
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
        }
    }//GEN-LAST:event_btnMokhoaActionPerformed

    private void btnkhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkhoaActionPerformed
        if(txtusername.getText().length()==0)//rỗng
        {
            JOptionPane.showMessageDialog(null, "Username không được để trống");
            return;
        }
        if(JOptionPane.showConfirmDialog(null, "Bạn có muốn Khóa user không?")== JOptionPane.OK_OPTION)
        {
            if(kttrung()==false)//không tồn tại khóa chính
            {
                JOptionPane.showMessageDialog(null, "Username Không tồn tại");
                return;
            }
            else
            {
                if(ktlockuser()==false)
                {
                    JOptionPane.showMessageDialog(null, "User Đang ở trạng thái khóa");
                    return;
                }
                else
                {
                    pojo_Admin_TaoUser x = new pojo_Admin_TaoUser();
                    x.setUsername(txtusername.getText().toUpperCase());
                    dao.Khoauser(x);
                    dao.LayDSAdmin_TaoUser_vecter(vdata);
                    jTable1.updateUI();
                    if(ktlockuser()==false)
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
        }
    }//GEN-LAST:event_btnkhoaActionPerformed

    private void txtFindKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyPressed

    }//GEN-LAST:event_txtFindKeyPressed

    private void txtFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyReleased

    }//GEN-LAST:event_txtFindKeyReleased

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
            java.util.logging.Logger.getLogger(Admin_CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_CreateUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnMokhoa;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnkhoa;
    private javax.swing.JComboBox<String> cbbdefault_tablespace;
    private javax.swing.JComboBox<String> cbbprofile;
    private javax.swing.JComboBox<String> cbbrole;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTextField txtFind;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtquota;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
