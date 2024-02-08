package Controlador;

import Clases.almacenamiento;
import Modelo.ModeloAlmacenamiento;
import Vista.ArmadoAlmacenamiento_JB;
import Vista.ArmadoFuenteP_JB;
import Vista.ArmadoPlaca_JB;
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
public class ArmadoAlmacenamientoJB {

    private ArmadoAlmacenamiento_JB vistaAlma; // Referencia a la vista de armado de memoria RAM

    /**
     * Constructor de la clase que recibe la vista de armado de memoria RAM
     * @param vista La vista de armado de memoria RAM
     */
    public ArmadoAlmacenamientoJB(ArmadoAlmacenamiento_JB vista) {
        this.vistaAlma = vista;
        vista.setVisible(true); // Hace visible la vista al crear el controlador
    }

    /**
     * Método para inicializar la vista y cargar los componentes necesarios
     */
    public void Inicio() {
        vistaAlma.setLocationRelativeTo(null); // Centra la vista en la pantalla
        CargarComponentes(); // Carga los componentes de las memorias RAM en la vista

        // Agrega listeners a los botones de la vista
        vistaAlma.getBtJdlDetalleAceptar().addActionListener(l -> aceptarDlgDetalle());
        vistaAlma.getBtJdlMensajeElejir().addActionListener(l -> aceptarDlg());
        vistaAlma.getBtJdlMAtras().addActionListener(l -> AtrasDlgMensaje());
        vistaAlma.getBtAtras().addActionListener(l -> atras());
        Ventana(); // Configura la apariencia de la ventana
    }

    /**
     * Método para cargar los componentes de las memorias RAM en la vista
     */
    private void CargarComponentes() {
        List<almacenamiento> gabis = ModeloAlmacenamiento.listaTodasAlmacenamiento(); // Obtiene la lista de memorias RAM del modelo

        // Asegura que la carga y manipulación de los componentes Swing se realice en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            // Configura el panel principal con un GridBagLayout
            vistaAlma.getJpComponentes().setLayout(new GridBagLayout());
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
            for (almacenamiento gab : gabis) {
                // Verifica si la imagen no es nula
                if (gab.getFoto() == null) {
                    System.out.println("foto");
                } 
                if (gab.getFoto() != null) {
                    System.out.println("aaaaaaaaaaa");
                    System.out.println(gab.toString());
                    // Crea y configura los componentes para mostrar la memoria RAM
                    ImageIcon imageIcon = new ImageIcon(gab.getFoto());
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
                    JLabel nameLabel = new JLabel(gab.getMarca() + " " + gab.getModelo());
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
                            vistaAlma.setEnabled(false);
                            vistaAlma.getJdlgMensaje().setSize(574, 357);
                            vistaAlma.getJdlgMensaje().setLocationRelativeTo(null);
                            vistaAlma.getJdlgMensaje().setUndecorated(true);
                            vistaAlma.getJdlgMensaje().setVisible(true);
                            ArmadoProcJB.pc.setIdRam(gab.getIdalmacenamiento());
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
                        vistaAlma.setEnabled(false);
                        vistaAlma.getJdlgDetalles().setSize(731, 502);
                        vistaAlma.getJdlgDetalles().setLocationRelativeTo(null);
                        vistaAlma.getJdlgDetalles().setUndecorated(true);
                        vistaAlma.getJdlgDetalles().setVisible(true);
                        // Carga los detalles de la memoria RAM en la vista
                        vistaAlma.getLblMarca().setText(gab.getMarca());
                        vistaAlma.getLblModelo().setText(gab.getModelo());
                        vistaAlma.getLblCapacidad().setText(String.valueOf(gab.getCapacidad()));
                        vistaAlma.getLblTipo().setText(gab.getTipo());
                        vistaAlma.getLblStock().setText(String.valueOf(gab.getStock()));
                        // Formatea el precio y lo muestra en la vista
                        DecimalFormat formatoPrecio = new DecimalFormat("#.##");
                        vistaAlma.getLblPrecio().setText(formatoPrecio.format(gab.getPrecio()));
                        vistaAlma.getJdlgDetalles().setVisible(true);
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
            vistaAlma.getJpComponentes().setLayout(new BorderLayout());
            vistaAlma.getJpComponentes().add(scrollPane, BorderLayout.CENTER);

            // Repinta la ventana para mostrar los cambios
            vistaAlma.revalidate();
            vistaAlma.repaint();
        });
    }

    /**
     * Método para configurar la apariencia de la ventana
     */
    public void Ventana() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Establece el aspecto del sistema operativo
            SwingUtilities.updateComponentTreeUI(vistaAlma.getJpComponentes()); // Actualiza la apariencia de los componentes
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            // Maneja las excepciones de configuración de la apariencia
        }
    }

    /**
     * Método para aceptar la ventana de detalles y volver a la vista principal
     */
    public void aceptarDlgDetalle() {
        vistaAlma.getJdlgDetalles().setVisible(false);
        vistaAlma.getJdlgDetalles().dispose();
        vistaAlma.setEnabled(true);
        vistaAlma.setVisible(true);
    }

    /**
     * Método para aceptar la selección de una memoria RAM y pasar a la vista de armado de fuente de poder
     */
    public void aceptarDlg() {
        vistaAlma.getJdlgMensaje().setVisible(false);
        vistaAlma.getJdlgMensaje().dispose();
        vistaAlma.setEnabled(true);
        ArmadoFuenteP_JB vista = new ArmadoFuenteP_JB();
        vistaAlma.setVisible(false);
        vistaAlma.dispose();
    }

    /**
     * Método para retroceder desde la ventana de mensaje a la vista principal
     */
    public void AtrasDlgMensaje() {
        SwingUtilities.invokeLater(() -> {
            vistaAlma.getJdlgMensaje().setVisible(false);
            vistaAlma.getJdlgMensaje().dispose();
            vistaAlma.setEnabled(true);
            vistaAlma.setVisible(true);
        });
    }

    /**
     * Método para retroceder a la vista de armado de placas
     */
    public void atras() {
        ArmadoPlaca_JB vista = new ArmadoPlaca_JB();
        ArmadoPlacaJB controlador = new ArmadoPlacaJB(vista);
        controlador.Inicio();
        vistaAlma.setVisible(false);
        vistaAlma.dispose();
    }
}
