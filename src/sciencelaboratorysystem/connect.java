/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sciencelaboratorysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Sadiqeen
 */
public class connect {
     public static Connection ConnectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sls?zeroDateTimeBehavior=convertToNull";
            Connection con = DriverManager.getConnection(url,"root","");
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sorry! can't connect to database please contact administrator", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return null;
    }
}
