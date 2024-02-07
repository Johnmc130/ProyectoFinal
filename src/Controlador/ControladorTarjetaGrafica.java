package Controlador;

import Clases.Tarjetagrafica;
import Vista.CrearTarjetaGrafica;
import Vista.EliminarTarjetaGrafica;
import Vista.ModificarTarjetaGrafica;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import Main.ModeloTarjetaGrafica;

/**
 *
 * @author MAX COMPUTERS
 */
public class ControladorTarjetaGrafica {

    private ModeloTarjetaGrafica modelo;
    private CrearTarjetaGrafica vistacrea;
    private ModificarTarjetaGrafica vistamodif;
    private EliminarTarjetaGrafica vistaelim;
    ModeloTarjetaGrafica mitarjeta = new ModeloTarjetaGrafica();
    private String ruta;

    public ControladorTarjetaGrafica(ModeloTarjetaGrafica modelo, CrearTarjetaGrafica vista) {
        this.modelo = modelo;
        this.vistacrea = vista;
        vista.setVisible(true);
        cargarCodigosProveedorComboBox();
    }

    // Constructor para la modificación
    public ControladorTarjetaGrafica(ModeloTarjetaGrafica modelo, ModificarTarjetaGrafica vista) {
        this.modelo = modelo;
        this.vistamodif = vista;
        vista.setVisible(true);
        cargarCodigosProveedorComboBoxmodi();
        iniciaControlModificar();
    }

    // Constructor para la eliminación
    public ControladorTarjetaGrafica(ModeloTarjetaGrafica modelo, EliminarTarjetaGrafica vista) {
        this.modelo = modelo;
        this.vistaelim = vista;
        vista.setVisible(true);
        iniciaControlEliminar();
    }

    public void iniciaControl() {
        // CRUD
        vistacrea.getBtnCreartarjeta().addActionListener(l -> grabarTarjetaGrafica());
        // PasaDatos y CargaImagenes
        vistacrea.getBtncargatarjeta().addActionListener(l -> abreFile());
        // GeneraID
        cargaID();
    }

    public void iniciaControlModificar() {
        vistamodif.getBtnModificartarjeta().addActionListener(e -> modificarTarjeta());
        cargarDatosTarjetaEnVistaModificar(mitarjeta.obtenerSiguienteIdtarjetag());
        cargarCodigosProveedorComboBoxmodi();
    }

    public void iniciaControlEliminar() {

    }

