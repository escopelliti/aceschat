/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Networking;

import GUI.Message;
import User.User;
import fileManager.fileOperation;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author enrico
 */
public class ChatSession {


    public ChatSession(User user,Requests toCon){
        
        this.convList = new HashMap<String, Message>();
        this.user = user;
        this.toCon = toCon;
        
    }
    

    
    public void messaging(Vector mess) throws IOException{

        boolean flag;
        Object load;
        fileOperation fo;
        load = mess.get(1);
        Vector participants = (Vector) mess.get(2);
        String identifier = doID(participants);
        flag = isThere(identifier);
        
        if(!flag){
            

            Message conv;
            conv = new Message(this.user,participants,this.toCon);
            conv.setVisible(true);
            convList.put(identifier, conv);
            
            if(load.getClass().getName().equals("java.lang.String")){
                
                conv.append(load.toString());//se non è una stringa facciamo visualizzare la finestra con la comunicazione che è un file
                conv.writingFile(mess.get(0).toString(),load.toString(), mess.get(0).toString());
            }
            else{
                
                conv.append("Hai ricevuto un file da "+mess.get(0).toString()+".");
                fo = new fileOperation();
                fo.writeFile((File) load);
            }
        }

        else{

            Message conv = convList.get(identifier);
            if(load.getClass().getName().equals("java.lang.String")){
                conv.append(load.toString());
                conv.writingFile(mess.get(0).toString(),load.toString(),mess.get(0).toString());
            }
            else{
                
                conv.append("Hai ricevuto un file da "+mess.get(0).toString()+".");
                fo = new fileOperation();
                fo.writeFile((File) load);
            }
        }

    }
    
    
    public String doID(Vector vect){
        
        int count = 0;
        String identifier = "";
        
        while(count < vect.size()){
            
            identifier = identifier.concat((String) vect.get(count));
            count++;
        }
        
        return identifier;
        
    }
    
    
    
    public void start(Vector participants) throws IOException{
        
        Message conversation;
        
        conversation = new Message(this.user,participants,this.toCon);
        conversation.setVisible(true);
 
        setConvList(doID(participants), conversation);//IN SOSPESOOOO
        
    }


    
    
    private void setConvList(String identifier, Message conversation){

        convList.put(identifier, conversation);
    }

    
    
    private boolean isThere(String toCheck){

        if(convList.containsKey(toCheck))
            return true;
        else 
            return false;
    }


    
    
    private HashMap<String, Message> convList;
    private User user;
    private Requests toCon;
}
