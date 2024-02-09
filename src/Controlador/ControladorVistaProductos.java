/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.DatosVenta;
import Clases.FuentePoder;
import Clases.Gabinete;
import Clases.Placamadre;
import Clases.Procesador;
import Clases.Tarjetagrafica;
import Clases.Ventiladores;
import Clases.almacenamiento;
import Clases.memoriaRam;

import Modelo.ModeloTarjetaGrafica;
import Clases.Disipadores;
import Modelo.ModeloAlmacenamiento;
import Modelo.ModeloDatosEnvio;
import Modelo.ModeloDisipadores;
import Modelo.ModeloFuentePoder;
import Modelo.ModeloGabinete;
import Modelo.ModeloMemoriaRam;
import Modelo.ModeloPlacaMadre;
import Modelo.ModeloProcesador;
import Modelo.ModeloVentiladores;

import Vista.ArmadoProc_JB;

import Vista.VentanaCesta;
import Vista.VentanaDatosEnvio;

import Vista.VistaProductos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;


import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Steven Zhicxay
 */
public class ControladorVistaProductos {

//    public static int ida;
    
    DatosVenta venta = new DatosVenta();
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

        Ventana();

        System.out.println("aqui");
    }

    public void iniciarControl() {
        Inicio();
        CargarComponentes();
        vista.getBtnBuscar().addActionListener(l -> CargarComponentes());
        vista.getBtJdlDetalleAceptar().addActionListener(l -> AceptarDlgDetalle());
        vista.getBtJdlDetalleAceptarPlaca().addActionListener(l -> AceptarDlgDetallePlaca());
        vista.getBtJdlDetalleAceptarTarjetaG().addActionListener(l -> AceptarDlgDetalleTarjeta());
        vista.getBtJdlDetalleAceptarMemoriaR().addActionListener(l -> AceptarDlgDetalleMemoriaR());
        vista.getBtJdlDetalleAceptarFuenteP().addActionListener(l -> AceptarDlgDetalleFuenteP());
        vista.getBtJdlDetalleAceptarAlmacena().addActionListener(l -> AceptarDlgDetalleAlmacenamiento());
        vista.getBtJdlDetalleAceptarVentila().addActionListener(l -> AceptarDlgDetalleVentiladores());
        vista.getBtJdlDetalleAceptarDisparadores().addActionListener(l -> AceptarDlgDetalleDsiparadores());
        vista.getBtJdlDetalleAceptarGabinete().addActionListener(l -> AceptarDlgDetalleGabinetes());
        vista.getBtnUsuario().addActionListener(l -> botonUsuario());
        vista.getBtnArmarPC().addActionListener(l -> botonArmadoPC());

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

                        JButton comprar = new JButton("Comprar");
                        comprar.setAlignmentX(Component.CENTER_ALIGNMENT);
                        comprar.setFont(new java.awt.Font("Montserrat", 0, 14));
                        comprar.setForeground(Color.GREEN);
                        panelComponentes.add(comprar);

                        // Agregar ActionListener al botón "Comprar"
                        comprar.addActionListener((ActionEvent e) -> {
                            // Crea e muestra la nueva ventana de compra
                            String componente = null;
                            Object objeto = p;
                            if (objeto instanceof Procesador) {
                                componente = "procesador";
                            } else if (objeto instanceof Placamadre) {
                                componente = "Placamadre";
                            } else if (objeto instanceof Tarjetagrafica) {
                                componente = "Tarjetagrafica";
                            } else if (objeto instanceof memoriaRam) {
                                componente = "memoriaRam";
                            } else if (objeto instanceof FuentePoder) {
                                componente = "FuentePoder";
                            } else if (objeto instanceof almacenamiento) {
                                componente = "almacenamiento";
                            } else if (objeto instanceof Ventiladores) {
                                componente = "Ventiladores";
                            } else if (objeto instanceof Disipadores) {
                                componente = "Disipadores";
                            } else if (objeto instanceof Gabinete) {
                                componente = "Gabinete";
                            }

                            VentanaDatosEnvio vist = new VentanaDatosEnvio();
                            ModeloDatosEnvio mDtos = new ModeloDatosEnvio();
                            ControladorVenDatosEnvio log = new ControladorVenDatosEnvio(vist, mDtos, p.getIdProcesador(), componente, p.getPrecio());
                            log.iniciaControlador();

                            vista.dispose();

                        });

                        //margen
                        JLabel label = new JLabel(" ");
                        label.setAlignmentX(Component.CENTER_ALIGNMENT);
                        label.setFont(new java.awt.Font("Montserrat", 0, 10));
                        panelComponentes.add(label);

                        imageLabel.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
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
                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {
                                imageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                            }

                            @Override
                            public void mouseExited(MouseEvent e) {
                                imageLabel.setCursor(Cursor.getDefaultCursor());
                            }
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
            List<Placamadre> placasM = ModeloPlacaMadre.listaPlacaMadre();
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

                for (Placamadre p : placasM) {
                    // Verificar si la imagen no es nula
                    if (p.getFoto() != null) {
                        System.out.println(p.toString());
                        ImageIcon imageIcon = new ImageIcon(p.getFoto());
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

                        JButton comprar = new JButton("Comprar");
                        comprar.setAlignmentX(Component.CENTER_ALIGNMENT);
                        comprar.setFont(new java.awt.Font("Montserrat", 0, 14));
                        comprar.setForeground(Color.GREEN);
                        panelComponentes.add(comprar);

                        // Agregar ActionListener al botón "Comprar"
                        comprar.addActionListener((ActionEvent e) -> {
                            // Crea e muestra la nueva ventana de compra
                            String componente = null;
                            Object objeto = p;
                            if (objeto instanceof Procesador) {
                                componente = "procesador";
                            } else if (objeto instanceof Placamadre) {
                                componente = "Placamadre";
                            } else if (objeto instanceof Tarjetagrafica) {
                                componente = "Tarjetagrafica";
                            } else if (objeto instanceof memoriaRam) {
                                componente = "memoriaRam";
                            } else if (objeto instanceof FuentePoder) {
                                componente = "FuentePoder";
                            } else if (objeto instanceof almacenamiento) {
                                componente = "almacenamiento";
                            } else if (objeto instanceof Ventiladores) {
                                componente = "Ventiladores";
                            } else if (objeto instanceof Disipadores) {
                                componente = "Disipadores";
                            } else if (objeto instanceof Gabinete) {
                                componente = "Gabinete";
                            }

                            VentanaDatosEnvio vist = new VentanaDatosEnvio();
                            ModeloDatosEnvio mDtos = new ModeloDatosEnvio();
                            ControladorVenDatosEnvio log = new ControladorVenDatosEnvio(vist, mDtos, p.getIdplacam(), componente, p.getPrecio());
                            log.iniciaControlador();

                            vista.dispose();

                        });

                        //margen
                        JLabel label = new JLabel(" ");
                        label.setAlignmentX(Component.CENTER_ALIGNMENT);
                        label.setFont(new java.awt.Font("Montserrat", 0, 10));
                        panelComponentes.add(label);

                        imageLabel.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                vista.setEnabled(false);
                                vista.getJdlgDetallesPlaca().setSize(798, 533);
                                vista.getJdlgDetallesPlaca().setLocationRelativeTo(null);
                                vista.getJdlgDetallesPlaca().setUndecorated(true);
                                vista.getJdlgDetallesPlaca().setVisible(true);

                                //cargar campos
                                vista.getLblMarcaPlaca().setText(p.getMarca());
                                vista.getLblModeloPlaca().setText(p.getModelo());
                                vista.getLblSocketPlaca().setText(String.valueOf(p.getSocket()));
                                vista.getLblTipoRamPlaca().setText(String.valueOf(p.getMaximoram()));
                                vista.getLblRanurasExpaPlaca().setText(p.getRanuraexpansion());
                                vista.getLblFormatoPlaca().setText(p.getFormato());
                                vista.getLblPrecioPlaca().setText(String.valueOf(p.getPrecio()));
                                vista.getLblStockPlaca().setText(String.valueOf(p.getStock()));
                                vista.getJdlgDetallesPlaca().setVisible(true);

                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {
                                imageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                            }

                            @Override
                            public void mouseExited(MouseEvent e) {
                                imageLabel.setCursor(Cursor.getDefaultCursor());
                            }
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
        } else if (vista.getjCbCategorias().getSelectedItem().equals("Tarjetas graficas")) {
            List<Tarjetagrafica> TarjetaG = ModeloTarjetaGrafica.listaTarjetaGrafica();
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

                for (Tarjetagrafica p : TarjetaG) {
                    // Verificar si la imagen no es nula
                    if (p.getFoto() != null) {
                        System.out.println(p.toString());
                        ImageIcon imageIcon = new ImageIcon(p.getFoto());
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

                        JButton comprar = new JButton("Comprar");
                        comprar.setAlignmentX(Component.CENTER_ALIGNMENT);
                        comprar.setFont(new java.awt.Font("Montserrat", 0, 14));
                        comprar.setForeground(Color.GREEN);
                        panelComponentes.add(comprar);

                        // Agregar ActionListener al botón "Comprar"
                        comprar.addActionListener((ActionEvent e) -> {
                            // Crea e muestra la nueva ventana de compra
                            String componente = null;
                            Object objeto = p;
                            if (objeto instanceof Procesador) {
                                componente = "procesador";
                            } else if (objeto instanceof Placamadre) {
                                componente = "Placamadre";
                            } else if (objeto instanceof Tarjetagrafica) {
                                componente = "Tarjetagrafica";
                            } else if (objeto instanceof memoriaRam) {
                                componente = "memoriaRam";
                            } else if (objeto instanceof FuentePoder) {
                                componente = "FuentePoder";
                            } else if (objeto instanceof almacenamiento) {
                                componente = "almacenamiento";
                            } else if (objeto instanceof Ventiladores) {
                                componente = "Ventiladores";
                            } else if (objeto instanceof Disipadores) {
                                componente = "Disipadores";
                            } else if (objeto instanceof Gabinete) {
                                componente = "Gabinete";
                            }

                            VentanaDatosEnvio vist = new VentanaDatosEnvio();
                            ModeloDatosEnvio mDtos = new ModeloDatosEnvio();
                            ControladorVenDatosEnvio log = new ControladorVenDatosEnvio(vist, mDtos, p.getIdtarjetag(), componente, p.getPrecio());
                            log.iniciaControlador();

                            vista.dispose();

                        });

                        //margen
                        JLabel label = new JLabel(" ");
                        label.setAlignmentX(Component.CENTER_ALIGNMENT);
                        label.setFont(new java.awt.Font("Montserrat", 0, 10));
                        panelComponentes.add(label);

                        imageLabel.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                vista.setEnabled(false);
                                vista.getJdlgDetallesTarjetaG().setSize(798, 533);
                                vista.getJdlgDetallesTarjetaG().setLocationRelativeTo(null);
                                vista.getJdlgDetallesTarjetaG().setUndecorated(true);
                                vista.getJdlgDetallesTarjetaG().setVisible(true);

                                //cargar campos
                                vista.getLblMarcaTarjetaG().setText(p.getMarca());
                                vista.getLblModeloTarjetaG().setText(p.getModelo());
                                vista.getLblVRamTarjetaG().setText(String.valueOf(p.getVram()));
                                vista.getLblDLSSTarjetaG().setText(String.valueOf(p.getDlss()));
                                vista.getLblFSRTarjetaG().setText(p.getFsr());
                                vista.getLblPrecio1TarjetaG().setText(String.valueOf(p.getPrecio()));
                                vista.getLblStockTarjetaG().setText(String.valueOf(p.getStock()));
                                vista.getJdlgDetallesTarjetaG().setVisible(true);

                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {
                                imageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                            }

                            @Override
                            public void mouseExited(MouseEvent e) {
                                imageLabel.setCursor(Cursor.getDefaultCursor());
                            }
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
        } else if (vista.getjCbCategorias().getSelectedItem().equals("Memorias ram")) {
            List<memoriaRam> MemoriaR = ModeloMemoriaRam.listaTodasmemoriaRam();
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

                for (memoriaRam p : MemoriaR) {
                    // Verificar si la imagen no es nula
                    if (p.getFoto() != null) {
                        System.out.println(p.toString());
                        ImageIcon imageIcon = new ImageIcon(p.getFoto());
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

                        JButton comprar = new JButton("Comprar");
                        comprar.setAlignmentX(Component.CENTER_ALIGNMENT);
                        comprar.setFont(new java.awt.Font("Montserrat", 0, 14));
                        comprar.setForeground(Color.GREEN);
                        panelComponentes.add(comprar);

                        // Agregar ActionListener al botón "Comprar"
                        comprar.addActionListener((ActionEvent e) -> {
                            // Crea e muestra la nueva ventana de compra
                            String componente = null;
                            Object objeto = p;
                            if (objeto instanceof Procesador) {
                                componente = "procesador";
                            } else if (objeto instanceof Placamadre) {
                                componente = "Placamadre";
                            } else if (objeto instanceof Tarjetagrafica) {
                                componente = "Tarjetagrafica";
                            } else if (objeto instanceof memoriaRam) {
                                componente = "memoriaRam";
                            } else if (objeto instanceof FuentePoder) {
                                componente = "FuentePoder";
                            } else if (objeto instanceof almacenamiento) {
                                componente = "almacenamiento";
                            } else if (objeto instanceof Ventiladores) {
                                componente = "Ventiladores";
                            } else if (objeto instanceof Disipadores) {
                                componente = "Disipadores";
                            } else if (objeto instanceof Gabinete) {
                                componente = "Gabinete";
                            }

                            VentanaDatosEnvio vist = new VentanaDatosEnvio();
                            ModeloDatosEnvio mDtos = new ModeloDatosEnvio();
                            ControladorVenDatosEnvio log = new ControladorVenDatosEnvio(vist, mDtos, p.getIdMemoriaRam(), componente, p.getPrecio());
                            log.iniciaControlador();

                            vista.dispose();

                        });

                        //margen
                        JLabel label = new JLabel(" ");
                        label.setAlignmentX(Component.CENTER_ALIGNMENT);
                        label.setFont(new java.awt.Font("Montserrat", 0, 10));
                        panelComponentes.add(label);

                        imageLabel.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                vista.setEnabled(false);
                                vista.getJdlgDetallesMemoriaR().setSize(798, 533);
                                vista.getJdlgDetallesMemoriaR().setLocationRelativeTo(null);
                                vista.getJdlgDetallesMemoriaR().setUndecorated(true);
                                vista.getJdlgDetallesMemoriaR().setVisible(true);

                                //cargar campos
                                vista.getLblMarcaMemoriaR().setText(p.getMarca());
                                vista.getLblModeloMemoriaR().setText(p.getModelo());
                                vista.getLblCapacidadMemoriaR().setText(String.valueOf(p.getCapacidad()));
                                vista.getLblTipoMemoriaR().setText(p.getTipo());
                                vista.getLblStockMemoriaR().setText(String.valueOf(p.getStock()));
                                vista.getLblPrecioMemoriaR().setText(String.valueOf(p.getPrecio()));
                                vista.getJdlgDetallesMemoriaR().setVisible(true);

                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {
                                imageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                            }

                            @Override
                            public void mouseExited(MouseEvent e) {
                                imageLabel.setCursor(Cursor.getDefaultCursor());
                            }
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
        } else if (vista.getjCbCategorias().getSelectedItem().equals("Fuentes de poder")) {
            List<FuentePoder> FuenteP = ModeloFuentePoder.listaTodasFuentePoder();
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

                for (FuentePoder p : FuenteP) {
                    // Verificar si la imagen no es nula
                    if (p.getFoto() != null) {
                        System.out.println(p.toString());
                        ImageIcon imageIcon = new ImageIcon(p.getFoto());
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

                        JButton comprar = new JButton("Comprar");
                        comprar.setAlignmentX(Component.CENTER_ALIGNMENT);
                        comprar.setFont(new java.awt.Font("Montserrat", 0, 14));
                        comprar.setForeground(Color.GREEN);
                        panelComponentes.add(comprar);

                        // Agregar ActionListener al botón "Comprar"
                        comprar.addActionListener((ActionEvent e) -> {
                            // Crea e muestra la nueva ventana de compra
                            String componente = null;
                            Object objeto = p;
                            if (objeto instanceof Procesador) {
                                componente = "procesador";
                            } else if (objeto instanceof Placamadre) {
                                componente = "Placamadre";
                            } else if (objeto instanceof Tarjetagrafica) {
                                componente = "Tarjetagrafica";
                            } else if (objeto instanceof memoriaRam) {
                                componente = "memoriaRam";
                            } else if (objeto instanceof FuentePoder) {
                                componente = "FuentePoder";
                            } else if (objeto instanceof almacenamiento) {
                                componente = "almacenamiento";
                            } else if (objeto instanceof Ventiladores) {
                                componente = "Ventiladores";
                            } else if (objeto instanceof Disipadores) {
                                componente = "Disipadores";
                            } else if (objeto instanceof Gabinete) {
                                componente = "Gabinete";
                            }

                            VentanaDatosEnvio vist = new VentanaDatosEnvio();
                            ModeloDatosEnvio mDtos = new ModeloDatosEnvio();
                            ControladorVenDatosEnvio log = new ControladorVenDatosEnvio(vist, mDtos, p.getIdFuentePoder(), componente, p.getPrecio());
                            log.iniciaControlador();

                            vista.dispose();

                        });

                        //margen
                        JLabel label = new JLabel(" ");
                        label.setAlignmentX(Component.CENTER_ALIGNMENT);
                        label.setFont(new java.awt.Font("Montserrat", 0, 10));
                        panelComponentes.add(label);

                        imageLabel.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                vista.setEnabled(false);
                                vista.getJdlgDetallesFuenteP().setSize(798, 533);
                                vista.getJdlgDetallesFuenteP().setLocationRelativeTo(null);
                                vista.getJdlgDetallesFuenteP().setUndecorated(true);
                                vista.getJdlgDetallesFuenteP().setVisible(true);

                                //cargar campos
                                vista.getLblMarcaFuenteP().setText(p.getMarca());
                                vista.getLblModeloFuenteP().setText(p.getModelo());
                                vista.getLblWattsFuenteP().setText(String.valueOf(p.getWatts()));
                                vista.getLblFormatoFuenteP().setText(p.getFormato());
                                vista.getLblCertificacionFuenteP().setText(p.getCertificacion());
                                vista.getLblModularFuenteP().setText(p.getModular());
                                vista.getLblStockFuenteP().setText(String.valueOf(p.getStock()));
                                vista.getLblPrecioFuenteP().setText(String.valueOf(p.getPrecio()));
                                vista.getJdlgDetallesFuenteP().setVisible(true);

                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {
                                imageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                            }

                            @Override
                            public void mouseExited(MouseEvent e) {
                                imageLabel.setCursor(Cursor.getDefaultCursor());
                            }
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
        } else if (vista.getjCbCategorias().getSelectedItem().equals("Almacenamiento")) {
            List<almacenamiento> Almacena = ModeloAlmacenamiento.listaTodasAlmacenamiento();
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

                for (almacenamiento p : Almacena) {
                    // Verificar si la imagen no es nula
                    if (p.getFoto() != null) {
                        System.out.println(p.toString());
                        ImageIcon imageIcon = new ImageIcon(p.getFoto());
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

                        JButton comprar = new JButton("Comprar");
                        comprar.setAlignmentX(Component.CENTER_ALIGNMENT);
                        comprar.setFont(new java.awt.Font("Montserrat", 0, 14));
                        comprar.setForeground(Color.GREEN);
                        panelComponentes.add(comprar);

                        // Agregar ActionListener al botón "Comprar"
                        comprar.addActionListener((ActionEvent e) -> {
                            // Crea e muestra la nueva ventana de compra
                            String componente = null;
                            Object objeto = p;
                            if (objeto instanceof Procesador) {
                                componente = "procesador";
                            } else if (objeto instanceof Placamadre) {
                                componente = "Placamadre";
                            } else if (objeto instanceof Tarjetagrafica) {
                                componente = "Tarjetagrafica";
                            } else if (objeto instanceof memoriaRam) {
                                componente = "memoriaRam";
                            } else if (objeto instanceof FuentePoder) {
                                componente = "FuentePoder";
                            } else if (objeto instanceof almacenamiento) {
                                componente = "almacenamiento";
                            } else if (objeto instanceof Ventiladores) {
                                componente = "Ventiladores";
                            } else if (objeto instanceof Disipadores) {
                                componente = "Disipadores";
                            } else if (objeto instanceof Gabinete) {
                                componente = "Gabinete";
                            }

                            VentanaDatosEnvio vist = new VentanaDatosEnvio();
                            ModeloDatosEnvio mDtos = new ModeloDatosEnvio();
                            ControladorVenDatosEnvio log = new ControladorVenDatosEnvio(vist, mDtos, p.getIdalmacenamiento(), componente, p.getPrecio());
                            log.iniciaControlador();

                            vista.dispose();

                        });

                        //margen
                        JLabel label = new JLabel(" ");
                        label.setAlignmentX(Component.CENTER_ALIGNMENT);
                        label.setFont(new java.awt.Font("Montserrat", 0, 10));
                        panelComponentes.add(label);

                        imageLabel.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                vista.setEnabled(false);
                                vista.getJdlgDetallesAlmacena().setSize(798, 533);
                                vista.getJdlgDetallesAlmacena().setLocationRelativeTo(null);
                                vista.getJdlgDetallesAlmacena().setUndecorated(true);
                                vista.getJdlgDetallesAlmacena().setVisible(true);

                                //cargar campos
                                vista.getLblMarcaAlmacena().setText(p.getMarca());
                                vista.getLblModeloAlmacena().setText(p.getModelo());
                                vista.getLblTipoAlmacena().setText(p.getTipo());
                                vista.getLblCapacidadAlmacena().setText(String.valueOf(p.getCapacidad()));
                                vista.getLblStockAlmacena().setText(String.valueOf(p.getStock()));
                                vista.getLblPrecioAlmacena().setText(String.valueOf(p.getPrecio()));
                                vista.getJdlgDetallesAlmacena().setVisible(true);

                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {
                                imageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                            }

                            @Override
                            public void mouseExited(MouseEvent e) {
                                imageLabel.setCursor(Cursor.getDefaultCursor());
                            }
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
        } else if (vista.getjCbCategorias().getSelectedItem().equals("Ventiladores")) {
            List<Ventiladores> Ventila = ModeloVentiladores.listaTodasventiladores();
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

                for (Ventiladores p : Ventila) {
                    // Verificar si la imagen no es nula
                    if (p.getFoto() != null) {
                        System.out.println(p.toString());
                        ImageIcon imageIcon = new ImageIcon(p.getFoto());
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

                        JButton comprar = new JButton("Comprar");
                        comprar.setAlignmentX(Component.CENTER_ALIGNMENT);
                        comprar.setFont(new java.awt.Font("Montserrat", 0, 14));
                        comprar.setForeground(Color.GREEN);
                        panelComponentes.add(comprar);

                        // Agregar ActionListener al botón "Comprar"
                        comprar.addActionListener((ActionEvent e) -> {
                            // Crea e muestra la nueva ventana de compra
                            String componente = null;
                            Object objeto = p;
                            if (objeto instanceof Procesador) {
                                componente = "procesador";
                            } else if (objeto instanceof Placamadre) {
                                componente = "Placamadre";
                            } else if (objeto instanceof Tarjetagrafica) {
                                componente = "Tarjetagrafica";
                            } else if (objeto instanceof memoriaRam) {
                                componente = "memoriaRam";
                            } else if (objeto instanceof FuentePoder) {
                                componente = "FuentePoder";
                            } else if (objeto instanceof almacenamiento) {
                                componente = "almacenamiento";
                            } else if (objeto instanceof Ventiladores) {
                                componente = "Ventiladores";
                            } else if (objeto instanceof Disipadores) {
                                componente = "Disipadores";
                            } else if (objeto instanceof Gabinete) {
                                componente = "Gabinete";
                            }

                            VentanaDatosEnvio vist = new VentanaDatosEnvio();
                            ModeloDatosEnvio mDtos = new ModeloDatosEnvio();
                            ControladorVenDatosEnvio log = new ControladorVenDatosEnvio(vist, mDtos, p.getIdVentiladores(), componente, p.getPrecio());
                            log.iniciaControlador();

                            vista.dispose();

                        });

                        //margen
                        JLabel label = new JLabel(" ");
                        label.setAlignmentX(Component.CENTER_ALIGNMENT);
                        label.setFont(new java.awt.Font("Montserrat", 0, 10));
                        panelComponentes.add(label);

                        imageLabel.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                vista.setEnabled(false);
                                vista.getJdlgDetallesVentila().setSize(798, 533);
                                vista.getJdlgDetallesVentila().setLocationRelativeTo(null);
                                vista.getJdlgDetallesVentila().setUndecorated(true);
                                vista.getJdlgDetallesVentila().setVisible(true);

                                //cargar campos
                                vista.getLblMarcaVentila().setText(p.getMarca());
                                vista.getLblModeloVentila().setText(p.getModelo());
                                vista.getLblRGBVentila().setText(p.getRGB());
                                vista.getLblTamañoVentila().setText(String.valueOf(p.getTamaño()));
                                vista.getLblPrecioVentila().setText(String.valueOf(p.getPrecio()));
                                vista.getJdlgDetallesVentila().setVisible(true);

                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {
                                imageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                            }

                            @Override
                            public void mouseExited(MouseEvent e) {
                                imageLabel.setCursor(Cursor.getDefaultCursor());
                            }
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
        } else if (vista.getjCbCategorias().getSelectedItem().equals("Disipadores")) {
            List<Disipadores> Dispa = ModeloDisipadores.listaTodasDisipadores();
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

                for (Disipadores p : Dispa) {
                    // Verificar si la imagen no es nula
                    if (p.getFoto() != null) {
                        System.out.println(p.toString());
                        ImageIcon imageIcon = new ImageIcon(p.getFoto());
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

                        JButton comprar = new JButton("Comprar");
                        comprar.setAlignmentX(Component.CENTER_ALIGNMENT);
                        comprar.setFont(new java.awt.Font("Montserrat", 0, 14));
                        comprar.setForeground(Color.GREEN);
                        panelComponentes.add(comprar);

                        // Agregar ActionListener al botón "Comprar"
                        comprar.addActionListener((ActionEvent e) -> {
                            // Crea e muestra la nueva ventana de compra
                            String componente = null;
                            Object objeto = p;
                            if (objeto instanceof Procesador) {
                                componente = "procesador";
                            } else if (objeto instanceof Placamadre) {
                                componente = "Placamadre";
                            } else if (objeto instanceof Tarjetagrafica) {
                                componente = "Tarjetagrafica";
                            } else if (objeto instanceof memoriaRam) {
                                componente = "memoriaRam";
                            } else if (objeto instanceof FuentePoder) {
                                componente = "FuentePoder";
                            } else if (objeto instanceof almacenamiento) {
                                componente = "almacenamiento";
                            } else if (objeto instanceof Ventiladores) {
                                componente = "Ventiladores";
                            } else if (objeto instanceof Disipadores) {
                                componente = "Disipadores";
                            } else if (objeto instanceof Gabinete) {
                                componente = "Gabinete";
                            }

                            VentanaDatosEnvio vist = new VentanaDatosEnvio();
                            ModeloDatosEnvio mDtos = new ModeloDatosEnvio();
                            ControladorVenDatosEnvio log = new ControladorVenDatosEnvio(vist, mDtos, p.getIdDisipadores(), componente, p.getPrecio());
                            log.iniciaControlador();

                            vista.dispose();

                        });

                        //margen
                        JLabel label = new JLabel(" ");
                        label.setAlignmentX(Component.CENTER_ALIGNMENT);
                        label.setFont(new java.awt.Font("Montserrat", 0, 10));
                        panelComponentes.add(label);

                        imageLabel.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                vista.setEnabled(false);
                                vista.getJdlgDetallesDisparadores().setSize(798, 533);
                                vista.getJdlgDetallesDisparadores().setLocationRelativeTo(null);
                                vista.getJdlgDetallesDisparadores().setUndecorated(true);
                                vista.getJdlgDetallesDisparadores().setVisible(true);

                                //cargar campos
                                vista.getLblMarcaDisparadores().setText(p.getMarca());
                                vista.getLblModeloDisparadores().setText(p.getModelo());
                                vista.getLblSocketDisparadores().setText(p.getSocket());
                                vista.getLblRGBDisparadores().setText(String.valueOf(p.getRGB()));
                                vista.getLblVentiladoresDisparadores().setText(String.valueOf(p.getVentiladores()));
                                vista.getLblPrecioDisparadores().setText(String.valueOf(p.getPrecio()));
                                vista.getLblStockDisparadores().setText(String.valueOf(p.getStock()));
                                vista.getJdlgDetallesDisparadores().setVisible(true);

                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {
                                imageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                            }

                            @Override
                            public void mouseExited(MouseEvent e) {
                                imageLabel.setCursor(Cursor.getDefaultCursor());
                            }
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
        } else if (vista.getjCbCategorias().getSelectedItem().equals("Gabinetes")) {
            List<Gabinete> Gabi = ModeloGabinete.listaGabinete();
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

                for (Gabinete p : Gabi) {
                    // Verificar si la imagen no es nula
                    if (p.getFoto() != null) {
                        System.out.println(p.toString());
                        ImageIcon imageIcon = new ImageIcon(p.getFoto());
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

                        JButton comprar = new JButton("Comprar");
                        comprar.setAlignmentX(Component.CENTER_ALIGNMENT);
                        comprar.setFont(new java.awt.Font("Montserrat", 0, 14));
                        comprar.setForeground(Color.GREEN);
                        panelComponentes.add(comprar);

                        // Agregar ActionListener al botón "Comprar"
                        comprar.addActionListener((ActionEvent e) -> {
                            // Crea e muestra la nueva ventana de compra
                            String componente = null;
                            Object objeto = p;
                            if (objeto instanceof Procesador) {
                                componente = "procesador";
                            } else if (objeto instanceof Placamadre) {
                                componente = "Placamadre";
                            } else if (objeto instanceof Tarjetagrafica) {
                                componente = "Tarjetagrafica";
                            } else if (objeto instanceof memoriaRam) {
                                componente = "memoriaRam";
                            } else if (objeto instanceof FuentePoder) {
                                componente = "FuentePoder";
                            } else if (objeto instanceof almacenamiento) {
                                componente = "almacenamiento";
                            } else if (objeto instanceof Ventiladores) {
                                componente = "Ventiladores";
                            } else if (objeto instanceof Disipadores) {
                                componente = "Disipadores";
                            } else if (objeto instanceof Gabinete) {
                                componente = "Gabinete";
                            }

                            VentanaDatosEnvio vist = new VentanaDatosEnvio();
                            ModeloDatosEnvio mDtos = new ModeloDatosEnvio();
                            ControladorVenDatosEnvio log = new ControladorVenDatosEnvio(vist, mDtos, p.getIdgabinete(), componente, p.getPrecio());
                            log.iniciaControlador();

                            vista.dispose();

                        });

                        //margen
                        JLabel label = new JLabel(" ");
                        label.setAlignmentX(Component.CENTER_ALIGNMENT);
                        label.setFont(new java.awt.Font("Montserrat", 0, 10));
                        panelComponentes.add(label);

                        imageLabel.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                vista.setEnabled(false);
                                vista.getJdlgDetallesGabinete().setSize(798, 533);
                                vista.getJdlgDetallesGabinete().setLocationRelativeTo(null);
                                vista.getJdlgDetallesGabinete().setUndecorated(true);
                                vista.getJdlgDetallesGabinete().setVisible(true);

                                //cargar campos
                                vista.getLblMarcaGabinete().setText(p.getMarca());
                                vista.getLblModeloGabinete().setText(p.getModelo());
                                vista.getLblPuertUSBGabinete().setText(String.valueOf(p.getPuertousb()));
                                vista.getLblNumVentilGabinete().setText(String.valueOf(p.getVentiladores()));
                                vista.getLblBahiasGabinete().setText(p.getBahias());
                                vista.getLblFormatoGabinete().setText(String.valueOf(p.getFormato()));
                                vista.getLblPrecioGabinete().setText(String.valueOf(p.getPrecio()));
                                vista.getLblStockGabinete().setText(String.valueOf(p.getStock()));
                                vista.getJdlgDetallesGabinete().setVisible(true);

                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {
                                imageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                            }

                            @Override
                            public void mouseExited(MouseEvent e) {
                                imageLabel.setCursor(Cursor.getDefaultCursor());
                            }
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
        }
    }

    public void Ventana() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(vista.getJpComponentes());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {

        }
    }

    public void botonUsuario() {

    }

    public void botonArmadoPC() {
        
        
        ArmadoProc_JB aramarPC = new ArmadoProc_JB();
        Controlador.ArmadoProcJB m = new ArmadoProcJB(aramarPC);
        m.Inicio();
        vista.dispose();
    }
    
    
    

    public void AceptarDlgDetalle() {
        vista.getJdlgDetalles().setVisible(false);
        vista.getJdlgDetalles().dispose();
        vista.setEnabled(true);
        vista.setVisible(true);
    }

    public void AceptarDlgDetallePlaca() {
        vista.getJdlgDetallesPlaca().setVisible(false);
        vista.getJdlgDetallesPlaca().dispose();
        vista.setEnabled(true);
        vista.setVisible(true);
    }

    public void AceptarDlgDetalleTarjeta() {
        vista.getJdlgDetallesTarjetaG().setVisible(false);
        vista.getJdlgDetallesTarjetaG().dispose();
        vista.setEnabled(true);
        vista.setVisible(true);
    }

    public void AceptarDlgDetalleMemoriaR() {
        vista.getJdlgDetallesMemoriaR().setVisible(false);
        vista.getJdlgDetallesMemoriaR().dispose();
        vista.setEnabled(true);
        vista.setVisible(true);
    }

    public void AceptarDlgDetalleFuenteP() {
        vista.getJdlgDetallesFuenteP().setVisible(false);
        vista.getJdlgDetallesFuenteP().dispose();
        vista.setEnabled(true);
        vista.setVisible(true);
    }

    public void AceptarDlgDetalleAlmacenamiento() {
        vista.getJdlgDetallesAlmacena().setVisible(false);
        vista.getJdlgDetallesAlmacena().dispose();
        vista.setEnabled(true);
        vista.setVisible(true);
    }

    public void AceptarDlgDetalleVentiladores() {
        vista.getJdlgDetallesVentila().setVisible(false);
        vista.getJdlgDetallesVentila().dispose();
        vista.setEnabled(true);
        vista.setVisible(true);
    }

    public void AceptarDlgDetalleDsiparadores() {
        vista.getJdlgDetallesDisparadores().setVisible(false);
        vista.getJdlgDetallesDisparadores().dispose();
        vista.setEnabled(true);
        vista.setVisible(true);
    }

    public void AceptarDlgDetalleGabinetes() {
        vista.getJdlgDetallesGabinete().setVisible(false);
        vista.getJdlgDetallesGabinete().dispose();
        vista.setEnabled(true);
        vista.setVisible(true);
    }
}
