/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 *
 * @author EDU
 */
public class CrearMemoriaRam extends javax.swing.JFrame {

    /**
     * Creates new form CrearMemoriaRam
     */
    public CrearMemoriaRam() {
        initComponents();
    }

    public JButton getBtnCargarI() {
        return btnCargarI;
    }

    public void setBtnCargarI(JButton btnCargarI) {
        this.btnCargarI = btnCargarI;
    }

    public JButton getBtnImagenProducto() {
        return btnImagenProducto;
    }

    public void setBtnImagenProducto(JButton btnImagenProducto) {
        this.btnImagenProducto = btnImagenProducto;
    }

    public JComboBox<String> getCmbTipo() {
        return cmbTipo;
    }

    public void setCmbTipo(JComboBox<String> cmbTipo) {
        this.cmbTipo = cmbTipo;
    }

    public JButton getBtnCrear() {
        return btnCrear;
    }

    public void setBtnCrear(JButton btnCrear) {
        this.btnCrear = btnCrear;
    }

    public JRadioButton getRb1() {
        return rb1;
    }

    public void setRb1(JRadioButton rb1) {
        this.rb1 = rb1;
    }

    public JRadioButton getRb2() {
        return rb2;
    }

    public void setRb2(JRadioButton rb2) {
        this.rb2 = rb2;
    }

    public JSpinner getSpCapacidad() {
        return spCapacidad;
    }

    public void setSpCapacidad(JSpinner spCapacidad) {
        this.spCapacidad = spCapacidad;
    }

    public JSpinner getSpPrecio() {
        return spPrecio;
    }

    public void setSpPrecio(JSpinner spPrecio) {
        this.spPrecio = spPrecio;
    }

    public JSpinner getSpStock() {
        return spStock;
    }

    public void setSpStock(JSpinner spStock) {
        this.spStock = spStock;
    }

    public JTextField getTxtmarca() {
        return txtmarca;
    }

    public void setTxtmarca(JTextField txtmarca) {
        this.txtmarca = txtmarca;
    }

    public JTextField getTxtmodelo() {
        return txtmodelo;
    }

    public void setTxtmodelo(JTextField txtmodelo) {
        this.txtmodelo = txtmodelo;
    }

    public JToggleButton getBtAtras2() {
        return btAtras2;
    }

    public JTextField getTxtID() {
        return txtID;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        btnCrear = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        btAtras2 = new javax.swing.JToggleButton();
        rb1 = new javax.swing.JRadioButton();
        rb2 = new javax.swing.JRadioButton();
        jLabel30 = new javax.swing.JLabel();
        txtmarca = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtmodelo = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        spCapacidad = new javax.swing.JSpinner();
        jLabel34 = new javax.swing.JLabel();
        spPrecio = new javax.swing.JSpinner();
        jLabel37 = new javax.swing.JLabel();
        spStock = new javax.swing.JSpinner();
        btnCargarI = new javax.swing.JButton();
        btnImagenProducto = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 212, 250), 3));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCrear.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        btnCrear.setText("Crear");
        jPanel3.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 150, -1));

        jLabel32.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel32.setText("Numero modulos:");
        jPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 170, 40));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 212, 250), 3));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(37, 53, 124));
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logo.png"))); // NOI18N
        jLabel35.setText("Memoria Ram");

        btAtras2.setBackground(new java.awt.Color(255, 255, 255));
        btAtras2.setFont(new java.awt.Font("Montserrat Black", 1, 48)); // NOI18N
        btAtras2.setForeground(new java.awt.Color(0, 212, 250));
        btAtras2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(btAtras2)
                .addGap(146, 146, 146)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btAtras2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, -1, -1));

        buttonGroup1.add(rb1);
        rb1.setText("1");
        jPanel3.add(rb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 60, 40));

        buttonGroup1.add(rb2);
        rb2.setText("2");
        rb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb2ActionPerformed(evt);
            }
        });
        jPanel3.add(rb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 60, 40));

        jLabel30.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel30.setText("Marca:");
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 80, 40));

        txtmarca.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtmarca.setBorder(null);
        jPanel3.add(txtmarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 146, 40));

        jLabel31.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel31.setText("Modelo:");
        jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 80, 40));

        txtmodelo.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtmodelo.setBorder(null);
        jPanel3.add(txtmodelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 148, 40));

        jLabel36.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel36.setText("Tipo:");
        jPanel3.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 80, 40));

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "sdd", "hdd", "m2" }));
        jPanel3.add(cmbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 148, 40));

        jLabel33.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel33.setText("Capacidad:");
        jPanel3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 170, 40));

        spCapacidad.setFont(new java.awt.Font("Montserrat Thin", 0, 18)); // NOI18N
        jPanel3.add(spCapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 60, 40));

        jLabel34.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel34.setText("Precio:");
        jPanel3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 170, 40));

        spPrecio.setFont(new java.awt.Font("Montserrat Thin", 0, 18)); // NOI18N
        spPrecio.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        jPanel3.add(spPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 60, 40));

        jLabel37.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel37.setText("Stock:");
        jPanel3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 170, 40));

        spStock.setFont(new java.awt.Font("Montserrat Thin", 0, 18)); // NOI18N
        jPanel3.add(spStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 60, 40));

        btnCargarI.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        btnCargarI.setText("Cargar Imagen");
        jPanel3.add(btnCargarI, new org.netbeans.lib.awtextra.AbsoluteConstraints(656, 376, -1, -1));
        jPanel3.add(btnImagenProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(609, 125, 254, 239));

        jLabel38.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel38.setText("ID:");
        jPanel3.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 80, 40));

        txtID.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtID.setBorder(null);
        jPanel3.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 146, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btAtras2;
    private javax.swing.JButton btnCargarI;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnImagenProducto;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JSpinner spCapacidad;
    private javax.swing.JSpinner spPrecio;
    private javax.swing.JSpinner spStock;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtmarca;
    private javax.swing.JTextField txtmodelo;
    // End of variables declaration//GEN-END:variables
}
