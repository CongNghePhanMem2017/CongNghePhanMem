/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancnpm;

import static doancnpm.frmTiepNhanHS.convertUtilDateToSqlDate;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Elitebook
 */
public class TacVu_NhapDiem extends javax.swing.JInternalFrame {
    ConnectDB DB=new ConnectDB();
    private String header[] = {"MHS","Năm Học", "Họ Tên","GT", "Ngày Sinh", "Địa Chỉ", "Email","MaBangDiem","MaLop"};
    private DefaultTableModel tblModel = new DefaultTableModel(header,0);
    private String header1[] = {"MaBangDiem","MaMon","MaNH","HocKy","LoaiKT","Diem"};
    private DefaultTableModel tblModel1 = new DefaultTableModel(header1,0);
    /**
     * Creates new form TacVu_NhapDiem2
     */
    public TacVu_NhapDiem() {
        initComponents();
        loadNamHocAndFillToCBBox();
        LoadKhoiAndFillToCBBox();
        LoadMaLop();
        loadHSbyLop();
        loadMHAndFillToCBBox();
        loadKTAndFillToCBBox();
        loadHKAndFillToCBBox();
        loadBD();;
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
          //  Vector data = null;
          //  DefaultComboBoxModel cmbModel = new DefaultComboBoxModel();

            // Nếu sách không tồn tại
            if (DB.rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "Nam hoc not available!");
                return;
            }

            // Trong khi chưa hết dữ liệu
            while (DB.rs.next()) {
                String MonHoc = DB.rs.getString("MANH");
                jComboBoxNamHoc.addItem(MonHoc);

            }

