/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import servicioWebExtra.*;
/**
 *
 * @author Estudiantes
 */
public class ServicioLocalExtra {
    private static ServiciosExtraSW_Service servicio = new ServiciosExtraSW_Service();
    private static ServiciosExtraSW servicioExtraSW = servicio.getServiciosExtraSWPort();

    private ServicioLocalExtra() {
    }
    
    public static ServiciosExtraSW getServicio(){
        return servicioExtraSW;
    }
    
}
