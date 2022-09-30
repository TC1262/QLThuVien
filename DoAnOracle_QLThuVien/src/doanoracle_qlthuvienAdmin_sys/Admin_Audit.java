package doanoracle_qlthuvienAdmin_sys;

import DAO_Admin.BienCucBo;
import DAO_Admin_sys.DAO_Admin_Audit;
import DAO_Admin_sys.DAO_Admin_TaoUser;
import doanoracle_qlthuvienAdmin.Admin_Home;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pojo_Admin_sys.pojo_Admin_Audit;

public class Admin_Audit extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    Vector vheader=new Vector();
    Vector vdata=new Vector();
    
    DAO_Admin_Audit dao;

    public Admin_Audit() {
        initComponents();
        
        this.setLocationRelativeTo(null); // Chỉnh form nằm giữa màn hình
        
        initComboBoxobject_schema();
        
        dao=new DAO_Admin_Audit();
        vheader.add("object_schema");
        vheader.add("object_name");
        vheader.add("policy_owner");
        vheader.add("policy_name");
        vheader.add("enabled");
        vheader.add("sel");
        vheader.add("ins");
        vheader.add("upd");
        vheader.add("del");
        dao.loadData(vdata);
        jTable1.setModel(new DefaultTableModel(vdata,vheader));
    }
    //kiem tra chua nhap du lieu
    public boolean ktrong()
    {
        if(cbbtentable.getSelectedItem().toString().length()==0)//rong
        {
            JOptionPane.showMessageDialog(null, "Chưa chọn tên table!");
            return  false;
        }
        if(jTFtenpolicy.getText().length()==0)//rong
        {
            JOptionPane.showMessageDialog(null, "Tên policy không được để trống");
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
            String sql = "select sys.kttenpolicy('"+jTFtenpolicy.getText().toUpperCase()+"') "
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
            String sql = "select sys.ktbattatpolicy('"+jTFtenpolicy.getText()+"') "
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
    // Khởi tạo combobox ten user ----------------------------------------
    private void initComboBoxobject_schema(){
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
    
    // Khởi tạo combobox Action ------------------------------------------------
    private void initComboBoxobject_name(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(BienCucBo.ketnoi, 
                    BienCucBo.userN, BienCucBo.passW);
            String sql = "SELECT table_name FROM sys.dba_tables "
                    + "where owner='"+cbbtenuser.getSelectedItem().toString()+"'";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            cbbtentable.removeAllItems();
            while(rs.next()){
                cbbtentable.addItem(rs.getString("table_name"));
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

        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnXemGiamSat = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        btnBat = new javax.swing.JButton();
        cbbtenuser = new javax.swing.JComboBox<String>();
        cbbtentable = new javax.swing.JComboBox<String>();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTFtenpolicy = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextGiamsat1 = new javax.swing.JTextField();
        btnTat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMINISTRATOR - Audit Policy");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("THÔNG TIN AUDIT POLICY");

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/back.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnXemGiamSat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXemGiamSat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/view.png"))); // NOI18N
        btnXemGiamSat.setText("Xem Giám Sát");
        btnXemGiamSat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemGiamSatActionPerformed(evt);
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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Tên user");

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/add.png"))); // NOI18N
        btnAdd.setText(" Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel4.setText("Tạo mới audit policy");

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/delete.png"))); // NOI18N
        btnXoa.setText(" Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel10.setText("Bật audit policy");

        btnBat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/open-padlock.png"))); // NOI18N
        btnBat.setText(" Bật");
        btnBat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatActionPerformed(evt);
            }
        });

        cbbtenuser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbbtenuser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbtenuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbtenuserActionPerformed(evt);
            }
        });

        cbbtentable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbbtentable.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Tên Policy");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Tên table");

        jTFtenpolicy.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Giám Sát");

        jTextGiamsat1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnTat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/lock.png"))); // NOI18N
        btnTat.setText("Tắt");
        btnTat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTatActionPerformed(evt);
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
                        .addGap(435, 435, 435)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFind, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnAdd)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnXoa)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnXemGiamSat))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel14)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jLabel15))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextGiamsat1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(cbbtentable, 0, 308, Short.MAX_VALUE)
                                                        .addComponent(cbbtenuser, 0, 308, Short.MAX_VALUE)
                                                        .addComponent(jTFtenpolicy, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)))))
                                        .addGap(12, 12, 12))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel11)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(55, 55, 55)
                                                .addComponent(btnBat, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(37, 37, 37)
                                                .addComponent(btnTat, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbbtenuser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbtentable, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTFtenpolicy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jTextGiamsat1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoa)
                            .addComponent(btnXemGiamSat)
                            .addComponent(btnAdd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBat)
                            .addComponent(btnTat))
                        .addGap(50, 50, 50))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Admin_Home ah = new Admin_Home();
        ah.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnXemGiamSatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemGiamSatActionPerformed
        Admin_GiamSat ah1 = new Admin_GiamSat();
        ah1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnXemGiamSatActionPerformed

    private void txtFindKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyPressed
        // TODO add your handling code here:
        //        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            //            pojo_Admin_Database x=new pojo_Admin_Database(txtFind.getText().toUpperCase(),t.getText(),txtLog_mode.getText(),txtcontrolfile_time.getText(), "");
            //            dao.timKiemAdmin_Database(vdata, x);
            //            jTable1.updateUI();
            //        }
    }//GEN-LAST:event_txtFindKeyPressed

    private void txtFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyReleased

    }//GEN-LAST:event_txtFindKeyReleased

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(ktrong()==false)
        {
            return;
        }
        if(BienCucBo.ktthem())
        {
            if(kttrung()==true)//trùng mã sách
            {
                JOptionPane.showMessageDialog(null, "Tên policy đã tồn tại!");
                return;
            }
            else//mã sách không trùng
            {
                pojo_Admin_Audit x = new pojo_Admin_Audit(cbbtenuser.getSelectedItem().toString(), 
                        cbbtentable.getSelectedItem().toString(),"",
                        jTFtenpolicy.getText(),"",jTextGiamsat1.getText(),"","","");
                dao.Thempolicy(x);
                dao.loadData(vdata);
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
        if(ktrong()==false)
        {
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
            pojo_Admin_Audit x = new pojo_Admin_Audit();
            pojo_Admin_Audit y = new pojo_Admin_Audit();
            pojo_Admin_Audit z = new pojo_Admin_Audit();
            x.setObject_schema(cbbtenuser.getSelectedItem().toString());
            y.setObject_name(cbbtentable.getSelectedItem().toString());
            z.setPolicy_name(jTFtenpolicy.getText());
            dao.Xoapolicy(x,y,z);
            dao.loadData(vdata);
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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        Vector v = (Vector)vdata.get(index);
        cbbtenuser.setSelectedItem((String)v.get(0));
        initComboBoxobject_name();
        cbbtentable.setSelectedItem((String)v.get(1));
        jTFtenpolicy.setText((String)v.get(3));
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnBatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatActionPerformed
        // TODO add your handling code here:
        if(ktrong()==false)
        {
            return;
        }
        if(JOptionPane.showConfirmDialog(null, "Bạn có muốn Bật Policy này không?")== JOptionPane.OK_OPTION)
        {
            if(kttrung()==false)//không tồn tại khóa chính
            {
                JOptionPane.showMessageDialog(null, "Tên Policy Không tồn tại");
                return;
            }
            else
            {
                if(ktlockuser()==true)
                {
                    JOptionPane.showMessageDialog(null, "Policy Đang ở trạng thái Bật");
                    return;
                }
                else
                {
                    pojo_Admin_Audit x = new pojo_Admin_Audit();
                    pojo_Admin_Audit y = new pojo_Admin_Audit();
                    pojo_Admin_Audit z = new pojo_Admin_Audit();
                    x.setObject_schema(cbbtenuser.getSelectedItem().toString());
                    y.setObject_name(cbbtentable.getSelectedItem().toString());
                    z.setPolicy_name(jTFtenpolicy.getText());
                    dao.Batpolicy(x,y,z);
                    dao.loadData(vdata);
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
    }//GEN-LAST:event_btnBatActionPerformed

    private void cbbtenuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbtenuserActionPerformed
        // TODO add your handling code here:
        initComboBoxobject_name();
    }//GEN-LAST:event_cbbtenuserActionPerformed

    private void btnTatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTatActionPerformed
        // TODO add your handling code here:
        if(ktrong()==false)
        {
            return;
        }
        if(JOptionPane.showConfirmDialog(null, "Bạn có muốn Bật Policy này không?")== JOptionPane.OK_OPTION)
        {
            if(kttrung()==false)//không tồn tại khóa chính
            {
                JOptionPane.showMessageDialog(null, "Tên Policy Không tồn tại");
                return;
            }
            else
            {
                if(ktlockuser()==false)
                {
                    JOptionPane.showMessageDialog(null, "Policy Đang ở trạng thái Tắt");
                    return;
                }
                else
                {
                    pojo_Admin_Audit x = new pojo_Admin_Audit();
                    pojo_Admin_Audit y = new pojo_Admin_Audit();
                    pojo_Admin_Audit z = new pojo_Admin_Audit();
                    x.setObject_schema(cbbtenuser.getSelectedItem().toString());
                    y.setObject_name(cbbtentable.getSelectedItem().toString());
                    z.setPolicy_name(jTFtenpolicy.getText());
                    dao.Tatpolicy(x,y,z);
                    dao.loadData(vdata);
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
    }//GEN-LAST:event_btnTatActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_Audit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Audit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Audit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Audit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Audit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBat;
    private javax.swing.JButton btnTat;
    private javax.swing.JButton btnXemGiamSat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbtentable;
    private javax.swing.JComboBox<String> cbbtenuser;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTFtenpolicy;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextGiamsat1;
    private javax.swing.JTextField txtFind;
    // End of variables declaration//GEN-END:variables
}
