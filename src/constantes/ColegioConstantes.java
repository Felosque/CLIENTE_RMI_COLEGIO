/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constantes;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author felip
 */
public class ColegioConstantes {
    
    public static final int EDAD_MINIMA_REGISTRO = 5;
    
    public static enum TIPO_RH{
        A, B, O, AB
    }
    
    //Verifica si la cadena es un numero
    public static boolean isNumeric(String value){
        boolean ret = false;
        if (!value.isEmpty()) {
            ret = value.matches("^[0-9]+$");
        }
        return ret;
    }
    
    public static Date sumarRestarAnosDate(Date fecha, int anos){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.YEAR, anos);
        return calendar.getTime();
    }
    
    public static boolean isEmailValid(String eMail){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(eMail);
        if(mather.find()) {
            return true;
        }else{
            return false;
        }
    }
    
}
