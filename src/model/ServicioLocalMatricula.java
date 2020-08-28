/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import servicioWebMatriculas.ServicioMatriculaSW;
import servicioWebMatriculas.ServicioMatriculaSW_Service;

/**
 *
 * @author felip
 */
public class ServicioLocalMatricula {
    
    private static ServicioMatriculaSW_Service service = new ServicioMatriculaSW_Service();
    private static ServicioMatriculaSW servicioMatriculaSW = service.getServicioMatriculaSWPort();

    private ServicioLocalMatricula() {
    }

    public static ServicioMatriculaSW getServicio(){
        return servicioMatriculaSW;
    }
    
}
