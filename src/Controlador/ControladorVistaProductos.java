/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.DatosVenta;
import Clases.Placamadre;
import Clases.Procesador;
import Modelo.ModeloDatosEnvio;
import Modelo.ModeloPlacaMadre;
import Modelo.ModeloProcesador;
import Vista.ArmadoPlaca_JB;
import Vista.VentanaCesta;
import Vista.VentanaDatosEnvio;
import Vista.VentanaPrincipal;
import Vista.VistaProductos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Steven Zhicxay
 */
public class ControladorVistaProductos {

    private VistaProductos vista;
    private Procesador procesador;
    private VentanaCesta cesta;

    public ControladorVistaProductos(VistaProductos vista) {

        this.vista = vista;
        Inicio();
        vista.setVisible(true);
    }

    public void Inicio() {
        vista.setLocationRelativeTo(null);
        CargarComponentes();
        Ventana();

        System.out.println("aqui");
    }

    public void iniciarControl() {
        Inicio();
        CargarComponentes();
        vista.getBtnBuscar().addActionListener(l -> CargarComponentes());
        vista.getBtJdlDetalleAceptar().addActionListener(l -> AceptarDlgDetalle());
        vista.getBtnCesta().addActionListener(l -> botonCesta());
        System.out.println(vista.getBtnCesta().getText());
    }

