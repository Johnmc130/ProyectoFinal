package Controlador;

import Clases.Tarjetagrafica;
import Modelo.ModeloTarjetaGrafica;
import Vista.ArmadoPlaca_JB;
import Vista.ArmadoRam_JB;
import Vista.ArmadoTarjetaV_JB;
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
import java.text.DecimalFormat;
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
 * @author TheBigG
 */
/**
 * Controlador para la vista de armado de tarjetas gráficas
 */
public class ArmadoTarjetaVJB {

    private ArmadoTarjetaV_JB vistaTV; // Referencia a la vista de armado de tarjetas gráficas

    /**
     * Constructor de la clase que recibe la vista de armado de tarjetas gráficas
     * @param vista La vista de armado de tarjetas gráficas
     */
    public ArmadoTarjetaVJB(ArmadoTarjetaV_JB vista) {
        this.vistaTV = vista;
        vista.setVisible(true); // Hace visible la vista al crear el controlador
    }

    /**
     * Método para inicializar la vista y cargar los componentes necesarios
     */
    public void Inicio() {
        vistaTV.setLocationRelativeTo(null); // Centra la vista en la pantalla
        CargarComponentes(); // Carga los componentes de las tarjetas gráficas en la vista

        // Agrega listeners a los botones de la vista
        vistaTV.getBtJdlDetalleAceptar().addActionListener(l -> aceptarDlgDetalle());
        vistaTV.getBtJdlMAceptar().addActionListener(l -> aceptarDlg());
        vistaTV.getBtJdlMAtras().addActionListener(l -> AtrasDlgMensaje());
        vistaTV.getBtAtras().addActionListener(l -> atras());
        Ventana(); // Configura la apariencia de la ventana
    }

    /**
     * Método para cargar los componentes de las tarjetas gráficas en la vista
     */
    private void CargarComponentes() {
        List<Tarjetagrafica> tarjetasGraficas = ModeloTarjetaGrafica.listaTarjetaGrafica(); // Obtiene la lista de tarjetas gráficas del modelo

        // Asegura que la carga y manipulación de los componentes Swing se realice en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            // Configura el panel principal con un GridBagLayout
            vistaTV.getJpComponentes().setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weighty = 1.0;
            gbc.insets = new Insets(10, 10, 10, 10); // Espacio uniforme entre filas y columnas
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.ipadx = 10; // Separación horizontal entre componentes

            // Panel para contener los componentes de las tarjetas gráficas
            JPanel contentPanel = new JPanel();
            contentPanel.setLayout(new GridBagLayout());
            contentPanel.setBackground(Color.white);

            GridBagConstraints contentGbc = new GridBagConstraints();
            contentGbc.gridx = 0;
            contentGbc.gridy = 0;
            contentGbc.weightx = 1.0;
            contentGbc.weighty = 1.0;
            contentGbc.fill = GridBagConstraints.BOTH; // Relleno en ambas direcciones

            // Recorre la lista de tarjetas gráficas y muestra cada una en la vista
            for (Tarjetagrafica p : tarjetasGraficas) {
                // Verifica si la imagen no es nula
                if (p.getFoto() != null) {
                    // Crea y configura los componentes para mostrar la tarjeta gráfica
                    ImageIcon imageIcon = new ImageIcon(p.getFoto());
                    Image image = imageIcon.getImage();
                    Image scaledImage = image.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(scaledImage);

                    JPanel panelComponentes = new JPanel();
                    panelComponentes.setLayout(new BoxLayout(panelComponentes, BoxLayout.Y_AXIS));
                    panelComponentes.setBackground(Color.WHITE); // Fondo blanco
                    panelComponentes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 212, 250), 3));

                    // Agrega una etiqueta de margen
                    JLabel label1 = new JLabel(" ");
                    label1.setAlignmentX(Component.CENTER_ALIGNMENT);
                    label1.setFont(new java.awt.Font("Montserrat", 0, 10));
                    panelComponentes.add(label1);

                    // Agrega la imagen de la tarjeta gráfica
                    JLabel imageLabel = new JLabel();
                    imageLabel.setIcon(scaledIcon);
                    imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    imageLabel.setOpaque(false); // Hacer el fondo del JLabel transparente
                    panelComponentes.add(imageLabel);

                    // Agrega el nombre de la tarjeta gráfica
                    JLabel nameLabel = new JLabel(p.getMarca() + " " + p.getModelo());
                    nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    nameLabel.setFont(new java.awt.Font("Montserrat", 0, 18));
                    panelComponentes.add(nameLabel);

                    // Agrega un botón para ver detalles de la tarjeta gráfica
                    JButton detalles = new JButton("Detalles");
                    detalles.setAlignmentX(Component.LEFT_ALIGNMENT);
                    detalles.setFont(new java.awt.Font("Montserrat", 0, 14));
                    detalles.setForeground(Color.BLUE);
                    panelComponentes.add(detalles);

                    // Agrega una etiqueta de margen
                    JLabel label = new JLabel(" ");
                    label.setAlignmentX(Component.CENTER_ALIGNMENT);
                    label.setFont(new java.awt.Font("Montserrat", 0, 10));
                    panelComponentes.add(label);

