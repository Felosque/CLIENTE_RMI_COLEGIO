/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import javax.swing.JDialog;

/**
 *
 * @author felip
 */
public class JDialogListarDatos extends JDialog {

    GUIPrincipal guiPrincipal;
    
    public JDialogListarDatos(GUIPrincipal gui) {
        
        guiPrincipal = gui;
        
        setTitle("Lista de estudiantes");
        setSize(new Dimension(1000, 400));
        setResizable(false);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        GUIListarDatos panelListar = new GUIListarDatos(gui);
        add(panelListar);
        
    }
    
    
    
    
    
}
