package Controlador;

import Clases.PC;
import Modelo.ModeloProcesador;
import Clases.Procesador;
import Vista.ArmadoPlaca_JB;
import Vista.ArmadoProc_JB;
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
 * Controlador para la vista de armado de procesadores. Esta clase se encarga de
 * cargar los procesadores disponibles y manejar las interacciones del usuario.
 *
 * @author TheBigG
 */
public class ArmadoProcJB {

    private ArmadoProc_JB vista; // Referencia a la vista de armado de procesadores
    public static PC pc = new PC(); // Variable estática para almacenar el procesador seleccionado

    /**
     * Constructor de la clase ArmadoProcJB.
     *
     * @param vista Referencia a la vista de armado de procesadores
     */
    public ArmadoProcJB(ArmadoProc_JB vista) {
        this.vista = vista; // Asigna la vista recibida como parámetro
        vista.setVisible(true); // Hace visible la vista
    }

    /**
     * Método que inicia la configuración de la vista y carga los componentes.
     */
    public void Inicio() {
        vista.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        CargarComponentes(); // Carga los procesadores disponibles en la vista
        // Agrega listeners a los botones de la vista para manejar acciones del usuario
        vista.getBtJdlDetalleAceptar().addActionListener(l -> AceptarDlgDetalle());
        vista.getBtJdlAceptar().addActionListener(l -> AceptarDlg());
        vista.getBtJdlAtras().addActionListener(l -> AtrasDlgMensaje());
        Ventana(); // Configura la apariencia de la ventana
    }

    /**
     * Método para cargar los procesadores disponibles en la vista.
     */
    private void CargarComponentes() {
        // Obtiene la lista de procesadores disponibles desde el modelo
        List<Procesador> procesadores = ModeloProcesador.cargaProcesadores();

        // Asegura que la creación y manipulación de componentes Swing se realice en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            // Configura el panel principal con un GridBagLayout
            vista.getJpComponentes().setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weighty = 1.0;
            gbc.insets = new Insets(10, 10, 10, 10); // Espacio uniforme entre filas y columnas
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.ipadx = 10; // Separación horizontal entre componentes

            // Panel para contener los componentes
            JPanel contentPanel = new JPanel();
            contentPanel.setLayout(new GridBagLayout());
            contentPanel.setBackground(Color.white);

            GridBagConstraints contentGbc = new GridBagConstraints();
            contentGbc.gridx = 0;
            contentGbc.gridy = 0;
            contentGbc.weightx = 1.0;
            contentGbc.weighty = 1.0;
            contentGbc.fill = GridBagConstraints.BOTH; // Relleno en ambas direcciones

            // Itera sobre la lista de procesadores para mostrar cada uno en la vista
            for (Procesador p : procesadores) {
                // Verifica si la imagen del procesador no es nula
                if (p.getImagen() != null) {
                    // Escala la imagen del procesador para mostrarla en un tamaño específico
                    ImageIcon imageIcon = new ImageIcon(p.getImagen());
                    Image image = imageIcon.getImage();
                    Image scaledImage = image.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(scaledImage);

                    // Panel para mostrar los detalles del procesador
                    JPanel panelComponentes = new JPanel();
                    panelComponentes.setLayout(new BoxLayout(panelComponentes, BoxLayout.Y_AXIS));
                    panelComponentes.setBackground(Color.WHITE); // Fondo blanco
                    panelComponentes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 212, 250), 3));

                    // Margen
                    JLabel label1 = new JLabel(" ");
                    label1.setAlignmentX(Component.CENTER_ALIGNMENT);
                    label1.setFont(new java.awt.Font("Montserrat", 0, 10));
                    panelComponentes.add(label1);

                    // Etiqueta para mostrar la imagen del procesador
                    JLabel imageLabel = new JLabel();
                    imageLabel.setIcon(scaledIcon);
                    imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    imageLabel.setOpaque(false); // Fondo del JLabel transparente
                    panelComponentes.add(imageLabel);

                    // Etiqueta para mostrar la marca y modelo del procesador
                    JLabel nameLabel = new JLabel(p.getMarca() + " " + p.getModelo());
                    nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    nameLabel.setFont(new java.awt.Font("Montserrat", 0, 18));
                    panelComponentes.add(nameLabel);

                    // Botón para ver detalles del procesador
                    JButton detalles = new JButton("Detalles");
                    detalles.setAlignmentX(Component.LEFT_ALIGNMENT);
                    detalles.setFont(new java.awt.Font("Montserrat", 0, 14));
                    detalles.setForeground(Color.BLUE);
                    panelComponentes.add(detalles);

                    // Margen
                    JLabel label = new JLabel(" ");
                    label.setAlignmentX(Component.CENTER_ALIGNMENT);
                    label.setFont(new java.awt.Font("Montserrat", 0, 10));
                    panelComponentes.add(label);