    private void grabarTarjetaGrafica() {
        // Obtener valores de los campos
        int idtarjetag = Integer.parseInt(vistacrea.getLbIdcreatarjetag().getText());
        String marca = vistacrea.getTxtmarcacreatarjetag().getText();
        String modelo = vistacrea.getTxtmodelocreatarjetag().getText();
        int vram = (Integer) vistacrea.getSpvramtarjeta().getValue();
        String dlss = vistacrea.getTxtDLSStarj().getText();
        String fsr = vistacrea.getTxtFSRtarjeta().getText();
        int watts = (Integer) vistacrea.getSpwattstarjeta().getValue();
        int tamano = (Integer) vistacrea.getSptamanotarjeta().getValue();
        double precio = Double.parseDouble(vistacrea.getTxtpreciocreatarj().getText());
        int stock = Integer.parseInt(vistacrea.getTxtstockcreatarj().getText());
        int idProveedor = Integer.valueOf(vistacrea.getCbproveedortarje().getSelectedItem().toString());

        // Verificar si se seleccionó una imagen
        if (ruta.isEmpty()) {
            JOptionPane.showMessageDialog(vistacrea, "Seleccione una imagen antes de guardar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Convertir ruta de la imagen a bytes
        byte[] imgtarjetag = GuardaImagen(ruta);

        // Asignar valores al modelo
        mitarjeta.setIdtarjetag(idtarjetag);
        mitarjeta.setMarca(marca);
        mitarjeta.setModelo(modelo);
        mitarjeta.setVram(vram);
        mitarjeta.setDlss(dlss);
        mitarjeta.setFsr(fsr);
        mitarjeta.setWatts(watts);
        mitarjeta.setTamano(tamano);
        mitarjeta.setPrecio(precio);
        mitarjeta.setStock(stock);
        mitarjeta.setProveedor(idProveedor);
        mitarjeta.setFoto(imgtarjetag);

        // Validar datos antes de guardar
        if (!datosVacios() && mitarjeta.grabarPlacamadre()) {
            JOptionPane.showMessageDialog(vistacrea, "Tarjeta Gráfica Agregada con Éxito");
        } else {
            JOptionPane.showMessageDialog(vistacrea, "Error al intentar agregar el Tarjeta Gráfica", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarDatosTarjetaEnVistaModificar(int idTarjeta) {
        Tarjetagrafica tarjeta = modelo.obtenerDatosTarjeta(idTarjeta);

        if (tarjeta != null) {

            byte[] imagenBytes = tarjeta.getFoto();
            if (imagenBytes != null && imagenBytes.length > 0) {
                ImageIcon imagenIcon = new ImageIcon(imagenBytes);
                vistamodif.getLbtarjetacaimg().setIcon(new ImageIcon(imagenIcon.getImage().getScaledInstance(
                        vistamodif.getLbtarjetacaimg().getWidth(), vistamodif.getLbtarjetacaimg().getHeight(), Image.SCALE_SMOOTH)));
            }
        }
    }

    private void modificarTarjeta() {
        int idTarjeta = obtenerIdTarjetaSeleccionada();

        String marca = vistamodif.getTxtmarcamodtarjetag().getText();
        String model = vistamodif.getTxtmodelomodtarjetag().getText();
        int vram = (Integer) vistamodif.getSpvrammodtarjeta().getValue();
        String dlss = vistamodif.getTxtDLSSmodtarj().getText();
        String fsr = vistamodif.getTxtFSRmodtarjeta().getText();
        int watts = (Integer) vistamodif.getSpwattsmodtarjeta().getValue();
        int tamano = (Integer) vistamodif.getSptamanomodtarjeta().getValue();
        double precio = Double.parseDouble(vistamodif.getTxtpreciomodtarj().getText());
        int stock = Integer.parseInt(vistamodif.getTxtstockmodtarj().getText());
        int idProveedor = Integer.valueOf(vistamodif.getCbproveedormodtarje().getSelectedItem().toString());

        byte[] imagenBytes = null;
        if (ruta != null) {
            imagenBytes = GuardaImagen(ruta);
        }
        Tarjetagrafica tarjetaModificada = new Tarjetagrafica();
        tarjetaModificada.setIdtarjetag(idTarjeta);
        tarjetaModificada.setMarca(marca);
        tarjetaModificada.setModelo(model);
        tarjetaModificada.setVram(vram);
        tarjetaModificada.setDlss(dlss);
        tarjetaModificada.setFsr(fsr);
        tarjetaModificada.setWatts(watts);
        tarjetaModificada.setTamano(tamano);
        tarjetaModificada.setPrecio(precio);
        tarjetaModificada.setStock(stock);
        tarjetaModificada.setProveedor(idProveedor);

        // Si hay una nueva imagen, establecerla
        if (imagenBytes != null) {
            tarjetaModificada.setFoto(imagenBytes);
        } else {
            // Si no hay nueva imagen, mantener la imagen actual
            Tarjetagrafica tarjetaActual = modelo.obtenerDatosTarjeta(idTarjeta);
            if (tarjetaActual != null) {
                tarjetaModificada.setFoto(tarjetaActual.getFoto());
            }
        }

        if (modelo.actualizarTarjeta(tarjetaModificada)) {
            JOptionPane.showMessageDialog(vistamodif, "Tarjeta Gráfica Modificada con Éxito");
        } else {
            JOptionPane.showMessageDialog(vistamodif, "Error al intentar modificar la Tarjeta Gráfica", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

//    private void buscarTarjetaGrafica() {
//        try {
//            String idTarjetaStr = vistamodif.getTxtbuscartarjeta().getText();
//            if (!idTarjetaStr.isEmpty()) {
//                int idTarjeta = Integer.parseInt(idTarjetaStr);
//                cargarDatosTarjetaEnVistaModificar(idTarjeta);
//            } else {
//                JOptionPane.showMessageDialog(vistamodif, "Ingrese un ID de tarjeta válido", "Advertencia", JOptionPane.WARNING_MESSAGE);
//            }
//        } catch (NumberFormatException ex) {
//            JOptionPane.showMessageDialog(vistamodif, "Ingrese un ID de tarjeta válido", "Advertencia", JOptionPane.WARNING_MESSAGE);
//        }
//    }

    public void cargarCodigosProveedorComboBox() {
        try {
            ArrayList<Integer> codigosProveedor = ModeloTarjetaGrafica.obtenerCodigosProveedor();
            vistacrea.getCbproveedortarje().removeAllItems();

            for (Integer idProveedor : codigosProveedor) {
                vistacrea.getCbproveedortarje().addItem(String.valueOf(idProveedor));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private byte[] GuardaImagen(String ruta) {
        try {
            File imagen = new File(ruta);
            return Files.readAllBytes(imagen.toPath());
        } catch (IOException e) {
            return null;
        }
    }

    private void abreFile() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);

        int resultado = fileChooser.showOpenDialog(vistacrea);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            ruta = archivoSeleccionado.getAbsolutePath();

            ImageIcon imagenIcon = new ImageIcon(ruta);
            vistacrea.getLbtarjetacaimg().setIcon(new ImageIcon(imagenIcon.getImage().getScaledInstance(
                    vistacrea.getLbtarjetacaimg().getWidth(), vistacrea.getLbtarjetacaimg().getHeight(), Image.SCALE_SMOOTH)));
        }
    }

    private void abreFileModificar() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);

        int resultado = fileChooser.showOpenDialog(vistamodif);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            String rutaImagen = archivoSeleccionado.getAbsolutePath();

            ImageIcon imagenIcon = new ImageIcon(rutaImagen);
            vistamodif.getLbIdmodtarjetag().setIcon(new ImageIcon(imagenIcon.getImage().getScaledInstance(
                    vistamodif.getLbIdmodtarjetag().getWidth(), vistamodif.getLbIdmodtarjetag().getHeight(), Image.SCALE_SMOOTH)));
        }
    }

    public boolean datosVacios() {
        try {
            // Obtener los valores de los atributos
            int vram = Integer.parseInt(vistacrea.getSpvramtarjeta().getValue().toString());
            int watss = Integer.parseInt(vistacrea.getSpwattstarjeta().getValue().toString());
            Double precio = Double.parseDouble(vistacrea.getTxtpreciocreatarj().getText());
            int tamano = Integer.parseInt(vistacrea.getSptamanotarjeta().getValue().toString());
            int stock = Integer.parseInt(vistacrea.getTxtstockcreatarj().getText());

            // Obtener los valores de los atributos de texto
            String idtarjetag = vistacrea.getLbIdcreatarjetag().getText();
            String marca = vistacrea.getTxtmarcacreatarjetag().getText();
            String modelo = vistacrea.getTxtmodelocreatarjetag().getText();
            String dlss = vistacrea.getTxtDLSStarj().getText();
            String fsr = vistacrea.getTxtFSRtarjeta().getText();
            String proveedor = (String) vistacrea.getCbproveedortarje().getSelectedItem();

            // Validar campos numéricos
            if (vram < 0 || watss < 0 || tamano < 0 || precio < 0 || stock < 0) {
                JOptionPane.showMessageDialog(null, "Los campos numéricos no pueden ser negativos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return true;
            }

            // Validar campos de texto
            if (idtarjetag.isEmpty() || marca.isEmpty() || modelo.isEmpty() || dlss.isEmpty() || fsr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos de texto", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return true;
            }

            return false;
        } catch (NumberFormatException ex) {
            // Capturar excepción si ocurre un error al convertir a entero o doble
            JOptionPane.showMessageDialog(vistacrea, "Error en la conversión de datos numéricos", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
    }

    private void cargaID() {
        vistacrea.getLbIdcreatarjetag().setText(String.valueOf(modelo.obtenerSiguienteIdtarjetag()));
    }

    public void cargarCodigosProveedorComboBoxmodi() {
        try {
            ArrayList<Integer> codigosProveedor = ModeloTarjetaGrafica.obtenerCodigosProveedor();

            vistamodif.getCbproveedormodtarje().removeAllItems();

            for (Integer idProveedor : codigosProveedor) {
                vistamodif.getCbproveedormodtarje().addItem(String.valueOf(idProveedor));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int obtenerIdTarjetaSeleccionada() {
        try {
            String idTarjetaStr = vistamodif.getLbIdmodtarjetag().getText();
            if (!idTarjetaStr.isEmpty()) {
                return Integer.parseInt(idTarjetaStr);
            } else {
                JOptionPane.showMessageDialog(vistamodif, "No se ha seleccionado ninguna Tarjeta Gráfica", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return -1; // Otra opción podría ser lanzar una excepción
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vistamodif, "ID de Tarjeta Gráfica inválido", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return -1; // Otra opción podría ser lanzar una excepción
        }
    }
}
