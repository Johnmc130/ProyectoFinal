/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ModeloAlmacenamiento;
import Modelo.ModeloDisipadores;
import Modelo.ModeloFuentePoder;
import Modelo.ModeloGabinete;
import Modelo.ModeloMemoriaRam;
import Modelo.ModeloPlacaMadre;
import Modelo.ModeloProcesador;
import Modelo.ModeloTarjetaGrafica;
import Modelo.ModeloVentiladores;
import Vista.CRUD_Productos_JB;
import Vista.*;

/**
 *
 * @author TheBigG
 */
public class CRUD_ProductosJB {

    private CRUD_Productos_JB vista;

    public CRUD_ProductosJB(CRUD_Productos_JB vista) {
        this.vista = vista;
        vista.setVisible(true);
    }

    public void iniciar() {
        //Botones componentes
        vista.getBtProcesador().addActionListener(l -> crud(1));
        vista.getBtPlacaMadre().addActionListener(l -> crud(2));
        vista.getBtRam().addActionListener(l -> crud(3));
        vista.getBtAlmacenamiento().addActionListener(l -> crud(4));
        vista.getBtTarjetaGrafica().addActionListener(l -> crud(5));
        vista.getBtDisipador().addActionListener(l -> crud(6));
        vista.getBtVentiladores().addActionListener(l -> crud(7));
        vista.getBtFuente().addActionListener(l -> crud(8));
        vista.getBtGabinete().addActionListener(l -> crud(9));
        vista.getBtAtrasDlg().addActionListener(l -> atrasDlg());
    }

    //Cargar botones JDialog
    public void crud(int numero) {
        switch (numero) {
            case 1:
                vista.getLblTitulo().setText("Procesadores");
                vista.getBtAgregar().addActionListener(l -> crudProcesadorCrear());
                vista.getBtModificar().addActionListener(l -> crudProcesadorModificar());
                vista.getBtEliminar().addActionListener(l -> crudProcesadorEliminar());
                break;
            case 2:
                vista.getLblTitulo().setText("Placas madre");
                vista.getBtAgregar().addActionListener(l -> crudPlacaMadCrear());
                vista.getBtModificar().addActionListener(l -> crudPlacaMadModificar());
                vista.getBtEliminar().addActionListener(l -> crudPlacaMadEliminar());
                break;
            case 3:
                vista.getLblTitulo().setText("RAMs");
                vista.getBtAgregar().addActionListener(l -> crudMemoriaRamCrear());
                vista.getBtModificar().addActionListener(l -> crudMemoriaRamModificar());
                vista.getBtEliminar().addActionListener(l -> crudMemoriaRamEliminar());
                break;
            case 4:
                vista.getLblTitulo().setText("Almacenamientos");
                vista.getBtAgregar().addActionListener(l -> crudAlmacenamientoCrear());
                vista.getBtModificar().addActionListener(l -> crudAlmacenamientoModificar());
                vista.getBtEliminar().addActionListener(l -> crudAlmacenamientoEliminar());
                break;
            case 5:
                vista.getLblTitulo().setText("Tarjetas Graficas");
                vista.getBtAgregar().addActionListener(l -> crudTarjetaGraficaCrear());
                vista.getBtModificar().addActionListener(l -> crudTarjetaGraficaModificar());
                vista.getBtEliminar().addActionListener(l -> crudTarjetaGraficaEliminar());
                break;
            case 6:
                vista.getLblTitulo().setText("Disipadores");
                vista.getBtAgregar().addActionListener(l -> crudDisipadorCrear());
                vista.getBtModificar().addActionListener(l -> crudDisipadorModificar());
                vista.getBtEliminar().addActionListener(l -> crudDisipadorEliminar());
                break;
            case 7:
                vista.getLblTitulo().setText("Ventiladores");
                vista.getBtAgregar().addActionListener(l -> crudVentiladorCrear());
                vista.getBtModificar().addActionListener(l -> crudVentiladoModificar());
                vista.getBtEliminar().addActionListener(l -> crudVentiladoEliminar());
                break;
            case 8:
                vista.getLblTitulo().setText("Fuentes de Poder");
                vista.getBtAgregar().addActionListener(l -> crudFuentePoderCrear());
                vista.getBtModificar().addActionListener(l -> crudFuentePoderModificar());
                vista.getBtEliminar().addActionListener(l -> crudFuentePoderEliminar());
                break;
            case 9:
                vista.getLblTitulo().setText("Gabinetes");
                vista.getBtAgregar().addActionListener(l -> crudGabinetesCrear());
                vista.getBtModificar().addActionListener(l -> crudGabinetesModificar());
                vista.getBtEliminar().addActionListener(l -> crudGabinetesEliminar());
                break;
        }
        vista.setEnabled(false);
        vista.getJdlgCRUD().setSize(600, 460);
        vista.getJdlgCRUD().setLocationRelativeTo(vista);
        vista.getJdlgCRUD().setUndecorated(true);

        vista.getJdlgCRUD().setVisible(true);

    }

