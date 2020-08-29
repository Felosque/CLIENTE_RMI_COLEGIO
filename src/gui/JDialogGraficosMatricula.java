/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JDialog;

/**
 *
 * @author felip
 */
public class JDialogGraficosMatricula extends JDialog {

    public JDialogGraficosMatricula(List<Integer> datin) {
         
        setResizable(false);
        setLocationRelativeTo(null);

        GUIPanelGrafica panelGrafica = new GUIPanelGrafica(datin, 2);
        add(panelGrafica, BorderLayout.CENTER);

        this.setSize(new Dimension(616, 439));
    }
    
    
    
}
