/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;
import static constantes.ColegioConstantes.sumarRestarAnosDate;
import estructural.Estudiante;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author felip
 */
public class ServicioEstudiante {
    
    private ArrayList<Estudiante> estudiantes;

    public ServicioEstudiante() {
        estudiantes = new ArrayList<>();
        Date date = sumarRestarAnosDate(new Date(), -8);
        estudiantes.add(new Estudiante("Alejandro", "Luna", date, "987654321", 0, "SALUDCOP", "30012324234", "Avenida 49", "alejandro.luna@gmail.com"));
        estudiantes.add(new Estudiante("Luis Felipe", "Londoño Medina", date, "123456789", 0, "SALUD TOTAL", "2772478", "CALLE 60 A", "felipelondono@gmail.com")); 
        for (int i = 0; i < 10; i++) {
            estudiantes.add(new Estudiante("Luis Felipe", "Londoño Medina", date, "123456789", 1, "SALUD TOTAL", "2772478", "CALLE 60 A", "felipelondono@gmail.com")); 
        }
    }
    
    public void insertarEstudiante(Estudiante pEstudiante){
        estudiantes.add(pEstudiante);
    }
    
    public boolean eliminarEstudiante(String pDocumento){
        for(int i = 0; i < estudiantes.size(); i++){
            if(estudiantes.get(i).getDocumento().equals(pDocumento)){
                estudiantes.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public boolean actualizarEstudiante(String pDocumento, Estudiante pEstudiante) throws Exception
    {
        for(int i = 0; i < estudiantes.size(); i++){
            if(estudiantes.get(i).getDocumento().equals(pEstudiante.getDocumento())){
                try{
                    estudiantes.get(i).actualizarTodaInformacion(pEstudiante);
                }catch(Exception e){
                    throw new Exception(e.getMessage());
                }    
                return true;
            }
        }
        return false;
    }
    
    public Estudiante buscarEstudiante(String pDocumento)
    {
        for(int i = 0; i < estudiantes.size(); i++){
            if(estudiantes.get(i).getDocumento().equals(pDocumento)){
                return estudiantes.get(i);
            }
        }
        return null;
    }
    
    public ArrayList<Estudiante> darEstudiantes() {
        return estudiantes;
    }

    public void cambiarEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
    //En la posición 0 devuelve la cantidad de hombres, en la 1 la cantidad de mujeres 
    public int[] cantidadEstudiantesPorGenero()
    {
        int[] cantEstu = new int[2];
        for (int i = 0; i < estudiantes.size(); i++) {
            if(estudiantes.get(i).getGenero() == 0){
                cantEstu[0]++;
            }else {
                cantEstu[1]++;
            }
        }
        return cantEstu;
    }
    
    
}
