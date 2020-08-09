/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructural;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author felip
 */
public class Estudiante {
    
    private String nombres;
    
    private String apellidos;
    
    private LocalDateTime fechaNacimiento;
    
    private String documentoIdentificacion;
    
    private String rH;
    
    private String eps;
    
    private String acudiente;
    
    private String telefono;
    
    private String direccion;
    
    private String correo;

    public Estudiante(String nombres, String apellidos, LocalDateTime fechaNacimiento, String documentoIdentificacion, String rH, String eps, String telefonoAcudiente, String direccion, String correo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.documentoIdentificacion = documentoIdentificacion;
        this.rH = rH;
        this.eps = eps;
        this.telefono = telefonoAcudiente;
        this.direccion = direccion;
        this.correo = correo;
    }

    public Estudiante(String nombres, String apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
    
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDocumento() {
        return documentoIdentificacion;
    }

    public void setDocumentoIdentificacion(String documentoIdentificacion) {
        this.documentoIdentificacion = documentoIdentificacion;
    }

    public String getrH() {
        return rH;
    }

    public void setrH(String rH) {
        this.rH = rH;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getAcudiente() {
        return acudiente;
    }

    public void setAcudiente(String acudiente) {
        this.acudiente = acudiente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefonoAcudiente) {
        this.telefono = telefonoAcudiente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public void actualizarTodaInformacion(Estudiante pEstudiante)
    {
        this.nombres = pEstudiante.getNombres();
        this.apellidos = pEstudiante.getApellidos();
        this.correo = pEstudiante.getCorreo();
        this.acudiente = pEstudiante.getAcudiente();
        this.direccion = pEstudiante.getDireccion();
        this.documentoIdentificacion = pEstudiante.getDocumento();
        this.eps = pEstudiante.getEps();
        this.fechaNacimiento = pEstudiante.getFechaNacimiento();
        this.rH = pEstudiante.getrH();
        this.telefono = pEstudiante.getTelefono();
    }
    
}
