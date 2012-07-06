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

    //vedere quale dei due metodi è meglio usare   (quello su e questo giù)
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
