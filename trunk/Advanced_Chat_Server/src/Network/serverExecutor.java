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
    
    
    
    public void sendMess(Object mess) throws InterruptedException{
        
        Vector received;
        Vector receiver;
        Vector participants;
        int count = 0;
                
        received = (Vector) mess;
        participants = (Vector) received.get(2);
        
        while(count < participants.size()){
            
            if(!received.get(0).toString().equals(participants.get(count))){
                receiver = logClient.get(participants.get(count));        
                receiver.add(received);
                gv.enqueueEvent("L'utente "+received.get(0).toString()+" ha inviato un messaggio/file a "+participants.get(count).toString());
            }
            count++;
        }
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
        
        query = con.prepareStatement("SELECT Level FROM `Level` WHERE IdUser= ? ");
        query.setInt(1,IdUser);
        rs = query.executeQuery();
    
        rs.next();
        level = rs.getInt("Level");
        
        if(level==1){
            addToBlackList(IdUser);
            
        }
        else{
        //abassare il livello
            query = con.prepareStatement("UPDATE `AdvancedChat`.`Level` SET `Level` = Level - 1 WHERE `Level`.`IdUser` = ? ");
            query.setInt(1,IdUser);
            query.execute();
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
        
        query= con.prepareStatement("INSERT INTO `AdvancedChat`.`BlackList` (Email) VALUES (?)");
        query.setString(1, Email);
        query.executeQuery();
        
    }
      
    
  
////            packet = new Packet(6,list);
////            this.out.writeObject(packet);
//            }
////
//        catch(IOException ex){
////
////            packet = new Packet(666, "\nCi sono dei problemi tecnici. Riprova tra qualche minuto.\n");
////            this.out.writeObject(packet);
//           }
//        catch(SQLException ex){
//
//            packet = new Packet(666,"\nCi sono dei problemi tecnici. Riprova tra qualche minuto.\n");
//            this.out.writeObject(packet);
//        }
//    }
    
    
    private Hashtable<String,Vector> logClient;
    private generalView gv;
}
