/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author felip
 */
public class ServicioLocalEstudiante {
    
    private static IServicioEstudiante servicioEstudiante;

    private ServicioLocalEstudiante() {
    }
    
    public static void setServicioEstudiante(IServicioEstudiante pServ){
        if(servicioEstudiante == null){
            servicioEstudiante = pServ;
        }
    }
   
    public static IServicioEstudiante getServicio(){
        return servicioEstudiante;
    }

}
