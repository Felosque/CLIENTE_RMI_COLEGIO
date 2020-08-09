/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import estructural.Estudiante;

/**
 *
 * @author felip
 */
public class GUIPanelAcciones extends JPanel implements ActionListener{
    
    private GUIPrincipal guiPrincipal;

    private JButton btListarEstudiantes;
    
    private JButton btAgregarEstudiante;
    
    private JButton btActualizarEstudiante;
    
    private JButton btBorrarEstudiante;
    
    private JButton btBuscarEstudiante;
    
    public GUIPanelAcciones(GUIPrincipal pGui) {
        guiPrincipal = pGui;
        
        setLayout(new GridLayout(1, 5));
        
        Border borde = new LineBorder(new Color(1, 2, 3));
        setBorder(borde);
        
        btListarEstudiantes = new JButton("Listar Estudiantes");
        btListarEstudiantes.addActionListener(this);
        btListarEstudiantes.setActionCommand("LISTAR");
        add(btListarEstudiantes);
        
        
        btAgregarEstudiante = new JButton("Agregar Estudiante");
        btAgregarEstudiante.addActionListener(this);
        btAgregarEstudiante.setActionCommand("AGREGAR");
        add(btAgregarEstudiante);
        
        
        btBuscarEstudiante = new JButton("Buscar Estudiante");
        btBuscarEstudiante.addActionListener(this);
        btBuscarEstudiante.setActionCommand("BUSCAR");
        add(btBuscarEstudiante);
        
        
        btActualizarEstudiante = new JButton("Actualizar Estudiante");
        btActualizarEstudiante.addActionListener(this);
        btActualizarEstudiante.setActionCommand("ACTUALIZAR");
        add(btActualizarEstudiante);
                
        
        btBorrarEstudiante = new JButton("Borrar Estudiante");
        btBorrarEstudiante.addActionListener(this);
        btBorrarEstudiante.setActionCommand("BORRAR");
        add(btBorrarEstudiante);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals(btActualizarEstudiante.getActionCommand())){
            String identificacion = JOptionPane.showInputDialog(guiPrincipal, "Digite el numero de identificación del estudiante que desea actualizar:");
            Estudiante estudiante = guiPrincipal.buscarEstudiante(identificacion);
            if(estudiante != null){
                //guiPrincipal.uiModificarEstudiante(estudiante);
                JDialogPanelInfo actualizarEstudiante = new JDialogPanelInfo(guiPrincipal, GUIConstantes.TIPO_ACCION.ACTUALIZAR);
                actualizarEstudiante.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(guiPrincipal, "El estudiante no se ha encontrado en la base de datos.");
            }
        }
        else if(e.getActionCommand().equals(btAgregarEstudiante.getActionCommand())){
            //guiPrincipal.uiRegistrarUsuario();
            JDialogPanelInfo agregarEstudiante = new JDialogPanelInfo(guiPrincipal, GUIConstantes.TIPO_ACCION.CREAR);
            agregarEstudiante.setVisible(true);
        }
        else if(e.getActionCommand().equals(btBorrarEstudiante.getActionCommand())){
            String identificacion = JOptionPane.showInputDialog(guiPrincipal, "Digite el numero de identificación del estudiante:");
            Estudiante estudiante = guiPrincipal.buscarEstudiante(identificacion);
            if(estudiante != null){
                //guiPrincipal.uiBorrarEstudiante(estudiante);
                JDialogPanelInfo eliminarEstudiante = new JDialogPanelInfo(guiPrincipal, GUIConstantes.TIPO_ACCION.ELIMINAR);
                eliminarEstudiante.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(guiPrincipal, "El estudiante no se ha encontrado en la base de datos.");
            }
        }
        else if(e.getActionCommand().equals(btBuscarEstudiante.getActionCommand())){
            String identificacion = JOptionPane.showInputDialog(guiPrincipal, "Digite el numero de identificación del estudiante:");
            Estudiante estudiante = guiPrincipal.buscarEstudiante(identificacion);
            if(estudiante != null){
                //guiPrincipal.uiVisualizarEstudiante(estudiante);
                JDialogPanelInfo verEstudiante = new JDialogPanelInfo(guiPrincipal, GUIConstantes.TIPO_ACCION.LEER);
                verEstudiante.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(guiPrincipal, "El estudiante no se ha encontrado en la base de datos.");
            }
                
        }
        else if(e.getActionCommand().equals(btListarEstudiantes.getActionCommand())){
            //guiPrincipal.uiVerLista();
            JDialogListarDatos dig = new JDialogListarDatos(guiPrincipal);
            dig.setVisible(true);
        }
        
    }
    
}
