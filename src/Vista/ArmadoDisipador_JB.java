/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author TheBigG
 */
public class ArmadoDisipador_JB extends javax.swing.JFrame {

    /**
     * Creates new form Armado_JB
     */
    public ArmadoDisipador_JB() {
        initComponents();
    }

    public JToggleButton getBtAtras() {
        return btAtras;
    }

    public JButton getBtJdlMAtras() {
        return btJdlMAtras;
    }

    public JButton getBtJdlSin() {
        return btJdlMAtras;
    }

    public JButton getBtJdlDetalleAceptar() {
        return btJdlDetalleAceptar;
    }

    public JButton getBtJdlMensajeElejir() {
        return btJdlMensajeElejir;
    }

    public JDialog getJdlgDetalles() {
        return jdlgDetalles;
    }

    public JDialog getJdlgMensaje() {
        return jdlgMensaje;
    }

    public JPanel getJpComponentes() {
        return jpComponentes;
    }

    public JLabel getLblFormato() {
        return lblFormato;
    }

    public JLabel getLblMarca() {
        return lblMarca;
    }

    public JLabel getLblModelo() {
        return lblModelo;
    }

    public JLabel getLblRanurasExpa() {
        return lblRanurasExpa;
    }

    public JLabel getLblSocket() {
        return lblSocket;
    }

