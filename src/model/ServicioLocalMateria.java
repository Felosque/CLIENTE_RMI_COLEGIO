/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import servicioWebMaterias.ServicioMateriaSW;
import servicioWebMaterias.ServicioMateriaSW_Service;

/**
 *
 * @author felip
 */
public class ServicioLocalMateria {
    
    private static ServicioMateriaSW_Service servicio = new ServicioMateriaSW_Service();
    private static ServicioMateriaSW servicioMateriaSW = servicio.getServicioMateriaSWPort();
    
    private ServicioLocalMateria() {
    }
    
    public static ServicioMateriaSW getServicio(){
        return servicioMateriaSW;
    }
    
    
}
