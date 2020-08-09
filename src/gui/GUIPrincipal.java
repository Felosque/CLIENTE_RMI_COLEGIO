/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JFrame;
import servicios.ServicioEstudiante;
import estructural.Estudiante;

/**
 *
 * @author felip
 */
public class GUIPrincipal extends JFrame{

    
    private GUIPanelAcciones panelAcciones;
    
    private GUIPanelInfo panelInformacion;
    
    private GUIPanelTitulo panelTitulo;
    
    private GUIListarDatos panelGrilla;
    
    private ServicioEstudiante colegio;
    
    public GUIPrincipal() {
        
        colegio = new ServicioEstudiante();
        
        
        setTitle("Administración de estudiantes");
        setVisible(true);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(1000, 600));
        setSize(new Dimension(1000, 601));
        setResizable(false);
        
        panelAcciones = new GUIPanelAcciones(this);
        
        panelTitulo = new GUIPanelTitulo("GESTIÓN ESTUDIANTIL");
        
        add(panelTitulo, BorderLayout.NORTH);
        add(panelAcciones, BorderLayout.SOUTH);
        
        panelGrilla = new GUIListarDatos(this);
        add(panelGrilla, BorderLayout.CENTER);
        
        setSize(new Dimension(1000, 600));
        setSize(new Dimension(1000, 601));
        
    }
    
    public ArrayList<Estudiante> getEstudiantes()
    {
        return colegio.darEstudiantes();
    }
    
    public Estudiante buscarEstudiante(String identificacion)
    {
        return colegio.buscarEstudiante(identificacion);
    }
    
    public void registrarEstudiante(Estudiante pEstudiante)
    {
        colegio.insertarEstudiante(pEstudiante);
    }
    
    public void actualizarEstudiante(String pDocumento, Estudiante pEstudiante)
    {
        colegio.actualizarEstudiante(pDocumento, pEstudiante);
    }
    
    public void borrarEstudiante(String pDocumento)    
    {
        colegio.eliminarEstudiante(pDocumento);
    }
    
    public void uiVerLista()
    {
        if(panelGrilla != null) { panelGrilla.setVisible(false); panelGrilla = null; }
        if(panelInformacion != null) { panelInformacion.setVisible(false); panelInformacion = null; }
        panelGrilla = new GUIListarDatos(this);
        add(panelGrilla);
        repaint();
    }
    
    public void uiRegistrarUsuario()
    {
        if(panelGrilla != null) { panelGrilla.setVisible(false); panelGrilla = null; }
        if(panelInformacion != null) { panelInformacion.setVisible(false); panelInformacion = null; }
        panelInformacion = new GUIPanelInfo(this, 1);
        add(panelInformacion);
        repaint();
    }
    
    public void uiModificarEstudiante(Estudiante pEstudiante)
    {
        if(panelGrilla != null) { panelGrilla.setVisible(false); panelGrilla = null; }
        if(panelInformacion != null) { panelInformacion.setVisible(false); panelInformacion = null; }
        panelInformacion = new GUIPanelInfo(this, 2);
        panelInformacion.refrescarInfo(pEstudiante);
        add(panelInformacion);
        repaint();
    }
    
    public void uiVisualizarEstudiante(Estudiante pEstudiante)
    {
        if(panelGrilla != null) { panelGrilla.setVisible(false); panelGrilla = null; }
        if(panelInformacion != null) { panelInformacion.setVisible(false); panelInformacion = null; }
        panelInformacion = new GUIPanelInfo(this, 3);
        panelInformacion.refrescarInfo(pEstudiante);
        add(panelInformacion);
        repaint();
    }
    
    public void uiBorrarEstudiante(Estudiante pEstudiante)      
    {
        if(panelGrilla != null) { panelGrilla.setVisible(false); panelGrilla = null; }
        if(panelInformacion != null) { panelInformacion.setVisible(false); panelInformacion = null; }
        panelInformacion = new GUIPanelInfo(this, 4);
        panelInformacion.refrescarInfo(pEstudiante);
        add(panelInformacion);
        repaint();
    }
         
            

    public static void main(String arg[]){
        new GUIPrincipal();
    }
}