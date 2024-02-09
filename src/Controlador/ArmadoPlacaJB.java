// Importaciones de clases necesarias
package Controlador;

import Clases.Placamadre;
import Modelo.ModeloPcResumen;
import Modelo.ModeloPlacaMadre;
import Vista.ArmadoPlaca_JB;
import Vista.ArmadoProc_JB;
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
import java.text.DecimalFormat; // Importación para formatear números decimales
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
 * Controlador para la vista de armado de placas base
 */
public class ArmadoPlacaJB {

    private ArmadoPlaca_JB vistaPlaca; // Instancia de la vista correspondiente

    // Constructor que recibe la vista como parámetro
    public ArmadoPlacaJB(ArmadoPlaca_JB vista) {
        this.vistaPlaca = vista;
        vista.setVisible(true); // Hacer visible la vista
    }

    // Método para inicializar la vista y cargar sus componentes
    public void Inicio() {
        vistaPlaca.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        CargarComponentes(); // Cargar los componentes de la vista

        // Asignar acciones a los botones de la vista
        vistaPlaca.getBtJdlDetalleAceptar().addActionListener(l -> AceptarDlg());
        vistaPlaca.getBtJdlMensajeElejir().addActionListener(l -> ConTarjetaDlg());
        //vistaPlaca.getBtJdlSin().addActionListener(l -> SinTarjetaDlg());
        vistaPlaca.getBtJdlMAtras().addActionListener(l -> AtrasDlgMensaje());
        vistaPlaca.getBtAtras().addActionListener(l->atras());
        Ventana(); // Configurar la apariencia de la ventana
    }

    // Método para cargar los componentes en la vista
    private void CargarComponentes() {
        List<Placamadre> placasLista = ModeloPlacaMadre.listaPlacaMadreCompartible(ModeloPcResumen.cargarProcesador(ArmadoProcJB.pc.getIdProcesador()).getSocket()); // Obtener la lista de placas base desde el modelo

        // Asegurarse de que la creación y manipulación de los componentes Swing se realice en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {

            // Configurar el panel principal con un GridBagLayout
            vistaPlaca.getJpComponentes().setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weighty = 1.0;
            gbc.insets = new Insets(10, 10, 10, 10); // Espacio uniforme entre filas y columnas
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.ipadx = 10; // Separación horizontal entre componentes

            JPanel contentPanel = new JPanel(); // Panel para contener los componentes
            contentPanel.setLayout(new GridBagLayout());
            contentPanel.setBackground(Color.white);

            GridBagConstraints contentGbc = new GridBagConstraints();
            contentGbc.gridx = 0;
            contentGbc.gridy = 0;
            contentGbc.weightx = 1.0;
            contentGbc.weighty = 1.0;
            contentGbc.fill = GridBagConstraints.BOTH; // Relleno en ambas direcciones

            // Iterar sobre cada placa base en la lista
            for (Placamadre p : placasLista) {
                // Verificar si la imagen no es nula
                if (p.getFoto() != null) {
                    // Escalar la imagen para que se ajuste al tamaño deseado
                    ImageIcon imageIcon = new ImageIcon(p.getFoto());
                    Image image = imageIcon.getImage();
                    Image scaledImage = image.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(scaledImage);

                    // Crear un panel para contener los componentes de la placa base
                    JPanel panelComponentes = new JPanel();
                    panelComponentes.setLayout(new BoxLayout(panelComponentes, BoxLayout.Y_AXIS));
                    panelComponentes.setBackground(Color.WHITE); // Fondo blanco
                    panelComponentes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 212, 250), 3));

                    // Añadir una etiqueta para el margen superior
                    JLabel label1 = new JLabel(" ");
                    label1.setAlignmentX(Component.CENTER_ALIGNMENT);
                    label1.setFont(new java.awt.Font("Montserrat", 0, 10));
                    panelComponentes.add(label1);

                    // Añadir la imagen de la placa base
                    JLabel imageLabel = new JLabel();
                    imageLabel.setIcon(scaledIcon);
                    imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    imageLabel.setOpaque(false); // Hacer el fondo del JLabel transparente
                    panelComponentes.add(imageLabel);

                    // Añadir una etiqueta para la marca y modelo de la placa base
                    JLabel nameLabel = new JLabel(p.getMarca() + " " + p.getModelo());
                    nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    nameLabel.setFont(new java.awt.Font("Montserrat", 0, 18));
                    panelComponentes.add(nameLabel);

                    // Añadir un botón para ver los detalles de la placa base
                    JButton detalles = new JButton("Detalles");
                    detalles.setAlignmentX(Component.LEFT_ALIGNMENT);
                    detalles.setFont(new java.awt.Font("Montserrat", 0, 14));
                    detalles.setForeground(Color.BLUE);
                    panelComponentes.add(detalles);

                    // Añadir una etiqueta para el margen inferior
                    JLabel label = new JLabel(" ");
                    label.setAlignmentX(Component.CENTER_ALIGNMENT);
                    label.setFont(new java.awt.Font("Montserrat", 0, 10));
                    panelComponentes.add(label);

