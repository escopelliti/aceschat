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

        return email.matches("^[_.0-9a-z-]+@([0-9a-z][0-9a-z-]+.)+[a-z]{2,3}$");
    }



}
