package General;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;


public class MD5 {



    public static String encode(String text) throws NoSuchAlgorithmException {

         String s = "";

         try {

             MessageDigest md;
             md = MessageDigest.getInstance("MD5");
             byte[] sha1hash = new byte[40];
             md.update(text.getBytes("iso-8859-1"), 0, text.length());
             sha1hash = md.digest();
             s = asHex(sha1hash);

         } catch (UnsupportedEncodingException ex) {
         } catch (NoSuchAlgorithmException ex) {
         }

         return s;
     }

    private static String asHex(byte[] buf) {

        Formatter formatter = new Formatter();
         for (byte b : buf)
             formatter.format("%02x", b);

         return formatter.toString();
 }
}

