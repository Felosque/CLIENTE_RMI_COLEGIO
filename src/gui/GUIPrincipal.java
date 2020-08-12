/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import estructural.Estudiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import javax.swing.*;
import model.IServicioEstudiante;

/**
 *
 * @author felip
 */
public class GUIPrincipal extends JFrame implements ActionListener{
    
    
    private GUIPanelInicio panelInicio;

    private IServicioEstudiante servicioEstudiante;
    
    public GUIPrincipal(IServicioEstudiante pServEst) {
        
        servicioEstudiante = pServEst;
        
        inicializarMenuBar();
        
        panelInicio = new GUIPanelInicio();
        add(panelInicio, BorderLayout.CENTER);
        setSize(new Dimension(500, 401));
    }
    
    public ArrayList<Estudiante> getEstudiantes() throws RemoteException
    {
        return servicioEstudiante.darEstudiantes();
    }
    
    public Estudiante buscarEstudiante(String identificacion) throws RemoteException
    {
        return servicioEstudiante.buscarEstudiante(identificacion);
    }
    
    public void registrarEstudiante(Estudiante pEstudiante) throws RemoteException
    {
        servicioEstudiante.insertarEstudiante(pEstudiante);
    }
    
    public void actualizarEstudiante(String pDocumento, Estudiante pEstudiante) throws RemoteException
    {
        try{
            servicioEstudiante.actualizarEstudiante(pDocumento, pEstudiante);
        }catch(RemoteException e){
            throw new RemoteException(e.getMessage());
        }
    }
    
    public void borrarEstudiante(String pDocumento) throws RemoteException    
    {
        servicioEstudiante.eliminarEstudiante(pDocumento);
    }
    
    public void uiVerLista()
    {
        JDialogListarDatos dialogoVerLista = new JDialogListarDatos(this);
        dialogoVerLista.setVisible(true);
    }
    
    public void uiRegistrarUsuario()
    {
        JDialogPanelInfo agregarEstudiante = new JDialogPanelInfo(this, GUIConstantes.TIPO_ACCION.CREAR);
        agregarEstudiante.setVisible(true);
    }
    
    public void uiModificarEstudiante(Estudiante pEstudiante)
    {
        JDialogPanelInfo actualizarEstudiante = new JDialogPanelInfo(this, GUIConstantes.TIPO_ACCION.ACTUALIZAR);
        actualizarEstudiante.darPanel().refrescarInfo(pEstudiante);
        actualizarEstudiante.setVisible(true);
    }
    
    public void uiVisualizarEstudiante(Estudiante pEstudiante)
    {
        JDialogPanelInfo verEstudiante = new JDialogPanelInfo(this, GUIConstantes.TIPO_ACCION.LEER);
        verEstudiante.darPanel().refrescarInfo(pEstudiante);
        verEstudiante.setVisible(true);
    }
    
    public void uiBorrarEstudiante(Estudiante pEstudiante)      
    {
        JDialogPanelInfo eliminarEstudiante = new JDialogPanelInfo(this, GUIConstantes.TIPO_ACCION.ELIMINAR);
        eliminarEstudiante.darPanel().refrescarInfo(pEstudiante);
        eliminarEstudiante.setVisible(true);
    }
         
    private JMenuBar barraMenu;
    
    private JMenu menuArchivo, menuEstudiante, menuAyuda;
    
    private JMenuItem mnSalir, mnAyuda;
    private JMenuItem mnEstListar, mnEstCrear, mnEstEliminar, mnEstActualizar, mnEstBuscar, mnEstGrafica;
    
    public void inicializarMenuBar()
    {
        barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);
        
        //Menu de archivo
        menuArchivo = new JMenu("Archivo");
        barraMenu.add(menuArchivo);
        
        mnSalir = new JMenuItem("Salir");
        mnSalir.addActionListener(this);
        menuArchivo.add(mnSalir);
        
        //Menu de Estudiante
        menuEstudiante = new JMenu("Estudiante");
        barraMenu.add(menuEstudiante);
        
        mnEstListar = new JMenuItem("Listar Estudiantes");
        mnEstListar.addActionListener(this);
        menuEstudiante.add(mnEstListar);
        
        mnEstCrear = new JMenuItem("Agregar Estudiante");
        mnEstCrear.addActionListener(this);
        menuEstudiante.add(mnEstCrear);
        
