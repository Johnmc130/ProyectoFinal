/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloVentiladores;
import Clases.Ventiladores;
import Vista.CrearVentiladores;
import Vista.EliminarVentiladores;
import Vista.ModificarVentiladores;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EDU
 */
public class ControladorVentiladores {

    private ModeloVentiladores modelo;
    private CrearVentiladores crear;
    private ModificarVentiladores modificar;
    private EliminarVentiladores eliminar;
    ModeloVentiladores miVentiladores = new ModeloVentiladores();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    String RGB = "";
    byte[] imagenBytes;

    public ControladorVentiladores() {

    }

    public ControladorVentiladores(ModeloVentiladores modelo, CrearVentiladores crear) {
        this.modelo = modelo;
        this.crear = crear;
        crear.setVisible(true);
        //cargarCodigosProveedorComboBox();
    }

    public ControladorVentiladores(ModeloVentiladores modelo, ModificarVentiladores modificar) {
        this.modelo = modelo;
        this.modificar = modificar;
        modificar.setVisible(true);
        listarAlmaceModificar();

    }

    public ControladorVentiladores(ModeloVentiladores modelo, EliminarVentiladores eliminar) {
        this.modelo = modelo;
        this.eliminar = eliminar;
        eliminar.setVisible(true);
        listarAlmaceEliminar();

    }

    public void iniciaControl() {
        // vista.getBtnEliminarA().addActionListener(l -> listarVentiladores(eliminar.getTblVentilador()));
        // vista.getBtnExaminar().addActionListener(l -> seleccionarImagen());
//                eliminar.getBtnEliminar().addActionListener(l -> eliminarVentiladores());
        crear.getBtnCargarI().addActionListener(l -> cargarImagen());
        crear.getBtnImagenProducto().addActionListener(l -> mostrarImagenEmergente());

        crear.getBtnCrear().addActionListener(l -> grabarVentiladores());

        // vista.getBtnModificar().addActionListener(l -> Actualizar());
        //vista.getBtnCancelar().addActionListener(l -> regresarInicio());
        //         vista.getBtnImprimir().addActionListener(l->imprimirVentiladoress());
    }

    public void iniciaControlEliminar() {
        // vista.getBtnEliminarA().addActionListener(l -> listarVentiladores(eliminar.getTblVentilador()));
        // vista.getBtnExaminar().addActionListener(l -> seleccionarImagen());
        eliminar.getBtnEliminar().addActionListener(l -> eliminarVentiladores());

        //crear.getBtnCrear().addActionListener(l -> grabarVentiladores());
        // vista.getBtnModificar().addActionListener(l -> Actualizar());
        //vista.getBtnCancelar().addActionListener(l -> regresarInicio());
        //         vista.getBtnImprimir().addActionListener(l->imprimirVentiladoress());
    }

    public void iniciaControlModificar() {
        // vista.getBtnEliminarA().addActionListener(l -> listarVentiladores(eliminar.getTblVentilador()));
        // vista.getBtnExaminar().addActionListener(l -> seleccionarImagen())

        modificar.getBtnCargardatos().addActionListener(l -> CargarDatos());

        modificar.getBtnModificar().addActionListener(l -> ActualizarVentiladores());

        // vista.getBtnModificar().addActionListener(l -> Actualizar());
        //vista.getBtnCancelar().addActionListener(l -> regresarInicio());
        //         vista.getBtnImprimir().addActionListener(l->imprimirVentiladoress());
    }

    private void grabarVentiladores() {
        // Lógica para grabar
        // Validar antes...

        String marca = crear.getTxtmarca().getText();
        String modelo = crear.getTxtmodelo().getText();
        if (crear.getRbSi().isSelected()) {
            RGB = "Si";
        } else if (crear.getRbNo().isSelected()) {
            RGB = "No";
        }
        int tamaño = (Integer) crear.getSpTamaño().getValue();

        double precio = (double) crear.getSpPrecio().getValue();

        int stock = (Integer) crear.getSpStock().getValue();

        miVentiladores.setMarca(marca);
        miVentiladores.setModelo(modelo);
        miVentiladores.setRGB(RGB);
        miVentiladores.setTamaño(tamaño);
        miVentiladores.setPrecio(precio);
        miVentiladores.setStock(stock);
        miVentiladores.setFoto(imagenBytes);

        if (CamposVacios() == true && miVentiladores.grabarventiladores() == null) {
            JOptionPane.showMessageDialog(crear, "Usuario Agregado con Exito");
        } else {
            JOptionPane.showMessageDialog(crear, "error");

        }

    }

