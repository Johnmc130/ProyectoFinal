/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloFuentePoder;
import Clases.FuentePoder;
import Vista.CrearFuentePoder;
import Vista.EliminarFuentePoder;
import Vista.ModificarFuentePoder;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
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
public class ControladorFuentePoder {

    private ModeloFuentePoder modelo;
    private CrearFuentePoder crear;
    private ModificarFuentePoder modificar;
    private EliminarFuentePoder eliminar;
    ModeloFuentePoder mifuentePoder = new ModeloFuentePoder();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    String modular = "";
        byte[] imagenBytes;


    public ControladorFuentePoder() {

    }

    public ControladorFuentePoder(ModeloFuentePoder modelo, CrearFuentePoder crear) {
        this.modelo = modelo;
        this.crear = crear;
        crear.setVisible(true);
        //cargarCodigosProveedorComboBox();
    }

    public ControladorFuentePoder(ModeloFuentePoder modelo, ModificarFuentePoder modificar) {
        this.modelo = modelo;
        this.modificar = modificar;
        modificar.setVisible(true);
        listarAlmaceModificar();

    }

    public ControladorFuentePoder(ModeloFuentePoder modelo, EliminarFuentePoder eliminar) {
        this.modelo = modelo;
        this.eliminar = eliminar;
        eliminar.setVisible(true);
        listarAlmaceEliminar();

    }

    public void iniciaControl() {
        // vista.getBtnEliminarA().addActionListener(l -> listarfuentePoder(eliminar.getTblfuentePoder()));
        // vista.getBtnExaminar().addActionListener(l -> seleccionarImagen());
//                eliminar.getBtnEliminar().addActionListener(l -> eliminarfuentePoder());
 crear.getBtnCargarI().addActionListener(l -> cargarImagen());
        crear.getBtnImagenProducto().addActionListener(l -> mostrarImagenEmergente());

        crear.getBtnCrear().addActionListener(l -> grabarfuentePoder());

        // vista.getBtnModificar().addActionListener(l -> Actualizar());
        //vista.getBtnCancelar().addActionListener(l -> regresarInicio());
        //         vista.getBtnImprimir().addActionListener(l->imprimirfuentePoders());
    }

    public void iniciaControlEliminar() {
        // vista.getBtnEliminarA().addActionListener(l -> listarfuentePoder(eliminar.getTblfuentePoder()));
        // vista.getBtnExaminar().addActionListener(l -> seleccionarImagen());
        eliminar.getBtnEliminar().addActionListener(l -> eliminarfuentePoder());

        //crear.getBtnCrear().addActionListener(l -> grabarfuentePoder());
        // vista.getBtnModificar().addActionListener(l -> Actualizar());
        //vista.getBtnCancelar().addActionListener(l -> regresarInicio());
        //         vista.getBtnImprimir().addActionListener(l->imprimirfuentePoders());
    }

    public void iniciaControlModificar() {
        // vista.getBtnEliminarA().addActionListener(l -> listarfuentePoder(eliminar.getTblfuentePoder()));
        // vista.getBtnExaminar().addActionListener(l -> seleccionarImagen())

        modificar.getBtnCargardatos().addActionListener(l -> CargarDatos());

        modificar.getBtnModificar().addActionListener(l -> ActualizarfuentePoder());

        // vista.getBtnModificar().addActionListener(l -> Actualizar());
        //vista.getBtnCancelar().addActionListener(l -> regresarInicio());
        //         vista.getBtnImprimir().addActionListener(l->imprimirfuentePoders());
    }

    private void grabarfuentePoder() {
        // Lógica para grabar
        // Validar antes...

        String marca = crear.getTxtmarca().getText();
        String Modelo = crear.getTxtmodelo().getText();
        String certificacion = crear.getTxtCertificacion().getText();
        if (crear.getRbSi().isSelected()) {
            modular = "Si";
        } else if (crear.getRbNo().isSelected()) {
            modular = "No";
        }
        String formato = crear.getTxtFormato().getText();
        String watts = crear.getTxtWatts().getText();

        double precio = (double) crear.getSpPrecio().getValue();

        int stock = (Integer) crear.getSpStock().getValue();

        mifuentePoder.setMarca(marca);
        mifuentePoder.setModelo(Modelo);
        mifuentePoder.setCertificacion(certificacion);
        mifuentePoder.setModular(modular);
        mifuentePoder.setFormato(formato);

        mifuentePoder.setWatts(watts);

        mifuentePoder.setPrecio(precio);
        mifuentePoder.setStock(stock);
                mifuentePoder.setFoto(imagenBytes);


        if ( mifuentePoder.grabarFuentePoder() == null) {
            JOptionPane.showMessageDialog(crear, "Fuente de poder Agregado con Exito");
        } else {
            JOptionPane.showMessageDialog(crear, "error");

        }

    }

