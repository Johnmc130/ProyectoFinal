/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloMemoriaRam;
import Clases.memoriaRam;
import Vistas.CrearMemoriaRam;
import Vistas.EliminarMemoriaRam;
import Vistas.ModificarMemoriaRam;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EDU
 */
public class ControladorMemoriaRam {

    private ModeloMemoriaRam modelo;
    private CrearMemoriaRam crear;
    private ModificarMemoriaRam modificar;
    private EliminarMemoriaRam eliminar;
    ModeloMemoriaRam mimemoriaRam = new ModeloMemoriaRam();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    int numero = 0;

    public ControladorMemoriaRam() {

    }

    public ControladorMemoriaRam(ModeloMemoriaRam modelo, CrearMemoriaRam crear) {
        this.modelo = modelo;
        this.crear = crear;
        crear.setVisible(true);
       // cargarCodigosProveedorComboBox();
    }

    public ControladorMemoriaRam(ModeloMemoriaRam modelo, ModificarMemoriaRam modificar) {
        this.modelo = modelo;
        this.modificar = modificar;
        modificar.setVisible(true);
        listarAlmaceModificar();

    }

    public ControladorMemoriaRam(ModeloMemoriaRam modelo, EliminarMemoriaRam eliminar) {
        this.modelo = modelo;
        this.eliminar = eliminar;
        eliminar.setVisible(true);
        listarAlmaceEliminar();

    }

    public void iniciaControl() {
        // vista.getBtnEliminarA().addActionListener(l -> listarmemoriaRam(eliminar.getTblMemoria()));
        // vista.getBtnExaminar().addActionListener(l -> seleccionarImagen());
//                eliminar.getBtnEliminar().addActionListener(l -> eliminarmemoriaRam());

        crear.getBtnCrear().addActionListener(l -> grabarmemoriaRam());

        // vista.getBtnModificar().addActionListener(l -> Actualizar());
        //vista.getBtnCancelar().addActionListener(l -> regresarInicio());
        //         vista.getBtnImprimir().addActionListener(l->imprimirmemoriaRams());
    }

    public void iniciaControlEliminar() {
        // vista.getBtnEliminarA().addActionListener(l -> listarmemoriaRam(eliminar.getTblMemoria()));
        // vista.getBtnExaminar().addActionListener(l -> seleccionarImagen());
        eliminar.getBtnEliminar().addActionListener(l -> eliminarmemoriaRam());

        //crear.getBtnCrear().addActionListener(l -> grabarmemoriaRam());
        // vista.getBtnModificar().addActionListener(l -> Actualizar());
        //vista.getBtnCancelar().addActionListener(l -> regresarInicio());
        //         vista.getBtnImprimir().addActionListener(l->imprimirmemoriaRams());
    }

    public void iniciaControlModificar() {
        // vista.getBtnEliminarA().addActionListener(l -> listarmemoriaRam(eliminar.getTblMemoria()));
        // vista.getBtnExaminar().addActionListener(l -> seleccionarImagen())

        modificar.getBtnCargardatos().addActionListener(l -> CargarDatos());

        modificar.getBtnModificar().addActionListener(l -> ActualizarmemoriaRam());

        // vista.getBtnModificar().addActionListener(l -> Actualizar());
        //vista.getBtnCancelar().addActionListener(l -> regresarInicio());
        //         vista.getBtnImprimir().addActionListener(l->imprimirmemoriaRams());
    }

    private void grabarmemoriaRam() {
        // Lógica para grabar
        // Validar antes...

        String marca = crear.getTxtmarca().getText();
        String modelo = crear.getTxtmodelo().getText();
        String tipo = crear.getCmbTipo().getSelectedItem().toString();
        int capacidad = (Integer) crear.getSpCapacidad().getValue();
        if (crear.getRb1().isSelected()) {
            numero = Integer.parseInt("1");
        } else if (crear.getRb2().isSelected()) {
            numero = Integer.parseInt("2");
        }
        double precio = (double) crear.getSpPrecio().getValue();

        int stock = (Integer) crear.getSpStock().getValue();

        mimemoriaRam.setMarca(marca);
        mimemoriaRam.setModelo(modelo);
        mimemoriaRam.setTipo(tipo);
        mimemoriaRam.setCapacidad(capacidad);
        mimemoriaRam.setPrecio(precio);
        mimemoriaRam.setNumeroModulos(numero);
        mimemoriaRam.setStock(stock);

        if (CamposVacios() == true && mimemoriaRam.grabarmemoriaRam() == null) {
            JOptionPane.showMessageDialog(crear, "Memoria Ram Agregado con Exito");
        } else {
            JOptionPane.showMessageDialog(crear, "error");

        }

    }

