package Controlador;

import Clases.Procesador;
import Vista.CrearProcesador;
import Vista.EliminarProcesador;
import Vista.ModificarProcesador;
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
import Modelo.ModeloProcesador;

/**
 *
 * @author MAX COMPUTERS
 */
public class ControladorProcesador {

    private ModeloProcesador modelo;
    private CrearProcesador vistacrea;
    private ModificarProcesador vistamodif;
    private EliminarProcesador vistaelim;
    ModeloProcesador miplaca = new ModeloProcesador();
    ModeloProcesador miplacamod = new ModeloProcesador();
    private String ruta;
    private String rutamod;

    public ControladorProcesador(ModeloProcesador modelo, CrearProcesador vista) {
        this.modelo = modelo;
        this.vistacrea = vista;
        vista.setVisible(true);
        cargarCodigosProveedorComboBox();
    }

    // Constructor para la modificación
    public ControladorProcesador(ModeloProcesador modelo, ModificarProcesador vista) {
        this.modelo = modelo;
        this.vistamodif = vista;
        vista.setVisible(true);
        cargarCodigosProveedorComboBoxmodi();
        listarProcesadores();
        iniciaControlModificar();

        vistamodif.getBtnCargarImgmodiproc().addActionListener(l -> abrefotoModificar());
        vistamodif.getBtnModificarproc().addActionListener(e -> modificarProcesador());
    }

    // Constructor para la eliminación
    public ControladorProcesador(ModeloProcesador modelo, EliminarProcesador vista) {
        this.modelo = modelo;
        this.vistaelim = vista;
        vista.setVisible(true);
        listarProcesadorelim();
        iniciaControlEliminar();

        vistaelim.getBtnEliminarproc().addActionListener(l -> eliminarProcesador());
    }

    public void iniciaControl() {
        vistacrea.getBtnCrearproc().addActionListener(l -> grabarProcesador());
        // PasaDatos y CargaImagenes
        vistacrea.getBtncagaprocesa().addActionListener(l -> abreFile());
        // GeneraID
        cargaID();

    }

