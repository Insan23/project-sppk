/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.sppk.tampilan;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class tambahProduk extends javax.swing.JFrame {

    /**
     * Creates new form tambahProduk
     */
    public tambahProduk() {
        initComponents();
    }

    public JButton getBatal() {
        return batal;
    }

    public JTextField getHarga() {
        return harga;
    }

    public JTextField getNama() {
        return nama;
    }

    public JButton getSimpan() {
        return simpan;
    }

    public JComboBox<String> getTipe() {
        return tipe;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nama = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tipe = new javax.swing.JComboBox<>();
        harga = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        simpan = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nama.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 39, 142, -1));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel1.setText("Nama");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 42, -1, -1));

        tipe.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        tipe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih...", "Makanan Ringan", "Makanan Berat", "Makanan Penunjang" }));
        getContentPane().add(tipe, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 80, 142, -1));

        harga.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        getContentPane().add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 121, 142, -1));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel2.setText("Tipe");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 83, -1, -1));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel3.setText("Harga");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 124, -1, -1));

        simpan.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        simpan.setText("Simpan");
        getContentPane().add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 162, -1, -1));

        batal.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        batal.setText("Batal");
        getContentPane().add(batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 162, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/sppk/res/bg0.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tambahProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tambahProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tambahProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tambahProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tambahProduk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batal;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nama;
    private javax.swing.JButton simpan;
    private javax.swing.JComboBox<String> tipe;
    // End of variables declaration//GEN-END:variables
}
