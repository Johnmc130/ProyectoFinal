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
public class ArmadoAlmacenamiento_JB extends javax.swing.JFrame {

    /**
     * Creates new form Armado_JB
     */
    public ArmadoAlmacenamiento_JB() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdlgDetalles = new javax.swing.JDialog();
        jPanel8 = new javax.swing.JPanel();
        btJdlDetalleAceptar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        lblCapacidad = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblTitulo3 = new javax.swing.JLabel();
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

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 212, 250), 3));

        btJdlDetalleAceptar.setBackground(new java.awt.Color(255, 255, 255));
        btJdlDetalleAceptar.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        btJdlDetalleAceptar.setForeground(new java.awt.Color(0, 0, 0));
        btJdlDetalleAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Compromisos.png"))); // NOI18N
        btJdlDetalleAceptar.setText("Aceptar");
        btJdlDetalleAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btJdlDetalleAceptarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(37, 53, 124));

        jLabel35.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(37, 53, 124));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("Stock:");
        jLabel35.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblCapacidad.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lblCapacidad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCapacidad.setText("---------------");
        lblCapacidad.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel36.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(37, 53, 124));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Modelo:");
        jLabel36.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel37.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(37, 53, 124));
        jLabel37.setText("Tipo:");
        jLabel37.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblStock.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lblStock.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblStock.setText("---------------");
        lblStock.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblTipo.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lblTipo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTipo.setText("---------------");
        lblTipo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblMarca.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lblMarca.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMarca.setText("---------------");
        lblMarca.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblModelo.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lblModelo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblModelo.setText("---------------");
        lblModelo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel38.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(37, 53, 124));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel38.setText("Capacidad:");
        jLabel38.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel39.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(37, 53, 124));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel39.setText("Marca:");
        jLabel39.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel40.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(37, 53, 124));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel40.setText("Precio:");
        jLabel40.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblPrecio.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lblPrecio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPrecio.setText("---------------");
        lblPrecio.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStock, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblMarca)
                        .addGap(11, 11, 11)
                        .addComponent(lblModelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCapacidad))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel36)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel38)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblStock)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(lblPrecio))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btJdlDetalleAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btJdlDetalleAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 212, 250), 3));

        lblTitulo3.setBackground(new java.awt.Color(255, 255, 255));
        lblTitulo3.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        lblTitulo3.setForeground(new java.awt.Color(37, 53, 124));
        lblTitulo3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo.png"))); // NOI18N
        lblTitulo3.setText("Detalles Almacenamiento");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jdlgDetallesLayout = new javax.swing.GroupLayout(jdlgDetalles.getContentPane());
        jdlgDetalles.getContentPane().setLayout(jdlgDetallesLayout);
        jdlgDetallesLayout.setHorizontalGroup(
            jdlgDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdlgDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdlgDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jdlgDetallesLayout.setVerticalGroup(
            jdlgDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdlgDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jdlgMensaje.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jdlgMensaje.setBackground(new java.awt.Color(255, 255, 255));
        jdlgMensaje.setResizable(false);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 212, 250), 3));

        jLabel2.setFont(new java.awt.Font("Montserrat", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(37, 53, 124));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("<html><p><b>De todo color y sabor</b><br> ¡¡¡Mas RGB mas poder!!! </p></html>");

        btJdlMAtras.setBackground(new java.awt.Color(255, 255, 255));
        btJdlMAtras.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        btJdlMAtras.setForeground(new java.awt.Color(0, 0, 0));
        btJdlMAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/JB/eliminar.png"))); // NOI18N
        btJdlMAtras.setText("Atras");

        btJdlMensajeElejir.setBackground(new java.awt.Color(255, 255, 255));
        btJdlMensajeElejir.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        btJdlMensajeElejir.setForeground(new java.awt.Color(0, 0, 0));
        btJdlMensajeElejir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/JB/agregar.png"))); // NOI18N
        btJdlMensajeElejir.setText("Elegir");

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
        lblTitulo2.setText("GABINETE");

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
        jLabel4.setText("Elija el nucleo de su Equipo");

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
                .addGap(0, 649, Short.MAX_VALUE))
            .addGroup(CuerpoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpComponentes, javax.swing.GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
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

    private void btJdlDetalleAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btJdlDetalleAceptarActionPerformed
                                                     // TODO add your handling code here:
    }//GEN-LAST:event_btJdlDetalleAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Cuerpo;
    private javax.swing.JPanel Encabezado;
    private javax.swing.JToggleButton btAtras;
    private javax.swing.JButton btJdlDetalleAceptar;
    private javax.swing.JButton btJdlMAtras;
    private javax.swing.JButton btJdlMensajeElejir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JDialog jdlgDetalles;
    private javax.swing.JDialog jdlgMensaje;
    private javax.swing.JPanel jpComponentes;
    private javax.swing.JLabel lblCapacidad;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTitulo3;
    // End of variables declaration//GEN-END:variables

    public JButton getBtJdlDetalleAceptar() {
        return btJdlDetalleAceptar;
    }

    public JButton getBtJdlMAtras() {
        return btJdlMAtras;
    }

    public JButton getBtJdlMensajeElejir() {
        return btJdlMensajeElejir;
    }

    public JDialog getJdlgDetalles() {
        return jdlgDetalles;
    }

    public JLabel getLblCapacidad() {
        return lblCapacidad;
    }

    public JLabel getLblMarca() {
        return lblMarca;
    }

    public JLabel getLblPrecio() {
        return lblPrecio;
    }

    public JLabel getLblStock() {
        return lblStock;
    }

    public JLabel getLblTipo() {
        return lblTipo;
    }

    public JPanel getJpComponentes() {
        return jpComponentes;
    }

    public JLabel getLblModelo() {
        return lblModelo;
    }

    public JToggleButton getBtAtras() {
        return btAtras;
    }

    public JDialog getJdlgMensaje() {
        return jdlgMensaje;
    }

}