                    // Listener para el evento de clic en la imagen del procesador
                    imageLabel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            vista.setEnabled(false);
                            vista.getJdlgMensaje().setSize(509, 357);
                            vista.getJdlgMensaje().setLocationRelativeTo(null);
                            vista.getJdlgMensaje().setUndecorated(true);
                            vista.getJdlgMensaje().setVisible(true);
                            pc.setIdProcesador(p.getIdProcesador());
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

                    // Listener para el evento de clic en el botón "Detalles"
                    detalles.addActionListener((ActionEvent e) -> {
                        vista.setEnabled(false);
                        vista.getJdlgDetalles().setSize(672, 444);
                        vista.getJdlgDetalles().setLocationRelativeTo(null);
                        vista.getJdlgDetalles().setUndecorated(true);
                        vista.getJdlgDetalles().setVisible(true);
                        // Carga los detalles del procesador en la vista de detalles
                        vista.getLblMarca().setText(p.getMarca());
                        vista.getLblModelo().setText(p.getModelo());
                        vista.getLblNucleos().setText(String.valueOf(p.getNucleosFisicos()));
                        vista.getLblGHz().setText(String.valueOf(p.getGhz()));
                        vista.getLblSocket().setText(p.getSocket());
                        // Formatea el precio del procesador con dos decimales y lo muestra en la vista de detalles
                        DecimalFormat formatoPrecio = new DecimalFormat("#.##");
                        vista.getLblPrecio().setText(formatoPrecio.format(p.getPrecio()));
                        vista.getJdlgDetalles().setVisible(true);
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
                    contentPanel.add(panelComponentes, contentGbc); // Agrega el panelComponentes al panel principal utilizando las restricciones del GridBagConstraints
                }
            }

            // Establece el tamaño preferido del contentPanel
            contentPanel.setPreferredSize(contentPanel.getPreferredSize());

            // Crea un JScrollPane y elimina el borde de su viewport
            JScrollPane scrollPane = new JScrollPane(contentPanel);
            scrollPane.setBorder(null);
            scrollPane.setBackground(Color.WHITE);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.getVerticalScrollBar().setUnitIncrement(20); // Ajusta la velocidad de desplazamiento

            // Agrega el scrollPane al contenedor principal
            vista.getJpComponentes().setLayout(new BorderLayout());
            vista.getJpComponentes().add(scrollPane, BorderLayout.CENTER);
            vista.revalidate(); // Indica a la vista que vuelva a calcular su tamaño y disposición
            vista.repaint(); // Vuelve a pintar la vista para reflejar los cambios
        });
    }

    /**
     * Método para configurar la apariencia de la ventana.
     */
    public void Ventana() {
        try {
            // Establece el aspecto de la interfaz de usuario con el aspecto del sistema operativo
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(vista.getJpComponentes()); // Actualiza la apariencia de los componentes
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            // Manejo de excepciones
        }
    }

    /**
     * Método para manejar el evento de aceptar los detalles del procesador.
     */
    public void AceptarDlgDetalle() {
        vista.getJdlgDetalles().setVisible(false); // Oculta la ventana de detalles
        vista.getJdlgDetalles().dispose(); // Libera los recursos asociados a la ventana de detalles
        vista.setEnabled(true); // Habilita la vista principal
        vista.setVisible(true); // Hace visible la vista principal
    }

    /**
     * Método para manejar el evento de aceptar la selección del procesador.
     */
    public void AceptarDlg() {
        vista.getJdlgMensaje().setVisible(false); // Oculta la ventana de mensaje
        vista.getJdlgMensaje().dispose(); // Libera los recursos asociados a la ventana de mensaje
        vista.setEnabled(true); // Habilita la vista principal
        ArmadoPlaca_JB vistaPlaca = new ArmadoPlaca_JB(); // Crea una instancia de la vista de armado de placa
        ArmadoPlacaJB controlador = new ArmadoPlacaJB(vistaPlaca); // Crea un controlador para la vista de armado de placa
        controlador.Inicio(); // Inicia la configuración de la vista de armado de placa
        vista.setVisible(false); // Oculta la vista de armado de procesadores
        vista.dispose(); // Libera los recursos asociados a la vista de armado de procesadores
    }

    /**
     * Método para manejar el evento de retroceder en la selección del
     * procesador.
     */
    public void AtrasDlgMensaje() {
        vista.getJdlgMensaje().setVisible(false); // Oculta la ventana de mensaje
        vista.getJdlgMensaje().dispose(); // Libera los recursos asociados a la ventana de mensaje
        vista.setEnabled(true); // Habilita la vista principal
        vista.setVisible(true); // Hace visible la vista principal
    }
}
