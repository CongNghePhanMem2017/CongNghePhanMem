/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancnpm;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author manng
 */
public class frmTiepNhanHS extends javax.swing.JInternalFrame {

    Extra CE = new Extra();
    ConnectDB DB=new ConnectDB();
    private String header[] = {"MHS","Năm Học","Khối", "Họ Tên","GT", "Ngày Sinh", "Địa Chỉ", "Email"};
    char NumArray[]={'0','1','2','3','4','5','6','7','8','9'};
    char SpecSign[]={'`','~','!','@','#','$','%','^','&','*','(',')','-','_','+','=','{','[','}',']','\\','|',';',':','\'','"','<',',','>','.','?','/'};
    private DefaultTableModel tblModel = new DefaultTableModel(header,0);
    /**
     * Creates new form frmThemHS
     */
    public frmTiepNhanHS() {
        initComponents();
        loadNamHocAndFillToCBBox();
        loadKhoiAndFillToCBBox();
        jTableTiepNhanHS.setModel(tblModel);
        loadHSFillTB();
    }

    private void loadNamHocAndFillToCBBox(){

        try {
            DB.conn = DriverManager.getConnection(DB.dbURL);

            // Câu lệnh xem dữ liệu
            String sql = "select * from NAMHOC ";

            // Tạo đối tượng thực thi câu lệnh Select
            DB.st = DB.conn.createStatement();

            // Thực thi 
            DB.rs = DB.st.executeQuery(sql);
            Vector data = null;
            DefaultComboBoxModel cmbModel = new DefaultComboBoxModel();

            // Nếu sách không tồn tại
            if (DB.rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "Nam hoc not available!");
                return;
            }

            // Trong khi chưa hết dữ liệu
            while (DB.rs.next()) {
//                data = new Vector();
//                data.add(DB.rs.getString("MANH"));
//                cmbModel.addElement(data);
                    String namhoc=DB.rs.getString("MANH");
                    jComboBoxNamHoc.addItem(namhoc);
            }

           //  jComboBoxNamHoc.setModel(cmbModel);

            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (DB.conn != null) {
                    DB.conn.close();
                }
                if (DB.st != null) {
                    DB.st.close();
                }
                if (DB.rs != null) {
                    DB.rs.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
     private void loadKhoiAndFillToCBBox(){

        try {
            DB.conn = DriverManager.getConnection(DB.dbURL);

            // Câu lệnh xem dữ liệu
            String sql = "select * from KHOI ";//fix

            // Tạo đối tượng thực thi câu lệnh Select
            DB.st = DB.conn.createStatement();

            // Thực thi 
            DB.rs = DB.st.executeQuery(sql);
            Vector data = null;
            DefaultComboBoxModel cmbModel = new DefaultComboBoxModel();

            // Nếu sách không tồn tại
            if (DB.rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "The KHOI is not available!");//fix
                return;
            }

            // Trong khi chưa hết dữ liệu
            while (DB.rs.next()) {
//                data = new Vector();
//                data.add(DB.rs.getString("MaKhoi"));//fix
//                //data.add(DB.rs.getString("tenkhoa"));//fix
//
//                // Thêm một dòng vào table model
//                cmbModel.addElement(data);
                    String makhoi=DB.rs.getString("MaKhoi");
                    jComboBoxKhoi.addItem(makhoi);
            }

//             jComboBoxKhoi.setModel(cmbModel);

            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (DB.conn != null) {
                    DB.conn.close();
                }
                if (DB.st != null) {
                    DB.st.close();
                }
                if (DB.rs != null) {
                    DB.rs.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
      private void loadHSFillTB(){

      
        try {
            DB.conn = DriverManager.getConnection(DB.dbURL);

            
            // Câu lệnh xem dữ liệu
            String sql = "select * from TIEPNHAN_HS ";
            

            // Tạo đối tượng thực thi câu lệnh Select
            DB.st = DB.conn.createStatement();

            // Thực thi 
            DB.rs = DB.st.executeQuery(sql);
            Vector data = null;

            tblModel.setRowCount(0);
        

            // Trong khi chưa hết dữ liệu
            while (DB.rs.next()) {
                data = new Vector();
                data.add(DB.rs.getString("MaHocSinh"));
                data.add(DB.rs.getString("MANH"));
                data.add(DB.rs.getString("MaKhoi"));
                data.add(DB.rs.getString("HoTen"));
                data.add(DB.rs.getString("GioiTinh"));
                data.add(DB.rs.getString("NgaySinh"));
                data.add(DB.rs.getString("DiaChi"));
                data.add(DB.rs.getString("Email"));
                // Thêm một dòng vào table model
                 tblModel.addRow(data);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (DB.conn != null) {
                    DB.conn.close();
                }
                if (DB.st != null) {
                    DB.st.close();
                }
                if (DB.rs != null) {
                    DB.rs.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
      public static java.sql.Date convertUtilDateToSqlDate(java.util.Date date){
        if(date != null) {
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            return sqlDate;
        }
        return null;
    }
    public static java.util.Date convertSqlDateToUtilDate(java.sql.Date date){
        if(date != null) {
            java.util.Date sqlDate = new java.util.Date(date.getTime());
            return sqlDate;
        }
        return null;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextFieldDiaChi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxNamHoc = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jComboBoxKhoi = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldMaHS = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxGioiTinh = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonThem = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();
        jButtonThoat = new javax.swing.JButton();
        jButtonSua = new javax.swing.JButton();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldHoTen = new javax.swing.JTextField();
        jDateChooserNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTiepNhanHS = new javax.swing.JTable();

        setClosable(true);
        setTitle("Quản Lý Học Sinh thpt Giồng Giềng");

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel1.setText("TIẾP NHẬN HỌC SINH");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setText("Mã Học Sinh");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel13.setText("Khối");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Họ và tên:");

        jTextFieldMaHS.setEditable(false);
        jTextFieldMaHS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMaHSActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel14.setText("Năm Học");

        jComboBoxGioiTinh.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jComboBoxGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Chưa Xác Định" }));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("Ngày sinh:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Giới tính");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("Địa chỉ:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setText("Email:");

        jButtonThem.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Shield 16x16.png"))); // NOI18N
        jButtonThem.setText("THÊM");
        jButtonThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemActionPerformed(evt);
            }
        });

        jButtonXoa.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Erase.png"))); // NOI18N
        jButtonXoa.setText("XÓA");
        jButtonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaActionPerformed(evt);
            }
        });

        jButtonThoat.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Exit.png"))); // NOI18N
        jButtonThoat.setText("THOÁT");
        jButtonThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThoatActionPerformed(evt);
            }
        });

