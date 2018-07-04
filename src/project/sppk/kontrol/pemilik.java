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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project.sppk.model.Kriteria;
import project.sppk.model.KriteriaProduk;
import project.sppk.model.Produk;
import project.sppk.model.laporan;
import project.sppk.tampilan.login;
import project.sppk.tampilan.pemilikDetailTransaksi;
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
    pemilikDetailTransaksi detail;
    pemilikSPPK rangking;
    pemilikPerhitungan perhitungan;
    pemilikTransaksi transaksi;

    laporan model;

    DefaultTableModel tabelKriteriaProduk;
    DefaultTableModel tabelRanking;
    DefaultTableModel tabelNormalisasi;
    DefaultTableModel tabelPerkalianNormalisasi;
    DefaultTableModel tabelBobot;

    ArrayList<Produk> produk;
    ArrayList<Kriteria> kriteria;
    ArrayList<KriteriaProduk> kriteriaproduk;

    public pemilik() {
        laporan = new pemilikLaporan();
        detail = new pemilikDetailTransaksi();
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
        laporan.getLihat().setEnabled(false);
        laporan.getTabelTransaksi().addMouseListener(new tabelListener());
        
        detail.getKembali().addActionListener(new listener("detail kembali"));

        rangking.getKembali().addActionListener(new listener("ke laporan"));
        rangking.getDetailPerhitungan().addActionListener(new listener("perhitungan"));

        perhitungan.getKembali().addActionListener(new listener("ke rangking"));
        perhitungan.getNormalisasi().addActionListener(new listener("tabel normalisasi"));
        perhitungan.getPerkalian().addActionListener(new listener("tabel perkalian"));
        perhitungan.getKriteria().addActionListener(new listener("tabel kriteria"));
        perhitungan.getBobot().addActionListener(new listener("bobot"));

        laporan.setVisible(true);

        getSemua();
        hitungNormalisasi();
        hitungPerkalian();
        urutkan();
    }

    private class tabelListener implements MouseListener {

        public tabelListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (laporan.getComboBulan().isEnabled()) {
                if (!laporan.getComboBulan().getSelectedItem().toString().equalsIgnoreCase("pilih")) {
                    laporan.getLihat().setEnabled(true);
                }
            }
        }

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
                    detail.setVisible(true);
                    String kode = laporan.getTabelTransaksi().getValueAt(
                            laporan.getTabelTransaksi().getSelectedRow()
                            , 0).toString();
                    detail.getTabelDetail().setModel(model.getDataPerTransaksi(kode));
                    break;
                case "rangking":
                    rangking.setVisible(true);
                    laporan.setVisible(false);
                    rangking.getTabelRangking().setModel(tabelRanking);
                    break;
                case "logout":
                    new user();
                    laporan.dispose();
                    break;
                case "tahun":
                    String tahun = laporan.getComboTahun().getSelectedItem().toString();
                    laporan.getLihat().setEnabled(false);
                    if (!tahun.equalsIgnoreCase("pilih")) {
                        laporan.getComboBulan().setModel(model.getBulan(tahun));
                        laporan.getComboBulan().setEnabled(true);
                    }
                    break;
                case "bulan":
                    String bulan = laporan.getComboBulan().getSelectedItem().toString();
                    if (!bulan.equalsIgnoreCase("pilih")) {
                        laporan.getTabelTransaksi().setModel(model.getDataBulanan(bulan));
                    }
                    break;
                case "perhitungan":
                    rangking.setVisible(false);
                    perhitungan.setVisible(true);
                    perhitungan.getTabelPerhitungan().setModel(tabelKriteriaProduk);
                    break;
                case "ke laporan":
                    rangking.setVisible(false);
                    laporan.setVisible(true);
                    break;
                case "ke rangking":
                    perhitungan.setVisible(false);
                    rangking.setVisible(true);
                    break;
                case "tabel normalisasi":
                    perhitungan.getTabelPerhitungan().setModel(tabelNormalisasi);
                    break;
                case "tabel perkalian":
                    perhitungan.getTabelPerhitungan().setModel(tabelPerkalianNormalisasi);
                    break;
                case "tabel kriteria":
                    perhitungan.getTabelPerhitungan().setModel(tabelKriteriaProduk);
                    break;
                case "bobot":
                    perhitungan.getTabelPerhitungan().setModel(tabelBobot);
                    break;
                case "detail kembali":
                    detail.setVisible(false);
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
        String kolomRangking[] = {"Nama Produk", "Ranking", "Saran Penambahan Produksi"};
        String kolomBobot[] = {"Nama Kriteria", "Bobot"};
        tabelKriteriaProduk = new DefaultTableModel(null, kolomKriteriaProduk);
        tabelNormalisasi = new DefaultTableModel(null, kolomNormalisasi);
        tabelPerkalianNormalisasi = new DefaultTableModel(null, kolomPerkalian);
        tabelRanking = new DefaultTableModel(null, kolomRangking);
        tabelBobot = new DefaultTableModel(null, kolomBobot);
        for (Kriteria k : kriteria) {
            Object data[] = new Object[2];
            data[0] = k.getNama();
            data[1] = k.getBobot();
            tabelBobot.addRow(data);
        }
        for (Produk p : produk) {
            Object data[] = new Object[5];
            for (int i = 0; i < kriteriaproduk.size(); i++) {
                if (kriteriaproduk.get(i).getIDProduk() == p.getID()) {
                    data[0] = kriteriaproduk.get(i).getNamaProduk();
                    switch (kriteriaproduk.get(i).getIDKriteria()) {
                        case 1:
                            data[1] = kriteriaproduk.get(i).getNilai();
                            break;
                        case 2:
                            data[2] = kriteriaproduk.get(i).getNilai();
                            break;
                        case 3:
                            data[3] = kriteriaproduk.get(i).getNilai();
                            break;
                        case 4:
                            data[4] = kriteriaproduk.get(i).getNilai();
                            break;
                        default:
                            throw new AssertionError();
                    }
                }
            }
            tabelKriteriaProduk.addRow(data);
        }
    }

    private void hitungNormalisasi() {
        double min[] = new double[tabelKriteriaProduk.getColumnCount() - 1];
        double max[] = new double[tabelKriteriaProduk.getColumnCount() - 1];

        for (int i = 0; i < tabelKriteriaProduk.getColumnCount() - 1; i++) {
            min[i] = Double.valueOf(tabelKriteriaProduk.getValueAt(0, i + 1).toString());
            max[i] = Double.valueOf(tabelKriteriaProduk.getValueAt(0, i + 1).toString());
            for (int j = 1; j < tabelKriteriaProduk.getRowCount(); j++) {
                double tmin = Double.valueOf(tabelKriteriaProduk.getValueAt(j, i + 1).toString());
                double tmax = Double.valueOf(tabelKriteriaProduk.getValueAt(j, i + 1).toString());
                if (tmin < min[i]) {
                    min[i] = tmax;
                }
                if (tmax > max[i]) {
                    max[i] = tmax;
                }
            }
        }

        for (int i = 0; i < tabelKriteriaProduk.getRowCount(); i++) {
            Object data[] = new Object[tabelKriteriaProduk.getColumnCount()];
            data[0] = tabelKriteriaProduk.getValueAt(i, 0);
            for (int j = 0; j < tabelKriteriaProduk.getColumnCount() - 1; j++) {
                double x = Double.valueOf(tabelKriteriaProduk.getValueAt(i, j + 1).toString());
                double xmin = min[j];
                double xmax = max[j];
                double norm = (x - xmin) / (xmax - xmin);
                data[j + 1] = norm;
            }
            tabelNormalisasi.addRow(data);
        }
    }

    private void hitungPerkalian() {
        for (int i = 0; i < tabelNormalisasi.getRowCount(); i++) {
            double total = 0.0;
            for (int j = 1; j < tabelNormalisasi.getColumnCount(); j++) {
                double t = Double.valueOf(tabelNormalisasi.getValueAt(i, j).toString());
                total += t * kriteria.get(j - 1).getBobot();
            }
            Object data[] = new Object[2];
            data[0] = tabelNormalisasi.getValueAt(i, 0);
            data[1] = total;
            tabelPerkalianNormalisasi.addRow(data);
        }
    }

    private void urutkan() {
        DefaultTableModel tmp = tabelPerkalianNormalisasi;

        for (int i = 0; i < tmp.getRowCount(); i++) {
            for (int j = 1; j < tmp.getRowCount() - i; j++) {
                double t1 = Double.valueOf(tmp.getValueAt(j - 1, 1).toString());
                Object n1 = tmp.getValueAt(j - 1, 0);
                double t2 = Double.valueOf(tmp.getValueAt(j, 1).toString());
                Object n2 = tmp.getValueAt(j, 0);
                if (t1 < t2) {
                    tmp.setValueAt(t2, j - 1, 1);
                    tmp.setValueAt(t1, j, 1);
                    tmp.setValueAt(n2, j - 1, 0);
                    tmp.setValueAt(n1, j, 0);
                }
            }
        }
        tmp.addColumn("Saran Penambahan Produksi");
        for (int i = 0; i < tmp.getRowCount(); i++) {
            tmp.setValueAt((i + 1), i, 1);
        }

        for (int i = 0; i < tmp.getRowCount(); i++) {
            int penambahan = ((tmp.getRowCount() / 2) * 10) - i * 10;
            if (penambahan < 0) {
                penambahan = 0;
            }
            tmp.setValueAt(penambahan + " bungkus", i, 2);
        }

        tabelRanking = tmp;
    }
}
