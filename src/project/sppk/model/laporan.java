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
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import project.sppk.koneksi.koneksi;

/**
 *
 * @author ASUS
 */
public class laporan {

    Connection koneksi;

    public laporan() {
        koneksi = new koneksi().getKoneksi();
    }

    public DefaultTableModel getDataBulanan(String bulan) {
        String kolom[] = {"Kode Transaksi", "Jumlah Produk", "Total"};
        DefaultTableModel output = new DefaultTableModel(null, kolom);
        String query = "SELECT kode_transaksi, COUNT(kode_transaksi) as jumlah, SUM(total) as totalTransaksi FROM penjualan WHERE MONTH(tanggal) = ? GROUP BY kode_transaksi;";

        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, bulan);
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

    public DefaultTableModel getDataPerTransaksi(String kode) {
        String kolom[] = {"Produk", "Harga", "Kuantitas", "Total"};
        DefaultTableModel output = new DefaultTableModel(null, kolom);
        String query = "SELECT pr.nama, pr.harga, pe.kuantitas, pe.total FROM penjualan pe JOIN produk pr ON pe.id_produk = pr.id WHERE pe.kode_transaksi = ?;";

        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, kode);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[4];
                data[0] = rs.getString("nama");
                data[1] = rs.getInt("harga");
                data[2] = rs.getString("kuantitas");
                data[2] = rs.getString("total");
                output.addRow(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return output;
    }

    public ArrayList<Kriteria> getKriteria() {
        ArrayList<Kriteria> kriteria = new ArrayList<>();
        String query = "SELECT id, nama, bobot FROM kriteria;";

        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Kriteria satu = new Kriteria(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getInt("bobot")
                );
                kriteria.add(satu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }

        return kriteria;
    }

    public ArrayList<Produk> getProduk() {
        ArrayList<Produk> produk = new ArrayList<>();
        String query = "SELECT id, nama, tipe, harga FROM produk;";

        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Produk satu = new Produk(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("tipe"),
                        rs.getInt("harga"));
                produk.add(satu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return produk;
    }
    
    public ArrayList<KriteriaProduk> getKriteriaProduk() {
        ArrayList<KriteriaProduk> kriteriaproduk = new ArrayList<>();
        String query = "SELECT ak.id_produk, p.nama as namaproduk, ak.id_kriteria, k.nama as namakriteria, ak.nilai "
                + "FROM alternatif_kriteria ak "
                + "JOIN kriteria k ON ak.id_kriteria = k.id "
                + "JOIN produk p ON ak.id_produk = p.id;";

        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                KriteriaProduk kp = new KriteriaProduk(
                        rs.getInt("id_produk"),
                        rs.getInt("id_kriteria"),
                        rs.getString("namaproduk"),
                        rs.getString("namakriteria"),
                        rs.getInt("nilai")
                );
                kriteriaproduk.add(kp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return kriteriaproduk;
    }

    public DefaultComboBoxModel getBulan(String tahun) {
        String query = "SELECT DISTINCT MONTH(tangal) as bulan FROM penjualan WHERE YEAR(tanggal) = ?;";
        DefaultComboBoxModel bulan = null;
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, tahun);
            ResultSet rs = st.executeQuery();
            ArrayList<String> s = new ArrayList<>();
            while (rs.next()) {
                s.add(rs.getString("bulan"));
            }
            bulan = new DefaultComboBoxModel(s.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bulan;
    }
    
    public DefaultComboBoxModel getTahun() {
        String query = "SELECT DISTINCT YEAR(tanggal) as tahun FROM penjualan;";
        
        DefaultComboBoxModel tahun = null;
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            ArrayList<String> s = new ArrayList<>();
            while (rs.next()) {
                s.add(rs.getString("tahun"));
            }
            tahun = new DefaultComboBoxModel(s.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tahun;
    }
}
