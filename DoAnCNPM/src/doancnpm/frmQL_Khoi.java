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
import javax.swing.table.TableModel;

/**
 *
 * @author Elitebook
 */
public class frmQL_Khoi extends javax.swing.JInternalFrame {

    ConnectDB DB=new ConnectDB();
    private String header[] = {"MaKHOI","TenKHOI"};
    private DefaultTableModel tblModel = new DefaultTableModel(header,0);
    /**
     * Creates new form frmQL_Khoi
     */
    public frmQL_Khoi() {
        initComponents();
        loadKhoiFillTB();
    }

    private void loadKhoiFillTB(){
        try {
            DB.conn = DriverManager.getConnection(DB.dbURL);

            
            // Câu lệnh xem dữ liệu
            String sql = "select * from KHOI ";
            

            // Tạo đối tượng thực thi câu lệnh Select
            DB.st = DB.conn.createStatement();

            // Thực thi 
            DB.rs = DB.st.executeQuery(sql);
            Vector data = null;

            tblModel.setRowCount(0);
        

            // Trong khi chưa hết dữ liệu
            while (DB.rs.next()) {
                data = new Vector();
                data.add(DB.rs.getString("MaKhoi"));
                data.add(DB.rs.getString("TenKhoi"));
                // Thêm một dòng vào table model
                 tblModel.addRow(data);
            }
            jTableKhoi.setModel(tblModel);
            // Thêm dữ liệu vào table
            
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

        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldMaKhoi = new javax.swing.JTextField();
        jTextFieldTenKhoi = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButtonThem = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();
        jButtonThoat = new javax.swing.JButton();
        jButtonSua = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableKhoi = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel5.setText("Danh Sách Các Khối");

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel2.setText("Cập Nhật Thông Tin");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Mã Khối");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Tên Khối");

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
                .addGap(0, 23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonSua, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(83, 83, 83)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldMaKhoi, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTenKhoi, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldMaKhoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldTenKhoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jTableKhoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "MaKhoi", "TenKhoi"
            }
        ));
        jTableKhoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableKhoiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableKhoi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaActionPerformed
        // TODO add your handling code here:
            int index = jTableKhoi.getSelectedRow();
        TableModel model=jTableKhoi.getModel(); 
        String key=model.getValueAt(index,0).toString();
        String delete="DELETE FROM KHOI  WHERE MaKhoi='"+key+"'";

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
        loadKhoiFillTB();
    }//GEN-LAST:event_jButtonXoaActionPerformed

    private void jButtonThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThoatActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonThoatActionPerformed

    private void jButtonSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaActionPerformed
        // TODO add your handling code here:
           try {
            DB.conn = DriverManager.getConnection(DB.dbURL);
            int index=jTableKhoi.getSelectedRow();
            String value = jTableKhoi.getModel().getValueAt(index, 0).toString();
            String update2 = "UPDATE KHOI SET MaKhoi=?,TenKhoi=? where MaKhoi='"+value+"'";

  
             DB.ps = DB.conn.prepareStatement(update2);
            
           DB.ps.setString(1,jTextFieldMaKhoi.getText());
           DB.ps.setString(2,jTextFieldTenKhoi.getText());
            

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
        loadKhoiFillTB();
    }//GEN-LAST:event_jButtonSuaActionPerformed

    private void jButtonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemActionPerformed
        // TODO add your handling code here:
         loadKhoiFillTB();
        String insert = "INSERT INTO KHOI (MaKhoi,TenKhoi) VALUES(?,?)";//fix

        try {
           DB.conn = DriverManager.getConnection(DB.dbURL);
           DB.ps = DB.conn.prepareStatement(insert);

           DB.ps.setString(1,jTextFieldMaKhoi.getText());
           DB.ps.setString(2,jTextFieldTenKhoi.getText());
         
            

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
        loadKhoiFillTB();
    }//GEN-LAST:event_jButtonThemActionPerformed

    private void jTableKhoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableKhoiMouseClicked
        // TODO add your handling code here:
        int index = jTableKhoi.getSelectedRow();
        TableModel model=jTableKhoi.getModel();
        
        
        jTextFieldMaKhoi.setText (model.getValueAt(index,0).toString());
        jTextFieldTenKhoi.setText (model.getValueAt(index,1).toString());
    }//GEN-LAST:event_jTableKhoiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSua;
    private javax.swing.JButton jButtonThem;
    private javax.swing.JButton jButtonThoat;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableKhoi;
    private javax.swing.JTextField jTextFieldMaKhoi;
    private javax.swing.JTextField jTextFieldTenKhoi;
    // End of variables declaration//GEN-END:variables
}
