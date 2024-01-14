package Vista;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Registro extends javax.swing.JFrame {

    public Registro() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
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
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
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
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 210, 30));

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("NOMBRE");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 210, 30));

        jLabel3.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("APELLIDO");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 210, 30));

        jLabel4.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("FECHA NACIMIENTO");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 210, 30));

        jLabel5.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("EDAD");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 210, 30));

        jLabel6.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("SEXO");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 210, 30));

        jLabel8.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("CONTRASEÑA");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 210, 30));

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

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1.setText("Ingrese su Cédula");
        jTextField1.setBorder(null);
        jTextField1.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 210, 30));

        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(0, 0, 0));
        jTextField2.setText("Ingrese su Nombre");
        jTextField2.setBorder(null);
        jTextField2.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 210, 30));

        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jTextField3.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(0, 0, 0));
        jTextField3.setText("Ingrese su Apellido");
        jTextField3.setBorder(null);
        jTextField3.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 210, 30));

        jDateChooser1.setForeground(new java.awt.Color(0, 0, 0));
        jDateChooser1.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 210, 35));

        jLabel11.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("12");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 210, 30));

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton1.setText("MASCULINO");
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 210, -1));

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton2.setText("FEMENINO");
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 210, -1));

        jTextField4.setBackground(new java.awt.Color(255, 255, 255));
        jTextField4.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(0, 0, 0));
        jTextField4.setText("Ingrese su Teléfono");
        jTextField4.setBorder(null);
        jTextField4.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 210, 30));

        jTextField5.setBackground(new java.awt.Color(255, 255, 255));
        jTextField5.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(0, 0, 0));
        jTextField5.setText("Ingrese su Dirección");
        jTextField5.setBorder(null);
        jTextField5.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 210, 30));

        jPasswordField1.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(0, 0, 0));
        jPasswordField1.setText("Contraseña123");
        jPasswordField1.setBorder(null);
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, 210, 20));

        jLabel12.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("_____________________");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, -1, 20));

        jLabel13.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("_____________________");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, -1, 20));

        jLabel14.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("_____________________");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, 20));

        jLabel15.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("_____________________");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, -1, 20));

        jLabel16.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("_____________________");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 470, -1, 20));

        jLabel17.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("_____________________");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, -1, 20));

        jLabel18.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("_____________________");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, -1, 20));

        jLabel19.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("_____________________");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, -1, 20));

        jLabel20.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("_____________________");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, -1, 20));

        jButton1.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("REGISTARSE");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, 160, -1));

        jButton2.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("CANCELAR");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 510, 160, -1));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Contraseña30x30.png"))); // NOI18N
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, 30, 30));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cedula30x30.png"))); // NOI18N
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 30, 30));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Usuario30x30.png"))); // NOI18N
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 30, 30));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Usuario30x30.png"))); // NOI18N
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 30, 30));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Calendario30x30.png"))); // NOI18N
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 30, 30));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Edad30x30.png"))); // NOI18N
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 30, 30));

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

    @SuppressWarnings("Convert2Lambda")
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables

    public void look() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(jDateChooser1);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