                    // Maneja el evento de clic en la imagen de la tarjeta gráfica
                    imageLabel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            vistaTV.setEnabled(false);
                            vistaTV.getJdlgMensaje().setSize(509, 357);
                            vistaTV.getJdlgMensaje().setLocationRelativeTo(null);
                            vistaTV.getJdlgMensaje().setUndecorated(true);
                            vistaTV.getJdlgMensaje().setVisible(true);
                            ArmadoProcJB.pc.setIdTarjetaGrafica(p.getIdtarjetag());
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

                    // Maneja el evento de clic en el botón de detalles
                    detalles.addActionListener((ActionEvent e) -> {
                        vistaTV.setEnabled(false);
                        vistaTV.getJdlgDetalles().setSize(731, 502);
                        vistaTV.getJdlgDetalles().setLocationRelativeTo(null);
                        vistaTV.getJdlgDetalles().setUndecorated(true);
                        vistaTV.getJdlgDetalles().setVisible(true);
                        // Carga los campos de detalle en la vista
                        vistaTV.getLblMarca().setText(p.getMarca());
                        vistaTV.getLblModelo().setText(p.getModelo());
                        vistaTV.getLblDLSS().setText(p.getDlss()); 
                        vistaTV.getLblFSR().setText(p.getFsr());
                        vistaTV.getLblVRam().setText(String.valueOf(p.getVram()));
                        vistaTV.getLblStock().setText(String.valueOf(p.getStock()));
                        // Formatea y muestra el precio
                        DecimalFormat formatoPrecio = new DecimalFormat("#.##");
                        vistaTV.getLblPrecio().setText(formatoPrecio.format(p.getPrecio()));
                        vistaTV.getLblPrecio().setText(String.valueOf(p.getPrecio()));
                        vistaTV.getJdlgDetalles().setVisible(true);
                    });

                    // Verifica si se alcanzó el límite de 3 imágenes por fila antes de incrementar la posición en la columna
                    if (contentGbc.gridx == 3) {
                        contentGbc.gridx = 0; // Reinicia la posición en la columna
                        contentGbc.gridy++; // Incrementa el valor de y para la nueva fila
                        contentGbc.insets = new Insets(10, 10, 40, 10); // Agrega espacio vertical entre filas
                    } else {
                        contentGbc.insets = new Insets(10, 10, 40, 10); // Restablece los márgenes para las demás filas
                    }
                    contentGbc.gridx++; // Incrementa la posición en la columna para la próxima iteración

                    // Agrega el panelComponentes al panel principal utilizando las restricciones del GridBagConstraints
                    contentPanel.add(panelComponentes, contentGbc);
                }
            }

            // Establece el tamaño preferido del contentPanel
            contentPanel.setPreferredSize(contentPanel.getPreferredSize());

            // Crea un nuevo JScrollPane y configura las propiedades
            JScrollPane scrollPane = new JScrollPane(contentPanel);
            scrollPane.setBorder(null);
            scrollPane.setBackground(Color.WHITE);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.getVerticalScrollBar().setUnitIncrement(20); // Ajusta la velocidad de desplazamiento

            // Agrega el scrollPane al panel principal
            vistaTV.getJpComponentes().setLayout(new BorderLayout());
            vistaTV.getJpComponentes().add(scrollPane, BorderLayout.CENTER);

            // Repinta la ventana para mostrar los cambios
            vistaTV.revalidate();
            vistaTV.repaint();
        });
    }

    /**
     * Método para configurar la apariencia de la ventana
     */
    public void Ventana() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Establece el aspecto del sistema operativo
            SwingUtilities.updateComponentTreeUI(vistaTV.getJpComponentes()); // Actualiza la apariencia de los componentes
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            // Maneja las excepciones de configuración de la apariencia
        }
    }

    /**
     * Método para aceptar la ventana de detalles y volver a la vista principal
     */
    public void aceptarDlgDetalle() {
        vistaTV.getJdlgDetalles().setVisible(false);
        vistaTV.getJdlgDetalles().dispose();
        vistaTV.setEnabled(true);
        vistaTV.setVisible(true);
    }

    /**
     * Método para aceptar la selección de una tarjeta gráfica y pasar a la vista de armado de RAM
     */
    public void aceptarDlg() {
        vistaTV.getJdlgMensaje().setVisible(false);
        vistaTV.getJdlgMensaje().dispose();
        vistaTV.setEnabled(true);
        ArmadoRam_JB vista = new ArmadoRam_JB();
        ArmadoRamJB controlador = new ArmadoRamJB(vista);
        controlador.Inicio();
        vistaTV.setVisible(false);
        vistaTV.dispose();
    }

    /**
     * Método para retroceder desde la ventana de mensaje a la vista principal
     */
    public void AtrasDlgMensaje() {
        SwingUtilities.invokeLater(() -> {
            vistaTV.getJdlgMensaje().setVisible(false);
            vistaTV.getJdlgMensaje().dispose();
            vistaTV.setEnabled(true);
            vistaTV.setVisible(true);
        });
    }

    /**
     * Método para retroceder a la vista de armado de placas
     */
    public void atras() {
        ArmadoPlaca_JB vista = new ArmadoPlaca_JB();
        ArmadoPlacaJB controlador = new ArmadoPlacaJB(vista);
        controlador.Inicio();
        vistaTV.setVisible(false);
        vistaTV.dispose();
    }
}