        //     jComboBoxNamHoc.setModel(cmbModel);

            
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
     private void loadHKAndFillToCBBox(){

        try {
            DB.conn = DriverManager.getConnection(DB.dbURL);

            // Câu lệnh xem dữ liệu
            String sql = "select * from HOCKY ";

            // Tạo đối tượng thực thi câu lệnh Select
            DB.st = DB.conn.createStatement();

            // Thực thi 
            DB.rs = DB.st.executeQuery(sql);
         //   Vector data = null;
          //  DefaultComboBoxModel cmbModel = new DefaultComboBoxModel();

            // Nếu sách không tồn tại
            if (DB.rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "hoc ky not available!");
                return;
            }

            // Trong khi chưa hết dữ liệu
            while (DB.rs.next()) {
                String MaLop = DB.rs.getString("MaHocKy");
                jComboBoxHocKy.addItem(MaLop);

            }

            // jComboBoxHocKy.setModel(cmbModel);

            
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
     private void loadMHAndFillToCBBox(){

        try {
            DB.conn = DriverManager.getConnection(DB.dbURL);

            // Câu lệnh xem dữ liệu
            String sql = "select * from MONHOC ";

            // Tạo đối tượng thực thi câu lệnh Select
            DB.st = DB.conn.createStatement();

            // Thực thi 
            DB.rs = DB.st.executeQuery(sql);
          //  Vector data = null;
          //  DefaultComboBoxModel cmbModel = new DefaultComboBoxModel();

            // Nếu sách không tồn tại
            if (DB.rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "Mon hoc not available!");
                return;
            }

            // Trong khi chưa hết dữ liệu
            while (DB.rs.next()) {
                String MonHoc = DB.rs.getString("MaMonHoc");
                jComboBoxMonHoc.addItem(MonHoc);
            }

           //  jComboBoxMonHoc.setModel(cmbModel);

            
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
     private void loadKTAndFillToCBBox(){

        try {
            DB.conn = DriverManager.getConnection(DB.dbURL);

            // Câu lệnh xem dữ liệu
            String sql = "select * from LOAIKIEMTRA ";

            // Tạo đối tượng thực thi câu lệnh Select
            DB.st = DB.conn.createStatement();

            // Thực thi 
            DB.rs = DB.st.executeQuery(sql);
          //  Vector data = null;
          //  DefaultComboBoxModel cmbModel = new DefaultComboBoxModel();

            // Nếu sách không tồn tại
            if (DB.rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "LOAI KIEM TRA not available!");
                return;
            }

            // Trong khi chưa hết dữ liệu
            while (DB.rs.next()) {
                String kt = DB.rs.getString("MaLoaiKiemTra");
                jComboBoxLoaiKiemTra.addItem(kt);

            }

            //jComboBoxLoaiKiemTra.setModel(cmbModel);

            
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
     private void LoadKhoiAndFillToCBBox() {
     
        try {
            DB.conn = DriverManager.getConnection(DB.dbURL);
            // câu lệnh xem dữ liệu 
            String sql = "select * from KHOI";
            //Tạo đối tượng thực thi câu lệnh
            DB.st = DB.conn.createStatement();
            // thực thi
            DB.rs = DB.st.executeQuery(sql);
            Vector data = null;
            DefaultComboBoxModel cmbModel = new DefaultComboBoxModel();
            // Nếu dan hsach1 không tồn tại 
            if (DB.rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, " The Khoi is not available ! ");
                return;
            }
            // trong khi chư hết dữ  liệu
            while (DB.rs.next()) {
                data = new Vector();
                data.add(DB.rs.getString("MaKhoi"));
                cmbModel.addElement(data);
            }
            jComboBoxKhoi.setModel(cmbModel);
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
      private void LoadMaLop(){
         int index = jComboBoxKhoi.getSelectedIndex();
        if (index < 0) {
            return;
        }
         Vector item = (Vector) jComboBoxKhoi.getSelectedItem();
         String MaKhoi =(item.get(0).toString());
        int k = 0;
        try {
            DB.conn = DriverManager.getConnection(DB.dbURL);
            // câu lệnh xem dữ liệu 
            String sql = "select * from LOP where MaKhoi='"+MaKhoi+"'";
            //Tạo đối tượng thực thi câu lệnh
            DB.st = DB.conn.createStatement();
            // thực thi
            DB.rs = DB.st.executeQuery(sql);
            Vector data = null;
            DefaultComboBoxModel cmbModel = new DefaultComboBoxModel();
            // Nếu dan hsach1 không tồn tại 
            if (DB.rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, " The LOP is not available ! ");
                return;
            }
            // trong khi chư hết dữ  liệu
            while (DB.rs.next()) {
                data = new Vector();
                data.add(DB.rs.getString("MaLop"));
                cmbModel.addElement(data);
          
            }
            
            jComboBoxMaLop.setModel(cmbModel);
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
      private void loadHSbyLop() {
        int index = jComboBoxMaLop.getSelectedIndex();
        if (index < 0) {
            return;
        }
         Vector item = (Vector) jComboBoxMaLop.getSelectedItem();
         String MaLop = (item.get(0).toString());
        int k = 0;
        //System.out.println(MaLop);
        try {
            DB.conn = DriverManager.getConnection(DB.dbURL);
            // câu lệnh xem dư liệu
            String sql = "exec NhapDiem '"+MaLop+"'";
            // tạo đối tượng thực thi câu lênh select
           DB.st = DB.conn.createStatement();
            // Thực thi
            DB.rs = DB.st.executeQuery(sql);
            Vector data = null;
            tblModel.setRowCount(0);
             // Nếu sách không tồn tại
            if (DB.rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "The SinhVien is not available!");
                return;
            }
            //Trong khi chưa hết dữ liệu
            while(DB.rs.next()){
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
                tblModel.addRow(data);
            }
            jTableDSHS.setModel(tblModel); // thêm dữ liệu vào table
             
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
       private void loadBD() {
        
        //System.out.println(MaLop);
        try {
            DB.conn = DriverManager.getConnection(DB.dbURL);
            // câu lệnh xem dư liệu
            String sql = "select * from CT_BANGDIEM";
            // tạo đối tượng thực thi câu lênh select
           DB.st = DB.conn.createStatement();
            // Thực thi
            DB.rs = DB.st.executeQuery(sql);
            Vector data = null;
            tblModel1.setRowCount(0);
             // Nếu sách không tồn tại
            if (DB.rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "Bang Diem is not available!");
                return;
            }
            //Trong khi chưa hết dữ liệu
            while(DB.rs.next()){
                data = new Vector();
                data.add(DB.rs.getInt("MaBangDiem"));

                data.add(DB.rs.getString("MaMonHoc"));

                data.add(DB.rs.getString("MANH"));
                data.add(DB.rs.getString("MaHocKy"));
                data.add(DB.rs.getString("MaLoaiKiemTra"));
                data.add(DB.rs.getFloat("Diem"));

                tblModel1.addRow(data);
            }
            jTableNhapDiem.setModel(tblModel1); // thêm dữ liệu vào table
             
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxNamHoc = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox_NamHoc = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxKhoi = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxMaLop = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMaHocSinh = new javax.swing.JTextField();
        txtTenHocSinh = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtMaBangDiem = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jComboBoxLoaiKiemTra = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jComboBoxHocKy = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        txtDiem = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        txtLop = new javax.swing.JTextField();
        jComboBoxMonHoc = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableNhapDiem = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDSHS = new javax.swing.JTable();

        setClosable(true);
        setResizable(true);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc Ra Danh Sách Học Sinh "));
        jPanel3.setForeground(new java.awt.Color(153, 204, 255));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Mã Khối");

        jButton1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton1.setText(">> LỌC >>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Mã Học Sinh");

        jTextField1.setText(" ");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Tên Học Sinh");

        jButton2.setText("TÌM KIẾM");

        jComboBox_NamHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_NamHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_NamHocActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Mã Lớp");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("Năm Học");

        jComboBoxKhoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxKhoiActionPerformed(evt);
            }
        });

        jComboBoxMaLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMaLopActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setText("Mã Lớp");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1063, 1063, 1063)
                        .addComponent(jButton1)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jComboBoxKhoi, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jComboBoxMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_NamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox_NamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxKhoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel7))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton2)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("NHẬP ĐIỂM CHO HỌC SINH"));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setText("Tên Học Sinh");

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel14.setText("Mã Học Sinh ");

        jTextField7.setText("jTextField7");

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel17.setText("Lớp");

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel18.setText("Học Kỳ");

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel19.setText("Loại Kiểm Tra");

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel20.setText("Điểm");

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel16.setText("Mã Bảng Điểm");

        jLabel21.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel21.setText("Mã Môn Học");

        jButton3.setText("Clean");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("THOÁT");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("NHẬP ");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("SỬA");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxLoaiKiemTra, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBoxHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenHocSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaHocSinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtLop, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                    .addComponent(jComboBoxMonHoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(txtMaBangDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(499, 499, 499)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaBangDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaHocSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(txtLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTenHocSinh, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel19))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel18)
                                            .addComponent(jComboBoxHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jComboBoxLoaiKiemTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DANH HS VỪA NHẬP ĐIỂM"));

        jTableNhapDiem.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableNhapDiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableNhapDiemMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableNhapDiem);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DANH SÁCH HỌC SINH"));

        jTableDSHS.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableDSHS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDSHSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDSHS);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox_NamHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_NamHocActionPerformed

    }//GEN-LAST:event_jComboBox_NamHocActionPerformed

    private void jComboBoxKhoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxKhoiActionPerformed
        // TODO add your handling code here:
        jComboBoxMaLop.removeAllItems();
      
        LoadMaLop();
    }//GEN-LAST:event_jComboBoxKhoiActionPerformed

    private void jComboBoxMaLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMaLopActionPerformed
        // TODO add your handling code here:
        loadHSbyLop();
    }//GEN-LAST:event_jComboBoxMaLopActionPerformed

    private void jTableDSHSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDSHSMouseClicked
        // TODO add your handling code here:
         int index = jTableDSHS.getSelectedRow();
        TableModel model=jTableDSHS.getModel();
        
        
        txtMaBangDiem.setText (model.getValueAt(index,7).toString());
        txtMaHocSinh.setText(model.getValueAt(index,0).toString());
        txtTenHocSinh.setText(model.getValueAt(index,2).toString());
        txtLop.setText (model.getValueAt(index,8).toString());
        
    }//GEN-LAST:event_jTableDSHSMouseClicked

    private void jTableNhapDiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableNhapDiemMouseClicked
        // TODO add your handling code here:
        String MaHS=null;
        String Ten=null;
        String Lop=null;
       
        int index = jTableNhapDiem.getSelectedRow();
        TableModel model=jTableNhapDiem.getModel();
        try {
            DB.conn = DriverManager.getConnection(DB.dbURL);
            

            // Câu lệnh xem dữ liệu
            String sql = "exec fillNhapDiem "+model.getValueAt(index,0);

            // Tạo đối tượng thực thi câu lệnh Select
            DB.st = DB.conn.createStatement();

            // Thực thi 
            DB.rs = DB.st.executeQuery(sql);
         
            // Nếu sách không tồn tại
            if (DB.rs.isBeforeFirst() == false) {
                return;
            }

            // Trong khi chưa hết dữ liệu
            while (DB.rs.next()) {
                MaHS=DB.rs.getString("MaHocSinh").toString();
                Ten=DB.rs.getString("HoTen");
                Lop=DB.rs.getString("MaLop");
                
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
        
        txtMaHocSinh.setText(MaHS);
        jComboBoxNamHoc.setSelectedItem(model.getValueAt(index,2).toString());
        txtTenHocSinh.setText(Ten);
        txtMaBangDiem.setText (model.getValueAt(index,0).toString());
        jComboBoxLoaiKiemTra.setSelectedItem(model.getValueAt(index,4).toString());
        txtDiem.setText(model.getValueAt(index,5).toString());
        txtLop.setText (Lop);
        jComboBoxMonHoc.setSelectedItem(model.getValueAt(index,1).toString());
        jComboBoxHocKy.setSelectedItem(model.getValueAt(index,3).toString());  
    }//GEN-LAST:event_jTableNhapDiemMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String insert = "INSERT INTO CT_BANGDIEM (MaBangDiem,MaMonHoc,MANH,MaHocKy,MaLoaiKiemTra,Diem) VALUES(?,?,?,?,?,?)";//fix        

        try {
           DB.conn = DriverManager.getConnection(DB.dbURL);
           DB.ps = DB.conn.prepareStatement(insert);

           //DB.ps.setString(1,txtMaHS.getText());
           DB.ps.setInt(1, Integer.parseInt(txtMaBangDiem.getText()));
           DB.ps.setString(2, (jComboBoxMonHoc.getSelectedItem().toString()));
           DB.ps.setString(3, (jComboBoxNamHoc.getSelectedItem().toString()));
           DB.ps.setString(4, (jComboBoxHocKy.getSelectedItem().toString()));
           System.out.println(jComboBoxHocKy.getSelectedItem().toString());
           DB.ps.setString(5,(jComboBoxLoaiKiemTra.getSelectedItem().toString()));
           DB.ps.setFloat(6, Integer.parseInt(txtDiem.getText()));
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
        loadBD();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        String insert = "update CT_BANGDIEM set MaMonHoc=?,MANH=?,MaHocKy=?,MaLoaiKiemTra=?,Diem=? where MaBangDiem=?";//fix        

        try {
           DB.conn = DriverManager.getConnection(DB.dbURL);
           DB.ps = DB.conn.prepareStatement(insert);

           //DB.ps.setString(1,txtMaHS.getText());
           DB.ps.setInt(6, Integer.parseInt(txtMaBangDiem.getText()));
           DB.ps.setString(1, (jComboBoxMonHoc.getSelectedItem().toString()));
           DB.ps.setString(2, (jComboBoxNamHoc.getSelectedItem().toString()));
           DB.ps.setString(3, (jComboBoxHocKy.getSelectedItem().toString()));
           DB.ps.setString(4,(jComboBoxLoaiKiemTra.getSelectedItem().toString()));
           DB.ps.setFloat(5, Integer.parseInt(txtDiem.getText()));
          // DB.ps.setString(9, txtGhiChu.getText());
            

            int ret = DB.ps.executeUpdate();
            if (ret != -1) {
                JOptionPane.showMessageDialog(null, "Update successed");
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
        loadBD();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        txtMaBangDiem.setText("");
        txtLop.setText("");
        txtDiem.setText("");
        txtMaHocSinh.setText("");
        txtTenHocSinh.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBoxHocKy;
    private javax.swing.JComboBox<String> jComboBoxKhoi;
    private javax.swing.JComboBox<String> jComboBoxLoaiKiemTra;
    private javax.swing.JComboBox<String> jComboBoxMaLop;
    private javax.swing.JComboBox<String> jComboBoxMonHoc;
    private javax.swing.JComboBox<String> jComboBoxNamHoc;
    private javax.swing.JComboBox<String> jComboBox_NamHoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableDSHS;
    private javax.swing.JTable jTableNhapDiem;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtLop;
    private javax.swing.JTextField txtMaBangDiem;
    private javax.swing.JTextField txtMaHocSinh;
    private javax.swing.JTextField txtTenHocSinh;
    // End of variables declaration//GEN-END:variables
}