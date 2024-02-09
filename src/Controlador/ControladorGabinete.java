package Controlador;

import Clases.Gabinete;
import Vista.CrearGabinetes;
import Vista.EliminarGabinete;
import Vista.ModificarGabinetes;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import Modelo.ModeloGabinete;
import Vista.CRUD_Productos_JB;

/**
 *
 * @author MAX COMPUTERS
 */
public class ControladorGabinete {

    private ModeloGabinete modelo;
    private CrearGabinetes vistacrea;
    private ModificarGabinetes vistamodif;
    private EliminarGabinete vistaelim;
    ModeloGabinete migabinete = new ModeloGabinete();
    ModeloGabinete migabinetemod = new ModeloGabinete();
    private String ruta;
    private String rutamod;

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
        cargarCodigosProveedorComboBoxmodi();
        listarGabinete();
        iniciaControlModificar();

        vistamodif.getBtncagagabinetemodi().addActionListener(l -> abrefotoModificar());
        vistamodif.getBtnModigabin().addActionListener(e -> modificarGabinete());
    }

    // Constructor para la eliminación
    public ControladorGabinete(ModeloGabinete modelo, EliminarGabinete vista) {
        this.modelo = modelo;
        this.vistaelim = vista;
        vista.setVisible(true);
        listarGabineteselim();
        iniciaControlEliminar();

        vistaelim.getBtnEliminargabin().addActionListener(l -> eliminarGabinetes());
    }

    public void iniciaControl() {
        // CRUD
        vistacrea.getBtnCreargabin().addActionListener(l -> grabarGabinete());
        // PasaDatos y CargaImagenes
        vistacrea.getBtncagagabinete().addActionListener(l -> abreFile());
        vistacrea.getBtAtrascrea().addActionListener(l -> botonAtras());
        // GeneraID
        cargaID();
    }

    public void iniciaControlModificar() {

        vistamodif.getBtnBuscarmodigabin().addActionListener(l -> buscarGabinete());
        vistamodif.getBtAtrascrea().addActionListener(l -> botonAtras());

        // Agregar el listener para la selección de fila en la tabla
        vistamodif.getTbGabinetemodi().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Obtener la fila seleccionada
                int filaSeleccionada = vistamodif.getTbGabinetemodi().getSelectedRow();

                // Cargar los datos de la fila en los componentes de modificación
                cargarDatosEnComponentesModificar(filaSeleccionada);
            }
        });

        cargarCodigosProveedorComboBoxmodi();
    }

    // Métodos de inicialización y eventos para la eliminación
    public void iniciaControlEliminar() {
        vistaelim.getBtnBuscareliminargabin().addActionListener(l -> buscarGabineteElim());
        vistaelim.getBtAtras1().addActionListener(l -> botonAtras());

        // Agregar el listener para la selección de fila en la tabla
        vistaelim.getTbGabineteelim().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Obtener la fila seleccionada
                int filaSeleccionada = vistaelim.getTbGabineteelim().getSelectedRow();

                // Cargar la imagen en lbimagentarjelim
                cargarImagenEliminar(filaSeleccionada);
            }
        });
    }

    private void grabarGabinete() {
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
        migabinete.setIdgabinete(idgabinete);
        migabinete.setMarca(marca);
        migabinete.setModelo(modelo);
        migabinete.setPuertousb(puertosusb);
        migabinete.setVentiladores(ventilador);
        migabinete.setTamanoventilador(tamanoventilador);
        migabinete.setFuentepoder(fpoder);
        migabinete.setTamanomaxvideo(tmvideo);
        migabinete.setPlacamadre(placamadre);
        migabinete.setBahias(bahias);
        migabinete.setPrecio(precio);
        migabinete.setStock(stock);
        migabinete.setProveedor(idProveedor);
        migabinete.setFoto(imggabinete);

        // Validar datos antes de guardar
        if (!datosVacios() && migabinete.grabarGabinete()) {
            JOptionPane.showMessageDialog(vistacrea, "Gabinete Agregada con Éxito");
            limpiarCamposAgregar();
        } else {
            JOptionPane.showMessageDialog(vistacrea, "Error al intentar agregar el Gabinete", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificarGabinete() {
        // Obtener la ID de la Tarjeta Gráfica seleccionada
        int idGabineteSeleccionada = obtenerIdGabineteSeleccionada();
        if (idGabineteSeleccionada == -1) {
            return;
        }

        // Obtener valores de los campos de la vista
        int idgabinete = Integer.parseInt(vistamodif.getLbIdmodigabinete().getText());
        String marca = vistamodif.getTxtmarcamodigabinete().getText();
        String modelo = vistamodif.getTxtmodelomodigabinete().getText();
        String puertosusb = vistamodif.getTxtpuertomodigabinete().getText();
        String ventilador = vistamodif.getTxtventiiladormodigabinete().getText();
        int tamanoventilador = (Integer) vistamodif.getSptamamodigabin().getValue();
        String fpoder = vistamodif.getTxtFpodermodigabin().getText();
        int tmvideo = (Integer) vistamodif.getSpTMvideomodigabin().getValue();
        String placamadre = vistamodif.getTxtplacamodigabin().getText();
        String bahias = vistamodif.getTxtbahiasmodigabin().getText();
        double precio = Double.parseDouble(vistamodif.getTxtpreciomodigabin().getText());
        int stock = Integer.parseInt(vistamodif.getTxtstockmodigabin().getText());
        int idProveedor = Integer.valueOf(vistamodif.getCbproveedormodigabin().getSelectedItem().toString());

// Verificar si se seleccionó una nueva imagen
        if (rutamod != null && !rutamod.isEmpty()) {
            byte[] imgTarjeta = GuardaImagen(rutamod);
            migabinetemod.setFoto(imgTarjeta);
        } else {
            // Si no se seleccionó una nueva imagen, obtener la imagen actual
            byte[] imageBytes = icono_a_Bytes(vistamodif.getLbgabineteimgmodi().getIcon());
            migabinetemod.setFoto(imageBytes);
        }

        // Asignar valores al modelo
        migabinetemod.setIdgabinete(idGabineteSeleccionada);
        migabinetemod.setMarca(marca);
        migabinetemod.setModelo(modelo);
        migabinetemod.setPuertousb(puertosusb);
        migabinetemod.setVentiladores(ventilador);
        migabinetemod.setTamanoventilador(tamanoventilador);
        migabinetemod.setFuentepoder(fpoder);
        migabinetemod.setTamanomaxvideo(tmvideo);
        migabinetemod.setPlacamadre(placamadre);
        migabinetemod.setBahias(bahias);
        migabinetemod.setPrecio(precio);
        migabinetemod.setStock(stock);
        migabinetemod.setProveedor(idProveedor);

        // Validar datos antes de modificar
        if (!datosVaciosModi() && migabinetemod.ModificarGabinete() == null) {
            JOptionPane.showMessageDialog(vistamodif, "Gabinete Modificada con Éxito");
        } else {
            JOptionPane.showMessageDialog(vistamodif, "Error al intentar modificar el Gabinete", "Error", JOptionPane.ERROR_MESSAGE);
        }
        listarGabinete();

    }

    private void buscarGabinete() {
        List<Gabinete> listaTarjetagrafica = ModeloGabinete.listaGabinete();
        List<Gabinete> resultado = new ArrayList<>();

        resultado = listaTarjetagrafica.stream()
                .filter(tar -> tar.getIdgabinete() == (Integer.parseInt(vistamodif.getTxtbuscarmodigabi().getText())))
                .collect(Collectors.toList());

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistamodif.getTbGabinetemodi().getModel();
        modelo.setNumRows(0);

        resultado.forEach(tar -> {
            Object[] fila = {
                tar.getIdgabinete(),
                tar.getModelo(),
                tar.getMarca(),
                tar.getPuertousb(),
                tar.getVentiladores(),
                tar.getTamanoventilador(),
                tar.getFuentepoder(),
                tar.getTamanomaxvideo(),
                tar.getPlacamadre(),
                tar.getBahias(),
                tar.getPrecio(),
                tar.getStock(),
                tar.getProveedor()
            };
            modelo.addRow(fila); // Agrega la fila al modelo de la tabla
        });
    }

    private void buscarGabineteElim() {
        List<Gabinete> listaTarjetagrafica = ModeloGabinete.listaGabinete();
        List<Gabinete> resultado = new ArrayList<>();

        resultado = listaTarjetagrafica.stream()
                .filter(tar -> tar.getIdgabinete() == (Integer.parseInt(vistaelim.getTxtbuscareliminargabin().getText())))
                .collect(Collectors.toList());

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistaelim.getTbGabineteelim().getModel();
        modelo.setNumRows(0);

        resultado.forEach(tar -> {
            Object[] fila = {
                tar.getIdgabinete(),
                tar.getModelo(),
                tar.getMarca(),
                tar.getPuertousb(),
                tar.getVentiladores(),
                tar.getTamanoventilador(),
                tar.getFuentepoder(),
                tar.getTamanomaxvideo(),
                tar.getPlacamadre(),
                tar.getBahias(),
                tar.getPrecio(),
                tar.getStock(),
                tar.getProveedor()
            };
            modelo.addRow(fila); // Agrega la fila al modelo de la tabla
        });
    }

    private void listarGabinete() {
        // Logica cargar tarjetas
        List<Gabinete> listap = ModeloGabinete.listaGabinete();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) vistamodif.getTbGabinetemodi().getModel();
        mTabla.setNumRows(0); // Limpio la tabla
        listap.stream().forEach(tar -> {
            String[] rowData = {String.valueOf(tar.getIdgabinete()), tar.getMarca(), tar.getModelo(), tar.getPuertousb(), tar.getVentiladores(), String.valueOf(tar.getTamanoventilador()), tar.getFuentepoder(), String.valueOf(tar.getTamanomaxvideo()), tar.getPlacamadre(), tar.getBahias(), String.valueOf(tar.getPrecio()), String.valueOf(tar.getStock()), String.valueOf(tar.getProveedor())
            };
            mTabla.addRow(rowData);
        });
    }

    private void listarGabineteselim() {
        // Logica cargar tarjetas
        List<Gabinete> listagab = ModeloGabinete.listaGabinete();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) vistaelim.getTbGabineteelim().getModel();
        mTabla.setNumRows(0); // Limpio la tabla
        listagab.stream().forEach(tar -> {
            String[] rowData = {String.valueOf(tar.getIdgabinete()), tar.getMarca(), tar.getModelo(), tar.getPuertousb(), tar.getVentiladores(), String.valueOf(tar.getTamanoventilador()), tar.getFuentepoder(), String.valueOf(tar.getTamanomaxvideo()), tar.getPlacamadre(), tar.getBahias(), String.valueOf(tar.getPrecio()), String.valueOf(tar.getStock()), String.valueOf(tar.getProveedor())
            };
            mTabla.addRow(rowData);
        });
    }

    private void eliminarGabinetes() {
// Obtener la fila seleccionada
        int fila = vistaelim.getTbGabineteelim().getSelectedRow();

        // Verificar si hay una fila seleccionada
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaelim, "Seleccione una Tarjeta Gráfica antes de eliminar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Obtener la ID de la Tarjeta Gráfica seleccionada
        int id = obtenerIdGabineteEliminarSeleccionadaEnFila(fila);

        // Preguntar si está seguro de eliminar
        int opcion = JOptionPane.showConfirmDialog(vistaelim, "¿Está seguro de eliminar la Tarjeta Gráfica seleccionada?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            // Realizar la eliminación
            if (modelo.eliminarGabinete(String.valueOf(id)) == null) {
                JOptionPane.showMessageDialog(vistaelim, "Tarjeta eliminada correctamente");
                // Limpiar la imagen en lbimagentarjelim
                vistaelim.getLbimagengabinelim().setIcon(null);
                // Actualizar la tabla después de la eliminación
                listarGabineteselim();
            }
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

    private void abrefotoModificar() {
        System.out.println("Método abreFileModificar ejecutado");
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);

//        int resultado = fileChooser.showOpenDialog(vistamodif);
        if (fileChooser.showOpenDialog(vistamodif) == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            rutamod = archivoSeleccionado.getAbsolutePath();

            ImageIcon imagenIcon = new ImageIcon(rutamod);
            vistamodif.getLbgabineteimgmodi().setIcon(new ImageIcon(imagenIcon.getImage().getScaledInstance(
                    vistamodif.getLbgabineteimgmodi().getWidth(), vistamodif.getLbgabineteimgmodi().getHeight(), Image.SCALE_SMOOTH)));
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

    public void cargarCodigosProveedorComboBoxmodi() {
        try {
            ArrayList<Integer> codigosProveedor = ModeloGabinete.obtenerCodigosProveedor();

            vistamodif.getCbproveedormodigabin().removeAllItems();

            for (Integer idProveedor : codigosProveedor) {
                vistamodif.getCbproveedormodigabin().addItem(String.valueOf(idProveedor));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean datosVaciosModi() {
        try {
            // Obtener los valores de los atributos
            int maximoram = Integer.parseInt(vistamodif.getSptamamodigabin().getValue().toString());
            int TMvideo = Integer.parseInt(vistamodif.getSpTMvideomodigabin().getValue().toString());
            Double precio = Double.parseDouble(vistamodif.getTxtpreciomodigabin().getText());
            int stock = Integer.parseInt(vistamodif.getTxtstockmodigabin().getText());

            // Obtener los valores de los atributos de texto
            String idgabinete = vistamodif.getLbIdmodigabinete().getText();
            String marca = vistamodif.getTxtmarcamodigabinete().getText();
            String modelo = vistamodif.getTxtmodelomodigabinete().getText();
            String puertosusb = vistamodif.getTxtpuertomodigabinete().getText();
            String ventiladores = vistamodif.getTxtventiiladormodigabinete().getText();
            String Fpoder = vistamodif.getTxtFpodermodigabin().getText();
            String placam = vistamodif.getTxtplacamodigabin().getText();
            String bahias = vistamodif.getTxtbahiasmodigabin().getText();
            String proveedor = (String) vistamodif.getCbproveedormodigabin().getSelectedItem();

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

    private int obtenerIdGabineteSeleccionada() {
        try {
            String idGanineteStr = vistamodif.getLbIdmodigabinete().getText();
            if (!idGanineteStr.isEmpty()) {
                return Integer.parseInt(idGanineteStr);
            } else {
                JOptionPane.showMessageDialog(vistamodif, "No se ha seleccionado ningun Gabinete", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return -1; // Otra opción podría ser lanzar una excepción
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vistamodif, "ID de Gabinete inválido", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return -1; // Otra opción podría ser lanzar una excepción
        }
    }

    private int obtenerIdGabineteSeleccionadaEnFila(int filaSeleccionada) {
        try {
            // Obtener la ID de la tarjeta de la columna 0 (la primera columna) de la fila seleccionada
            int fila = Integer.parseInt(String.valueOf(vistamodif.getTbGabinetemodi().getValueAt(filaSeleccionada, 0)));
            return fila;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vistamodif, "ID de Gabinete inválido en la fila seleccionada", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return -1; // Otra opción podría ser lanzar una excepción
        }
    }

    private int obtenerIdGabineteEliminarSeleccionadaEnFila(int filaSeleccionada) {
        try {
            // Obtener la ID de la tarjeta de la columna 0 (la primera columna) de la fila seleccionada
            return Integer.parseInt(vistaelim.getTbGabineteelim().getValueAt(filaSeleccionada, 0).toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vistaelim, "ID de Gabinete inválido en la fila seleccionada", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return -1; // Otra opción podría ser lanzar una excepción
        }
    }

    private Gabinete obtenerGabinetePorId(int idgabinete) {
        List<Gabinete> listagabinetes = ModeloGabinete.listaGabinete();

        for (Gabinete gabinete : listagabinetes) {
            if (gabinete.getIdgabinete() == idgabinete) {
                return gabinete;
            }
        }
        return null;
    }

    private void cargarDatosEnComponentesModificar(int filaSeleccionada) {
        if (filaSeleccionada != -1) {
            // Obtener la ID de la Tarjeta Gráfica seleccionada
            int idgabinete = obtenerIdGabineteSeleccionadaEnFila(filaSeleccionada);

            // Obtener la tarjeta correspondiente a la ID
            Gabinete gabinete = obtenerGabinetePorId(idgabinete);

            // Verificar si la tarjeta se encontró
            if (gabinete != null) {
                // Cargar los datos en los componentes de modificación
                vistamodif.getLbIdmodigabinete().setText(String.valueOf(gabinete.getIdgabinete()));
                vistamodif.getTxtmarcamodigabinete().setText(gabinete.getMarca());
                vistamodif.getTxtmodelomodigabinete().setText(gabinete.getModelo());
                vistamodif.getTxtpuertomodigabinete().setText(gabinete.getPuertousb());
                vistamodif.getTxtventiiladormodigabinete().setText(gabinete.getVentiladores());
                vistamodif.getSptamamodigabin().setValue(gabinete.getTamanoventilador());
                vistamodif.getTxtFpodermodigabin().setText(gabinete.getFuentepoder());
                vistamodif.getSpTMvideomodigabin().setValue(gabinete.getTamanomaxvideo());
                vistamodif.getTxtplacamodigabin().setText(gabinete.getPlacamadre());
                vistamodif.getTxtbahiasmodigabin().setText(gabinete.getBahias());
                vistamodif.getTxtpreciomodigabin().setText(String.valueOf(gabinete.getPrecio()));
                vistamodif.getTxtstockmodigabin().setText(String.valueOf(gabinete.getStock()));
                vistamodif.getCbproveedormodigabin().setSelectedItem(String.valueOf(gabinete.getProveedor()));

                // Cargar la imagen
                if (gabinete.getFoto() != null) {
                    ImageIcon imagenIcon = new ImageIcon(gabinete.getFoto());
                    vistamodif.getLbgabineteimgmodi().setIcon(new ImageIcon(imagenIcon.getImage().getScaledInstance(
                            vistamodif.getLbgabineteimgmodi().getWidth(), vistamodif.getLbgabineteimgmodi().getHeight(), Image.SCALE_SMOOTH)));
                } else {
                    // Si no hay imagen, limpiar el icono
                    vistamodif.getLbgabineteimgmodi().setIcon(null);
                }
            }
        }
    }

    private byte[] icono_a_Bytes(Icon icon) {
        BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bufferedImage.getGraphics();
        icon.paintIcon(null, g, 0, 0);
        g.dispose();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return byteArrayOutputStream.toByteArray();

    }

    private void cargarImagenEliminar(int filaSeleccionada) {
        if (filaSeleccionada != -1) {
            // Obtener la ID de la Tarjeta Gráfica seleccionada
            int idGabineteSeleccionada = obtenerIdGabineteEliminarSeleccionadaEnFila(filaSeleccionada);

            // Obtener la tarjeta correspondiente a la ID
            Gabinete gabineteSeleccionada = obtenerGabinetePorId(idGabineteSeleccionada);

            // Cargar la imagen en lbimagentarjelim
            if (gabineteSeleccionada != null && gabineteSeleccionada.getFoto() != null) {
                ImageIcon imagenIcon = new ImageIcon(gabineteSeleccionada.getFoto());
                vistaelim.getLbimagengabinelim().setIcon(new ImageIcon(imagenIcon.getImage().getScaledInstance(
                        vistaelim.getLbimagengabinelim().getWidth(), vistaelim.getLbimagengabinelim().getHeight(), Image.SCALE_SMOOTH)));
            } else {
                // Si no hay imagen, limpiar el icono
                vistaelim.getLbimagengabinelim().setIcon(null);
            }
        }
    }

    private void limpiarCamposAgregar() {
        // Limpiar campos de la vista después de la modificación
        vistacrea.getTxtmarcacrergabinete().setText("");
        vistacrea.getTxtmodelocreagabinete().setText("");
        vistacrea.getTxtpuertocreagabinete().setText("");
        vistacrea.getTxtventiiladorcreagabinete().setText("");
        vistacrea.getSptamacreagabin().setValue(0);
        vistacrea.getTxtFpodercreagabin().setText("");
        vistacrea.getSpTMvideocreagabin().setValue(0);
        vistacrea.getTxtplacacreagabin().setText("");
        vistacrea.getTxtbahiascreagabin().setText("");
        vistacrea.getTxtpreciocreagabin().setText("");
        vistacrea.getTxtstockcreagabin().setText("");
        vistacrea.getCbproveedorcreagabin().setSelectedIndex(0);
        vistacrea.getLbgabineteimg().setIcon(null);
        cargaID();
    }

    private void botonAtras() {
        CRUD_Productos_JB vista = new CRUD_Productos_JB();
        CRUD_ProductosJB cProductosJB = new CRUD_ProductosJB(vista);
        cProductosJB.iniciar();
    }
}
