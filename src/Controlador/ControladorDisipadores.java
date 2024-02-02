/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloDisipadores;
import Modelo.Disipadores;
import Vistas.CrearDisipadores;
import Vistas.EliminarDisipadores;
import Vistas.ModificarDisipadores;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EDU
 */
public class ControladorDisipadores {

    private ModeloDisipadores modelo;
    private CrearDisipadores crear;
    private ModificarDisipadores modificar;
    private EliminarDisipadores eliminar;
    ModeloDisipadores miDisipadores = new ModeloDisipadores();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    String RGB = "";

    public ControladorDisipadores() {

    }

    public ControladorDisipadores(ModeloDisipadores modelo, CrearDisipadores crear) {
        this.modelo = modelo;
        this.crear = crear;
        crear.setVisible(true);
        //cargarCodigosProveedorComboBox();
    }

    public ControladorDisipadores(ModeloDisipadores modelo, ModificarDisipadores modificar) {
        this.modelo = modelo;
        this.modificar = modificar;
        modificar.setVisible(true);
        listarDisipaModificar();

    }

    public ControladorDisipadores(ModeloDisipadores modelo, EliminarDisipadores eliminar) {
        this.modelo = modelo;
        this.eliminar = eliminar;
        eliminar.setVisible(true);
        listarDisipaEliminar();

    }

    public void iniciaControl() {
        // vista.getBtnEliminarA().addActionListener(l -> listarDisipadores(eliminar.getTblDisipadores()));
        // vista.getBtnExaminar().addActionListener(l -> seleccionarImagen());
//                eliminar.getBtnEliminar().addActionListener(l -> eliminarDisipadores());

        crear.getBtnCrear().addActionListener(l -> grabarDisipadores());

        // vista.getBtnModificar().addActionListener(l -> Actualizar());
        //vista.getBtnCancelar().addActionListener(l -> regresarInicio());
        //         vista.getBtnImprimir().addActionListener(l->imprimirDisipadoress());
    }

    public void iniciaControlEliminar() {
        // vista.getBtnEliminarA().addActionListener(l -> listarDisipadores(eliminar.getTblDisipadores()));
        // vista.getBtnExaminar().addActionListener(l -> seleccionarImagen());
        eliminar.getBtnEliminar().addActionListener(l -> eliminarDisipadores());

        //crear.getBtnCrear().addActionListener(l -> grabarDisipadores());
        // vista.getBtnModificar().addActionListener(l -> Actualizar());
        //vista.getBtnCancelar().addActionListener(l -> regresarInicio());
        //         vista.getBtnImprimir().addActionListener(l->imprimirDisipadoress());
    }

    public void iniciaControlModificar() {
        // vista.getBtnEliminarA().addActionListener(l -> listarDisipadores(eliminar.getTblDisipadores()));
        // vista.getBtnExaminar().addActionListener(l -> seleccionarImagen())

        modificar.getBtnCargardatos().addActionListener(l -> CargarDatos());

        modificar.getBtnModificar().addActionListener(l -> ActualizarDisipadores());

        // vista.getBtnModificar().addActionListener(l -> Actualizar());
        //vista.getBtnCancelar().addActionListener(l -> regresarInicio());
        //         vista.getBtnImprimir().addActionListener(l->imprimirDisipadoress());
    }

    private void grabarDisipadores() {
        // Lógica para grabar
        // Validar antes...

        String marca = crear.getTxtmarca().getText();
        String modelo = crear.getTxtModelo().getText();
        String socket = crear.getTxtsocket().getText();

        if (crear.getRbSi().isSelected()) {
            RGB = "Si";
        } else if (crear.getRbNo().isSelected()) {
            RGB = "No";
        }

        int ventiladores = Integer.valueOf(crear.getCmbVentilador().getSelectedItem().toString());

        double precio = (double) crear.getSpPrecio().getValue();

        int stock = (Integer) crear.getSpStock().getValue();

        miDisipadores.setMarca(marca);
        miDisipadores.setModelo(modelo);
        miDisipadores.setSocket(socket);
        miDisipadores.setRGB(RGB);

        miDisipadores.setVentiladores(ventiladores);
        miDisipadores.setPrecio(precio);
        miDisipadores.setStock(stock);

        if (miDisipadores.grabardisipadores() == null) {
            JOptionPane.showMessageDialog(crear, "Disipador Agregado con Exito");
        } else {
            JOptionPane.showMessageDialog(crear, "error");

        }

    }

