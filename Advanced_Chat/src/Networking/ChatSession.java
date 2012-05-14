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
        flag = isThere(mess.get(0).toString());
        
        if(!flag){
            

            Message conv;
            conv = new Message(this.user,mess.get(0).toString(),this.toCon);
            conv.setVisible(true);
            convList.put(mess.get(0).toString(), conv);
            
            if(load.getClass().getName().equals("java.lang.String")){
                
                conv.append(mess.get(1).toString());//se non è una stringa facciamo visualizzare la finestra con la comunicazione che è un file
                conv.writingFile(mess.get(0).toString(),mess.get(1).toString(), mess.get(0).toString());
            }
            else{
                
                conv.append("Hai ricevuto un file da "+mess.get(0).toString()+".");
                fo = new fileOperation();
                fo.writeFile((File) load);
            }
        }

        else{

            Message conv = convList.get(mess.get(0));
            if(load.getClass().getName().equals("java.lang.String")){
                conv.append(mess.get(1).toString());
                conv.writingFile(mess.get(0).toString(),mess.get(1).toString(), mess.get(0).toString());
            }
            else{
                
                conv.append("Hai ricevuto un file da "+mess.get(0).toString()+".");
                fo = new fileOperation();
                fo.writeFile((File) load);
            }
        }



    }
    
    
    public void start(String username) throws IOException{
        
        Message conversation;
        
        conversation = new Message(this.user,username,this.toCon);
        conversation.setVisible(true);
 
        setConvList(username, conversation);
        
    }


    private void setConvList(String username, Message conversation){

        convList.put(username, conversation);
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