        jButtonSua.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Refresh.png"))); // NOI18N
        jButtonSua.setText("SỬA");
        jButtonSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButtonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSua, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonThoat)
                .addGap(0, 101, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonSua, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jDateChooserNgaySinh.setDateFormatString("dd/MM/yyyy");

        jLabel10.setText("VD a@email.com");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(26, 26, 26)
                                .addComponent(jTextFieldMaHS, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jComboBoxKhoi, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooserNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10))
                            .addComponent(jTextFieldDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldMaHS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBoxKhoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooserNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel7.setText("DANH SÁCH HS NHẬP HỌC");

        jTableTiepNhanHS.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableTiepNhanHS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTiepNhanHSMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableTiepNhanHS);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addGap(42, 42, 42)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(434, 434, 434)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(jLabel9))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaActionPerformed
        // TODO add your handling code here:
        try {
            DB.conn = DriverManager.getConnection(DB.dbURL);
            int index=jTableTiepNhanHS.getSelectedRow();
            String value = jTableTiepNhanHS.getModel().getValueAt(index, 0).toString();
            String update = "UPDATE TIEPNHAN_HS SET MANH=?,MaKhoi=?,HoTen=?,GioiTinh=?,NgaySinh=?,DiaChi=?,Email=? where MaHocSinh='"+value+"'";
            
             DB.ps = DB.conn.prepareStatement(update);
            
           //DB.ps.setString(1,txtMaHS.getText());
           DB.ps.setString(1, (jComboBoxNamHoc.getSelectedItem().toString()));
           DB.ps.setString(2, (jComboBoxKhoi.getSelectedItem().toString()));
           if(jTextFieldHoTen.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(rootPane, "Không thể để trống");
               return;
           }
           String str=jTextFieldHoTen.getText();
          str=str.trim();
            int lenght=str.length();
            for (int i=0;i<10;i++)
                for (int j=0;j<lenght;j++)
                    if(NumArray[i]==str.toCharArray()[j])
                    {
                        JOptionPane.showMessageDialog(rootPane,"Tên không được phép chứa số");
                        return;
                    }
            if (CE.count(str)<2)
              {
                        JOptionPane.showMessageDialog(rootPane,"Tên không được phép có 1 chữ");
                        return;
               } 
            for (int i=0;i<SpecSign.length;i++)
                for (int j=0;j<lenght;j++)
                    if(SpecSign[i]==str.toCharArray()[j])
                    {
                        JOptionPane.showMessageDialog(rootPane,"Tên không được phép chứa kí tự đặc biệt");
                        return;
                    }
           DB.ps.setString(3, str);
           DB.ps.setString(4, (String)jComboBoxGioiTinh.getSelectedItem());
           Date today=new Date(System.currentTimeMillis()); 
           SimpleDateFormat timeFormat= new SimpleDateFormat("yyyy"); 
           int s=Integer.parseInt(timeFormat.format(jDateChooserNgaySinh.getDate())); 
           int n=Integer.parseInt(timeFormat.format(today.getTime()));
           int check=CE.CheckAge(n,s);
           if(check==0)
           {
               JOptionPane.showMessageDialog(null, "Tuổi phải từ 15 đến 18");
               return;
           }
           if(check==-1)
           {
               return;
           }
           DB.ps.setDate(5, convertUtilDateToSqlDate(jDateChooserNgaySinh.getDate()));
           if(jTextFieldHoTen.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(rootPane, "Không thể để trống");
               return;
           }
           DB.ps.setString(6, jTextFieldDiaChi.getText());
           Pattern regex = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");
           Matcher matcher = regex .matcher(jTextFieldEmail.getText());
           if(matcher.matches()==false)
           {
               JOptionPane.showMessageDialog(rootPane, "Email không hợp lệ");
               return;
           }
           DB.ps.setString(7, jTextFieldEmail.getText());
          // DB.ps.setString(9, txtGhiChu.getText());
            
            
                int ret = DB.ps.executeUpdate();
            if ( ret  != -1) {
                JOptionPane.showMessageDialog(null, "Update successed");
       
            }
          
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (DB.conn != null) {
                    DB.conn.close();
                }
                if (DB.st != null) {
                    DB.st.close();
                }
                if (DB.rs != null) {
                    DB.rs.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        loadHSFillTB();
         jTextFieldMaHS.setText("");
         jTextFieldHoTen.setText("");
         jTextFieldDiaChi.setText("");
         jTextFieldEmail.setText("");
    }//GEN-LAST:event_jButtonSuaActionPerformed

    private void jTextFieldMaHSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMaHSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMaHSActionPerformed

    private void jButtonThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThoatActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonThoatActionPerformed

    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaActionPerformed
        // TODO add your handling code here:
        int index = jTableTiepNhanHS.getSelectedRow();
        TableModel model=jTableTiepNhanHS.getModel(); 
        String key=model.getValueAt(index,0).toString();
        String delete="DELETE FROM TIEPNHAN_HS WHERE MaHocSinh='"+key+"'";
       try {
           DB.conn = DriverManager.getConnection(DB.dbURL);
           DB.ps = DB.conn.prepareStatement(delete);
           
            int ret = DB.ps.executeUpdate();
            if (ret != -1) {
                JOptionPane.showMessageDialog(null, "Delete successed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (DB.conn != null) {
                    DB.conn.close();
                }

                if (DB.rs != null) {
                    DB.rs.close();
                }

                if (DB.ps != null) {
                    DB.ps.close();
                }
            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
        loadHSFillTB();
         jTextFieldMaHS.setText("");
         jTextFieldHoTen.setText("");
         jTextFieldDiaChi.setText("");
         jTextFieldEmail.setText("");
    }//GEN-LAST:event_jButtonXoaActionPerformed

    private void jButtonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemActionPerformed
        // TODO add your handling code here:
        loadHSFillTB();
        String insert = "INSERT INTO TIEPNHAN_HS (MaHocSinh,MANH,MaKhoi,HoTen,GioiTinh,NgaySinh,DiaChi,Email) VALUES(?,?,?,?,?,?,?,?)";//fix

       
        
        try {
           DB.conn = DriverManager.getConnection(DB.dbURL);
           DB.ps = DB.conn.prepareStatement(insert);

           //DB.ps.setString(1,txtMaHS.getText());
           DB.ps.setString(1,"");
           DB.ps.setString(2, (jComboBoxNamHoc.getSelectedItem().toString()));
           DB.ps.setString(3, (jComboBoxKhoi.getSelectedItem().toString()));
           if(jTextFieldHoTen.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(rootPane, "Không thể để trống");
               return;
           }
           String str=jTextFieldHoTen.getText();
           str=str.toLowerCase();
           String[] tokens = str.split("\\s");
           str = "";

           for(int i = 0; i < tokens.length; i++){
                char capLetter = Character.toUpperCase(tokens[i].charAt(0));
                str +=  " " + capLetter + tokens[i].substring(1);
            }
            str=str.trim();
            int lenght=str.length();
            for (int i=0;i<10;i++)
                for (int j=0;j<lenght;j++)
                    if(NumArray[i]==str.toCharArray()[j])
                    {
                        JOptionPane.showMessageDialog(rootPane,"Tên không được phép chứa số");
                        return;
                    }
            if (CE.count(str)<2)
              {
                        JOptionPane.showMessageDialog(rootPane,"Tên không được phép có 1 chữ");
                        return;
               } 
            for (int i=0;i<SpecSign.length;i++)
                for (int j=0;j<lenght;j++)
                    if(SpecSign[i]==str.toCharArray()[j])
                    {
                        JOptionPane.showMessageDialog(rootPane,"Tên không được phép chứa kí tự đặc biệt");
                        return;
                    }
           DB.ps.setString(4, str);
           DB.ps.setString(5, (String)jComboBoxGioiTinh.getSelectedItem());
           
           Date today=new Date(System.currentTimeMillis()); 
           SimpleDateFormat timeFormat= new SimpleDateFormat("yyyy"); 
           int s=Integer.parseInt(timeFormat.format(jDateChooserNgaySinh.getDate())); 
           int n=Integer.parseInt(timeFormat.format(today.getTime()));
           int check=CE.CheckAge(n,s);
           if(check==0)
           {
               JOptionPane.showMessageDialog(null, "Tuổi phải từ 15 đến 18");
               return;
           }
           if(check==-1)
           {
               return;
           }
           DB.ps.setDate(6, convertUtilDateToSqlDate(jDateChooserNgaySinh.getDate()));
           if(jTextFieldDiaChi.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(rootPane, "Không thể để trống");
               return;
           }
           DB.ps.setString(7, jTextFieldDiaChi.getText());
           Pattern regex = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");
           Matcher matcher = regex .matcher(jTextFieldEmail.getText());
           if(matcher.matches()==false)
           {
               JOptionPane.showMessageDialog(rootPane, "Email không hợp lệ");
               return;
           }
           DB.ps.setString(8, jTextFieldEmail.getText());
          // DB.ps.setString(9, txtGhiChu.getText());
            

            int ret = DB.ps.executeUpdate();
            if (ret != -1) {
                JOptionPane.showMessageDialog(null, "Insert successed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (DB.conn != null) {
                    DB.conn.close();
                }

                if (DB.rs != null) {
                    DB.rs.close();
                }

                if (DB.ps != null) {
                    DB.ps.close();
                }
            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
        loadHSFillTB();
        jTextFieldMaHS.setText("");
        jTextFieldHoTen.setText("");
        jTextFieldDiaChi.setText("");
        jTextFieldEmail.setText("");
    }//GEN-LAST:event_jButtonThemActionPerformed

    private void jTableTiepNhanHSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTiepNhanHSMouseClicked
        // TODO add your handling code here:
        int index = jTableTiepNhanHS.getSelectedRow();
        TableModel model=jTableTiepNhanHS.getModel();
        
        
        jTextFieldMaHS.setText (model.getValueAt(index,0).toString());
        jComboBoxNamHoc.setSelectedItem(model.getValueAt(index,1).toString());
        jComboBoxKhoi.setSelectedItem(model.getValueAt(index,2).toString());
        jTextFieldHoTen.setText (model.getValueAt(index,3).toString());
        jComboBoxGioiTinh.setSelectedItem(model.getValueAt(index,4).toString());
        try {
            java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(index,5).toString());
            jDateChooserNgaySinh.setDate(date2);
        } catch (ParseException ex) {
            Logger.getLogger(frmTiepNhanHS.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextFieldDiaChi.setText (model.getValueAt(index,6).toString());
        jTextFieldEmail.setText (model.getValueAt(index,7).toString());
        
    }//GEN-LAST:event_jTableTiepNhanHSMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSua;
    private javax.swing.JButton jButtonThem;
    private javax.swing.JButton jButtonThoat;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JComboBox<String> jComboBoxGioiTinh;
    private javax.swing.JComboBox<String> jComboBoxKhoi;
    private javax.swing.JComboBox<String> jComboBoxNamHoc;
    private com.toedter.calendar.JDateChooser jDateChooserNgaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableTiepNhanHS;
    private javax.swing.JTextField jTextFieldDiaChi;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldHoTen;
    private javax.swing.JTextField jTextFieldMaHS;
    // End of variables declaration//GEN-END:variables
}
