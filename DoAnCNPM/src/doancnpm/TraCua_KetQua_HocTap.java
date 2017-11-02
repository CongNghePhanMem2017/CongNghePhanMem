/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancnpm;

import java.sql.DriverManager;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Elitebook
 */
public class TraCua_KetQua_HocTap extends javax.swing.JInternalFrame {

     DefaultTableModel T =new DefaultTableModel();
    ConnectDB DB = new ConnectDB();
    //Bảng điểm tổng kết
    private String header[] = {"Mã Học Sinh", "Họ Tên", "Giới Tính", "Lớp", "TB_HọcKỳ_I", "TB_HọcKỳ_II", "Tổng Kết"};
    private DefaultTableModel tblMode = new DefaultTableModel(header, 0);
    //Bảng điểm học sinh  
    private String header_BangDiem[] = {"Môn Học", "Loại Kiểm Tra", "Điểm"};
    private DefaultTableModel tblMode_BangDiem = new DefaultTableModel(header_BangDiem, 0);
    private String header_loc[] = {"MHS","Năm Học", "Họ Tên","GT", "Ngày Sinh", "Địa Chỉ", "Email","Mã Bảng Điểm","Mã Lớp"};
    private DefaultTableModel tblModel_loc = new DefaultTableModel(header_loc,0);
   

    
    public TraCua_KetQua_HocTap() {
        initComponents();
        JOptionPane.showMessageDialog(this, "Vui Lòng Lọc Dữ Liệu Để Xem Điểm Nhé !");

    }

