package Controlador;

import Vista.CrearGabinetes;
import Vista.EliminarGabinete;
import Vista.ModificarGabinetes;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import Main.ModeloGabinete;

/**
 *
 * @author MAX COMPUTERS
 */
public class ControladorGabinete {

    private ModeloGabinete modelo;
    private CrearGabinetes vistacrea;
    private ModificarGabinetes vistamodif;
    private EliminarGabinete vistaelim;
    ModeloGabinete miplaca = new ModeloGabinete();
    private String ruta;

    public ControladorGabinete(ModeloGabinete modelo, CrearGabinetes vista) {
        this.modelo = modelo;
        this.vistacrea = vista;
        vista.setVisible(true);
        cargarCodigosProveedorComboBox();
    }

    // Constructor para la modificación
    public ControladorGabinete(ModeloGabinete modelo, ModificarGabinetes vista) {
        this.modelo = modelo;
        this.vistamodif = vista;
        vista.setVisible(true);
        cargarCodigosProveedorComboBox();
        iniciaControlModificar();
    }

    // Constructor para la eliminación
    public ControladorGabinete(ModeloGabinete modelo, EliminarGabinete vista) {
        this.modelo = modelo;
        this.vistaelim = vista;
        vista.setVisible(true);
        cargarCodigosProveedorComboBox();
        iniciaControlEliminar();
    }

    public void iniciaControl() {
        // CRUD
        vistacrea.getBtnCreargabin().addActionListener(l -> grabarPlaca());
        // PasaDatos y CargaImagenes
        vistacrea.getBtncagagabinete().addActionListener(l -> abreFile());
        // GeneraID
        cargaID();
    }

    private void iniciaControlModificar() {

    }

    // Métodos de inicialización y eventos para la eliminación
    private void iniciaControlEliminar() {

    }

    private void grabarPlaca() {
        // Obtener valores de los campos
        int idgabinete = Integer.parseInt(vistacrea.getLbIdcreagabinete().getText());
        String marca = vistacrea.getTxtmarcacrergabinete().getText();
        String modelo = vistacrea.getTxtmodelocreagabinete().getText();
        String puertosusb = vistacrea.getTxtpuertocreagabinete().getText();
        String ventilador = vistacrea.getTxtventiiladorcreagabinete().getText();
        int tamanoventilador = (Integer) vistacrea.getSptamacreagabin().getValue();
        String fpoder = vistacrea.getTxtFpodercreagabin().getText();
        int tmvideo = (Integer) vistacrea.getSpTMvideocreagabin().getValue();
        String placamadre = vistacrea.getTxtplacacreagabin().getText();
        String bahias = vistacrea.getTxtbahiascreagabin().getText();
        double precio = Double.parseDouble(vistacrea.getTxtpreciocreagabin().getText());
        int stock = Integer.parseInt(vistacrea.getTxtstockcreagabin().getText());
        int idProveedor = Integer.valueOf(vistacrea.getCbproveedorcreagabin().getSelectedItem().toString());

        // Verificar si se seleccionó una imagen
        if (ruta.isEmpty()) {
            JOptionPane.showMessageDialog(vistacrea, "Seleccione una imagen antes de guardar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Convertir ruta de la imagen a bytes
        byte[] imggabinete = GuardaImagen(ruta);

        // Asignar valores al modelo
        miplaca.setIdgabinete(idgabinete);
        miplaca.setMarca(marca);
        miplaca.setModelo(modelo);
        miplaca.setPuertousb(puertosusb);
        miplaca.setVentiladores(ventilador);
        miplaca.setTamanoventilador(tamanoventilador);
        miplaca.setFuentepoder(fpoder);
        miplaca.setTamanomaxvideo(tmvideo);
        miplaca.setPlacamadre(placamadre);
        miplaca.setBahias(bahias);
        miplaca.setPrecio(precio);
        miplaca.setStock(stock);
        miplaca.setProveedor(idProveedor);
        miplaca.setFoto(imggabinete);

        // Validar datos antes de guardar
        if (!datosVacios() && miplaca.grabarPlacamadre()) {
            JOptionPane.showMessageDialog(vistacrea, "Gabinete Agregada con Éxito");
        } else {
            JOptionPane.showMessageDialog(vistacrea, "Error al intentar agregar el Gabinete", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cargarCodigosProveedorComboBox() {
        try {
            ArrayList<Integer> codigosProveedor = ModeloGabinete.obtenerCodigosProveedor();

            vistacrea.getCbproveedorcreagabin().removeAllItems();

            for (Integer idProveedor : codigosProveedor) {
                vistacrea.getCbproveedorcreagabin().addItem(String.valueOf(idProveedor));
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
            vistacrea.getLbgabineteimg().setIcon(new ImageIcon(imagenIcon.getImage().getScaledInstance(
                    vistacrea.getLbgabineteimg().getWidth(), vistacrea.getLbgabineteimg().getHeight(), Image.SCALE_SMOOTH)));
        }
    }

    public boolean datosVacios() {
        try {
            // Obtener los valores de los atributos
            int maximoram = Integer.parseInt(vistacrea.getSptamacreagabin().getValue().toString());
            int TMvideo = Integer.parseInt(vistacrea.getSpTMvideocreagabin().getValue().toString());
            Double precio = Double.parseDouble(vistacrea.getTxtpreciocreagabin().getText());
            int stock = Integer.parseInt(vistacrea.getTxtstockcreagabin().getText());

            // Obtener los valores de los atributos de texto
            String idgabinete = vistacrea.getLbIdcreagabinete().getText();
            String marca = vistacrea.getTxtmarcacrergabinete().getText();
            String modelo = vistacrea.getTxtmodelocreagabinete().getText();
            String puertosusb = vistacrea.getTxtpuertocreagabinete().getText();
            String ventiladores = vistacrea.getTxtventiiladorcreagabinete().getText();
            String Fpoder = vistacrea.getTxtFpodercreagabin().getText();
            String placam = vistacrea.getTxtplacacreagabin().getText();
            String bahias = vistacrea.getTxtbahiascreagabin().getText();
            String proveedor = (String) vistacrea.getCbproveedorcreagabin().getSelectedItem();

            // Validar campos numéricos
            if (maximoram < 0 || maximoram < 0 || TMvideo < 0 || precio < 0 || stock < 0) {
                JOptionPane.showMessageDialog(null, "Los campos numéricos no pueden ser negativos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return true;
            }

            // Validar campos de texto
            if (idgabinete.isEmpty() || marca.isEmpty() || modelo.isEmpty() || puertosusb.isEmpty() || ventiladores.isEmpty()
                    || Fpoder.isEmpty() || placam.isEmpty() || bahias.isEmpty()) {
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
        vistacrea.getLbIdcreagabinete().setText(String.valueOf(modelo.obtenerSiguienteIdGabinete()));
    }
}
