package Controlador;

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
 *
 * @author TheBigG
 */
public class ArmadoProcJB {

    private ArmadoProc_JB vista;
    private Procesador procesador;

    public ArmadoProcJB(ArmadoProc_JB vista) {

        this.vista = vista;
        vista.setVisible(true);

    }

    public void Inicio() {
        vista.setLocationRelativeTo(null);
        CargarComponentes();
        vista.getBtJdlDetalleAceptar().addActionListener(l -> AceptarDlgDetalle());
        vista.getBtJdlAceptar().addActionListener(l -> AceptarDlg());
        vista.getBtJdlAtras().addActionListener(l -> AtrasDlgMensaje());
        Ventana();
    }

    private void CargarComponentes() {
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
                    detalles.setAlignmentX(Component.LEFT_ALIGNMENT);
                    detalles.setFont(new java.awt.Font("Montserrat", 0, 14));
                    detalles.setForeground(Color.BLUE);
                    panelComponentes.add(detalles);
                    //margen
                    JLabel label = new JLabel(" ");
                    label.setAlignmentX(Component.CENTER_ALIGNMENT);
                    label.setFont(new java.awt.Font("Montserrat", 0, 10));
                    panelComponentes.add(label);

                    imageLabel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            vista.setEnabled(false);
                            vista.getJdlgMensaje().setSize(509, 357);
                            vista.getJdlgMensaje().setLocationRelativeTo(null);
                            vista.getJdlgMensaje().setUndecorated(true);
                            vista.getJdlgMensaje().setVisible(true);

                            procesador = new Procesador(p.getIdProcesador(), p.getMarca(), p.getModelo(), p.getNucleosFisicos(), p.getGhz(),
                                    p.getSocket(), p.getMaximoVram(), p.getWatts(), p.getPrecio(), p.getImagen(), p.getStock(), p.getIdProveedor());
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
                        // Crear un objeto DecimalFormat para formatear el precio con dos decimales
                        DecimalFormat formatoPrecio = new DecimalFormat("#.##");

                        // Formatear el precio con dos decimales y establecerlo en tu etiqueta (Label)
                        vista.getLblPrecio().setText(formatoPrecio.format(p.getPrecio()));
                        //vista.getLblPrecio().setText(String.valueOf(p.getPrecio()));
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
    }

    public void Ventana() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(vista.getJpComponentes());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {

        }
    }

    public void AceptarDlgDetalle() {
        vista.getJdlgDetalles().setVisible(false);
        vista.getJdlgDetalles().dispose();
        vista.setEnabled(true);
        vista.setVisible(true);
    }

    public void AceptarDlg() {
        vista.getJdlgMensaje().setVisible(false);
        vista.getJdlgMensaje().dispose();
        vista.setEnabled(true);
        ArmadoPlaca_JB vistaPlaca = new ArmadoPlaca_JB();
        ArmadoPlacaJB controlador = new ArmadoPlacaJB(vistaPlaca);
        controlador.Inicio();
        vista.setVisible(false);
        vista.dispose();

    }

    public void AtrasDlgMensaje() {
        vista.getJdlgMensaje().setVisible(false);
        vista.getJdlgMensaje().dispose();
        vista.setEnabled(true);
        vista.setVisible(true);
    }
}
