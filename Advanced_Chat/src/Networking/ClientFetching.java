
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Networking;

import GUI.Home;
import General.Packet;
import User.User;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author enrico
 */
public class ClientFetching extends Thread{

    Requests connection;
    private ChatSession newSession;
    private Home thehome;

    public ClientFetching(Requests connection,Home thehome,ChatSession newSession){

        this.connection = connection;
        this.thehome = thehome;
        this.newSession = newSession;
    }


    public void run(){

        try{

            fetch();
        }
        catch(IOException ex){

            JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
        }
        catch(ClassNotFoundException ex){

            JOptionPane.showMessageDialog(null,"Problemi tecnici. Ci scusiamo per l'inconveniente." , "ACES", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void fetch() throws IOException, ClassNotFoundException{

        Packet response;
        
        while(true){
            
                response = (Packet) connection.getIn().readObject();
            
                switch(response.getHeader()){

                    case 1: this.newSession.messaging((Vector)response.getPayload()); break;
                    case 6: this.thehome.setContactList((Vector) response.getPayload()); break;
                    case 7: this.thehome.setUser((User) response.getPayload()); break;
                    case 666: JOptionPane.showMessageDialog(null, response.getPayload().toString(), "ACES", JOptionPane.ERROR_MESSAGE); break;
                    case 8: this.thehome.setInfo((User)response.getPayload());break;
                    case 9: this.thehome.setStatistic((Vector)response.getPayload());break;
                }

            

        }

        }

}