    // tính điểm Tổng kết cả năm
    private void DiemTongKetNamHoc() {
      
        String MaBangDiem = "";
        MaBangDiem = txtMaBangDiem.getText();       // Lấy Mã Bảng Điểm
        try {
            DB.conn = DriverManager.getConnection(DB.dbURL);
            // câu lệnh xem dư liệu
            String DiemTongKetNamHoc = "EXEC DiemTongKetNamHoc '" + MaBangDiem + "'";
            // tạo đối tượng thực thi câu lênh select
            DB.st = DB.conn.createStatement();
            // Thực thi
            DB.rs = DB.st.executeQuery(DiemTongKetNamHoc);
            Vector data = null;
            tblMode.setRowCount(0);

            if (DB.rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "Không Tìm Thấy Kết Qủa , Vui Lòng Nhập Đúng Mã Nha !");
                  DefaultTableModel model=(DefaultTableModel) jTable_DiemTB_CaNam.getModel();
                 model.setRowCount(0);
                return;
            }   // Trong khi chưa hết dữ liệu
            //Trong khi chưa hết dữ liệu
            while (DB.rs.next()) {
                data = new Vector();
                data.add(DB.rs.getString("MaHocSinh"));
                data.add(DB.rs.getString("HoTen"));
                data.add(DB.rs.getString("GioiTinh"));
                data.add(DB.rs.getString("TenLop"));
                data.add(DB.rs.getString("TB_HK1"));
                data.add(DB.rs.getString("TB_HK2"));
                data.add(DB.rs.getString("TongKet"));
                // Thêm một dòng vào table model
                tblMode.addRow(data);
            }
            jTable_DiemTB_CaNam.setModel(tblMode); // thêm dữ liệu vào table 
            
           
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

    // mô tả nÈ : Hàm này dùng để tính điểm của học sinh ở từng học kỳ
    private void BangDiemHocSinh() {

        jTable_BangDiemHocSinh.setModel(tblMode);
        String MaBangDiem = "";                      //Lấy Mã Bảng Điêm
        MaBangDiem = txtMaBangDiem.getText();
        String MaHocKy = "";                         // Lấy Mã Học Kỳ
           MaHocKy= jComboBox_HoKy.getSelectedItem().toString();
           
        try {
            DB.conn = DriverManager.getConnection(DB.dbURL);
            // câu lệnh xem dư liệu
            String DiemTongKetNamHoc = "exec DiemChiTietTungMon '"+MaBangDiem+"', '"+MaHocKy+"'";
            // tạo đối tượng thực thi câu lênh select
            DB.st = DB.conn.createStatement();
            // Thực thi
            DB.rs = DB.st.executeQuery(DiemTongKetNamHoc);
            Vector data = null;
            tblMode.setRowCount(0);

            if (DB.rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "Không Tìm Thấy Kết Qủa , Vui Lòng Nhập Đúng Mã Nha !");
                  DefaultTableModel model=(DefaultTableModel) jTable_BangDiemHocSinh.getModel();
                  model.setRowCount(0);
                  return;
            }   // Trong khi chưa hết dữ liệu
            //Trong khi chưa hết dữ liệu
            while (DB.rs.next()) {
                data = new Vector();
                data.add(DB.rs.getString("MaMonHoc"));
                data.add(DB.rs.getString("MaLoaiKiemTra"));
                data.add(DB.rs.getString("Diem"));
                // Thêm một dòng vào table model
                tblMode_BangDiem.addRow(data);
            }
            jTable_BangDiemHocSinh.setModel(tblMode_BangDiem); // thêm dữ liệu vào table 
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
    
    // load thông tin học sinh khi tra điểm 
      private void loadHSbyValue() {
        int index = jComboBoxMenu.getSelectedIndex();
        if (index < 0) {
            return;
        } 
        if(jTextFieldThongTin.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(rootPane, "Không thể để trống");
               return;
           }
         String Value = jComboBoxMenu.getSelectedItem().toString();
       try {
           DB.conn = DriverManager.getConnection(DB.dbURL); 
           
            if(Value.equals("Mã học sinh"))
            {

               String sql = "EXEC XuatTongTinMHS '"+jTextFieldThongTin.getText()+"' ";
                 DB.st = DB.conn.createStatement();
                DB.rs = DB.st.executeQuery(sql);
                   Vector data = null;

            tblModel_loc.setRowCount(0);
            if (DB.rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this,"Không Tìm thấy ! ");
            }

            // Trong khi chưa hết dữ liệu
            while (DB.rs.next()) {
                data = new Vector();
                data.add(DB.rs.getString("MaHocSinh"));
                data.add(DB.rs.getString("MANH"));
                data.add(DB.rs.getString("HoTen"));
                data.add(DB.rs.getString("GioiTinh"));
                data.add(DB.rs.getString("NgaySinh"));
                data.add(DB.rs.getString("DiaChi"));
                data.add(DB.rs.getString("Email"));
                data.add(DB.rs.getString("MaBangDiem"));
                data.add(DB.rs.getString("MaLop"));
                // Thêm một dòng vào table model
                 tblModel_loc.addRow(data);
            }
            jTableLoc.setModel(tblModel_loc);
            }
            
            // TÌM THEO TÊN HỌC SINH
           else
            {
                System.out.println(jTextFieldThongTin.getText().toString());
               String sql = "exec XuatThongTin   N'" + jTextFieldThongTin.getText() + "' ";
                 DB.st = DB.conn.createStatement();
                DB.rs = DB.st.executeQuery(sql);
                   Vector data = null;

            tblModel_loc.setRowCount(0); 
             if (DB.rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this,"Không Tìm thấy ! ");
            }
            // Trong khi chưa hết dữ liệu
            while (DB.rs.next()) {
                data = new Vector();
                data.add(DB.rs.getString("MaHocSinh"));
                data.add(DB.rs.getString("MANH"));
                data.add(DB.rs.getString("HoTen"));
                data.add(DB.rs.getString("GioiTinh"));
                data.add(DB.rs.getString("NgaySinh"));
                data.add(DB.rs.getString("DiaChi"));
                data.add(DB.rs.getString("Email"));
                data.add(DB.rs.getString("MaBangDiem"));
                data.add(DB.rs.getString("MaLop"));
                // Thêm một dòng vào table model
                 tblModel_loc.addRow(data);
            }
            jTableLoc.setModel(tblModel_loc);
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtMaBangDiem = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox_HoKy = new javax.swing.JComboBox<>();
        jButton_XemDiemTB = new javax.swing.JButton();
        jButton_Thoat2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_BangDiemHocSinh = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_DiemTB_CaNam = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButtonLoc = new javax.swing.JButton();
        jComboBoxMenu = new javax.swing.JComboBox<>();
        jTextFieldThongTin = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableLoc = new javax.swing.JTable();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        setClosable(true);
        setTitle("Tra Cứu");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc Dữ Liệu Để Xem "));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Mã Bảng Điểm ");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Học Kỳ");

        jComboBox_HoKy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HK1", "HK2" }));
        jComboBox_HoKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_HoKyActionPerformed(evt);
            }
        });

        jButton_XemDiemTB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Find.png"))); // NOI18N
        jButton_XemDiemTB.setText("Xem Điểm TB");
        jButton_XemDiemTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XemDiemTBActionPerformed(evt);
            }
        });

        jButton_Thoat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Exit.png"))); // NOI18N
        jButton_Thoat2.setText("Thoát");
        jButton_Thoat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Thoat2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMaBangDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5))
                    .addComponent(jButton_XemDiemTB, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox_HoKy, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Thoat2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaBangDiem)
                    .addComponent(jComboBox_HoKy, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_XemDiemTB, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Thoat2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Bảng Điểm "));

        jTable_BangDiemHocSinh.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_BangDiemHocSinh);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Điểm Tổng Kết"));

        jTable_DiemTB_CaNam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null", "Title 6"
            }
        ));
        jScrollPane4.setViewportView(jTable_DiemTB_CaNam);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tra Cứu Thông Tin Học Sinh"));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm Theo"));

        jButtonLoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/View.png"))); // NOI18N
        jButtonLoc.setText("Lọc");
        jButtonLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLocActionPerformed(evt);
            }
        });

        jComboBoxMenu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã học sinh", "Tên học sinh" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jComboBoxMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldThongTin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jTableLoc.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jTableLoc);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(557, 557, 557)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(194, 194, 194))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 627, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(994, 994, 994))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_HoKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_HoKyActionPerformed
               if(txtMaBangDiem.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(rootPane, "Không thể để trống");
               return;
           }
          DefaultTableModel model=(DefaultTableModel) jTable_BangDiemHocSinh.getModel();
         model.setRowCount(0);
          BangDiemHocSinh();

    }//GEN-LAST:event_jComboBox_HoKyActionPerformed

    private void jButton_XemDiemTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XemDiemTBActionPerformed
       if(txtMaBangDiem.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(rootPane, "Không thể để trống");
               return;
           }
        DiemTongKetNamHoc();

    }//GEN-LAST:event_jButton_XemDiemTBActionPerformed

    private void jButton_Thoat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Thoat2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton_Thoat2ActionPerformed

    private void jButtonLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLocActionPerformed
        // TODO add your handling code here:
        loadHSbyValue();
    }//GEN-LAST:event_jButtonLocActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLoc;
    private javax.swing.JButton jButton_Thoat2;
    private javax.swing.JButton jButton_XemDiemTB;
    private javax.swing.JComboBox<String> jComboBoxMenu;
    private javax.swing.JComboBox<String> jComboBox_HoKy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTableLoc;
    private javax.swing.JTable jTable_BangDiemHocSinh;
    private javax.swing.JTable jTable_DiemTB_CaNam;
    private javax.swing.JTextField jTextFieldThongTin;
    private javax.swing.JTextField txtMaBangDiem;
    // End of variables declaration//GEN-END:variables
}
