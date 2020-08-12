/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import constantes.UtilitiesFunctions;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import estructural.Estudiante;
import java.rmi.RemoteException;
import java.util.Calendar;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author felip
 */
public class GUIListarDatos extends JPanel{

    private GUIPrincipal principal;
    
    public GUIListarDatos(GUIPrincipal gui) throws RemoteException {
        
        this.principal = gui;
        crearTabla(principal.getEstudiantes());
        this.setBackground(new Color(0, 0, 0));
        setLayout(null);
    }
    
    public void crearTabla(ArrayList<Estudiante> est)
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
            fila.add(est.get(i).getDocumento());
            fila.add(est.get(i).getNombres());
            fila.add(est.get(i).getApellidos());
            fila.add((est.get(i).getGenero() == 0) ?"Masculino":"Femenino");
            fila.add(UtilitiesFunctions.darDiaMesAnoToString(est.get(i).getFechaNacimiento()));
            fila.add((est.get(i).getCorreo().trim().isEmpty()) ?"NO REGISTRADO":""+est.get(i).getCorreo());
            fila.add(est.get(i).getDireccion());
            fila.add(est.get(i).getTelefono());
            filas.add(fila);
        }
        
        JTable tbl = new JTable(filas,columnas);
        tbl.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbl.setEnabled(false);
        JScrollPane scroll =new JScrollPane(tbl);
        //scroll.setSize(900, 400);
        
        tbl.setRowHeight(30);
        scroll.setBounds(0, 0, 983, 390);
        add(scroll);
        invalidate();
        validate();
        
        
    }
    
}
