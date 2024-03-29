package Controlador;

import Clases.Disipadores;
import Modelo.ModeloDisipadores;
import Modelo.ModeloPcResumen;
import Vista.ArmadoDisipador_JB;
import Vista.ArmadoResumen_JB;
import Vista.ArmadoVentiladores_JB;
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
 * Controlador para la vista de armado de memoria RAM
 */
public class ArmadoDisipadorRC{

    private ArmadoDisipador_JB vistaDisipador; // Referencia a la vista de armado de memoria RAM

    /**
     * Constructor de la clase que recibe la vista de armado de memoria RAM
     * @param vista La vista de armado de memoria RAM
     */
    public ArmadoDisipadorRC(ArmadoDisipador_JB vista) {
        this.vistaDisipador = vista;
        vista.setVisible(true); // Hace visible la vista al crear el controlador
    }

    /**
     * Método para inicializar la vista y cargar los componentes necesarios
     */
    public void Inicio() {
        vistaDisipador.setLocationRelativeTo(null); // Centra la vista en la pantalla
        CargarComponentes(); // Carga los componentes de las memorias RAM en la vista

        // Agrega listeners a los botones de la vista
        vistaDisipador.getBtJdlDetalleAceptar().addActionListener(l -> aceptarDlgDetalle());
        vistaDisipador.getBtJdlMensajeElejir().addActionListener(l -> aceptarDlg());
        vistaDisipador.getBtJdlMAtras().addActionListener(l -> AtrasDlgMensaje());
        vistaDisipador.getBtAtras().addActionListener(l -> atras());
        Ventana(); // Configura la apariencia de la ventana
    }

    /**
     * Método para cargar los componentes de las memorias RAM en la vista
     */
    private void CargarComponentes() {
        List<Disipadores> disipadores = ModeloDisipadores.listaTodasDisipadoresCompatibles(ModeloPcResumen.cargarProcesador(ArmadoProcJB.pc.getIdProcesador()).getSocket()); // Obtiene la lista de memorias RAM del modelo

        // Asegura que la carga y manipulación de los componentes Swing se realice en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            // Configura el panel principal con un GridBagLayout
            vistaDisipador.getJpComponentes().setLayout(new GridBagLayout());
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

            // Recorre la lista de memorias RAM y muestra cada una en la vista
            for (Disipadores disipador : disipadores) {
                // Verifica si la imagen no es nula
                if (disipador.getFoto() == null) {
                    System.out.println("foto");
                } 
                if (disipador.getFoto() != null) {
                    System.out.println("aaaaaaaaaaa");
                    System.out.println(disipador.toString());
                    // Crea y configura los componentes para mostrar la memoria RAM
                    ImageIcon imageIcon = new ImageIcon(disipador.getFoto());
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

                    // Agrega la imagen de la memoria RAM
                    JLabel imageLabel = new JLabel();
                    imageLabel.setIcon(scaledIcon);
                    imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    imageLabel.setOpaque(false); // Hacer el fondo del JLabel transparente
                    panelComponentes.add(imageLabel);

                    // Agrega el nombre de la memoria RAM
                    JLabel nameLabel = new JLabel(disipador.getMarca() + " " + disipador.getModelo());
                    nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    nameLabel.setFont(new java.awt.Font("Montserrat", 0, 18));
                    panelComponentes.add(nameLabel);

                    // Agrega un botón para ver detalles de la memoria RAM
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

                    // Maneja el evento de clic en la imagen de la memoria RAM
                    imageLabel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            vistaDisipador.setEnabled(false);
                            vistaDisipador.getJdlgMensaje().setSize(574, 357);
                            vistaDisipador.getJdlgMensaje().setLocationRelativeTo(null);
                            vistaDisipador.getJdlgMensaje().setUndecorated(true);
                            vistaDisipador.getJdlgMensaje().setVisible(true);
                            ArmadoProcJB.pc.setIdDisipador(disipador.getIdDisipadores());
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
                        vistaDisipador.setEnabled(false);
                        vistaDisipador.getJdlgDetalles().setSize(731, 502);
                        vistaDisipador.getJdlgDetalles().setLocationRelativeTo(null);
                        vistaDisipador.getJdlgDetalles().setUndecorated(true);
                        vistaDisipador.getJdlgDetalles().setVisible(true);
                        // Carga los detalles de la memoria RAM en la vista
                        vistaDisipador.getLblMarca().setText(disipador.getMarca());
                        vistaDisipador.getLblModelo().setText(disipador.getModelo());
                        vistaDisipador.getLblSocket().setText(disipador.getSocket());
                        vistaDisipador.getLblRGB().setText(disipador.getRGB());
                        vistaDisipador.getLblVentiladores().setText(String.valueOf(disipador.getVentiladores()));
                        vistaDisipador.getLblStock().setText(String.valueOf(disipador.getStock()));
                        // Formatea el precio y lo muestra en la vista
                        DecimalFormat formatoPrecio = new DecimalFormat("#.##");
                        vistaDisipador.getLblPrecio().setText(formatoPrecio.format(disipador.getPrecio()));
                        vistaDisipador.getJdlgDetalles().setVisible(true);
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

            // Crea un nuevo JScrollPane y configura sus propiedades
            JScrollPane scrollPane = new JScrollPane(contentPanel);
            scrollPane.setBorder(null);
            scrollPane.setBackground(Color.WHITE);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.getVerticalScrollBar().setUnitIncrement(20); // Ajusta la velocidad de desplazamiento

            // Agrega el scrollPane al panel principal
            vistaDisipador.getJpComponentes().setLayout(new BorderLayout());
            vistaDisipador.getJpComponentes().add(scrollPane, BorderLayout.CENTER);

            // Repinta la ventana para mostrar los cambios
            vistaDisipador.revalidate();
            vistaDisipador.repaint();
        });
    }

