package Controlador;

import Clases.Tarjetagrafica;
import Vista.CrearTarjetaGrafica;
import Vista.EliminarTarjetaGrafica;
import Vista.ModificarTarjetaGrafica;
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
import Modelo.ModeloTarjetaGrafica;

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
    ModeloTarjetaGrafica mitarjetamod = new ModeloTarjetaGrafica();
    private String ruta;
    private String rutamod;

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
        listarTarjetasg();
        iniciaControlModificar();

        vistamodif.getBtncargatarjeta().addActionListener(l -> abrefotoModificar());
        vistamodif.getBtnModificartarjeta().addActionListener(e -> modificarTarjeta());
    }

    // Constructor para la eliminación
    public ControladorTarjetaGrafica(ModeloTarjetaGrafica modelo, EliminarTarjetaGrafica vista) {
        this.modelo = modelo;
        this.vistaelim = vista;
        vista.setVisible(true);
        iniciaControlEliminar();
        listarTarjetasgelim();

        vistaelim.getBtnEliminartarjeta().addActionListener(l -> eliminarPersonas());
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

        vistamodif.getBtnBuscartarjeta().addActionListener(l -> buscarTarjetaGrafica());

        // Agregar el listener para la selección de fila en la tabla
        vistamodif.getTbtarjetasgraficas().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Obtener la fila seleccionada
                int filaSeleccionada = vistamodif.getTbtarjetasgraficas().getSelectedRow();

                // Cargar los datos de la fila en los componentes de modificación
                cargarDatosEnComponentesModificar(filaSeleccionada);
            }
        });

        cargarCodigosProveedorComboBoxmodi();
    }

    public void iniciaControlEliminar() {
        vistaelim.getBtnBuscartarjeta().addActionListener(l -> buscarTarjetaGraficaElim());

        // Agregar el listener para la selección de fila en la tabla
        vistaelim.getTbtarjetasgraficas().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Obtener la fila seleccionada
                int filaSeleccionada = vistaelim.getTbtarjetasgraficas().getSelectedRow();

                // Cargar la imagen en lbimagentarjelim
                cargarImagenEliminar(filaSeleccionada);
            }
        });

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
            limpiarCamposAgregar();
        } else {
            JOptionPane.showMessageDialog(vistacrea, "Error al intentar agregar el Tarjeta Gráfica", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificarTarjeta() {
        // Obtener la ID de la Tarjeta Gráfica seleccionada
        int idTarjetaSeleccionada = obtenerIdTarjetaSeleccionada();
        if (idTarjetaSeleccionada == -1) {
            return;
        }

        // Obtener valores de los campos de la vista
        String marca = vistamodif.getTxtmarcamodtarjetag().getText();
        String modelo = vistamodif.getTxtmodelomodtarjetag().getText();
        int vram = (Integer) vistamodif.getSpvrammodtarjeta().getValue();
        String dlss = vistamodif.getTxtDLSSmodtarj().getText();
        String fsr = vistamodif.getTxtFSRmodtarjeta().getText();
        int watts = (Integer) vistamodif.getSpwattsmodtarjeta().getValue();
        int tamano = (Integer) vistamodif.getSptamanomodtarjeta().getValue();
        String precioTexto = vistamodif.getTxtpreciomodtarj().getText();
        char ultimoDigito = vistamodif.getTxtpreciomodtarj().getText().charAt(vistamodif.getTxtpreciomodtarj().getText().length() - 1);
        if (ultimoDigito != ',') {
            double precio = Double.parseDouble(vistamodif.getTxtpreciomodtarj().getText());
            mitarjetamod.setPrecio(precio);
        } else {
            JOptionPane.showMessageDialog(vistamodif, "Precio invalido");
        }
        int stock = Integer.parseInt(vistamodif.getTxtstockmodtarj().getText());
        int idProveedor = Integer.valueOf(vistamodif.getCbproveedormodtarje().getSelectedItem().toString());

// Verificar si se seleccionó una nueva imagen
        if (rutamod != null && !rutamod.isEmpty()) {
            byte[] imgTarjeta = GuardaImagen(rutamod);
            mitarjetamod.setFoto(imgTarjeta);
        } else {
            // Si no se seleccionó una nueva imagen, obtener la imagen actual
            byte[] imageBytes = icono_a_Bytes(vistamodif.getLbtarjetacaimg().getIcon());
            mitarjetamod.setFoto(imageBytes);
        }

        // Asignar valores al modelo
        mitarjetamod.setIdtarjetag(idTarjetaSeleccionada);
        mitarjetamod.setMarca(marca);
        mitarjetamod.setModelo(modelo);
        mitarjetamod.setVram(vram);
        mitarjetamod.setDlss(dlss);
        mitarjetamod.setFsr(fsr);
        mitarjetamod.setWatts(watts);
        mitarjetamod.setTamano(tamano);
        mitarjetamod.setStock(stock);
        mitarjetamod.setProveedor(idProveedor);

        // Validar datos antes de modificar
        if (!datosVaciosModi() && mitarjetamod.ModificarPTarjetagrafica() == null) {
            JOptionPane.showMessageDialog(vistamodif, "Tarjeta Gráfica Modificada con Éxito");
        } else {
            JOptionPane.showMessageDialog(vistamodif, "Error al intentar modificar la Tarjeta Gráfica", "Error", JOptionPane.ERROR_MESSAGE);
        }
        listarTarjetasg();

    }

    private void buscarTarjetaGrafica() {
        List<Tarjetagrafica> listaTarjetagrafica = ModeloTarjetaGrafica.listaTarjetaGrafica();
        List<Tarjetagrafica> resultado = new ArrayList<>();

        resultado = listaTarjetagrafica.stream()
                .filter(tar -> tar.getIdtarjetag() == (Integer.parseInt(vistamodif.getTxtbuscartarjeta().getText())))
                .collect(Collectors.toList());

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistamodif.getTbtarjetasgraficas().getModel();
        modelo.setNumRows(0);

        resultado.forEach(tar -> {
            Object[] fila = {
                tar.getIdtarjetag(),
                tar.getModelo(),
                tar.getMarca(),
                tar.getVram(),
                tar.getDlss(),
                tar.getFsr(),
                tar.getWatts(),
                tar.getPrecio(),
                tar.getStock(),
                tar.getProveedor()
            };
            modelo.addRow(fila); // Agrega la fila al modelo de la tabla
        });
    }

    private void buscarTarjetaGraficaElim() {
        List<Tarjetagrafica> listaTarjetagrafica = ModeloTarjetaGrafica.listaTarjetaGrafica();
        List<Tarjetagrafica> resultado = new ArrayList<>();

        resultado = listaTarjetagrafica.stream()
                .filter(tar -> tar.getIdtarjetag() == (Integer.parseInt(vistaelim.getTxtbuscartarjeta().getText())))
                .collect(Collectors.toList());

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistaelim.getTbtarjetasgraficas().getModel();
        modelo.setNumRows(0);

        resultado.forEach(tar -> {
            Object[] fila = {
                tar.getIdtarjetag(),
                tar.getModelo(),
                tar.getMarca(),
                tar.getVram(),
                tar.getDlss(),
                tar.getFsr(),
                tar.getWatts(),
                tar.getPrecio(),
                tar.getStock(),
                tar.getProveedor()
            };
            modelo.addRow(fila); // Agrega la fila al modelo de la tabla
        });
    }

    private void listarTarjetasg() {
        // Logica cargar tarjetas
        List<Tarjetagrafica> listap = ModeloTarjetaGrafica.listaTarjetaGrafica();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) vistamodif.getTbtarjetasgraficas().getModel();
        mTabla.setNumRows(0); // Limpio la tabla
        listap.stream().forEach(tar -> {
            String[] rowData = {String.valueOf(tar.getIdtarjetag()), tar.getMarca(), tar.getModelo(), String.valueOf(tar.getVram()), tar.getDlss(), tar.getFsr(), String.valueOf(tar.getWatts()), String.valueOf(tar.getTamano()), String.valueOf(tar.getPrecio()), String.valueOf(tar.getStock()), String.valueOf(tar.getProveedor())
            };
            mTabla.addRow(rowData);
        });
    }

    private void listarTarjetasgelim() {
        // Logica cargar tarjetas
        List<Tarjetagrafica> listap = ModeloTarjetaGrafica.listaTarjetaGrafica();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) vistaelim.getTbtarjetasgraficas().getModel();
        mTabla.setNumRows(0); // Limpio la tabla
        listap.stream().forEach(tar -> {
            String[] rowData = {String.valueOf(tar.getIdtarjetag()), tar.getMarca(), tar.getModelo(), String.valueOf(tar.getVram()), tar.getDlss(), tar.getFsr(), String.valueOf(tar.getWatts()), String.valueOf(tar.getTamano()), String.valueOf(tar.getPrecio()), String.valueOf(tar.getStock()), String.valueOf(tar.getProveedor())
            };
            mTabla.addRow(rowData);
        });
    }

    private void eliminarPersonas() {
// Obtener la fila seleccionada
        int fila = vistaelim.getTbtarjetasgraficas().getSelectedRow();

        // Verificar si hay una fila seleccionada
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaelim, "Seleccione una Tarjeta Gráfica antes de eliminar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Obtener la ID de la Tarjeta Gráfica seleccionada
        int id = obtenerIdTarjetaEliminarSeleccionadaEnFila(fila);

        // Preguntar si está seguro de eliminar
        int opcion = JOptionPane.showConfirmDialog(vistaelim, "¿Está seguro de eliminar la Tarjeta Gráfica seleccionada?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            // Realizar la eliminación
            if (modelo.eliminarPersona(String.valueOf(id)) == null) {
                JOptionPane.showMessageDialog(vistaelim, "Tarjeta eliminada correctamente");
                // Limpiar la imagen en lbimagentarjelim
                vistaelim.getLbimagentarjelim().setIcon(null);
                // Actualizar la tabla después de la eliminación
                listarTarjetasgelim();
            }
        }

    }

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
            vistamodif.getLbtarjetacaimg().setIcon(new ImageIcon(imagenIcon.getImage().getScaledInstance(
                    vistamodif.getLbtarjetacaimg().getWidth(), vistamodif.getLbtarjetacaimg().getHeight(), Image.SCALE_SMOOTH)));
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

    public boolean datosVaciosModi() {
        try {
            // Obtener los valores de los atributos
            int vram = Integer.parseInt(vistamodif.getSpvrammodtarjeta().getValue().toString());
            int watss = Integer.parseInt(vistamodif.getSpwattsmodtarjeta().getValue().toString());
            Double precio = Double.parseDouble(vistamodif.getTxtpreciomodtarj().getText());
            int tamano = Integer.parseInt(vistamodif.getSptamanomodtarjeta().getValue().toString());
            int stock = Integer.parseInt(vistamodif.getTxtstockmodtarj().getText());

            // Obtener los valores de los atributos de texto
            String idtarjetag = vistamodif.getLbIdmodtarjetag().getText();
            String marca = vistamodif.getTxtmarcamodtarjetag().getText();
            String modelo = vistamodif.getTxtmodelomodtarjetag().getText();
            String dlss = vistamodif.getTxtDLSSmodtarj().getText();
            String fsr = vistamodif.getTxtFSRmodtarjeta().getText();
            String proveedor = (String) vistamodif.getCbproveedormodtarje().getSelectedItem();

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
            JOptionPane.showMessageDialog(vistamodif, "Error en la conversión de datos numéricos", "Error", JOptionPane.ERROR_MESSAGE);
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

    private int obtenerIdTarjetaSeleccionadaEnFila(int filaSeleccionada) {
        try {
            // Obtener la ID de la tarjeta de la columna 0 (la primera columna) de la fila seleccionada
            return Integer.parseInt(vistamodif.getTbtarjetasgraficas().getValueAt(filaSeleccionada, 0).toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vistamodif, "ID de Tarjeta Gráfica inválido en la fila seleccionada", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return -1; // Otra opción podría ser lanzar una excepción
        }
    }

    private int obtenerIdTarjetaEliminarSeleccionadaEnFila(int filaSeleccionada) {
        try {
            // Obtener la ID de la tarjeta de la columna 0 (la primera columna) de la fila seleccionada
            return Integer.parseInt(vistaelim.getTbtarjetasgraficas().getValueAt(filaSeleccionada, 0).toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vistaelim, "ID de Tarjeta Gráfica inválido en la fila seleccionada", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return -1; // Otra opción podría ser lanzar una excepción
        }
    }

    private Tarjetagrafica obtenerTarjetaPorId(int idTarjeta) {
        List<Tarjetagrafica> listaTarjetas = ModeloTarjetaGrafica.listaTarjetaGrafica();

        for (Tarjetagrafica tarjeta : listaTarjetas) {
            if (tarjeta.getIdtarjetag() == idTarjeta) {
                return tarjeta;
            }
        }
        return null;
    }

    private void cargarDatosEnComponentesModificar(int filaSeleccionada) {
        if (filaSeleccionada != -1) {
            // Obtener la ID de la Tarjeta Gráfica seleccionada
            int idTarjetaSeleccionada = obtenerIdTarjetaSeleccionadaEnFila(filaSeleccionada);

            // Obtener la tarjeta correspondiente a la ID
            Tarjetagrafica tarjetaSeleccionada = obtenerTarjetaPorId(idTarjetaSeleccionada);

            // Verificar si la tarjeta se encontró
            if (tarjetaSeleccionada != null) {
                // Cargar los datos en los componentes de modificación
                vistamodif.getLbIdmodtarjetag().setText(String.valueOf(tarjetaSeleccionada.getIdtarjetag()));
                vistamodif.getTxtmarcamodtarjetag().setText(tarjetaSeleccionada.getMarca());
                vistamodif.getTxtmodelomodtarjetag().setText(tarjetaSeleccionada.getModelo());
                vistamodif.getSpvrammodtarjeta().setValue(tarjetaSeleccionada.getVram());
                vistamodif.getTxtDLSSmodtarj().setText(tarjetaSeleccionada.getDlss());
                vistamodif.getTxtFSRmodtarjeta().setText(tarjetaSeleccionada.getFsr());
                vistamodif.getSpwattsmodtarjeta().setValue(tarjetaSeleccionada.getWatts());
                vistamodif.getSptamanomodtarjeta().setValue(tarjetaSeleccionada.getTamano());
                vistamodif.getTxtpreciomodtarj().setText(String.valueOf(tarjetaSeleccionada.getPrecio()));
                vistamodif.getTxtstockmodtarj().setText(String.valueOf(tarjetaSeleccionada.getStock()));
                vistamodif.getCbproveedormodtarje().setSelectedItem(String.valueOf(tarjetaSeleccionada.getProveedor()));

                // Cargar la imagen
                if (tarjetaSeleccionada.getFoto() != null) {
                    ImageIcon imagenIcon = new ImageIcon(tarjetaSeleccionada.getFoto());
                    vistamodif.getLbtarjetacaimg().setIcon(new ImageIcon(imagenIcon.getImage().getScaledInstance(
                            vistamodif.getLbtarjetacaimg().getWidth(), vistamodif.getLbtarjetacaimg().getHeight(), Image.SCALE_SMOOTH)));
                } else {
                    // Si no hay imagen, limpiar el icono
                    vistamodif.getLbtarjetacaimg().setIcon(null);
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
            int idTarjetaSeleccionada = obtenerIdTarjetaEliminarSeleccionadaEnFila(filaSeleccionada);

            // Obtener la tarjeta correspondiente a la ID
            Tarjetagrafica tarjetaSeleccionada = obtenerTarjetaPorId(idTarjetaSeleccionada);

            // Cargar la imagen en lbimagentarjelim
            if (tarjetaSeleccionada != null && tarjetaSeleccionada.getFoto() != null) {
                ImageIcon imagenIcon = new ImageIcon(tarjetaSeleccionada.getFoto());
                vistaelim.getLbimagentarjelim().setIcon(new ImageIcon(imagenIcon.getImage().getScaledInstance(
                        vistaelim.getLbimagentarjelim().getWidth(), vistaelim.getLbimagentarjelim().getHeight(), Image.SCALE_SMOOTH)));
            } else {
                // Si no hay imagen, limpiar el icono
                vistaelim.getLbimagentarjelim().setIcon(null);
            }
        }
    }

    private void limpiarCamposAgregar() {
        // Limpiar campos de la vista después de la modificación
        vistacrea.getTxtmarcacreatarjetag().setText("");
        vistacrea.getTxtmodelocreatarjetag().setText("");
        vistacrea.getSpvramtarjeta().setValue(0);
        vistacrea.getTxtDLSStarj().setText("");
        vistacrea.getTxtFSRtarjeta().setText("");
        vistacrea.getSpwattstarjeta().setValue(0);
        vistacrea.getSptamanotarjeta().setValue(0);
        vistacrea.getTxtpreciocreatarj().setText("");
        vistacrea.getTxtstockcreatarj().setText("");
        vistacrea.getCbproveedortarje().setSelectedIndex(0);
        vistacrea.getLbtarjetacaimg().setIcon(null);
        cargaID();
    }
}
