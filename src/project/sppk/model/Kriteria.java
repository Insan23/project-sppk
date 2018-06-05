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
public class Kriteria {
    int ID;
    String Nama;
    double Bobot;

    public Kriteria(int ID, String Nama, double Bobot) {
        this.ID = ID;
        this.Nama = Nama;
        this.Bobot = Bobot;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public double getBobot() {
        return Bobot;
    }

    public void setBobot(double Bobot) {
        this.Bobot = Bobot;
    }
    
}