    public JLabel getLblTipoRam() {
        return lblTipoRam;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdlgDetalles = new javax.swing.JDialog();
        jPanel10 = new javax.swing.JPanel();
        btJdlDetalleAceptar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        lblTipoRam = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        lblRanurasExpa = new javax.swing.JLabel();
        lblSocket = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        lblFormato = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        lblFSR1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        lblTitulo4 = new javax.swing.JLabel();
        jdlgMensaje = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btJdlMAtras = new javax.swing.JButton();
        btJdlMensajeElejir = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        lblTitulo2 = new javax.swing.JLabel();
        Encabezado = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btAtras = new javax.swing.JToggleButton();
        Cuerpo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jpComponentes = new javax.swing.JPanel();

        jdlgDetalles.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jdlgDetalles.setBackground(new java.awt.Color(255, 255, 255));
        jdlgDetalles.setResizable(false);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 212, 250), 3));

        btJdlDetalleAceptar.setBackground(new java.awt.Color(255, 255, 255));
        btJdlDetalleAceptar.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        btJdlDetalleAceptar.setForeground(new java.awt.Color(0, 0, 0));
        btJdlDetalleAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Compromisos.png"))); // NOI18N
        btJdlDetalleAceptar.setText("Aceptar");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(37, 53, 124));

        jLabel41.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(37, 53, 124));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel41.setText("Ranuras de Expancion:");
        jLabel41.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblTipoRam.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lblTipoRam.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTipoRam.setText("---------------");
        lblTipoRam.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel42.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(37, 53, 124));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel42.setText("Modelo:");
        jLabel42.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel43.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(37, 53, 124));
        jLabel43.setText("Socket:");
        jLabel43.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblRanurasExpa.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lblRanurasExpa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRanurasExpa.setText("---------------");
        lblRanurasExpa.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblSocket.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lblSocket.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSocket.setText("---------------");
        lblSocket.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblMarca.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lblMarca.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMarca.setText("---------------");
        lblMarca.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblModelo.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lblModelo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblModelo.setText("---------------");
        lblModelo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel44.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(37, 53, 124));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel44.setText("RAM Admitida:");
        jLabel44.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel45.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(37, 53, 124));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel45.setText("Marca:");
        jLabel45.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel46.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(37, 53, 124));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel46.setText("Tamaño Formato:");
        jLabel46.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblFormato.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lblFormato.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFormato.setText("---------------");
        lblFormato.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblPrecio.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lblPrecio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPrecio.setText("---------------");
        lblPrecio.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel40.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(37, 53, 124));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel40.setText("Precio:");
        jLabel40.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel47.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(37, 53, 124));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel47.setText("Stock:");
        jLabel47.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblFSR1.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lblFSR1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFSR1.setText("---------------");
        lblFSR1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(195, 195, 195))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRanurasExpa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFormato, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTipoRam, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSocket, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel47)
                .addGap(18, 18, 18)
                .addComponent(lblFSR1)
                .addGap(240, 240, 240))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblMarca)
                        .addGap(11, 11, 11)
                        .addComponent(lblModelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSocket)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTipoRam)
                        .addGap(8, 8, 8)
                        .addComponent(lblRanurasExpa))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel42)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel44)))
                        .addGap(8, 8, 8)
                        .addComponent(jLabel41)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(lblFormato))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(lblPrecio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFSR1)
                    .addComponent(jLabel47))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(507, 507, 507)
                        .addComponent(btJdlDetalleAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btJdlDetalleAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 212, 250), 3));

        lblTitulo4.setBackground(new java.awt.Color(255, 255, 255));
        lblTitulo4.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        lblTitulo4.setForeground(new java.awt.Color(37, 53, 124));
        lblTitulo4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo.png"))); // NOI18N
        lblTitulo4.setText("Detalles Placa Madre");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jdlgDetallesLayout = new javax.swing.GroupLayout(jdlgDetalles.getContentPane());
        jdlgDetalles.getContentPane().setLayout(jdlgDetallesLayout);
        jdlgDetallesLayout.setHorizontalGroup(
            jdlgDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdlgDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdlgDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jdlgDetallesLayout.setVerticalGroup(
            jdlgDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdlgDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jdlgMensaje.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jdlgMensaje.setBackground(new java.awt.Color(255, 255, 255));
        jdlgMensaje.setResizable(false);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 212, 250), 3));

        jLabel2.setFont(new java.awt.Font("Montserrat", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(37, 53, 124));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("<html><center><p><b>Todo listo</b><br>Clic en aceptar para ver tu resumen de componentes.</p></center></html>");

        btJdlMAtras.setBackground(new java.awt.Color(255, 255, 255));
        btJdlMAtras.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        btJdlMAtras.setForeground(new java.awt.Color(0, 0, 0));
        btJdlMAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/JB/eliminar.png"))); // NOI18N
        btJdlMAtras.setText("Atras");

        btJdlMensajeElejir.setBackground(new java.awt.Color(255, 255, 255));
        btJdlMensajeElejir.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        btJdlMensajeElejir.setForeground(new java.awt.Color(0, 0, 0));
        btJdlMensajeElejir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/JB/agregar.png"))); // NOI18N
        btJdlMensajeElejir.setText("Elejir");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btJdlMAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btJdlMensajeElejir, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btJdlMAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btJdlMensajeElejir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 212, 250), 3));

        lblTitulo2.setBackground(new java.awt.Color(255, 255, 255));
        lblTitulo2.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(37, 53, 124));
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo.png"))); // NOI18N
        lblTitulo2.setText("Listo!!!");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jdlgMensajeLayout = new javax.swing.GroupLayout(jdlgMensaje.getContentPane());
        jdlgMensaje.getContentPane().setLayout(jdlgMensajeLayout);
        jdlgMensajeLayout.setHorizontalGroup(
            jdlgMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdlgMensajeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdlgMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jdlgMensajeLayout.setVerticalGroup(
            jdlgMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdlgMensajeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Encabezado.setBackground(new java.awt.Color(255, 255, 255));
        Encabezado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 212, 250), 3));
        Encabezado.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(37, 53, 124));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo.png"))); // NOI18N
        jLabel3.setText("Cotizacion");

        btAtras.setBackground(new java.awt.Color(255, 255, 255));
        btAtras.setFont(new java.awt.Font("Montserrat Black", 1, 48)); // NOI18N
        btAtras.setForeground(new java.awt.Color(0, 212, 250));
        btAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N

        javax.swing.GroupLayout EncabezadoLayout = new javax.swing.GroupLayout(Encabezado);
        Encabezado.setLayout(EncabezadoLayout);
        EncabezadoLayout.setHorizontalGroup(
            EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncabezadoLayout.createSequentialGroup()
                .addComponent(btAtras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        EncabezadoLayout.setVerticalGroup(
            EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btAtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Cuerpo.setBackground(new java.awt.Color(255, 255, 255));
        Cuerpo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 212, 250), 3));
        Cuerpo.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Montserrat", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(37, 53, 124));
        jLabel4.setText("Elija la base pasa sus componentes");

        jpComponentes.setBackground(new java.awt.Color(255, 255, 255));
        jpComponentes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 212, 250), 3));
        jpComponentes.setAlignmentX(0.0F);
        jpComponentes.setAlignmentY(0.0F);
        jpComponentes.setMaximumSize(new java.awt.Dimension(941, 405));
        jpComponentes.setMinimumSize(new java.awt.Dimension(941, 405));
        jpComponentes.setPreferredSize(new java.awt.Dimension(941, 405));

        javax.swing.GroupLayout jpComponentesLayout = new javax.swing.GroupLayout(jpComponentes);
        jpComponentes.setLayout(jpComponentesLayout);
        jpComponentesLayout.setHorizontalGroup(
            jpComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpComponentesLayout.setVerticalGroup(
            jpComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout CuerpoLayout = new javax.swing.GroupLayout(Cuerpo);
        Cuerpo.setLayout(CuerpoLayout);
        CuerpoLayout.setHorizontalGroup(
            CuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CuerpoLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 564, Short.MAX_VALUE))
            .addGroup(CuerpoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpComponentes, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
                .addContainerGap())
        );
        CuerpoLayout.setVerticalGroup(
            CuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CuerpoLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpComponentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Cuerpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cuerpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Cuerpo;
    private javax.swing.JPanel Encabezado;
    private javax.swing.JToggleButton btAtras;
    private javax.swing.JButton btJdlDetalleAceptar;
    private javax.swing.JButton btJdlMAtras;
    private javax.swing.JButton btJdlMensajeElejir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JDialog jdlgDetalles;
    private javax.swing.JDialog jdlgMensaje;
    private javax.swing.JPanel jpComponentes;
    private javax.swing.JLabel lblFSR1;
    private javax.swing.JLabel lblFormato;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblRanurasExpa;
    private javax.swing.JLabel lblSocket;
    private javax.swing.JLabel lblTipoRam;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTitulo4;
    // End of variables declaration//GEN-END:variables
}
