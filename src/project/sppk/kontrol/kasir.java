/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.sppk.kontrol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import project.sppk.model.Produk;
import project.sppk.model.Transaksi;
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

    ArrayList<Produk> produk;
    DefaultTableModel tabelTransaksi;

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
                String kolom[] = {"ID Produk", "Nama", "Jumlah", "Total"};
                tabelTransaksi = new DefaultTableModel(null, kolom);
                transaksi = new kasirTransaksi();
                transaksi.setVisible(true);
                transaksi.getKembali().addActionListener(new listener("kembali"));
                transaksi.getTambah().addActionListener(new listener("tambah transaksi"));
                transaksi.getTipe().addActionListener(new listener("tipe"));
                transaksi.getProduk().addActionListener(new listener("produk"));
                transaksi.getSelesai().addActionListener(new listener("selesai"));

                transaksi.getProduk().setEnabled(false);
                transaksi.getTambah().setEnabled(false);
                transaksi.getSelesai().setEnabled(false);

                transaksi.getTabelTransaksi().setModel(tabelTransaksi);

                //transaksi.getJumlah().getDocument().addDocumentListener(new DocumentListener() {
//                    @Override
//                    public void insertUpdate(DocumentEvent e) {
//                        hitung();
//                    }
//
//                    @Override
//                    public void removeUpdate(DocumentEvent e) {
//                        hitung();
//                    }
//
//                    @Override
//                    public void changedUpdate(DocumentEvent e) {
//                        hitung();
//                    }
//
//                    public void hitung() {
//                        if (!transaksi.getJumlah().getText().equalsIgnoreCase("")) {
//                            int jumlah = Integer.valueOf(transaksi.getJumlah().getText());
//                            int harga = produk.get(
//                                    transaksi.getProduk().getSelectedIndex()
//                            ).getHarga();
//                            int total = jumlah * harga;
//                            transaksi.getTotal().setText("" + total);
//                            transaksi.getTambah().setEnabled(true);
//                        }
//                    }
//                });
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
                    new kasir("transaksi");
                    home.dispose();
                    break;
                case "tambah transaksi":
                    Object perTransaksi[] = new Object[4];

                    perTransaksi[0] = produk.get(transaksi.getProduk().getSelectedIndex()).getID();
                    perTransaksi[1] = transaksi.getProduk().getSelectedItem().toString();
                    perTransaksi[2] = Integer.valueOf(transaksi.getJumlah().getText());
                    int harga = produk.get(transaksi.getProduk().getSelectedIndex()).getHarga();
                    perTransaksi[3] = Integer.valueOf(transaksi.getJumlah().getText()) * harga;

                    tabelTransaksi.addRow(perTransaksi);
                    transaksi.getTabelTransaksi().setModel(tabelTransaksi);

                    transaksi.getTipe().setSelectedIndex(0);
                    transaksi.getProduk().setModel(new DefaultComboBoxModel<>());
                    transaksi.getProduk().setEnabled(false);
                    transaksi.getTambah().setEnabled(false);
                    transaksi.getSelesai().setEnabled(false);
                    break;
                case "selesai":
                    ArrayList<Transaksi> tran = new ArrayList<>();
                    for (int i = 0; i < tabelTransaksi.getRowCount(); i++) {
                        int ID = Integer.valueOf(tabelTransaksi.getValueAt(i, 0).toString());
                        int jumlah = Integer.valueOf(tabelTransaksi.getValueAt(i, 2).toString());
                        int total = Integer.valueOf(tabelTransaksi.getValueAt(i, 3).toString());
                        Transaksi tr = new Transaksi(ID, jumlah, total);
                        tran.add(tr);
                    }
                    model.insertDataPenjualan(tran);
                    break;
                case "kembali":
                    new kasir("home");
                    transaksi.dispose();
                    break;
                case "tipe":
                    String tipe = transaksi.getTipe().getSelectedItem().toString();
                    if (!tipe.equalsIgnoreCase("pilih...")) {
                        produk = model.getProdukPerTipe(tipe);
                        Object data[] = {};
                        DefaultComboBoxModel produkModel = new DefaultComboBoxModel(data);
                        for (Produk per : produk) {
                            produkModel.addElement(per.getNama());
                        }
                        transaksi.getProduk().setModel(produkModel);
                        transaksi.getProduk().setEnabled(true);
                    }
                    break;
                case "produk":
                    transaksi.getJumlah().setEnabled(true);
                    break;
                case "logout":
                    new user();
                    home.dispose();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Belum Di implementasi");
            }
        }

    }
}
