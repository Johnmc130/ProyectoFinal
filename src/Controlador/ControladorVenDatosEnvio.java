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
import javax.swing.JOptionPane;

public class ControladorVenDatosEnvio {

    private ModeloCliente mCliente;
    private ModeloPersona mPersona;
    private DatosVenta datosVenta;
    private VentanaDatosEnvio vista;
    

    public ControladorVenDatosEnvio(ModeloCliente mCliente, ModeloPersona mPersona, DatosVenta datosVenta, VentanaDatosEnvio vista) {
        this.mCliente = mCliente;
        this.mPersona = mPersona;
        this.datosVenta = datosVenta;
        this.vista = vista;
        vista.setVisible(true);
        iniciaControlador();
    }

    public void iniciaControlador() {
        vista.getBtnRealizarPedido().addActionListener(l -> guardarDatosEnvio());
        vista.getBtRegresar().addActionListener(l -> cancelarOperacion());
    }

    private void guardarDatosEnvio() {
        // Obtener datos de la vista
        String nombres = vista.getTxtNombres().getText();
        String apellidos = vista.getTxtApellidos().getText();
        String movil = vista.getTxtMovil().getText();
        String direccion = vista.getTxtDireccion().getText();
        String numeroCuenta = vista.getTxtNumeroCuenta().getText();
        String codigoSeguridad = vista.getTxtCodigoSeguridad().getText();
        String fechaExpiracion = vista.getjDFechaEx().getDateFormatString();

        // Validar datos
        if (datosVacios(nombres, apellidos, movil, direccion, numeroCuenta, codigoSeguridad, fechaExpiracion)) {
            JOptionPane.showMessageDialog(null, "Llene todos los datos de envío y tarjeta de crédito");
        } else {
            // Establecer datos en el modelo
            datosVenta.setNombres(nombres);
            datosVenta.setApellidos(apellidos);
            datosVenta.setMovil(movil);
            datosVenta.setDireccion(direccion);
            datosVenta.setNumeroCuenta(numeroCuenta);
            datosVenta.setCodigoSeguridad(codigoSeguridad);
            datosVenta.setFechaExpiracion(fechaExpiracion);

            // Guardar o actualizar datos de envío según el modelo
            ModeloDatosEnvio modeloDatosEnvio = new ModeloDatosEnvio();
            modeloDatosEnvio.guardarOActualizarDatosEnvio(datosVenta.getId_cliente());

            // Puedes realizar otras operaciones según tus necesidades
            // Cerrar la ventana de datos de envío
            vista.dispose();
        }
    }

    private boolean datosVacios(String nombres, String apellidos, String movil, String direccion, String numeroCuenta, String codigoSeguridad, String fechaExpiracion) {
        return nombres.isBlank() || apellidos.isBlank() || movil.isBlank() || direccion.isBlank()
                || numeroCuenta.isBlank() || codigoSeguridad.isBlank() || fechaExpiracion.isBlank();
    }

    private void cancelarOperacion() {
        // Puedes implementar lógica para cancelar la operación si es necesario
        vista.dispose();
    }
}
