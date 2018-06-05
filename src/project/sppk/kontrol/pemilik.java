/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.sppk.kontrol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project.sppk.model.Kriteria;
import project.sppk.model.KriteriaProduk;
import project.sppk.model.Produk;
import project.sppk.model.laporan;
import project.sppk.tampilan.login;
import project.sppk.tampilan.pemilikLaporan;
import project.sppk.tampilan.pemilikPerhitungan;
import project.sppk.tampilan.pemilikSPPK;
import project.sppk.tampilan.pemilikTransaksi;

/**
 *
 * @author ASUS
 */
public class pemilik {
    pemilikLaporan laporan;
    pemilikSPPK rangking;
    pemilikPerhitungan perhitungan;
    pemilikTransaksi transaksi;
    
    laporan model;
    
    DefaultTableModel tabelKriteriaProduk;
    DefaultTableModel tabelRanking;
    DefaultTableModel tabelNormalisasi;
    DefaultTableModel tabelPerkalianNormalisasi;
    
    ArrayList<Produk> produk;
    ArrayList<Kriteria> kriteria;
    ArrayList<KriteriaProduk> kriteriaproduk;
    
    
    public pemilik() {
        laporan = new pemilikLaporan();
        rangking = new pemilikSPPK();
        perhitungan = new pemilikPerhitungan();
        transaksi = new pemilikTransaksi();
        
        model = new laporan();
        
        laporan.getLihat().addActionListener(new listener("lihat transaksi"));
        laporan.getRangking().addActionListener(new listener("rangking"));
        laporan.getLogout().addActionListener(new listener("logout"));
        laporan.getComboTahun().addActionListener(new listener("tahun"));
        laporan.getComboBulan().addActionListener(new listener("bulan"));
        laporan.getComboTahun().setModel(model.getTahun());
        laporan.getComboBulan().setEnabled(false);
        
        rangking.getKembali().addActionListener(new listener("ke laporan"));
        
        laporan.setVisible(true);
    }
    
    private class listener implements ActionListener {

        String tipe;
        
        public listener(String tp) {
            tipe = tp;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (tipe) {
                case "lihat transaksi":
                    JOptionPane.showMessageDialog(null, "Belum Di implementasi : lihat transaksi");
                    break;
                case "rangking":
                    rangking.setVisible(true);
                    laporan.setVisible(false);
                    break;
                case "logout":
                    new login();
                    laporan.dispose();
                    break;
                case "tahun":
                    String tahun = laporan.getComboTahun().getSelectedItem().toString();
                    laporan.getComboBulan().setModel(model.getBulan(tahun));
                    laporan.getComboBulan().setEnabled(true);
                    break;
                case "bulan":
                    String bulan = laporan.getComboBulan().getSelectedItem().toString();
                    laporan.getTabelTransaksi().setModel(model.getDataBulanan(bulan));
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Belum Di implementasi");
            }
        }
        
    }
    
    private void getSemua() {
        produk = model.getProduk();
        kriteria = model.getKriteria();
        kriteriaproduk = model.getKriteriaProduk();
        
        String kolomKriteriaProduk[] = {"Nama Produk", "Harga", "Kuantitas", "Tekstur", "Rasa"};
        String kolomNormalisasi[] = {"Nama Produk", "Harga", "Kuantitas", "Tekstur", "Rasa"};
        String kolomPerkalian[] = {"Nama Produk", "Total"};
        String kolomRangking[] = {"Nama Produk", "Total", "Ranking"};
        
        tabelKriteriaProduk = new DefaultTableModel(null, kolomKriteriaProduk);
        tabelNormalisasi = new DefaultTableModel(null, kolomNormalisasi);
        tabelPerkalianNormalisasi = new DefaultTableModel(null, kolomPerkalian);
        tabelRanking = new DefaultTableModel(null, kolomRangking);
        
        for (KriteriaProduk k : kriteriaproduk) {
            
        }
    }
    
    private void hitungNormalisasi() {
        
    }
}
