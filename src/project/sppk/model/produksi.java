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
import javax.swing.table.DefaultTableModel;
import project.sppk.koneksi.koneksi;

/**
 *
 * @author ASUS
 */
public class produksi {
    Connection koneksi;
    
    public produksi() {
        koneksi = new koneksi().getKoneksi();
    }
    
    public DefaultTableModel getStok() {
        String query = "SELECT s.id, s.id_produk, p.nama, s.stok, s.terakhir_diperbarui FROM stok s JOIN produk p ON s.id_produk = p.id;";
        String kolom[] = {"ID", "ID Produk", "Nama Produk", "Stok", "Terakhir Diperbarui"};
        DefaultTableModel output = new DefaultTableModel(null, kolom);
        
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[5];
                data[0] = rs.getInt("id");
                data[1] = rs.getInt("id_produk");
                data[2] = rs.getString("nama");
                data[3] = rs.getInt("stok");
                data[4] = rs.getString("terakhir_diperbarui");
                output.addRow(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output;
    }
    
    public DefaultTableModel getProduk() {
        String query = "SELECT id, nama, tipe, harga FROM produk;";
        String kolom[] = {"ID", "Nama", "Tipe", "Harga"};
        DefaultTableModel output = new DefaultTableModel(null, kolom);
        
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[4];
                data[0] = rs.getInt("id");
                data[1] = rs.getInt("nama");
                data[2] = rs.getString("tipe");
                data[3] = rs.getInt("harga");
                output.addRow(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output;
    }
    
    public boolean updateStok(int stok, int id) {
        String query = "UPDATE stok SET stok=?, terakhir_diperbarui=CURDATE() WHERE id_produk=?;";
        
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setInt(1, stok);
            st.setInt(2, id);
            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateProduk(int stok, int id) {
        String query = "UPDATE stok SET stok=?, terakhir_diperbarui=CURDATE() WHERE id_produk=?;";
        
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setInt(1, stok);
            st.setInt(2, id);
            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean insertProduk(Produk prod) {
        String query = "INSERT INTO produk(nama, tipe, harga) VALUES(?, ?, ?);";
        
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, prod.getNama());
            st.setString(2, prod.getTipe());
            st.setInt(3, prod.getHarga());
            int hasil = st.executeUpdate();
            if (hasil > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteProduk(int ID) {
        String query = "DELETE FROM produk WHERE id = ?;";
        
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setInt(1, ID);
            int hasil = st.executeUpdate();
            if (hasil > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
