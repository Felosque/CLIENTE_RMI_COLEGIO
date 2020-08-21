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
public class ServicioLocalMateria {
    
    private static IServicioMateria servicioMateria;

    private ServicioLocalMateria() {
    }
    
    public static void setServicioMateria(IServicioMateria pServ){
        if(servicioMateria == null){
            servicioMateria = pServ;
        }
    }
   
    public static IServicioMateria getServicio(){
        return servicioMateria;
    }
    
    
}
