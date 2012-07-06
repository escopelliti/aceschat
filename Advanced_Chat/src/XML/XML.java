package XML;

import fileManager.fileOperation;
import General.DateTime;
import org.jdom.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/*Classe che gestisce scrittura e lettura di file XML per la cronologia*/
public class XML {

    /*metodo che crea un file XML tramite filepath all'apertura di una conversazione con solo l'elemento root*/
    public void genXml(String filepath) throws FileNotFoundException, IOException{

        if(!fileOperation.exist(filepath)){
            FileOutputStream file = new FileOutputStream(filepath);
            Element root = new Element("conversazione");                
            Document document = new Document(root);
            XMLOutputter outputter = new XMLOutputter();
        try{
            outputter.setFormat(Format.getPrettyFormat());
            outputter.output(document,file);
        }catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
        }
        }
    }
   
    //Scriviamo il file di configurazione per la connessione al server
    public void writeXml(String filepath,String ip,String porta) throws IOException{
  
        Document document;
        Element root,first,second;
        root = new Element("server");
        first = new Element("ip");
        second = new Element("porta");
        document = new Document(root);
        first.addContent(ip);
        second.addContent(porta);
        root.addContent(first);
        root.addContent(second);

        XMLOutputter outputter = new XMLOutputter();
        try{           
            outputter.setFormat(Format.getPrettyFormat());          
            outputter.output(document, new FileOutputStream(filepath));
        }catch (FileNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
        }
}

    //metodo per creare il file con le credenziali dell'utente; è creato al momento della registrazione;
    public void writeXml(String filepath,String username,String password,String remember) throws IOException{

        Element root,first,second,third;
        root = new Element("credenziali");
        first = new Element("username");      
        second = new Element("password");
        third = new Element("ricordami");
        
        first.addContent(username);
        second.addContent(password);
        third.addContent(remember);
        root.addContent(first);
        root.addContent(second);
        root.addContent(third);
        Document document = new Document(root);
        
        XMLOutputter outputter = new XMLOutputter();
        try{
            outputter.setFormat(Format.getPrettyFormat());
            outputter.output(document, new FileOutputStream(filepath));
        }catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    //permette di modificare il file XML in particolare le conversazioni;
    public Document modifyXml(String username,String text,Document doc){
        
        if(doc != null){
            Element root,s;
            root = doc.getRootElement();
            s = new Element(username);
            s = s.setAttribute("DataOra",DateTime.getDateTime());
            s.addContent(text);
            root.addContent(s);
        }

        return doc;
    }

    //vera e propria creazione/modifica del file;come argomento ha bisogno del Document relativo al file da scrivere
    public void write(Document doc,String filepath) throws IOException{

        XMLOutputter outputter;
        BufferedWriter out;
        
        out = null;
        outputter = new XMLOutputter();
        out = new BufferedWriter(new FileWriter(filepath));
        outputter.setFormat(Format.getPrettyFormat());
        outputter.output(doc,out);
    }

    //Ritorna il Document dato il file;
    public Document getDocument(String filepath){

        File file;
        SAXBuilder saxbuilder;
        Document doc;
        
        saxbuilder = new SAXBuilder();
        doc = null;
        file = new File(filepath);
        try{
            doc = saxbuilder.build(file);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
        }

        return doc;
    }

    //Lettura del file XML
    public ArrayList readXml(String filepath){

        Document doc;
        Element root;
        ArrayList list;
        List elements;
        Iterator it;
        
        list = new ArrayList();
        doc = getDocument(filepath);       
        root = doc.getRootElement();
        elements = root.getChildren();
        it = elements.iterator();              

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


