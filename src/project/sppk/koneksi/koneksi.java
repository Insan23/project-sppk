/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.sppk.koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class koneksi {
    Connection koneksi;
    
    public Connection getKoneksi() {
        if (koneksi == null) {
            String database = "matrix_jaya";
            String username = "root";
            String password = "";
            try {
                koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                        + database, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return koneksi;
    }
}
