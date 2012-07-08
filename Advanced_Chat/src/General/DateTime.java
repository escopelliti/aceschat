package General;

import java.util.Calendar;

/*
 * Classe per la gestione delle date e ora locale del client
 */
public class DateTime {
    
    //il metodo restituisce una stringa che contiene data e ora nel formato AAAA-MM-DD hh:mm:ss 
       public static String getDateTime(){
           
                Calendar calendar = Calendar.getInstance();
                int y = calendar.get(Calendar.YEAR);
                String Year = Integer.toString(y);
                int m = calendar.get(Calendar.MONTH)+1;
                String Month = Integer.toString(m);
                int d = calendar.get(Calendar.DAY_OF_MONTH);
                String day = Integer.toString(d);
                int h = calendar.get(Calendar.HOUR_OF_DAY);
                String hour = Integer.toString(h);
                int minute = calendar.get(Calendar.MINUTE);
                String min = Integer.toString(minute);
                int sec = calendar.get(Calendar.SECOND);
                String second = Integer.toString(sec);

                String date = (Year+"-"+Month+"-"+day+" "+hour+":"+min+":"+second);
                return date;
       }

}
