package XML;

import Database.databaseQueries;
import Database.dumpQueries;
import General.DateTime;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;


public class XML {

    public XML(databaseQueries query){
        
        this.dump = new dumpQueries(query.getCon());
        this.root = new Element("dump");
        this.root = this.root.setAttribute("DataOra",DateTime.getDateTime());
    }
        
    public void dumpDB() throws SQLException, IOException{
       
       dumpUser();
        
        
    }
    
    private void dumpUser() throws SQLException, IOException{
        
        ArrayList userTable;
        Integer index = 0;
        
        userTable = dump.dumpUserTable();
        
        while(index < userTable.size()){
                        
            Element username = new Element("username");
            Element psw = new Element("password");
            Element email = new Element("email");
            Element warning = new Element("warning");
            Element user = new Element("user");
            
            username.addContent(userTable.get(index + 1).toString());
            psw.addContent(userTable.get(index + 2).toString());
            email.addContent(userTable.get(index + 3).toString());
            warning.addContent(userTable.get(index + 4).toString());
            user = user.setAttribute("id",userTable.get(index).toString());
            user.addContent(username);
            user.addContent(psw);
            user.addContent(email);
            user.addContent(warning);
            root.addContent(user);
            index = index + 5;
        }
        
        Document document = new Document(root);        
        XMLOutputter outputter = new XMLOutputter();
        try{
            outputter.setFormat(Format.getPrettyFormat());
            outputter.output(document, new FileOutputStream("userTable.xml"));
        }catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Problemi nel dump:\n"+ex , "ACES - Server", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    
    private dumpQueries dump;
    private Element root;
}



