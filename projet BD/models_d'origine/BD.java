/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Nivekiba
 */
public class BD {
    private static String urlPilote = "com.mysql.jdbc.Driver";
    private static String urlBD = "jdbc:mysql://localhost:3306/eshop";
    public static Connection connex = null;
    private static Statement statement = null;

    public static Connection ConnexionMySql() {
        if(connex==null) {
            try {
                Class.forName(urlPilote);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Pilote du SGBD introuvable");
            }

            try{
                connex =  DriverManager.getConnection(urlBD, "root", "");
                statement = connex.createStatement();
                return connex;
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Connexion a la BD impossible");
                return null;
            }
        } else {
            return connex;
        }
    }

    public static Statement getStatement()
    {
      return statement;
    }
}
