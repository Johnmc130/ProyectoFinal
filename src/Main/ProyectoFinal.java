package Main;

import Clases.DatosVenta;
import Controlador.ArmadoPlacaJB;
import Controlador.ArmadoProcJB;
import Controlador.CRUD_ProductosJB;
import Controlador.ControladorAlmacenamiento;
import Controlador.ControladorVenDatosEnvio;
import Controlador.ControladorVistaProductos;
import Modelo.ModeloProcesador;
import Vista.ArmadoProc_JB;
import Vista.CRUD_Productos_JB;

import Controlador.ControladorlLogin;
import Modelo.ModeloAlmacenamiento;
import Modelo.ModeloCliente;
import Modelo.ModeloDatosEnvio;
import Modelo.ModeloPersona;
import Vista.ArmadoPlaca_JB;
import Vista.VentanaDatosEnvio;
import Vista.VentanaLogin_JM;
import Vista.VentanaPrincipal;
import Vista.VistaProductos;
import Vista.CrearAlmacenamiento;

public class ProyectoFinal {

    public static void main(String[] args) {

//        CRUD_Productos_JB vista = new CRUD_Productos_JB();
//        CRUD_ProductosJB control = new CRUD_ProductosJB(vista);
//        control.iniciar();


        ArmadoProc_JB vistaA = new ArmadoProc_JB();
        ArmadoProcJB controlador = new ArmadoProcJB(vistaA);
        controlador.Inicio();
        
        
//        VistaProductos v = new VistaProductos();
//        ControladorVistaProductos contro = new ControladorVistaProductos(v);
//        contro.iniciarControl();


//          CrearAlmacenamiento vis = new CrearAlmacenamiento();
//          Modelo.ModeloAlmacenamiento mAl = new ModeloAlmacenamiento();
//          ControladorAlmacenamiento Clo = new ControladorAlmacenamiento(mAl, vis);
//          Clo.iniciaControl();


//        VentanaDatosEnvio vista = new VentanaDatosEnvio();
//        ModeloDatosEnvio mDtos = new ModeloDatosEnvio();        
//        ControladorVenDatosEnvio log = new ControladorVenDatosEnvio(vista, mDtos);
//        log.iniciaControlador();

//        ArmadoPlaca_JB vistaA = new ArmadoPlaca_JB();
//        ArmadoPlacaJB controlador = new ArmadoPlacaJB(vistaA);
//        controlador.Inicio();
//        VentanaLogin_JM vista = new VentanaLogin_JM();
//        Modelo.ModeloCliente mCliente = new ModeloCliente();
//        ControladorlLogin cLogin = new ControladorlLogin(mCliente, vista);
//        cLogin.iniciaControlador();
    }

}