    private void CargarDatos() {

        int fila = modificar.getTblfuentePoder().getSelectedRow();

        if (fila != -1) {
            String IdF = (String) modificar.getTblfuentePoder().getValueAt(fila, 0);
            String marca = (String) modificar.getTblfuentePoder().getValueAt(fila, 1);
            String Modelo = (String) modificar.getTblfuentePoder().getValueAt(fila, 2);
            String certificacion = (String) modificar.getTblfuentePoder().getValueAt(fila, 3);
            String modular = (String) modificar.getTblfuentePoder().getValueAt(fila, 4);
            String formato = (String) modificar.getTblfuentePoder().getValueAt(fila, 5);
            String watts = (String) modificar.getTblfuentePoder().getValueAt(fila, 6);
            String precio = (String) modificar.getTblfuentePoder().getValueAt(fila, 7);
            String stock = (String) modificar.getTblfuentePoder().getValueAt(fila, 8);

            // Obtener los bytes de la imagen
            // Convertir los bytes a un ImageIcon
            // ImageIcon imagenIcon = new ImageIcon(bytesImagen);
            // Establecer la imagen en el JLabel
            //vista.getLblFoto().setIcon(imagenIcon);
            modificar.getTxtIdF().setText(IdF);
            modificar.getTxtmarca().setText(marca);
            modificar.getTxtmodelo().setText(Modelo);
            modificar.getTxtCertificacion().setText(certificacion);
            if (modular.equals("Si")) {
                modificar.getRbSi().setSelected(true);
            } else if (modular.equals("No")) {
                modificar.getRbNo().setSelected(true);
            }
            modificar.getTxtFormato().setText(formato);
            modificar.getTxtWatts().setText(watts);
            modificar.getSpPrecio().setValue(Double.parseDouble(precio));
            modificar.getSpStock().setValue(Integer.parseInt(stock));
            modificar.getTxtIdF().setEditable(false);

        } else {
            JOptionPane.showMessageDialog(modificar, "Selecciona una fila antes de modificar.");
        }
    }

    private void listarAlmaceModificar() {
        ///Logica cargar personas
        List<FuentePoder> listap = ModeloFuentePoder.listaTodasFuentePoder();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) modificar.getTblfuentePoder().getModel();
        mTabla.setNumRows(0);//limpio la tabla
        listap.stream().forEach(fuente -> {
            String[] rowData = {String.valueOf(fuente.getIdFuentePoder()), fuente.getMarca(), fuente.getModelo(), fuente.getCertificacion(), fuente.getModular(), fuente.getFormato(), fuente.getWatts(), String.valueOf(fuente.getPrecio()), String.valueOf(fuente.getStock())};
            mTabla.addRow(rowData);
        });
    }

    private void listarAlmaceEliminar() {
        ///Logica cargar personas
        List<FuentePoder> listap = ModeloFuentePoder.listaTodasFuentePoder();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) eliminar.getTblFuentePoder().getModel();
        mTabla.setNumRows(0);//limpio la tabla
        listap.stream().forEach(fuente -> {
            String[] rowData = {String.valueOf(fuente.getIdFuentePoder()), fuente.getMarca(), fuente.getModelo(), fuente.getCertificacion(), fuente.getModular(), fuente.getFormato(), fuente.getWatts(), String.valueOf(fuente.getPrecio()), String.valueOf(fuente.getStock())};
            mTabla.addRow(rowData);
        });
    }

    public void ActualizarfuentePoder() {
        
        String idF = modificar.getTxtIdF().getText();
        String marca = modificar.getTxtmarca().getText();
        String modelo = modificar.getTxtmodelo().getText();
        String certificacion = modificar.getTxtCertificacion().getText();
        if (modificar.getRbSi().isSelected()) {
            modular = "Si";
        } else if (modificar.getRbNo().isSelected()) {
            modular = "No";
        }
        String formato = modificar.getTxtFormato().getText();
        String watts = modificar.getTxtWatts().getText();

        double precio = (double) modificar.getSpPrecio().getValue();

        int stock = (Integer) modificar.getSpStock().getValue();
        mifuentePoder.setIdFuentePoder(Integer.parseInt(idF));
        mifuentePoder.setMarca(marca);
        mifuentePoder.setModelo(modelo);
        mifuentePoder.setCertificacion(certificacion);
        mifuentePoder.setModular(modular);
        mifuentePoder.setFormato(formato);

        mifuentePoder.setWatts(watts);

        mifuentePoder.setPrecio(precio);
        mifuentePoder.setStock(stock);

        if (mifuentePoder.editarFuentePoder() == null) {
            JOptionPane.showMessageDialog(modificar, "fuentePoder Actualizado correctamente");
            listarAlmaceModificar();
        } else {
            JOptionPane.showMessageDialog(modificar, "ERROR");

        }

    }

    private void eliminarfuentePoder() {
        int fila = eliminar.getTblFuentePoder().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(eliminar, "Seleccione una fila!");
        } else {
            String id = (String) eliminar.getTblFuentePoder().getValueAt(fila, 0);
            modelo.setIdFuentePoder(Integer.valueOf(id));
            modelo.eliminar();
            JOptionPane.showMessageDialog(eliminar, "Fuente de Poder Actualizado correctamente");
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
//            ArrayList<Integer> codigosProveedor = ModelofuentePoder.obtenerCodigosProveedor();
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
//        vista.getDlgfuentePoder().setVisible(false);
//
//    }
//     private void imprimirfuentePoders(){
//        ConexionPg conecction=new ConexionPg();
//        try {
//            JasperReport reporte=(JasperReport)JRLoader.loadObject(
//                    getClass().getResource("/mvc2023/pkg2/vista/reportes/ReportefuentePoders.jasper")
//            );
//            
//            JasperPrint jp =JasperFillManager.fillReport(
//                    reporte,
//                    null,
//                    conecction.getCon());
//            JasperViewer jv=new JasperViewer(jp,false);
//            jv.setVisible(true);
//        } catch (JRException ex) {
//            Logger.getLogger(ControladorfuentePoders.class.getName()).log(Level.SEVERE, null, ex);
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

//        if (crear.getSpCapac().getValue().equals(0)) {
//
//            JOptionPane.showMessageDialog(crear, "Capacidad no puede estar en 0");
//            Valor3 = true;
//        } else {
//            Valor3 = false;
//        }
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
