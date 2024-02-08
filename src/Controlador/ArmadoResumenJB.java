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
import Modelo.ModeloTarjetaGrafica;
import Clases.Disipadores;
import Modelo.ModeloPlacaMadre;
import Vista.ArmadoResumen_JB;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
/**
 *
 * @author TheBigG
 */
public class ArmadoResumenJB {

    private ArmadoResumen_JB vista; // Referencia a la vista de armado de procesadores
    public PC pc = ArmadoProcJB.pc;

    public ArmadoResumenJB(ArmadoResumen_JB vista) {
        this.vista = vista; // Asigna la vista recibida como parámetro
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
                        int id =(int) vista.getJtResumen().getValueAt(filaSeleccionada, 0);
                        
                    }
                }
            }
        });

    }

    public void cargarComponentes(int idPc) {
        PC pc;
        Procesador procesador = new Procesador();
        Placamadre placaMadre = new ModeloPlacaMadre();
        Tarjetagrafica tarjetaGrafica = new ModeloTarjetaGrafica();
        memoriaRam ram = new memoriaRam();
        FuentePoder Fuente = new FuentePoder();
        almacenamiento almacenamientoV = new almacenamiento();
        Gabinete gabinete = new Gabinete();
        ArrayList<Ventiladores> ventiladores = new ArrayList<>();
        Disipadores disipador = new Disipadores();

    }
}
