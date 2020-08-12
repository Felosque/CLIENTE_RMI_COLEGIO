/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author felip
 */
public class JDialogPanelInfo extends JDialog{

    private GUIPrincipal guiPrincipal;
    
    private GUIPanelInfo panelInfo;
    
    private JLabel lbTitulo;
    
    public JDialogPanelInfo(GUIPrincipal gui, GUIConstantes.TIPO_ACCION tipo) {
        
        this.guiPrincipal = gui;
        setSize(new Dimension(820, 500));
        setResizable(false);
        //setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        
        JPanel panelTitulo = new JPanel();
        lbTitulo = new JLabel("TITULO GENERICO");
        lbTitulo.setHorizontalAlignment(JLabel.CENTER);
        lbTitulo.setForeground(GUIConstantes.COLOR_PRINCIPAL);
        lbTitulo.setFont(new Font("TAHOMA", Font.BOLD, 50));
        panelTitulo.add(lbTitulo);
        add(panelTitulo, BorderLayout.NORTH);
        
        panelInfo = new GUIPanelInfo(gui, this, tipo);
        add(panelInfo, BorderLayout.CENTER);
    }
    
    public GUIPanelInfo darPanel(){
        return panelInfo;
    }
    
    public void cambiarTitulo(String pTexto){
        pTexto = pTexto.toUpperCase();
        lbTitulo.setText(pTexto);
    }
    
}
