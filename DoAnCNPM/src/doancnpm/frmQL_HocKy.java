/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancnpm;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import java.sql.Statement;
 
import javax.swing.JOptionPane;
 
import javax.swing.table.DefaultTableModel;
 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Elitebook
 */
public class frmQL_HocKy extends javax.swing.JInternalFrame {
     
    
     ConnectDB DB = new ConnectDB();
     String header[]={"Mã Học Kỳ", "Tên Học Kỳ"};
     DefaultTableModel model = new DefaultTableModel();

    public frmQL_HocKy() {
        initComponents();
        load();
         //loadData();
       // loadDataHocKy();
        
    }
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDrivaer";

    // 
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDSHOCKY = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldMaHocKy = new javax.swing.JTextField();
        jTextFieldTenHocKy = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButtonThem = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();
        jButtonClean = new javax.swing.JButton();
        jButtonSua = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonThoat = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jTableDSHOCKY.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Học Kỳ", "Tên Học Kỳ"
            }
        ));
        jTableDSHOCKY.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTableDSHOCKYAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTableDSHOCKY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDSHOCKYMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDSHOCKY);

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel5.setText("Danh Sách Các Học Kỳ");

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel2.setText("Cập Nhật Thông Tin");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Mã Học Kỳ");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Tên Học Kỳ");

        jTextFieldMaHocKy.setText(" ");

        jTextFieldTenHocKy.setText(" ");

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

        jButtonClean.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Refresh.png"))); // NOI18N
        jButtonClean.setText("Clean");
        jButtonClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCleanActionPerformed(evt);
            }
        });

        jButtonSua.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Redo.png"))); // NOI18N
        jButtonSua.setText("SỬA");
        jButtonSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuaActionPerformed(evt);
            }
        });

        jLabel1.setText(" ");

        jButtonThoat.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Exit.png"))); // NOI18N
        jButtonThoat.setText("THOÁT");
        jButtonThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThoatActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonThoat)
                .addGap(13, 13, 13)
                .addComponent(jButtonClean)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(jLabel1)
                        .addComponent(jButtonThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonClean, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldMaHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTenHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldMaHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldTenHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(171, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    
    
    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaActionPerformed
       int index = jTableDSHOCKY.getSelectedRow();
       TableModel model = jTableDSHOCKY.getModel();
       String key = model.getValueAt(index,0).toString();
       String delete = "DELETE FROM HOCKY WHERE MaHocKy = " +key;
        try {
            DB.conn = DriverManager.getConnection(DB.dbURL);
            DB.ps = DB.conn.prepareStatement(delete);
            
             int ret = DB.ps.executeUpdate();
             if (ret != -1 ) {
               // JOptionPane.showMessageDialog(null, " +ret.toString());
                JOptionPane.showMessageDialog(null, " Delete Thanh cong ");
            }
        }  catch (Exception e) {
              JOptionPane.showMessageDialog(null, " Delete That bai ");
             // System.out.println(e.toString());
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
     //   load();
        
// Chức năng xóa toàn dữ liệu 
       /* DefaultTableModel model = (DefaultTableModel) jTableDSHOCKY.getModel();
        if (jTableDSHOCKY.getSelectedRow() == -1) {
            if (jTableDSHOCKY.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Chưa Có Dữ Liệu !");
            } else {
                JOptionPane.showMessageDialog(this, "Vui Lòng Chọn Dòng !");
            }
        } else {
            model.removeRow(jTableDSHOCKY.getSelectedRow()); // câu le65ng dùng để xóa
            JOptionPane.showMessageDialog(this, "Xóa Thành Công ");
        }  */

    }//GEN-LAST:event_jButtonXoaActionPerformed

    private void jButtonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCleanActionPerformed
        jTextFieldMaHocKy.setText("");
        jTextFieldTenHocKy.setText("");
    }//GEN-LAST:event_jButtonCleanActionPerformed

    // Lam lai
    private void jButtonSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaActionPerformed
        try {
            DB.conn = DriverManager.getConnection(DB.dbURL);
            int index = jTableDSHOCKY.getSelectedRow();
           // String value = jTableDSHOCKY.getModel().getValueAt(index,0).toString();
            String Update = "UPDATE HOCKY set  TenHocKy = ? where MaHocKy =? "  ;
          
            DB.ps = DB.conn.prepareStatement(Update);
            DB.ps.setString(1, jTextFieldTenHocKy.getText());
            DB.ps.setString(2, jTextFieldMaHocKy.getText());
            
           
           // DB.ps.executeUpdate();
           //DB.ps.executeLargeUpdate(value)

           long ret = DB.ps.executeUpdate();

            if (ret != -1 ) {
               // JOptionPane.showMessageDialog(null, " +ret.toString());
                JOptionPane.showMessageDialog(null, " UpDate Thanh cong ");
               
            }
        } 
        catch (Exception e) {
              JOptionPane.showMessageDialog(null, " UpDate That bai ");
              System.out.println(e.toString());
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
        load();
    }//GEN-LAST:event_jButtonSuaActionPerformed

    @SuppressWarnings("empty-statement")
    private  void load(){  // load dl tu7 database
        DefaultTableModel model = (DefaultTableModel) jTableDSHOCKY.getModel();     
         try {
             DB.conn=DriverManager.getConnection(DB.dbURL);
             String sql = "select * from HOCKY";
              DB.st = DB.conn.createStatement();
              
                DB.rs = DB.st.executeQuery(sql);
                // DB.rs = DB.st.executeQuery(sql);
                 
                 Vector data = null;
                     model.setRowCount(0);
                  if (DB.rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "The HOC KY is not available!");
                return;
                  }
                 while (DB.rs.next()) {
                data = new Vector();
                data.add(DB.rs.getString("MaHocKy"));
                data.add(DB.rs.getString("TenHocKy"));

               
                 model.addRow(data);
            }
                  jTableDSHOCKY.setModel(model);
        
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
    
    private void jButtonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemActionPerformed
      // Chức năng thêm một hs mới vào  
        DefaultTableModel model = (DefaultTableModel) jTableDSHOCKY.getModel();      
        if (!jTextFieldMaHocKy.getText().trim().equals("")) {       //Kiểm tra điều kiện Mã Học Kỳ không được bỏ trống
            model.addRow(new Object[]{
                jTextFieldMaHocKy.getText(),
                jTextFieldTenHocKy.getText(),});
        } else {
            JOptionPane.showMessageDialog(this, "Mã Số Học Kỳ Không được bỏ trống");
            return;
        }
         //--------
        String insert = "INSERT INTO HOCKY (MaHocKy,TenHocKy) VALUES(?,?)";
         try {
            DB.conn = DriverManager.getConnection(DB.dbURL);
            DB.ps = DB.conn.prepareStatement(insert);
            
            DB.ps.setString(1, jTextFieldMaHocKy.getText());
            DB.ps.setString(2, jTextFieldTenHocKy.getText());
            int ret = DB.ps.executeUpdate();
            
            if (ret != -1) {
                JOptionPane.showMessageDialog(this, "The HỌC KỲ  has been insertet"); 
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
         
    }//GEN-LAST:event_jButtonThemActionPerformed

    
    private void jTableDSHOCKYMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDSHOCKYMouseClicked
        // code sử lí khi click chuộc vào chọn 1 dòng dữ liệu để chỉnh sửa mội dung
        // Khi click vào dòng nào thì nội dung của dòng  đó sẽ được đổ vào các text 
        int index = jTableDSHOCKY.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTableDSHOCKY.getModel();
        jTextFieldMaHocKy.setText(model.getValueAt(jTableDSHOCKY.getSelectedRow(), 0).toString());
        jTextFieldTenHocKy.setText(model.getValueAt(jTableDSHOCKY.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_jTableDSHOCKYMouseClicked

    
    private void jTableDSHOCKYAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTableDSHOCKYAncestorAdded
         
    }//GEN-LAST:event_jTableDSHOCKYAncestorAdded

    private void jButtonThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThoatActionPerformed
          // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Có Muốn Thoát Hong !");
        System.exit(0);

    }//GEN-LAST:event_jButtonThoatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClean;
    private javax.swing.JButton jButtonSua;
    private javax.swing.JButton jButtonThem;
    private javax.swing.JButton jButtonThoat;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDSHOCKY;
    private javax.swing.JTextField jTextFieldMaHocKy;
    private javax.swing.JTextField jTextFieldTenHocKy;
    // End of variables declaration//GEN-END:variables

     

   /* private void Load() {
        try {
            DB.conn = DriverManager.getConnection(DB.dbURL);
            String sql = "select * from HOCKY";
          DB.st = DB.CONN
        } catch (Exception e) {
        }
    
    }*/

    

   
}
