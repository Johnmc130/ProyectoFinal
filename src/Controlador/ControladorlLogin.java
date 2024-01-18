package Controlador;

import Modelo.ModeloCliente;
import Modelo.ModeloPersona;
import Vista.VentanaLogin_JM;
import Vista.VentanaRegistro_JM;
import Vista.VentanaUsuario_JM;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class ControladorlLogin {

    private ModeloCliente modeloc;
    private VentanaLogin_JM vista;

    public ControladorlLogin(ModeloCliente modeloc, VentanaLogin_JM vista) {
        this.modeloc = modeloc;
        this.vista = vista;
        vista.setVisible(true);
    }

    public void iniciaControlador() {
        limpiaCampos();
        vista.getBtnRegistra().addActionListener(l -> botonRegistra());
        vista.getBtnInicia().addActionListener(l -> iniciaSesion());
    }

    private void iniciaSesion() {
        String cedula = vista.getTxtCedula().getText();
        String contra = String.valueOf(vista.getTxtContra().getPassword());

        if (modeloc.loginCliente(cedula, contra)) {
            JOptionPane.showMessageDialog(null, "¡Sesion Iniciada con Exito!");
            VentanaUsuario_JM ventana = new VentanaUsuario_JM();
            ModeloPersona mPersona = new ModeloPersona();
            ConroladorCliente cCliente = new ConroladorCliente(ventana, modeloc, mPersona, cedula);
            cCliente.iniciaControlador();
            ventana.setVisible(true);
            vista.dispose();

        } else {
            JOptionPane.showMessageDialog(null, "¡La Cedula o Contraseña son Incorrectas!");
        }

    }

    private void limpiaCampos() {
        String cedula = vista.getTxtCedula().getText();
        String contra = String.valueOf(vista.getTxtContra().getPassword());

        if (cedula.equals("Ingrese su Cédula")) {
            vista.getTxtCedula().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Limpiar el JTextField cuando se hace clic
                    vista.getTxtCedula().setText("");
                }
            });
        }
        if (contra.equals("Contraseña123")) {
            vista.getTxtContra().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Limpiar el JTextField cuando se hace clic
                    vista.getTxtContra().setText("");
                }
            });
        }
    }

    private void botonRegistra() {
        VentanaRegistro_JM ventana = new VentanaRegistro_JM();
        ModeloCliente mCliente = new ModeloCliente();
        ModeloPersona mPersona = new ModeloPersona();
        ControladorRegistro cRegistro = new ControladorRegistro(mCliente, mPersona, ventana);
        cRegistro.iniciaControlador();
        ventana.setVisible(true);
        vista.dispose();
    }
}
