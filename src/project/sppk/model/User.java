/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.sppk.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import project.sppk.koneksi.koneksi;

/**
 *
 * @author ASUS
 */
public class User {
    Connection koneksi;
    
    public User() {
        koneksi = new koneksi().getKoneksi();
    }
    
    public String login(String user, String pass) {
        String query = "SELECT level FROM user WHERE username=? AND password=?;";
        
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, user);
            st.setString(2, pass);
            
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getString("level");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "salah";
    }
}