        mnEstBuscar = new JMenuItem("Buscar Estudiante");
        mnEstBuscar.addActionListener(this);
        menuEstudiante.add(mnEstBuscar);
                
        mnEstActualizar = new JMenuItem("Actualizar Estudiante");
        mnEstActualizar.addActionListener(this);
        menuEstudiante.add(mnEstActualizar);
        
        mnEstEliminar = new JMenuItem("Eliminar Estudiante");
        mnEstEliminar.addActionListener(this);
        menuEstudiante.add(mnEstEliminar);
        
        mnEstGrafica = new JMenuItem("Estadisticas de Estudiantes");
        mnEstGrafica.addActionListener(this);
        menuEstudiante.add(mnEstGrafica);
        
        //Menú ayuda
        menuAyuda = new JMenu("Ayuda");
        barraMenu.add(menuAyuda);
        
        mnAyuda = new JMenuItem("Acerca de...");
        mnAyuda.addActionListener(this);
        menuAyuda.add(mnAyuda);
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mnSalir){
            System.exit(0);
        }
        else if(e.getSource() == mnEstBuscar){
            String identificacion = JOptionPane.showInputDialog(this, "Digite el numero de identificación del estudiante que desea buscar:", "Buscar Estudiante", JOptionPane.WARNING_MESSAGE);
            if(identificacion != null){
                Estudiante estudiante;
                try {
                    estudiante = this.buscarEstudiante(identificacion);
                    if(estudiante != null){
                    this.uiVisualizarEstudiante(estudiante);
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "El estudiante no se ha encontrado en la base de datos.");
                    }
                } catch (RemoteException ex) {
                    
                }
            }
        }
        else if(e.getSource() == mnEstCrear){
            this.uiRegistrarUsuario();
        }
        else if(e.getSource() == mnEstEliminar){
            String identificacion = JOptionPane.showInputDialog(this, "Digite el numero de identificación del estudiante que desea eliminar:", "Eliminar Estudiante", JOptionPane.WARNING_MESSAGE);
            if(identificacion != null){
                try{
                    Estudiante estudiante = this.buscarEstudiante(identificacion);
                    if(estudiante != null){
                        this.uiBorrarEstudiante(estudiante);
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "El estudiante no se ha encontrado en la base de datos.");
                    }
                } catch (RemoteException ex) {
                    
                }
            }
        }
        else if(e.getSource() == mnEstActualizar){
            String identificacion = JOptionPane.showInputDialog(this, "Digite el numero de identificación del estudiante que desea actualizar:", "Actualizar Estudiante", JOptionPane.WARNING_MESSAGE);
            if(identificacion != null){
                try{
                    Estudiante estudiante = this.buscarEstudiante(identificacion);
                    if(estudiante != null){
                        this.uiModificarEstudiante(estudiante);
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "El estudiante no se ha encontrado en la base de datos.");
                    }
                } catch (RemoteException ex) {
                    
                }
            }
        }
        else if(e.getSource() == mnEstListar){
            this.uiVerLista();
        }
        else if(e.getSource() == mnEstGrafica){
            try{
                JDialogGraficos dialogoGrafica = new JDialogGraficos(servicioEstudiante.cantidadEstudiantesPorGenero());
                dialogoGrafica.setVisible(true);
            } catch (RemoteException ex) {
                    
            }
        }
        else if(e.getSource() == mnAyuda){
            JOptionPane.showMessageDialog(this,"Desarrollado por:\n\n- Alejandro Luna Miranda\n- Luis Felipe Londoño\n\n\tUNIVERSIDAD DE IBAGUÉ\n\t\t©©©©©© 2020 ©©©©©©");
        }
    }
    
    public static void main(String arg[]){
        try{
            IServicioEstudiante model = (IServicioEstudiante)Naming.lookup("//127.0.0.1/ServicioEstudiante");
            GUIPrincipal ven = new GUIPrincipal(model);
            ven.setTitle("Gestión estudiantil");
            ven.setVisible(true);
            ven.setSize(new Dimension(500, 400));
            ven.setLayout(new BorderLayout());
            ven.setDefaultCloseOperation(EXIT_ON_CLOSE);
            ven.setResizable(false);
            ven.setLocationRelativeTo(null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}