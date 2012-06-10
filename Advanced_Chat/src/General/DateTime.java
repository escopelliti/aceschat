/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package General;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author enrico
 */
public class DateTime {

    //mi restituisce un array di interi comprendenti tutte le informazioni di data e ora;

    //vedere quale dei due metodi è meglio usare   (quello su e questo giù)
       public static String getDateTime(){
           
                Calendar calendar = Calendar.getInstance();
                int y = calendar.get(Calendar.YEAR);
                String Year = Integer.toString(y);
                int m = calendar.get(Calendar.MONTH);
                String Month = Integer.toString(m);
                int d = calendar.get(Calendar.DAY_OF_MONTH);
                String day = Integer.toString(d);
                int h = calendar.get(Calendar.HOUR_OF_DAY);
                String hour = Integer.toString(h);
                int minute = calendar.get(Calendar.MINUTE);
                String min = Integer.toString(minute);
                int sec = calendar.get(Calendar.SECOND);
                String second = Integer.toString(sec);

                String date = (Year+"-"+Month+"-"+day+"-"+hour+"-"+min+"-"+second);
                return date;
    }


  

}
