/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import constantes.UtilitiesFunctions;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.ServicioLocalEstudiante;
import servicioWebEstudiante.Estudiante;
import servicioWebEstudiante.Exception_Exception;
import servicioWebEstudiante.ServicioEstudianteSW;
import servicioWebEstudiante.ServicioEstudianteSW_Service;

/**
 *
 * @author felip
 */
public class GUIListarDatos extends JPanel implements KeyListener{

    private GUIPrincipal principal;
    
    private JTextField busqueda;
    
    private DefaultTableModel modelo;
    
    private JTable tabla;
    
    public GUIListarDatos(GUIPrincipal gui){
        
        this.principal = gui;
        try {
            crearTabla(ServicioLocalEstudiante.getServicio().darEstudiantes());
        } catch (Exception_Exception ex) {
            Logger.getLogger(GUIListarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        setBorder(BorderFactory.createTitledBorder(""));
        //this.setBackground(new Color(0, 0, 0));
        setLayout(null);
        
        busqueda = new JTextField();
        busqueda.setBounds(140, 41, 300, 20);
        busqueda.addKeyListener(this);
        add(busqueda);
    }
    
    public void crearTabla(List<Estudiante> est)
    {
        Vector columnas = new Vector();
        columnas.add("Documento");
        columnas.add("Nombres");
        columnas.add("Apellidos");
        columnas.add("Género");
        columnas.add("F. Nacimiento");
        columnas.add("Correo");
        columnas.add("Dirección");
        columnas.add("Teléfono");
        
        Vector filas = new Vector();
        
        
        for (int i = 0; i < est.size(); i++) {
            Vector fila = new Vector();
            fila.add(est.get(i).getDocumentoIdentificacion());
            fila.add(est.get(i).getNombres());
            fila.add(est.get(i).getApellidos());
            fila.add((est.get(i).getGenero() == 0) ?"Masculino":"Femenino");
            fila.add(est.get(i).getFechaNacimiento());
            fila.add((est.get(i).getCorreo().trim().isEmpty()) ?"NO REGISTRADO":""+est.get(i).getCorreo());
            fila.add(est.get(i).getDireccion());
            fila.add(est.get(i).getTelefono());
            filas.add(fila);
        }
        
        tabla = new JTable(filas, columnas);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.setEnabled(false);
     
        JScrollPane scroll = new JScrollPane(tabla);
        //scroll.setSize(900, 400);
        
        tabla.setRowHeight(30);
        scroll.setBounds(10, 70, 967, 310);
        add(scroll);
        invalidate();
        validate();
        
        
        JLabel ayuda = new JLabel("Filtar por nombre: ");
        ayuda.setBounds(10, 0, 300, 100);
        add(ayuda);
        
    }
    
    private void cambiarDatosTabla(ArrayList<Estudiante> estudiantes){
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        modelo.getDataVector().removeAllElements();
        revalidate();
        
        for (int i = 0; i < estudiantes.size(); i++) {
            Vector fila = new Vector();
            fila.add(estudiantes.get(i).getDocumentoIdentificacion());
            fila.add(estudiantes.get(i).getNombres());
            fila.add(estudiantes.get(i).getApellidos());
            fila.add((estudiantes.get(i).getGenero() == 0) ?"Masculino":"Femenino");
            fila.add(estudiantes.get(i).getFechaNacimiento());
            fila.add((estudiantes.get(i).getCorreo().trim().isEmpty()) ?"NO REGISTRADO":""+estudiantes.get(i).getCorreo());
            fila.add(estudiantes.get(i).getDireccion());
            fila.add(estudiantes.get(i).getTelefono());
            modelo.addRow(fila);
        }
        repaint();
    }
    

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        try {
            
            List<Estudiante> est = new ArrayList<Estudiante>();
            try {
                est = ServicioLocalEstudiante.getServicio().darEstudiantesPorNombre(busqueda.getText());
            } catch (Exception_Exception ex) {
                Logger.getLogger(GUIListarDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
            cambiarDatosTabla((ArrayList<Estudiante>) est);
        } catch (Exception ex) {
            Logger.getLogger(GUIListarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(busqueda.getText());
        //ordenador.setRowFilter(RowFilter.regexFilter(busqueda.getText(), 1));
    }
    
    
}
