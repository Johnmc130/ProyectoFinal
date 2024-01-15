package Main;

import Controlador.CRUD_ProductosJB;
import Vista.CRUD_Productos_JB;

public class ProyectoFinal {
    
    public static void main(String[] args) {
        CRUD_Productos_JB p_jb = new CRUD_Productos_JB();
        CRUD_ProductosJB control = new CRUD_ProductosJB(p_jb);
        control.iniciar();
    }
    
}
