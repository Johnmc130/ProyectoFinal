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

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 495));

        btnModificar.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        btnModificar.setText("Modificar");

        txtbuscarproc.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtbuscarproc.setBorder(null);

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnCargarImgmodiproc.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        btnCargarImgmodiproc.setText("Cargar Imagen");

        btnBuscarproc.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        btnBuscarproc.setText("Buscar");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 212, 250), 3));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(37, 53, 124));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Fuente de Poder");
        jLabel20.setPreferredSize(new java.awt.Dimension(100, 58));

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
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 1163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btAtras1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel30.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Marca:");
        jLabel30.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtmarca.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtmarca.setBorder(null);

        jLabel31.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Modelo:");
        jLabel31.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtmodelo.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtmodelo.setBorder(null);

        jLabel32.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel32.setText("Watts:");
        jLabel32.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel33.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("Certificacion:");
        jLabel33.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtCertificacion.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtCertificacion.setBorder(null);

        jLabel34.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("Modular:");
        jLabel34.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        rbSi.setText("Si");

        rbNo.setText("No");

        jLabel25.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Formato:");
        jLabel25.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel28.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Precio:");
        jLabel28.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        spPrecio.setFont(new java.awt.Font("Montserrat Thin", 0, 18)); // NOI18N
        spPrecio.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        jLabel26.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Stock:");
        jLabel26.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        spStock.setFont(new java.awt.Font("Montserrat Thin", 0, 18)); // NOI18N

        jLabel35.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("Id Fuente Poder");
        jLabel35.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtIdF.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtIdF.setBorder(null);

        txtWatts.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtWatts.setBorder(null);

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

        BtnCargardatos.setText("Cargar Datos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(txtIdF, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnCargarImgmodiproc)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarproc))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel32))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rbSi)
                                        .addGap(27, 27, 27)
                                        .addComponent(rbNo))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtWatts, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCertificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFormato, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(22, 22, 22)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(spPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(btnModificar)))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(spStock, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnCargardatos)
                        .addGap(37, 37, 37)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtbuscarproc, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel35))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtIdF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCargarImgmodiproc)
                    .addComponent(btnBuscarproc))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel31)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel33)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel34)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtWatts, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtCertificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbSi)
                                    .addComponent(rbNo))
                                .addGap(7, 7, 7)
                                .addComponent(txtFormato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(spPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(spStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar))
                            .addComponent(BtnCargardatos)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtbuscarproc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

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
