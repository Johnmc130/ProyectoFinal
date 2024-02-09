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
import Clases.Procesador;
import Modelo.ModeloCliente;
import Modelo.ModeloDatosEnvio;
import Modelo.ModeloPersona;
import Vista.VentanaDatosEnvio;
import Vista.VistaProductos;
import java.util.Date;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

public class ControladorVenDatosEnvio {

    private DatosVenta datosVenta = new DatosVenta();
    private int id;
    private double precio;
    private String componente;
    private VentanaDatosEnvio vista;
    private ModeloDatosEnvio modelo;
    ModeloDatosEnvio misdatos = new ModeloDatosEnvio();

    public ControladorVenDatosEnvio(VentanaDatosEnvio vista, ModeloDatosEnvio modelo, int id, String componente, double precio) {
        this.modelo = modelo;
        this.vista = vista;
        this.id = id;
        this.precio = precio;
        this.componente = componente;
        vista.setVisible(true);
        iniciaControlador();
        mostrarPrecio();
        vista.getBtnRealizarPedido().addActionListener(l -> guardarDatosEnvio());

    }

    public void iniciaControlador() {

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
        String nombretabla = componente;
        int idProducto = id;
        String idCliente = datosVenta.getId_cliente();

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
        misdatos.setNombreProducto(nombretabla);
        misdatos.setId_producto(idProducto);
        misdatos.setId_cliente(idCliente);

        // Puedes realizar otras operaciones según tus necesidades
        // Cerrar la ventana de datos de envío
        // Validar datos antes de guardar
        if (!datosVacios() && misdatos.guardarDatosEnvio()) {
            JOptionPane.showMessageDialog(vista, "Datos Agregados con Éxito");
            imprimirPdf();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al intentar agregar los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void imprimirPdf() {
        try {
            // Cargar el archivo Jasper compilado (.jasper)
            String jasperFilePath = "/Reportes/ReporteFactura.jasper";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(jasperFilePath);

            // Puedes pasar parámetros al informe si es necesario
            // Map<String, Object> parametros = new HashMap<>();
            // Generar el informe
            byte[] jasperPrint = JasperRunManager.runReportToPdf(jasperReport, null);

            // Puedes guardar el informe en un archivo PDF u otro formato si lo deseas
            // JasperExportManager.exportReportToPdfFile(jasperPrint, "ruta/de/salida/informe.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    private void mostrarPrecio() {
        vista.getLblPrecio1().setText(String.valueOf(precio));
        vista.getLblPrecio2().setText(String.valueOf(precio));
    }

    private void cancelarOperacion() {
        VistaProductos v = new VistaProductos();
        ControladorVistaProductos contro = new ControladorVistaProductos(v);
        contro.iniciarControl();
        vista.dispose();
    }
}
