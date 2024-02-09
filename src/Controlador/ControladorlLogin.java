package Controlador;

import Modelo.ModeloAdministrador;
import Modelo.ModeloCliente;
import Modelo.ModeloPersona;
import Modelo.ModeloProveedor;
import Vista.VentanaLogin_JM;
import Vista.VentanaRegistro_JM;
import Vista.VentanaUsuario_JM;
import Vista.VistaProductos;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class ControladorlLogin {

    public static String id_cedula;
    private ModeloCliente modeloC;
    private ModeloAdministrador modeloA;
    private ModeloProveedor modeloP;
    private VentanaLogin_JM vista;

    public ControladorlLogin(ModeloCliente modeloC, ModeloAdministrador modeloA, ModeloProveedor modeloP, VentanaLogin_JM vista) {
        this.modeloC = modeloC;
        this.modeloA = modeloA;
        this.modeloP = modeloP;
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
        id_cedula = cedula;
        String contra = String.valueOf(vista.getTxtContra().getPassword());

        if (modeloC.loginCliente(cedula, contra)) {
            VistaProductos v = new VistaProductos();
            ControladorVistaProductos contro = new ControladorVistaProductos(v);
            contro.iniciarControl();
            vista.dispose();

        } else if (modeloA.loginAdmin(cedula, contra)) {
            JOptionPane.showMessageDialog(null, "¡Sesion Iniciada con Exito!");
            VentanaUsuario_JM ventana = new VentanaUsuario_JM();
            ModeloPersona mPersona = new ModeloPersona();
            ConroladorUsuario cUsuario = new ConroladorUsuario(ventana, modeloC, mPersona, modeloA, modeloP, cedula);
            cUsuario.iniciaControlador();
            vista.dispose();

        } else if (modeloP.loginProveedor(cedula, contra)) {
            JOptionPane.showMessageDialog(null, "¡Sesion Iniciada con Exito!");
            VentanaUsuario_JM ventana = new VentanaUsuario_JM();
            ModeloPersona mPersona = new ModeloPersona();
            ConroladorUsuario cUsuario = new ConroladorUsuario(ventana, modeloC, mPersona, modeloA, modeloP, cedula);
            cUsuario.iniciaControlador();
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
