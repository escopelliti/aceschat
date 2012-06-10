/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package XML;

import fileManager.fileOperation;
import General.DateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author enrico
 */
public class XML {

        /*metodo che crea il file XML con il filepath all'apertura della conversazione con solo root*/
        public void genXml(String filepath) throws FileNotFoundException, IOException{

            if(!fileOperation.exist(filepath)){
                FileOutputStream file = new FileOutputStream(filepath);
                Element root = new Element("conversazione");                
                Document document = new Document(root);
                XMLOutputter outputter = new XMLOutputter();
        try {
            outputter.setFormat(Format.getPrettyFormat());
            outputter.output(document,file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
        }
   



    //metodo per scrivere il file di configurazione per connettersi al server
    public void writeXml(String filepath,String ip,String porta) throws IOException{

        
        Element root = new Element("server");
        Document document = new Document(root);

        Element first = new Element("ip");
        Element second = new Element("porta");
        first.addContent(ip);
        second.addContent(porta);
        root.addContent(first);
        root.addContent(second);

        XMLOutputter outputter = new XMLOutputter();
        try {           
            outputter.setFormat(Format.getPrettyFormat());          
            outputter.output(document, new FileOutputStream(filepath));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }


         }




    //metodo per creare il file con le credenziali; è creato al momento della registrazione in qualsiasi caso;
    public void writeXml(String filepath,String username,String password,String remember) throws IOException{

        Element root = new Element("credenziali");
        Document document = new Document(root);

        Element first = new Element("username");
        Element second = new Element("password");
        Element fourth = new Element("ricordami");
        first.addContent(username);
        second.addContent(password);
        fourth.addContent(remember);
        root.addContent(first);
        root.addContent(second);
        root.addContent(fourth);

        XMLOutputter outputter = new XMLOutputter();
        try {
            outputter.setFormat(Format.getPrettyFormat());
            outputter.output(document, new FileOutputStream(filepath));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    //permette di modificare il file XML in particolare quello che riguarda le conversazioni;aggiungie via via i messaggi dai vari client
    public Document modifyXml(String username,String text,Document doc){
        
                if(doc != null) {
                    Element root = doc.getRootElement();
                    Element s = new Element(username);
                    s = s.setAttribute("DataOra",DateTime.getDateTime());
                    s.addContent(text);
                    root.addContent(s);
        }

            return doc;
    }

    //vera e propria creazione/modifica del file;
    public void write(Document doc,String filepath) throws IOException{

            XMLOutputter outputter = new XMLOutputter();
            BufferedWriter out = null;
            out = new BufferedWriter(new FileWriter(filepath));
            outputter.setFormat(Format.getPrettyFormat());
            outputter.output(doc,out);


    }


    public Document getDocument(String filepath){

            File file = new File(filepath);
            SAXBuilder saxbuilder = new SAXBuilder();
            Document doc = null;
            try {
                doc = saxbuilder.build(file);
                } catch (Exception ex) {
                System.out.println("Error: "+ex);
                }

            return doc;
    }


    public ArrayList readXml(String filepath){

        ArrayList list = new ArrayList();
        Document doc = getDocument(filepath);
        Element root = doc.getRootElement();       
        String x = root.getAttributeValue("ID");
            if(x != null)
                list.add(x);
        List elements = root.getChildren();
        Iterator it = elements.iterator();              

        while(it.hasNext()){
         
            Element tag = (Element) it.next();
            list.add(tag.getName());
            String y = tag.getAttributeValue("DataOra");
                if(y != null)
                    list.add(y);
            list.add(tag.getText());

                }

        return list;
        }

        

    }


