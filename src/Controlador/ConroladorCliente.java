package Controlador;

import Clases.Cliente;
import Clases.Persona;
import Modelo.ModeloCliente;
import Modelo.ModeloPersona;
import Vista.VentanaLogin_JM;
import Vista.VentanaUsuario_JM;
import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class ConroladorCliente {
    
    private VentanaUsuario_JM vista;
    private ModeloCliente mCliente;
    private ModeloPersona mPersona;
    private String cedula;
    
    public ConroladorCliente(VentanaUsuario_JM vista, ModeloCliente mCliente, ModeloPersona mPersona, String cedula) {
        this.vista = vista;
        this.mCliente = mCliente;
        this.mPersona = mPersona;
        this.cedula = cedula;
        vista.setVisible(true);
    }
    
    public void iniciaControlador() {
        requestDatos();

        //Botones
        vista.getBtnActu().addActionListener(l -> updatecliente());
        vista.getBtnElim().addActionListener(l -> botonCerrarSesion());
    }
    
    private void requestDatos() {
        List<Cliente> datosCliente = ModeloCliente.requestClientes();
        List<Persona> datosPersona = ModeloPersona.requestPersonas();
        
        for (int i = 0; i < datosCliente.size(); i++) {
            vista.getTxtCedula().setText(cedula);
            vista.getTxtCon().setText(datosCliente.get(i).getContraseña());
        }
        
        for (int i = 0; i < datosPersona.size(); i++) {
            
            vista.getTxtNombte().setText(datosPersona.get(i).getNombre());
            vista.getTxtApellido().setText(datosPersona.get(i).getApellido());
            
            vista.getDtcFecha().setDate(datosPersona.get(i).getFecha_nac());
            
            if (String.valueOf(datosPersona.get(i).getSexo()).equals("M")) {
                vista.getRbtnMas().setSelected(true);
            } else {
                vista.getRbtnFem().setSelected(true);
            }
            
            vista.getTxtTelef().setText(datosPersona.get(i).getTelefono());
            vista.getTxtCorreo().setText(datosPersona.get(i).getCorreo());
            vista.getTxtDirec().setText(datosPersona.get(i).getDireccion());
        }
        
    }
    
    private void updatecliente() {
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
        
        if (persona.updatePersona() == null) {
            
            ModeloCliente cliente = new ModeloCliente();
            cliente.setId_cliente(cedula);
            cliente.setContraseña(contra);
            
            if (cliente.updateCliente() == null) {
                JOptionPane.showMessageDialog(null, "¡Datos Actualizados con Exito!");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo Actualizar los Datos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo Actualizar los Datos");
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
        ControladorlLogin cLogin = new ControladorlLogin(mCliente, ventana);
        cLogin.iniciaControlador();
        vista.dispose();
    }
    
}
