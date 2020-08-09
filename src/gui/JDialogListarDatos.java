/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import static java.awt.Dialog.ModalityType.TOOLKIT_MODAL;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author felip
 */
public class JDialogListarDatos extends JDialog {

    private JLabel lbTitulo;
    
    public JDialogListarDatos(GUIPrincipal gui) {

        //super(null, TOOLKIT_MODAL);
        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Gestión Estudiantil - Lista de estudiantes");
        setSize(new Dimension(1000, 500));
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panelTitulo = new JPanel();
        lbTitulo = new JLabel("LISTA DE ESTUDIANTES");
        lbTitulo.setHorizontalAlignment(JLabel.CENTER);
        lbTitulo.setForeground(GUIConstantes.COLOR_PRINCIPAL);
        lbTitulo.setFont(new Font("TAHOMA", Font.BOLD, 50));
        panelTitulo.add(lbTitulo);
        add(panelTitulo, BorderLayout.NORTH);
        
        
        GUIListarDatos panelListar = new GUIListarDatos(gui);
        add(panelListar, BorderLayout.CENTER);
        
    }
    
    
    
    
    
}
