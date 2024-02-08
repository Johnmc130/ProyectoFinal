package Controlador;

import Clases.Placamadre;
import Vista.CrearPlacaMadre;
import Vista.ModificarPlacaMadre;
import Vista.EliminarPlacaMadre;
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
import Modelo.ModeloPlacaMadre;

public class ControladorPlacaMadre {

    private ModeloPlacaMadre modelo;
    private CrearPlacaMadre vistacrea;
    private ModificarPlacaMadre vistamodif;
    private EliminarPlacaMadre vistaelim;
    ModeloPlacaMadre miplaca = new ModeloPlacaMadre();
    ModeloPlacaMadre miplacamod = new ModeloPlacaMadre();
    private String ruta;
    private String rutamod;

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
        cargarCodigosProveedorComboBoxmodi();
        listarPlacaMadre();
        iniciaControlModificar();

        vistamodif.getBtncargaplaca().addActionListener(l -> abrefotoModificar());
        vistamodif.getBtnModificarPlaca().addActionListener(e -> modificarPlacamadre());
    }

    // Constructor para la eliminación
    public ControladorPlacaMadre(ModeloPlacaMadre modelo, EliminarPlacaMadre vista) {
        this.modelo = modelo;
        this.vistaelim = vista;
        vista.setVisible(true);
        listarPlacaMadreelim();
        iniciaControlEliminar();

        vistaelim.getBtnEliminarplaca().addActionListener(l -> eliminarPlacaMadre());
    }

    public void iniciaControl(String vista) {
        vistacrea.getBtnCrearplacam().addActionListener(l -> grabarPlaca());
        // PasaDatos y CargaImagenes
        vistacrea.getBtncargaplaca().addActionListener(l -> abreFile());
        // GeneraID
        cargaID();

    }

    public void iniciaControlModificar() {
        vistamodif.getBtnBuscarmodiplaca().addActionListener(l -> buscarPlaca());

        // Agregar el listener para la selección de fila en la tabla
        vistamodif.getTbPlacasmodi().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Obtener la fila seleccionada
                int filaSeleccionada = vistamodif.getTbPlacasmodi().getSelectedRow();

                // Cargar los datos de la fila en los componentes de modificación
                cargarDatosEnComponentesModificar(filaSeleccionada);
            }
        });

        cargarCodigosProveedorComboBoxmodi();
    }

    // Métodos de inicialización y eventos para la eliminación
    public void iniciaControlEliminar() {
        vistaelim.getBtnBuscarelimplaca().addActionListener(l -> buscarPlacaElim());

        // Agregar el listener para la selección de fila en la tabla
        vistaelim.getTbPlacaMelim().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Obtener la fila seleccionada
                int filaSeleccionada = vistaelim.getTbPlacaMelim().getSelectedRow();

                // Cargar la imagen en lbimagentarjelim
                cargarImagenEliminar(filaSeleccionada);
            }
        });
    }

    private void grabarPlaca() {
        // Obtener valores de los campos
        int idplacam = Integer.parseInt(vistacrea.getLbIdcreaplaca().getText());
        String marca = vistacrea.getTxtmarcacreaplaca().getText();
        String modelo = vistacrea.getTxtmodelocreaplaca().getText();
        String puertosalmacena = vistacrea.getTxtpuertosalma().getText();
        String puertosusb = vistacrea.getTxtpuertosusb().getText();
        String socket = vistacrea.getTxtsocketcreaplaca().getText();
        String tiporam = vistacrea.getTxttiporamcreaplaca().getText();
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

    private void modificarPlacamadre() {
        // Obtener la ID de la Tarjeta Gráfica seleccionada
        int idPlacaSeleccionada = obtenerIdPlacaMarSeleccionada();
        if (idPlacaSeleccionada == -1) {
            return;
        }

        // Obtener valores de los campos de la vista
        int idplacam = Integer.parseInt(vistamodif.getLbIdcreaplaca().getText());
        String marca = vistamodif.getTxtmarcacreaplaca().getText();
        String modelo = vistamodif.getTxtmodelocreaplaca().getText();
        String puertosalmacena = vistamodif.getTxtpuertosalma().getText();
        String puertosusb = vistamodif.getTxtpuertosusb().getText();
        String socket = vistamodif.getTxtsocketcreaplaca().getText();
        String tiporam = vistamodif.getTxttiporammodiplaca().getText();
        int maximoram = (Integer) vistamodif.getSpMaximoramplaca().getValue();
        String ranuras = vistamodif.getTxtranuraexpcreaplaca().getText();
        String formato = vistamodif.getTxtformatocreaplaca2().getText();
        int watts = (Integer) vistamodif.getSpwattsramplaca().getValue();
        double precio = Double.parseDouble(vistamodif.getTxtpreciocreaplaca().getText());
        int stock = Integer.parseInt(vistamodif.getTxtstockcreaplaca().getText());
        int idProveedor = Integer.valueOf(vistamodif.getCbproveedorplaca().getSelectedItem().toString());

// Verificar si se seleccionó una nueva imagen
        if (rutamod != null && !rutamod.isEmpty()) {
            byte[] imgTarjeta = GuardaImagen(rutamod);
            miplacamod.setFoto(imgTarjeta);
        } else {
            // Si no se seleccionó una nueva imagen, obtener la imagen actual
            byte[] imageBytes = icono_a_Bytes(vistamodif.getLbplacaimg().getIcon());
            miplacamod.setFoto(imageBytes);
        }

        // Asignar valores al modelo
        miplacamod.setIdplacam(idPlacaSeleccionada);
        miplacamod.setMarca(marca);
        miplacamod.setModelo(modelo);
        miplacamod.setPuertosalmacenamiento(puertosalmacena);
        miplacamod.setPuertosusb(puertosusb);
        miplacamod.setSocket(socket);
        miplacamod.setTiposram(tiporam);
        miplacamod.setMaximoram(maximoram);
        miplacamod.setRanuraexpansion(ranuras);
        miplacamod.setFormato(formato);
        miplacamod.setWatts(watts);
        miplacamod.setPrecio(precio);
        miplacamod.setStock(stock);
        miplacamod.setProveedor(idProveedor);

        // Validar datos antes de modificar
        if (!datosVaciosModi() && miplacamod.ModificarPlacamadre() == null) {
            JOptionPane.showMessageDialog(vistamodif, "Placa Madre Modificada con Éxito");
        } else {
            JOptionPane.showMessageDialog(vistamodif, "Error al intentar modificar la Placa Madre", "Error", JOptionPane.ERROR_MESSAGE);
        }
        listarPlacaMadre();

    }

    private void buscarPlaca() {
        List<Placamadre> listaTarjetagrafica = ModeloPlacaMadre.listaPlacaMadre();
        List<Placamadre> resultado = new ArrayList<>();

        resultado = listaTarjetagrafica.stream()
                .filter(tar -> tar.getIdplacam() == (Integer.parseInt(vistamodif.getTxtbuscarmodiplacas().getText())))
                .collect(Collectors.toList());

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistamodif.getTbPlacasmodi().getModel();
        modelo.setNumRows(0);

        resultado.forEach(tar -> {
            Object[] fila = {
                tar.getIdplacam(),
                tar.getModelo(),
                tar.getMarca(),
                tar.getPuertosalmacenamiento(),
                tar.getPuertosusb(),
                tar.getSocket(),
                tar.getTiposram(),
                tar.getMaximoram(),
                tar.getRanuraexpansion(),
                tar.getFormato(),
                tar.getWatts(),
                tar.getPrecio(),
                tar.getStock(),
                tar.getProveedor()
            };
            modelo.addRow(fila); // Agrega la fila al modelo de la tabla
        });
    }

    private void buscarPlacaElim() {
        List<Placamadre> listaTarjetagrafica = ModeloPlacaMadre.listaPlacaMadre();
        List<Placamadre> resultado = new ArrayList<>();

        resultado = listaTarjetagrafica.stream()
                .filter(tar -> tar.getIdplacam() == (Integer.parseInt(vistamodif.getTxtbuscarmodiplacas().getText())))
                .collect(Collectors.toList());

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistamodif.getTbPlacasmodi().getModel();
        modelo.setNumRows(0);

        resultado.forEach(tar -> {
            Object[] fila = {
                tar.getIdplacam(),
                tar.getModelo(),
                tar.getMarca(),
                tar.getPuertosalmacenamiento(),
                tar.getPuertosusb(),
                tar.getSocket(),
                tar.getTiposram(),
                tar.getMaximoram(),
                tar.getRanuraexpansion(),
                tar.getFormato(),
                tar.getWatts(),
                tar.getPrecio(),
                tar.getStock(),
                tar.getProveedor()
            };
            modelo.addRow(fila); // Agrega la fila al modelo de la tabla
        });
    }

    private void listarPlacaMadre() {
        // Logica cargar tarjetas
        List<Placamadre> listap = ModeloPlacaMadre.listaPlacaMadre();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) vistamodif.getTbPlacasmodi().getModel();
        mTabla.setNumRows(0); // Limpio la tabla
        listap.stream().forEach(tar -> {
            String[] rowData = {String.valueOf(tar.getIdplacam()), tar.getMarca(), tar.getModelo(), tar.getPuertosalmacenamiento(), tar.getPuertosusb(), tar.getSocket(), tar.getTiposram(), String.valueOf(tar.getMaximoram()), tar.getRanuraexpansion(), tar.getFormato(), String.valueOf(tar.getWatts()), String.valueOf(tar.getPrecio()), String.valueOf(tar.getStock()), String.valueOf(tar.getProveedor())
            };
            mTabla.addRow(rowData);
        });
    }

    private void listarPlacaMadreelim() {
        // Logica cargar tarjetas
        List<Placamadre> listagab = ModeloPlacaMadre.listaPlacaMadre();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) vistaelim.getTbPlacaMelim().getModel();
        mTabla.setNumRows(0); // Limpio la tabla
        listagab.stream().forEach(tar -> {
            String[] rowData = {String.valueOf(tar.getIdplacam()), tar.getMarca(), tar.getModelo(), tar.getPuertosalmacenamiento(), tar.getPuertosusb(), tar.getSocket(), tar.getTiposram(), String.valueOf(tar.getMaximoram()), tar.getRanuraexpansion(), tar.getFormato(), String.valueOf(tar.getWatts()), String.valueOf(tar.getPrecio()), String.valueOf(tar.getStock()), String.valueOf(tar.getProveedor())
            };
            mTabla.addRow(rowData);
        });
    }

    private void eliminarPlacaMadre() {
// Obtener la fila seleccionada
        int fila = vistaelim.getTbPlacaMelim().getSelectedRow();

        // Verificar si hay una fila seleccionada
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaelim, "Seleccione una Tarjeta Gráfica antes de eliminar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Obtener la ID de la Tarjeta Gráfica seleccionada
        int id = obtenerIdPlacaEliminarSeleccionadaEnFila(fila);

        // Preguntar si está seguro de eliminar
        int opcion = JOptionPane.showConfirmDialog(vistaelim, "¿Está seguro de eliminar la Tarjeta Gráfica seleccionada?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            // Realizar la eliminación
            if (modelo.eliminarPlacaMadre(String.valueOf(id)) == null) {
                JOptionPane.showMessageDialog(vistaelim, "Tarjeta eliminada correctamente");
                // Limpiar la imagen en lbimagentarjelim
                vistaelim.getLbplacaimgelim().setIcon(null);
                // Actualizar la tabla después de la eliminación
                listarPlacaMadreelim();
            }
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
            vistamodif.getLbplacaimg().setIcon(new ImageIcon(imagenIcon.getImage().getScaledInstance(
                    vistamodif.getLbplacaimg().getWidth(), vistamodif.getLbplacaimg().getHeight(), Image.SCALE_SMOOTH)));
        }
    }

    public boolean datosVacios() {
        try {
            // Obtener los valores de los atributos
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
            String tiporam = vistacrea.getTxttiporamcreaplaca().getText();

            // Validar campos numéricos
            if (maximoram < 0 || watts < 0 || precio < 0 || stock < 0) {
                JOptionPane.showMessageDialog(null, "Los campos numéricos no pueden ser negativos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return true;
            }

            // Validar campos de texto
            if (idplacam.isEmpty() || marca.isEmpty() || modelo.isEmpty() || puertosalma.isEmpty() || puertosUSB.isEmpty()
                    || socket.isEmpty() || tiporam.isEmpty() || ranurasexp.isEmpty() || formato.isEmpty()) {
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

    public void cargarCodigosProveedorComboBoxmodi() {
        try {
            ArrayList<Integer> codigosProveedor = ModeloPlacaMadre.obtenerCodigosProveedor();

            vistamodif.getCbproveedorplaca().removeAllItems();

            for (Integer idProveedor : codigosProveedor) {
                vistamodif.getCbproveedorplaca().addItem(String.valueOf(idProveedor));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean datosVaciosModi() {
        try {
            // Obtener los valores de los atributos
            int maximoram = Integer.parseInt(vistamodif.getSpMaximoramplaca().getValue().toString());
            int watts = Integer.parseInt(vistamodif.getSpwattsramplaca().getValue().toString());
            Double precio = Double.parseDouble(vistamodif.getTxtpreciocreaplaca().getText());
            int stock = Integer.parseInt(vistamodif.getTxtstockcreaplaca().getText());

            // Obtener los valores de los atributos de texto
            String idplacam = vistamodif.getLbIdcreaplaca().getText();
            String marca = vistamodif.getTxtmarcacreaplaca().getText();
            String modelo = vistamodif.getTxtmodelocreaplaca().getText();
            String puertosalma = vistamodif.getTxtpuertosalma().getText();
            String puertosUSB = vistamodif.getTxtpuertosusb().getText();
            String socket = vistamodif.getTxtsocketcreaplaca().getText();
            String ranurasexp = vistamodif.getTxtranuraexpcreaplaca().getText();
            String formato = vistamodif.getTxtformatocreaplaca2().getText();
            String proveedor = (String) vistamodif.getCbproveedorplaca().getSelectedItem();
            String tiporam = vistamodif.getTxttiporammodiplaca().getText();

            // Validar campos numéricos
            if (maximoram < 0 || watts < 0 || precio < 0 || stock < 0) {
                JOptionPane.showMessageDialog(null, "Los campos numéricos no pueden ser negativos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return true;
            }

            // Validar campos de texto
            if (idplacam.isEmpty() || marca.isEmpty() || modelo.isEmpty() || puertosalma.isEmpty() || puertosUSB.isEmpty()
                    || socket.isEmpty() || tiporam.isEmpty() || ranurasexp.isEmpty() || formato.isEmpty()) {
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

    private int obtenerIdPlacaMarSeleccionada() {
        try {
            String idGanineteStr = vistamodif.getLbIdcreaplaca().getText();
            if (!idGanineteStr.isEmpty()) {
                return Integer.parseInt(idGanineteStr);
            } else {
                JOptionPane.showMessageDialog(vistamodif, "No se ha seleccionado ningun Placa Madre", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return -1; // Otra opción podría ser lanzar una excepción
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vistamodif, "ID de Placa Madre inválido", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return -1; // Otra opción podría ser lanzar una excepción
        }
    }

    private int obtenerIdPlacaSeleccionadaEnFila(int filaSeleccionada) {
        try {
            // Obtener la ID de la tarjeta de la columna 0 (la primera columna) de la fila seleccionada
            int fila = Integer.parseInt(String.valueOf(vistamodif.getTbPlacasmodi().getValueAt(filaSeleccionada, 0)));
            return fila;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vistamodif, "ID de Placa Madre inválido en la fila seleccionada", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return -1; // Otra opción podría ser lanzar una excepción
        }
    }

    private int obtenerIdPlacaEliminarSeleccionadaEnFila(int filaSeleccionada) {
        try {
            // Obtener la ID de la tarjeta de la columna 0 (la primera columna) de la fila seleccionada
            return Integer.parseInt(vistaelim.getTbPlacaMelim().getValueAt(filaSeleccionada, 0).toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vistaelim, "ID de Gabinete inválido en la fila seleccionada", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return -1; // Otra opción podría ser lanzar una excepción
        }
    }

    private Placamadre obtenerPlacaPorId(int idplaca) {
        List<Placamadre> listaplacas = ModeloPlacaMadre.listaPlacaMadre();

        for (Placamadre placam : listaplacas) {
            if (placam.getIdplacam() == idplaca) {
                return placam;
            }
        }
        return null;
    }

    private void cargarDatosEnComponentesModificar(int filaSeleccionada) {
        if (filaSeleccionada != -1) {
            // Obtener la ID de la Tarjeta Gráfica seleccionada
            int idplaca = obtenerIdPlacaSeleccionadaEnFila(filaSeleccionada);

            // Obtener la tarjeta correspondiente a la ID
            Placamadre placamadre = obtenerPlacaPorId(idplaca);

            // Verificar si la tarjeta se encontró
            if (placamadre != null) {
                // Cargar los datos en los componentes de modificación
                vistamodif.getLbIdcreaplaca().setText(String.valueOf(placamadre.getIdplacam()));
                vistamodif.getTxtmarcacreaplaca().setText(placamadre.getMarca());
                vistamodif.getTxtmodelocreaplaca().setText(placamadre.getModelo());
                vistamodif.getTxtpuertosalma().setText(placamadre.getPuertosalmacenamiento());
                vistamodif.getTxtpuertosusb().setText(placamadre.getPuertosusb());
                vistamodif.getTxtsocketcreaplaca().setText(placamadre.getSocket());
                vistamodif.getTxttiporammodiplaca().setText(placamadre.getTiposram());
                vistamodif.getSpMaximoramplaca().setValue(placamadre.getMaximoram());
                vistamodif.getTxtranuraexpcreaplaca().setText(placamadre.getRanuraexpansion());
                vistamodif.getTxtformatocreaplaca2().setText(placamadre.getFormato());
                vistamodif.getSpwattsramplaca().setValue(placamadre.getWatts());
                vistamodif.getTxtpreciocreaplaca().setText(String.valueOf(placamadre.getPrecio()));
                vistamodif.getTxtstockcreaplaca().setText(String.valueOf(placamadre.getStock()));
                vistamodif.getCbproveedorplaca().setSelectedItem(String.valueOf(placamadre.getProveedor()));

                // Cargar la imagen
                if (placamadre.getFoto() != null) {
                    ImageIcon imagenIcon = new ImageIcon(placamadre.getFoto());
                    vistamodif.getLbplacaimg().setIcon(new ImageIcon(imagenIcon.getImage().getScaledInstance(
                            vistamodif.getLbplacaimg().getWidth(), vistamodif.getLbplacaimg().getHeight(), Image.SCALE_SMOOTH)));
                } else {
                    // Si no hay imagen, limpiar el icono
                    vistamodif.getLbplacaimg().setIcon(null);
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
            int idGabineteSeleccionada = obtenerIdPlacaEliminarSeleccionadaEnFila(filaSeleccionada);

            // Obtener la tarjeta correspondiente a la ID
            Placamadre gabineteSeleccionada = obtenerPlacaPorId(idGabineteSeleccionada);

            // Cargar la imagen en lbimagentarjelim
            if (gabineteSeleccionada != null && gabineteSeleccionada.getFoto() != null) {
                ImageIcon imagenIcon = new ImageIcon(gabineteSeleccionada.getFoto());
                vistaelim.getLbplacaimgelim().setIcon(new ImageIcon(imagenIcon.getImage().getScaledInstance(
                        vistaelim.getLbplacaimgelim().getWidth(), vistaelim.getLbplacaimgelim().getHeight(), Image.SCALE_SMOOTH)));
            } else {
                // Si no hay imagen, limpiar el icono
                vistaelim.getLbplacaimgelim().setIcon(null);
            }
        }
    }

    private void limpiarCamposAgregar() {
        // Limpiar campos de la vista después de la modificación
        vistacrea.getTxtmarcacreaplaca().setText("");
        vistacrea.getTxtmodelocreaplaca().setText("");
        vistacrea.getTxtpuertosalma().setText("");
        vistacrea.getTxtpuertosusb().setText("");
        vistacrea.getTxtsocketcreaplaca().setText("");
        vistacrea.getTxttiporamcreaplaca().setText("");
        vistacrea.getSpMaximoramplaca().setValue(0);
        vistacrea.getTxtranuraexpcreaplaca().setText("");
        vistacrea.getTxtformatocreaplaca2().setText("");
        vistacrea.getSpwattsramplaca().setValue(0);
        vistacrea.getTxtpreciocreaplaca().setText("");
        vistacrea.getTxtstockcreaplaca().setText("");
        vistacrea.getCbproveedorplaca().setSelectedIndex(0);
        vistacrea.getLbplacaimg().setIcon(null);
        cargaID();
    }
}
