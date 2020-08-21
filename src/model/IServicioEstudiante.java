/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import estructural.Estudiante;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author felip
 */
public interface IServicioEstudiante extends Remote{
    
    public void insertarEstudiante(Estudiante pEstudiante) throws RemoteException;
    
    public boolean eliminarEstudiante(String pDocumento) throws RemoteException;
    
    public boolean actualizarEstudiante(String pDocumento, Estudiante pEstudiante) throws RemoteException;
    
    public Estudiante buscarEstudiante(String pDocumento) throws RemoteException;
    
    public ArrayList<Estudiante> darEstudiantes() throws RemoteException;
    
    public ArrayList<Estudiante> darEstudiantesPorNombre(String pNombre) throws RemoteException;
    
    public int[] cantidadEstudiantesPorGenero() throws RemoteException;
    
    public int darGradoEstudiante() throws RemoteException;
    
}
