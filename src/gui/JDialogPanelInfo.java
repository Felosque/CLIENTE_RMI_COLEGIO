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
public class JDialogPanelInfo extends JDialog{

    private GUIPrincipal guiPrincipal;
    
    public JDialogPanelInfo(GUIPrincipal gui, GUIConstantes.TIPO_ACCION tipo) {
        
        this.guiPrincipal = gui;
        
        setSize(new Dimension(820, 500));
        setResizable(false);
        setAlwaysOnTop(true);
        
        GUIPanelInfo panelInfo = new GUIPanelInfo(gui, tipo);
        add(panelInfo);
    }
    
    
    
    
}