    public void iniciaControlModificar() {
        vistamodif.getBtnBuscarproc().addActionListener(l -> buscarProcesador());

        // Agregar el listener para la selección de fila en la tabla
        vistamodif.getTbprocesadores().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Obtener la fila seleccionada
                int filaSeleccionada = vistamodif.getTbprocesadores().getSelectedRow();

                // Cargar los datos de la fila en los componentes de modificación
                cargarDatosEnComponentesModificar(filaSeleccionada);
            }
        });

        cargarCodigosProveedorComboBoxmodi();
    }

    // Métodos de inicialización y eventos para la eliminación
    public void iniciaControlEliminar() {
        vistaelim.getBtnBuscareliminarproc().addActionListener(l -> buscarProcesadorElim());

        // Agregar el listener para la selección de fila en la tabla
        vistaelim.getTbProcesadoreselim().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Obtener la fila seleccionada
                int filaSeleccionada = vistaelim.getTbProcesadoreselim().getSelectedRow();

                // Cargar la imagen en lbimagentarjelim
                cargarImagenEliminar(filaSeleccionada);
            }
        });
    }

    private void grabarProcesador() {
        // Obtener valores de los campos
        int idplacam = Integer.parseInt(vistacrea.getLbIdcreaproc().getText());
        String marca = vistacrea.getTxtmarcacreaproc().getText();
        String modelo = vistacrea.getTxtmodelocreaproc().getText();
        int nucleosfisicos = (Integer) vistacrea.getSpnucleoscreaproc().getValue();
        double ghz = Double.parseDouble(vistacrea.getTxtghzcreaproc().getText());
        String socket = vistacrea.getTxtsocketcreaproc().getText();
        int maximoram = (Integer) vistacrea.getSpRamcreaproc().getValue();
        int watts = (Integer) vistacrea.getSpWattscreaproc().getValue();
        double precio = Double.parseDouble(vistacrea.getTxtpreciocreaproc().getText());
        int stock = Integer.parseInt(vistacrea.getTxtStockcreaproc().getText());
        int idProveedor = Integer.valueOf(vistacrea.getCbproveedorcreaproc().getSelectedItem().toString());

        // Verificar si se seleccionó una imagen
        if (ruta.isEmpty()) {
            JOptionPane.showMessageDialog(vistacrea, "Seleccione una imagen antes de guardar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Convertir ruta de la imagen a bytes
        byte[] imgplaca = GuardaImagen(ruta);

        // Asignar valores al modelo
        miplaca.setIdProcesador(idplacam);
        miplaca.setMarca(marca);
        miplaca.setModelo(modelo);
        miplaca.setNucleosFisicos(nucleosfisicos);
        miplaca.setGhz(ghz);
        miplaca.setSocket(socket);
        miplaca.setMaximoVram(maximoram);
        miplaca.setWatts(watts);
        miplaca.setPrecio(precio);
        miplaca.setStock(stock);
        miplaca.setIdProveedor(idProveedor);
        miplaca.setImagen(imgplaca);

        // Validar datos antes de guardar
        if (!datosVacios() && miplaca.grabarProcesador()) {
            JOptionPane.showMessageDialog(vistacrea, "Procesador Agregado con Éxito");
        } else {
            JOptionPane.showMessageDialog(vistacrea, "Error al intentar agregar el Procesador", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificarProcesador() {
        // Obtener la ID de la Tarjeta Gráfica seleccionada
        int idProcesadorSeleccionada = obtenerIdProcesadorSeleccionada();
        if (idProcesadorSeleccionada == -1) {
            return;
        }

        // Obtener valores de los campos de la vista
        String marca = vistamodif.getTxtmarcamodiproc().getText();
        String modelo = vistamodif.getTxtmodelomodiproc().getText();
        int nucleosfisicos = (Integer) vistamodif.getSpnucleosmodiproc().getValue();
        double ghz = Double.parseDouble(vistamodif.getTxtghzmodiproc().getText());
        String socket = vistamodif.getTxtsocketmodiproc().getText();
        int maximoram = (Integer) vistamodif.getSpRammodiproc().getValue();
        int watts = (Integer) vistamodif.getSpWattsmodiproc().getValue();
        double precio = Double.parseDouble(vistamodif.getTxtpreciomodiproc().getText());
        int stock = Integer.parseInt(vistamodif.getTxtstockmodiproc().getText());
        int idProveedor = Integer.valueOf(vistamodif.getCbproveedormodiproc().getSelectedItem().toString());

// Verificar si se seleccionó una nueva imagen
        if (rutamod != null && !rutamod.isEmpty()) {
            byte[] imgTarjeta = GuardaImagen(rutamod);
            miplacamod.setImagen(imgTarjeta);
        } else {
            // Si no se seleccionó una nueva imagen, obtener la imagen actual
            byte[] imageBytes = icono_a_Bytes(vistamodif.getLbimagenproce().getIcon());
            miplacamod.setImagen(imageBytes);
        }

        // Asignar valores al modelo
        miplacamod.setIdProcesador(idProcesadorSeleccionada);
        miplacamod.setMarca(marca);
        miplacamod.setModelo(modelo);
        miplacamod.setNucleosFisicos(nucleosfisicos);
        miplacamod.setGhz(ghz);
        miplacamod.setSocket(socket);
        miplacamod.setMaximoVram(maximoram);
        miplacamod.setWatts(watts);
        miplacamod.setPrecio(precio);
        miplacamod.setStock(stock);
        miplacamod.setIdProveedor(idProveedor);

        // Validar datos antes de modificar
        if (!datosVaciosModi() && miplacamod.ModificarProcesador() == null) {
            JOptionPane.showMessageDialog(vistamodif, "Procesador Modificada con Éxito");
        } else {
            JOptionPane.showMessageDialog(vistamodif, "Error al intentar modificar el Procesador", "Error", JOptionPane.ERROR_MESSAGE);
        }
        listarProcesadores();

    }

    private void buscarProcesador() {
        List<Procesador> listaProcesador = ModeloProcesador.listaProcesador();
        List<Procesador> resultado = new ArrayList<>();

        resultado = listaProcesador.stream()
                .filter(tar -> tar.getIdProcesador() == (Integer.parseInt(vistamodif.getTxtbuscarproc().getText())))
                .collect(Collectors.toList());

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistamodif.getTbprocesadores().getModel();
        modelo.setNumRows(0);

        resultado.forEach(tar -> {
            Object[] fila = {
                tar.getIdProcesador(),
                tar.getModelo(),
                tar.getMarca(),
                tar.getNucleosFisicos(),
                tar.getGhz(),
                tar.getSocket(),
                tar.getMaximoVram(),
                tar.getWatts(),
                tar.getPrecio(),
                tar.getStock(),
                tar.getIdProveedor()
            };
            modelo.addRow(fila); // Agrega la fila al modelo de la tabla
        });
    }

    private void buscarProcesadorElim() {
        List<Procesador> listaProcesador = ModeloProcesador.listaProcesador();
        List<Procesador> resultado = new ArrayList<>();

        resultado = listaProcesador.stream()
                .filter(tar -> tar.getIdProcesador() == (Integer.parseInt(vistaelim.getTxtbuscareliminarproc().getText())))
                .collect(Collectors.toList());

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistaelim.getTbProcesadoreselim().getModel();
        modelo.setNumRows(0);

        resultado.forEach(tar -> {
            Object[] fila = {
                tar.getIdProcesador(),
                tar.getModelo(),
                tar.getMarca(),
                tar.getNucleosFisicos(),
                tar.getGhz(),
                tar.getSocket(),
                tar.getMaximoVram(),
                tar.getWatts(),
                tar.getPrecio(),
                tar.getStock(),
                tar.getIdProveedor()
            };
            modelo.addRow(fila); // Agrega la fila al modelo de la tabla
        });
    }

    private void listarProcesadores() {
        // Logica cargar tarjetas
        List<Procesador> listap = ModeloProcesador.listaProcesador();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) vistamodif.getTbprocesadores().getModel();
        mTabla.setNumRows(0); // Limpio la tabla
        listap.stream().forEach(tar -> {
            String[] rowData = {String.valueOf(tar.getIdProcesador()), tar.getMarca(), tar.getModelo(), String.valueOf(tar.getNucleosFisicos()), String.valueOf(tar.getGhz()), tar.getSocket(), String.valueOf(tar.getMaximoVram()), String.valueOf(tar.getWatts()), String.valueOf(tar.getPrecio()), String.valueOf(tar.getStock()), String.valueOf(tar.getIdProveedor())
            };
            mTabla.addRow(rowData);
        });
    }

    private void listarProcesadorelim() {
        // Logica cargar tarjetas
        List<Procesador> listap = ModeloProcesador.listaProcesador();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) vistaelim.getTbProcesadoreselim().getModel();
        mTabla.setNumRows(0); // Limpio la tabla
        listap.stream().forEach(tar -> {
            String[] rowData = {String.valueOf(tar.getIdProcesador()), tar.getMarca(), tar.getModelo(), String.valueOf(tar.getNucleosFisicos()), String.valueOf(tar.getGhz()), tar.getSocket(), String.valueOf(tar.getMaximoVram()), String.valueOf(tar.getWatts()), String.valueOf(tar.getPrecio()), String.valueOf(tar.getStock()), String.valueOf(tar.getIdProveedor())
            };
            mTabla.addRow(rowData);
        });
    }

    private void eliminarProcesador() {
// Obtener la fila seleccionada
        int fila = vistaelim.getTbProcesadoreselim().getSelectedRow();

        // Verificar si hay una fila seleccionada
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaelim, "Seleccione un Procesador antes de eliminar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Obtener la ID de la Tarjeta Gráfica seleccionada
        int id = obtenerIdPlacaEliminarSeleccionadaEnFila(fila);

        // Preguntar si está seguro de eliminar
        int opcion = JOptionPane.showConfirmDialog(vistaelim, "¿Está seguro de eliminar el Procesador seleccionada?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            // Realizar la eliminación
            if (modelo.eliminarProcesador(String.valueOf(id)) == null) {
                JOptionPane.showMessageDialog(vistaelim, "Procesador eliminada correctamente");
                // Limpiar la imagen en lbimagentarjelim
                vistaelim.getLbimagenproelim().setIcon(null);
                // Actualizar la tabla después de la eliminación
                listarProcesadorelim();
            }
        }

    }

    public void cargarCodigosProveedorComboBox() {
        try {
            ArrayList<Integer> codigosProveedor = ModeloProcesador.obtenerCodigosProveedor();

            vistacrea.getCbproveedorcreaproc().removeAllItems();

            for (Integer idProveedor : codigosProveedor) {
                vistacrea.getCbproveedorcreaproc().addItem(String.valueOf(idProveedor));
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
            vistacrea.getLbprocesadorimg().setIcon(new ImageIcon(imagenIcon.getImage().getScaledInstance(
                    vistacrea.getLbprocesadorimg().getWidth(), vistacrea.getLbprocesadorimg().getHeight(), Image.SCALE_SMOOTH)));
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
            vistamodif.getLbimagenproce().setIcon(new ImageIcon(imagenIcon.getImage().getScaledInstance(
                    vistamodif.getLbimagenproce().getWidth(), vistamodif.getLbimagenproce().getHeight(), Image.SCALE_SMOOTH)));
        }
    }

    public boolean datosVacios() {
        try {
            // Obtener los valores de los atributos
            int maximoram = Integer.parseInt(vistacrea.getSpRamcreaproc().getValue().toString());
            int watts = Integer.parseInt(vistacrea.getSpWattscreaproc().getValue().toString());
            Double precio = Double.parseDouble(vistacrea.getTxtpreciocreaproc().getText());
            int stock = Integer.parseInt(vistacrea.getTxtStockcreaproc().getText());
            int nucleosf = Integer.parseInt(vistacrea.getSpnucleoscreaproc().getValue().toString());
            Double ghz = Double.parseDouble(vistacrea.getTxtghzcreaproc().getText());

            // Obtener los valores de los atributos de texto
            String idplacam = vistacrea.getLbIdcreaproc().getText();
            String marca = vistacrea.getTxtmarcacreaproc().getText();
            String modelo = vistacrea.getTxtmodelocreaproc().getText();
            String socket = vistacrea.getTxtsocketcreaproc().getText();
            String proveedor = (String) vistacrea.getCbproveedorcreaproc().getSelectedItem();

            // Validar campos numéricos
            if (maximoram < 0 || watts < 0 || precio < 0 || stock < 0 || nucleosf < 0 || ghz < 0) {
                JOptionPane.showMessageDialog(null, "Los campos numéricos no pueden ser negativos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return true;
            }

            // Validar campos de texto
            if (idplacam.isEmpty() || marca.isEmpty() || modelo.isEmpty() || socket.isEmpty()) {
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
        vistacrea.getLbIdcreaproc().setText(String.valueOf(modelo.obtenerSiguienteIdProcesador()));
    }

    public void cargarCodigosProveedorComboBoxmodi() {
        try {
            ArrayList<Integer> codigosProveedor = ModeloProcesador.obtenerCodigosProveedor();

            vistamodif.getCbproveedormodiproc().removeAllItems();

            for (Integer idProveedor : codigosProveedor) {
                vistamodif.getCbproveedormodiproc().addItem(String.valueOf(idProveedor));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean datosVaciosModi() {
        try {
            // Obtener los valores de los atributos
            int maximoram = Integer.parseInt(vistamodif.getSpRammodiproc().getValue().toString());
            int watts = Integer.parseInt(vistamodif.getSpWattsmodiproc().getValue().toString());
            Double precio = Double.parseDouble(vistamodif.getTxtpreciomodiproc().getText());
            int stock = Integer.parseInt(vistamodif.getTxtstockmodiproc().getText());
            int nucleosf = Integer.parseInt(vistamodif.getSpnucleosmodiproc().getValue().toString());
            Double ghz = Double.parseDouble(vistamodif.getTxtghzmodiproc().getText());

            // Obtener los valores de los atributos de texto
            String idplacam = vistamodif.getLbIdmodiproc().getText();
            String marca = vistamodif.getTxtmarcamodiproc().getText();
            String modelo = vistamodif.getTxtmodelomodiproc().getText();
            String socket = vistamodif.getTxtsocketmodiproc().getText();
            String proveedor = (String) vistamodif.getCbproveedormodiproc().getSelectedItem();

            // Validar campos numéricos
            if (maximoram < 0 || watts < 0 || precio < 0 || stock < 0 || nucleosf < 0 || ghz < 0) {
                JOptionPane.showMessageDialog(null, "Los campos numéricos no pueden ser negativos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return true;
            }

            // Validar campos de texto
            if (idplacam.isEmpty() || marca.isEmpty() || modelo.isEmpty() || socket.isEmpty()) {
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

    private int obtenerIdProcesadorSeleccionada() {
        try {
            String idProcesadorStr = vistamodif.getLbIdmodiproc().getText();
            if (!idProcesadorStr.isEmpty()) {
                return Integer.parseInt(idProcesadorStr);
            } else {
                JOptionPane.showMessageDialog(vistamodif, "No se ha seleccionado ningun Procesador", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return -1; // Otra opción podría ser lanzar una excepción
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vistamodif, "ID de Procesador inválido", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return -1; // Otra opción podría ser lanzar una excepción
        }
    }

    private int obtenerIdPlacaSeleccionadaEnFila(int filaSeleccionada) {
        try {
            // Obtener la ID de la tarjeta de la columna 0 (la primera columna) de la fila seleccionada
            int fila = Integer.parseInt(String.valueOf(vistamodif.getTbprocesadores().getValueAt(filaSeleccionada, 0)));
            return fila;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vistamodif, "ID de Procesador inválido en la fila seleccionada", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return -1; // Otra opción podría ser lanzar una excepción
        }
    }

    private int obtenerIdPlacaEliminarSeleccionadaEnFila(int filaSeleccionada) {
        try {
            // Obtener la ID de la tarjeta de la columna 0 (la primera columna) de la fila seleccionada
            return Integer.parseInt(vistaelim.getTbProcesadoreselim().getValueAt(filaSeleccionada, 0).toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vistaelim, "ID de Procesador inválido en la fila seleccionada", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return -1; // Otra opción podría ser lanzar una excepción
        }
    }

    private Procesador obtenerProcesadorPorId(int idplaca) {
        List<Procesador> listaplacas = ModeloProcesador.listaProcesador();

        for (Procesador procesadorm : listaplacas) {
            if (procesadorm.getIdProcesador() == idplaca) {
                return procesadorm;
            }
        }
        return null;
    }

    private void cargarDatosEnComponentesModificar(int filaSeleccionada) {
        if (filaSeleccionada != -1) {
            // Obtener la ID de la Tarjeta Gráfica seleccionada
            int idplaca = obtenerIdPlacaSeleccionadaEnFila(filaSeleccionada);

            // Obtener la tarjeta correspondiente a la ID
            Procesador procesador = obtenerProcesadorPorId(idplaca);

            // Verificar si la tarjeta se encontró
            if (procesador != null) {
                // Cargar los datos en los componentes de modificación
                vistamodif.getLbIdmodiproc().setText(String.valueOf(procesador.getIdProcesador()));
                vistamodif.getTxtmarcamodiproc().setText(procesador.getMarca());
                vistamodif.getTxtmodelomodiproc().setText(procesador.getModelo());
                vistamodif.getSpnucleosmodiproc().setValue(procesador.getNucleosFisicos());
                vistamodif.getTxtghzmodiproc().setText(String.valueOf(procesador.getGhz()));
                vistamodif.getTxtsocketmodiproc().setText(procesador.getSocket());
                vistamodif.getSpRammodiproc().setValue(procesador.getMaximoVram());
                vistamodif.getSpWattsmodiproc().setValue(procesador.getWatts());
                vistamodif.getTxtpreciomodiproc().setText(String.valueOf(procesador.getPrecio()));
                vistamodif.getTxtstockmodiproc().setText(String.valueOf(procesador.getStock()));
                vistamodif.getCbproveedormodiproc().setSelectedItem(String.valueOf(procesador.getIdProveedor()));

                // Cargar la imagen
                if (procesador.getImagen() != null) {
                    ImageIcon imagenIcon = new ImageIcon(procesador.getImagen());
                    vistamodif.getLbimagenproce().setIcon(new ImageIcon(imagenIcon.getImage().getScaledInstance(
                            vistamodif.getLbimagenproce().getWidth(), vistamodif.getLbimagenproce().getHeight(), Image.SCALE_SMOOTH)));
                } else {
                    // Si no hay imagen, limpiar el icono
                    vistamodif.getLbimagenproce().setIcon(null);
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
            Procesador procesaSeleccionada = obtenerProcesadorPorId(idGabineteSeleccionada);

            // Cargar la imagen en lbimagentarjelim
            if (procesaSeleccionada != null && procesaSeleccionada.getImagen() != null) {
                ImageIcon imagenIcon = new ImageIcon(procesaSeleccionada.getImagen());
                vistaelim.getLbimagenproelim().setIcon(new ImageIcon(imagenIcon.getImage().getScaledInstance(
                        vistaelim.getLbimagenproelim().getWidth(), vistaelim.getLbimagenproelim().getHeight(), Image.SCALE_SMOOTH)));
            } else {
                // Si no hay imagen, limpiar el icono
                vistaelim.getLbimagenproelim().setIcon(null);
            }
        }
    }

    private void limpiarCamposAgregar() {
        // Limpiar campos de la vista después de la modificación
        vistacrea.getTxtmarcacreaproc().setText("");
        vistacrea.getTxtmodelocreaproc().setText("");
        vistacrea.getSpnucleoscreaproc().setValue(0);
        vistacrea.getTxtghzcreaproc().setText("");
        vistacrea.getTxtsocketcreaproc().setText("");
        vistacrea.getSpRamcreaproc().setValue(0);
        vistacrea.getSpWattscreaproc().setValue(0);
        vistacrea.getTxtpreciocreaproc().setText("");
        vistacrea.getTxtStockcreaproc().setText("");
        vistacrea.getCbproveedorcreaproc().setSelectedIndex(0);
        vistacrea.getLbprocesadorimg().setIcon(null);
        cargaID();
    }
}
