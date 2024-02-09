package Controlador;

import Clases.FuentePoder;
import Clases.Gabinete;
import Clases.PC;
import Clases.Placamadre;
import Clases.Procesador;
import Clases.Tarjetagrafica;
import Clases.Ventiladores;
import Clases.almacenamiento;
import Clases.memoriaRam;
import Clases.Disipadores;
import Modelo.ModeloPcResumen;
import Vista.ArmadoResumen_JB;
import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author TheBigG
 */
public class ArmadoResumenJB {

    private ArmadoResumen_JB vista; // Referencia a la vista de armado de procesadores
    public PC pc = ArmadoProcJB.pc;
    private ModeloPcResumen modelo;

    public ArmadoResumenJB(ArmadoResumen_JB vista, ModeloPcResumen modelo) {
        this.vista = vista; // Asigna la vista recibida como parámetro
        this.modelo = modelo;
        vista.setVisible(true); // Hace visible la vista

    }

    /**
     * Método que inicia la configuración de la vista y carga los componentes.
     */
    public void Inicio() {
        vista.setLocationRelativeTo(null); // Centra la ventana en la pantalla  
        // Obtener la columna deseada (en este caso, la segunda columna)
        TableColumn columna = vista.getJtResumen().getColumnModel().getColumn(1); // El índice es 1 para la segunda columna
        // Establecer el ancho preferido de la columna
        columna.setPreferredWidth(50);
        // Agrega listeners a los botones de la vista para manejar acciones del usuario

        // Agrega un oyente de selección a la tabla
        vista.getJtResumen().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // Verificar que la selección haya terminado
                    // Obtener el índice de la fila seleccionada
                    int filaSeleccionada = vista.getJtResumen().getSelectedRow();
                    if (filaSeleccionada != -1) { // Verificar si se ha seleccionado alguna fila
                        // Obtener el valor del campo en la columna 0 de la fila seleccionada
                        int id = (int) vista.getJtResumen().getValueAt(filaSeleccionada, 0);
                        String tipo = (String) vista.getJtResumen().getValueAt(filaSeleccionada, 2);
                        // Cargar la imagen correspondiente al componente seleccionado
                        cargarImagenComponente(id, tipo);

                    }
                }
            }
        });

    }

    public void cargarComponentes() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.getJtResumen().getModel();
        // Limpiar la tabla antes de cargar nuevos datos
        modeloTabla.setRowCount(0);

        // Cargar procesador
        Procesador procesador = modelo.cargarProcesador(pc.getIdProcesador());
        modeloTabla.addRow(new Object[]{procesador.getIdProcesador(), procesador.getMarca() + " " + procesador.getModelo(), "Procesador"});

        // Cargar placa madre
        Placamadre placaMadre = modelo.cargarPlacaMadre(pc.getIdPlacaMadre());
        modeloTabla.addRow(new Object[]{placaMadre.getIdplacam(), placaMadre.getMarca() + " " + placaMadre.getModelo(), "Placa madre"});

        // Cargar tarjeta gráfica
        Tarjetagrafica tarjetaGrafica = modelo.cargarTarjetaGrafica(pc.getIdTarjetaGrafica());
        modeloTabla.addRow(new Object[]{tarjetaGrafica.getIdtarjetag(), tarjetaGrafica.getMarca() + " " + tarjetaGrafica.getModelo(), "Tarjeta gráfica"});

        // Cargar RAM
        memoriaRam ram = modelo.cargarMemoriaRam(pc.getIdRam());
        modeloTabla.addRow(new Object[]{ram.getIdMemoriaRam(), ram.getMarca() + " " + ram.getModelo(), "RAM"});

        // Cargar fuente de poder
        FuentePoder fuentePoder = modelo.cargarFuentePoder(pc.getIdFuentePoder());
        modeloTabla.addRow(new Object[]{fuentePoder.getIdFuentePoder(), fuentePoder.getMarca() + " " + fuentePoder.getModelo(), "Fuente de poder"});

        // Cargar almacenamiento
        almacenamiento almacenamiento = modelo.cargarAlmacenamiento(pc.getIdAlmacenamiento());
        modeloTabla.addRow(new Object[]{almacenamiento.getIdalmacenamiento(), almacenamiento.getMarca() + " " + almacenamiento.getModelo(), "Almacenamiento"});

        // Cargar gabinete
        Gabinete gabinete = modelo.cargarGabinete(pc.getIdGabinete());
        modeloTabla.addRow(new Object[]{gabinete.getIdgabinete(), gabinete.getMarca() + " " + gabinete.getModelo(), "Gabinete"});

        // Cargar ventilador
        Ventiladores ventilador1 = modelo.cargarVentiladores(pc.getIdVentiladores());
        modeloTabla.addRow(new Object[]{ventilador1.getIdVentiladores(), ventilador1.getMarca() + " " + ventilador1.getModelo(), "Ventilador"});
       
        // Cargar disipador
        Disipadores disipador = modelo.cargarDisipadores(pc.getIdDisipador());
        modeloTabla.addRow(new Object[]{disipador.getIdDisipadores(), disipador.getMarca() + " " + disipador.getModelo(), "Disipador"});
    }

