/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 *
 * @author EDU
 */
public class ModificarFuentePoder extends javax.swing.JFrame {

    /**
     * Creates new form ModificarFuentePoder
     */
    public ModificarFuentePoder() {
        initComponents();
    }

    public JButton getBtnCargardatos() {
        return BtnCargardatos;
    }

    public void setBtnCargardatos(JButton BtnCargardatos) {
        this.BtnCargardatos = BtnCargardatos;
    }

    public JTable getTblfuentePoder() {
        return tblfuentePoder;
    }

    public void setTblfuentePoder(JTable tblfuentePoder) {
        this.tblfuentePoder = tblfuentePoder;
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

    public JTextField getTxtWatts() {
        return txtWatts;
    }

    public void setTxtWatts(JTextField txtWatts) {
        this.txtWatts = txtWatts;
    }

    public JTextField getTxtCertificacion() {
        return txtCertificacion;
    }

    public void setTxtCertificacion(JTextField txtCertificacion) {
        this.txtCertificacion = txtCertificacion;
    }

    public JTextField getTxtFormato() {
        return txtFormato;
    }

    public void setTxtFormato(JTextField txtFormato) {
        this.txtFormato = txtFormato;
    }

    public JTextField getTxtIdF() {
        return txtIdF;
    }

    public void setTxtIdF(JTextField txtIdF) {
        this.txtIdF = txtIdF;
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

    public JToggleButton getBtAtras1() {
        return btAtras1;
    }

    public JButton getBtnBuscarproc() {
        return btnBuscarproc;
    }

    public JButton getBtnCargarImgmodiproc() {
        return btnCargarImgmodiproc;
    }

    public JTextField getTxtbuscarproc() {
        return txtbuscarproc;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        txtbuscarproc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnCargarImgmodiproc = new javax.swing.JButton();
        btnBuscarproc = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        btAtras1 = new javax.swing.JToggleButton();
        jLabel30 = new javax.swing.JLabel();
        txtmarca = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtmodelo = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtCertificacion = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        rbSi = new javax.swing.JRadioButton();
        rbNo = new javax.swing.JRadioButton();
        jLabel25 = new javax.swing.JLabel();
        txtFormato = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        spPrecio = new javax.swing.JSpinner();
        jLabel26 = new javax.swing.JLabel();
        spStock = new javax.swing.JSpinner();
        jLabel35 = new javax.swing.JLabel();
        txtIdF = new javax.swing.JTextField();
        txtWatts = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblfuentePoder = new javax.swing.JTable();
        BtnCargardatos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 495));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnModificar.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnModificar.setText("Modificar");
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, 170, -1));

        txtbuscarproc.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtbuscarproc.setBorder(null);
        jPanel1.add(txtbuscarproc, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 210, 40));

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 170, 170));

        btnCargarImgmodiproc.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        btnCargarImgmodiproc.setForeground(new java.awt.Color(0, 0, 0));
        btnCargarImgmodiproc.setText("Cargar Imagen");
        jPanel1.add(btnCargarImgmodiproc, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, -1));

        btnBuscarproc.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        btnBuscarproc.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscarproc.setText("Buscar");
        jPanel1.add(btnBuscarproc, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 110, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 212, 250), 3));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(37, 53, 124));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo.png"))); // NOI18N
        jLabel20.setText("Fuente de Poder");
        jLabel20.setPreferredSize(new java.awt.Dimension(100, 58));
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(722, 3, 540, 100));

        btAtras1.setBackground(new java.awt.Color(255, 255, 255));
        btAtras1.setFont(new java.awt.Font("Montserrat Black", 1, 48)); // NOI18N
        btAtras1.setForeground(new java.awt.Color(0, 212, 250));
        btAtras1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        jPanel4.add(btAtras1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 80, 100));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 110));

        jLabel30.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel30.setText("Marca:");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 130, 40));

        txtmarca.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtmarca.setBorder(null);
        jPanel1.add(txtmarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 150, 40));

        jLabel31.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel31.setText("Modelo:");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 130, 40));

        txtmodelo.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtmodelo.setBorder(null);
        jPanel1.add(txtmodelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 150, 40));

        jLabel32.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel32.setText("Watts:");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, 40));

        jLabel33.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel33.setText("Certificacion:");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 130, 40));

        txtCertificacion.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtCertificacion.setBorder(null);
        jPanel1.add(txtCertificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 150, 40));

        jLabel34.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel34.setText("Modular:");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 130, 40));

        rbSi.setText("Si");
        jPanel1.add(rbSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 60, 40));

        rbNo.setText("No");
        jPanel1.add(rbNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 60, 40));

        jLabel25.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel25.setText("Formato:");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 130, 40));
        jPanel1.add(txtFormato, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 150, 40));

        jLabel28.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel28.setText("Precio:");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 130, 40));

        spPrecio.setFont(new java.awt.Font("Montserrat Thin", 0, 18)); // NOI18N
        spPrecio.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        jPanel1.add(spPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 60, 40));

        jLabel26.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel26.setText("Stock:");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 130, 40));

        spStock.setFont(new java.awt.Font("Montserrat Thin", 0, 18)); // NOI18N
        jPanel1.add(spStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 520, 60, 40));

        jLabel35.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel35.setText("ID");
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 130, 40));

        txtIdF.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtIdF.setBorder(null);
        jPanel1.add(txtIdF, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 150, 40));

        txtWatts.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtWatts.setBorder(null);
        jPanel1.add(txtWatts, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 150, 40));

        tblfuentePoder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Fuente de Poder", "Marca", "Modelo", "Certificacion", "Modular", "Formato", "Watts", "Precio", "Stock"
            }
        ));
        jScrollPane1.setViewportView(tblfuentePoder);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 167, 720, 390));

        BtnCargardatos.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        BtnCargardatos.setForeground(new java.awt.Color(0, 0, 0));
        BtnCargardatos.setText("Cargar Datos");
        jPanel1.add(BtnCargardatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 170, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1270, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbNo;
    private javax.swing.JRadioButton rbSi;
    private javax.swing.JSpinner spPrecio;
    private javax.swing.JSpinner spStock;
    private javax.swing.JTable tblfuentePoder;
    private javax.swing.JTextField txtCertificacion;
    private javax.swing.JTextField txtFormato;
    private javax.swing.JTextField txtIdF;
    private javax.swing.JTextField txtWatts;
    private javax.swing.JTextField txtbuscarproc;
    private javax.swing.JTextField txtmarca;
    private javax.swing.JTextField txtmodelo;
    // End of variables declaration//GEN-END:variables
}