    private void CargarDatos() {

        int fila = modificar.getTblMemoria().getSelectedRow();

        if (fila != -1) {
            String IdM = (String) modificar.getTblMemoria().getValueAt(fila, 0);
            String marca = (String) modificar.getTblMemoria().getValueAt(fila, 1);
            String modelo = (String) modificar.getTblMemoria().getValueAt(fila, 2);
            String tipo = (String) modificar.getTblMemoria().getValueAt(fila, 3);
            String capacidad = (String) modificar.getTblMemoria().getValueAt(fila, 4);
            String numero = (String) modificar.getTblMemoria().getValueAt(fila, 5);

            String precio = (String) modificar.getTblMemoria().getValueAt(fila, 6);
            String stock = (String) modificar.getTblMemoria().getValueAt(fila, 7);

            // Obtener los bytes de la imagen
            // Convertir los bytes a un ImageIcon
            // ImageIcon imagenIcon = new ImageIcon(bytesImagen);
            // Establecer la imagen en el JLabel
            //vista.getLblFoto().setIcon(imagenIcon);
            modificar.getTxtIdM().setText(IdM);
            modificar.getTxtmarca().setText(marca);
            modificar.getTxtmodelo().setText(modelo);
            if (numero.equals("1")) {
                modificar.getRb1().setSelected(true);
            } else if (numero.equals("2")) {
                modificar.getRb2().setSelected(true);
            }
            modificar.getCmbTipo().setSelectedItem(tipo);
            modificar.getSpCapacidad().setValue(Integer.parseInt(capacidad));
            modificar.getSpPrecio().setValue(Double.parseDouble(precio));

            modificar.getSpStock().setValue(Integer.parseInt(stock));

            modificar.getTxtIdM().setEditable(false);

        } else {
            JOptionPane.showMessageDialog(modificar, "Selecciona una fila antes de modificar.");
        }
    }

    private void listarAlmaceModificar() {
        ///Logica cargar personas
        List<memoriaRam> listap = ModeloMemoriaRam.listaTodasmemoriaRam();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) modificar.getTblMemoria().getModel();
        mTabla.setNumRows(0);//limpio la tabla
        listap.stream().forEach(memo -> {
            String[] rowData = {String.valueOf(memo.getIdMemoriaRam()), memo.getMarca(), memo.getModelo(), memo.getTipo(), String.valueOf(memo.getCapacidad()), String.valueOf(memo.getNumeroModulos()), String.valueOf(memo.getPrecio()), String.valueOf(memo.getStock())};
            mTabla.addRow(rowData);
        });

    }

    private void listarAlmaceEliminar() {
        ///Logica cargar personas
        List<memoriaRam> listap = ModeloMemoriaRam.listaTodasmemoriaRam();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) eliminar.getTblMemoria().getModel();
        mTabla.setNumRows(0);//limpio la tabla
        listap.stream().forEach(memo -> {
            String[] rowData = {String.valueOf(memo.getIdMemoriaRam()), memo.getMarca(), memo.getModelo(), memo.getTipo(), String.valueOf(memo.getCapacidad()), String.valueOf(memo.getNumeroModulos()), String.valueOf(memo.getPrecio()), String.valueOf(memo.getStock())};
            mTabla.addRow(rowData);
        });

    }

    public void ActualizarmemoriaRam() {
        String idmemoriaRam = modificar.getTxtIdM().getText();
        String marca = modificar.getTxtmarca().getText();
        String modelo = modificar.getTxtmodelo().getText();
        String tipo = modificar.getCmbTipo().getSelectedItem().toString();
        int capacidad = (Integer) modificar.getSpCapacidad().getValue();
        if (modificar.getRb1().isSelected()) {
            numero = Integer.parseInt("1");
        } else if (modificar.getRb2().isSelected()) {
            numero = Integer.parseInt("2");
        }
        double precio = (double) modificar.getSpPrecio().getValue();

        int stock = (Integer) modificar.getSpStock().getValue();
        mimemoriaRam.setIdMemoriaRam(Integer.parseInt(idmemoriaRam));

        mimemoriaRam.setMarca(marca);
        mimemoriaRam.setModelo(modelo);
        mimemoriaRam.setTipo(tipo);
        mimemoriaRam.setCapacidad(capacidad);
        mimemoriaRam.setPrecio(precio);
        mimemoriaRam.setNumeroModulos(numero);
        mimemoriaRam.setStock(stock);

        if ( mimemoriaRam.editarmemoriaRam() == null) {
            JOptionPane.showMessageDialog(modificar, "memoriaRam Actualizado correctamente");
            listarAlmaceModificar();
        } else {
            JOptionPane.showMessageDialog(modificar, "ERROR");

        }

    }

    private void eliminarmemoriaRam() {
        int fila = eliminar.getTblMemoria().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(eliminar, "Seleccione una fila!");
        } else {
            String id = (String) eliminar.getTblMemoria().getValueAt(fila, 0);
            modelo.setIdMemoriaRam(Integer.valueOf(id));
            modelo.eliminar();
            JOptionPane.showMessageDialog(eliminar, "memoriaRam Actualizado correctamente");
            listarAlmaceEliminar();

        }

    }

//    public void cargarCodigosProveedorComboBox() {
//        try {
//            ArrayList<Integer> codigosProveedor = ModelomemoriaRam.obtenerCodigosProveedor();
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
//        vista.getDlgmemoriaRam().setVisible(false);
//
//    }
//     private void imprimirmemoriaRams(){
//        ConexionPg conecction=new ConexionPg();
//        try {
//            JasperReport reporte=(JasperReport)JRLoader.loadObject(
//                    getClass().getResource("/mvc2023/pkg2/vista/reportes/ReportememoriaRams.jasper")
//            );
//            
//            JasperPrint jp =JasperFillManager.fillReport(
//                    reporte,
//                    null,
//                    conecction.getCon());
//            JasperViewer jv=new JasperViewer(jp,false);
//            jv.setVisible(true);
//        } catch (JRException ex) {
//            Logger.getLogger(ControladormemoriaRams.class.getName()).log(Level.SEVERE, null, ex);
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

        if (Valor1 == false && Valor1 == false && Valor1 == false && Valor1 == false) {
            validar = true;
        } else {
            validar = false;
        }

        return validar;
    }

}