    //Cierre de dialogo y habilitacion de Frame principal
    public void atrasDlg() {
        vista.getJdlgCRUD().setVisible(false);
        vista.getJdlgCRUD().dispose();
        vista.setEnabled(true);
        vista.setVisible(true);
    }

    //PROCESADOR
    private void crudProcesadorCrear() {
        ModeloProcesador modelo = new ModeloProcesador();
        CrearProcesador vprocesador = new CrearProcesador();
        ControladorProcesador controladoragregar = new ControladorProcesador(modelo, vprocesador);
        controladoragregar.iniciaControl();
    }

    private void crudProcesadorModificar() {
        ModeloProcesador modelo = new ModeloProcesador();
        ModificarProcesador vprocesador = new ModificarProcesador();
        ControladorProcesador controladormod = new ControladorProcesador(modelo, vprocesador);
        controladormod.iniciaControlModificar();
    }

    private void crudProcesadorEliminar() {
        ModeloProcesador modelo = new ModeloProcesador();
        EliminarProcesador vprocesador = new EliminarProcesador();
        ControladorProcesador controladorEliminar = new ControladorProcesador(modelo, vprocesador);
        controladorEliminar.iniciaControlEliminar();
    }

    //PLACA MADRE
    private void crudPlacaMadCrear() {
        ModeloPlacaMadre modelo = new ModeloPlacaMadre();
        CrearPlacaMadre vistacrea = new CrearPlacaMadre();
        ControladorPlacaMadre controladoragregar = new ControladorPlacaMadre(modelo, vistacrea);
        controladoragregar.iniciaControl();
    }

    private void crudPlacaMadModificar() {
        ModeloPlacaMadre modelo = new ModeloPlacaMadre();
        ModificarPlacaMadre vistamodi = new ModificarPlacaMadre();
        ControladorPlacaMadre controladormod = new ControladorPlacaMadre(modelo, vistamodi);
        controladormod.iniciaControlModificar();
    }

    private void crudPlacaMadEliminar() {
        ModeloPlacaMadre modelo = new ModeloPlacaMadre();
        EliminarPlacaMadre vistaelim = new EliminarPlacaMadre();
        ControladorPlacaMadre controladorEliminar = new ControladorPlacaMadre(modelo, vistaelim);
        controladorEliminar.iniciaControlEliminar();
    }

    //RAM
    private void crudMemoriaRamCrear() {
        ModeloMemoriaRam modelo = new ModeloMemoriaRam();
        CrearMemoriaRam vistacrea = new CrearMemoriaRam();
        ControladorMemoriaRam controladoragregar = new ControladorMemoriaRam(modelo, vistacrea);
        controladoragregar.iniciaControl();
    }

    private void crudMemoriaRamModificar() {
        ModeloMemoriaRam modelo = new ModeloMemoriaRam();
        ModificarMemoriaRam vistamodi = new ModificarMemoriaRam();
        ControladorMemoriaRam controladormod = new ControladorMemoriaRam(modelo, vistamodi);
        controladormod.iniciaControlModificar();
    }

    private void crudMemoriaRamEliminar() {
        ModeloMemoriaRam modelo = new ModeloMemoriaRam();
        EliminarMemoriaRam vistaelim = new EliminarMemoriaRam();
        ControladorMemoriaRam controladorEliminar = new ControladorMemoriaRam(modelo, vistaelim);
        controladorEliminar.iniciaControlEliminar();
    }
    //ALMACENAMIENTO
    private void crudAlmacenamientoCrear() {
        ModeloAlmacenamiento modelo = new ModeloAlmacenamiento();
        CrearAlmacenamiento vistacrea = new CrearAlmacenamiento();
        ControladorAlmacenamiento controladoragregar = new ControladorAlmacenamiento(modelo, vistacrea);
        controladoragregar.iniciaControl();
    }

    private void crudAlmacenamientoModificar() {
        ModeloAlmacenamiento modelo = new ModeloAlmacenamiento();
        ModificarAlmacenamiento vistamodi = new ModificarAlmacenamiento();
        ControladorAlmacenamiento controladormod = new ControladorAlmacenamiento(modelo, vistamodi);
        controladormod.iniciaControlModificar();
    }

    private void crudAlmacenamientoEliminar() {
        ModeloAlmacenamiento modelo = new ModeloAlmacenamiento();
        EliminarAlmacenamiento vistaelim = new EliminarAlmacenamiento();
        ControladorAlmacenamiento controladorEliminar = new ControladorAlmacenamiento(modelo, vistaelim);
        controladorEliminar.iniciaControlEliminar();
    }
    //TARJETA GRAFICA
    private void crudTarjetaGraficaCrear() {
        ModeloTarjetaGrafica modelo = new ModeloTarjetaGrafica();
        CrearTarjetaGrafica vistacrea = new CrearTarjetaGrafica();
        ControladorTarjetaGrafica controladoragregar = new ControladorTarjetaGrafica(modelo, vistacrea);
        controladoragregar.iniciaControl();
    }

