/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancnpm;

import java.sql.DriverManager;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author manng
 */
public class BaoCao_TongKet_HocKy extends javax.swing.JInternalFrame {
       
    private String header_BAOCAO_HK [] = {"Tên Lớp", "Sỉ Số", "Số Lượng Đạt","Tỉ Lê(%)"};
           private DefaultTableModel tblMode_BaoCao = new DefaultTableModel(header_BAOCAO_HK, 0);
    private String header_BAOCAO_HK_ChuaDat [] = {"Tên Lớp", "Sỉ Số", "Số Lượng Chưa Đạt","Tỉ Lê(%)"};
           private DefaultTableModel tblMode_BaoCao_chuadat = new DefaultTableModel(header_BAOCAO_HK_ChuaDat, 0);
    ConnectDB DB = new ConnectDB ();
    public BaoCao_TongKet_HocKy() {
        
        initComponents();
        
        // BÁP CAO HOC KY
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBox_NamHoc = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox_HocKy = new javax.swing.JComboBox<>();
        jButton_LapBaoCao = new javax.swing.JButton();
        jButton_Thoat = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_BaoCaoHocKy = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_BaoCaoHocKy_ChuaDat = new javax.swing.JTable();

        setClosable(true);
        setTitle("BÁO CÁO TỔNG KẾT HỌC KỲ");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc Dữ Liệu "));

        jComboBox_NamHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "K17", "K18", "K19" }));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Năm Học");

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setText("Học Kỳ");

        jComboBox_HocKy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HK1", "HK2" }));
        jComboBox_HocKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_HocKyActionPerformed(evt);
            }
        });

        jButton_LapBaoCao.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton_LapBaoCao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Clipboard.png"))); // NOI18N
        jButton_LapBaoCao.setText("Lập Báo Cáo");
        jButton_LapBaoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LapBaoCaoActionPerformed(evt);
            }
        });

        jButton_Thoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Erase.png"))); // NOI18N
        jButton_Thoat.setText("Thoát");
        jButton_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_NamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jComboBox_HocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jButton_LapBaoCao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_Thoat, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_Thoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox_NamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox_HocKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton_LapBaoCao, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DS_Lớp_Có SL  HS Đạt"));

        jTable_BaoCaoHocKy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên Lớp", "Sỉ Số", "Số Lượng Đạt", "Tỉ Lệ"
            }
        ));
        jScrollPane1.setViewportView(jTable_BaoCaoHocKy);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("DS_Lớp_Có SL  HS Chứa Đạt"));

        jTable_BaoCaoHocKy_ChuaDat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên Lớp", "Sỉ Số", "Số Lượng Đạt", "Tỉ Lệ"
            }
        ));
        jTable_BaoCaoHocKy_ChuaDat.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable_BaoCaoHocKy_ChuaDatAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(jTable_BaoCaoHocKy_ChuaDat);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_LapBaoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LapBaoCaoActionPerformed
           String namhoc = "";
        namhoc = jComboBox_NamHoc.getSelectedItem().toString();    
        String hocky = "";
        hocky = jComboBox_HocKy.getSelectedItem().toString();
         try {
            DB.conn = DriverManager.getConnection(DB.dbURL);
            // câu lệnh xem dư liệu
            String DiemTongKetNamHoc = "exec BAOCAO_HK '"+hocky+"', '"+namhoc+"'";
            // tạo đối tượng thực thi câu lênh select
            DB.st = DB.conn.createStatement();
            // Thực thi
            DB.rs = DB.st.executeQuery(DiemTongKetNamHoc);  
            Vector data = null;
            tblMode_BaoCao.setRowCount(0); 
            if (DB.rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "Không có lớp nào có hs đạt hết Tỉ Lệ Đạt 0% !");      
            } 
            while (DB.rs.next()) {
                data = new Vector();
                data.add(DB.rs.getString("TenLop"));
                data.add(DB.rs.getString("SiSo"));
                data.add(DB.rs.getString("sldat")) ;
                data.add(DB.rs.getString("tile")); 
                // Thêm một dòng vào table model
                tblMode_BaoCao.addRow(data);
            }
            jTable_BaoCaoHocKy.setModel(tblMode_BaoCao); // thêm dữ liệu vào table 
     
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không có dự liệu");
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
         // DS_Lớp Chưa đạt
 
         try {
            DB.conn = DriverManager.getConnection(DB.dbURL);
            // câu lệnh xem dư liệu
            String DiemTongKetNamHoc = "exec BAOCAO_HK_ChuaDat '"+hocky+"', '"+namhoc+"'";
            // tạo đối tượng thực thi câu lênh select
            DB.st = DB.conn.createStatement();
            // Thực thi
            DB.rs = DB.st.executeQuery(DiemTongKetNamHoc);  
               Vector data = null;
            tblMode_BaoCao_chuadat.setRowCount(0); 
              if (DB.rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "Học Sinh Ở Các Lớp đạt 100% !");
                return;
            } 
             while (DB.rs.next()) {
                data = new Vector();
                data.add(DB.rs.getString("TenLop"));
                data.add(DB.rs.getString("SiSo"));
                data.add(DB.rs.getString("slkhongdat"));
                data.add(DB.rs.getString("tile")); 
                // Thêm một dòng vào table model
                tblMode_BaoCao_chuadat.addRow(data);
            }
            jTable_BaoCaoHocKy_ChuaDat.setModel(tblMode_BaoCao_chuadat); // thêm dữ liệu vào table 
         }catch (Exception e){
             
         }
        
    }//GEN-LAST:event_jButton_LapBaoCaoActionPerformed

    private void jTable_BaoCaoHocKy_ChuaDatAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable_BaoCaoHocKy_ChuaDatAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_BaoCaoHocKy_ChuaDatAncestorAdded

    private void jComboBox_HocKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_HocKyActionPerformed
        DefaultTableModel model_Dat=(DefaultTableModel) jTable_BaoCaoHocKy.getModel();
     model_Dat.setRowCount(0);
             
     DefaultTableModel model_ChuaDat=(DefaultTableModel) jTable_BaoCaoHocKy_ChuaDat.getModel();
     model_ChuaDat.setRowCount(0);
    }//GEN-LAST:event_jComboBox_HocKyActionPerformed

    private void jButton_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThoatActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton_ThoatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_LapBaoCao;
    private javax.swing.JButton jButton_Thoat;
    private javax.swing.JComboBox<String> jComboBox_HocKy;
    private javax.swing.JComboBox<String> jComboBox_NamHoc;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_BaoCaoHocKy;
    private javax.swing.JTable jTable_BaoCaoHocKy_ChuaDat;
    // End of variables declaration//GEN-END:variables
}