    private void CargarComponentes() {
        

        if (vista.getjCbCategorias().getSelectedItem().equals("Procesadores")) {
            List<Procesador> procesadores = ModeloProcesador.cargaProcesadores();
            // Asegurarse de que la creación y manipulación de los componentes Swing se realice en el hilo de eventos de Swing
            SwingUtilities.invokeLater(() -> {

                // Configurar el panel principal con un GridBagLayout
                vista.getJpComponentes().setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.weighty = 1.0;
                gbc.insets = new Insets(10, 10, 10, 10); // Espacio uniforme entre filas y columnas
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.ipadx = 10; // Separación horizontal entre componentes

                JPanel contentPanel = new JPanel();
                contentPanel.setLayout(new GridBagLayout());
                contentPanel.setBackground(Color.white);

                GridBagConstraints contentGbc = new GridBagConstraints();
                contentGbc.gridx = 0;
                contentGbc.gridy = 0;
                contentGbc.weightx = 1.0;
                contentGbc.weighty = 1.0;
                contentGbc.fill = GridBagConstraints.BOTH; // Relleno en ambas direcciones

                for (Procesador p : procesadores) {
                    // Verificar si la imagen no es nula
                    if (p.getImagen() != null) {
                        System.out.println(p.toString());
                        ImageIcon imageIcon = new ImageIcon(p.getImagen());
                        Image image = imageIcon.getImage();
                        Image scaledImage = image.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
                        ImageIcon scaledIcon = new ImageIcon(scaledImage);

                        JPanel panelComponentes = new JPanel();
                        panelComponentes.setLayout(new BoxLayout(panelComponentes, BoxLayout.Y_AXIS));
                        panelComponentes.setBackground(Color.WHITE); // Fondo blanco
                        panelComponentes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 212, 250), 3));

                        //margen
                        JLabel label1 = new JLabel(" ");
                        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
                        label1.setFont(new java.awt.Font("Montserrat", 0, 10));
                        panelComponentes.add(label1);

                        JLabel imageLabel = new JLabel();
                        imageLabel.setIcon(scaledIcon);
                        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                        imageLabel.setOpaque(false); // Hacer el fondo del JLabel transparente
                        panelComponentes.add(imageLabel);

                        JLabel nameLabel = new JLabel(p.getMarca() + " " + p.getModelo());
                        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                        nameLabel.setFont(new java.awt.Font("Montserrat", 0, 18));
                        panelComponentes.add(nameLabel);

                        JButton detalles = new JButton("Detalles");
                        detalles.setAlignmentX(Component.CENTER_ALIGNMENT);
                        detalles.setFont(new java.awt.Font("Montserrat", 0, 14));
                        detalles.setForeground(Color.BLUE);
                        panelComponentes.add(detalles);

                        JButton comprar = new JButton("Comprar");
                        comprar.setAlignmentX(Component.CENTER_ALIGNMENT);
                        comprar.setFont(new java.awt.Font("Montserrat", 0, 14));
                        comprar.setForeground(Color.GREEN);
                        panelComponentes.add(comprar);

                        // Agregar ActionListener al botón "Comprar"
                        comprar.addActionListener((ActionEvent e) -> {
                            // Crea e muestra la nueva ventana de compra
                            VentanaDatosEnvio vist = new VentanaDatosEnvio();
                            ModeloDatosEnvio mDtos = new ModeloDatosEnvio();
                            ControladorVenDatosEnvio log = new ControladorVenDatosEnvio(vist, mDtos);
                            log.iniciaControlador();
                            
                            DatosVenta venta = new DatosVenta();
                            venta.setId_producto(p.getIdProcesador());

                            vista.dispose();

                        });

                        //margen
                        JLabel label = new JLabel(" ");
                        label.setAlignmentX(Component.CENTER_ALIGNMENT);
                        label.setFont(new java.awt.Font("Montserrat", 0, 10));
                        panelComponentes.add(label);

                        imageLabel.addMouseListener(new MouseAdapter() {

                            @Override
                            public void mouseEntered(MouseEvent e) {
                                imageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                            }

                            @Override
                            public void mouseExited(MouseEvent e) {
                                imageLabel.setCursor(Cursor.getDefaultCursor());
                            }
                        });

                        detalles.addActionListener((ActionEvent e) -> {
                            vista.setEnabled(false);
                            vista.getJdlgDetalles().setSize(672, 444);
                            vista.getJdlgDetalles().setLocationRelativeTo(null);
                            vista.getJdlgDetalles().setUndecorated(true);
                            vista.getJdlgDetalles().setVisible(true);

                            //cargar campos
                            vista.getLblMarca().setText(p.getMarca());
                            vista.getLblModelo().setText(p.getModelo());
                            vista.getLblNucleos().setText(String.valueOf(p.getNucleosFisicos()));
                            vista.getLblGHz().setText(String.valueOf(p.getGhz()));
                            vista.getLblSocket().setText(p.getSocket());
                            vista.getLblPrecio().setText(String.valueOf(p.getPrecio()));
                            vista.getJdlgDetalles().setVisible(true);

                            

                        });

                        // Verificar si se alcanzó el límite de 3 imágenes por fila antes de incrementar la posición en la columna
                        if (contentGbc.gridx == 3) {
                            contentGbc.gridx = 0; // Reiniciar la posición en la columna
                            contentGbc.gridy++; // Incrementar el valor de y para la nueva fila

                            // Agregar espacio vertical entre filas
                            contentGbc.insets = new Insets(10, 10, 40, 10);
                        } else {
                            // Restablecer los márgenes para las demás filas
                            contentGbc.insets = new Insets(10, 10, 40, 10); // Espacio uniforme entre las filas
                        }

                        // Incrementar la posición en la columna para la próxima iteración
                        contentGbc.gridx++;

                        // Agregar el panelComponentes al panel principal utilizando las restricciones del GridBagConstraints
                        contentPanel.add(panelComponentes, contentGbc);
                    }
                }

                // Establecer el tamaño preferido del contentPanel
                contentPanel.setPreferredSize(contentPanel.getPreferredSize());

                // Crear un nuevo JScrollPane y eliminar el borde de su viewport
                JScrollPane scrollPane = new JScrollPane(contentPanel);
                scrollPane.setBorder(null);
                scrollPane.setBackground(Color.WHITE);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                // Ajustar la velocidad de desplazamiento
                scrollPane.getVerticalScrollBar().setUnitIncrement(20);

                // Agregar el panel principal al contenedor principal (pnlLabels)
                vista.getJpComponentes().setLayout(new BorderLayout());
                vista.getJpComponentes().add(scrollPane, BorderLayout.CENTER);
                // que la ventana se repinte
                vista.revalidate();
                vista.repaint();
            });
        } else if (vista.getjCbCategorias().getSelectedItem().equals("Placas madre")) {
            System.out.println("Hola mundo");
        }

    }

    public void Ventana() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(vista.getJpComponentes());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {

        }
    }

    public void botonCesta() {
        System.out.println("aaaaaaaaaaa");
        VentanaCesta v = new VentanaCesta();
        v.setVisible(true);
        // Cierra la ventana actual 
        vista.dispose();
    }

    public void botonUsuario() {

    }

    public void botonArmadoPC() {

    }

    public void AceptarDlgDetalle() {
        vista.getJdlgDetalles().setVisible(false);
        vista.getJdlgDetalles().dispose();
        vista.setEnabled(true);
        vista.setVisible(true);
    }

}
