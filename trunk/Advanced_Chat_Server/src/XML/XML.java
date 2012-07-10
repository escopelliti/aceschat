package XML;

import Database.databaseQueries;
import Database.dumpQueries;
import General.DateTime;
import java.io.*;
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
        this.dateTime = DateTime.getDateTime();
        
        }
    
    //metodo che avvia la routine di dump del DB
    public void dumpDB() throws SQLException, IOException{
             
        dumpAbuse();
        dumpActivation();
        dumpBlackList();
        dumpChat();
        dumpConversation();
        dumpFile();
        dumpFriend();
        dumpInterest();
        dumpLevel();
        dumpLevelDescription();
        dumpLogin();
        dumpOffense();
        dumpUser();
        dumpPerson();
        dumpStatus();
        dumpStatusDescription();
    }
    
    
    //i metodi successivi richiedono le informazione al db e creano il file XML tabella per tabella
    private void dumpUser() throws SQLException, IOException{
        
        ArrayList userTable;
        Integer index = 0;
        String arg= "User";
        Element root;
        
        userTable = dump.dumpTable(arg);
        
        root = new Element("dump");
        root = root.setAttribute("DataOra",this.dateTime);
    
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
    
        createDumpFile(root,arg); 
      
    }

    
    private void dumpPerson() throws SQLException, IOException {
        ArrayList personTable;
        Integer index = 0;
        String arg= "Person";
        Element root;
        personTable = dump.dumpTable(arg);
        
        root = new Element("dump");
        root = root.setAttribute("DataOra",this.dateTime);
    
        while(index < personTable.size()){
                        
            Element name = new Element("name");
            Element surname = new Element("surname");
            Element birthday = new Element("birthday");
            Element city = new Element("city");
            Element nation = new Element("nation");
            Element sex = new Element("sex");
            Element job = new Element("job");
            
            Element person = new Element("person");
            
            name.addContent(personTable.get(index + 1).toString());
            surname.addContent(personTable.get(index + 2).toString());
            birthday.addContent(personTable.get(index + 3).toString());
            city.addContent(personTable.get(index + 4).toString());
            nation.addContent(personTable.get(index + 5).toString());
            sex.addContent(personTable.get(index + 6).toString());
            job.addContent(personTable.get(index + 7).toString());
                        
            person = person.setAttribute("id",personTable.get(index).toString());
            
            person.addContent(name);
            person.addContent(surname);
            person.addContent(birthday);
            person.addContent(city);
            person.addContent(nation);
            person.addContent(sex);
            person.addContent(job);
            
            root.addContent(person);
            
            index = index + 8;
        }
        createDumpFile(root,arg);
    
    }
     
     private void dumpActivation() throws SQLException, IOException{
         ArrayList activationTable;
         Integer index = 0;
         String arg= "Activation";
         Element root;
         activationTable = dump.dumpTable(arg);
        
         root = new Element("dump");
         root = root.setAttribute("DataOra",this.dateTime);
        
         while(index < activationTable.size()){
             Element registrationTime = new Element("registrationTime");
             Element activationStatus  = new Element("activationStatus");
             Element user = new Element("user");
             
             registrationTime.addContent(activationTable.get(index + 1).toString());
             activationStatus.addContent(activationTable.get(index + 2).toString());
         
             user = user.setAttribute("id",activationTable.get(index).toString());
             
             user.addContent(registrationTime);
             user.addContent(activationStatus);
             
             root.addContent(user);
             index = index + 3;
         }
         createDumpFile(root,arg);

    }
    
     private void dumpBlackList() throws SQLException, IOException{
         ArrayList blackListTable;
         Integer index = 0;
         String arg= "BlackList";
         Element root;
         blackListTable = dump.dumpTable(arg);
        
         root = new Element("dump");
         root = root.setAttribute("DataOra",this.dateTime);
        
         while(index < blackListTable.size()){
             Element dateTime = new Element("dateTime");
             Element user  = new Element("user");
             
             dateTime.addContent(blackListTable.get(index + 1).toString());
             
             user = user.setAttribute("email",blackListTable.get(index).toString());
             user.addContent(dateTime);
             root.addContent(user);
             index = index + 2;
         }
         createDumpFile(root,arg);
     }
          
     private void dumpLogin() throws SQLException, IOException{
         ArrayList loginTable;
         Integer index = 0;
         String arg= "Login";
         Element root;
         loginTable = dump.dumpTable(arg);
        
         root = new Element("dump");
         root = root.setAttribute("DataOra",this.dateTime);
        
         while(index < loginTable.size()){
             Element ip = new Element("ip");
             Element datetime = new Element("dateTime");
             Element user = new Element("user");
             
             ip.addContent(loginTable.get(index + 1).toString());
             datetime.addContent(loginTable.get(index + 2).toString());
         
             user = user.setAttribute("id",loginTable.get(index).toString());
             
             user.addContent(ip);
             user.addContent(datetime);
             
             root.addContent(user);
             index = index + 3;
         }
         createDumpFile(root,arg);

    }
     
      private void dumpAbuse() throws SQLException, IOException{
          ArrayList abuseTable;
          Integer index = 0;
          String arg= "Abuse";
          Element root;
          abuseTable = dump.dumpTable(arg);
        
          root = new Element("dump");
          root = root.setAttribute("DataOra",this.dateTime);
        
          while(index < abuseTable.size()){
              Element description = new Element("description");
              Element user  = new Element("user");
            
              description.addContent(abuseTable.get(index + 1).toString());
             
              user = user.setAttribute("id",abuseTable.get(index).toString());
              user.addContent(description);
              root.addContent(user);
              index = index + 2;
           }
           createDumpFile(root,arg);
     
      }
     
      private void dumpChat() throws SQLException, IOException{
          ArrayList chatTable;
          Integer index = 0;
          String arg= "Chat";
          Element root;
          chatTable = dump.dumpTable(arg);
        
          root = new Element("dump");
          root = root.setAttribute("DataOra",this.dateTime);
        
          while(index < chatTable.size()){
              Element idUser = new Element("idUser");
              Element text  = new Element("text");
              Element history  = new Element("history");
              Element idfile  = new Element("idFile");
              Element datetime = new Element("datetime");
              Element mess = new Element("mess");
             
              idUser.addContent(chatTable.get(index + 1).toString());
              text.addContent(chatTable.get(index + 2).toString());
              history.addContent(chatTable.get(index + 3).toString());
              idfile.addContent(chatTable.get(index + 4).toString());
              datetime.addContent(chatTable.get(index + 5).toString());
             
              mess = mess.setAttribute("idMes",chatTable.get(index).toString());
              mess.addContent(idUser);
              mess.addContent(text);
              mess.addContent(history);
              mess.addContent(idfile);
              mess.addContent(datetime);
             
              root.addContent(mess);
              index = index + 6;
          }
          createDumpFile(root,arg);
      
      }
     
      
      private void dumpConversation() throws SQLException, IOException{
          ArrayList conversationTable;
          Integer index = 0;
          String arg= "Conversation";
          Element root;
          conversationTable = dump.dumpTable(arg);
          root = new Element("dump");
          root = root.setAttribute("DataOra",this.dateTime);
        
          while(index < conversationTable.size()){
              Element idSorg = new Element("idSorg");
              Element idDest  = new Element("idDest");
              Element mess = new Element("mess");
             
              idSorg.addContent(conversationTable.get(index + 1).toString());
              idDest.addContent(conversationTable.get(index + 2).toString());
                         
              mess = mess.setAttribute("idMes",conversationTable.get(index).toString());
              mess.addContent(idSorg);
              mess.addContent(idDest);
                         
              root.addContent(mess);
              index = index + 3;
             
              }
          createDumpFile(root,arg);
      
      }
      
       private void dumpFile() throws SQLException, IOException{
           ArrayList fileTable;
           Integer index = 0;
           String arg= "File";
           Element root;
           fileTable = dump.dumpTable(arg);
        
           root = new Element("dump");
           root = root.setAttribute("DataOra",this.dateTime);
        
           while(index < fileTable.size()){
               Element description = new Element("description");
               Element file  = new Element("file");
             
               description.addContent(fileTable.get(index + 1).toString());
             
               file = file.setAttribute("idFile",fileTable.get(index).toString());
               file.addContent(description);
               root.addContent(file);
               index = index + 2;
           }
           createDumpFile(root,arg);
     
       }
       
       private void dumpFriend() throws SQLException, IOException{
           ArrayList friendTable;
           Integer index = 0;
           String arg= "Friend";
           Element root;
        
           friendTable = dump.dumpTable(0);
                
           root = new Element("dump");
           root = root.setAttribute("DataOra",this.dateTime);

           while(index < friendTable.size()){
               Element user = new Element("user");
             
               user = user.setAttribute("idUser",friendTable.get(index).toString());
                          
               Element userFriend = new Element("idFriend");
               Element datetime = new Element("datetime");
                 
               userFriend.addContent(friendTable.get(index + 1).toString());
               datetime.addContent(friendTable.get(index + 2).toString());
                
               user.addContent(userFriend);
               user.addContent(datetime);
               root.addContent(user);
               index = index + 3;
           }
           createDumpFile(root,arg);
       }
        
       private void dumpInterest() throws SQLException, IOException{
           ArrayList interestTable;
           Integer index = 0;
           String arg= "Interest";
           Element root;
        
           interestTable = dump.dumpTable(1);
        
           root = new Element("dump");
           root = root.setAttribute("DataOra",this.dateTime);

           while(index < interestTable.size()){
               Element description = new Element("description");
               Element user  = new Element("user");
             
               description.addContent(interestTable.get(index+1).toString());
             
               user = user.setAttribute("idUser",interestTable.get(index).toString());
               user.addContent(description);
               root.addContent(user);
               index = index + 2;
           }
           createDumpFile(root,arg);

       }
        
       private void dumpLevel() throws IOException, SQLException {
           ArrayList levelTable;
           Integer index = 0;
           String arg= "Level";
           Element root;
        
           levelTable = dump.dumpTable(0);
                
           root = new Element("dump");
           root = root.setAttribute("DataOra",this.dateTime);

           while(index < levelTable.size()){
               Element user = new Element("user");
               user = user.setAttribute("idUser",levelTable.get(index).toString());           
               Element level = new Element("level");
               Element datetime = new Element("datetime");
                 
               level.addContent(levelTable.get(index + 1).toString());
               datetime.addContent(levelTable.get(index + 2).toString());
                
               user.addContent(level);
               user.addContent(datetime);
               root.addContent(user);
               index = index + 3;
          }
          createDumpFile(root,arg);
    }
      
      private void dumpLevelDescription() throws SQLException, IOException{
          ArrayList levelDescriptionTable;
          Integer index = 0;
          String arg= "LevelDescription";
          Element root;
          levelDescriptionTable = dump.dumpTable(2);
        
          root = new Element("dump");
          root = root.setAttribute("DataOra",this.dateTime);
        
          while(index < levelDescriptionTable.size()){
              Element description = new Element("description");
              Element level  = new Element("level");
             
              description.addContent(levelDescriptionTable.get(index + 1).toString());
             
              level = level.setAttribute("idFile",levelDescriptionTable.get(index).toString());
              level.addContent(description);
              root.addContent(level);
              index = index + 2;
          }
          createDumpFile(root,arg);
      }
      
      private void dumpOffense() throws IOException, SQLException{
          ArrayList userTable;
          Integer index = 0;
          String arg= "Offense";
          Element root;
        
          userTable = dump.dumpTable(arg);
        
          root = new Element("dump");
          root = root.setAttribute("DataOra",this.dateTime);
    
          while(index < userTable.size()){
              Element useroffending = new Element("idOffendin");
              Element usersender = new Element("idSender");
              Element datetime = new Element("datetime");
              Element abuse = new Element("abuse");
            
              useroffending.addContent(userTable.get(index + 1).toString());
              usersender.addContent(userTable.get(index + 2).toString());
              datetime.addContent(userTable.get(index + 3).toString());
                       
              abuse = abuse.setAttribute("idAbuse",userTable.get(index).toString());
            
              abuse.addContent(useroffending);
              abuse.addContent(usersender);
              abuse.addContent(datetime);
                       
              root.addContent(abuse);
            
              index = index + 4;
          }
          createDumpFile(root,arg); 
      
    }
      
      private void dumpStatus() throws SQLException, IOException{
          ArrayList statusTable;
          Integer index = 0;
          String arg= "Status";
          Element root;
        
          statusTable = dump.dumpTable(arg);
        
          root = new Element("dump");
          root = root.setAttribute("DataOra",this.dateTime);
    
          while(index < statusTable.size()){
              Element user = new Element("user");
              Element datetime = new Element("datetime");
              Element idStatus = new Element("idStatus");
            
              datetime.addContent(statusTable.get(index + 1).toString());
              idStatus.addContent(statusTable.get(index + 2).toString());
            
              user.setAttribute("idUser",statusTable.get(index).toString());
              user.addContent(datetime);
              user.addContent(idStatus);
            
              root.addContent(user);
              index = index + 3;
          }
          createDumpFile(root,arg);
      }
      
      
      private void dumpStatusDescription() throws SQLException, IOException{
          ArrayList statusDescriptionTable;
          Integer index = 0;
          String arg= "StatusDescription";
          Element root;
          statusDescriptionTable = dump.dumpTable(3);
        
          root = new Element("dump");
          root = root.setAttribute("DataOra",this.dateTime);
        
          while(index < statusDescriptionTable.size()){
              Element description = new Element("description");
              Element status  = new Element("status");
              
              description.addContent(statusDescriptionTable.get(index + 1).toString());
             
              status = status.setAttribute("idFile",statusDescriptionTable.get(index).toString());
              status.addContent(description);
              root.addContent(status);
              index = index + 2;
          }
          createDumpFile(root,arg);
     
      }
      
      private void createDumpFile(Element root, String title) throws IOException{
          Document document = new Document(root);        
          XMLOutputter outputter = new XMLOutputter();
          try{
              outputter.setFormat(Format.getPrettyFormat());
              outputter.output(document, new FileOutputStream(title+".xml"));
          }catch (FileNotFoundException ex) {
              JOptionPane.showMessageDialog(null,"Problemi nel dump:\n"+ex , "ACES - Server", JOptionPane.ERROR_MESSAGE);
          }
         
      }
    
      private String dateTime;
      private dumpQueries dump;

    
}



