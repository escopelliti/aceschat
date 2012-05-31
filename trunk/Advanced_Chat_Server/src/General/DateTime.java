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
       public static String getDate(){
                Calendar c = Calendar.getInstance();
                int y =c.get(Calendar.YEAR);
                String Year=Integer.toString(y);
                int m = c.get(Calendar.MONTH);
                String Month=Integer.toString(m);
                int d = c.get(Calendar.DAY_OF_MONTH);
                String Day=Integer.toString(d);

                String date = (Year+"-"+Month+"-"+Day);
                return date;
    }

    
    
     public static String getDateTime(){


         String g = null;
         String date="";
         Calendar calendar = new GregorianCalendar();
         String[] datetime = new String[6];
         datetime[3] = g.valueOf(calendar.get(Calendar.HOUR_OF_DAY)).concat(":");
         datetime[4] = g.valueOf(calendar.get(Calendar.MINUTE)).concat(":");
         datetime[5] = g.valueOf(calendar.get(Calendar.SECOND));
         datetime[2] = g.valueOf(calendar.get(Calendar.DAY_OF_MONTH)).concat(" ");
         datetime[1] = g.valueOf(calendar.get(Calendar.MONTH)+1).concat("-");
         datetime[0] = g.valueOf(calendar.get(Calendar.YEAR)).concat("-");

         for(int index = 0;index < datetime.length;index++){

            date = date.concat(datetime[index]);

        }
         
         return date;

    
        
    }

}
