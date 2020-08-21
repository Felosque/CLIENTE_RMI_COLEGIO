/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import estructural.Materia;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author felip
 */
public interface IServicioMateria extends Remote{
    
    public Materia darMateriaPorCodigo(int pCodigo) throws RemoteException;
    
    public ArrayList<Materia> darMateriasPorGrado(int pGrado) throws RemoteException;
    
    public ArrayList<Materia> darMaterias() throws RemoteException;
    
}
