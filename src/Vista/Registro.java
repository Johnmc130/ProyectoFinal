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
        txt = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
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
        jTextField6 = new javax.swing.JTextField();
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
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt.setBackground(new java.awt.Color(30, 61, 88));
        txt.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(232, 238, 241));
        jLabel1.setText("CEDULA");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        txt.add(jLabel1);
        jLabel1.setBounds(90, 30, 210, 30);

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(232, 238, 241));
        jLabel2.setText("NOMBRE");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        txt.add(jLabel2);
        jLabel2.setBounds(90, 120, 210, 30);

        jLabel3.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(232, 238, 241));
        jLabel3.setText("APELLIDO");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        txt.add(jLabel3);
        jLabel3.setBounds(90, 220, 210, 30);

        jLabel4.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(232, 238, 241));
        jLabel4.setText("FECHA NACIMIENTO");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        txt.add(jLabel4);
        jLabel4.setBounds(90, 320, 210, 30);

        jLabel5.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(232, 238, 241));
        jLabel5.setText("EDAD");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        txt.add(jLabel5);
        jLabel5.setBounds(90, 410, 210, 30);

        jLabel6.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(232, 238, 241));
        jLabel6.setText("SEXO");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        txt.add(jLabel6);
        jLabel6.setBounds(440, 30, 210, 30);

        jLabel7.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(232, 238, 241));
        jLabel7.setText("USUARIO");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        txt.add(jLabel7);
        jLabel7.setBounds(440, 320, 210, 30);

        jLabel8.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(232, 238, 241));
        jLabel8.setText("CONTRASEÑA");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        txt.add(jLabel8);
        jLabel8.setBounds(440, 410, 210, 30);

        jLabel9.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(232, 238, 241));
        jLabel9.setText("TELEFONO");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        txt.add(jLabel9);
        jLabel9.setBounds(440, 120, 210, 30);

        jLabel10.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(232, 238, 241));
        jLabel10.setText("DIRECCION");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        txt.add(jLabel10);
        jLabel10.setBounds(440, 220, 210, 30);

        jTextField1.setBackground(new java.awt.Color(30, 61, 88));
        jTextField1.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("Ingrese su Cédula");
        jTextField1.setBorder(null);
        jTextField1.setCaretColor(new java.awt.Color(255, 255, 255));
        txt.add(jTextField1);
        jTextField1.setBounds(90, 70, 210, 30);

        jTextField2.setBackground(new java.awt.Color(30, 61, 88));
        jTextField2.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setText("Ingrese su Nombre");
        jTextField2.setBorder(null);
        jTextField2.setCaretColor(new java.awt.Color(255, 255, 255));
        txt.add(jTextField2);
        jTextField2.setBounds(90, 160, 210, 30);

        jTextField3.setBackground(new java.awt.Color(30, 61, 88));
        jTextField3.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setText("Ingrese su Apellido");
        jTextField3.setBorder(null);
        jTextField3.setCaretColor(new java.awt.Color(255, 255, 255));
        txt.add(jTextField3);
        jTextField3.setBounds(90, 260, 210, 30);

        jDateChooser1.setForeground(new java.awt.Color(255, 255, 255));
        jDateChooser1.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        txt.add(jDateChooser1);
        jDateChooser1.setBounds(90, 360, 210, 35);

        jLabel11.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(232, 238, 241));
        jLabel11.setText("12");
        txt.add(jLabel11);
        jLabel11.setBounds(90, 450, 210, 30);

        jRadioButton1.setBackground(new java.awt.Color(30, 61, 88));
        jRadioButton1.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("MASCULINO");
        txt.add(jRadioButton1);
        jRadioButton1.setBounds(440, 70, 210, 33);

        jRadioButton2.setBackground(new java.awt.Color(30, 61, 88));
        jRadioButton2.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("FEMENINO");
        txt.add(jRadioButton2);
        jRadioButton2.setBounds(670, 70, 210, 33);

        jTextField4.setBackground(new java.awt.Color(30, 61, 88));
        jTextField4.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setText("Ingrese su Teléfono");
        jTextField4.setBorder(null);
        jTextField4.setCaretColor(new java.awt.Color(255, 255, 255));
        txt.add(jTextField4);
        jTextField4.setBounds(440, 160, 210, 30);

        jTextField5.setBackground(new java.awt.Color(30, 61, 88));
        jTextField5.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setText("Ingrese su Dirección");
        jTextField5.setBorder(null);
        jTextField5.setCaretColor(new java.awt.Color(255, 255, 255));
        txt.add(jTextField5);
        jTextField5.setBounds(440, 260, 210, 30);

        jTextField6.setBackground(new java.awt.Color(30, 61, 88));
        jTextField6.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setText("Ingrese su Usuario");
        jTextField6.setBorder(null);
        jTextField6.setCaretColor(new java.awt.Color(255, 255, 255));
        txt.add(jTextField6);
        jTextField6.setBounds(440, 360, 210, 30);

        jPasswordField1.setBackground(new java.awt.Color(30, 61, 88));
        jPasswordField1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setText("Contraseña123");
        jPasswordField1.setBorder(null);
        txt.add(jPasswordField1);
        jPasswordField1.setBounds(440, 450, 210, 20);

        jLabel12.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("_____________________");
        txt.add(jLabel12);
        jLabel12.setBounds(90, 460, 210, 20);

        jLabel13.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(232, 238, 241));
        jLabel13.setText("_____________________");
        txt.add(jLabel13);
        jLabel13.setBounds(90, 90, 210, 20);

        jLabel14.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(232, 238, 241));
        jLabel14.setText("_____________________");
        txt.add(jLabel14);
        jLabel14.setBounds(90, 180, 210, 20);

        jLabel15.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(232, 238, 241));
        jLabel15.setText("_____________________");
        txt.add(jLabel15);
        jLabel15.setBounds(90, 280, 210, 20);

        jLabel16.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(232, 238, 241));
        jLabel16.setText("_____________________");
        txt.add(jLabel16);
        jLabel16.setBounds(440, 460, 210, 20);

        jLabel17.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("_____________________");
        txt.add(jLabel17);
        jLabel17.setBounds(90, 460, 210, 20);

        jLabel18.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(232, 238, 241));
        jLabel18.setText("_____________________");
        txt.add(jLabel18);
        jLabel18.setBounds(90, 380, 210, 20);

        jLabel19.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(232, 238, 241));
        jLabel19.setText("_____________________");
        txt.add(jLabel19);
        jLabel19.setBounds(440, 180, 210, 20);

        jLabel20.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(232, 238, 241));
        jLabel20.setText("_____________________");
        txt.add(jLabel20);
        jLabel20.setBounds(440, 280, 210, 20);

        jLabel21.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(232, 238, 241));
        jLabel21.setText("_____________________");
        txt.add(jLabel21);
        jLabel21.setBounds(440, 380, 210, 20);

        jLabel22.setBackground(new java.awt.Color(30, 61, 88));
        jLabel22.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(30, 61, 88));
        jLabel22.setText("GUARDAR");
        txt.add(jLabel22);
        jLabel22.setBounds(120, 570, 210, 30);

        jLabel23.setBackground(new java.awt.Color(30, 61, 88));
        jLabel23.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(30, 61, 88));
        jLabel23.setText("CANCELAR");
        txt.add(jLabel23);
        jLabel23.setBounds(0, 570, 210, 30);

        jButton1.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("REGISTARSE");
        txt.add(jButton1);
        jButton1.setBounds(710, 440, 160, 39);

        jButton2.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("CANCELAR");
        txt.add(jButton2);
        jButton2.setBounds(710, 490, 160, 39);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JPanel txt;
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