// Método para cargar la imagen del componente seleccionado
    private void cargarImagenComponente(int idComponente, String tipo) {
        Object componente = null;

        // Determina el tipo de componente según el ID
        switch (tipo) {
            case "Procesador": // Procesador
                componente = modelo.cargarProcesador(idComponente);
                break;
            case "Placa madre": // Placa madre
                componente = modelo.cargarPlacaMadre(idComponente);
                break;
            case "Tarjeta gráfica": // Tarjeta gráfica
                componente = modelo.cargarTarjetaGrafica(idComponente);
                break;
            case "RAM": // RAM
                componente = modelo.cargarMemoriaRam(idComponente);
                break;
            case "Fuente de poder": // Fuente de poder
                componente = modelo.cargarFuentePoder(idComponente);
                break;
            case "Almacenamiento": // Almacenamiento
                componente = modelo.cargarAlmacenamiento(idComponente);
                break;
            case "Gabinete": // Gabinete
                componente = modelo.cargarGabinete(idComponente);
                break;
            case "Ventilador": // Ventiladores (asumiendo que hay uno solo para simplificar)
                componente = modelo.cargarVentiladores(idComponente);
                break;
            case "Disipador": // Disipador
                componente = modelo.cargarDisipadores(idComponente);
                break;
        }

        // Lógica para cargar la imagen según el ID del componente
        ImageIcon imagenIcono = null;

        // Verifica si se obtuvo el componente y si es del tipo esperado
        if (componente != null) {
            byte[] fotoByte = null;

            // Obtén la foto del componente según su tipo
            if (componente instanceof Procesador) {
                fotoByte = ((Procesador) componente).getImagen();
            } else if (componente instanceof Placamadre) {
                fotoByte = ((Placamadre) componente).getFoto();
            } else if (componente instanceof Tarjetagrafica) {
                fotoByte = ((Tarjetagrafica) componente).getFoto();
            } else if (componente instanceof memoriaRam) {
                fotoByte = ((memoriaRam) componente).getFoto();
            } else if (componente instanceof FuentePoder) {
                fotoByte = ((FuentePoder) componente).getFoto();
            } else if (componente instanceof almacenamiento) {
                fotoByte = ((almacenamiento) componente).getFoto();
            } else if (componente instanceof Gabinete) {
                fotoByte = ((Gabinete) componente).getFoto();
            } else if (componente instanceof Ventiladores) {
                fotoByte = ((Ventiladores) componente).getFoto();
            } else if (componente instanceof Disipadores) {
                fotoByte = ((Disipadores) componente).getFoto();
            } else {
                System.out.println("componente no es instancia de ningun tipo");
            }

            // Convertir el byte[] en un ImageIcon
            if (fotoByte != null) {
                imagenIcono = new ImageIcon(fotoByte);
            } else {
                System.out.println("imagen nula");
            }
        } else {
            System.out.println("Componente nulo");
        }

        // Establecer el ImageIcon en el JLabel
        vista.getLblImagen().setIcon(imagenIcono);
    }

}
