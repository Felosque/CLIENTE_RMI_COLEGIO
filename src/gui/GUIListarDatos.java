/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import estructural.Estudiante;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author felip
 */
public class GUIListarDatos extends JPanel{

    private GUIPrincipal principal;
    
    public GUIListarDatos(GUIPrincipal gui) {
        
        this.principal = gui;
        CrearTabla(principal.getEstudiantes());
        this.setBackground(new Color(0, 0, 0));
        setLayout(null);
    }
    
    
    
    
    public void CrearTabla(ArrayList<Estudiante> est)
    {
        Vector columnas = new Vector();
        columnas.add("Nombres");
        columnas.add("Apellidos");
        columnas.add("Correo");
        columnas.add("Documento");
        columnas.add("F. Nacimiento");
        columnas.add("Dirección");
        columnas.add("Factor RH");
        columnas.add("Telefono");
        
        Vector filas = new Vector();
        
        for (int i = 0; i < est.size(); i++) {
            Vector fila = new Vector();
            fila.add(est.get(i).getNombres());
            fila.add(est.get(i).getApellidos());
            fila.add(est.get(i).getCorreo());
            fila.add(est.get(i).getDocumento());
            fila.add(est.get(i).getFechaNacimiento().toString());
            fila.add(est.get(i).getDireccion());
            fila.add(est.get(i).getrH());
            fila.add(est.get(i).getTelefono());
            filas.add(fila);
        }
        
        JTable tbl = new JTable(filas,columnas);
        tbl.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scroll =new JScrollPane(tbl);
        //scroll.setSize(900, 400);
        tbl.setRowHeight(30);
        scroll.setBounds(0, 0, 983, 390);
        add(scroll);
        invalidate();
        validate();
        
        
    }
    
}
