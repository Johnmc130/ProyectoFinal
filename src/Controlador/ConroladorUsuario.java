package Controlador;

import Clases.Administrador;
import Clases.Cliente;
import Clases.Proveedor;
import Modelo.ModeloAdministrador;
import Modelo.ModeloCliente;
import Modelo.ModeloPersona;
import Modelo.ModeloProveedor;
import Vista.VentanaLogin_JM;
import Vista.VentanaUsuario_JM;
import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class ConroladorUsuario {

    private VentanaUsuario_JM vista;
    private ModeloCliente mCliente;
    private ModeloPersona mPersona;
    private ModeloAdministrador mAdministrador;
    private ModeloProveedor mProveedor;
    private String cedula;

    public ConroladorUsuario() {
    }

    public ConroladorUsuario(VentanaUsuario_JM vista, ModeloCliente mCliente, ModeloPersona mPersona, ModeloAdministrador mAdministrador, ModeloProveedor mProveedor, String cedula) {
        this.vista = vista;
        this.mCliente = mCliente;
        this.mPersona = mPersona;
        this.mAdministrador = mAdministrador;
        this.mProveedor = mProveedor;
        this.cedula = cedula;
        vista.setVisible(true);
    }

    public void iniciaControlador() {
        requestDatos();

        //Botones
        vista.getBtnActu().addActionListener(l -> updateUsuario());
        vista.getBtnElim().addActionListener(l -> botonCerrarSesion());
    }

    private void requestDatos() {
        List<Cliente> datosCliente = ModeloCliente.requestClientebyID(cedula);
        List<Administrador> datosAdmin = ModeloAdministrador.requestAdminbyID(cedula);
        List<Proveedor> datosProv = ModeloProveedor.requestProvbyID(cedula);

        if (mCliente.existeCliente(cedula)) {
            for (int i = 0; i < datosCliente.size(); i++) {
                vista.getTxtCedula().setText(cedula);
                vista.getTxtCon().setText(datosCliente.get(i).getContraseña());
                vista.getTxtNombte().setText(datosCliente.get(i).getNombre());
                vista.getTxtApellido().setText(datosCliente.get(i).getApellido());
                vista.getDtcFecha().setDate(datosCliente.get(i).getFecha_nac());

                if (String.valueOf(datosCliente.get(i).getSexo()).equals("M")) {
                    vista.getRbtnMas().setSelected(true);
                } else {
                    vista.getRbtnFem().setSelected(true);
                }

                vista.getTxtTelef().setText(datosCliente.get(i).getTelefono());
                vista.getTxtCorreo().setText(datosCliente.get(i).getCorreo());
                vista.getTxtDirec().setText(datosCliente.get(i).getDireccion());
            }

        } else if (mAdministrador.existeAdmin(cedula)) {
            for (int i = 0; i < datosAdmin.size(); i++) {
                vista.getTxtCedula().setText(cedula);
                vista.getTxtCon().setText(datosAdmin.get(i).getContraseña());
                vista.getTxtNombte().setText(datosAdmin.get(i).getNombre());
                vista.getTxtApellido().setText(datosAdmin.get(i).getApellido());
                vista.getDtcFecha().setDate(datosAdmin.get(i).getFecha_nac());

                if (String.valueOf(datosAdmin.get(i).getSexo()).equals("M")) {
                    vista.getRbtnMas().setSelected(true);
                } else {
                    vista.getRbtnFem().setSelected(true);
                }

                vista.getTxtTelef().setText(datosAdmin.get(i).getTelefono());
                vista.getTxtCorreo().setText(datosAdmin.get(i).getCorreo());
                vista.getTxtDirec().setText(datosAdmin.get(i).getDireccion());
            }

        } else if (mProveedor.existeProv(cedula)) {
            for (int i = 0; i < datosProv.size(); i++) {
                vista.getTxtCedula().setText(cedula);
                vista.getTxtCon().setText(datosProv.get(i).getContraseña());
                vista.getTxtNombte().setText(datosProv.get(i).getNombre());
                vista.getTxtApellido().setText(datosProv.get(i).getApellido());

                vista.getDtcFecha().setDate(datosProv.get(i).getFecha_nac());

                if (String.valueOf(datosProv.get(i).getSexo()).equals("M")) {
                    vista.getRbtnMas().setSelected(true);
                } else {
                    vista.getRbtnFem().setSelected(true);
                }

                vista.getTxtTelef().setText(datosProv.get(i).getTelefono());
                vista.getTxtCorreo().setText(datosProv.get(i).getCorreo());
                vista.getTxtDirec().setText(datosProv.get(i).getDireccion());
            }
        }
    }

    private void updateUsuario() {
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

        if (mCliente.existeCliente(cedula)) {
            if (persona.updatePersona() == null) {
                ModeloCliente cliente = new ModeloCliente();
                cliente.setContraseña(contra);
                cliente.setCedula(cedula);

                if (cliente.updateCliente() == null) {
                    JOptionPane.showMessageDialog(null, "¡Datos Actualizados con Exito!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo Actualizar los Datos");
            }
        } else if (mAdministrador.existeAdmin(cedula)) {
            if (persona.updatePersona() == null) {
                ModeloAdministrador admin = new ModeloAdministrador();
                admin.setContraseña(contra);
                admin.setCedula(cedula);

                if (admin.updateAdmin() == null) {
                    JOptionPane.showMessageDialog(null, "¡Datos Actualizados con Exito!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo Actualizar los Datos");
            }
        } else if (mProveedor.existeProv(cedula)) {
            if (persona.updatePersona() == null) {
                ModeloProveedor proveedor = new ModeloProveedor();
                proveedor.setContraseña(contra);
                proveedor.setCedula(cedula);

                if (proveedor.updateProveedor() == null) {
                    JOptionPane.showMessageDialog(null, "¡Datos Actualizados con Exito!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo Actualizar los Datos");
            }
        }
    }

    private int calcularEdad() {
        JDateChooser dateChooser = vista.getDtcFecha();
        LocalDate fechaNacimiento = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaActual = LocalDate.now();

        long edad = ChronoUnit.YEARS.between(fechaNacimiento, fechaActual);
        return (int) edad;
    }

    private void botonCerrarSesion() {
        VentanaLogin_JM ventana = new VentanaLogin_JM();
        ModeloCliente mCliente = new ModeloCliente();
        ModeloAdministrador modeloA = new ModeloAdministrador();
        ModeloProveedor modeloP = new ModeloProveedor();
        ControladorlLogin cLogin = new ControladorlLogin(mCliente, modeloA, modeloP, ventana);
        cLogin.iniciaControlador();

        vista.dispose();
    }

}
