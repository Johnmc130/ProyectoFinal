package Controlador;

import Clases.memoriaRam;
import Modelo.ModeloMemoriaRam;
import Vista.ArmadoFuenteP_JB;
import Vista.ArmadoPlaca_JB;
import Vista.ArmadoRam_JB;
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
public class ArmadoRamJB {

    private ArmadoRam_JB vistaRam;

    public ArmadoRamJB(ArmadoRam_JB vista) {
        this.vistaRam = vista;
        vista.setVisible(true);
    }

    public void Inicio() {
        vistaRam.setLocationRelativeTo(null);
        CargarComponentes();

        vistaRam.getBtJdlDetalleAceptar().addActionListener(l -> aceptarDlgDetalle());
        vistaRam.getBtJdlAceptar().addActionListener(l -> aceptarDlg());
        vistaRam.getBtJdlAtras().addActionListener(l -> AtrasDlgMensaje());
        vistaRam.getBtAtras().addActionListener(l -> atras());
        Ventana();
    }

    private void CargarComponentes() {
        List<memoriaRam> rams = ModeloMemoriaRam.listaTodasmemoriaRam();

        // Asegurarse de que la creación y manipulación de los componentes Swing se realice en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {

            // Configurar el panel principal con un GridBagLayout
            vistaRam.getJpComponentes().setLayout(new GridBagLayout());
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
            System.out.println("************************************************************");
            for (memoriaRam ram : rams) {
                // Verificar si la imagen no es nula
                if (ram.getFoto() == null){
                    System.out.println("foto");
            } 
                if (ram.getFoto() != null) {
                    System.out.println("aaaaaaaaaaa");
                    System.out.println(ram.toString());
                    ImageIcon imageIcon = new ImageIcon(ram.getFoto());
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

                    JLabel nameLabel = new JLabel(ram.getMarca() + " " + ram.getModelo());
                    nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    nameLabel.setFont(new java.awt.Font("Montserrat", 0, 18));
                    panelComponentes.add(nameLabel);

                    JButton detalles = new JButton("Detalles");
                    detalles.setAlignmentX(Component.LEFT_ALIGNMENT);
                    detalles.setFont(new java.awt.Font("Montserrat", 0, 14));
                    detalles.setForeground(Color.BLUE);
                    panelComponentes.add(detalles);
                    //margen
                    JLabel label = new JLabel(" ");
                    label.setAlignmentX(Component.CENTER_ALIGNMENT);
                    label.setFont(new java.awt.Font("Montserrat", 0, 10));
                    panelComponentes.add(label);
                    //Siguente Componente
                    imageLabel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            vistaRam.setEnabled(false);
                            vistaRam.getJdlgMensaje().setSize(574, 357);
                            vistaRam.getJdlgMensaje().setLocationRelativeTo(null);
                            vistaRam.getJdlgMensaje().setUndecorated(true);
                            vistaRam.getJdlgMensaje().setVisible(true);
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

                    detalles.addActionListener((ActionEvent e) -> {
                        vistaRam.setEnabled(false);
                        vistaRam.getJdlgDetalles().setSize(731, 502);
                        vistaRam.getJdlgDetalles().setLocationRelativeTo(null);
                        vistaRam.getJdlgDetalles().setUndecorated(true);
                        vistaRam.getJdlgDetalles().setVisible(true);
                        // Cargar campos en vistaRam
                        vistaRam.getLblMarca().setText(ram.getMarca());
                        vistaRam.getLblModelo().setText(ram.getModelo());
                        vistaRam.getLblCapacidad().setText(String.valueOf(ram.getCapacidad()));
                        vistaRam.getLblTipo().setText(ram.getTipo());
                        vistaRam.getLblStock().setText(String.valueOf(ram.getStock()));
                        // Crear un objeto DecimalFormat para formatear el precio con dos decimales
                        DecimalFormat formatoPrecio = new DecimalFormat("#.##");
                        // Formatear el precio con dos decimales y establecerlo en tu etiqueta (Label)
                        vistaRam.getLblPrecio().setText(formatoPrecio.format(ram.getPrecio()));
                        vistaRam.getJdlgDetalles().setVisible(true);

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
            vistaRam.getJpComponentes().setLayout(new BorderLayout());
            vistaRam.getJpComponentes().add(scrollPane, BorderLayout.CENTER);
            System.out.println("aqui final metodo cargar compo");
            // que la ventana se repinte
            vistaRam.revalidate();
            vistaRam.repaint();
        });
        
    }

    public void Ventana() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(vistaRam.getJpComponentes());
            System.out.println("aqui swing");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {

        }
    }

    public void aceptarDlgDetalle() {
        vistaRam.getJdlgDetalles().setVisible(false);
        vistaRam.getJdlgDetalles().dispose();
        vistaRam.setEnabled(true);
        vistaRam.setVisible(true);
    }

    public void aceptarDlg() {
        vistaRam.getJdlgMensaje().setVisible(false);
        vistaRam.getJdlgMensaje().dispose();
        vistaRam.setEnabled(true);
        ArmadoFuenteP_JB vista = new ArmadoFuenteP_JB();
//        ArmadoTarjetaVJB controlador = new ArmadoTarjetaVJB(vista);
//        controlador.Inicio();
        vistaRam.setVisible(false);
        vistaRam.dispose();
    }

    public void AtrasDlgMensaje() {
        SwingUtilities.invokeLater(() -> {
            vistaRam.getJdlgMensaje().setVisible(false);
            vistaRam.getJdlgMensaje().dispose();
            vistaRam.setEnabled(true);
            vistaRam.setVisible(true);
        });
    }

    public void atras() {
        ArmadoPlaca_JB vista = new ArmadoPlaca_JB();
        ArmadoPlacaJB controlador = new ArmadoPlacaJB(vista);
        controlador.Inicio();
        vistaRam.setVisible(false);
        vistaRam.dispose();
    }
}
