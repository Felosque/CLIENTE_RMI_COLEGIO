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
public class ServicioLocalMatricula {
    
    private static IServicioMatricula servicioMateria;

    private ServicioLocalMatricula() {
    }
    
    public static void setServicioEstudiante(IServicioMatricula pServ){
        if(servicioMateria == null){
            servicioMateria = pServ;
        }
    }
   
    public static IServicioMatricula getServicio(){
        return servicioMateria;
    }
    
}
