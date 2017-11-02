/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancnpm;

import java.sql.DriverManager;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author manng
 */
public class Extra {
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

            String sql = "select * from QUYDINH where TenQuyDinh like N'Tuổi%' ";//fix
            DB.st = DB.conn.createStatement();
            DB.rs = DB.st.executeQuery(sql);

            if (DB.rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(null, "Quy dinh is not available!");//fix
                return -1;
            }
            while (DB.rs.next()) {
                    QD[i]=DB.rs.getInt("ThongSo");
                       i++;
            }
            if(QD[0]<QD[1])
            {
              if(n-s<QD[0] || n-s>QD[1])
              {
                  return 0;
              }
            }
            else
               if(n-s<QD[1] || n-s>QD[0])
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

            String sql = "select * from QUYDINH where TenQuyDinh=N'Sĩ  Số Lớp' ";//fix
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
    public int CheckMaHK(String mahk){
        int i=0;
        try {
            DB.conn = DriverManager.getConnection(DB.dbURL);

            String sql = "select * from HOCKY  ";//fix
            DB.st = DB.conn.createStatement();
            DB.rs = DB.st.executeQuery(sql);

            if (DB.rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(null, "Hoc kì is not available!");//fix
                return -1;
            }
            while (DB.rs.next()) {
                    String mhk=DB.rs.getString("mahocky");
                    if(mahk.equals(mhk))
                    {
                        i++;
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
        if(i==0)
        return 1;
        else return 0;
    }
    private static char[] SOURCE_CHARACTERS = { 'À', 'Á', 'Â', 'Ã', 'È', 'É',
            'Ê', 'Ì', 'Í', 'Ò', 'Ó', 'Ô', 'Õ', 'Ù', 'Ú', 'Ý', 'à', 'á', 'â',
            'ã', 'è', 'é', 'ê', 'ì', 'í', 'ò', 'ó', 'ô', 'õ', 'ù', 'ú', 'ý',
            'Ă', 'ă', 'Đ', 'đ', 'Ĩ', 'ĩ', 'Ũ', 'ũ', 'Ơ', 'ơ', 'Ư', 'ư', 'Ạ',
            'ạ', 'Ả', 'ả', 'Ấ', 'ấ', 'Ầ', 'ầ', 'Ẩ', 'ẩ', 'Ẫ', 'ẫ', 'Ậ', 'ậ',
            'Ắ', 'ắ', 'Ằ', 'ằ', 'Ẳ', 'ẳ', 'Ẵ', 'ẵ', 'Ặ', 'ặ', 'Ẹ', 'ẹ', 'Ẻ',
            'ẻ', 'Ẽ', 'ẽ', 'Ế', 'ế', 'Ề', 'ề', 'Ể', 'ể', 'Ễ', 'ễ', 'Ệ', 'ệ',
            'Ỉ', 'ỉ', 'Ị', 'ị', 'Ọ', 'ọ', 'Ỏ', 'ỏ', 'Ố', 'ố', 'Ồ', 'ồ', 'Ổ',
            'ổ', 'Ỗ', 'ỗ', 'Ộ', 'ộ', 'Ớ', 'ớ', 'Ờ', 'ờ', 'Ở', 'ở', 'Ỡ', 'ỡ',
            'Ợ', 'ợ', 'Ụ', 'ụ', 'Ủ', 'ủ', 'Ứ', 'ứ', 'Ừ', 'ừ', 'Ử', 'ử', 'Ữ',
            'ữ', 'Ự', 'ự', };

    // Mang cac ky tu thay the khong dau
    private static char[] DESTINATION_CHARACTERS = { 'A', 'A', 'A', 'A', 'E',
            'E', 'E', 'I', 'I', 'O', 'O', 'O', 'O', 'U', 'U', 'Y', 'a', 'a',
            'a', 'a', 'e', 'e', 'e', 'i', 'i', 'o', 'o', 'o', 'o', 'u', 'u',
            'y', 'A', 'a', 'D', 'd', 'I', 'i', 'U', 'u', 'O', 'o', 'U', 'u',
            'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A',
            'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'E', 'e',
            'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E',
            'e', 'I', 'i', 'I', 'i', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o',
            'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O',
            'o', 'O', 'o', 'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u',
            'U', 'u', 'U', 'u', };

    /**
     * Bo dau 1 ky tu
     * 
     * @param ch
     * @return
     */
    public static char removeAccent(char ch) {
        int index = Arrays.binarySearch(SOURCE_CHARACTERS, ch);
        if (index >= 0) {
            ch = DESTINATION_CHARACTERS[index];
        }
        return ch;
    }

    /**
     * Bo dau 1 chuoi
     * 
     * @param s
     * @return
     */
    public static String removeAccent(String s) {
        s=s.toUpperCase();
         s = s.replaceAll("\\s+","");
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, removeAccent(sb.charAt(i)));
        }
        return sb.toString();
    }
    public int CheckMaMH(String mamh){
        int i=0;
        try {
            DB.conn = DriverManager.getConnection(DB.dbURL);

            String sql = "select * from monhoc  ";//fix
            DB.st = DB.conn.createStatement();
            DB.rs = DB.st.executeQuery(sql);

            if (DB.rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(null, "Hoc kì is not available!");//fix
                return -1;
            }
            while (DB.rs.next()) {
                    String mmh=DB.rs.getString("mamonhoc");
                    if(mamh.equals(mmh))
                    {
                        i++;
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
        if(i==0)
        return 1;
        else return 0;
    }
     public int CheckMaLKT(String malkt){
        int i=0;
        try {
            DB.conn = DriverManager.getConnection(DB.dbURL);

            String sql = "select * from loaikiemtra  ";//fix
            DB.st = DB.conn.createStatement();
            DB.rs = DB.st.executeQuery(sql);

            if (DB.rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(null, "Hoc kì is not available!");//fix
                return -1;
            }
            while (DB.rs.next()) {
                    String mlkt=DB.rs.getString("maloaikiemtra");
                    if(malkt.equals(mlkt))
                    {
                        i++;
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
        if(i==0)
        return 1;
        else return 0;
    }
}