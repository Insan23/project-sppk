/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.sppk.kontrol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import project.sppk.model.penjualan;
import project.sppk.tampilan.kasirHome;
import project.sppk.tampilan.kasirTransaksi;

/**
 *
 * @author ASUS
 */
public class kasir {
    private kasirHome home;
    private kasirTransaksi transaksi;
    private penjualan model;
    
    public kasir(String view) {
        model = new penjualan();
        switch (view) {
            case "home":
                home = new kasirHome();
                home.setVisible(true);
                home.getLogout().addActionListener(new listener("logout"));
                home.getTambah().addActionListener(new listener("tambah"));
                home.getTabelKasir().setModel(model.getDataPerHari());
                break;
            case "transaksi":
                transaksi = new kasirTransaksi();
                transaksi.setVisible(true);
                transaksi.getKembali().addActionListener(new listener("kembali"));
                transaksi.getTambah().addActionListener(new listener("tambah transaksi"));
                transaksi.getTipe().addActionListener(new listener("tipe"));
                transaksi.getProduk().addActionListener(new listener("produk"));
                transaksi.getSelesai().addActionListener(new listener("selesai"));
                break;
            default:
                
        }
    }
    
    private class listener implements ActionListener {

        String tipe;
        
        public listener(String tipe) {
            this.tipe = tipe;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (tipe) {
                case "tambah":
                    break;
                case "tambah transaksi":
                    break;
                case "selesai":
                    break;
                case "kembali":
                    break;
                case "tipe":
                    break;
                case "produk":
                    break;
                case "logout":
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Belum Di implementasi");
            }
        }
        
    }
}
