/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 *
 * @author EDU
 */
public class EliminarDisipadores extends javax.swing.JFrame {

    /**
     * Creates new form EliminarDisipadores
     */
    public EliminarDisipadores() {
        initComponents();
    }

    public JTable getTblDisipadores() {
        return tblDisipadores;
    }

    public void setTblDisipadores(JTable tblDisipadores) {
        this.tblDisipadores = tblDisipadores;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JToggleButton getBtAtras1() {
        return btAtras1;
    }

    public JTextField getTxtbuscareliminarproc() {
        return txtbuscareliminarproc;
    }

    public JButton getBtnBuscareliminarproc() {
        return btnBuscareliminarproc;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDisipadores = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btAtras1 = new javax.swing.JToggleButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBuscareliminarproc = new javax.swing.JButton();
        txtbuscareliminarproc = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDisipadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Disipadores", "Marca", "Modelo", "Socket", "RGB", "Ventiladores", "Precio", "Stock"
            }
        ));
        jScrollPane1.setViewportView(tblDisipadores);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 670, 420));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 212, 250), 3));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btAtras1.setBackground(new java.awt.Color(255, 255, 255));
        btAtras1.setFont(new java.awt.Font("Montserrat Black", 1, 48)); // NOI18N
        btAtras1.setForeground(new java.awt.Color(0, 212, 250));
        btAtras1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        jPanel4.add(btAtras1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 90, 100));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(37, 53, 124));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo.png"))); // NOI18N
        jLabel20.setText("Disipadores");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(467, 3, 430, 100));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 110));

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 159, 159));

        btnBuscareliminarproc.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        btnBuscareliminarproc.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscareliminarproc.setText("Buscar");
        jPanel1.add(btnBuscareliminarproc, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));

        txtbuscareliminarproc.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtbuscareliminarproc.setBorder(null);
        jPanel1.add(txtbuscareliminarproc, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 210, 40));

        btnEliminar.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar");
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btAtras1;
    private javax.swing.JButton btnBuscareliminarproc;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDisipadores;
    private javax.swing.JTextField txtbuscareliminarproc;
    // End of variables declaration//GEN-END:variables
}
