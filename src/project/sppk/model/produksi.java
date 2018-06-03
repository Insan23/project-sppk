/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.sppk.model;

import java.sql.Connection;
import project.sppk.koneksi.koneksi;

/**
 *
 * @author ASUS
 */
public class produksi {
    Connection koneksi;
    
    public produksi() {
        koneksi = new koneksi().getKoneksi();
    }
    
    
}
