/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 *
 * @author MAX COMPUTERS
 */
public class CrearProcesador extends javax.swing.JFrame {

    /**
     * Creates new form CrudProcesador
     */
    public CrearProcesador() {
        initComponents();
    }

    public JToggleButton getBtAtrascrea() {
        return btAtrascrea;
    }

    public void setBtAtrascrea(JToggleButton btAtrascrea) {
        this.btAtrascrea = btAtrascrea;
    }

    public JLabel getLbprocesador() {
        return lbprocesador;
    }

    public void setLbprocesador(JLabel lbprocesador) {
        this.lbprocesador = lbprocesador;
    }
    

    public JButton getBtncagaprocesa() {
        return btncagaprocesa;
    }

    public void setBtncagaprocesa(JButton btncagaprocesa) {
        this.btncagaprocesa = btncagaprocesa;
    }

    public JComboBox<String> getCbproveedorcreaproc() {
        return cbproveedorcreaproc;
    }

    public void setCbproveedorcreaproc(JComboBox<String> cbproveedorcreaproc) {
        this.cbproveedorcreaproc = cbproveedorcreaproc;
    }

    public JLabel getLbIdcreaproc() {
        return lbIdcreaproc;
    }

    public void setLbIdcreaproc(JLabel lbIdcreaproc) {
        this.lbIdcreaproc = lbIdcreaproc;
    }

    public JSpinner getSpRamcreaproc() {
        return spRamcreaproc;
    }

    public void setSpRamcreaproc(JSpinner spRamcreaproc) {
        this.spRamcreaproc = spRamcreaproc;
    }

    public JSpinner getSpWattscreaproc() {
        return spWattscreaproc;
    }

    public void setSpWattscreaproc(JSpinner spWattscreaproc) {
        this.spWattscreaproc = spWattscreaproc;
    }

    public JSpinner getSpnucleoscreaproc() {
        return spnucleoscreaproc;
    }

    public void setSpnucleoscreaproc(JSpinner spnucleoscreaproc) {
        this.spnucleoscreaproc = spnucleoscreaproc;
    }

    public JTextField getTxtghzcreaproc() {
        return txtghzcreaproc;
    }

    public void setTxtghzcreaproc(JTextField txtghzcreaproc) {
        this.txtghzcreaproc = txtghzcreaproc;
    }

    public JTextField getTxtmarcacreaproc() {
        return txtmarcacreaproc;
    }

    public void setTxtmarcacreaproc(JTextField txtmarcacreaproc) {
        this.txtmarcacreaproc = txtmarcacreaproc;
    }

    public JTextField getTxtmodelocreaproc() {
        return txtmodelocreaproc;
    }

    public void setTxtmodelocreaproc(JTextField txtmodelocreaproc) {
        this.txtmodelocreaproc = txtmodelocreaproc;
    }

    public JTextField getTxtpreciocreaproc() {
        return txtpreciocreaproc;
    }

    public void setTxtpreciocreaproc(JTextField txtpreciocreaproc) {
        this.txtpreciocreaproc = txtpreciocreaproc;
    }

    public JTextField getTxtsocketcreaproc() {
        return txtsocketcreaproc;
    }

    public void setTxtsocketcreaproc(JTextField txtsocketcreaproc) {
        this.txtsocketcreaproc = txtsocketcreaproc;
    }

    public JButton getBtnCrearproc() {
        return btnCrearproc;
    }

    public void setBtnCrearproc(JButton btnCrearproc) {
        this.btnCrearproc = btnCrearproc;
    }

    public JSpinner getSpStockcreaproc() {
        return spStockcreaproc;
    }