    private void crudTarjetaGraficaModificar() {
        ModeloTarjetaGrafica modelo = new ModeloTarjetaGrafica();
        ModificarTarjetaGrafica vistamodi = new ModificarTarjetaGrafica();
        ControladorTarjetaGrafica controladormod = new ControladorTarjetaGrafica(modelo, vistamodi);
        controladormod.iniciaControlModificar();
    }

    private void crudTarjetaGraficaEliminar() {
        ModeloTarjetaGrafica modelo = new ModeloTarjetaGrafica();
        EliminarTarjetaGrafica vistaelim = new EliminarTarjetaGrafica();
        ControladorTarjetaGrafica controladorEliminar = new ControladorTarjetaGrafica(modelo, vistaelim);
        controladorEliminar.iniciaControlEliminar();
    }
    //DISIPADOR
    private void crudDisipadorCrear() {
        ModeloDisipadores modelo = new ModeloDisipadores();
        CrearDisipadores vistacrea = new CrearDisipadores();
        ControladorDisipadores controladoragregar = new ControladorDisipadores(modelo, vistacrea);
        controladoragregar.iniciaControl();
    }

    private void crudDisipadorModificar() {
        ModeloDisipadores modelo = new ModeloDisipadores();
        ModificarDisipadores vistamodi = new ModificarDisipadores();
        ControladorDisipadores controladormod = new ControladorDisipadores(modelo, vistamodi);
        controladormod.iniciaControlModificar();
    }

    private void crudDisipadorEliminar() {
        ModeloDisipadores modelo = new ModeloDisipadores();
        EliminarDisipadores vistaelim = new EliminarDisipadores();
        ControladorDisipadores controladorEliminar = new ControladorDisipadores(modelo, vistaelim);
        controladorEliminar.iniciaControlEliminar();
    }
    //Ventiladores
    private void crudVentiladorCrear() {
        ModeloVentiladores modelo = new ModeloVentiladores();
        CrearVentiladores vistacrea = new CrearVentiladores();
        ControladorVentiladores controladoragregar = new ControladorVentiladores(modelo, vistacrea);
        controladoragregar.iniciaControl();
    }

    private void crudVentiladoModificar() {
        ModeloVentiladores modelo = new ModeloVentiladores();
        ModificarVentiladores vistamodi = new ModificarVentiladores();
        ControladorVentiladores controladormod = new ControladorVentiladores(modelo, vistamodi);
        controladormod.iniciaControlModificar();
    }

    private void crudVentiladoEliminar() {
        ModeloVentiladores modelo = new ModeloVentiladores();
        EliminarVentiladores vistaelim = new EliminarVentiladores();
        ControladorVentiladores controladorEliminar = new ControladorVentiladores(modelo, vistaelim);
        controladorEliminar.iniciaControlEliminar();
    }
    //FUENTES DE PODER
    private void crudFuentePoderCrear() {
        ModeloFuentePoder modelo = new ModeloFuentePoder();
        CrearFuentePoder vistacrea = new CrearFuentePoder();
        ControladorFuentePoder controladoragregar = new ControladorFuentePoder(modelo, vistacrea);
        controladoragregar.iniciaControl();
    }

    private void crudFuentePoderModificar() {
        ModeloFuentePoder modelo = new ModeloFuentePoder();
        ModificarFuentePoder vistamodi = new ModificarFuentePoder();
        ControladorFuentePoder controladormod = new ControladorFuentePoder(modelo, vistamodi);
        controladormod.iniciaControlModificar();
    }

    private void crudFuentePoderEliminar() {
        ModeloFuentePoder modelo = new ModeloFuentePoder();
        EliminarFuentePoder vistaelim = new EliminarFuentePoder();
        ControladorFuentePoder controladorEliminar = new ControladorFuentePoder(modelo, vistaelim);
        controladorEliminar.iniciaControlEliminar();
    }
    //Gabinetes
    private void crudGabinetesCrear() {
        ModeloGabinete modelo = new ModeloGabinete();
        CrearGabinetes vistacrea = new CrearGabinetes();
        ControladorGabinete controladoragregar = new ControladorGabinete(modelo, vistacrea);
        controladoragregar.iniciaControl();
    }

    private void crudGabinetesModificar() {
        ModeloGabinete modelo = new ModeloGabinete();
        ModificarGabinetes vistamodi = new ModificarGabinetes();
        ControladorGabinete controladormod = new ControladorGabinete(modelo, vistamodi);
        controladormod.iniciaControlModificar();
    }

    private void crudGabinetesEliminar() {
        ModeloGabinete modelo = new ModeloGabinete();
        EliminarGabinete vistaelim = new EliminarGabinete();
        ControladorGabinete controladorEliminar = new ControladorGabinete(modelo, vistaelim);
        controladorEliminar.iniciaControlEliminar();
    }
}
