package Controlador;

import Modelo.ModeloCliente;
import Modelo.ModeloPersona;
import Vista.VentanaLogin_JM;
import Vista.VentanaRegistro_JM;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.swing.JOptionPane;

public class ControladorRegistro {

    private ModeloCliente mCliente;
    private ModeloPersona mPersona;
    private VentanaRegistro_JM vista;

    public ControladorRegistro(ModeloCliente mCliente, ModeloPersona mPersona, VentanaRegistro_JM vista) {
        this.mCliente = mCliente;
        this.mPersona = mPersona;
        this.vista = vista;
        vista.setVisible(true);
    }

    public void iniciaControlador() {
        vista.getBtnRegistra().addActionListener(l -> createCliente());
        vista.getBtnCancela().addActionListener(l -> botonRegresar());
        //Metodo para limpiar los Campos al hacer click
        limpiaCampos();
    }

    private void createCliente() {
        if (datosVacios()) {
            JOptionPane.showMessageDialog(null, "Llene todos los Datos");
        } else {
            String cedula = vista.getTxtCedula().getText();
            String nombre = vista.getTxtNombte().getText();
            String apellido = vista.getTxtApellido().getText();
            Date fecha_nac = vista.getDtcFecha().getDate();
            int edad = calcularEdad();
            char sexo = 0;
            if (vista.getRbtnMas().isSelected()) {
                sexo = 'M';
            } else if (vista.getRbtnFem().isSelected()) {
                sexo = 'F';
            }
            String correo = vista.getTxtCorreo().getText();
            String direccion = vista.getTxtDirec().getText();
            String telefono = vista.getTxtTelef().getText();
            String contra = String.valueOf(vista.getTxtCon().getPassword());

            ModeloPersona persona = new ModeloPersona();

            persona.setCedula(cedula);
            persona.setNombre(nombre);
            persona.setApellido(apellido);
            persona.setFecha_nac(new java.sql.Date(fecha_nac.getTime()));
            persona.setEdad(edad);
            persona.setSexo(sexo);
            persona.setCorreo(correo);
            persona.setDireccion(direccion);
            persona.setTelefono(telefono);

            ModeloCliente cliente = new ModeloCliente();
            cliente.setId_cliente(cedula);
            cliente.setContraseña(contra);

            if (persona.createPersona() == null) {
                if (cliente.createCliente() == null) {
                    JOptionPane.showMessageDialog(null, "¡Cuenta creada con Exito!");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo crear la Cuenta");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo crear la Cuenta");
            }
        }
    }

    private boolean datosVacios() {
        String cedula = vista.getTxtCedula().getText();
        String nombre = vista.getTxtNombte().getText();
        String apellido = vista.getTxtApellido().getText();
        Date fecha_nac = vista.getDtcFecha().getDate();
        int edad = calcularEdad();
        char sexo = 0;
        if (vista.getRbtnMas().isSelected()) {
            sexo = 'M';
        } else if (vista.getRbtnFem().isSelected()) {
            sexo = 'F';
        }
        String correo = vista.getTxtCorreo().getText();
        String direccion = vista.getTxtDirec().getText();
        String telefono = vista.getTxtTelef().getText();
        String contraseña = String.valueOf(vista.getTxtCon().getPassword());

        if (cedula.isBlank()) {
            JOptionPane.showMessageDialog(null, "Escriba una Cédula");
            return true;
        }
        if (nombre.isBlank()) {
            JOptionPane.showMessageDialog(null, "Escriba un Nombre");
            return true;
        }
        if (apellido.isBlank()) {
            JOptionPane.showMessageDialog(null, "Escriba un Apellido");
            return true;
        }
        if (fecha_nac == null) {
            JOptionPane.showMessageDialog(null, "Seleccione una Fecha de Nacimiento");
            return true;
        }
        if (edad == 0) {
            JOptionPane.showMessageDialog(null, "La Edad debe ser mayor a 0");
            return true;
        }
        if (String.valueOf(sexo).isBlank()) {
            JOptionPane.showMessageDialog(null, "Seleccione un Sexo");
            return true;
        }
        if (correo.isBlank()) {
            JOptionPane.showMessageDialog(null, "Escriba un Correo");
            return true;
        }
        if (direccion.isBlank()) {
            JOptionPane.showMessageDialog(null, "Escriba una Dirección");
            return true;
        }
        if (telefono.isBlank()) {
            JOptionPane.showMessageDialog(null, "Escriba un Teléfono");
            return true;
        }
        if (contraseña.isBlank()) {
            JOptionPane.showMessageDialog(null, "Escriba una Contraseña");
            return true;
        } else {
            return false;
        }
    }

    private int calcularEdad() {
        JDateChooser dateChooser = vista.getDtcFecha();
        LocalDate fechaNacimiento = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaActual = LocalDate.now();

        long edad = ChronoUnit.YEARS.between(fechaNacimiento, fechaActual);
        return (int) edad;
    }

    private void limpiaCampos() {
        if (vista.getTxtCedula().getText().equals("Ingrese su Cédula")) {
            vista.getTxtCedula().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Limpiar el JTextField cuando se hace clic
                    vista.getTxtCedula().setText("");
                }
            });
        }

        if (vista.getTxtNombte().getText().equals("Ingrese su Nombre")) {
            vista.getTxtNombte().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Limpiar el JTextField cuando se hace clic
                    vista.getTxtNombte().setText("");
                }
            });
        }

        if (vista.getTxtApellido().getText().equals("Ingrese su Apellido")) {
            vista.getTxtApellido().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Limpiar el JTextField cuando se hace clic
                    vista.getTxtApellido().setText("");
                }
            });
        }

        if (vista.getTxtCorreo().getText().equals("Ingrese su Correo")) {
            vista.getTxtCorreo().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Limpiar el JTextField cuando se hace clic
                    vista.getTxtCorreo().setText("");
                }
            });
        }

        if (vista.getTxtDirec().getText().equals("Ingrese su Dirección")) {
            vista.getTxtDirec().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Limpiar el JTextField cuando se hace clic
                    vista.getTxtDirec().setText("");
                }
            });
        }

        if (vista.getTxtTelef().getText().equals("Ingrese su Teléfono")) {
            vista.getTxtTelef().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Limpiar el JTextField cuando se hace clic
                    vista.getTxtTelef().setText("");
                }
            });
        }

        if (String.valueOf(vista.getTxtCon().getPassword()).equals("Contraseña123")) {
            vista.getTxtCon().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Limpiar el JTextField cuando se hace clic
                    vista.getTxtCon().setText("");
                }
            });
        }
    }

    private void botonRegresar() {
        VentanaLogin_JM ventana = new VentanaLogin_JM();
        ModeloCliente mCliente = new ModeloCliente();
        ControladorlLogin cRegistro = new ControladorlLogin(mCliente, ventana);
        cRegistro.iniciaControlador();
        ventana.setVisible(true);
        vista.dispose();
    }
}
