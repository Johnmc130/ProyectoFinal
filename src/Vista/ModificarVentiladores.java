/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author EDU
 */
public class ModificarVentiladores extends javax.swing.JFrame {

    /**
     * Creates new form ModificarVentiladores
     */
    public ModificarVentiladores() {
        initComponents();
    }

    public JButton getBtnCargardatos() {
        return BtnCargardatos;
    }

    public void setBtnCargardatos(JButton BtnCargardatos) {
        this.BtnCargardatos = BtnCargardatos;
    }
    
    

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(JButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public JRadioButton getRbNo() {
        return rbNo;
    }

    public void setRbNo(JRadioButton rbNo) {
        this.rbNo = rbNo;
    }

    public JRadioButton getRbSi() {
        return rbSi;
    }

    public void setRbSi(JRadioButton rbSi) {
        this.rbSi = rbSi;
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

    public JSpinner getSpTamaño() {
        return spTamaño;
    }

    public void setSpTamaño(JSpinner spTamaño) {
        this.spTamaño = spTamaño;
    }

    public JTable getTblVentilador() {
        return tblVentilador;
    }

    public void setTblVentilador(JTable tblVentilador) {
        this.tblVentilador = tblVentilador;
    }

    public JTextField getTxtIdV() {
        return txtIdV;
    }

    public void setTxtIdV(JTextField txtIdV) {
        this.txtIdV = txtIdV;
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
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        txtbuscarproc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnCargarImgmodiproc = new javax.swing.JButton();
        txtmarcamodiproc = new javax.swing.JTextField();
        btnBuscarproc = new javax.swing.JButton();
        txtmodelomodiproc = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        btAtras1 = new javax.swing.JToggleButton();
        jLabel30 = new javax.swing.JLabel();
        txtmarca = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtmodelo = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        rbSi = new javax.swing.JRadioButton();
        rbNo = new javax.swing.JRadioButton();
        jLabel33 = new javax.swing.JLabel();
        spTamaño = new javax.swing.JSpinner();
        jLabel28 = new javax.swing.JLabel();
        spPrecio = new javax.swing.JSpinner();
        jLabel36 = new javax.swing.JLabel();
        spStock = new javax.swing.JSpinner();
        txtIdV = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVentilador = new javax.swing.JTable();
        BtnCargardatos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnModificar.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        btnModificar.setText("Modificar");
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, -1, -1));

        txtbuscarproc.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtbuscarproc.setBorder(null);
        jPanel1.add(txtbuscarproc, new org.netbeans.lib.awtextra.AbsoluteConstraints(684, 95, 210, -1));

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 159, 159));

        btnCargarImgmodiproc.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        btnCargarImgmodiproc.setText("Cargar Imagen");
        jPanel1.add(btnCargarImgmodiproc, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 92, -1, -1));

        txtmarcamodiproc.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtmarcamodiproc.setBorder(null);
        jPanel1.add(txtmarcamodiproc, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 128, -1, -1));

        btnBuscarproc.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        btnBuscarproc.setText("Buscar");
        jPanel1.add(btnBuscarproc, new org.netbeans.lib.awtextra.AbsoluteConstraints(566, 92, -1, -1));

        txtmodelomodiproc.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtmodelomodiproc.setBorder(null);
        jPanel1.add(txtmodelomodiproc, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 156, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 212, 250), 3));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(37, 53, 124));
        jLabel20.setText(" Ventiladores");

        btAtras1.setBackground(new java.awt.Color(255, 255, 255));
        btAtras1.setFont(new java.awt.Font("Montserrat Black", 1, 48)); // NOI18N
        btAtras1.setForeground(new java.awt.Color(0, 212, 250));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btAtras1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 936, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btAtras1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, -1));

        jLabel30.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Marca:");
        jLabel30.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 140, -1));

        txtmarca.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtmarca.setBorder(null);
        jPanel1.add(txtmarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 146, -1));

        jLabel31.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Modelo:");
        jLabel31.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 197, 140, -1));

        txtmodelo.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtmodelo.setBorder(null);
        jPanel1.add(txtmodelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 148, -1));

        jLabel32.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel32.setText("RGB:");
        jLabel32.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 225, -1, 30));

        rbSi.setText("SI");
        jPanel1.add(rbSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 234, -1, -1));

        rbNo.setText("No");
        rbNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNoActionPerformed(evt);
            }
        });
        jPanel1.add(rbNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 234, -1, -1));

        jLabel33.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("Tamaño:");
        jLabel33.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 269, 112, -1));

        spTamaño.setFont(new java.awt.Font("Montserrat Thin", 0, 18)); // NOI18N
        jPanel1.add(spTamaño, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 269, 60, -1));

        jLabel28.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Precio:");
        jLabel28.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 140, -1));

        spPrecio.setFont(new java.awt.Font("Montserrat Thin", 0, 18)); // NOI18N
        spPrecio.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        jPanel1.add(spPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 60, -1));

        jLabel36.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Stock:");
        jLabel36.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 140, -1));

        spStock.setFont(new java.awt.Font("Montserrat Thin", 0, 18)); // NOI18N
        jPanel1.add(spStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 60, -1));

        txtIdV.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtIdV.setBorder(null);
        jPanel1.add(txtIdV, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 146, -1));

        jLabel34.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("Id Ventilador:");
        jLabel34.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 140, -1));

        tblVentilador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Ventilador", "Marca", "Modelo", "RGB", "Tamaño", "Precio", "Stock"
            }
        ));
        jScrollPane1.setViewportView(tblVentilador);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 642, 397));

        BtnCargardatos.setText("Cargar Datos");
        jPanel1.add(BtnCargardatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 145, 45));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbNoActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCargardatos;
    private javax.swing.JToggleButton btAtras1;
    private javax.swing.JButton btnBuscarproc;
    private javax.swing.JButton btnCargarImgmodiproc;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbNo;
    private javax.swing.JRadioButton rbSi;
    private javax.swing.JSpinner spPrecio;
    private javax.swing.JSpinner spStock;
    private javax.swing.JSpinner spTamaño;
    private javax.swing.JTable tblVentilador;
    private javax.swing.JTextField txtIdV;
    private javax.swing.JTextField txtbuscarproc;
    private javax.swing.JTextField txtmarca;
    private javax.swing.JTextField txtmarcamodiproc;
    private javax.swing.JTextField txtmodelo;
    private javax.swing.JTextField txtmodelomodiproc;
    // End of variables declaration//GEN-END:variables
}
