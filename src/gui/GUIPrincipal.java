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
import servicios.ServicioEstudiante;
import estructural.Estudiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author felip
 */
public class GUIPrincipal extends JFrame implements ActionListener{
    
    private ServicioEstudiante colegio;
    
    private GUIPanelInicio panelInicio;
           
    
    public GUIPrincipal() {
        
        colegio = new ServicioEstudiante();
        
        inicializarMenuBar();
        
        panelInicio = new GUIPanelInicio();
        add(panelInicio, BorderLayout.CENTER);
        setSize(new Dimension(500, 401));
    }
    
    public ArrayList<Estudiante> getEstudiantes()
    {
        return colegio.darEstudiantes();
    }
    
    public Estudiante buscarEstudiante(String identificacion)
    {
        return colegio.buscarEstudiante(identificacion);
    }
    
    public void registrarEstudiante(Estudiante pEstudiante) throws Exception
    {
        colegio.insertarEstudiante(pEstudiante);
    }
    
    public void actualizarEstudiante(String pDocumento, Estudiante pEstudiante) throws Exception
    {
        try{
            colegio.actualizarEstudiante(pDocumento, pEstudiante);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    public void borrarEstudiante(String pDocumento)    
    {
        colegio.eliminarEstudiante(pDocumento);
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
    private JMenuItem mnEstListar, mnEstCrear, mnEstEliminar, mnEstActualizar, mnEstBuscar;
    
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
            String identificacion = JOptionPane.showInputDialog(this, "Digite el numero de identificación del estudiante:");
            Estudiante estudiante = this.buscarEstudiante(identificacion);
            if(estudiante != null){
                this.uiVisualizarEstudiante(estudiante);
            }
            else{
                JOptionPane.showMessageDialog(this, "El estudiante no se ha encontrado en la base de datos.");
            }
        }
        else if(e.getSource() == mnEstCrear){
            this.uiRegistrarUsuario();
        }
        else if(e.getSource() == mnEstEliminar){
            String identificacion = JOptionPane.showInputDialog(this, "Digite el numero de identificación del estudiante:");
            Estudiante estudiante = this.buscarEstudiante(identificacion);
            if(estudiante != null){
                this.uiBorrarEstudiante(estudiante);
            }
            else{
                JOptionPane.showMessageDialog(this, "El estudiante no se ha encontrado en la base de datos.");
            }
        }
        else if(e.getSource() == mnEstActualizar){
            String identificacion = JOptionPane.showInputDialog(this, "Digite el numero de identificación del estudiante que desea actualizar:");
            Estudiante estudiante = this.buscarEstudiante(identificacion);
            if(estudiante != null){
                this.uiModificarEstudiante(estudiante);
            }
            else{
                JOptionPane.showMessageDialog(this, "El estudiante no se ha encontrado en la base de datos.");
            }
        }
        else if(e.getSource() == mnEstListar){
            this.uiVerLista();
        }
        else if(e.getSource() == mnAyuda){
            JOptionPane.showMessageDialog(this,"Desarrollado por:\n\n- Alejandro Luna Miranda\n- Luis Felipe Londoño");
        }
    }
    
    public static void main(String arg[]){
        GUIPrincipal ven = new GUIPrincipal();
        ven.setTitle("Gestión estudiantil");
        ven.setVisible(true);
        ven.setSize(new Dimension(500, 400));
        ven.setLayout(new BorderLayout());
        ven.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ven.setResizable(false);
        ven.setLocationRelativeTo(null);
    }
}