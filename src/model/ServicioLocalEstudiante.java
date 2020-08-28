/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import servicioWebEstudiante.ServicioEstudianteSW;
import servicioWebEstudiante.ServicioEstudianteSW_Service;

/**
 *
 * @author felip
 */
public class ServicioLocalEstudiante {
    
    private static servicioWebEstudiante.ServicioEstudianteSW_Service servicio = new ServicioEstudianteSW_Service();
    private static ServicioEstudianteSW servicioEstudianteSW = servicio.getServicioEstudianteSWPort();
    
    private ServicioLocalEstudiante() {
    }

    public static ServicioEstudianteSW getServicio(){
        return servicioEstudianteSW;
    }

}