    private void CargarDatos() {

        int fila = modificar.getTblVentilador().getSelectedRow();

        if (fila != -1) {
            String IdV = (String) modificar.getTblVentilador().getValueAt(fila, 0);
            String marca = (String) modificar.getTblVentilador().getValueAt(fila, 1);
            String modelo = (String) modificar.getTblVentilador().getValueAt(fila, 2);
            String RGB = (String) modificar.getTblVentilador().getValueAt(fila, 3);
            String tamaño = (String) modificar.getTblVentilador().getValueAt(fila, 4);
            String precio = (String) modificar.getTblVentilador().getValueAt(fila, 5);
            String stock = (String) modificar.getTblVentilador().getValueAt(fila, 6);

            // Obtener los bytes de la imagen
            // Convertir los bytes a un ImageIcon
            // ImageIcon imagenIcon = new ImageIcon(bytesImagen);
            // Establecer la imagen en el JLabel
            //vista.getLblFoto().setIcon(imagenIcon);
            modificar.getTxtIdV().setText(IdV);
            modificar.getTxtmarca().setText(marca);
            modificar.getTxtmodelo().setText(modelo);
            if (RGB.equals("Si")) {
                modificar.getRbSi().setSelected(true);
            } else if (RGB.equals("No")) {
                modificar.getRbNo().setSelected(true);
            }
            modificar.getSpTamaño().setValue(Integer.parseInt(tamaño));
            modificar.getSpPrecio().setValue(Double.parseDouble(precio));

            modificar.getSpStock().setValue(Integer.parseInt(stock));

            modificar.getTxtIdV().setEditable(false);

        } else {
            JOptionPane.showMessageDialog(modificar, "Selecciona una fila antes de modificar.");
        }
    }

    private void listarAlmaceModificar() {
        ///Logica cargar personas
        List<Ventiladores> listap = ModeloVentiladores.listaTodasventiladores();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) modificar.getTblVentilador().getModel();
        mTabla.setNumRows(0);//limpio la tabla
        listap.stream().forEach(venti -> {
            String[] rowData = {String.valueOf(venti.getIdVentiladores()), venti.getMarca(), venti.getModelo(), venti.getRGB(), String.valueOf(venti.getTamaño()), String.valueOf(venti.getPrecio()), String.valueOf(venti.getStock())};
            mTabla.addRow(rowData);
        });

    }

    private void listarAlmaceEliminar() {
        ///Logica cargar personas
        List<Ventiladores> listap = ModeloVentiladores.listaTodasventiladores();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) eliminar.getTblVentilador().getModel();
        mTabla.setNumRows(0);//limpio la tabla
        listap.stream().forEach(venti -> {
            String[] rowData = {String.valueOf(venti.getIdVentiladores()), venti.getMarca(), venti.getModelo(), venti.getRGB(), String.valueOf(venti.getTamaño()), String.valueOf(venti.getPrecio()), String.valueOf(venti.getStock())};
            mTabla.addRow(rowData);
        });

    }

    public void ActualizarVentiladores() {
        String idVentiladores = modificar.getTxtIdV().getText();
        String marca = modificar.getTxtmarca().getText();
        String modelo = modificar.getTxtmodelo().getText();
        if (modificar.getRbSi().isSelected()) {
            RGB = "Si";
        } else if (modificar.getRbNo().isSelected()) {
            RGB = "No";
        }
        int tamaño = (Integer) modificar.getSpTamaño().getValue();

        double precio = (double) modificar.getSpPrecio().getValue();

        int stock = (Integer) modificar.getSpStock().getValue();
        miVentiladores.setIdVentiladores(Integer.parseInt(idVentiladores));

        miVentiladores.setMarca(marca);
        miVentiladores.setModelo(modelo);
        miVentiladores.setRGB(RGB);
        miVentiladores.setTamaño(tamaño);
        miVentiladores.setPrecio(precio);
        miVentiladores.setStock(stock);

        if (miVentiladores.editarventiladores() == null) {
            JOptionPane.showMessageDialog(modificar, "Ventiladores Actualizado correctamente");
            listarAlmaceModificar();
        } else {
            JOptionPane.showMessageDialog(modificar, "ERROR");

        }

    }

    private void eliminarVentiladores() {
        int fila = eliminar.getTblVentilador().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(eliminar, "Seleccione una fila!");
        } else {
            String id = (String) eliminar.getTblVentilador().getValueAt(fila, 0);
            modelo.setIdVentiladores(Integer.valueOf(id));
            modelo.eliminar();
            JOptionPane.showMessageDialog(eliminar, "Ventiladores Actualizado correctamente");
            listarAlmaceEliminar();

        }

    }

    private byte[] obtenerBytesImagen(String rutaImagen) {
        try {
            // Leer la imagen desde el archivo en la ruta especificada
            File file = new File(rutaImagen);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            fis.close();

            // Obtener el arreglo de bytes de la imagen
            byte[] imagenBytes = bos.toByteArray();
            bos.close();
            return imagenBytes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
//
// Método que invoca obtenerBytesImagen() y asigna el arreglo de bytes a la variable "foto"
    private String rutaImagenSeleccionada;

    private void cargarImagen() {
        JFileChooser jf = new JFileChooser();
        jf.setMultiSelectionEnabled(false);
        if (jf.showOpenDialog(crear) == JFileChooser.APPROVE_OPTION) {
            rutaImagenSeleccionada = jf.getSelectedFile().toString();

            // Mostrar la imagen en el botón btnImagenProducto
            crear.getBtnImagenProducto().setIcon(new ImageIcon(rutaImagenSeleccionada));

            // Obtener los bytes de la imagen y guardarlos en la variable imagenBytes
            imagenBytes = obtenerBytesImagen(rutaImagenSeleccionada);
        }

    }

    private void mostrarImagenEmergente() {
        // Obtener la imagen actual del botón
        Icon imagenActual = crear.getBtnImagenProducto().getIcon();

        // Si el botón no tiene una imagen, no hacemos nada
        if (imagenActual == null) {
            return;
        }

        // Crear un componente JLabel para mostrar la imagen en el diálogo emergente
        JLabel lblImagen = new JLabel(imagenActual);

        // Crear un diálogo emergente de JOptionPane para mostrar la imagen
        JOptionPane.showMessageDialog(crear, lblImagen, "Imagen del Producto", JOptionPane.PLAIN_MESSAGE);
    }

    public static byte[] convert(String hexString) {
        int length = hexString.length();
        byte[] data = new byte[length / 2];

        for (int i = 0; i < length; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i + 1), 16));
        }

        return data;
    }

