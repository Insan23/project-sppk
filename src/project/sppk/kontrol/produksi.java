/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.sppk.kontrol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import project.sppk.model.Produk;
import project.sppk.tampilan.login;
import project.sppk.tampilan.produksiProduk;
import project.sppk.tampilan.produksiStok;
import project.sppk.tampilan.tambahProduk;

/**
 *
 * @author ASUS
 */
public class produksi {

    private produksiStok stok;
    private produksiProduk produk;
    private tambahProduk tambahProd;
    private project.sppk.model.produksi model;

    int baris;

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

                stok.getTambah_stok().setEnabled(false);
                break;
            case "produk":
                produk = new produksiProduk();
                produk.setVisible(true);

                produk.getHapus().addActionListener(new listener("hapus"));
                produk.getUbah().addActionListener(new listener("ubah"));
                produk.getTambah().addActionListener(new listener("tambah"));
                produk.getKembali().addActionListener(new listener("kembali"));
                produk.getTabelProduk().setModel(model.getProduk());

                produk.getHapus().setEnabled(false);
                produk.getUbah().setEnabled(false);
                break;
            case "tambah produk":
                tambahProd = new tambahProduk();
                tambahProd.setVisible(true);
                tambahProd.getSimpan().addActionListener(new listener("simpan produk"));
                tambahProd.getBatal().addActionListener(new listener("batal produk"));
                break;
            default:
                JOptionPane.showMessageDialog(null, "Tampilan Tidak Tersedia");
                new produksi("stok");
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
                case "tambah stok":
                    int ID = Integer.valueOf(stok.getTabelStok().getValueAt(baris, 0).toString());
                    int jmlStok = Integer.valueOf(stok.getTabelStok().getValueAt(baris, 3).toString());
                    String input = JOptionPane.showInputDialog(stok, "Jumlah", "Tambah Stok", JOptionPane.INFORMATION_MESSAGE);
                    if (!input.equalsIgnoreCase("")) {
                        int totalStok = Integer.valueOf(input) + jmlStok;
                        model.updateStok(totalStok, ID);
                        stok.getTambah_stok().setEnabled(false);
                        stok.getTabelStok().setModel(model.getStok());
                    }
                    break;
                case "tambah":
                    new produksi("tambah produk");
                    produk.dispose();
                    ;
                    break;
                case "simpan produk":
                    String nama = tambahProd.getNama().getText();
                    String tipe = tambahProd.getTipe().getSelectedItem().toString();
                    int harga = Integer.valueOf(tambahProd.getHarga().getText().trim());

                    if (nama.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Nama Harus Diisi");
                    }
                    if (tambahProd.getHarga().getText().trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Harga Harus Diisi");
                    }
                    if (tipe.equalsIgnoreCase("pilih...")) {
                        JOptionPane.showMessageDialog(null, "Pilih Tipe yang Sesuai!!");
                    }

                    if (!nama.trim().equalsIgnoreCase("") && !tambahProd.getHarga().getText().trim().equalsIgnoreCase("") && !tipe.equalsIgnoreCase("pilih...")) {
                        Produk p = new Produk(0, nama, tipe, harga);
                        if (model.insertProduk(p)) {
                            JOptionPane.showMessageDialog(null, "Berhasil");
                            new produksi("produk");
                            tambahProd.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Gagal");
                        }
                    }
                    break;
                case "batal produk":
                    new produksi("produk");
                    tambahProd.dispose();
                    break;
                case "ubah":
                    break;
                case "hapus":
                    int IDProdukHapus = Integer.valueOf(produk.getTabelProduk().getValueAt(baris, 0).toString());
                    int pilihan = JOptionPane.showConfirmDialog(produk, "Yakin Dihapus?", "Hapus", JOptionPane.YES_NO_OPTION);
                    if (pilihan == JOptionPane.YES_OPTION) {
                        if (model.deleteProduk(IDProdukHapus)) {
                            JOptionPane.showMessageDialog(null, "Berhasil");
                            produk.getTabelProduk().setModel(model.getProduk());
                        } else {
                            JOptionPane.showMessageDialog(null, "Gagal");
                        }
                    } else {
                        //tidak ada
                    }
                    break;
                case "kembali":
                    new produksi("stok");
                    produk.dispose();
                    break;
                case "lihat produk":
                    new produksi("produk");
                    stok.dispose();
                    break;
                case "logout":
                    new login();
                    stok.dispose();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Belum Di implementasi");

            }
        }

    }

    private class tabelListener implements MouseListener {

        String tabel;

        public tabelListener(String tab) {
            tabel = tab;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (tabel) {
                case "tabel stok":
                    baris = stok.getTabelStok().getSelectedRow();
                    stok.getTambah_stok().setEnabled(true);
                    break;
                case "tabel produk":
                    baris = produk.getTabelProduk().getSelectedRow();
                    produk.getHapus().setEnabled(true);
                    produk.getUbah().setEnabled(true);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Belum Diimplementasi");
            }
        }

        //<editor-fold defaultstate="collapsed" desc="tidak dipaka">
        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
        //</editor-fold>

    }
}
