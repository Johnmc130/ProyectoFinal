package Controlador;

import Clases.Gabinete;
import Modelo.ModeloGabinete;
import Modelo.ModeloPcResumen;
import Vista.ArmadoAlmacenamiento_JB;
import Vista.ArmadoFuenteP_JB;
import Vista.ArmadoGabinete_JB;
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
public class ArmadoGabineteJB {

    private ArmadoGabinete_JB vistaGab; // Referencia a la vista de armado de memoria RAM ******

    /**
     * Constructor de la clase que recibe la vista de armado de memoria RAM
     *
     * @param vista La vista de armado de memoria RAM
     */
    public ArmadoGabineteJB(ArmadoGabinete_JB vista) {
        this.vistaGab = vista;
        vista.setVisible(true); // Hace visible la vista al crear el controlador
    }

    /**
     * Método para inicializar la vista y cargar los componentes necesarios
     */
    public void Inicio() {
        vistaGab.setLocationRelativeTo(null); // Centra la vista en la pantalla
        CargarComponentes(); // Carga los componentes de las memorias RAM en la vista

        // Agrega listeners a los botones de la vista
        vistaGab.getBtJdlDetalleAceptar().addActionListener(l -> aceptarDlgDetalle());
        vistaGab.getBtJdlAceptar().addActionListener(l -> aceptarDlg()); //************
        vistaGab.getBtJdlAtras().addActionListener(l -> AtrasDlgMensaje());
        vistaGab.getBtAtras().addActionListener(l -> atras()); //************* 
        Ventana(); // Configura la apariencia de la ventana
    }

    /**
     * Método para cargar los componentes de las memorias RAM en la vista
     */
    private void CargarComponentes() {
        List<Gabinete> gabine = ModeloGabinete.listaGabineteCompatible(ModeloPcResumen.cargarPlacaMadre(ArmadoProcJB.pc.getIdPlacaMadre()).getFormato()); // Obtiene la lista de memorias RAM del modelo CAMBIAR A FUENTE ***********

        // Asegura que la carga y manipulación de los componentes Swing se realice en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            // Configura el panel principal con un GridBagLayout
            vistaGab.getJpComponentes().setLayout(new GridBagLayout());
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
            for (Gabinete g : gabine) {
                // Verifica si la imagen no es nula
                if (g.getFoto() == null) {
                    System.out.println("foto");
                }
                if (g.getFoto() != null) {
                    System.out.println(g.toString());
                    // Crea y configura los componentes para mostrar la memoria RAM
                    ImageIcon imageIcon = new ImageIcon(g.getFoto());
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
                    JLabel nameLabel = new JLabel(g.getMarca() + " " + g.getModelo());
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
                            vistaGab.setEnabled(false);
                            vistaGab.getJdlgMensaje().setSize(574, 357);
                            vistaGab.getJdlgMensaje().setLocationRelativeTo(null);
                            vistaGab.getJdlgMensaje().setUndecorated(true);
                            vistaGab.getJdlgMensaje().setVisible(true);
                            ArmadoProcJB.pc.setIdGabinete(g.getIdgabinete()); // ***********
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
                        vistaGab.setEnabled(false);
                        vistaGab.getJdlgDetalles().setSize(731, 502);
                        vistaGab.getJdlgDetalles().setLocationRelativeTo(null);
                        vistaGab.getJdlgDetalles().setUndecorated(true);
                        vistaGab.getJdlgDetalles().setVisible(true);
                        // Carga los detalles de la memoria RAM en la vista
                        vistaGab.getLblMarca().setText(g.getMarca());
                        vistaGab.getLblModelo().setText(g.getModelo());
                        vistaGab.getLblPuertUSB().setText(g.getPuertousb());
                        vistaGab.getLblNumVentil().setText(g.getVentiladores());
                        vistaGab.getLblFormato().setText(g.getFuentepoder());
                        vistaGab.getLblBahias().setText(g.getBahias());
                        vistaGab.getLblStock().setText(String.valueOf(g.getStock()));
                        // Formatea el precio y lo muestra en la vista
                        DecimalFormat formatoPrecio = new DecimalFormat("#.##");
                        vistaGab.getLblPrecio().setText(formatoPrecio.format(g.getPrecio()));
                        vistaGab.getJdlgDetalles().setVisible(true);
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
            vistaGab.getJpComponentes().setLayout(new BorderLayout());
            vistaGab.getJpComponentes().add(scrollPane, BorderLayout.CENTER);

            // Repinta la ventana para mostrar los cambios
            vistaGab.revalidate();
            vistaGab.repaint();
        });
    }

    /**
     * Método para configurar la apariencia de la ventana
     */
    public void Ventana() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Establece el aspecto del sistema operativo
            SwingUtilities.updateComponentTreeUI(vistaGab.getJpComponentes()); // Actualiza la apariencia de los componentes
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            // Maneja las excepciones de configuración de la apariencia
        }
    }

    /**
     * Método para aceptar la ventana de detalles y volver a la vista principal
     */
    public void aceptarDlgDetalle() {
        vistaGab.getJdlgDetalles().setVisible(false);
        vistaGab.getJdlgDetalles().dispose();
        vistaGab.setEnabled(true);
        vistaGab.setVisible(true);
    }

    /**
     * Método para aceptar la selección de una memoria RAM y pasar a la vista de armado de fuente de poder
     */
    public void aceptarDlg() {
        vistaGab.getJdlgMensaje().setVisible(false);
        vistaGab.getJdlgMensaje().dispose();
        vistaGab.setEnabled(true);
        ArmadoFuenteP_JB vista = new ArmadoFuenteP_JB();
        ArmadoFuentePJB controlador = new ArmadoFuentePJB(vista);
        controlador.Inicio();
        vistaGab.setVisible(false);
        vistaGab.dispose();
    }

    /**
     * Método para retroceder desde la ventana de mensaje a la vista principal
     */
    public void AtrasDlgMensaje() {
        SwingUtilities.invokeLater(() -> {
            vistaGab.getJdlgMensaje().setVisible(false);
            vistaGab.getJdlgMensaje().dispose();
            vistaGab.setEnabled(true);
            vistaGab.setVisible(true);
        });
    }

    /**
     * Método para retroceder a la vista de armado de placas
     */
    public void atras() {
        ArmadoAlmacenamiento_JB vista = new ArmadoAlmacenamiento_JB();
        ArmadoAlmacenamientoJB controlador = new ArmadoAlmacenamientoJB(vista);
        controlador.Inicio();
        vistaGab.setVisible(false);
        vistaGab.dispose();
    }
}
