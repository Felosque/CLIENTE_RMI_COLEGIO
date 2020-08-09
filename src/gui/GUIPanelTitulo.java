/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author felip
 */
public class GUIPanelTitulo extends JPanel{
    
    private JLabel titulo;
    public GUIPanelTitulo(String ptitulo) {
        setLayout(new BorderLayout());
        
        Border borde = new LineBorder(new Color(1, 2, 3));
        setBorder(borde);
        
        titulo = new JLabel(ptitulo);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setFont(new Font("ARIAL", Font.BOLD, 60));
        
        add(titulo);
    }
    
}
