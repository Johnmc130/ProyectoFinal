/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloAlmacenamiento;
import Clases.almacenamiento;
//import Vistas.Componentes;
import Vistas.CrearAlmacenamiento;
import Vistas.EliminarAlmacenamiento;
import Vistas.ModificarAlmacenamiento;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EDU
 */
public class ControladorAlmacenamiento {

    private ModeloAlmacenamiento modelo;
    private CrearAlmacenamiento crear;
    private ModificarAlmacenamiento modificar;
    private EliminarAlmacenamiento eliminar;
    ModeloAlmacenamiento miAlmacenamiento = new ModeloAlmacenamiento();
    DefaultTableModel modeloTabla = new DefaultTableModel();

    public ControladorAlmacenamiento() {

    }

    public ControladorAlmacenamiento(ModeloAlmacenamiento modelo, CrearAlmacenamiento crear) {
        this.modelo = modelo;
        this.crear = crear;
        crear.setVisible(true);
        cargarCodigosProveedorComboBox();
    }

    public ControladorAlmacenamiento(ModeloAlmacenamiento modelo, ModificarAlmacenamiento modificar) {
        this.modelo = modelo;
        this.modificar = modificar;
        modificar.setVisible(true);
        listarAlmaceModificar();

    }

    public ControladorAlmacenamiento(ModeloAlmacenamiento modelo, EliminarAlmacenamiento eliminar) {
        this.modelo = modelo;
        this.eliminar = eliminar;
        eliminar.setVisible(true);
        listarAlmaceEliminar();

    }

    public void iniciaControl() {
        // vista.getBtnEliminarA().addActionListener(l -> listarAlmacenamiento(eliminar.getTblAlmacenamiento()));
        // vista.getBtnExaminar().addActionListener(l -> seleccionarImagen());
//                eliminar.getBtnEliminar().addActionListener(l -> eliminarAlmacenamiento());

        crear.getBtnCrear().addActionListener(l -> grabarAlmacenamiento());

        // vista.getBtnModificar().addActionListener(l -> Actualizar());
        //vista.getBtnCancelar().addActionListener(l -> regresarInicio());
        //         vista.getBtnImprimir().addActionListener(l->imprimirAlmacenamientos());
    }

    public void iniciaControlEliminar() {
        // vista.getBtnEliminarA().addActionListener(l -> listarAlmacenamiento(eliminar.getTblAlmacenamiento()));
        // vista.getBtnExaminar().addActionListener(l -> seleccionarImagen());
        eliminar.getBtnEliminar().addActionListener(l -> eliminarAlmacenamiento());

        //crear.getBtnCrear().addActionListener(l -> grabarAlmacenamiento());
        // vista.getBtnModificar().addActionListener(l -> Actualizar());
        //vista.getBtnCancelar().addActionListener(l -> regresarInicio());
        //         vista.getBtnImprimir().addActionListener(l->imprimirAlmacenamientos());
    }

    public void iniciaControlModificar() {
        // vista.getBtnEliminarA().addActionListener(l -> listarAlmacenamiento(eliminar.getTblAlmacenamiento()));
        // vista.getBtnExaminar().addActionListener(l -> seleccionarImagen())

        modificar.getBtnCargardatos().addActionListener(l -> CargarDatos());

        modificar.getBtnModificar().addActionListener(l -> ActualizarAlmacenamiento());

        // vista.getBtnModificar().addActionListener(l -> Actualizar());
        //vista.getBtnCancelar().addActionListener(l -> regresarInicio());
        //         vista.getBtnImprimir().addActionListener(l->imprimirAlmacenamientos());
    }

    private void grabarAlmacenamiento() {
        // Lógica para grabar
        // Validar antes...
        
       
        
        
        String marca = crear.getTxtmarca().getText();
        String modelo = crear.getTxtmodelo().getText();
        String tipo = crear.getCmbTipo().getSelectedItem().toString();
        int capacidad = (Integer) crear.getSpCapacidad().getValue();

        double precio = (double) crear.getSpPrecio().getValue();
        int idProveedor = Integer.valueOf(crear.getCmbProveedor().getSelectedItem().toString());

        int stock = (Integer) crear.getSpStock().getValue();

        miAlmacenamiento.setMarca(marca);
        miAlmacenamiento.setModelo(modelo);
        miAlmacenamiento.setTipo(tipo);
        miAlmacenamiento.setCapacidad(capacidad);
        miAlmacenamiento.setPrecio(precio);
        miAlmacenamiento.setId_proveedor(idProveedor);
        miAlmacenamiento.setStock(stock);

        if (CamposVacios() == true  && miAlmacenamiento.grabarAlmacenamiento() == null) {
            JOptionPane.showMessageDialog(crear, "Usuario Agregado con Exito");
        } else {
            JOptionPane.showMessageDialog(crear, "error");

        }

    }

