/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancnpm;

import static doancnpm.frmTiepNhanHS.convertUtilDateToSqlDate;
import java.sql.DriverManager;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static jdk.nashorn.internal.objects.NativeString.trim;

/**
 *
 * @author Elitebook
 */
public class frmQL_NamHoc extends javax.swing.JInternalFrame {
    ConnectDB DB=new ConnectDB();
    char NumArray[]={'0','1','2','3','4','5','6','7','8','9'};
    private String header[] = {"MaNH","TenNH","YNGHIA"};
    private DefaultTableModel tblModel = new DefaultTableModel(header,0);
    char SpecSign[]={'`','~','!','@','#','$','%','^','&','*','(',')','-','_','+','=','{','[','}',']','\\','|',';',':','\'','"','<',',','>','.','?','/'};
    /**
     * Creates new form frmQL_NamHoc
     */
    public frmQL_NamHoc() {
        initComponents();
        loadNHFillTB();
    }
     private void loadNHFillTB(){
        try {
            DB.conn = DriverManager.getConnection(DB.dbURL);

            
            // Câu lệnh xem dữ liệu
            String sql = "select * from NAMHOC ";
            

            // Tạo đối tượng thực thi câu lệnh Select
            DB.st = DB.conn.createStatement();

            // Thực thi 
            DB.rs = DB.st.executeQuery(sql);
            Vector data = null;

            tblModel.setRowCount(0);
        

            // Trong khi chưa hết dữ liệu
            while (DB.rs.next()) {
                data = new Vector();
                data.add(DB.rs.getString("MANH"));
                data.add(DB.rs.getString("TENNH"));
                data.add(DB.rs.getString("YNGHIA"));
                // Thêm một dòng vào table model
                 tblModel.addRow(data);
            }
            jTableNamHoc.setModel(tblModel);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNamHoc = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldMaNamHoc = new javax.swing.JTextField();
        jTextFieldTenNamHoc = new javax.swing.JTextField();
        jTextFieldYNghia = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButtonThem = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();
        jButtonThoat = new javax.swing.JButton();
        jButtonSua = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Quản Lý Năm Học");

        jTableNamHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jTableNamHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableNamHocMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableNamHoc);

        jLabel2.setText("Thay Đổi");

        jLabel3.setText("Mã Năm Học");

        jLabel4.setText("Tên Năm Học");

        jLabel5.setText("Ý Nghĩa");

        jTextFieldMaNamHoc.setEditable(false);
        jTextFieldMaNamHoc.setText(" ");

        jTextFieldTenNamHoc.setText(" ");

        jTextFieldYNghia.setText(" ");

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jButtonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSua, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonThoat)
                .addGap(0, 11, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonSua, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldMaNamHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(jTextFieldTenNamHoc)
                            .addComponent(jTextFieldYNghia)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldMaNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addComponent(jTextFieldTenNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldYNghia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jLabel6.setText("Mã NĂM HỌC");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setText("QUẢN LÝ NĂM HỌC");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaActionPerformed
        // TODO add your handling code here:
           int index = jTableNamHoc.getSelectedRow();
        TableModel model=jTableNamHoc.getModel(); 
        String key=model.getValueAt(index,0).toString();
        String delete="DELETE FROM NAMHOC  WHERE MANH='"+key+"'";

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
        loadNHFillTB();
        jTextFieldMaNamHoc.setText("");
        jTextFieldTenNamHoc.setText("");
        jTextFieldYNghia.setText("");
    }//GEN-LAST:event_jButtonXoaActionPerformed

    private void jButtonThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThoatActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonThoatActionPerformed

    private void jButtonSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaActionPerformed
        // TODO add your handling code here:
         try {
            DB.conn = DriverManager.getConnection(DB.dbURL);
            int index=jTableNamHoc.getSelectedRow();
            String value = jTableNamHoc.getModel().getValueAt(index, 0).toString();
            String update2 = "UPDATE NAMHOC SET TENNH=?,YNGHIA=? where MANH='"+value+"'";

  
             DB.ps = DB.conn.prepareStatement(update2);
             if(jTextFieldTenNamHoc.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(rootPane, "Không thể để trống");
               return;
           }
           DB.ps.setString(1,jTextFieldTenNamHoc.getText());
           DB.ps.setString(2,jTextFieldYNghia.getText());
            

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
        loadNHFillTB();
        jTextFieldMaNamHoc.setText("");
        jTextFieldTenNamHoc.setText("");
        jTextFieldYNghia.setText("");
    }//GEN-LAST:event_jButtonSuaActionPerformed

    private void jButtonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemActionPerformed
        // TODO add your handling code here:
          loadNHFillTB();
        String insert = "INSERT INTO NAMHOC (MANH,TENNH,YNGHIA) VALUES('',?,?)";//fix

        try {
           DB.conn = DriverManager.getConnection(DB.dbURL);
           DB.ps = DB.conn.prepareStatement(insert);
           
           if(jTextFieldTenNamHoc.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(rootPane, "Không thể để trống");
               return;
           }
           DB.ps.setString(1,jTextFieldTenNamHoc.getText());
           DB.ps.setString(2,jTextFieldYNghia.getText());
         
            

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
        loadNHFillTB();
        jTextFieldMaNamHoc.setText("");
        jTextFieldTenNamHoc.setText("");
        jTextFieldYNghia.setText("");
    }//GEN-LAST:event_jButtonThemActionPerformed

    private void jTableNamHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableNamHocMouseClicked
        // TODO add your handling code here:
        int index = jTableNamHoc.getSelectedRow();
        TableModel model=jTableNamHoc.getModel();
        
        
        jTextFieldMaNamHoc.setText (model.getValueAt(index,0).toString());
        jTextFieldTenNamHoc.setText (model.getValueAt(index,1).toString());
        jTextFieldYNghia.setText (model.getValueAt(index,2).toString());
    }//GEN-LAST:event_jTableNamHocMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSua;
    private javax.swing.JButton jButtonThem;
    private javax.swing.JButton jButtonThoat;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableNamHoc;
    private javax.swing.JTextField jTextFieldMaNamHoc;
    private javax.swing.JTextField jTextFieldTenNamHoc;
    private javax.swing.JTextField jTextFieldYNghia;
    // End of variables declaration//GEN-END:variables
}
