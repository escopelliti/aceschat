
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Networking;

import GUI.Home;
import GUI.userDialog;
import General.Packet;
import User.User;
import java.io.IOException;
import java.util.Vector;

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

            new userDialog(ex.getMessage());
        }
        catch(ClassNotFoundException ex){

            new userDialog(ex.getMessage());
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
                    case 666: new userDialog(response.getPayload().toString()).setVisible(true); break;
                    case 8:/*METODO PER LA RICERCA GENERICA DI UN USER*/;break;
                }

            

        }

        }

}
