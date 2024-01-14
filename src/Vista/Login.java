package Vista;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtContra = new javax.swing.JPasswordField();
        btnInicia = new javax.swing.JButton();
        btnRegistra = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login de Usuario");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 340, 500));

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(37, 53, 124));
        jLabel2.setText("GLOBALCORE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 360, 60));

        jLabel3.setFont(new java.awt.Font("Montserrat", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(37, 53, 124));
        jLabel3.setText("USUARIO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 170, 50));

        jLabel4.setFont(new java.awt.Font("Montserrat", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(37, 53, 124));
        jLabel4.setText("CONTRASEÑA");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 170, 50));

        jLabel5.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Usuario.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Contraseña.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jLabel7.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("_________________");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, 20));

        jLabel8.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("___________________________________");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, 20));

        txtCedula.setBackground(new java.awt.Color(255, 255, 255));
        txtCedula.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtCedula.setForeground(new java.awt.Color(0, 0, 0));
        txtCedula.setText("Ingrese su Cedúla");
        txtCedula.setBorder(null);
        jPanel1.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 177, 170, 40));

        txtContra.setBackground(new java.awt.Color(255, 255, 255));
        txtContra.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtContra.setForeground(new java.awt.Color(0, 0, 0));
        txtContra.setText("Contraseña");
        txtContra.setBorder(null);
        jPanel1.add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 170, -1));

        btnInicia.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        btnInicia.setForeground(new java.awt.Color(0, 0, 0));
        btnInicia.setText("INICIAR SESIÓN");
        jPanel1.add(btnInicia, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 170, 50));

        btnRegistra.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        btnRegistra.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistra.setText("REGISTRARSE");
        jPanel1.add(btnRegistra, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 170, 50));

        jLabel9.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("INICIA SESIÓN PARA CONTINUAR");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 360, -1));

        jLabel10.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO60X60.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 60));

        jLabel11.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("_________________");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, 20));

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

        setSize(new java.awt.Dimension(916, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicia;
    private javax.swing.JButton btnRegistra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JPasswordField txtContra;
    // End of variables declaration//GEN-END:variables
}
