/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Procesador;
import Modelo.ModeloProcesador;
import Vista.ArmadoPlaca_JB;
import Vista.VentanaCesta;
import Vista.VentanaPrincipal;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Steven Zhicxay
 */
public class ControladorVentanaPrin {

    private VentanaPrincipal vista;
    private Procesador procesador;
    private VentanaCesta cesta;

    public ControladorVentanaPrin(VentanaPrincipal vista) {

        this.vista = vista;
        vista.setVisible(true);

    }

    public void Inicio() {
        vista.setLocationRelativeTo(null);
        CargarComponentes();
        Ventana();

        System.out.println("aqui");
    }

    public void iniciarControl() {
        vista.getBtnCesta().addActionListener(l -> botonCesta());
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
            gbc.weightx = 1.0;
            gbc.insets = new Insets(10, 10, 10, 10); // Espacio uniforme entre filas y columnas
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.ipady = 10; // Separación vertical entre componentes

            JPanel contentPanel = new JPanel();
            contentPanel.setLayout(new GridBagLayout());
            contentPanel.setBackground(Color.white);

            GridBagConstraints contentGbc = new GridBagConstraints();
            contentGbc.gridx = 0;
            contentGbc.gridy = 0;
            contentGbc.weighty = 1.0;
            contentGbc.fill = GridBagConstraints.BOTH; // Relleno en ambas direcciones

            for (Procesador p : procesadores) {
                // Verificar si la imagen no es nula
                if (p.getImagen() != null) {
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
                        // Mostrar un JOptionPane en lugar del JDialog
                        int option = JOptionPane.showOptionDialog(vista, getDetallesMessage(p), "Detalles", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

                        // Si necesitas realizar acciones adicionales después de cerrar el JOptionPane, puedes hacerlo aquí
                        if (option == JOptionPane.OK_OPTION) {
                            // Acciones adicionales después de hacer clic en OK
                        }
                    });

                    // Verificar si se alcanzó el límite de 3 imágenes por fila antes de incrementar la posición en la columna
                    if (contentGbc.gridy == 3) {
                        contentGbc.gridy = 0; // Reiniciar la posición en la fila
                        contentGbc.gridx++; // Incrementar el valor de x para la nueva columna

                        // Agregar espacio horizontal entre columnas
                        contentGbc.insets = new Insets(10, 10, 10, 40);
                    } else {
                        // Restablecer los márgenes para las demás columnas
                        contentGbc.insets = new Insets(10, 10, 10, 40); // Espacio uniforme entre las columnas
                    }

                    // Incrementar la posición en la fila para la próxima iteración
                    contentGbc.gridy++;

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
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane.getHorizontalScrollBar().setUnitIncrement(20);

            // Agregar el panel principal al contenedor principal (pnlLabels)
            vista.getJpComponentes().setLayout(new BorderLayout());
            vista.getJpComponentes().add(scrollPane, BorderLayout.CENTER);
        });
    }

    public void Ventana() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(vista.getJpComponentes());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {

        }
    }

    public void botonCesta() {
        VentanaCesta v = new VentanaCesta();
        v.setVisible(true);
        VentanaPrincipal p = new VentanaPrincipal();
        v.setVisible(false);
    }

    public void botonUsuario() {

    }

    public void botonArmadoPC() {

    }

    // Método para obtener el mensaje de detalles
    private Object getDetallesMessage(Procesador p) {
        // Puedes personalizar este método según tus necesidades para mostrar la información de detalles
        String message = "Marca: " + p.getMarca() + "\nModelo: " + p.getModelo() + "\nNúcleos: " + p.getNucleosFisicos() + "\nGHz: " + p.getGhz() + "\nSocket: " + p.getSocket();
        return message;
    }
}
