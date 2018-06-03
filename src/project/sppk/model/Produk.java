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
public class Produk {
    int ID;
    String Nama;
    String Tipe;
    int Harga;

    public Produk(int ID, String Nama, String Tipe, int Harga) {
        this.ID = ID;
        this.Nama = Nama;
        this.Tipe = Tipe;
        this.Harga = Harga;
    }

    

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public int getHarga() {
        return Harga;
    }

    public void setHarga(int Harga) {
        this.Harga = Harga;
    }

    public String getTipe() {
        return Tipe;
    }

    public void setTipe(String Tipe) {
        this.Tipe = Tipe;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
}
