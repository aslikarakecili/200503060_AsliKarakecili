/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class DBOperations {
    
        public static Connection getCon() throws Exception
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fitplus?&useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false","root","agk130922");
            return con;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    } 

}
    