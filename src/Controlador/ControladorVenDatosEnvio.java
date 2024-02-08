/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Steven Zhicay
 */
import Clases.DatosVenta;
import Modelo.ModeloCliente;
import Modelo.ModeloDatosEnvio;
import Modelo.ModeloPersona;
import Vista.VentanaDatosEnvio;
import java.util.Date;
import javax.swing.JOptionPane;

public class ControladorVenDatosEnvio {

    private DatosVenta datosVenta;
    private VentanaDatosEnvio vista;
    private ModeloDatosEnvio modelo;
    ModeloDatosEnvio misdatos = new ModeloDatosEnvio();

    public ControladorVenDatosEnvio(VentanaDatosEnvio vista, ModeloDatosEnvio modelo) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        iniciaControlador();

    }

    public void iniciaControlador() {
        vista.getBtnRealizarPedido().addActionListener(l -> guardarDatosEnvio());
        vista.getBtRegresar().addActionListener(l -> cancelarOperacion());
        cargaID();
    }

    private void guardarDatosEnvio() {
        // Obtener datos de la vista

        int id_datos = Integer.parseInt(vista.getLblId_envio().getText());
        String nombres = vista.getTxtNombres().getText();
        String apellidos = vista.getTxtApellidos().getText();
        String movil = vista.getTxtMovil().getText();
        String direccion = vista.getTxtDireccion().getText();
        String numeroCuenta = vista.getTxtNumeroCuenta().getText();
        String codigoSeguridad = vista.getTxtCodigoSeguridad().getText();
        Date fechaExpiracion = vista.getjDFechaEx().getDate();

        // Validar datos
        System.out.println(vista.getLblId_envio().getText());
        // Establecer datos en el modelo

        misdatos.setId_datos(id_datos);
        misdatos.setNombres(nombres);
        misdatos.setApellidos(apellidos);
        misdatos.setMovil(movil);
        misdatos.setDireccion(direccion);
        misdatos.setNumeroCuenta(numeroCuenta);
        misdatos.setCodigoSeguridad(codigoSeguridad);
        misdatos.setFechaExpiracion(fechaExpiracion);

        // Puedes realizar otras operaciones según tus necesidades
        // Cerrar la ventana de datos de envío
        // Validar datos antes de guardar
        if (!datosVacios() && misdatos.guardarDatosEnvio()) {
            JOptionPane.showMessageDialog(vista, "Datos Agregados con Éxito");
        } else {
            JOptionPane.showMessageDialog(vista, "Error al intentar agregar los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }

//        // Validar datos antes de guardar para FK cliente
//        if (!datosVacios()) {
//            if (misdatos.datosEnvioExisten(id_client)) {
//                // Si los datos existen, actualizar
//                if (modelo.actualizarDatosEnvio()) {
//                    JOptionPane.showMessageDialog(vista, "Datos Actualizados con Éxito");
//                } else {
//                    JOptionPane.showMessageDialog(vista, "Error al intentar actualizar los datos", "Error", JOptionPane.ERROR_MESSAGE);
//                }
//            } else {
//                // Si los datos no existen, guardar
//                if (misdatos.guardarDatosEnvio()) {
//                    JOptionPane.showMessageDialog(vista, "Datos Agregados con Éxito");
//                } else {
//                    JOptionPane.showMessageDialog(vista, "Error al intentar agregar los datos", "Error", JOptionPane.ERROR_MESSAGE);
//                }
//            }
//        } else {
//            JOptionPane.showMessageDialog(vista, "Ingrese todos los datos antes de guardar o actualizar", "Error", JOptionPane.ERROR_MESSAGE);
//        }
    }

    private void cargaID() {
        vista.getLblId_envio().setText(String.valueOf(modelo.obtenerSiguienteIdDatos()));
    }

    private boolean datosVacios() {
        try {
            // Definir los campos de texto
            String nombres = vista.getTxtNombres().getText();
            String apellidos = vista.getTxtApellidos().getText();
            String movil = vista.getTxtMovil().getText();
            String direccion = vista.getTxtDireccion().getText();
            String numeroCuenta = vista.getTxtNumeroCuenta().getText();
            String codigoSeguridad = vista.getTxtCodigoSeguridad().getText();
            String fechaExpiracion = vista.getjDFechaEx().getDateFormatString();

            // Validar campos de texto
            if (nombres.isBlank() || apellidos.isBlank() || movil.isBlank() || direccion.isBlank()
                    || numeroCuenta.isBlank() || codigoSeguridad.isBlank() || fechaExpiracion.isBlank()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos de texto", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return true;
            }

            return false;
        } catch (Exception ex) {
            // Manejar cualquier excepción que pueda ocurrir
            JOptionPane.showMessageDialog(null, "Error en la validación de datos", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
    }

    private void cancelarOperacion() {
        // Puedes implementar lógica para cancelar la operación si es necesario
        vista.dispose();
    }
}
