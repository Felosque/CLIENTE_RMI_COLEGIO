/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author felip
 */
public class JDialogPanelMatricula extends JDialog{

    private JLabel lbTitulo;
    
    private GUIPrincipal gui;
    
    public JDialogPanelMatricula(GUIPrincipal pGui) {
        this.gui = pGui;
        
        setTitle("Matricular Estudiante");
        setSize(new Dimension(780, 550));
        setResizable(false);
        setLocationRelativeTo(gui);
        
        JPanel panelTitulo = new JPanel();
        lbTitulo = new JLabel("MATRICULAR ESTUDIANTE");
        lbTitulo.setHorizontalAlignment(JLabel.CENTER);
        lbTitulo.setForeground(GUIConstantes.COLOR_PRINCIPAL);
        lbTitulo.setFont(new Font("TAHOMA", Font.BOLD, 50));
        panelTitulo.add(lbTitulo);
        add(panelTitulo, BorderLayout.NORTH);
        
        GUIPanelMatricula panelMatricula = new GUIPanelMatricula();
        add(panelMatricula, BorderLayout.CENTER);
    }
    
    
    
    
}