    private void CargarDatos() {

        int fila = modificar.getTblDisipadores().getSelectedRow();

        if (fila != -1) {
            String IdD = (String) modificar.getTblDisipadores().getValueAt(fila, 0);
            String marca = (String) modificar.getTblDisipadores().getValueAt(fila, 1);
            String modelo = (String) modificar.getTblDisipadores().getValueAt(fila, 2);
            String socket = (String) modificar.getTblDisipadores().getValueAt(fila, 3);
            String rgb = (String) modificar.getTblDisipadores().getValueAt(fila, 4);
            String ventiladores = (String) modificar.getTblDisipadores().getValueAt(fila, 5);
            String precio = (String) modificar.getTblDisipadores().getValueAt(fila, 6);
            String stock = (String) modificar.getTblDisipadores().getValueAt(fila, 7);

            // Obtener los bytes de la imagen
            // Convertir los bytes a un ImageIcon
            // ImageIcon imagenIcon = new ImageIcon(bytesImagen);
            // Establecer la imagen en el JLabel
            //vista.getLblFoto().setIcon(imagenIcon);
            modificar.getTxtIddisipadores().setText(IdD);
            modificar.getTxtmarca().setText(marca);
            modificar.getTxtModelo().setText(modelo);
            modificar.getTxtsocket().setText(socket);
            if (rgb.equals("Si")) {
                modificar.getRbSi().setSelected(true);
            } else if (rgb.equals("No")) {
                modificar.getRbNo().setSelected(true);
            }

            modificar.getCmbVentilador().setSelectedItem(ventiladores);
            modificar.getSpPrecio().setValue(Double.parseDouble(precio));

            modificar.getSpStock().setValue(Integer.parseInt(stock));

            modificar.getTxtIdD().setEditable(false);

        } else {
            JOptionPane.showMessageDialog(modificar, "Selecciona una fila antes de modificar.");
        }
    }

