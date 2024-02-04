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
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
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
import javax.swing.JSlider;
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
        Inicio();
        vista.setVisible(true);
    }

    public void Inicio() {
        vista.setLocationRelativeTo(null);
        CargarComponentes();
        Ventana();

        System.out.println("aqui");
    }

    public void iniciarControl() {
        Inicio();
        vista.getBtnCesta().addActionListener(l -> botonCesta());
        System.out.println(vista.getBtnCesta().getText());
    }

    private void CargarComponentes() {
        List<Procesador> procesadores = ModeloProcesador.cargaProcesadores();

        SwingUtilities.invokeLater(() -> {
            JPanel contentPanel = new JPanel();
            contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
            contentPanel.setBackground(Color.WHITE);

            for (Procesador p : procesadores) {
                if (p.getImagen() != null) {
                    ImageIcon imageIcon = new ImageIcon(p.getImagen());
                    Image image = imageIcon.getImage();
                    Image scaledImage = image.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(scaledImage);

                    JPanel panelComponentes = new JPanel();
                    panelComponentes.setLayout(new BoxLayout(panelComponentes, BoxLayout.Y_AXIS));
                    panelComponentes.setBackground(Color.WHITE);
                    panelComponentes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 212, 250), 3));

                    JLabel label1 = new JLabel(" ");
                    label1.setAlignmentX(Component.CENTER_ALIGNMENT);
                    label1.setFont(new java.awt.Font("Montserrat", 0, 10));
                    panelComponentes.add(label1);

                    JLabel imageLabel = new JLabel();
                    imageLabel.setIcon(scaledIcon);
                    imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    imageLabel.setOpaque(false);
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

                    JLabel label = new JLabel(" ");
                    label.setAlignmentX(Component.CENTER_ALIGNMENT);
                    label.setFont(new java.awt.Font("Montserrat", 0, 10));
                    panelComponentes.add(label);

                    imageLabel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            // Agrega acciones para el clic en la imagen si es necesario
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
                        int option = JOptionPane.showOptionDialog(vista, getDetallesMessage(p), "Detalles", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                        if (option == JOptionPane.OK_OPTION) {
                            // Acciones adicionales después de hacer clic en OK
                        }
                    });

                    contentPanel.add(panelComponentes);
                }
            }

            JScrollPane scrollPane = new JScrollPane(contentPanel);
            scrollPane.setBorder(null);
            scrollPane.setBackground(Color.WHITE);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

            JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
            slider.addChangeListener(e -> {
                int value = slider.getValue();
                int max = slider.getMaximum();
                int scrollValue = (int) ((contentPanel.getPreferredSize().width - scrollPane.getViewport().getWidth()) * (value / (double) max));
                scrollPane.getViewport().setViewPosition(new Point(scrollValue, 0));
            });

            vista.getJpComponentes().setLayout(new BorderLayout());
            vista.getJpComponentes().add(scrollPane, BorderLayout.CENTER);
            vista.getJpComponentes().add(slider, BorderLayout.SOUTH);
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
        System.out.println("aaaaaaaaaaa");
        VentanaCesta v = new VentanaCesta();
        v.setVisible(true);
        // Cierra la ventana actual 
        vista.dispose();
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
