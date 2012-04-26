/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import General.Packet;
import java.io.IOException;
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
    
    
    private Hashtable<String,Vector> logClient;
}
