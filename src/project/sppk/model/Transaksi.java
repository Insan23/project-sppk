/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.sppk.model;

/**
 *
 * @author ASUS
 */
public class Transaksi {
    int IDProduk;
    int Jumlah;
    int total;

    public Transaksi(int IDProduk, int Jumlah, int total) {
        this.IDProduk = IDProduk;
        this.Jumlah = Jumlah;
        this.total = total;
    }

    public int getIDProduk() {
        return IDProduk;
    }

    public void setIDProduk(int IDProduk) {
        this.IDProduk = IDProduk;
    }

    public int getJumlah() {
        return Jumlah;
    }

    public void setJumlah(int Jumlah) {
        this.Jumlah = Jumlah;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
}
