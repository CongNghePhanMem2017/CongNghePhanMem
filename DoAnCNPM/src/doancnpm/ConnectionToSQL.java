/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doancnpm;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConnectionToSQL 
{
    Connection conn;
    public Connection getConnection()
    {
       // class.forName("");
        try {
            conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=DB_DOAN_QLHS;user=sa;password=sa");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionToSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    public void CloseConn()
    {
        if(conn!=null)
        {
            try {
                if(!conn.isClosed())
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionToSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        conn=null;
                
    }

    Connection prepareCall(String callgetNoStudents) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

