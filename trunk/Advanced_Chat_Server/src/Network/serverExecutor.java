/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import Database.Database;
import General.generalView;
import java.sql.Connection;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Vector;

/**
 *
 * @author enrico
 */
public class serverExecutor {
    
    
    public serverExecutor(generalView gv){
        
        this.logClient = new Hashtable<String, Vector>();
        this.gv = gv;
    }
    
    
    
    //object mess è composto da tre campi 0)l'username del sorgente 1)file o messaggio di testo 2)vettore di partecipanti(min=2 elem-max?) 
    public void sendMess(Object mess) throws InterruptedException, SQLException{
        
        Vector received;
        Vector receiver;
        Vector participants;
        int count = 0;
        Object message;        
        received = (Vector) mess;
        participants = (Vector) received.get(2);
        message = received.get(1);
        
        while(count < participants.size()){
            
            if(!received.get(0).toString().equals(participants.get(count))){
                receiver = logClient.get(participants.get(count));        
                receiver.add(received);
                
                //controlla se tipo di file che è del vector recived campo 1 è una stringa
                if(message.getClass().getName().equals("java.lang.String")){
                    //trattalo come stringa per aggiungere al db
                    addMessToDb(received.get(0).toString(),received.get(1).toString(),participants);
                    
                    
                }
                else{
                    //E' un file da aggiungere al db
                    addFileToDb(received.get(0).toString(),participants);
                
                
                }
                    
                    
                gv.enqueueEvent("L'utente "+received.get(0).toString()+" ha inviato un messaggio/file a "+participants.get(count).toString());
            }
            count++;
        }
    }
    //nuovi metodi implementati
    private void addMessToDb(String sender, String text, Vector participants) throws SQLException{
        Connection con = Database.getCon();
        PreparedStatement query;
        ResultSet rs;        
        int idSender,idMess,i;
        Integer idDest;
        
        
        query=con.prepareStatement("SELECT IdUser FROM User WHERE username = ?");
        query.setString(1,sender);
        rs=query.executeQuery();
        rs.next();
        idSender=rs.getInt("IdUser");
        
        query = con.prepareStatement("INSERT INTO `AdvancedChat`.`Chat` (IdSorg,Text) VALUES (?,?)",1);
        query.setInt(1,idSender);
        query.setString(2,text);
        query.execute();
        rs=query.getGeneratedKeys();
        rs.next();
        idMess=rs.getInt(1);
                
        for(i=0;i<=participants.size();i++){
           
            idDest=(Integer) participants.get(i);
            
            if(idDest!= idSender){
            query=con.prepareStatement("INSERT INTO `AdvancedChat`.`Conversation` () VALUES (?,?,?)");
            query.setInt(1, idSender);
            query.setInt(2, idDest);
            query.setInt(3, idMess);
            query.execute();
            }
        }
    }
    
    private void addFileToDb(String sender, Vector participants) throws SQLException{
        
        Connection con = Database.getCon();
        PreparedStatement query;
        ResultSet rs;        
        int idSender;
        
        //li dobbiamo mettere nel DB????????????????
        String path = "Path Of File ";       //da costruire 
        String description = "Size Of File :  ";//da definire
        
        query=con.prepareStatement("SELECT IdUser FROM User WHERE username = ?");
        query.setString(1,sender);
        rs=query.executeQuery();
        rs.next();
        idSender=rs.getInt("IdUser");
        
        query=con.prepareStatement("INSERT INTO `AdvancedChat`.`File`(`Path`,`Description`) VALUE (?,?)");
        query.setString(1,path);
        query.setString(2,description);
        rs=query.executeQuery();
        
    }
    
    public Vector getVector(String username){
        
        return this.logClient.get(username);
    }
    
    
    public void addMe(Vector toAdd, String username){
        
        this.logClient.put(username, toAdd);
    }
    
    
    public String sendMail(Vector vect) throws IOException{
        
        Mail toSend;
        String comunication;

        toSend = new Mail(vect.get(0).toString(), vect.get(1).toString());
        try{
            toSend.start();
            comunication = "Invito inviato con successo.";
        }
        catch(Exception ex){
            comunication = "Errore!!";
        }

        return comunication;
    }

    public void upWarning(int IdUser) throws SQLException{
        Connection con = Database.getCon();
        PreparedStatement query;
        ResultSet rs;
                     
        query = con.prepareStatement("UPDATE `AdvancedChat`.`User` SET `Warning` = Warning + 1 WHERE `User`.`IdUser` = ?");
        query.setInt(1,IdUser);
        query.execute();
    }
    
    public void downLevel(int IdUser) throws SQLException{
        
        Connection con = Database.getCon();
        PreparedStatement query;
        ResultSet rs;
        int level;
        
        try{
            query = con.prepareStatement("SELECT Level FROM `Level` WHERE IdUser= ? ");
            query.setInt(1,IdUser);
            rs = query.executeQuery();    
            rs.next();
            level = rs.getInt("Level");
        
            if(level==1)
                addToBlackList(IdUser);
            else{
        //abassare il livello
                query = con.prepareStatement("UPDATE `AdvancedChat`.`Level` SET `Level` = Level - 1 WHERE `Level`.`IdUser` = ? ");
                query.setInt(1,IdUser);
                query.execute();
            }
        }
        catch(SQLException ex){
            
            System.out.println(ex.getMessage());
        }
            
        
    }
    
    private void addToBlackList(int IdUser) throws SQLException{
        
        Connection con = Database.getCon();
        PreparedStatement query;
        ResultSet rs;
        String Email;
        query= con.prepareStatement("SELECT Email FROM `User` WHERE IdUser=?");
        query.setInt(1,IdUser);
        rs=query.executeQuery();
    
        rs.next();
        Email = rs.getString("Email");
        query = con.prepareStatement("INSERT INTO `AdvancedChat`.`BlackList` (Email) VALUES (?)");
        query.setString(1, Email);
        query.execute();
        
        
        
    }
      
    
    
    private Hashtable<String,Vector> logClient;
    private generalView gv;
}
