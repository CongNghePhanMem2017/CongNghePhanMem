/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancnpm;

import java.sql.DriverManager;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author manng
 */
public class CatchExceptions {
    ConnectDB DB=new ConnectDB();
    public static int count(String s)
    {
        int i = 0, count = 1;
        char[] s1 = s.toCharArray(); 
        while(s1[i] == ' ')
        {
            i++;
        }

        for (int j = i; j < s1.length - 1; j++)
        {
            if(s1[j] == ' ' && s1[j + 1] != ' ')
            {
                count++;
            }
        }
        return count;
    } 
    public int CheckAge(int n,int s){
        int[] QD = new int[2];
        int i=0;
        try {
            DB.conn = DriverManager.getConnection(DB.dbURL);

            String sql = "select * from QUYDINH where TenQuyDinh=N'Tuổi' ";//fix
            DB.st = DB.conn.createStatement();
            DB.rs = DB.st.executeQuery(sql);
            Vector data = null;
            

            // Nếu sách không tồn tại
            if (DB.rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(null, "Now Quy dinh is not available!");//fix
                return -1;
            }
            while (DB.rs.next()) {
                    QD[i]=DB.rs.getInt("ThongSo");
                       i++;
            }
              if(n-s<QD[0] || n-s>QD[1])
              {
                  return 0;
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
        return 1;
    }
    public int CheckSiSo(String malop,int n){

        try {
            DB.conn = DriverManager.getConnection(DB.dbURL);

            String sql = "select * from QUYDINH where TenQuyDinh=N'SiSo' ";//fix
            DB.st = DB.conn.createStatement();
            DB.rs = DB.st.executeQuery(sql);
            Vector data = null;
            

            // Nếu sách không tồn tại
            if (DB.rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(null, "Now Quy dinh is not available!");//fix
                return -1;
            }
            while (DB.rs.next()) {
                    int QD=DB.rs.getInt("ThongSo");
                    if(n>QD)
                    {
                        return 0;
                    }
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
        return 1;
    }
}