    private void listarDisipaModificar() {
        ///Logica cargar personas
        List<Disipadores> listap = ModeloDisipadores.listaTodasDisipadores();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) modificar.getTblDisipadores().getModel();
        mTabla.setNumRows(0);//limpio la tabla
        listap.stream().forEach(disi -> {
            String[] rowData = {String.valueOf(disi.getIdDisipadores()), disi.getMarca(), disi.getModelo(), disi.getSocket(), disi.getRGB(), String.valueOf(disi.getVentiladores()), String.valueOf(disi.getPrecio()), String.valueOf(disi.getStock())};
            mTabla.addRow(rowData);
        });

    }

    private void listarDisipaEliminar() {
        ///Logica cargar personas
        List<Disipadores> listap = ModeloDisipadores.listaTodasDisipadores();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) eliminar.getTblDisipadores().getModel();
        mTabla.setNumRows(0);//limpio la tabla
        listap.stream().forEach(disi -> {
            String[] rowData = {String.valueOf(disi.getIdDisipadores()), disi.getMarca(), disi.getModelo(), disi.getSocket(), disi.getRGB(), String.valueOf(disi.getVentiladores()), String.valueOf(disi.getPrecio()), String.valueOf(disi.getStock())};
            mTabla.addRow(rowData);
        });

    }

    public void ActualizarDisipadores() {
        String idDisipadores = modificar.getTxtIdD().getText();

        String marca = modificar.getTxtmarca().getText();
        String modelo = modificar.getTxtModelo().getText();
        String socket = modificar.getTxtsocket().getText();

        if (modificar.getRbSi().isSelected()) {
            RGB = "Si";
        } else if (modificar.getRbNo().isSelected()) {
            RGB = "No";
        }

        int ventiladores = Integer.valueOf(modificar.getCmbVentilador().getSelectedItem().toString());

        double precio = (double) modificar.getSpPrecio().getValue();

        int stock = (Integer) modificar.getSpStock().getValue();
        miDisipadores.setIdDisipadores(Integer.parseInt(idDisipadores));

        miDisipadores.setMarca(marca);

        miDisipadores.setMarca(marca);
        miDisipadores.setModelo(modelo);
        miDisipadores.setSocket(socket);
        miDisipadores.setRGB(RGB);

        miDisipadores.setVentiladores(ventiladores);
        miDisipadores.setPrecio(precio);
        miDisipadores.setStock(stock);

        if (miDisipadores.editardisipadores() == null) {
            JOptionPane.showMessageDialog(modificar, "Disipadores Actualizado correctamente");
            listarDisipaModificar();
        } else {
            JOptionPane.showMessageDialog(modificar, "ERROR");

        }

    }

    private void eliminarDisipadores() {
        int fila = eliminar.getTblDisipadores().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(eliminar, "Seleccione una fila!");
        } else {
            String id = (String) eliminar.getTblDisipadores().getValueAt(fila, 0);
            modelo.setIdDisipadores(Integer.valueOf(id));
            modelo.eliminar();
            JOptionPane.showMessageDialog(eliminar, "Disipadores Actualizado correctamente");
            listarDisipaEliminar();

        }

    }

//    public void cargarCodigosProveedorComboBox() {
//        try {
//            ArrayList<Integer> codigosProveedor = ModeloDisipadores.obtenerCodigosProveedor();
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
//        vista.getDlgDisipadores().setVisible(false);
//
//    }
//     private void imprimirDisipadoress(){
//        ConexionPg conecction=new ConexionPg();
//        try {
//            JasperReport reporte=(JasperReport)JRLoader.loadObject(
//                    getClass().getResource("/mvc2023/pkg2/vista/reportes/ReporteDisipadoress.jasper")
//            );
//            
//            JasperPrint jp =JasperFillManager.fillReport(
//                    reporte,
//                    null,
//                    conecction.getCon());
//            JasperViewer jv=new JasperViewer(jp,false);
//            jv.setVisible(true);
//        } catch (JRException ex) {
//            Logger.getLogger(ControladorDisipadoress.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public boolean CamposVacios() {
        boolean validar = true;
        boolean Valor1 = true;
        boolean Valor2 = true;
        boolean Valor3 = true;
        boolean Valor4 = true;
        boolean Valor5 = true;

        if (crear.getTxtmarca().getText().isEmpty()) {

            JOptionPane.showMessageDialog(crear, "Campo Vacio en Marca");
            Valor1 = true;
        } else {
            Valor1 = false;
        }

        if (crear.getTxtModelo().getText().isEmpty()) {

            JOptionPane.showMessageDialog(crear, "Campo Vacio en Modelo");
            Valor2 = true;
        } else {
            Valor2 = false;
        }

        if (crear.getSpPrecio().getValue().equals(0.0)) {

            JOptionPane.showMessageDialog(crear, "Registre un precio");
            Valor4 = true;
        } else {
            Valor4 = false;
        }

        if (crear.getSpStock().getValue().equals(0.0)) {

            JOptionPane.showMessageDialog(crear, "Registre el Stock");
            Valor5 = true;
        } else {
            Valor5 = false;
        }

        if (Valor1 == false && Valor2 == false && Valor3 == false && Valor4 == false && Valor5 == false) {
            validar = true;
        } else {
            validar = false;
        }

        return validar;
    }

}
