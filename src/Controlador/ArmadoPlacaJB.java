package Controlador;

import Clases.Placamadre;
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
public class ArmadoPlacaJB {

    private ArmadoPlaca_JB vistaPlaca;

    public ArmadoPlacaJB(ArmadoPlaca_JB vista) {
        this.vistaPlaca = vista;
        vista.setVisible(true);
    }

    public void Inicio() {
        vistaPlaca.setLocationRelativeTo(null);
        CargarComponentes();

        vistaPlaca.getBtJdlDetalleAceptar().addActionListener(l -> AceptarDlg());
        vistaPlaca.getBtJdlMensajeElejir().addActionListener(l -> ConTarjetaDlg());
        vistaPlaca.getBtJdlSin().addActionListener(l -> SinTarjetaDlg());
        vistaPlaca.getBtJdlMAtras().addActionListener(l -> AtrasDlgMensaje());
        vistaPlaca.getBtAtras().addActionListener(l->atras());
        Ventana();
    }

    private void CargarComponentes() {
        List<Placamadre> placasLista = ModeloPlacaMadre.cargaPlacasMadre();

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

            JPanel contentPanel = new JPanel();
            contentPanel.setLayout(new GridBagLayout());
            contentPanel.setBackground(Color.white);

            GridBagConstraints contentGbc = new GridBagConstraints();
            contentGbc.gridx = 0;
            contentGbc.gridy = 0;
            contentGbc.weightx = 1.0;
            contentGbc.weighty = 1.0;
            contentGbc.fill = GridBagConstraints.BOTH; // Relleno en ambas direcciones

            for (Placamadre p : placasLista) {
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
                            vistaPlaca.setEnabled(false);
                            vistaPlaca.getJdlgMensaje().setSize(613, 377);
                            vistaPlaca.getJdlgMensaje().setLocationRelativeTo(null);
                            vistaPlaca.getJdlgMensaje().setUndecorated(true);
                            vistaPlaca.getJdlgMensaje().setVisible(true);
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
                        vistaPlaca.setEnabled(false);
                        vistaPlaca.getJdlgDetalles().setSize(731, 520);
                        vistaPlaca.getJdlgDetalles().setLocationRelativeTo(null);
                        vistaPlaca.getJdlgDetalles().setUndecorated(true);
                        vistaPlaca.getJdlgDetalles().setVisible(true);
                        //cargar campos

                        vistaPlaca.getLblMarca().setText(p.getMarca());
                        vistaPlaca.getLblModelo().setText(p.getModelo());
                        vistaPlaca.getLblFormato().setText(p.getFormato());
                        vistaPlaca.getLblTipoRam().setText(p.getTiposram());
                        vistaPlaca.getLblSocket().setText(p.getSocket());
                        vistaPlaca.getLblRanurasExpa().setText(p.getRanuraexpansion());
                        // Crear un objeto DecimalFormat para formatear el precio con dos decimales
                        DecimalFormat formatoPrecio = new DecimalFormat("#.##");
                        // Formatear el precio con dos decimales y establecerlo en tu etiqueta (Label)
                        vistaPlaca.getLblPrecio().setText(formatoPrecio.format(p.getPrecio()));
                        vistaPlaca.getLblStock().setText(String.valueOf(p.getStock()));
                        vistaPlaca.getJdlgDetalles().setVisible(true);
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

    public void Ventana() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(vistaPlaca.getJpComponentes());
            System.out.println("aqui swing");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {

        }
    }

    public void AceptarDlg() {
        vistaPlaca.getJdlgDetalles().setVisible(false);
        vistaPlaca.getJdlgDetalles().dispose();
        vistaPlaca.setEnabled(true);
        vistaPlaca.setVisible(true);
    }

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

    public void AtrasDlgMensaje() {
        SwingUtilities.invokeLater(() -> {
            vistaPlaca.getJdlgMensaje().setVisible(false);
            vistaPlaca.getJdlgMensaje().dispose();
            vistaPlaca.setEnabled(true);
            vistaPlaca.setVisible(true);
        });
    }
    
    public void atras() {
        ArmadoProc_JB vista = new ArmadoProc_JB();
        ArmadoProcJB controlador = new ArmadoProcJB(vista);
        controlador.Inicio();
        vistaPlaca.setVisible(false);
        vistaPlaca.dispose();
    }
}
