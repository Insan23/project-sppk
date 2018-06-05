/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.sppk.kontrol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import project.sppk.model.User;
import project.sppk.tampilan.login;

/**
 *
 * @author ASUS
 */
public class user {
    login view;
    User model;
    
    public user() {
        view = new login();
        model = new User();
        view.setVisible(true);
        view.getMasuk().addActionListener(new listener());
    }
    
    private class listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String user = view.getUsername().getText();
            String pass = view.getPassword().getText();
            if (user.equalsIgnoreCase("") || pass.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(view, "Harus Diisi", "Perhatian", JOptionPane.WARNING_MESSAGE);
            } else {
                String level = model.login(user, pass);
                
                switch (level) {
                    case "admin":
                        JOptionPane.showMessageDialog(view, "Belum Diimplementasi", "Perhatian", JOptionPane.WARNING_MESSAGE);
                        break;
                    case "pemilik":
                        new pemilik();
                        break;
                    case "kasir":
                        new kasir("home");
                        break;
                    case "gudang":
                        new produksi("stok");
                        break;
                    default:
                        JOptionPane.showMessageDialog(view, "Kesalahan Saat Membaca Data", "Perhatian", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        
    }
}
