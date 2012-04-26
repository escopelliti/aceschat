/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package XML;
import General.DateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.*;
import java.io.*;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author enrico
 */
public class createXml {

        public boolean exist(String file){

            File check = new File(file);

            boolean value = check.exists();


            return value;

        }



   



    //con questo scriviamo sia il file xml di configurazione dei parametri del server e sia le credenziali dell utente
    public static void writeXml(String filepath,String _root,String f_tag,String f_tagContent,String s_tag,String s_tagContent) throws IOException{

        
        Element root = new Element(_root);
        Document document = new Document(root);

        Element first = new Element(f_tag);
        Element second = new Element(s_tag);
        first.addContent(f_tagContent);
        second.addContent(s_tagContent);
        root.addContent(first);
        root.addContent(second);

        XMLOutputter outputter = new XMLOutputter();
        try {           
            outputter.setFormat(Format.getPrettyFormat());          
            outputter.output(document, new FileOutputStream(filepath));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(createXml.class.getName()).log(Level.SEVERE, null, ex);
        }


         }


    public static void writeXml(String file,String username,String text,int[] datetime) throws IOException{


        FileWriter s = new FileWriter(file,true);
        XMLOutputter outputter = new XMLOutputter();

        Element root = new Element("Conversazione");
        Document document = new Document(root);

        Element user = new Element(username);
        Element message = new Element("text");
        message.addContent(text);
        String value = datetime.toString();
        message = message.setAttribute("data-ora",value);

        user.addContent(message);
        root.addContent(user);

        try {
            outputter.setFormat(Format.getPrettyFormat());

            outputter.output(document,s);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(createXml.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        s.close();
    }





}

