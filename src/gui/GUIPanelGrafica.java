/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author felip
 */
public class GUIPanelGrafica extends javax.swing.JPanel {

    private JFreeChart Grafica;
    private DefaultPieDataset datos;
    
    /**
     * Creates new form GUIPanelGrafica
     */
    public GUIPanelGrafica(int[] cantidadGenero) {
        initComponents();
        setBackground(Color.red);
        datos = new DefaultPieDataset();
        
        
        datos.setValue("Hombres", cantidadGenero[0]);
        datos.setValue("Mujeres", cantidadGenero[1]);
        
        Grafica = ChartFactory.createPieChart("Estudiantes por género", datos, true, true, false);
        ChartPanel chartPanel = new ChartPanel(Grafica);
        chartPanel.setSize(new Dimension(600, 400));
        add(chartPanel);
        this.setSize(chartPanel.getSize());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}