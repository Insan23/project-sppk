/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.sppk.kontrol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import project.sppk.tampilan.produksiProduk;
import project.sppk.tampilan.produksiStok;

/**
 *
 * @author ASUS
 */
public class produksi {
    private produksiStok stok;
    private produksiProduk produk;
    private project.sppk.model.produksi model;
    
    public produksi(String view) {
        model = new project.sppk.model.produksi();
        switch (view) {
            case "stok":
                stok = new produksiStok();
                stok.setVisible(true);
                
                stok.getLihat_produk().addActionListener(new listener("lihat produk"));
                stok.getLogout().addActionListener(new listener("logout"));
                stok.getTambah_stok().addActionListener(new listener("tambah stok"));
                stok.getTabelStok().setModel(model.getStok());
                break;
            case "produk":
                produk = new produksiProduk();
                produk.setVisible(true);
                
                produk.getHapus().addActionListener(new listener("hapus"));
                produk.getUbah().addActionListener(new listener("ubah"));
                produk.getTambah().addActionListener(new listener("tambah"));
                produk.getKembali().addActionListener(new listener("kembali"));
                produk.getTabelProduk().setModel(model.getProduk());
                break;
            default:
                throw new AssertionError();
        }
    }
    
    private class listener implements ActionListener {

        String tipe;
        
        public listener(String t) {
            tipe = t;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (tipe) {
                case "tambah":
                    
                    break;
                case "tambah produk":
                    break;
                case "ubah":
                    break;
                case "hapus":
                    break;
                case "kembali":
                    break;
                case "lihat produk":
                    break;
                case "logout":
                    break;
                default:
                    throw new AssertionError();
            }
        }
        
    }
}