    /**
     * Método para configurar la apariencia de la ventana
     */
    public void Ventana() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Establece el aspecto del sistema operativo
            SwingUtilities.updateComponentTreeUI(vistaDisipador.getJpComponentes()); // Actualiza la apariencia de los componentes
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            // Maneja las excepciones de configuración de la apariencia
        }
    }

    /**
     * Método para aceptar la ventana de detalles y volver a la vista principal
     */
    public void aceptarDlgDetalle() {
        vistaDisipador.getJdlgDetalles().setVisible(false);
        vistaDisipador.getJdlgDetalles().dispose();
        vistaDisipador.setEnabled(true);
        vistaDisipador.setVisible(true);
    }

    /**
     * Método para aceptar la selección de una memoria RAM y pasar a la vista de armado de fuente de poder
     */
    public void aceptarDlg() {
        vistaDisipador.getJdlgMensaje().setVisible(false);
        vistaDisipador.getJdlgMensaje().dispose();
        vistaDisipador.setEnabled(true);
        ArmadoResumen_JB vista = new ArmadoResumen_JB();
        ModeloPcResumen modelo = new ModeloPcResumen();
       ArmadoResumenJB controlador = new ArmadoResumenJB(vista, modelo);
       controlador.Inicio();
        vistaDisipador.setVisible(false);
        vistaDisipador.dispose();
    }

    /**
     * Método para retroceder desde la ventana de mensaje a la vista principal
     */
    public void AtrasDlgMensaje() {
        SwingUtilities.invokeLater(() -> {
            vistaDisipador.getJdlgMensaje().setVisible(false);
            vistaDisipador.getJdlgMensaje().dispose();
            vistaDisipador.setEnabled(true);
            vistaDisipador.setVisible(true);
        });
    }

    /**
     * Método para retroceder a la vista de armado de placas
     */
    public void atras() {
        ArmadoVentiladores_JB vista = new ArmadoVentiladores_JB();
        ArmadoVentiladorJB controlador = new ArmadoVentiladorJB(vista);
        controlador.Inicio();
        vistaDisipador.setVisible(false);
        vistaDisipador.dispose();
    }
}

