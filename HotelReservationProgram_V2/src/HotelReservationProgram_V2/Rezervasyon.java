/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelReservationProgram_V2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Abdussamet
 */
public class Rezervasyon extends javax.swing.JFrame {

    /**
     * Creates new form Rezervasyon
     */
    DefaultComboBoxModel dcm1 = new DefaultComboBoxModel();
    DefaultComboBoxModel dcm2 = new DefaultComboBoxModel();
    Connection conn;

    public Rezervasyon() {
        initComponents();
        for (int i = 1; i <= 10; i++) {
            dcm1.addElement("" + i);
        }
        jComboBoxGeceSayisi.setModel(dcm1);

        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
            Statement s = conn.createStatement();
            String sql = "SELECT * FROM Otel";
            ResultSet rs = s.executeQuery(sql);
            String sehir = "";
            while (rs.next()) {
                if (!sehir.equals(rs.getString("sehir"))) {
                    sehir = rs.getString("sehir");
                } else {
                    continue;
                }
                dcm2.addElement("" + rs.getString("sehir"));
            }
            jComboBoxSehir.setModel(dcm2);
        } catch (SQLException ex) {
            Logger.getLogger(Rezervasyon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxSehir = new javax.swing.JComboBox<>();
        jButtonOtelleriGoruntule = new javax.swing.JButton();
        jComboBoxGeceSayisi = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Gece Sayısı");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Şehir:");

        jButtonOtelleriGoruntule.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButtonOtelleriGoruntule.setText("Otelleri Görüntüle");
        jButtonOtelleriGoruntule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOtelleriGoruntuleActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Tarih:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonOtelleriGoruntule)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jComboBoxGeceSayisi, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxSehir, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel3)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxGeceSayisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonOtelleriGoruntule)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBoxSehir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(111, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOtelleriGoruntuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOtelleriGoruntuleActionPerformed
        if (jDateChooserTarih.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Lütfen bir tarih seçiniz!", "Uyarı!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String tarih = sdf.format(jDateChooserTarih.getDate());

        int günInt = Integer.parseInt(tarih.substring(0, 2)) + Integer.parseInt((String) jComboBoxGeceSayisi.getSelectedItem());

        DecimalFormat df = new DecimalFormat("00");

        String gün = df.format(günInt);
        String ay = (String) tarih.substring(3, 5);
        String yıl = (String) tarih.substring(6, 10);
        tarih = tarih + "/" + gün + "-" + ay + "-" + yıl;

        System.out.println(tarih);
        ArrayList<String> oteller = new ArrayList();
        String sehir = (String) jComboBoxSehir.getSelectedItem();

        try {
            Statement s = conn.createStatement();
            String sql = "SELECT * FROM Otel";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                if (sehir.equals(rs.getString("sehir"))) {
                    oteller.add(rs.getString("ad"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Rezervasyon.class.getName()).log(Level.SEVERE, null, ex);
        }

        Oteller o = new Oteller(oteller, tarih, Integer.parseInt((String)jComboBoxGeceSayisi.getSelectedItem()));
        o.setVisible(true);
    }//GEN-LAST:event_jButtonOtelleriGoruntuleActionPerformed

   
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
            java.util.logging.Logger.getLogger(Rezervasyon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rezervasyon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rezervasyon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rezervasyon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rezervasyon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOtelleriGoruntule;
    private javax.swing.JComboBox<String> jComboBoxGeceSayisi;
    private javax.swing.JComboBox<String> jComboBoxSehir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
