/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Networking;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author enrico
 */
public class Mail {


    public static boolean checkMail(String email){

        Pattern x = Pattern.compile("[a-z]"+"@"+"[a-z]"+"."+"[a-z]");
        Matcher matcher = x.matcher(email);

        if(matcher.find()){
            //qui ci va il metodo del network che se va a buon fine(cioè la mail è unica e non è nella black list)
            //allora ritorniamo vero cioè possiamo completare la registrazione
            return true;
        }

        return false;



    }



}
