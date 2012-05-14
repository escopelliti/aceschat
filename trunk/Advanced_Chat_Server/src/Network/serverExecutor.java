/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import Database.Database;
import General.Packet;
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
    
    
    public serverExecutor(){
        
        this.logClient = new Hashtable<String, Vector>();
        
    }
    
    
    
    public void sendMess(Object mess){
        
        Vector v;
        Vector receiver;
                
        v = (Vector) mess;
        receiver = logClient.get(v.get(2).toString());        
        receiver.add(v);
      
    }
    
    
    public Vector getVector(String username){
        
        return this.logClient.get(username);
    }
    
    
    public void addMe(Vector toAdd, String username){
        
        this.logClient.put(username, toAdd);
 
    }
    
    
    public String sendMail(Object payload) throws IOException{

        Vector vect;
        Mail toSend;
        Packet response;
        String comunication;

        vect = (Vector) payload;
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
    
    private Hashtable<String,Vector> logClient;
}