    public void setSpStockcreaproc(JSpinner spStockcreaproc1) {
        this.spStockcreaproc = spStockcreaproc1;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btnCrearproc = new javax.swing.JButton();
        txtsocketcreaproc = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        spRamcreaproc = new javax.swing.JSpinner();
        jLabel26 = new javax.swing.JLabel();
        spWattscreaproc = new javax.swing.JSpinner();
        jLabel27 = new javax.swing.JLabel();
        txtpreciocreaproc = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lbIdcreaproc = new javax.swing.JLabel();
        cbproveedorcreaproc = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        txtmarcacreaproc = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtmodelocreaproc = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtghzcreaproc = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        spnucleoscreaproc = new javax.swing.JSpinner();
        jLabel34 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        btAtrascrea = new javax.swing.JToggleButton();
        btncagaprocesa = new javax.swing.JButton();
        lbprocesador = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        spStockcreaproc = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 212, 250), 3));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        btnCrearproc.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        btnCrearproc.setText("Crear");

        txtsocketcreaproc.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtsocketcreaproc.setBorder(null);

        jLabel25.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Máximo Ram:");
        jLabel25.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        spRamcreaproc.setFont(new java.awt.Font("Montserrat Thin", 0, 18)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Watts:");
        jLabel26.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        spWattscreaproc.setFont(new java.awt.Font("Montserrat Thin", 0, 18)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Proveedor");
        jLabel27.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtpreciocreaproc.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtpreciocreaproc.setBorder(null);

        jLabel28.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Precio:");
        jLabel28.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel29.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("ID Procesador:");
        jLabel29.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lbIdcreaproc.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lbIdcreaproc.setText("--");
        lbIdcreaproc.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        cbproveedorcreaproc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel30.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Marca:");
        jLabel30.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtmarcacreaproc.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtmarcacreaproc.setBorder(null);

        jLabel31.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Modelo:");
        jLabel31.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtmodelocreaproc.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtmodelocreaproc.setBorder(null);

        jLabel32.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel32.setText("Núcleos Físicos:");
        jLabel32.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtghzcreaproc.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtghzcreaproc.setBorder(null);

        jLabel33.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("GHz:");
        jLabel33.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        spnucleoscreaproc.setFont(new java.awt.Font("Montserrat Thin", 0, 18)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("Socket:");
        jLabel34.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 212, 250), 3));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(37, 53, 124));
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo.png"))); // NOI18N
        jLabel35.setText("Procesadores");

        btAtrascrea.setBackground(new java.awt.Color(255, 255, 255));
        btAtrascrea.setFont(new java.awt.Font("Montserrat Black", 1, 48)); // NOI18N
        btAtrascrea.setForeground(new java.awt.Color(0, 212, 250));
        btAtrascrea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(btAtrascrea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btAtrascrea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btncagaprocesa.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        btncagaprocesa.setText("Cargar Imagen");

        lbprocesador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel36.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Stock:");
        jLabel36.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        spStockcreaproc.setFont(new java.awt.Font("Montserrat Thin", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(spnucleoscreaproc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtghzcreaproc)
                            .addComponent(txtsocketcreaproc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbIdcreaproc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtmarcacreaproc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtmodelocreaproc)))))
                .addGap(74, 74, 74)
                .addComponent(btncagaprocesa)
                .addGap(18, 18, 18)
                .addComponent(lbprocesador, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(spRamcreaproc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(spWattscreaproc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(btnCrearproc))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(spStockcreaproc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(txtpreciocreaproc))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(cbproveedorcreaproc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(lbIdcreaproc))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(txtmarcacreaproc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(txtmodelocreaproc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel33)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel34))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(spnucleoscreaproc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtghzcreaproc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtsocketcreaproc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btncagaprocesa))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lbprocesador, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(spRamcreaproc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(spWattscreaproc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(txtpreciocreaproc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(spStockcreaproc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(cbproveedorcreaproc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(btnCrearproc))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

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
            java.util.logging.Logger.getLogger(CrearProcesador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearProcesador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearProcesador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearProcesador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearProcesador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btAtrascrea;
    private javax.swing.JButton btnCrearproc;
    private javax.swing.JButton btncagaprocesa;
    private javax.swing.JComboBox<String> cbproveedorcreaproc;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbIdcreaproc;
    private javax.swing.JLabel lbprocesador;
    private javax.swing.JSpinner spRamcreaproc;
    private javax.swing.JSpinner spStockcreaproc;
    private javax.swing.JSpinner spWattscreaproc;
    private javax.swing.JSpinner spnucleoscreaproc;
    private javax.swing.JTextField txtghzcreaproc;
    private javax.swing.JTextField txtmarcacreaproc;
    private javax.swing.JTextField txtmodelocreaproc;
    private javax.swing.JTextField txtpreciocreaproc;
    private javax.swing.JTextField txtsocketcreaproc;
    // End of variables declaration//GEN-END:variables
}