                    // Acción cuando se hace clic en la imagen de la placa base
                    imageLabel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            vistaPlaca.setEnabled(false); // Deshabilitar la vista principal
                            vistaPlaca.getJdlgMensaje().setSize(613, 377); // Establecer el tamaño del diálogo de mensaje
                            vistaPlaca.getJdlgMensaje().setLocationRelativeTo(null); // Centrar el diálogo de mensaje en la pantalla
                            vistaPlaca.getJdlgMensaje().setUndecorated(true); // Eliminar la decoración del diálogo de mensaje
                            vistaPlaca.getJdlgMensaje().setVisible(true); // Mostrar el diálogo de mensaje
                            ArmadoProcJB.pc.setIdPlacaMadre(p.getIdplacam()); // Asignar el ID de la placa base seleccionada a la variable estática
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
                            imageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al puntero cuando se pasa sobre la imagen
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            imageLabel.setCursor(Cursor.getDefaultCursor()); // Restaurar el cursor predeterminado cuando se sale de la imagen
                        }
                    });

                    // Acción cuando se hace clic en el botón "Detalles"
                    detalles.addActionListener((ActionEvent e) -> {
                        vistaPlaca.setEnabled(false); // Deshabilitar la vista principal
                        vistaPlaca.getJdlgDetalles().setSize(731, 520); // Establecer el tamaño del diálogo de detalles
                        vistaPlaca.getJdlgDetalles().setLocationRelativeTo(null); // Centrar el diálogo de detalles en la pantalla
                        vistaPlaca.getJdlgDetalles().setUndecorated(true); // Eliminar la decoración del diálogo de detalles
                        vistaPlaca.getJdlgDetalles().setVisible(true); // Mostrar el diálogo de detalles
                        
                        // Cargar los detalles de la placa base en la vista correspondiente
                        vistaPlaca.getLblMarca().setText(p.getMarca());
                        vistaPlaca.getLblModelo().setText(p.getModelo());
                        vistaPlaca.getLblFormato().setText(p.getFormato());
                        vistaPlaca.getLblTipoRam().setText(p.getTiposram());
                        vistaPlaca.getLblSocket().setText(p.getSocket());
                        vistaPlaca.getLblRanurasExpa().setText(p.getRanuraexpansion());
                        
                        // Crear un objeto DecimalFormat para formatear el precio con dos decimales
                        DecimalFormat formatoPrecio = new DecimalFormat("#.##");
                        // Formatear el precio con dos decimales y establecerlo en la etiqueta correspondiente
                        vistaPlaca.getLblPrecio().setText(formatoPrecio.format(p.getPrecio()));
                        
                        vistaPlaca.getLblStock().setText(String.valueOf(p.getStock())); // Establecer el stock en la etiqueta correspondiente
                        vistaPlaca.getJdlgDetalles().setVisible(true); // Hacer visible el diálogo de detalles
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
            vistaPlaca.getJpComponentes().setLayout(new BorderLayout());
            vistaPlaca.getJpComponentes().add(scrollPane, BorderLayout.CENTER);
            System.out.println("aqui final metodo cargar compo");
            // que la ventana se repinte
            vistaPlaca.revalidate();
            vistaPlaca.repaint();
        });

    }

    // Método para configurar la apariencia de la ventana
    public void Ventana() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(vistaPlaca.getJpComponentes());
            System.out.println("aqui swing");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {

        }
    }

    // Método para cerrar el diálogo de detalles y habilitar la vista principal
    public void AceptarDlg() {
        vistaPlaca.getJdlgDetalles().setVisible(false);
        vistaPlaca.getJdlgDetalles().dispose();
        vistaPlaca.setEnabled(true);
        vistaPlaca.setVisible(true);
    }

    // Método para mostrar la siguiente vista al hacer clic en "Siguiente" sin seleccionar tarjeta de video
    public void SinTarjetaDlg() {
        vistaPlaca.getJdlgMensaje().setVisible(false);
        vistaPlaca.getJdlgMensaje().dispose();
        vistaPlaca.setEnabled(true);
        ArmadoRam_JB vista = new ArmadoRam_JB();
        ArmadoRamJB controlador = new ArmadoRamJB(vista);
        controlador.Inicio();
        vistaPlaca.setVisible(false);
        vistaPlaca.dispose();
    }

    // Método para mostrar la siguiente vista al hacer clic en "Siguiente" seleccionando tarjeta de video
    public void ConTarjetaDlg() {
        vistaPlaca.getJdlgMensaje().setVisible(false);
        vistaPlaca.getJdlgMensaje().dispose();
        vistaPlaca.setEnabled(true);
        ArmadoTarjetaV_JB vista = new ArmadoTarjetaV_JB();
        ArmadoTarjetaVJB controlador = new ArmadoTarjetaVJB(vista);
        controlador.Inicio();
        vistaPlaca.setVisible(false);
        vistaPlaca.dispose();
    }

    // Método para volver a la vista anterior
    public void AtrasDlgMensaje() {
        SwingUtilities.invokeLater(() -> {
            vistaPlaca.getJdlgMensaje().setVisible(false);
            vistaPlaca.getJdlgMensaje().dispose();
            vistaPlaca.setEnabled(true);
            vistaPlaca.setVisible(true);
        });
    }
    
    // Método para regresar a la vista de selección de procesador
    public void atras() {
        ArmadoProc_JB vista = new ArmadoProc_JB();
        ArmadoProcJB controlador = new ArmadoProcJB(vista);
        controlador.Inicio();
        vistaPlaca.setVisible(false);
        vistaPlaca.dispose();
    }
}
