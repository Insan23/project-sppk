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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import project.sppk.koneksi.koneksi;

/**
 *
 * @author ASUS
 */
public class penjualan {
    Connection koneksi;
    
    public penjualan() {
        koneksi = new koneksi().getKoneksi();
    }
    
    public DefaultTableModel getDataPerHari(int bulan) {
        String kolom[] = {"Kode Transaksi", "Jumlah Produk", "Total"};
        DefaultTableModel output = new DefaultTableModel(null, kolom);
        String query = "SELECT kode_transaksi, COUNT(kode_transaksi) as jumlah, SUM(total) as totalTransaksi FROM penjualan WHERE tanggal = ? GROUP BY kode_transaksi;";

        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setInt(1, bulan);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[3];
                data[0] = rs.getString("kode_transaksi");
                data[1] = rs.getInt("jumlah");
                data[2] = rs.getString("totalTransaksi");
                output.addRow(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return output;
    }
    
    public void insertDataPenjualan(ArrayList<Transaksi> data) {
        String query = "INSERT INTO penjualan(tangal, kode_transaksi, id_produk, kuantitas, total) VALUES(CURDATE(), ?, ?, ?, ?);";
        
        DateFormat dateFormat = new SimpleDateFormat("FMM-sS");
	Date date = new Date();
	String kode = dateFormat.format(date);
        
        try {
            for (Transaksi perTran : data) {
                PreparedStatement st = koneksi.prepareStatement(query);
                
                st.setString(1, kode);
                st.setInt(2, perTran.getIDProduk());
                st.setInt(3, perTran.getJumlah());
                st.setInt(4, perTran.getTotal());
                
                st.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
    
    public ArrayList<Produk> getProdukPerTipe(String tipe) {
        String query = "SELECT id, nama, tipe, harga FROM produk WHERE tipe=?;";
        ArrayList<Produk> produk = new ArrayList<>();
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, tipe);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Produk p = new Produk(rs.getInt("id"), 
                        rs.getString("nama"), 
                        rs.getString("tipe"), 
                        rs.getInt("harga")
                );
                produk.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produk;
    }
}
