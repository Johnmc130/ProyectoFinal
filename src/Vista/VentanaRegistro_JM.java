package Vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;

public class VentanaRegistro_JM extends javax.swing.JFrame {

    public VentanaRegistro_JM() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgSexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombte = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        dtcFecha = new com.toedter.calendar.JDateChooser();
        rbtnMasc = new javax.swing.JRadioButton();
        rbtnFem = new javax.swing.JRadioButton();
        txtTelef = new javax.swing.JTextField();
        txtDirec = new javax.swing.JTextField();
        txtCon = new javax.swing.JPasswordField();
        btnRegistra = new javax.swing.JButton();
        btnCancela = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de Usuario");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("CÉDULA");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 210, 30));

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("NOMBRE");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 210, 30));

        jLabel3.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("APELLIDO");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 210, 30));

        jLabel4.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("FECHA NACIMIENTO");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 210, 30));

        jLabel5.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("CORREO");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 210, 30));

        jLabel6.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("SEXO");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 210, 30));

        jLabel8.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("CONTRASEÑA");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, 210, 30));

        jLabel9.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("TELEFONO");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 210, 30));

        jLabel10.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("DIRECCION");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 210, 30));

        txtCedula.setBackground(new java.awt.Color(255, 255, 255));
        txtCedula.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        txtCedula.setForeground(new java.awt.Color(0, 0, 0));
        txtCedula.setText("Ingrese su Cédula");
        txtCedula.setBorder(null);
        txtCedula.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 210, 30));

        txtNombte.setBackground(new java.awt.Color(255, 255, 255));
        txtNombte.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        txtNombte.setForeground(new java.awt.Color(0, 0, 0));
        txtNombte.setText("Ingrese su Nombre");
        txtNombte.setBorder(null);
        txtNombte.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtNombte, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 210, 30));

        txtApellido.setBackground(new java.awt.Color(255, 255, 255));
        txtApellido.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(0, 0, 0));
        txtApellido.setText("Ingrese su Apellido");
        txtApellido.setBorder(null);
        txtApellido.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 210, 30));

        txtCorreo.setBackground(new java.awt.Color(255, 255, 255));
        txtCorreo.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(0, 0, 0));
        txtCorreo.setText("Ingrese su Correo");
        txtCorreo.setBorder(null);
        txtCorreo.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 210, 30));

        dtcFecha.setForeground(new java.awt.Color(0, 0, 0));
        dtcFecha.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jPanel1.add(dtcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 210, 35));

        rbtnMasc.setBackground(new java.awt.Color(255, 255, 255));
        btgSexo.add(rbtnMasc);
        rbtnMasc.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        rbtnMasc.setForeground(new java.awt.Color(0, 0, 0));
        rbtnMasc.setText("MASCULINO");
        jPanel1.add(rbtnMasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 210, -1));

        rbtnFem.setBackground(new java.awt.Color(255, 255, 255));
        btgSexo.add(rbtnFem);
        rbtnFem.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        rbtnFem.setForeground(new java.awt.Color(0, 0, 0));
        rbtnFem.setText("FEMENINO");
        jPanel1.add(rbtnFem, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 210, -1));

        txtTelef.setBackground(new java.awt.Color(255, 255, 255));
        txtTelef.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        txtTelef.setForeground(new java.awt.Color(0, 0, 0));
        txtTelef.setText("Ingrese su Teléfono");
        txtTelef.setBorder(null);
        txtTelef.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtTelef, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 210, 30));

        txtDirec.setBackground(new java.awt.Color(255, 255, 255));
        txtDirec.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        txtDirec.setForeground(new java.awt.Color(0, 0, 0));
        txtDirec.setText("Ingrese su Dirección");
        txtDirec.setBorder(null);
        txtDirec.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtDirec, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 210, 30));

        txtCon.setBackground(new java.awt.Color(255, 255, 255));
        txtCon.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txtCon.setForeground(new java.awt.Color(0, 0, 0));
        txtCon.setText("Contraseña123");
        txtCon.setBorder(null);
        jPanel1.add(txtCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, 210, 30));

        btnRegistra.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        btnRegistra.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistra.setText("REGISTARSE");
        jPanel1.add(btnRegistra, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, 160, -1));

        btnCancela.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        btnCancela.setForeground(new java.awt.Color(0, 0, 0));
        btnCancela.setText("CANCELAR");
        jPanel1.add(btnCancela, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 510, 160, -1));

        jLabel12.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("_____________________");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, -1, 20));

        jLabel13.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("_____________________");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, 20));

        jLabel14.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("_____________________");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, 20));

        jLabel15.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("_____________________");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, -1, 20));

        jLabel16.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("_____________________");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 470, -1, 20));

        jLabel17.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("_____________________");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, -1, 20));

        jLabel18.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("_____________________");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, -1, 20));

        jLabel19.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("_____________________");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, -1, 20));

        jLabel20.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("_____________________");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, -1, 20));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Contraseña30x30.png"))); // NOI18N
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, 30, 30));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cedula30x30.png"))); // NOI18N
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 30, 30));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Usuario30x30.png"))); // NOI18N
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 30, 30));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Usuario30x30.png"))); // NOI18N
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 30, 30));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Calendario30x30.png"))); // NOI18N
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 30, 30));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Correo30x30.png"))); // NOI18N
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 30, 30));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Sexo30x30.png"))); // NOI18N
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 30, 30));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Telefono30x30.png"))); // NOI18N
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 30, 30));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Direccion30x30.png"))); // NOI18N
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 30, 30));

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

        setSize(new java.awt.Dimension(916, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgSexo;
    private javax.swing.JButton btnCancela;
    private javax.swing.JButton btnRegistra;
    private com.toedter.calendar.JDateChooser dtcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbtnFem;
    private javax.swing.JRadioButton rbtnMasc;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JPasswordField txtCon;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDirec;
    private javax.swing.JTextField txtNombte;
    private javax.swing.JTextField txtTelef;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnCancela() {
        return btnCancela;
    }

    public JButton getBtnRegistra() {
        return btnRegistra;
    }

    public ButtonGroup getButtonGroup1() {
        return btgSexo;
    }

    public JDateChooser getDtcFecha() {
        return dtcFecha;
    }

    public JRadioButton getRbtnFem() {
        return rbtnFem;
    }

    public JRadioButton getRbtnMas() {
        return rbtnMasc;
    }

    public JTextField getTxtApellido() {
        return txtApellido;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public JPasswordField getTxtCon() {
        return txtCon;
    }

    public JTextField getTxtCorreo() {
        return txtCorreo;
    }

    public JTextField getTxtDirec() {
        return txtDirec;
    }

    public JTextField getTxtNombte() {
        return txtNombte;
    }

    public JTextField getTxtTelef() {
        return txtTelef;
    }

}
