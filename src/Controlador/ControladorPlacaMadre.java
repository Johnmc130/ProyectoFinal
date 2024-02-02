package Controlador;


import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import Modelo.ModeloPlacaMadre;
import Vista.*;

public class ControladorPlacaMadre {

    private ModeloPlacaMadre modelo;
    private CrearPlacaMadre vistacrea;
    private ModificarPlacaMadre vistamodif;
    private EliminarPlacaMadre vistaelim;
    ModeloPlacaMadre miplaca = new ModeloPlacaMadre();
    private String ruta;

    public ControladorPlacaMadre(ModeloPlacaMadre modelo, CrearPlacaMadre vista) {
        this.modelo = modelo;
        this.vistacrea = vista;
        vista.setVisible(true);
        cargarCodigosProveedorComboBox();
    }

    // Constructor para la modificación
    public ControladorPlacaMadre(ModeloPlacaMadre modelo, ModificarPlacaMadre vista) {
        this.modelo = modelo;
        this.vistamodif = vista;
        vista.setVisible(true);
        cargarCodigosProveedorComboBox();
        iniciaControlModificar();
    }

    // Constructor para la eliminación
    public ControladorPlacaMadre(ModeloPlacaMadre modelo, EliminarPlacaMadre vista) {
        this.modelo = modelo;
        this.vistaelim = vista;
        vista.setVisible(true);
        cargarCodigosProveedorComboBox();
        iniciaControlEliminar();
    }

    public void iniciaControl(String vista) {
        // CRUD
        switch (vista) {
            case "Crear":
                vistacrea.getBtnCrearplacam().addActionListener(l -> grabarPlaca());
                // PasaDatos y CargaImagenes
                vistacrea.getBtncargaplaca().addActionListener(l -> abreFile());
                // GeneraID
                break;
            case "Modificar":
                break;
            case "Eliminar":
                break;

        }

        cargaID();
    }

    private void iniciaControlModificar() {

    }

    // Métodos de inicialización y eventos para la eliminación
    private void iniciaControlEliminar() {

    }

    private void grabarPlaca() {
        // Obtener valores de los campos
        int idplacam = Integer.parseInt(vistacrea.getLbIdcreaplaca().getText());
        String marca = vistacrea.getTxtmarcacreaplaca().getText();
        String modelo = vistacrea.getTxtmodelocreaplaca().getText();
        String puertosalmacena = vistacrea.getTxtpuertosalma().getText();
        String puertosusb = vistacrea.getTxtpuertosusb().getText();
        String socket = vistacrea.getTxtsocketcreaplaca().getText();
        int tiporam = (Integer) vistacrea.getSptiporamplaca().getValue();
        int maximoram = (Integer) vistacrea.getSpMaximoramplaca().getValue();
        String ranuras = vistacrea.getTxtranuraexpcreaplaca().getText();
        String formato = vistacrea.getTxtformatocreaplaca2().getText();
        int watts = (Integer) vistacrea.getSpwattsramplaca().getValue();
        double precio = Double.parseDouble(vistacrea.getTxtpreciocreaplaca().getText());
        int stock = Integer.parseInt(vistacrea.getTxtstockcreaplaca().getText());
        int idProveedor = Integer.valueOf(vistacrea.getCbproveedorplaca().getSelectedItem().toString());

        // Verificar si se seleccionó una imagen
        if (ruta.isEmpty()) {
            JOptionPane.showMessageDialog(vistacrea, "Seleccione una imagen antes de guardar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Convertir ruta de la imagen a bytes
        byte[] imgplaca = GuardaImagen(ruta);

        // Asignar valores al modelo
        miplaca.setIdplacam(idplacam);
        miplaca.setMarca(marca);
        miplaca.setModelo(modelo);
        miplaca.setPuertosalmacenamiento(puertosalmacena);
        miplaca.setPuertosusb(puertosusb);
        miplaca.setSocket(socket);
        miplaca.setTiposram(tiporam);
        miplaca.setMaximoram(maximoram);
        miplaca.setRanuraexpansion(ranuras);
        miplaca.setFormato(formato);
        miplaca.setWatts(watts);
        miplaca.setPrecio(precio);
        miplaca.setStock(stock);
        miplaca.setProveedor(idProveedor);
        miplaca.setFoto(imgplaca);

        // Validar datos antes de guardar
        if (!datosVacios() && miplaca.grabarPlacamadre()) {
            JOptionPane.showMessageDialog(vistacrea, "Placa Agregada con Éxito");
        } else {
            JOptionPane.showMessageDialog(vistacrea, "Error al intentar agregar la Placa", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cargarCodigosProveedorComboBox() {
        try {
            ArrayList<Integer> codigosProveedor = ModeloPlacaMadre.obtenerCodigosProveedor();

            vistacrea.getCbproveedorplaca().removeAllItems();

            for (Integer idProveedor : codigosProveedor) {
                vistacrea.getCbproveedorplaca().addItem(String.valueOf(idProveedor));
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
            vistacrea.getLbplacaimg().setIcon(new ImageIcon(imagenIcon.getImage().getScaledInstance(
                    vistacrea.getLbplacaimg().getWidth(), vistacrea.getLbplacaimg().getHeight(), Image.SCALE_SMOOTH)));
        }
    }

    public boolean datosVacios() {
        try {
            // Obtener los valores de los atributos
            int tiporam = Integer.parseInt(vistacrea.getSptiporamplaca().getValue().toString());
            int maximoram = Integer.parseInt(vistacrea.getSpMaximoramplaca().getValue().toString());
            int watts = Integer.parseInt(vistacrea.getSpwattsramplaca().getValue().toString());
            Double precio = Double.parseDouble(vistacrea.getTxtpreciocreaplaca().getText());
            int stock = Integer.parseInt(vistacrea.getTxtstockcreaplaca().getText());

            // Obtener los valores de los atributos de texto
            String idplacam = vistacrea.getLbIdcreaplaca().getText();
            String marca = vistacrea.getTxtmarcacreaplaca().getText();
            String modelo = vistacrea.getTxtmodelocreaplaca().getText();
            String puertosalma = vistacrea.getTxtpuertosalma().getText();
            String puertosUSB = vistacrea.getTxtpuertosusb().getText();
            String socket = vistacrea.getTxtsocketcreaplaca().getText();
            String ranurasexp = vistacrea.getTxtranuraexpcreaplaca().getText();
            String formato = vistacrea.getTxtformatocreaplaca2().getText();
            String proveedor = (String) vistacrea.getCbproveedorplaca().getSelectedItem();

            // Validar campos numéricos
            if (tiporam < 0 || maximoram < 0 || watts < 0 || precio < 0 || stock < 0) {
                JOptionPane.showMessageDialog(null, "Los campos numéricos no pueden ser negativos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return true;
            }

            // Validar campos de texto
            if (idplacam.isEmpty() || marca.isEmpty() || modelo.isEmpty() || puertosalma.isEmpty() || puertosUSB.isEmpty()
                    || socket.isEmpty() || ranurasexp.isEmpty() || formato.isEmpty()) {
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
        vistacrea.getLbIdcreaplaca().setText(String.valueOf(modelo.obtenerSiguienteIdPlacaMadre()));
    }
}
