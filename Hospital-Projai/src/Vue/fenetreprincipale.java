package Vue;

import Modele.RechercheInformations;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Louis
 */
public class fenetreprincipale extends javax.swing.JFrame {

    /**
     * Creates new form fenetreprincipale
     */
    public fenetreprincipale() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1026, 660));
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 54, 1030, 590);

        jButton1.setText("Ajouter un patient");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 10, 158, 29);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vue/cartoon-1295191_960_720.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        getContentPane().add(jButton3);
        jButton3.setBounds(980, 10, 40, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Patient", "Employe", "Numero", "Batiment", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(790, 10, 111, 27);

        jTextField1.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jTextField1.setText("Recherche");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(630, 10, 120, 30);

        jButton2.setText("Diagramme");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(220, 10, 116, 29);

        jButton4.setText("jButton4");
        getContentPane().add(jButton4);
        jButton4.setBounds(420, 20, 97, 29);

        jButton5.setText("jButton5");
        getContentPane().add(jButton5);
        jButton5.setBounds(0, 0, 97, 29);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vue/medical-free-vector-background-with-heart-monitor.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1030, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      this.setVisible(false);
      new ajoutPatient().setVisible(true);// TODO add your handling code here:
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

        JTextField text = (JTextField)evt.getSource();
        String textCast;
        textCast=text.getText();
        String choix;
        choix=jComboBox1.getSelectedItem().toString();
        RechercheInformations r1;
        
        r1=new RechercheInformations (textCast);
        ArrayList <String> resultatRecherche=null;
        try {
            resultatRecherche=r1.recherche(choix);
        } catch (SQLException ex) {
            Logger.getLogger(fenetreprincipale.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fenetreprincipale.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        switch(choix)
        {
            
            case "Patient" : 
            {
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [resultatRecherche.size()][6] ,
                new String [] {
                    "Numéro", "Nom", "Prénom", "Adresse", "Téléphone", "Mutuelle"
                }
                ));
                jScrollPane1.setViewportView(jTable1);

                getContentPane().add(jScrollPane1);
                jScrollPane1.setBounds(0, 54, 1030, 590);
                }
            break;
            case "Employe" : 
            {
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [resultatRecherche.size()][5] ,
                new String [] {
                    "Numéro", "Nom", "Prénom", "Adresse", "Téléphone"
                }
                ));
                jScrollPane1.setViewportView(jTable1);

                getContentPane().add(jScrollPane1);
                jScrollPane1.setBounds(0, 54, 1030, 590);
            }
            break;
            
            case "Numero" : 
            {
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [resultatRecherche.size()][5] ,
                new String [] {
                    "Numéro", "Nom", "Prénom", "Adresse", "Téléphone"
                }
                ));
                jScrollPane1.setViewportView(jTable1);

                getContentPane().add(jScrollPane1);
                jScrollPane1.setBounds(0, 54, 1030, 590);
            }
            break;
            case "Batiment" : 
            {
                
            }
            break;
                    
        }
        
        
        for(int i=0 ; i<resultatRecherche.size(); i++)
        {
            
            int champSuivant=0;
            String chaineTemp="";
            for(int j=0 ; j<resultatRecherche.get(i).length(); j++)
            {
                if(resultatRecherche.get(i).charAt(j)==';' || j==(resultatRecherche.get(i).length()-1))
                {
                    jTable1.setValueAt(chaineTemp, i, champSuivant);
                    champSuivant++;
                    chaineTemp="";
                }
                else
                {
                   chaineTemp+=resultatRecherche.get(i).charAt(j);
                }
            }
            
        }
        
        
        
        
        
        //jTable1.addColumn(new TableColumn(modelColumn, width, cellRenderer, cellEditor));
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       this.setVisible(false);
      new fenetreDiagramme().setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(fenetreprincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fenetreprincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fenetreprincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fenetreprincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fenetreprincipale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
