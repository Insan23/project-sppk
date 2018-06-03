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
public class KriteriaProduk {
    int IDProduk;
    int IDKriteria;
    String NamaProduk;
    String NamaKriteria;
    double Nilai;

    public KriteriaProduk(int IDProduk, int IDKriteria, String NamaProduk, String NamaKriteria, double Nilai) {
        this.IDProduk = IDProduk;
        this.IDKriteria = IDKriteria;
        this.NamaProduk = NamaProduk;
        this.NamaKriteria = NamaKriteria;
        this.Nilai = Nilai;
    }

    public int getIDProduk() {
        return IDProduk;
    }

    public void setIDProduk(int IDProduk) {
        this.IDProduk = IDProduk;
    }

    public int getIDKriteria() {
        return IDKriteria;
    }

    public void setIDKriteria(int IDKriteria) {
        this.IDKriteria = IDKriteria;
    }

    public String getNamaProduk() {
        return NamaProduk;
    }

    public void setNamaProduk(String NamaProduk) {
        this.NamaProduk = NamaProduk;
    }

    public String getNamaKriteria() {
        return NamaKriteria;
    }

    public void setNamaKriteria(String NamaKriteria) {
        this.NamaKriteria = NamaKriteria;
    }

    public double getNilai() {
        return Nilai;
    }

    public void setNilai(double Nilai) {
        this.Nilai = Nilai;
    }
    
}
