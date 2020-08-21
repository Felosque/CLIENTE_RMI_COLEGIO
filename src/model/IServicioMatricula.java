/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import estructural.Matricula;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author felip
 */
public interface IServicioMatricula extends Remote{
    
    public void matricularEstudiante(Matricula pMatricula) throws RemoteException;
    
    public Matricula darMatriculaCodigo(int pCodigo) throws RemoteException;
    
    public ArrayList<Matricula> darMatriculasEstudiante(String pDocumento) throws RemoteException;
    
    public ArrayList<Matricula> darMatriculasEstudianteGrado(String pDocumento, int Grado) throws RemoteException;
    
    public ArrayList<Matricula> darMatriculas() throws RemoteException;
    
    public int[] darMateriasPorGrado() throws RemoteException;
    
    public ArrayList<Matricula> darMatriculasPorFecha(Date pFecha) throws RemoteException;
    
    public void actualizarMatricula(Matricula pMatricula) throws RemoteException;
    
    public void borrarMatriculaCodigo(int pCodigo) throws RemoteException;
    
    public boolean darPazYSalvoEstudiante(int pGrado, Matricula pMatricula) throws RemoteException;
    
    public double darPromedioEstudiante(Matricula pMatricula) throws RemoteException;
}
