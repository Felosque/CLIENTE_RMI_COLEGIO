/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import estructural.Estudiante;
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
public class JDialogPanelActMatricula extends JDialog{

    private JLabel lbTitulo;
    
    public JDialogPanelActMatricula(String pEstudiante, int Codigo) {
        setSize(new Dimension(820, 500));
        setResizable(false);
        //setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        
        //setDefaultCloseOperation(PROPERTIES);
        
        JPanel panelTitulo = new JPanel();
        lbTitulo = new JLabel("TITULO GENERICO");
        lbTitulo.setHorizontalAlignment(JLabel.CENTER);
        lbTitulo.setForeground(GUIConstantes.COLOR_PRINCIPAL);
        lbTitulo.setFont(new Font("TAHOMA", Font.BOLD, 50));
        panelTitulo.add(lbTitulo);
        add(panelTitulo, BorderLayout.NORTH);
        
        GUIPanelActMatricula panelActMatricula = new GUIPanelActMatricula();
        add(panelActMatricula, BorderLayout.CENTER);
    }
    
}
