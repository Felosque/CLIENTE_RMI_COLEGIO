/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import estructural.Estudiante;
import estructural.Matricula;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ServicioLocalMatricula;

/**
 *
 * @author felip
 */
public class GUIPanelActMatricula extends javax.swing.JPanel {

    
    private Estudiante estudiante;
    
    private Matricula matricula;
    
    private JDialogBuscarMatriculaEstudiante padre;
    /**
     * 
     * 
     * Creates new form GUIPanelListarMaterias
     */
    public GUIPanelActMatricula(Estudiante pEst, Matricula pMatricula, JDialogBuscarMatriculaEstudiante pe) {
        initComponents();
        
        padre = pe;
        estudiante = pEst;
        jtDoc.setText(pEst.getDocumento());
        jtEps.setText(pEst.getEps());
        jtGenero.setText((pEst.getGenero() == 1) ? "Masculino":"Femenino" );
        jtNombre.setText(pEst.getNombres() + " " + pEst.getApellidos());
        
        
        matricula = pMatricula;
        jcFechaInicio.setText(matricula.getFechaInicio().toString());
        jcFechaFinal.setText(matricula.getFechaFinal().toString());
        jcEstado.setSelectedIndex(matricula.getEstado());
        jcNota.setText(""+matricula.getNotaDefinitiva());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jtEps = new javax.swing.JTextField();
        jtDoc = new javax.swing.JTextField();
        jtGenero = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcEstado = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcFechaFinal = new javax.swing.JTextField();
        jcFechaInicio = new javax.swing.JTextField();
        jcNota = new javax.swing.JTextField();

        jButton2.setText("jButton2");

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Estudiante"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        jLabel2.setText("Documento:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jLabel3.setText("Género :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        jLabel4.setText("Grado:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        jtNombre.setEditable(false);
        jPanel1.add(jtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 160, 20));

        jtEps.setEditable(false);
        jPanel1.add(jtEps, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 160, 20));

        jtDoc.setEditable(false);
        jPanel1.add(jtDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 160, 20));

        jtGenero.setEditable(false);
        jPanel1.add(jtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 160, 20));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 570, 80));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Matricula"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Nota:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jLabel6.setText("Fecha Fin:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

        jcEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matriculada", "Cursando", "Reprobada", "Aprobada" }));
        jPanel2.add(jcEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 170, -1));

        jButton1.setText("Actualizar Matricula");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 260, 30));

        jLabel7.setText("Estado:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jLabel8.setText("Fecha Inicio:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jcFechaFinal.setEditable(false);
        jPanel2.add(jcFechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 170, -1));

        jcFechaInicio.setEditable(false);
        jPanel2.add(jcFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 170, -1));
        jPanel2.add(jcNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 170, -1));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 570, 160));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int select = JOptionPane.showOptionDialog(this, "¿Seguro que desea actualizar la matricula?", "IMPORTANTE", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 1);
        if(select == 0){
            matricula.setEstado(jcEstado.getSelectedIndex());
            try{
                double numerito = Double.parseDouble(jcNota.getText());
                matricula.setNotaDefinitiva(numerito);
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Debe ser un formato valido de nota");
            }
            try {
                ServicioLocalMatricula.getServicio().actualizarMatricula(matricula);
                JOptionPane.showMessageDialog(this, "¡Se actualizó la matricula correctamente!");
                padre.cambiarDatosTabla(0);
                
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error al actualizar la matricula");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> jcEstado;
    private javax.swing.JTextField jcFechaFinal;
    private javax.swing.JTextField jcFechaInicio;
    private javax.swing.JTextField jcNota;
    private javax.swing.JTextField jtDoc;
    private javax.swing.JTextField jtEps;
    private javax.swing.JTextField jtGenero;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables
}