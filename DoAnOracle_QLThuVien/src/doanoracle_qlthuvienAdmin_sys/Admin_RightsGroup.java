package doanoracle_qlthuvienAdmin_sys;

import DAO_Admin.BienCucBo;
import DAO_Admin_sys.DAO_Admin_RightsGroup;
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
import pojo_Admin_sys.pojo_Admin_Profile;
import pojo_Admin_sys.pojo_Admin_RightsGroup;

public class Admin_RightsGroup extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Vector vheader=new Vector();
    Vector vdata=new Vector();
    
    Vector vheaderU=new Vector();
    Vector vdataU=new Vector();
    
    DAO_Admin_RightsGroup daoRole;
    DAO_Admin_TaoUser daoUser;

    public Admin_RightsGroup() {
        initComponents();
        
        this.setLocationRelativeTo(null); // Chỉnh form nằm giữa màn hình
        initComboBoxtenuser();
        initComboBoxRole();
        
        String[] s={"With admin option"};
        cbbadminoption.removeAllItems();
        cbbadminoption.addItem("");
        for (String item : s) {
            cbbadminoption.addItem(item);
        }
        
        
        daoRole = new DAO_Admin_RightsGroup();
        vheader.add("Role");
        vheader.add("Quyền");
        vheader.add("admin_option");
        vheader.add("common");
        daoRole.LayDSAdmin_RightsGroup_vecter(vdata);
        tblRole.setModel(new DefaultTableModel(vdata,vheader));
        
        daoUser=new DAO_Admin_TaoUser();
        vheaderU.add("Username");
        vheaderU.add("Password");
        vheaderU.add("Default_tablespace");
        vheaderU.add("Profile");
        vheaderU.add("Account_status");
        vheaderU.add("Created");
        vheaderU.add("Last_login");
        daoUser.LayDSAdmin_TaoUser_vecter(vdataU);
        tblUser.setModel(new DefaultTableModel(vdataU,vheaderU));
    }
    // kiem tra rỗng -----------------------------------------------------------
    public boolean ktrong()
    {
        if(txttenRole.getText().length()==0)//rong
        {
            JOptionPane.showMessageDialog(null, "Tên nhóm quyền không được để trống");
            return  false;
        }
        if(txtquyen.getText().length()==0)//rong
        {
            JOptionPane.showMessageDialog(null, "Quyền không được để trống");
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
            String sql = "select sys.kttrungtenhomq('"+txttenRole.getText().toUpperCase()+"') "
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
    
    
    // Khởi tạo combobox ten ser ----------------------------------------
    private void initComboBoxtenuser(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(BienCucBo.ketnoi, 
                    BienCucBo.userN, BienCucBo.passW);
            String sql = "select * from sys.xemtenuserhienco";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            cbbtenuser.removeAllItems();
            while(rs.next()){
                cbbtenuser.addItem(rs.getString("username"));
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Khởi tạo phần combobox --------------------------------------------------
    private void initComboBoxRole(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(BienCucBo.ketnoi, 
                    BienCucBo.userN,BienCucBo.passW);
            String sql = "select * from sys.tenhomdatao";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            cbbRole.removeAllItems();
            while(rs.next()){
                cbbRole.addItem(rs.getString("role"));
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
        tblRole = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txttenRole = new javax.swing.JTextField();
        txtquyen = new javax.swing.JTextField();
        txtFind = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnRevokeRole = new javax.swing.JButton();
        btnPasteRole = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbbRole = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        cbbtenuser = new javax.swing.JComboBox();
        cbbadminoption = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMINISTRATOR - Rights Group");

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/back.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("THÔNG TIN NHÓM QUYỀN");

        tblRole.setModel(new javax.swing.table.DefaultTableModel(
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
        tblRole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRoleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRole);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Tên Role");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Quyền");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Admin option");

        txttenRole.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txttenRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttenRoleActionPerformed(evt);
            }
        });

        txtquyen.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtFind.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFindKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/find.png"))); // NOI18N
        jLabel9.setText("Nhập thông tin nhóm quyền cần tìm:");

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/delete.png"))); // NOI18N
        btnXoa.setText(" Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/edit.png"))); // NOI18N
        btnAdd.setText("Thêm Quyền");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCreate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/add.png"))); // NOI18N
        btnCreate.setText(" Tạo");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
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
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblUser);

        jLabel10.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel10.setText("Thông tin user");

        jLabel11.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel11.setText("Thông tin nhóm quyền");

        btnRevokeRole.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRevokeRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/delete.png"))); // NOI18N
        btnRevokeRole.setText(" Thu hồi");
        btnRevokeRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevokeRoleActionPerformed(evt);
            }
        });

        btnPasteRole.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPasteRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/add.png"))); // NOI18N
        btnPasteRole.setText(" Gán");
        btnPasteRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasteRoleActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("User Name");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Role");

        cbbRole.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbbRole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel13.setText("Phân quyền cho user");

        cbbtenuser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbbtenuser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbadminoption.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbbadminoption.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel14.setText("Thông tin các nhóm quyền");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txttenRole, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtquyen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbbadminoption, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14))))
                                .addGap(34, 34, 34))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(btnCreate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdd)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addGap(417, 417, 417)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel7)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cbbtenuser, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addGap(180, 180, 180)
                                                    .addComponent(cbbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(131, 131, 131)
                                        .addComponent(btnPasteRole)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnRevokeRole)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txttenRole, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtquyen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbadminoption, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreate)
                            .addComponent(btnXoa)
                            .addComponent(btnAdd))
                        .addGap(50, 50, 50)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbtenuser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPasteRole)
                            .addComponent(btnRevokeRole))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Admin_Home ah = new Admin_Home();
        ah.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void tblRoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRoleMouseClicked
        int index = tblRole.getSelectedRow();
        Vector v = (Vector)vdata.get(index);
        txttenRole.setText(((String)v.get(0)).replace(" ", ""));
        txtquyen.setText((String)v.get(1));
    }//GEN-LAST:event_tblRoleMouseClicked

    // Xóa quyền ---------------------------------------------------------------
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

        // Nếu để rỗng -> không thực thi
        if(txttenRole.getText().length()==0)//rỗng
        {
            JOptionPane.showMessageDialog(null, "Tên nhóm quyền không được để trống");
            return;
        }
        
        if (BienCucBo.ktxoa()) // đồng ý thực hiện thao tác
        {
            if(kttrung()==false) // không tồn tại khóa chính
            {
                JOptionPane.showMessageDialog(null, "Nhóm quyền Không tồn tại");
                return;
            }
            else // khong trung
            {
               pojo_Admin_RightsGroup x = new pojo_Admin_RightsGroup(txttenRole.getText(), 
               txtquyen.getText(),cbbadminoption.getSelectedItem().toString(),"","");
               daoRole.XoaNhomquyen(x);
               daoRole.LayDSAdmin_RightsGroup_vecter(vdata);
               tblRole.updateUI();
            
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

    // Thêm vào nhóm quyền -----------------------------------------------------
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không?")
                            == JOptionPane.OK_OPTION){
            pojo_Admin_RightsGroup x = new pojo_Admin_RightsGroup(txttenRole.getText(), 
                        txtquyen.getText(),cbbadminoption.getSelectedItem().toString(),"","");
               daoRole.ThemquyenNhomquyen(x);
               daoRole.LayDSAdmin_RightsGroup_vecter(vdata);
               tblRole.updateUI();
               JOptionPane.showMessageDialog(null, "Thành công");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    // Tạo nhóm quyền ----------------------------------------------------------
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // Nếu để rỗng -> không thực thi
        if(ktrong()==false)
        {
            return;
        }
        
        if(BienCucBo.ktthem()) // Đồng ý thực hiện thao tác
        {
            if(kttrung()==true) //trùng mã sách
            {
                JOptionPane.showMessageDialog(null, "Tên nhóm quyền đã tồn tại!");
                return;
            }
            else //mã sách không trùng
            {
               pojo_Admin_RightsGroup x = new pojo_Admin_RightsGroup(txttenRole.getText(), 
                        txtquyen.getText(),cbbadminoption.getSelectedItem().toString(),"","");
               daoRole.TaoNhomquyen(x);
               daoRole.LayDSAdmin_RightsGroup_vecter(vdata);
               tblRole.updateUI();
               
               if(kttrung()==true) // trung là đã thêm vào thành công
                {
                    JOptionPane.showMessageDialog(null, "Thành công");
                    return;
                }
               else // không trùng không có trong table
                {
                    JOptionPane.showMessageDialog(null, "Thất Bại");
                    return;
                }
            }
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    // Thu hồi quyền của user --------------------------------------------------
    private void btnRevokeRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevokeRoleActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thu hồi nhóm Quyền cho user này không?")
            == JOptionPane.OK_OPTION){
            pojo_Admin_RightsGroup x = new pojo_Admin_RightsGroup(cbbRole.getSelectedItem().toString(), 
               cbbtenuser.getSelectedItem().toString(),"","","");
               daoRole.ThuhoiNhomquyenchoUser(x);
               daoRole.LayDSAdmin_RightsGroup_vecter(vdata);
               tblRole.updateUI();
               JOptionPane.showMessageDialog(null, "Thu hồi thành công");
        }
    }//GEN-LAST:event_btnRevokeRoleActionPerformed

    // Gán quyền cho user ------------------------------------------------------
    private void btnPasteRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasteRoleActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm nhóm quyền cho user này không?")
            == JOptionPane.OK_OPTION){
            pojo_Admin_RightsGroup x = new pojo_Admin_RightsGroup(txttenRole.getText(), 
                    txtquyen.getText(),cbbadminoption.getSelectedItem().toString(),"","");
               daoRole.ThemNhomquyenchoUser(x);
               daoRole.LayDSAdmin_RightsGroup_vecter(vdata);
               tblRole.updateUI();
               JOptionPane.showMessageDialog(null, "Gán quyền thành công");
        }
    }//GEN-LAST:event_btnPasteRoleActionPerformed

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        int index = tblUser.getSelectedRow();
        Vector v = (Vector)vdata.get(index);
        cbbtenuser.setSelectedItem((String)v.get(0));
    }//GEN-LAST:event_tblUserMouseClicked

    // Tìm kiếm ----------------------------------------------------------------
    private void txtFindKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            pojo_Admin_RightsGroup x=new pojo_Admin_RightsGroup(txtFind.getText().toUpperCase(),
                    txtquyen.getText(),"","","");
            daoRole.timKiem(vdata, x);
            tblRole.updateUI();
        }
    }//GEN-LAST:event_txtFindKeyPressed

    private void txttenRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttenRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttenRoleActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_RightsGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_RightsGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_RightsGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_RightsGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_RightsGroup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnPasteRole;
    private javax.swing.JButton btnRevokeRole;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox cbbRole;
    private javax.swing.JComboBox cbbadminoption;
    private javax.swing.JComboBox cbbtenuser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblRole;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtquyen;
    private javax.swing.JTextField txttenRole;
    // End of variables declaration//GEN-END:variables
}