//    public void cargarCodigosProveedorComboBox() {
//        try {
//            ArrayList<Integer> codigosProveedor = ModeloVentiladores.obtenerCodigosProveedor();
//
//            crear.getCmbProveedor().removeAllItems();
//
//            for (Integer idProveedor : codigosProveedor) {
//                crear.getCmbProveedor().addItem(String.valueOf(idProveedor));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    private byte[] obtenerBytesImagen() {
//        JFileChooser se = new JFileChooser();
//        se.setFileSelectionMode(JFileChooser.FILES_ONLY);
//        int estado = se.showOpenDialog(null);
//        if (estado == JFileChooser.APPROVE_OPTION) {
//            try {
//                File archivo = se.getSelectedFile();
//                this.longitudBytes = (int) archivo.length();
//
//                // Leer la imagen seleccionada como bytes
//                byte[] buffer = new byte[this.longitudBytes];
//                try ( FileInputStream fis = new FileInputStream(archivo)) {
//                    fis.read(buffer);
//                }
//
//                // Mostrar la imagen en un JLabel (opcional, solo para visualización)
//                Image icono = ImageIO.read(archivo).getScaledInstance(vista.getLblFoto().getWidth(), vista.getLblFoto().getHeight(), Image.SCALE_DEFAULT);
//                vista.getLblFoto().setIcon(new ImageIcon(icono));
//                vista.getLblFoto().updateUI();
//
//                return buffer;
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//        return null;
//    }
//
//// Método que invoca obtenerBytesImagen() y asigna el arreglo de bytes a la variable "foto"
//    public void seleccionarImagen() {
//        foto = obtenerBytesImagen();
//    }
//    public void regresarInicio() {
//
//        vista.getDlgVentiladores().setVisible(false);
//
//    }
//     private void imprimirVentiladoress(){
//        ConexionPg conecction=new ConexionPg();
//        try {
//            JasperReport reporte=(JasperReport)JRLoader.loadObject(
//                    getClass().getResource("/mvc2023/pkg2/vista/reportes/ReporteVentiladoress.jasper")
//            );
//            
//            JasperPrint jp =JasperFillManager.fillReport(
//                    reporte,
//                    null,
//                    conecction.getCon());
//            JasperViewer jv=new JasperViewer(jp,false);
//            jv.setVisible(true);
//        } catch (JRException ex) {
//            Logger.getLogger(ControladorVentiladoress.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public boolean CamposVacios() {
        boolean validar = true;
        boolean Valor1 = true;
        boolean Valor2 = true;
        boolean Valor3 = true;
        boolean Valor4 = true;

        if (crear.getTxtmarca().getText().isEmpty()) {

            JOptionPane.showMessageDialog(crear, "Campo Vacio en Marca");
            Valor1 = true;
        } else {
            Valor1 = false;
        }

        if (crear.getTxtmodelo().getText().isEmpty()) {

            JOptionPane.showMessageDialog(crear, "Campo Vacio en Modelo");
            Valor2 = true;
        } else {
            Valor2 = false;
        }

        if (crear.getSpTamaño().getValue().equals(0)) {

            JOptionPane.showMessageDialog(crear, "Capacidad no puede estar en 0");
            Valor3 = true;
        } else {
            Valor3 = false;
        }

        if (crear.getSpPrecio().getValue().equals(0.0)) {

            JOptionPane.showMessageDialog(crear, "Registre un precio");
            Valor4 = true;
        } else {
            Valor4 = false;
        }

        if (Valor1 == false && Valor1 == false && Valor1 == false && Valor1 == false) {
            validar = true;
        } else {
            validar = false;
        }

        return validar;
    }

}