    private void CargarDatos() {

        int fila = modificar.getTblAlmacenamiento().getSelectedRow();

        if (fila != -1) {
            String IdA = (String) modificar.getTblAlmacenamiento().getValueAt(fila, 0);
            String marca = (String) modificar.getTblAlmacenamiento().getValueAt(fila, 1);
            String modelo = (String) modificar.getTblAlmacenamiento().getValueAt(fila, 2);
            String tipo = (String) modificar.getTblAlmacenamiento().getValueAt(fila, 3);
            String capacidad = (String) modificar.getTblAlmacenamiento().getValueAt(fila, 4);
            String precio = (String) modificar.getTblAlmacenamiento().getValueAt(fila, 5);
            String idProveedor = (String) modificar.getTblAlmacenamiento().getValueAt(fila, 6);
            String stock = (String) modificar.getTblAlmacenamiento().getValueAt(fila, 7);

            // Obtener los bytes de la imagen
            // Convertir los bytes a un ImageIcon
            // ImageIcon imagenIcon = new ImageIcon(bytesImagen);
            // Establecer la imagen en el JLabel
            //vista.getLblFoto().setIcon(imagenIcon);
            modificar.getTxtIdA().setText(IdA);
            modificar.getTxtmarca().setText(marca);
            modificar.getTxtmodelo().setText(modelo);
            modificar.getCmbTipo().setSelectedItem(tipo);
            modificar.getSpCapacidad().setValue(Integer.parseInt(capacidad));
            modificar.getSpPrecio().setValue(Double.parseDouble(precio));

            modificar.getSpStock().setValue(Integer.parseInt(stock));
            
            modificar.getTxtIdA().setEditable(false);

        } else {
            JOptionPane.showMessageDialog(modificar, "Selecciona una fila antes de modificar.");
        }
    }

    private void listarAlmaceModificar() {
        ///Logica cargar personas
        List<almacenamiento> listap = ModeloAlmacenamiento.listaTodasAlmacenamiento();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) modificar.getTblAlmacenamiento().getModel();
        mTabla.setNumRows(0);//limpio la tabla
        listap.stream().forEach(alma -> {
            String[] rowData = {String.valueOf(alma.getIdalmacenamiento()), alma.getMarca(), alma.getModelo(), alma.getTipo(), String.valueOf(alma.getCapacidad()), String.valueOf(alma.getPrecio()), String.valueOf(alma.getId_proveedor()), String.valueOf(alma.getStock())};
            mTabla.addRow(rowData);
        });

    }

    private void listarAlmaceEliminar() {
        ///Logica cargar personas
        List<almacenamiento> listap = ModeloAlmacenamiento.listaTodasAlmacenamiento();
        DefaultTableModel mTabla2;
        mTabla2 = (DefaultTableModel) eliminar.getTblAlmacenamiento().getModel();
        mTabla2.setNumRows(0);//limpio la tabla
        listap.stream().forEach(alma -> {
            String[] rowData = {String.valueOf(alma.getIdalmacenamiento()), alma.getMarca(), alma.getModelo(), alma.getTipo(), String.valueOf(alma.getCapacidad()), String.valueOf(alma.getPrecio()), String.valueOf(alma.getId_proveedor()), String.valueOf(alma.getStock())};
            mTabla2.addRow(rowData);
        });

    }

    public void ActualizarAlmacenamiento() {
        String idAlmacenamiento = modificar.getTxtIdA().getText();
        String marca = modificar.getTxtmarca().getText();
        String modelo = modificar.getTxtmodelo().getText();
        String tipo = modificar.getCmbTipo().getSelectedItem().toString();
        int capacidad = (Integer) modificar.getSpCapacidad().getValue();

        double precio = (double) modificar.getSpPrecio().getValue();

        int stock = (Integer) modificar.getSpStock().getValue();
        miAlmacenamiento.setIdalmacenamiento(Integer.parseInt(idAlmacenamiento));
        miAlmacenamiento.setMarca(marca);
        miAlmacenamiento.setModelo(modelo);
        miAlmacenamiento.setTipo(tipo);
        miAlmacenamiento.setCapacidad(capacidad);
        miAlmacenamiento.setPrecio(precio);
        miAlmacenamiento.setStock(stock);

        if (CamposVacios() == true && miAlmacenamiento.editarAlmacenamiento() == null) {
            JOptionPane.showMessageDialog(modificar, "Almacenamiento Actualizado correctamente");
            listarAlmaceModificar();
        } else {
            JOptionPane.showMessageDialog(modificar, "ERROR");

        }

    }

    private void eliminarAlmacenamiento() {
        int fila = eliminar.getTblAlmacenamiento().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(eliminar, "Seleccione una fila!");
        } else {
            String id = (String) eliminar.getTblAlmacenamiento().getValueAt(fila, 0);
            modelo.setIdalmacenamiento(Integer.valueOf(id));
            modelo.eliminar();
            JOptionPane.showMessageDialog(eliminar, "Almacenamiento Actualizado correctamente");
            listarAlmaceEliminar();

        }

    }

    public void cargarCodigosProveedorComboBox() {
        try {
            ArrayList<Integer> codigosProveedor = ModeloAlmacenamiento.obtenerCodigosProveedor();

            crear.getCmbProveedor().removeAllItems();

            for (Integer idProveedor : codigosProveedor) {
                crear.getCmbProveedor().addItem(String.valueOf(idProveedor));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
//        vista.getDlgAlmacenamiento().setVisible(false);
//
//    }
//     private void imprimirAlmacenamientos(){
//        ConexionPg conecction=new ConexionPg();
//        try {
//            JasperReport reporte=(JasperReport)JRLoader.loadObject(
//                    getClass().getResource("/mvc2023/pkg2/vista/reportes/ReporteAlmacenamientos.jasper")
//            );
//            
//            JasperPrint jp =JasperFillManager.fillReport(
//                    reporte,
//                    null,
//                    conecction.getCon());
//            JasperViewer jv=new JasperViewer(jp,false);
//            jv.setVisible(true);
//        } catch (JRException ex) {
//            Logger.getLogger(ControladorAlmacenamientos.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    
    public boolean CamposVacios(){
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
        
        if (crear.getSpCapacidad().getValue().equals(0)) {

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
        
    if(Valor1==false && Valor1==false  && Valor1==false  && Valor1==false ) {
     validar=true;   
    }   else{
        validar = false;
    }
        
        return validar;
    }
    
    
    
}
