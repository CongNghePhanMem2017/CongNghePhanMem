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
    private String header[] = {"MHS","Năm Học", "Họ Tên","GT","MaBangDiem","MaLop"};
    private DefaultTableModel tblModel = new DefaultTableModel(header,0);
    private String header1[] = {"MaBangDiem","MaMon","HocKy","LoaiKT","Diem","MaCT_BANGDIEM"};
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
        loadBD();
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
               // JOptionPane.showMessageDialog(this, "The SinhVien is not available!");
                return;
            }
            //Trong khi chưa hết dữ liệu
            while(DB.rs.next()){
                data = new Vector();
                data.add(DB.rs.getString("MaHocSinh"));

                data.add(DB.rs.getString("MANH"));

                data.add(DB.rs.getString("HoTen"));
                data.add(DB.rs.getString("GioiTinh"));
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
               // JOptionPane.showMessageDialog(this, "Bang Diem is not available!");
                return;
            }
            //Trong khi chưa hết dữ liệu
            while(DB.rs.next()){
                data = new Vector();
                data.add(DB.rs.getString("MaBangDiem"));

                data.add(DB.rs.getString("MaMonHoc"));

                
                data.add(DB.rs.getString("MaHocKy"));
                data.add(DB.rs.getString("MaLoaiKiemTra"));
                data.add(DB.rs.getFloat("Diem"));
                data.add(DB.rs.getInt("MaCT_BANGDIEM"));

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
        jButtonXoaVaClean = new javax.swing.JButton();
        jButtonThoat = new javax.swing.JButton();
        jButton_NhapDiemChoHS = new javax.swing.JButton();
        jButtonSua = new javax.swing.JButton();
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

        txtMaHocSinh.setEditable(false);

        txtTenHocSinh.setEditable(false);

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel14.setText("Mã Học Sinh ");

        txtMaBangDiem.setEditable(false);

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

        jButtonXoaVaClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Diagram.png"))); // NOI18N
        jButtonXoaVaClean.setText("Xóa & Clean");
        jButtonXoaVaClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaVaCleanActionPerformed(evt);
            }
        });

        jButtonThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Erase.png"))); // NOI18N
        jButtonThoat.setText("THOÁT");
        jButtonThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThoatActionPerformed(evt);
            }
        });

        jButton_NhapDiemChoHS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Create.png"))); // NOI18N
        jButton_NhapDiemChoHS.setText("NHẬP ");
        jButton_NhapDiemChoHS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NhapDiemChoHSActionPerformed(evt);
            }
        });

        jButtonSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Redo.png"))); // NOI18N
        jButtonSua.setText("SỬA");
        jButtonSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_NhapDiemChoHS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonXoaVaClean)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonThoat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonXoaVaClean, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_NhapDiemChoHS, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSua, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        txtLop.setEditable(false);

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
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxLoaiKiemTra, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jComboBoxMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(266, 266, 266))))
                            .addComponent(txtMaBangDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenHocSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaHocSinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLop, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(jLabel14))
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
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jComboBoxLoaiKiemTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 691, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableDSHSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDSHSMouseClicked
        // TODO add your handling code here:
         int index = jTableDSHS.getSelectedRow();
        TableModel model=jTableDSHS.getModel();
        
        
        txtMaBangDiem.setText (model.getValueAt(index,4).toString());
        txtMaHocSinh.setText(model.getValueAt(index,0).toString());
        txtTenHocSinh.setText(model.getValueAt(index,2).toString());
        txtLop.setText (model.getValueAt(index,5).toString());
        
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
                MaHS=DB.rs.getString("MaHocSinh");
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
       // jComboBoxNamHoc.setSelectedItem(model.getValueAt(index,2).toString());
        txtTenHocSinh.setText(Ten);
        txtMaBangDiem.setText (model.getValueAt(index,0).toString());
        jComboBoxLoaiKiemTra.setSelectedItem(model.getValueAt(index,3).toString());
        txtDiem.setText(model.getValueAt(index,4).toString());
        txtLop.setText (Lop);
        jComboBoxMonHoc.setSelectedItem(model.getValueAt(index,1).toString());
        jComboBoxHocKy.setSelectedItem(model.getValueAt(index,2).toString());

        
    }//GEN-LAST:event_jTableNhapDiemMouseClicked

        
    private void TinhDiemTBMon(){
         // lấy mã bảng điểm
        int MaBangDiem = 0;
             MaBangDiem = Integer.parseInt(txtMaBangDiem.getText());
        // lấy mã học kỳ
         String MaHocKy = "";
            MaHocKy = jComboBoxHocKy.getSelectedItem().toString();
       // lấy mã môn
       String MaMonHoc = "";
            MaMonHoc = jComboBoxMonHoc.getSelectedItem().toString();    
        // Lấy mã học kỳ
        String MaLoaiKT = "" ;
           MaLoaiKT=jComboBoxLoaiKiemTra.getSelectedItem().toString();
        // Hàm tính điểm 
        try {
          String  insert = "INSERT INTO B_P_Sinh_QL_DiemTB_Mon (MaBangDiem,MaMonHoc,MaHocKy) VALUES(?,?,?)";//fix        
            DB.ps.setInt (1, Integer.parseInt(txtMaBangDiem.getText()));
            DB.ps.setString(2, (jComboBoxMonHoc.getSelectedItem().toString()));
            DB.ps.setString(3, (jComboBoxHocKy.getSelectedItem().toString()));     
         
            DB.ps = DB.conn.prepareStatement(insert);
            
            int ret = DB.ps.executeUpdate();
            if ( ret  != -1) {
                JOptionPane.showMessageDialog(null, " Da insert vao bang tinh diem tb ");
            }     
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, " Không thể insert vao bang tinh diem tb ");
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
    
//           // Cặp nhật lại ds BANG_PHAT_SINH_QL_DIEM để tiến hành update điểm tb môn
//             // lấy mã bảng điểm
//       
//        
            
//            String luuBangTB_Mon = "INSERT INTO B_P_Sinh_QL_DiemTB_Mon (MaBangDiem,MaMonHoc,MaHocKy) VALUES(?,?,?)";
//             DB.ps = DB.conn.prepareStatement(luuBangTB_Mon);
//             
//                DB.ps.setInt(1, Integer.parseInt(txtMaBangDiem.getText()));
//                DB.ps.setString(2, (jComboBoxMonHoc.getSelectedItem().toString()));
//                DB.ps.setString(3, (jComboBoxHocKy.getSelectedItem().toString()));      
//                int ret2 = DB.ps.executeUpdate();
//            if (ret2 != -1) {
//                JOptionPane.showMessageDialog(null, "Dang Cho Tinh Diem TB ");
//            }
//        //  TinhDiemTBMon();
//            
    
    private void jButton_NhapDiemChoHSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NhapDiemChoHSActionPerformed
          String insert = "INSERT INTO CT_BANGDIEM (MaBangDiem,MaMonHoc,MaHocKy,MaLoaiKiemTra,Diem) VALUES(?,?,?,?,?)";
        try {
           DB.conn = DriverManager.getConnection(DB.dbURL);
           DB.ps = DB.conn.prepareStatement(insert);

           DB.ps.setString(1, txtMaBangDiem.getText());
           DB.ps.setString(2, (jComboBoxMonHoc.getSelectedItem().toString()));
           DB.ps.setString(3, (jComboBoxHocKy.getSelectedItem().toString()));
           
           DB.ps.setString(4,(jComboBoxLoaiKiemTra.getSelectedItem().toString()));
           if(txtDiem.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(rootPane, "Không thể để trống");
               return;
           }
           if (Float.parseFloat(txtDiem.getText())<0 || Float.parseFloat(txtDiem.getText())>10 )
           {
               JOptionPane.showMessageDialog(this,"Điểm phải từ 0  đến 10 ");
               return ; 
           }
           DB.ps.setFloat(5,Float.parseFloat(txtDiem.getText()));
            
           
            int ret = DB.ps.executeUpdate();
            if (ret != -1) {
                JOptionPane.showMessageDialog(null, "Insert điểm thành công");
            }
            String luuBangTB_Mon = "INSERT INTO B_P_Sinh_QL_DiemTB_Mon (MaBangDiem,MaMonHoc,MaHocKy) VALUES(?,?,?)";
            DB.ps = DB.conn.prepareStatement(luuBangTB_Mon);  
                DB.ps.setString(1, txtMaBangDiem.getText());
                DB.ps.setString(2, (jComboBoxMonHoc.getSelectedItem().toString()));
                DB.ps.setString(3, (jComboBoxHocKy.getSelectedItem().toString()));      
  
        } catch (Exception e) {
           // e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Insert điểm  không thành công");
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
            // tính điêm tb / mon  nek
            String    MaBangDiem = "";
                MaBangDiem = txtMaBangDiem.getText();
            String MaHocKy = "";
                MaHocKy = jComboBoxHocKy.getSelectedItem().toString();
            String MaMonHoc = "";
                MaMonHoc = jComboBoxMonHoc.getSelectedItem().toString();
           // tính điêm tb / mon  nek
            try {
                 String UpDate_DiemTB_Mon = "exec UpDate_DiemTB_Mon  '"+MaBangDiem+"','"+MaHocKy+"','"+MaMonHoc+"'";
 
                        DB.conn = DriverManager.getConnection(DB.dbURL);
                        DB.st = DB.conn.createStatement();
                        // Thực thi
                        DB.rs = DB.st.executeQuery(UpDate_DiemTB_Mon);
                        JOptionPane.showMessageDialog(this, "Đã Tính_DiemTB_Môn thành công !  "); 
            } catch (Exception e) {
               //  JOptionPane.showMessageDialog(this, "Lỗi_DiemTB_Mon !   "); 
            }   
            
            // TÍNH ĐIỂM TỔNG  KẾT MÔN /NĂM HỌC
            try {
                 String UpDate_DiemTB_Mon = " exec UPDATEDiem_Tong_Ket_Mon '"+MaBangDiem+"', '"+MaMonHoc+"'";
                        DB.conn = DriverManager.getConnection(DB.dbURL);
                        DB.st = DB.conn.createStatement();
                        // Thực thi
                        DB.rs = DB.st.executeQuery(UpDate_DiemTB_Mon);
                        JOptionPane.showMessageDialog(this, "Đã  TÍNH Diem_Tong_Ket_Mon thành công !  "); 
            } catch (Exception e) {
               //  JOptionPane.showMessageDialog(this, "Lỗi_DiemTB_Mon !   "); 
            }   
            // Tính điêm tổng kết năm học cho 1 hs nè
            try {
                 String UpDate_DiemTB_Mon = "EXEC UPDATE_B_P_Sinh_KetQuaHocTap '"+MaBangDiem+"'";
                        DB.conn = DriverManager.getConnection(DB.dbURL);
                        DB.st = DB.conn.createStatement();
                        // Thực thi
                        DB.rs = DB.st.executeQuery(UpDate_DiemTB_Mon);
                      //  JOptionPane.showMessageDialog(this, "Đã  TÍNH Diem tb Năm của 1 hs  thành công !  "); 
            } catch (Exception e) {
               //  JOptionPane.showMessageDialog(this, "Lỗi_DiemTB_Mon !   "); 
            }   
            //B_P_Sinh_TB_HK_CuaHS_ TINH DIEM TB HOC KY HK1, HK2 NEK
            try {
                 String UpDate_DiemTB_HK = "exec Insert_B_P_Sinh_TB_HK '"+MaBangDiem+"'";
                        DB.conn = DriverManager.getConnection(DB.dbURL);
                        DB.st = DB.conn.createStatement();
                        // Thực thi
                        DB.rs = DB.st.executeQuery(UpDate_DiemTB_HK);
                      //  JOptionPane.showMessageDialog(this, "Đã  TÍNH Diem tb Năm của 1 hs  thành công !  "); 
            } catch (Exception e) {
               //  JOptionPane.showMessageDialog(this, "Lỗi_DiemTB_Mon !   "); 
            }   
            // Tính điểm tổng kết năm học cua 1 hs 
             try {
                 String tongketnamhoc = "EXEC DiemTongKetNamHoc  '"+MaBangDiem+"'";
                        DB.conn = DriverManager.getConnection(DB.dbURL);
                        DB.st = DB.conn.createStatement();
                        // Thực thi
                        DB.rs = DB.st.executeQuery(tongketnamhoc);
                      //  JOptionPane.showMessageDialog(this, "Đã  TÍNH Diem tb Năm của 1 hs  thành công !  "); 
            } catch (Exception e) {
               //  JOptionPane.showMessageDialog(this, "Lỗi_DiemTB_Mon !   "); 
            }   
            // update kết qua2 học tập  hk1, hk2 
            try {
                 String tongketnamhoc = "EXEC UPDATEDiem_KetQuaHocTap  '"+MaBangDiem+"', '"+MaHocKy+"'";
                        DB.conn = DriverManager.getConnection(DB.dbURL);
                        DB.st = DB.conn.createStatement();
                        // Thực thi
                        DB.rs = DB.st.executeQuery(tongketnamhoc);
                       
            } catch (Exception e) {
               // JOptionPane.showMessageDialog(this, "Lỗi_DiemTB_HocKy !   "); 
            }   
        } 

        loadBD();
    }//GEN-LAST:event_jButton_NhapDiemChoHSActionPerformed

    private void jButtonSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaActionPerformed
        // TODO add your handling code here:
        String update = "update CT_BANGDIEM set MaMonHoc=?,MaHocKy=?,MaLoaiKiemTra=?,Diem=? where MaCT_BANGDIEM=?";//fix        
         int index = jTableNhapDiem.getSelectedRow();
        TableModel model=jTableNhapDiem.getModel();
        try {
           DB.conn = DriverManager.getConnection(DB.dbURL);
           DB.ps = DB.conn.prepareStatement(update);
           //DB.ps.setString(1,txtMaHS.getText());
          // DB.ps.setInt(6, Integer.parseInt(txtMaBangDiem.getText()));
           DB.ps.setString(1, (jComboBoxMonHoc.getSelectedItem().toString()));
          // DB.ps.setString(2, (jComboBoxNamHoc.getSelectedItem().toString()));
           DB.ps.setString(2, (jComboBoxHocKy.getSelectedItem().toString()));
           DB.ps.setString(3,(jComboBoxLoaiKiemTra.getSelectedItem().toString()));
           if(txtDiem.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(rootPane, "Không thể để trống");
               return;
           }
           DB.ps.setFloat(4, Float.parseFloat(txtDiem.getText()));
           DB.ps.setString(5,model.getValueAt(index,5).toString());
            
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
    }//GEN-LAST:event_jButtonSuaActionPerformed

    private void jButtonXoaVaCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaVaCleanActionPerformed
        // TODO add your handling code here:
         int index = jTableNhapDiem.getSelectedRow();
        TableModel model=jTableNhapDiem.getModel(); 
        String key=model.getValueAt(index,5).toString();
        String delete="DELETE FROM CT_BANGDIEM WHERE MaCT_BangDiem='"+key+"'";
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
        loadBD();
        txtMaBangDiem.setText("");
        txtLop.setText("");
        txtDiem.setText("");
        txtMaHocSinh.setText("");
        txtTenHocSinh.setText("");
    }//GEN-LAST:event_jButtonXoaVaCleanActionPerformed

    private void jButtonThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThoatActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonThoatActionPerformed

    private void jComboBoxMaLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMaLopActionPerformed
        // TODO add your handling code here:
        loadHSbyLop();
    }//GEN-LAST:event_jComboBoxMaLopActionPerformed

    private void jComboBoxKhoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxKhoiActionPerformed
        // TODO add your handling code here:
        jComboBoxMaLop.removeAllItems();

        LoadMaLop();
    }//GEN-LAST:event_jComboBoxKhoiActionPerformed

    private void jComboBox_NamHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_NamHocActionPerformed

    }//GEN-LAST:event_jComboBox_NamHocActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonSua;
    private javax.swing.JButton jButtonThoat;
    private javax.swing.JButton jButtonXoaVaClean;
    private javax.swing.JButton jButton_NhapDiemChoHS;
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
