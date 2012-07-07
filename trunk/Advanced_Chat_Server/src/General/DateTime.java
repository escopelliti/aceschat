package General;

import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 * Classe per la gestione della data nel server
 */

public class DateTime {

    // il metodo restituisce una stringa che contiene la data nel formato AAAA-MM-DD 
        
    public static String getDateTime(){
           
        Calendar calendar = Calendar.getInstance();
        int y = calendar.get(Calendar.YEAR);
        String Year = Integer.toString(y);
        int m = calendar.get(Calendar.MONTH)+1;
        String Month = Integer.toString(m);
        int d = calendar.get(Calendar.DAY_OF_MONTH);
        String day = Integer.toString(d);
        
        String date = (Year+"-"+Month+"-"+day);

        return date;
    }

    
    
     

}
